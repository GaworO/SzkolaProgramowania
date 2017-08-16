<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Users</h1>
	<table>

		<tr>
			
			<th>UserName</th>
			<th>Group Id </th>
		
		</tr>
		<c:forEach var="user" items="${user}">
			<tr>
				<th>${user.userName}</th>
				<th>${user.group_id}</th>
			</tr>
		</c:forEach>

	</table>
</body>
</html>