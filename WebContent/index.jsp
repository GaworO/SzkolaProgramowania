<%@	taglib	uri="http://java.sun.com/jsp/jstl/core"	prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
 <style>
    table {
      border: 1px solid black;
      margin-bottom: 25px;
    }
    th, td {
      border: 1px solid black;
      
    }
    td {
    	
    }
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table align="center">
    <tr>
      <th colspan="6">Ostatnie rozwiazania</th>
    </tr>
    <tr>
      <th scope="col">id</th>
      <th scope="col">utworzono</th>
      <th scope="col">zaktualizowano</th>
      <th scope="col">szczegoly</th>
    </tr>
    <c:forEach var="solution" items="${solutionSQLs}">
    <tr>
      <th scope="row">${solution.solution_id}</th>
      <td>${solution.created}</td>
      <td>${solution.upade}</td>
      <td>${solution.description}</td>

   
    </tr>
    </c:forEach>
  </table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>