<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<script src="https://code.angularjs.org/1.4.7/angular.js"></script>
	<script src="https://code.angularjs.org/1.4.7/angular-route.js"></script>
	<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

	<c:forEach var="controller" items="${G1_CONTETS_VIEW_CONTROLLERS}">
		<script src='<c:url value="/static/js/controller/${controller}.js"/>'></script>
	</c:forEach>
	<!-- HEADER -->
	<div id="header"></div>
	<!-- /HEADER -->
	<!-- BODY CONTENTS -->
	<div id="contets">
		<jsp:include page="/WEB-INF/views/includePage/${G1_CONTENTS_VIEW_NAME}.jsp"></jsp:include>
	</div>
	<!-- /BODY CONTENTS -->
	<!-- FOOTER -->
	<div id="footer"></div>
	<!-- /FOOTER  -->
</body>
</html>