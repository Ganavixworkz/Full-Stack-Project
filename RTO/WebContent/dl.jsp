<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DL application</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" 
 rel="stylesheet" 
 integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
  crossorigin="anonymous">
 <script type="text/javascript">
var citiesByState = {
Karnataka: ["Bengalore","Mysore","Manglore"],
Maharashtra: ["Mumbai","Pune","Nagpur"],
Kerala: ["kochi","Kanpur"]
}
function makeSubmenu(value) {
if(value.length==0) document.getElementById("citySelect").innerHTML = "<option></option>";
else {
var citiesOptions = "";
for(cityId in citiesByState[value]) {
citiesOptions+="<option>"+citiesByState[value][cityId]+"</option>";
}
document.getElementById("citySelect").innerHTML = citiesOptions;
}
}
function displaySelected() { var country = document.getElementById("countrySelect").value;
var city = document.getElementById("citySelect").value;
alert(country+"\n"+city);
}
function resetSelection() {
document.getElementById("countrySelect").selectedIndex = 0;
document.getElementById("citySelect").selectedIndex = 0;
}

function handleFName() {
    const fname = document.getElementById('firstName').value
    const button = document.getElementById('button');
    if (fname.length >= 3 && fname.length <= 20) {
      document.getElementById("fmsg").innerHTML = "<span style='color: green'> Name is valid </span>"
      button.removeAttribute("disabled");
    } else {
      document.getElementById("fmsg").innerHTML = "<span style='color :red'> Name is Invalid </span>"
      button.setAttribute("disabled", "");
    }
  }



function handleLName() {
    const lname = document.getElementById('lastName').value
    const button = document.getElementById('button');
    if (lname.length >= 2 && lname.length <= 10) {
      document.getElementById("lmsg").innerHTML = "<span style='color: green'> Name is valid </span>"
      button.removeAttribute("disabled");
    } else {
      document.getElementById("lmsg").innerHTML = "<span style='color :red'> Name is Invalid </span>"
      button.setAttribute("disabled", "");
    }
  }

function handlePhoneNo() {
    const phno = document.getElementById('contact').value
    const button = document.getElementById('button');
    if (phno.length === 10) {
      document.getElementById("phmsg").innerHTML = "<span style='color: green'> PhoneNumber is valid </span>"
      button.removeAttribute("disabled");
    } else {
      document.getElementById("phmsg").innerHTML = "<span style='color :red'> PhoneNumber is Invalid </span>"
      button.setAttribute("disabled", "");
    }
  }

function handleAadharNo() {
    const aadharno = document.getElementById('aadhar').value
    const button = document.getElementById('button');
    if (aadharno.length === 12) {
      document.getElementById("aamsg").innerHTML = "<span style='color: green'> AadharNumber is valid </span>"
      button.removeAttribute("disabled");
    } else {
      document.getElementById("aamsg").innerHTML = "<span style='color :red'> AadharNumber is Invalid </span>"
      button.setAttribute("disabled", "");
    }
  }
  

function handleEmail() {
    const em = document.getElementById('email').value;
    const button = document.getElementById('button');
    if (em.match(/^[a-z]+@[a-z]+\.[a-z]{3}$/)) {
      document.getElementById("emsg").innerHTML = "<span style='color: green'>Email is valid</span>";
      button.removeAttribute("disabled");
    } else {
      document.getElementById("emsg").innerHTML = "<span style='color: red'>Invalid Email format</span>";
      button.setAttribute("disabled", "");
    }
  }

function handlePermanentAdd() {
    const padd = document.getElementById('permanent').value
    const button = document.getElementById('button');
    if (padd.length >= 3 && padd.length <=50) {
      document.getElementById("pa").innerHTML = "<span style='color: green'> Address is valid </span>"
      button.removeAttribute("disabled");
    } else {
      document.getElementById("pa").innerHTML = "<span style='color :red'> Address is Invalid </span>"
      button.setAttribute("disabled", "");
    }
  }

function handleCurrentAdd() {
    const cadd = document.getElementById('current').value
    const button = document.getElementById('button');
    if (cadd.length >= 3 && cadd.length <=50) {
      document.getElementById("ca").innerHTML = "<span style='color: green'> Address is valid </span>"
      button.removeAttribute("disabled");
    } else {
      document.getElementById("ca").innerHTML = "<span style='color :red'> Address is Invalid </span>"
      button.setAttribute("disabled", "");
    }
  }

