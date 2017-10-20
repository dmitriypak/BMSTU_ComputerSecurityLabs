<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="page" tagdir="/WEB-INF/tags"%>


<head>

<title>Оригинальное изображение</title>

</head>
<body>
	<div ng-app>
		<form:form method="post" modelAttribute="originalMessage" action="encryptMessage">
			<p>Загружен файл: ${originalFile.getOriginalFilename()}</p>
			<p style="font-weight: 600";">Зашифрованное сообщение: ${uploadedFile.message}</p>
			<table id="table-1" width=100%>
				<tbody>
					<tr>
						<td>Оригинальное изображение</td>
						<td>С зашифрованным текстом</td>
					</tr>
					</tr>
					<td><img width=100% alt="${filename}" src="${uploadedFile.getPath()}" style=""></td>
					<td><img width=100% alt="${filename}" src="${uploadedFile.getPath()}"style=""></td>
					</tr>

				</tbody>
			</table>


		</form:form>
	</div>

</body>

