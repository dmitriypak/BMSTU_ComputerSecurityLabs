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
		<form:form method="post" modelAttribute="file">
			<h3>Загружен файл: ${file.getSourceFile().getName()}!</h3>
			<p style="font-weight:600";">Шифруемое сообщение</p>
			<textarea placeholder="Введите сообщение..." name="message" rows="5" cols="100"></textarea>
			<p>Оригинальное изображение</p>
			
			Кол-во бит на пиксель: <form:input path="bitCount" id="bitcount" size="5" value = "1"></form:input>
			<input type="submit" value="Зашифровать" name="_eventId_encryptMessage"/>
			
			<p><img alt="${file.getPath()}" src="${file.getPath()} "></p>
		</form:form>

		
	</div>
	
</body>