function handleAge() {
    const age = document.getElementById('uage').value
    const button = document.getElementById('button');
    if (age >= 18) {
      document.getElementById("agee").innerHTML = "<span style='color: green'> Age Verified </span>"
      button.removeAttribute("disabled");
    } else {
      document.getElementById("agee").innerHTML = "<span style='color :red'> Age Not Verified....Must Be 18 above!!! </span>"
      button.setAttribute("disabled", "");
    }
  }

</script>
</head>

<body onload="resetSelection()">

<form action="dlentry" method="post" >

      <font color="green" text-align="center"><h4>${success}</h4></font> 

<div class="container w-100  border border-dark border-5 mt-5">
 <h5 class="bg-info p-1 border-primary border-1 border text-left">
      <a class="btn btn-light" href="index.jsp" role="button">Home</a>

Driving License
</h5>
 

<h3 class="bg-primary-subtle p-3 border-primary border-1 border text-center">


NEW DRIVING LICENSE REGISTRATION
<br>
<font color="RED" size=4>**Fields marked with * are mandatory
<br>
**To calculate Age,place the cursor in age field
</font>

</h3>
  
  <h4 class="bg-info p-1 border-primary border-1 border text-center">

DEMOGRAPHIC DETAILS


</h4>
 
<div class="row g-4">
 

 

<!-- <div class="col-md-4">
     <label  class="form-label"><b>Pincode</b></label> 
    <input type="number" placeholder="PINCODE" name="pincode" required>
    </div> -->
   

  <div class="col-md-5">
     <label  class="form-label"><b>Applicant First Name*</b>
    <input id="firstName" type="text"  placeholder="FIRST NAME" name="firstName"  value="${dto.firstName}" required="required" oninput="handleFName()">
        <span id="fmsg"></span>
    
    </div>
    
  
  <div class="col-md-5 md-5">
    <input  type="text"  placeholder="MIDDLE NAME" name="middleName" value="${dto.middleName}" required>
    </div>
    
    <div class="col-md-2 md-5">
    <input id="lastName" type="text" placeholder="LAST NAME" name="lastName" value="${dto.lastName}" required="required" oninput="handleLName()">
   <span id="lmsg"></span>
    </div>
    
             <label  class="form-label"><b>Gender</b>
             <div class="form-check form-check-inline">
    
              <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="Male">
              <label class="form-check-label" for="inlineRadio1">Male</label>
              </div>


<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="Female">
  <label class="form-check-label" for="inlineRadio2">Female</label>
</div>

<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="gender" id="inlineRadio3" value="TransGender" >
  <label class="form-check-label" for="inlineRadio3">TransGender</label>
</div>
  
  <div class="col-md-5 md-5">
               <label  class="form-label"><b>Aadhar Number</b>
  <input id="aadhar" type="tel"  placeholder="AADHAR NUMBER" name="aadharNumber" value="${dto.aadharNumber}" required="required" oninput="handleAadharNo()">
  <span id="aamsg"></span>
  
    </div>
    
    <div class="row g-4">
  
  <div class="col-md-4">
 <label  class="form-label"><b>*State</b>
<select id="stateSelect" name="state" size="1" onchange="makeSubmenu(this.value)"></label>
<option value="" disabled selected>Choose State</option>
<option>Karnataka</option>
<option>Maharashtra</option>
<option>Kerala</option>
</select>
</div>
   
    <div class="row g-4">
    <div class="col-md-4 ">
               <label  class="form-label"><b>Place Of Birth</b>
  <input type="tel"  placeholder="PLACE OF BIRTH" name="placeOfBirth" value="${dto.placeOfBirth}" required>
    </div>
    
    <div class="col-md-4">
               <label  class="form-label"><b>Date of Birth </b>
  <input type="date"  placeholder="DATE OF BIRTH" name="dob" value="${dto.dob}" required>
    </div>
    
    <div class="col-md-4">
               <label  class="form-label"><b>Age </b>
  <input id="uage" type="number"  placeholder="AGE" name="age" required="required" value="${dto.age}" oninput="handleAge()">
   <span id="agee"></span>
    </div>
    
        <div class="row g-3">
    <div class="col-md-6">
               <label  class="form-label"><b>Qualification</b>
  <input type="text"  placeholder="QUALIFICATION" name="qualification" value="${dto.qualification}" required>
    </div>
    
    <div class="col-md-6">
               <label  class="form-label"><b>Blood Group</b>
  <input type="text"  placeholder="BLOOD GROUP" name="bloodGroup" value="${dto.bloodGroup}" required>
    </div>
    
    
      <div class="row g-3">
    <div class="col-md-6">
               <label  class="form-label"><b>PhoneNumber</b>
  <input id="contact" type="tel"  placeholder="PHONENUMBER" name="phoneNumber"  required="required" value="${dto.phoneNumber}" oninput="handlePhoneNo()">
