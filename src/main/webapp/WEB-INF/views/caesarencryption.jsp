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
	<form:form method="POST" modelAttribute="message">
		<fieldset>
			<p style="font-weight: bold">Сообщение:</p>
			<form:textarea path="message" id="message" rows="5" cols="100" />
			<p style="font-weight: bold">Сдвиг:</p>
			<form:input path="shift" id="shift" value = "3"></form:input>
			<input class="btn btn-success" type="submit" value="Зашифровать" name="_eventId_encrypt" />					
			
			
			<p style="font-weight: bold">Зашифрованное сообщение:</p>
			<form:textarea path="encmessage" id="encmessage" rows="5" cols="100" />
		</fieldset>
		
		
		<footer>
		
		</footer>
		
	</form:form>

	<%-- <P>  The time on the server is ${serverTime}. </P> --%>
</body>
</html>
