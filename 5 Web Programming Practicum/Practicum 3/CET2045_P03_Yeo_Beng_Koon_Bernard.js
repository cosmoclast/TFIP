//your Javascript code here
let allBtns = document.body.querySelector(".calckeys");
let calcDisplay = document.body.querySelector(".calcdisplay");
let clearBtn = document.body.querySelector("#allclear");
let equalBtn = document.body.querySelector("#calculate");
let m1Val = "0";
let m2Val = "0";
let previousVal = "0";
let currentVal = "0";
let currentOp = "0";

// Function to reset previousVal, currentVal and currentOp
function resetValOp(){
  previousVal = "0";
  currentVal = "0";
  currentOp = "0";
}

// Function to add comma separators
function addCommas(){
  let currentValArray = Math.abs(currentVal).toString().split("").reverse();
  let currValArrayLen = currentValArray.length;
  let commaCurrentValArray = new Array();
  // Adding of commas
  for(let i = 0; i < currValArrayLen; i++){
    commaCurrentValArray.push(currentValArray[i]);
    if((i + 1) % 3 == 0 && (i + 1) != currValArrayLen)
      commaCurrentValArray.push(",");
  }
  // Adding negative sign for negative numbers
  if(currentVal[0] == "-")
    commaCurrentValArray.push("-");
  calcDisplay.textContent = commaCurrentValArray.reverse().join("");
}

// Function to print to calculator display
function printToDisplay(numberRounded = false){
  // Check for errorneous output
  if(Math.abs(currentVal) > 999999999){
    resetValOp();
    calcDisplay.textContent = "E";
    return;
  }
  // Adding commas for values more than or equal to thousand
  addCommas();
  // Adding R for rounded numbers
  if(numberRounded){
    calcDisplay.textContent += "r";
  }
}

// Event listener for AC button
clearBtn.addEventListener('click', function(){
    resetValOp();
    calcDisplay.textContent = "0";
  }
);

// Event listener for number buttons
allBtns.addEventListener('click', function(event){
    // Check if button pressed is a number button
    if(event.target.className === "") {    
      // Check if calculator has error
      if(calcDisplay.textContent == "E"){
        return;
      // Check if display reached max length
      }else if(Math.abs(currentVal).toString().length >= 9){
        return;
      // Check if display is currently zero
      }else if(currentVal == 0){
        currentVal = event.target.innerText;
        printToDisplay();
      }else{
        currentVal += event.target.innerText;
        printToDisplay();
      }
    }
  }
);

// Event listener for M+ button
allBtns.addEventListener('click', function(event){
    // Check if calculator has error
    if(calcDisplay.textContent == "E"){
      return;
    }else if(event.target.id == "m1add"){
        m1Val = currentVal;
    }else if(event.target.id == "m2add"){
        m2Val = currentVal;
    }
  }
); 

//Event listener for M button
allBtns.addEventListener('click', function(event){
    // Check if calculator has error
    if(calcDisplay.textContent == "E"){
      return;
    }else if(event.target.id == "m1"){
      currentVal = m1Val;
      printToDisplay();
    }else if(event.target.id == "m2"){
      currentVal = m2Val;
      printToDisplay();
    }
  }
); 

//Event listener for operator buttons
allBtns.addEventListener('click', function(event){  
    switch(event.target.id){
      case "add":
      case "subtract":
      case "multiply":
      case "divide":
        //Check if there is a value stored in currentVal
        if(currentVal && currentVal == "0"){
          return;
        }else if(currentVal && currentVal != "0"){
          currentOp = event.target.id;
          previousVal = currentVal;
          currentVal = 0;
        }else{
          currentOp = event.target.id;
        }
        break;       
    }
  }
);

//Event listener for equal button
equalBtn.addEventListener('click', function(){
    if(previousVal && currentVal && currentOp && previousVal != 0){
      switch(currentOp){
        case "add":
          currentVal = (Number(previousVal) + Number(currentVal)).toString();
          printToDisplay();
          //may have to set previousVal to zero so that pressing equal sign continously without a new operator does not cause any computation.
          previousVal = "0";
          break;

        case "subtract":
          currentVal = (Number(previousVal) - Number(currentVal)).toString();
          printToDisplay();
          //may have to set previousVal to zero so that pressing equal sign continously without a new operator does not cause any computation.
          previousVal = "0";
          break;

        case "multiply":
          currentVal = (Number(previousVal) * Number(currentVal)).toString();
          printToDisplay();
          //may have to set previousVal to zero so that pressing equal sign continously without a new operator does not cause any computation.
          previousVal = "0";
          break;

        case "divide":
          if(Number(previousVal) % Number(currentVal) == 0){
            currentVal = (Number(previousVal) / Number(currentVal)).toString();
            printToDisplay();
            //may have to set previousVal to zero so that pressing equal sign continously without a new operator does not cause any computation.
            previousVal = "0";
          }else if(Number(previousVal) % Number(currentVal) != 0){
            currentVal = Math.round(Number(previousVal) / Number(currentVal)).toString();
            printToDisplay(true);
            //may have to set previousVal to zero so that pressing equal sign continously without a new operator does not cause any computation.
            previousVal = "0";
          }        
          break;
      }   
    }
  }
);
