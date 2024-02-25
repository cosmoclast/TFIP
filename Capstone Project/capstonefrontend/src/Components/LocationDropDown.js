import React from 'react';

// Dropdown list options are hardcoded because departure bays at the airport are seldom changed. 
const locations = ["A1", "A2", "A3", "A4", "A5", "A9", "A10", "A11", "A12", "A13", "A14", "A15", "A16", "A17", "A18", "A19", "A20", "A21",
                  "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", 
                  "C1", "C11", "C13", "C15", "C16", "C17", "C18", "C19", "C20", "C22", "C23", "C24", "C25", "C26", 
                  "D30", "D32", "D34", "D35", "D36", "D37", "D38", "D40", "D41", "D42", "D44", "D46", "D47", "D48", "D49", 
                  "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E10", "E11", "E12", "E20", "E22", "E24", "E26", "E27", "E28", 
                  "F30", "F31", "F32", "F33", "F34", "F35", "F36", "F37", "F40", "F41", "F42", "F50", "F52", "F54", "F56", "F58", "F59", "F60", 
                  "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "G11", "G12", "G13", "G14", "G15", "G16", "G17", "G18", "G19", "G20", "G21"];

// Maps the locations array above to options in a dropdown list.
const LocationDropDown = function(){
  return(
    <React.Fragment>
      {locations.map((location) => {
        return(<option key={location} value={location}>{location}</option>);
      })}
    </React.Fragment>
  );
}

export default LocationDropDown;