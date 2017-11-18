<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Лабораторные работы по Компьютерной безопасности</title>
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet"></link>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h2 class="display-3">Компьютерная безопасность</h2>
			<p class="lead">Лабораторные работы Пак Д.В. ВИУ7-88</p>
		</div>
	</div>

	<div class="list-group">
		<a href="${flowExecutionUrl}&_eventId=caesarencryptionPage"
			class="list-group-item list-group-item-action">Лабораторная	работа №1. Шифр Цезаря </a> 
		<a	href="${flowExecutionUrl}&_eventId=lsbencryptionPage"
			class="list-group-item list-group-item-action">Лабораторная	работа №2. Стеганография в графических файлах. Шифрофание	сообщения.</a>
		<a	href="${flowExecutionUrl}&_eventId=lsbdecryptionPage"
			class="list-group-item list-group-item-action">Лабораторная	работа №3. Расшифровка сообщения в изображении.</a>
	</div>

</body>
</html>
