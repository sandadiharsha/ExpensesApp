<%@ taglib uri="WEB-INF/EntryField.tld" prefix="c" %>
<html>
<body>

<form method="post" action="Login">
<c:EntryField type="text" name="userId" ></c:EntryField>
<c:EntryField type="password" name="pwd" ></c:EntryField>
<c:EntryField type="submit" value="Login" ></c:EntryField>
</form>
</body>
</html>
