<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="page" tagdir="/WEB-INF/tags"%>


<head>

<title>Оригинальное изображение</title>

</head>
<body>
	<div>
		<h3>Сообщение зашифровано</h3>


		<p>Width:${file.getWidth()}</p>
		<p>Height:${file.getHeight()}</p>
		<p>Защифрованное сообщение:</p> 
		<textarea rows="5" cols="120">${file.getMessage()} </textarea>
		<table>
			<tr>
				<td style="width: 50%">Исходное изображение:</td>
				<td style="width: 50%">Зашифрованное изображение:</td>
			</tr>
			<tr>
				<td><img alt="${file.getPath()}" src="${file.getPath()} "></td>
				<td><img alt="${file.getEncryptedFilePath()}" src="${file.getEncryptedFilePath()} "></td>
			</tr>
		</table>
	</div>
</body>

