import axios from 'axios';
import "./UsingPage.css";
import EquipmentInfoRemoveUse from "../Components/EquipmentInfoRemoveUse";
import { LoginContext } from "../App";
import { useState, useEffect, useContext } from "react";
import { useNavigate } from 'react-router-dom';

// UsingPage allows user to view equipment they are currently using
const UsingPage = function(){
  const navigate = useNavigate();
  const cxt = useContext(LoginContext);
  const [dbData, setDBData] = useState([]);

  // UseEffect to route user back to login if user is not logged
  useEffect(() => {
    if(sessionStorage.getItem("isLoggedIn") != 1){
      navigate("/");
    }
  },[]) 

  // UseEffect to get equipment in use data if a change in the data has occurred
  useEffect(() => {
    async function getDBData() {
      await axios.get(`http://localhost:8080/usingEquipment`, 
        {params: {employeeId: sessionStorage.getItem("employeeId")}})
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
      <div className="usingequipmentinfo" style={{paddingTop: cxt.mapStatus ? "100px" : "" }}>
       {dbData.map((equipment) => (
          <EquipmentInfoRemoveUse 
            key={"using"+equipment.equipmentId}
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
      <div className='nousingequipmentinfo' style={{display: dbData.length == 0 ? "flex" : "none"}}>
        <h1>YOU HAVE NO EQUIPMENT IN USE CURRENTLY</h1>
      </div>
    </div>
  );
} 

export default UsingPage;