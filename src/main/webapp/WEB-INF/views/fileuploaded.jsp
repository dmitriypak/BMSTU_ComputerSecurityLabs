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
		<p>Загружен файл: ${file.getFile().getOriginalFilename()}!</p>
		<p style="font-weight:600";">Шифруемое сообщение</p>
		<textarea placeholder="" name="message" rows="5" cols="100"></textarea>
		<p>Оригинальное изображение</p>
		<input type="submit" value="Зашифровать" />
		<p></p>
		<img alt="${file.getPath()}" src="${file.getPath()} ">
		

		
	</div>
	
</body>

