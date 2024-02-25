import axios from 'axios';
import "./EquipmentInfo.css";
import LocationDropDown from "./LocationDropDown";
import { LoginContext } from '../App';
import { useContext, useState } from "react";

// EquipmentInfoAddUse is used in BayPage, SearchPage, EquipmentInfoRemoveUse is used in UsingPage
// EquipmentInfoAddUse allows user to select equipment to use but does not allow relinquishing equipment use
// EquipmentInfoRemoveUse allows user to select equipment to relinquish use but does not selecting of equipment to use
const EquipmentInfoAddUse = function(props){
  const [defectShowing, setDefectShowing] = useState(false);
  const cxt = useContext(LoginContext);

  // Handler to handle minimising and maximising of defect list
  const minMaxDefectsHandler = () => {
    setDefectShowing(!defectShowing);
  }

  // Handler to update database when user changed equipment to in use
  async function submitInUseHandler(event){
    event.preventDefault();
    await axios.put(`http://localhost:8080/inUseEquipment`, null,
      {params: {equipmentId: props.equipmentID,
                bay: event.target[0].value,
                employeeId: sessionStorage.getItem("employeeId")}})
    .then(() => {
      cxt.onAnyChange();
    }).catch((err) => {
      // console.log(err);
      alert("Server Is Currently Under Maintenance");
    });
  }

  // Handler to add to database when user added a new defect
  async function submitDefectHandler(event){
    event.preventDefault();
    await axios.post(`http://localhost:8080/newDefect`, null,
      {params: {equipmentId: props.equipmentID,
                description: event.target[0].value}})
    .then(() => {
      event.target[0].value = "";
      cxt.onAnyChange();
    }).catch((err) => {
      // console.log(err);
      alert("Server Is Currently Under Maintenance");
    });
  }

  // Handler to add to database when user favourited an equipment
  async function submitFavouriteHandler(event){
    event.preventDefault();
    await axios.post(`http://localhost:8080/addFavourites`, null,
      {params: {equipmentId: props.equipmentID,
                employeeId: sessionStorage.getItem("employeeId")}})
    .then(() => {
      event.target[0].checked = false;
      cxt.onAnyChange();
    }).catch((err) => {
      // console.log(err);
      alert("Server Is Currently Under Maintenance");
    }); 
  }

  // Handler to delete from database when user unfavourited an equipment
  async function submitUnfavouriteHandler(event){
    event.preventDefault();
    await axios.delete(`http://localhost:8080/deleteFavourites`,
      {params: {equipmentId: props.equipmentID,
                employeeId: sessionStorage.getItem("employeeId")}})
    .then(() => {
      event.target[0].checked = false;
      cxt.onAnyChange();
    }).catch((err) => {
      // console.log(err);
      alert("Server Is Currently Under Maintenance");
    }); 
  }

  return(
    <div className="equipmentinfo">
      {/* Listing of information obtained from database */}
      <div><b>EquipmentID:</b> {props.equipmentID}</div>
      <div><b>Category:</b> {props.category}</div>
      <div><b>Name:</b> {props.name}</div>
      <div><b>Dimension:</b> {`${parseFloat(props.length).toFixed(1)}L x ${parseFloat(props.width).toFixed(1)}W x ${parseFloat(props.height).toFixed(1)}H`}</div>
      <div><b>Aircraft:</b> {props.aircraft}</div>
      <div><b>Location:</b> {props.location}</div>
      <div><b>In Use:</b> {`${props.inUse}`} </div>
      <div><b>Employee ID:</b> {props.employee.employeeId}</div>

      {/* Inline styling to show/hide + or - button to expand or collapse defects list */}
      <div>
        <b>Has Defects:</b> {`${props.hasDefects}`}&nbsp; 
        <button className="minmaxdefectbtn" style={{display: defectShowing ? "none" : "" }} onClick={minMaxDefectsHandler}>+</button>
        <button className="minmaxdefectbtn" style={{display: defectShowing ? "" : "none" }} onClick={minMaxDefectsHandler}>-</button>
      </div>

      {/* List of defects for the equipment */}
      <div style={{display: defectShowing ? "" : "none" }}>
        {props.defects.map((defect, index)=>{
        return(
          <div key={defect.defectId}>{index+1}: {defect.description}</div>
        )
      })}
      </div>

      {/* Form for submitting of new defects */}
      <form onSubmit={submitDefectHandler} style={{display: (props.defects.length < 10 && defectShowing) ? "" : "none" }}>
        <input className="textdefect" type="text" maxLength="50" size="45" placeholder="Type defect here" required></input><br></br>
        <button className="submitbtn" type="submit">Submit Defect</button>
      </form>
      
      {/* Inline styling to show/hide option to favourite/unfavourite equipment */}
      <div><b>Is Favourite:</b> {`${props.isFavourite}`} &nbsp; 
        <div style={{display: props.isFavourite ? "none" : "block"}}>
          {/* Form for submitting equipment to favourite */}
          <form onSubmit={submitFavouriteHandler}>
            <label>
              <b>Favourite Form:</b><br></br>
            <input className="chkbox" type="checkbox" required></input>
              Add Favourite
            </label>&nbsp;
            <button className="submitbtn" type="submit">Confirm Add</button>
          </form>
        </div>
        <div style={{display: props.isFavourite ? "block" : "none"}}>
          {/* Form for submitting equipment to unfavourite */}
          <form onSubmit={submitUnfavouriteHandler}>
            <label>
              <b>Unfavourite Form:</b><br></br>
            <input className="chkbox" type="checkbox" required></input>
              Remove Favourite
            </label>&nbsp;
            <button className="submitbtn" type="submit">Confirm Remove</button>
          </form>
        </div>
      </div>

      {/* Inline styling to hide option to select equipment for use if equipment is in use */}
      <div style={{display: props.inUse ? "none" : "block"}}>
        {/* Form for submitting location where equipment is going to used at */}
        <form onSubmit={submitInUseHandler}>
          <label>
            <b>Usage Form: </b><br></br>
            <select className="selectbay" name="locationdropdown" required defaultValue={""}>Location
              <option value="" hidden>Select Location</option>
              <LocationDropDown />
            </select>
          </label>&nbsp;
          <button className="submitbtn" type="submit">Confirm Use</button>
        </form>
      </div>   
    </div>
  );
} 

export default EquipmentInfoAddUse;