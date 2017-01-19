<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/EntryField.tld" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member Demographics</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

  <link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>

  $( function() {

    $("input[type='datepicker']" ).datepicker();

  } );
  </script>
</head>
<body>
<form method="post" action="MemberInformation">
Prefix: <select name="prefix">
  <option value="MR">Mr.</option>
  <option value="MS">Ms.</option>
  <option value="MRS">Mrs.</option>
</select>
First Name: <c:EntryField type="text" name="firstName" ></c:EntryField>
Middle Name: <c:EntryField type="text" name="middleName" ></c:EntryField>
Last Name: <c:EntryField type="text" name="middleName" ></c:EntryField>
Suffix: <select name="suffix">
  <option value="JR">Jr.</option>
  <option value="SR">Sr.</option>
	</select> <br>
Date of Birth: <c:EntryField type="datepicker" name="dateOfBirth" ></c:EntryField>
 Gender: <select name="gender">
  <option value="M">Male</option>
  <option value="F">Female</option>
</select>
<c:EntryField type="submit" value="MemberInformation" ></c:EntryField><br>

</form>
</body>
</html>