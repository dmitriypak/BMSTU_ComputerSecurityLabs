<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>


<head>

<title>Загруженное изображение</title>
</head>
<body>
	<div>
		<form:form method="post" modelAttribute="file">
			<h3>Загружен файл: ${file.getSourceFile().getName()}!</h3>
			<input type="submit" value="Расшифровать" name="_eventId_decryptMessage"/>
			
			<p><img alt="${file.getPath()}" src="${file.getPath()} "></p>
		</form:form>

		
	</div>
	
</body>

