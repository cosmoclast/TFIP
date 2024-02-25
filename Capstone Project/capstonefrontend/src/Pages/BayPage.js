import axios from 'axios';
import "./BayPage.css";
import EquipmentInfoAddUse from '../Components/EquipmentInfoAddUse';
import { LoginContext } from "../App";
import { useState, useEffect, useContext } from "react";
import { useNavigate, useParams } from 'react-router-dom';

// BayPage allows user to view equipment at a particular departure bay
const BayPage = function(){
  const params = useParams();
  const navigate = useNavigate();
  const cxt = useContext(LoginContext);
  const [dbData, setDBData] = useState([]);

  // UseEffect to route user back to login if user is not logged
  useEffect(() => {
    if(sessionStorage.getItem("isLoggedIn") != 1){
      navigate("/");
    }
  },[])

  // UseEffect to get equipment location data if a change in the data has occurred
  useEffect(() => {
    async function getDBData() {
      await axios.get(`http://localhost:8080/locationEquipment`, 
        {params: {employeeId: sessionStorage.getItem("employeeId"),
                  bay: params.bay,}})
      .then((res) => {
        setDBData(res.data);
      }).catch((err) => {
        // console.log(err);
        alert("Server Is Currently Under Maintenance Or You Are Not Logged In");
      });
    }
    getDBData();    
  },[cxt.changeStatus]);

  return(
    <div>
      {/* Mapping to display equipment info */}
      <div className="bayequipmentinfo" style={{paddingTop: cxt.mapStatus ? "100px" : "" }}>
       {dbData.map((equipment) => (
          <EquipmentInfoAddUse 
            key={"bay"+equipment.equipmentId}
            equipmentID = {equipment.equipmentId}
            category = {equipment.category}
            name = {equipment.equipmentName}
            length = {equipment.eLength}
            width = {equipment.eWidth}
            height = {equipment.eHeight}
            aircraft = {equipment.aircraft}
            inUse = {equipment.inUse}
            hasDefects = {equipment.hasDefects}
            isFavourite = {equipment.isFavourite}
            location = {equipment.location.bay}
            employee = {equipment.employee == null ? {employeeId: ""} : equipment.employee}
            defects = {equipment.defectsList}
          /> 
        ))}
      </div>
      {/* Display message if no info to display */}
      <div className='nobayequipmentinfo' style={{display: dbData.length == 0 ? "flex" : "none"}}>
        <h1>NO EQUIPMENT AT {params.bay} OR NO SUCH BAY</h1>
      </div>      
    </div>
  );
} 

export default BayPage;