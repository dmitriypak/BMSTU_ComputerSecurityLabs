<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet"></link>
</head>
<body>
	<form:form method="post" enctype="multipart/form-data"
		modelAttribute="uploadedFile" action="uploadFile">
		<table>
			<tr>
				<td></td>
				<td><input type="file" name="file" /></td>
				<td style="color: red; font-style: italic;"><form:errors
						path="file" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Загрузить" /></td>
				<td></td>
			</tr>
		</table>
	</form:form>

	<%-- <P>  The time on the server is ${serverTime}. </P> --%>
</body>
</html>
