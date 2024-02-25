import axios from 'axios';
import "./Login.css";
import {useContext, useState} from 'react';
import { LoginContext } from '../App';
import { useNavigate } from 'react-router-dom';

// Login allows user to log in to the site
const Login = () => {
  const [enteredId, setEnteredId] = useState("");
  const navigate = useNavigate();
  const cxt = useContext(LoginContext);

  // Handler to handle entered ID
  const idInputHandler = (event) => {
    setEnteredId(event.target.value);
  };

  // Function to check form data and if data is valid to send to database to check if user exists
  // If log in is successful, user log in status and user job title is stored in session storage
  // and automatically navigated to SearchPage.
  async function formHandler(event) {
    event.preventDefault();
    const idRegex = /[0-9]{8}/;

    if(!idRegex.test(enteredId)){
      alert("Employee ID requires 8 digits");
    }else{
      await axios.get(`http://localhost:8080/employees`, {params: {employeeId: enteredId}})
        .then((res) => {
          if(res.data == null){
            alert("No Such Employee Exists");
          }else{
            cxt.onLogIn(res.data.employeeId, res.data.title);
            navigate("/search");
          }
        }).catch((err)=>{
          // console.log(err);
          alert("Server Is Currently Under Maintenance");
        })
    }
  }  

  return(
      <div className="loginform">
        <h1>Track Equipment SysTem (TEST)</h1>
        {/* Log in form */}
        <form onSubmit={formHandler}>
          <input className="logininput" type="text" maxLength="8" placeholder="Employee ID" onChange={idInputHandler}></input>
          <br></br><button className="loginbtn" type="submit">LOG IN</button>
        </form>
      </div>
    );
};

export default Login;