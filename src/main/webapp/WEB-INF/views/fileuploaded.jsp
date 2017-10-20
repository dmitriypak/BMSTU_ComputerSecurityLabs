<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>


<head>

<title>Оригинальное изображение</title>
</head>
<body>
	<div>
		<form:form method="post" modelAttribute="uploadedFile" action="encryptMessage">
			<p>Загружен файл: ${originalFile.getOriginalFilename()}!</p>
			<p style="font-weight:600";">Шифруемое сообщение</p>
			<form:textarea placeholder="" path="message" rows="5" cols="100"></form:textarea>
			<p>Оригинальное изображение</p>
			<input type="submit" value="Зашифровать" />
			<p></p>

			<img alt="${uploadedFile.getPath()}" src="${uploadedFile.getPath()}">
		</form:form>	
		
		
	</div>
	
</body>

