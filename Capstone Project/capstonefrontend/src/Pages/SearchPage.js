import axios from 'axios';
import "./SearchPage.css";
import EquipmentInfoAddUse from "../Components/EquipmentInfoAddUse";
import { LoginContext } from "../App";
import { useState, useEffect, useContext } from "react";
import { useNavigate } from 'react-router-dom';

// SearchPage allows user to view all equipment that is currently in the database
const SearchPage = function(){
  const navigate = useNavigate();
  const cxt = useContext(LoginContext);
  const [dbData, setDBData] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const [isFavourite, setIsFavourite] = useState("nofilter");
  const [inUse, setInUse] = useState("nofilter");
  const [hasDefects, setHasDefects] = useState("nofilter");
  const [category, setCategory] = useState("nofilter");

  // Handler to handler filtering of IsFavourite
  const isFavouriteHandler = function(event){
    setIsFavourite(event.target.value);
  }

  // Handler to handler filtering of inUse
  const inUseHandler = function(event){
    setInUse(event.target.value);
  }

  // Handler to handler filtering of hasDefects
  const hasDefectsHandler = function(event){
    setHasDefects(event.target.value);
  }

  // Handler to handler filtering of category
  const categoryHandler = function(event){
    setCategory(event.target.value);
  }

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
        setFilteredData(res.data);
      }).catch((err) => {
        // console.log(err);
        alert("Server Is Currently Under Maintenance Or You Are Not Logged In");
      });     
    }
    getDBData();   
  },[cxt.changeStatus]);

  // UseEffect to filter equipment data for display to users whenever data has changed or filtering selection changed
  useEffect(() => {     
    let temporaryData = dbData;
    const isFavouriteFilter = function(data){
      return data.filter((element)=>(element.isFavourite.toString() == isFavourite))
    }
    const inUseFilter = function(data){    
      return data.filter((element)=>(element.inUse.toString() == inUse))
    }
    const hasDefectsFilter = function(data){
      return data.filter((element)=>(element.hasDefects.toString() == hasDefects))
    }
    const categoryFilter = function(data){
      return data.filter((element)=>(element.category.toString() == category))
    }

    if(isFavourite != "nofilter")
      temporaryData = isFavouriteFilter(temporaryData);
    if(inUse != "nofilter")
      temporaryData = inUseFilter(temporaryData);
    if(hasDefects != "nofilter")
      temporaryData = hasDefectsFilter(temporaryData);
    if(category != "nofilter")
      temporaryData = categoryFilter(temporaryData);

    setFilteredData(temporaryData); 
  }, [isFavourite, inUse, hasDefects, category, dbData]);

  return(
    <div>
      {/* Dropdown list for filters */}
      <div className="filterbar" style={{top: cxt.mapStatus ? "100px" : "" }}>
        <div className="filterbarselect">
          <label><b>Is Favourite</b> <br></br>
            <select onChange={isFavouriteHandler} className="selectfilter" defaultValue="nofilter">
              <option value="nofilter">None</option>
              <option value="true">True</option>
              <option value="false">False</option>
            </select>
          </label>
        </div>
        <div className="filterbarselect">
        <label><b>In Use</b> <br></br>
            <select onChange={inUseHandler} className="selectfilter" defaultValue="nofilter">
              <option value="nofilter">None</option>
              <option value="true">True</option>
              <option value="false">False</option>
            </select>
          </label>
        </div>
        <div className="filterbarselect">
        <label><b>Has Defects</b> <br></br>
            <select onChange={hasDefectsHandler} className="selectfilter" defaultValue="nofilter">
              <option value="nofilter">None</option>
              <option value="true">True</option>
              <option value="false">False</option>
            </select>
          </label>
        </div>
        <div className="filterbarselect">
        <label><b>Category</b> &nbsp; <br></br>
            <select onChange={categoryHandler} className="selectfilter" defaultValue="nofilter">
              <option value="nofilter">None</option>
              <option value="Tow Tug">Tow Tug</option>
              <option value="Tow Bar">Tow Bar</option>
              <option value="Ground Power Unit">Ground Power Unit</option>
              <option value="Step">Step</option>
            </select>
          </label>
        </div>
      </div>

      {/* Mapping to display equipment info */}
      <div className="searchequipmentinfo" style={{paddingTop: cxt.mapStatus ? "150px" : "" }}>
       {filteredData.map((equipment) => (
          <EquipmentInfoAddUse 
            key={"search"+equipment.equipmentId}
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
      <div className='nofilteredequipmentinfo' style={{display: filteredData.length == 0 ? "flex" : "none"}}>
        <h1>NO FILTERED EQUIPMENT TO DISPLAY</h1>
      </div>      
    </div>
  );
};

export default SearchPage;

