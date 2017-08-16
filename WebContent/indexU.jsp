<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UserS" method="post">

Proszę wprowadzić nazwę użytkownika :  
<input type="text" name="name"/>
<br>
Proszę wprowadzić email : 
<input type="text" name="email"/>
<br>
Prosze wprowadzić hasło:
<input type="text" name="password"/>
<br>
Proszę wprowadzić id grupy :
<input type="text" name="id" min="1"/>
<br>
Prosze wprowaszic swoje id 
 <input type="number" name="userId" <%-- value="${param.user}" --%>> 
<input type="submit" name="Submit"/>

</form>

</body>
</html>