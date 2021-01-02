<!DOCTYPE html>
<html>

<head>

<title>Registration Form</title>
<link rel="stylesheet" href="style.css">
<link rel = "stylesheet" href = "bootstrap.css" >

</head>

<body>
<header class = "bg-dark text-white navbar">
	<h1 class= "p-2">JOB CONSULTANCY</h1>
	<div class= "p-2">
		<a href = "#" class="btn btn-primary">Home</a>
		<a href = "about.html" class="btn btn-primary">About Us</a>
		<a href = "contact.html" class="btn btn-primary">Contact Us</a>
		<a href = "jobsearch.jsp" class="btn btn-primary">Job Search</a>
		<a href = "login.jsp" class="btn btn-danger">Log in</a>
		<a href = "register.jsp" class="btn btn-warning">Register</a>
	</div>
	
</header>

<section>
<div class="hero">
<div class="form-box">
<div class="button-box">
<div id="btn"></div>
<button type="button" class="toggle-btn" onclick="Employee()">Recruiter</button>
<button type="button" class="toggle-btn" onclick="candidate()">Candidate</button>

</div>

<form id="Employee" class="input-groups" action="Register" method="post" onsubmit="return validation(this)">
<input type="text" id="e_fname" name="e_fname" class="input-field" placeholder="Company Name" required>
<input type="text" id="e_lname" name="e_lname" class="input-field" placeholder="Address" required>
<input type="email" id="e_email" name="e_email" class="input-field" placeholder="Email" required>
<input type="text" id="e_lname" name="e_lname" class="input-field" placeholder="Website" required>
<input type="password" id="e_password" name="e_password" class="input-field" placeholder="Enter Password" required>
<input type="password" id="e_password1" name="e_password1" class="input-field" placeholder="Confirm Password" required>


<button type="submit" class="submit-btn" onclick="return validate()">Register</button>
If you are already a registered user please <a href="login.html">login</a>
</form>

 <form id="candidate" class="input-groups" action="Register" method="post" onsubmit="return validation1(this)">
<input type="text" id="c_fname"  name="c_fname" class="input-field" placeholder="First Name" required>
<input type="text" id="c_lname" name="c_lname" class="input-field" placeholder="Last Name" required>
<input type="text" id="c_gender" name="c_gender" class="input-field" placeholder="Gender" required>
<input type="text" id="c_phone" name="c_phone" class="input-field" placeholder="Contact Number" required>
<input type="email" id="c_email" name="c_email" class="input-field" placeholder="Email" required>
<input type="text" id="c_add" name="c_add" class="input-field" placeholder="Address" required>
<input type="text" id="c_quali" name="c_quali"  class="input-field" placeholder="Qualification" required>
<input type="password" id="c_password" name="c_password" class="input-field" placeholder="Enter Password" required>
<input type="password" id="c_password1" name="c_password1" class="input-field" placeholder="Confirm Password" required>
<input type="text" id="c_exp" name="c_exp" class="input-field" placeholder="Ecperience" required>
<input type="date" id="c_dob" name="c_dob" class="input-field" placeholder="Date Of Birth" required>
<input type="file" id="c_resume" name="c_resume" class="input-field" placeholder="Resume" required>
<input type="hidden" id="cand" name="cand" value="emp" >

<button type="submit" class="submit-btn" onclick="return validate1()">Register</button>
If you are already a registered user please <a href="login.html">login</a>
</form>
</div>


 </div>
 
<script>
var x = document.getElementById("Employee");
var y = document.getElementById("candidate");
var z = document.getElementById("btn");
var q = 0;

function candidate() {
x.style.left = "-400px";
y.style.left = "50px";
z.style.left = "110px";
document.getElementById("stu").value="stu";

//stu.value = 1;
}

 function Employee() {
x.style.left = "50px";
y.style.left = "450px";
z.style.left = "0px";

//emp.value = 0;
}

 function validate(){
	 var p=document.getElementById("e_password").value;
	 var p1=document.getElementById("e_password1").value;
	 if(p!=p1){
		 alert("password and confirm password should be same");
		 return false;
	 }
 }
 
 function validate1(){
	 var p=document.getElementById("c_password").value;
	 var p1=document.getElementById("c_password1").value;
	 if(p!=p1){
		 alert("password and confirm password should be same");
		 return false;
	 }
 }

 </script>
</section>
</body>

</html>