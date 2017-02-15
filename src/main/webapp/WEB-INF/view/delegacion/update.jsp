<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Update ciudad delegacion</title>
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
	<h1><s:message code="updateciudaddelegacion"></s:message></h1>
	</div>
	<s:url var="action" value="/delegaciones/saveupdate" />
	<sf:form method="post" action="${action}" modelAttribute="delegacion">
		<sf:hidden path="id" />
		<sf:hidden path="ciudad.id" />
		<div>
			<label for="ciudad"><s:message code="title"></s:message></label>
			<sf:select class="form-control" path="ciudad.id">
				<sf:options items="${ciudad}" itemLabel="nombre" itemValue="id" />
			</sf:select>
		</div>
		<div class="form-group">
			<label for="nombre"><s:message code="nombre"></s:message></label>
			<sf:input class="form-control" path="nombre" placeholder="Name" />
			<sf:errors path="nombre" cssClass="error" />
		</div>
		<div class="form-group">
			<label for="descripcion"><s:message code="descripcion"></s:message></label>
			<sf:textarea class="form-control" path="descripcion" placeholder="Description" />
			<sf:errors path="descripcion" cssClass="error" />
		</div>
		<div class="form-group">
			<label for="direccion"><s:message code="direccion"></s:message></label>
			<sf:textarea class="form-control" path="direccion" placeholder="Direction" />
			<sf:errors path="direccion" cssClass="error" />
		</div>
		<sf:button class="btn btn-success"><s:message code="actualizar"></s:message></sf:button>
	</sf:form>
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
