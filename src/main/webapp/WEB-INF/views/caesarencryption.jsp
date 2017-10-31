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
	<div style="margin-left: 5%">
		<form:form method="POST" modelAttribute="message" >
			<fieldset>
				<p style="font-weight: bold;margin-left: 0px">Исходное сообщение:</p>
				<form:textarea path="message" id="message" rows="5" cols="100" />
				<p style="font-weight: bold;margin-left: 0px">Сдвиг:</p>
				<input class="btn btn-success" type="submit" value="&larr;Зашифровать" name="_eventId_encryptLeft" />	
				<form:input path="shift" id="shift" value = "3" size="5"></form:input>
				
				<input class="btn btn-success" type="submit" value="Зашифровать&rarr;" name="_eventId_encryptRight" />		
				<p style="font-weight: bold;margin-left: 0px">Кол-во сдвигов:</p>			
				<label style="color: blue;margin-left: 0px; font-size: 14px">${message.getCountShifts()} </label>
				
				<p style="font-weight: bold;margin-left: 0px">Зашифрованное сообщение:</p>
				<form:textarea path="encmessage" id="encmessage" rows="5" cols="100" />
			</fieldset>
		</form:form>
	</div>

	<%-- <P>  The time on the server is ${serverTime}. </P> --%>
</body>
</html>
