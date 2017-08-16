<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
<style>
table, th, td {
	border: 1px solid black;
	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>

	<h1>Users</h1>
	<table>

		<tr>
			<th>ID</th>
			<th>UserName</th>
			<th>Email</th>
			<th>Password</th>
			<th>Group ID</th>
		</tr>
		<c:forEach var="user" items="${user}">
			<tr>
				<th>${user.id}</th>
				<th>${user.userName}</th>
				<th>${user.email}</th>
				<th>${user.password}</th>
				<th><a href="userDetails?group=${user.group_id}">${user.group_id}</a></th>

				<th><a href="UserAction?acction=edit&user=${user.id}">Edytuj</a></th>
				<th><a href="UserAction?acction=delete&user=${user.id}">Usun</a>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="UserAction?acction=add">Dodaj</a>
	<br>



</body>
</html>