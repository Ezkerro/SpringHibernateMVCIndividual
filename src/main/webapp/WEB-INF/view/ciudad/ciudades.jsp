<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring forms :: Ciudades</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><s:message code="title"></s:message></a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<s:url value="/ciudades/" />"
						title="<s:message code="navbar.users"></s:message>"><s:message
								code="navbar.users"></s:message></a></li>
					<li><a href="<s:url value="/ciudades/new" />"
						title="<s:message code="navbar.newUser"></s:message>"><s:message
								code="navbar.newUser"></s:message></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="true"><s:message
								code="navbar.language"></s:message> <span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="?locale=en"><img src="blank.gif"
									class="flag flag-gb"
									alt="<s:message code="english"></s:message>" /> <s:message
										code="english"></s:message></a></li>
							<li><a href="?locale=es"><img src="blank.gif"
									class="flag flag-es"
									alt="<s:message code="spanish"></s:message>" /> <s:message
										code="spanish"></s:message></a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

<div class="container">
<div class="jumbotron">
	<h1><s:message code="listaciudades"></s:message></h1>
	<p><s:message code="mssg"></s:message></p>
</div>
	<table class="table">
		<thead>
			<tr>
				<th><s:message code="nombre"></s:message></th>
				<th><s:message code="cpostal"></s:message></th>
				<th><s:message code="acciones"></s:message></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ciudades}" var="ciudad">
				<tr>
					<td>${ciudad.nombre}</td>
					<td>${ciudad.cpostal}</td>
					<td><a href="<s:url value="/ciudades/${ciudad.id}" />"
						title="Detailed info"><s:message code="verdetalles"></s:message></a> || <a
						href="<c:url value="/ciudades/update/${ciudad.id}" />"><s:message code="actualizar"></s:message></a> || <a
						href="<c:url value="/ciudades/delete/${ciudad.id}" />"><s:message code="borrar"></s:message></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted">&copy; 2017 David Ezquerro</p>
		</div>
	</footer>
	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</body>
</html>