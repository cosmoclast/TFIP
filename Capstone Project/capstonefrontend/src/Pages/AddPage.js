import axios from 'axios';
import "./AddPage.css";
import LocationDropDown from "../Components/LocationDropDown";
import { LoginContext } from "../App";
import { useEffect, useContext } from "react";
import { useNavigate } from 'react-router-dom';

// AddPage allows user to add new equipment to the database
const AddPage = function(){
  const navigate = useNavigate();
  const cxt = useContext(LoginContext);

  // UseEffect to route user back to login if user is not logged in or a Supervisor
  useEffect(() => {
    if(sessionStorage.getItem("isLoggedIn") != 1 || sessionStorage.getItem("isSupervisor") != 1){
      navigate("/");
    }
  },[])
  
  // Handler to add new equipment to the database
  async function addFormHandler(event){
    event.preventDefault();
    const formData = {
      "category": event.target[0].value,
      "equipmentName": event.target[1].value,
      "eLength": parseFloat(event.target[2].value),
      "eWidth": parseFloat(event.target[3].value),
      "eHeight": parseFloat(event.target[4].value),
      "aircraft": event.target[5].value,
      "location": event.target[6].value,
    }

    await axios.post(`http://localhost:8080/newEquipment`, formData)
      .then(() => {
        cxt.onAnyChange();
        event.target[0].value = "";
        event.target[1].value = "";
        event.target[2].value = "";
        event.target[3].value = "";
        event.target[4].value = "";
        event.target[5].value = "";
        event.target[6].value = "";
        alert("Equipment added successfully"); 
      }).catch((err) => {
        // console.log(err);
        alert("Server Is Currently Under Maintenance Or You Are Not Logged In Or You Do Not Have Rights To This Page");
    });
  }

  return(
    <div>
      {/* Form to submit new equipment info to send to database */}
      <form onSubmit={addFormHandler}>
        <table className="addformcontainer" style={{paddingTop: cxt.mapStatus ? "100px" : "" }}>
          <tbody>
            <tr>
              <td><b>Category:</b></td>
              <td>
                <select className="selectcategory" required defaultValue={""}>
                  <option value="" hidden>Select Category</option>
                  <option value="Tow Tug">Tow Tug</option>
                  <option value="Tow Bar">Tow Bar</option>
                  <option value="Ground Power Unit">Ground Power Unit</option>
                  <option value="Step">Step</option>
                </select>
              </td>
            </tr>
            <tr>
              <td><b>Equipment Name:</b></td>
              <td><input className="textequipmentname" type="text" maxLength="50" size="40" required></input></td>
            </tr>
            <tr>
              <td><b>Length:</b></td>
              <td><input className="dimequipment" type="number" step="0.1" max="99.9" min="0.1" required></input></td>
            </tr>
            <tr>
              <td><b>Width:</b></td>
              <td><input className="dimequipment" type="number" step="0.1" max="99.9" min="0.1" required></input></td>
            </tr>
            <tr>
              <td><b>Height:</b></td>
              <td><input className="dimequipment" type="number" step="0.1" max="99.9" min="0.1" required></input></td>
            </tr>
            <tr>
              <td><b>Aircraft:</b></td>
              <td><input className="textaircraft" type="text" maxLength="20" size="40" required></input></td>
            </tr>
            <tr>
              <td><b>Location:</b></td>
              <td>
                <select className="selectlocation" required defaultValue={""}>
                  <option value="" hidden>Select Location</option>
                  <LocationDropDown/>
                </select>
              </td>
            </tr>
            <tr>
              <td></td>
              <td><button className="addequipmentbtn" type="submit">Add New Equipment</button></td>
            </tr>
          </tbody>
        </table>
      </form>  
    </div>
  );
}

export default AddPage;