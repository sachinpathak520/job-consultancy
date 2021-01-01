<!DOCTYPE html>
<html>

<head>

<title>Registration Form</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
<div class="hero">
<div class="form-box">
<div class="button-box">
<div id="btn"></div>
<button type="button" class="toggle-btn" onclick="Employee()">Employee</button>
<button type="button" class="toggle-btn" onclick="Student()">Student</button>

</div>

<form id="Employee" class="input-group" action="register" method="post" onsubmit="return validation(this)">
<input type="text" id="e_fname" name="e_fname" class="input-field" placeholder="First Name" required>
<input type="text" id="e_lname" name="e_lname" class="input-field" placeholder="Last Name" required>
<input type="email" id="e_email" name="e_email" class="input-field" placeholder="Email" required>
<input type="text" id="e_phone" name="e_phone" class="input-field" placeholder="Contact Number" required>
<input type="text" id="e_company" name="e_company" class="input-field" placeholder="Company" required>
<input type="password" id="e_password" name="e_password" class="input-field" placeholder="Enter Password" required>
<input type="password" id="e_password1" name="e_password1" class="input-field" placeholder="Confirm Password" required>

<button type="submit" class="submit-btn" onclick="return validate()">Register</button>
If you are already a registered user please <a href="login.html">login</a>
</form>

 <form id="Student" class="input-group" action="register" method="post" onsubmit="return validation1(this)">
<input type="text" id="s_fname"  name="s_fname" class="input-field" placeholder="First Name" required>
<input type="text" id="s_lname" name="s_lname" class="input-field" placeholder="Last Name" required>
<input type="email" id="s_email" name="s_email" class="input-field" placeholder="Email" required>
<input type="text" id="s_phone" name="s_phone" class="input-field" placeholder="Contact Number" required>
<input type="text" id="s_qualification" name="s_qualification"  class="input-field" placeholder="Qualification" required>
<input type="password" id="s_password" name="s_password" class="input-field" placeholder="Enter Password" required>
<input type="password" id="s_password1" name="s_password1" class="input-field" placeholder="Confirm Password" required>
<input type="hidden" id="stu" name="custId" value="emp" >

<button type="submit" class="submit-btn" onclick="return validate1()">Register</button>
If you are already a registered user please <a href="login.html">login</a>
</form>
</div>


 </div>
<script>
var x = document.getElementById("Employee");
var y = document.getElementById("Student");
var z = document.getElementById("btn");
var q = 0;

function Student() {
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
	 var p=document.getElementById("s_password").value;
	 var p1=document.getElementById("s_password1").value;
	 if(p!=p1){
		 alert("password and confirm password should be same");
		 return false;
	 }
 }

 </script>

</body>

</html>