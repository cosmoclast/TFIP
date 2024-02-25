//your Javascript code here
let allBtns = document.body.querySelector(".calckeys");
let calcDisplay = document.body.querySelector(".calcdisplay");
let clearBtn = document.body.querySelector("#allclear");
let equalBtn = document.body.querySelector("#calculate");

let m1Val = "0";
let m2Val = "0";
let previousVal = new String();
let currentVal = new String();
let currentOp = new String();
// let numRounded = false;
// let numNegative = false;
// let numError = false;

//Function to reset previousVal, currentVal and currentOp
function resetValOp(){
  previousVal = "";
  currentVal = "";
  currentOp = "";
}

//Function to validate outputs before display on calculator
function validateOutput(outputVal){
  if(Math.abs(outputVal) > 999999999){
    return false;
  }else{
    return true;
  }
}

// Function to add comma separators
function addCommas(listenerEvent = null){
  // Catches events not from number key so it is not appended to currentVal.
  try{
    currentVal += listenerEvent.target.innerText;
  }catch(err){
    console.log("Event is not from a number key");
  }

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

//Event listener for AC button
clearBtn.addEventListener('click', function(){
    resetValOp();
    calcDisplay.textContent = "0";
  }
);

//Event listener for number buttons
allBtns.addEventListener('click', function(event){
    // Check if button pressed is a number button
    if(event.target.className === "") {
      // // Check if display is currently zero VERSION 1
      // if(calcDisplay.textContent == 0){
      //   currentVal = event.target.innerText;
      //   calcDisplay.textContent = currentVal;

      // Check if display is currently zero VERSION 2
      // }else if(calcDisplay.textContent == 0){
      //   currentVal = event.target.innerText;
      //   calcDisplay.textContent = currentVal;

     // }else if(calcDisplay.textContent.length >= 11){ Version 1

     
      // Check if calculator has error
      if(calcDisplay.textContent == "E"){
        return;
      // Check if display reached max length
      }else if(Math.abs(currentVal).toString().length >= 9){
        return;
      // Check if display is currently zero VERSION 3
      }else if(currentVal == 0){
        currentVal = event.target.innerText;
        calcDisplay.textContent = currentVal;
      // Check if need to add commas
      }else if(calcDisplay.textContent.length < 3){
        currentVal += event.target.innerText;
        calcDisplay.textContent = currentVal;
      }else {
        addCommas(event);
      }
    }
  }
);

//Event listener for M+ button
allBtns.addEventListener('click', function(event){
    if(calcDisplay.textContent == "E"){
      return;
    }else if(event.target.id == "m1add"){
      if(currentVal == ""){
        m1Val = "0";
      }else{
        m1Val = currentVal;
      }
      console.log(m1Val);
      console.log(m2Val);
    }else if(event.target.id == "m2add"){
      if(currentVal == ""){
        m2Val = "0";
      }else{
        m2Val = currentVal;
      }
      console.log(m1Val);
      console.log(m2Val);
    }
  }
); 

//Event listener for M button
allBtns.addEventListener('click', function(event){
  if(calcDisplay.textContent == "E"){
    return;
  }else if(event.target.id == "m1"){
    currentVal = m1Val;
    addCommas();
  }else if(event.target.id == "m2"){
    currentVal = m2Val;
    addCommas();
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
          // console.log(currentVal && currentVal != "0");
          //Check if there is a value stored in currentVal
          if(currentVal && currentVal == "0"){
            return;
          }else if(currentVal && currentVal != "0"){
            currentOp = event.target.id;
            previousVal = currentVal;
            currentVal = "";
          }else{
            currentOp = event.target.id;
          }
          break;
          // calcDisplay.textContent = "0";

          // console.log(currentOp);
        
    }
  }
);

//Event listener for equal button
equalBtn.addEventListener('click', function(){
    if(previousVal && currentVal && currentOp && previousVal != 0){
      // console.log(previousVal);
      // console.log(currentVal);
      // console.log(currentOp);
      switch(currentOp){
        case "add":
          currentVal = (Number(previousVal) + Number(currentVal)).toString();
          if(validateOutput(currentVal)){
            calcDisplay.textContent = currentVal;
            //may have to set previousVal to zero so that pressing equal sign continously without a new operator does not cause any computation.
            previousVal = "";
            addCommas();
          }else{
            resetValOp();
            calcDisplay.textContent = "E";
          }
          break;
        case "subtract":
          currentVal = (Number(previousVal) - Number(currentVal)).toString();
          if(validateOutput(currentVal)){
            calcDisplay.textContent = currentVal;
            //may have to set previousVal to zero so that pressing equal sign continously without a new operator does not cause any computation.
            previousVal = "";
            addCommas();
          }else{
            resetValOp();
            calcDisplay.textContent = "E";
          }
          break;
        case "multiply":
          currentVal = (Number(previousVal) * Number(currentVal)).toString();
          if(validateOutput(currentVal)){
            calcDisplay.textContent = currentVal;
            //may have to set previousVal to zero so that pressing equal sign continously without a new operator does not cause any computation.
            previousVal = "";
            addCommas();
          }else{
            resetValOp();
            calcDisplay.textContent = "E";
          }
          break;
        case "divide":
          // currentVal = (Number(previousVal) / Number(currentVal)).toString();

          if(Number(previousVal) % Number(currentVal) == 0){
            currentVal = (Number(previousVal) / Number(currentVal)).toString();
          }else if(Number(previousVal) % Number(currentVal) != 0){
            currentVal = Math.round(Number(previousVal) / Number(currentVal)).toString();
            numRounded = true;
            console.log(currentVal);
            console.log(numRounded);
          }        
          
          if(validateOutput(currentVal) == false){
            resetValOp();
            calcDisplay.textContent = "E";
           
          }else if(numRounded == true){
            // calcDisplay.textContent = currentVal + "R";
            //may have to set previousVal to zero so that pressing equal sign continously without a new operator does not cause any computation.
            previousVal = "";
            console.log(currentVal);
            addCommas();
            calcDisplay.textContent += "R";
            numRounded = false;
          }else{
            calcDisplay.textContent = currentVal;
            //may have to set previousVal to zero so that pressing equal sign continously without a new operator does not cause any computation.
            previousVal = "";
            addCommas();
          }
          break;
      }   
    }else{
      return;
    }
  }
);

