import axios from 'axios';
import "./MapNav.css";
import { GoogleMap, Marker, useLoadScript } from "@react-google-maps/api";
import { LoginContext } from "../App";
import { useContext, useState, useEffect, useMemo, useCallback } from "react";
import { Outlet, useNavigate, NavLink } from 'react-router-dom';

// MapNav is a map and navigation bar display that occurs on every page other than the log in page
const MapNav = function(){
  // useMemo hook has to be used otherwise the map is centered everytime a change occurs
  const center = useMemo(() => ({ lat: 1.35583, lng: 103.98797 }), []);
  const [dbData, setDBData] = useState([]);
  const navigate = useNavigate();
  const cxt = useContext(LoginContext);

  // UseEffect to route user back to login if user is not logged
  useEffect(() => {
    if(sessionStorage.getItem("isLoggedIn") != 1){
      navigate("/");
    }
  },[])

  // UseEffect to get all equipment data if a change in the data has occurred
  useEffect(() => {
    async function getDBData() {
      await axios.get(`http://localhost:8080/allEquipment`, 
        {params: {employeeId: sessionStorage.getItem("employeeId")}})
      .then((res) => {
        setDBData(res.data);
      }).catch((err)=>{
        // console.log(err);
      });
    }
    getDBData();            
  },[cxt.changeStatus]);
  
  // Uncomment the first line for development mode, this mode will not incur API costs
  // Uncomment the second and third line for production, 
  // put the API key as a string in the second line, put the port for React in the third line,
  // this will start incurring API costs if you exceeed the free credits per month.
  const { isLoaded } = useLoadScript({
    // googleMapsApiKey: process.env.REACT_APP_GOOGLE_API_KEY,
    googleMapsApiKey: 'AIzaSyBJNN4_p3ezAVuJBkIXwT_65IqUqOXwEd0',
    googleMapsClientId: "http://localhost:3000/"
  });

  // Handler to handle log out and redirecting to log in page
  const logoutHandler = () => {
    navigate("/");
    cxt.onLogOut();
  }

  // Handler to handle selection of a particular departure bay by the user
  const bayNavHandler = (bay) => {
    cxt.onAnyChange();
    navigate("/bay/"+bay);
  }

  // Function that processes equipment data and colours the departure bay marker
  // as red, yellow, blue or green depending on equipment status at that particular
  // departure bay. If all equipment at the bay is in use, marker is red. If there 
  // are at least 1 equipment not in use, it checks if it is a favourite, if it is,
  // marker is yellow, if it is not, it checks if the equipment is defective, if it is,
  // marker is blue, if it is not, the marker is green.
  const mapMarkerColour = useCallback((bay) => {
    let bayStatus = {}
    dbData.forEach(element => {
      if(bayStatus[element.location.bay] == undefined)
        bayStatus = {...bayStatus, [element.location.bay]: "red"};

      if(bayStatus[element.location.bay] == "red"){
        if(element.inUse == true){

        }else if(element.isFavourite == true){
          bayStatus = {...bayStatus, [element.location.bay]: "yellow"}
        }else if(element.hasDefects == true){
          bayStatus = {...bayStatus, [element.location.bay]: "blue"}
        }else{
          bayStatus = {...bayStatus, [element.location.bay]: "green"}
        }
      }else if(bayStatus[element.location.bay] == "green"){
        if(element.inUse == true){

        }else if(element.isFavourite == true){
          bayStatus = {...bayStatus, [element.location.bay]: "yellow"}
        }else if(element.hasDefects == true){
          bayStatus = {...bayStatus, [element.location.bay]: "blue"}
        }
      }else if(bayStatus[element.location.bay] == "blue"){
        if(element.inUse == true){

        }else if(element.isFavourite == true){
          bayStatus = {...bayStatus, [element.location.bay]: "yellow"}
        }
      }
    })
    let colour = bayStatus[bay];

    return (require(`../Images/${colour}marker.png`));
  })
  
  return(
    <div>
      {/* Inline style to toggle map to minimise or maximise */}
      <div className={`${cxt.mapStatus ? "togglemapbar" : ""}`}></div>
      <button className="togglemapbtn" onClick={cxt.onToggleMap}>Toggle Map</button>
      <div className="map-container" style={{display: cxt.mapStatus ? "none" : "" }}>
        {!isLoaded ? (<h1>Loading...</h1>) : (
          <GoogleMap mapContainerClassName="map" center={center} zoom={15}>
            {dbData.map(({equipmentId, location}) => (
              <Marker
                key={equipmentId}
                position={{lat:location.lat ,lng: location.lng}} // For defining the latitude and longitude of the marker
                icon={mapMarkerColour(location.bay)} // For selecting the correct coloured marker
                label = {location.bay} // For adding departure bay label to the marker
                onClick={()=>{bayNavHandler(location.bay)}} 
              />
            ))}
          </GoogleMap>
        )}      
      </div>
      {/* Navigation bar and navigation buttons and employee ID indication */}
      <div className="navbar" style={{top: cxt.mapStatus ? "60px" : "" }}>
        <div className="navbarbuttoncont">
          <NavLink className={(navData) => navData.isActive ? "navbaybtnactive" : "navbaybtn" } to="/bay">Bay</NavLink>
        </div>
        <div className="navbarbuttoncont">
          <NavLink className={(navData) => navData.isActive ? "navbarbtnactive" : "navbarbtn" } to="/search">Search</NavLink>
        </div>
        <div className="navbarbuttoncont">
          <NavLink className={(navData) => navData.isActive ? "navbarbtnactive" : "navbarbtn" } to="/using">Using</NavLink>
        </div>
        <div className="navbarbuttoncont" style={{display: sessionStorage.getItem("isSupervisor") != 1 ? "none" : "flex" }}>
          <NavLink className={(navData) => navData.isActive ? "navbarbtnactive" : "navbarbtn" } to="/add">Add</NavLink>
        </div>
        <div className="navbarbuttoncont">
          <NavLink className={(navData) => navData.isActive ? "navbarbtnactive" : "navbarbtn"} to="/" onClick={logoutHandler}>Log Out</NavLink>
        </div>
        <div className="empiddispcont">
          <div className="empiddisp">{sessionStorage.getItem("employeeId")}</div>
        </div>
      </div>
      <Outlet/>
    </div> 
  );
};

export default MapNav;