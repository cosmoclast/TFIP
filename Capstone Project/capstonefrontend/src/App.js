import "./App.css";
import Login from "./Pages/Login.js";
import NoMatch from "./Pages/NoMatch";
import SearchPage from "./Pages/SearchPage";
import AddPage from "./Pages/AddPage";
import BayPage from "./Pages/BayPage";
import UsingPage from "./Pages/UsingPage";
import MapNav from "./Pages/MapNav";
import { createContext, useState } from "react";
import { Routes, Route, Navigate, } from "react-router-dom";

export const LoginContext = createContext();

const App = () => {
  // Global value to denote something has changed
  const [hasChanged, setHasChanged] = useState(false);
  // Global value to denote the map is minimised or maximised
  const [miniMap, setMiniMap] = useState(false);

  // To change miniMap to toggle between a minimised and maximised map
  const toggleMapHandler = () => {
    setMiniMap(!miniMap);
  }

  // To change hasChanged to indicate something has changed
  const changeHandler = () => {
    setHasChanged(!hasChanged);
  }

  // To clear user information from session storage on log out
  const logoutHandler = () => {
    sessionStorage.removeItem("isLoggedIn");
    sessionStorage.removeItem("isSupervisor");
    sessionStorage.removeItem("employeeId");
  } 

  // To store user information in session storage on log in
  const loginHandler = (employeeId, title) => {
    sessionStorage.setItem("isLoggedIn", 1);
    sessionStorage.setItem("isSupervisor", 0);
    sessionStorage.setItem("employeeId", employeeId);

    if(title == "Supervisor"){
      sessionStorage.setItem("isSupervisor", 1);
    }
  }

  return (
    <div>
      {/* Context for global values */}
      <LoginContext.Provider value={{
                                    mapStatus: miniMap,
                                    changeStatus: hasChanged,
                                    onAnyChange: changeHandler,
                                    onLogOut: logoutHandler,
                                    onLogIn: loginHandler,
                                    onToggleMap: toggleMapHandler
                                    }}>                         
        <Routes>        
          {/* Automatically redirecting the root path to the Login page */}
          <Route path="/" element={<Navigate replace to="login" />} />
          {/* Automatically redirecting to bay A1 if user tries to directly access via URL */}
          <Route path="/bay" element={<Navigate replace to="A1" />} />
          <Route path="login" element={<Login />} />
          {/* MapNav will appear on every page */}
          <Route element={<MapNav />} >
            {/* Routes for various pages; Bay, Search, Using, Add */}
            <Route path="bay">
              <Route path=":bay" element={<BayPage />} />
            </Route>
            <Route path="search" element={<SearchPage />} />
            <Route path="using" element={<UsingPage />} />
            <Route path="add" element={<AddPage />} />
          </Route>
          {/* For invalid URLs */}
          <Route path='*' element={<NoMatch />} />     
        </Routes>  
      </LoginContext.Provider>
    </div>
  );
};

export default App;

