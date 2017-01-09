<%@ taglib uri="WEB-INF/EntryField.tld" prefix="c" %>
<html>
<body>

<form method="post" action="Login">
User Name: <c:EntryField type="text" name="userId" ></c:EntryField></br>
Password: <c:EntryField type="password" name="pwd" ></c:EntryField></br>
<c:EntryField type="submit" value="Login" ></c:EntryField></br>
<a href="signUp.jsp">Sign Up</a> </br>
<a href="forgetPassword.jsp">Forget Password</a>
</form>
</body>
</html>