<span id="phmsg"></span>
    </div>
    
    <div class="col-md-6">
               <label  class="form-label"><b>Email Id</b>
  <input id="email"  type="text"  placeholder="Ex:abc@xyz.com" name="email"  required="required" value="${dto.email}" oninput="handleEmail()">
<span id="emsg"></span>
  
    </div>
    
       <div class="row g-3">
    <div class="col-md-6">
               <label  class="form-label"><b>Citizenship No*</b>
  <input id="" type="tel"  placeholder="" name="citizenshipNumber"  required="required" oninput="">
<span id=""></span>
    </div>
    
    <div class="col-md-6">
               <label  class="form-label"><b>Passport No</b>
  <input id=""  type="text"  placeholder="" name="PassportNumber"  required="required" oninput="">
<span id=""></span>
  
    </div>
    
    
    <div class="row g-3">
    <div class="col-md-6">
               <label  class="form-label"><b>Trainer License No</b>
  <input id="" type="text"  placeholder="" name="trainerLicenseNo"  required="required" oninput="">
<span id=""></span>
    </div>
    
    <div class="col-md-6">
               <label  class="form-label"><b>Trainer Name</b>
  <input id=""  type="text"  placeholder="" name="trainerName"  required="required" oninput="">
<span id=""></span>
  </div>
  
  <div class="row g-3">
    <div class="col-md-6">
               <label  class="form-label"><b>Citizenship Issued District</b>
  <input id="" type="text"  placeholder="" name="citizenshipIssuedDistrict"  required="required" oninput="">
<span id=""></span>
    </div>
    
    <div class="col-md-6">
               <label  class="form-label"><b>Passport Issued Country</b>
  <input id=""  type="text"  placeholder="" name="passportIssuedCountry"  required="required" oninput="">
<span id=""></span>
  </div>
    
    
    <div class="row g-3">
    <div class="col-md-6">
               <label  class="form-label"><b>Witness First Name</b>
  <input id="" type="text"  placeholder="" name="wFirstName"  required="required" oninput="">
<span id=""></span>
    </div>
    
    <div class="col-md-6">
               <label  class="form-label"><b>Witness Middle Name</b>
  <input id=""  type="text"  placeholder="" name="wMiddleName"  required="required" oninput="">
<span id=""></span>
  </div>
  
  <div class="row g-3">
    <div class="col-md-6">
               <label  class="form-label"><b>Witness Last Name</b>
  <input id="" type="text"  placeholder="" name="wLastName"  required="required" oninput="">
<span id=""></span>
    </div>
    
    <div class="col-md-6">
               <label  class="form-label"><b>Witness Relationship*</b>
  <input id=""  type="text"  placeholder="" name="relationship"  required="required" oninput="">
<span id=""></span>
  </div>
  
    
   <font color="red"><h6>${uerr}</h6></font>
    
    <hr>
    
    <div class="col-md-6">
 <label  class="form-label"><b>*Country</b>
<select id="countrySelect" name="country" size="1" onchange="makeSubmenu(this.value)"></label>
<option value="" disabled selected>Choose Country</option>
<option>India</option>
<option>Australia</option>
<option>UK</option>
</select>
</div>
<div class="row g-3">
    <div class="col-md-6">
               <label  class="form-label"><b>*Permanent Address</b>
  <input id="permanent" type="text"  placeholder="" name="permanentAddress" value="${dto.permanentAddress}" required="required" oninput="handlePermanentAdd()">
<span id="pa"></span>
    </div>
    
    <div class="col-md-6">
               <label  class="form-label"><b>*Pincode</b>
  <input type="text"  placeholder="" name="permanentPincode" value="${dto.permanentPincode}" required>
    </div>
    </div>
    <div class="row g-3">
    
    <div class="col-md-6 ">
               <label  class="form-label"><b>*Current Address</b>
  <input id="current" type="text"  placeholder="" name="currentAddress"  required="required" value="${dto.currentAddress}" oninput="handleCurrentAdd()">
<span id="ca"></span>
    </div>
    
    <div class="col-md-6">
               <label  class="form-label"><b>*Pincode</b>
  <input type="text"  placeholder="" name="currentPincode" value="${dto.currentPincode}" required>
    </div>
    </div>
   

  <div class="col-12">
    <button class="btn btn-primary" type="submit">Submit</button>
  </div>
  </div>
</div>
</form>
</body>
</html>