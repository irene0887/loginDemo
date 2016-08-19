<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Here is Login.</h1>
	<p>Please type in your username and password.</p>
	<br />If you have not registered yet, please click here.
	<a href="register.jsp">Register</a>
	<br />
	<s:form action="login" method="post" namespace="/">
		<s:textfield name="username" label="Your username"></s:textfield>
		<s:password name="password" label="Your password"></s:password>
		<s:submit value="Login Now!"></s:submit>
	</s:form>
</body>
</html>