<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="BlueLandApp">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<!-- Common -->
	<script src="https://code.angularjs.org/1.4.7/angular.js"></script>
	<script src="https://code.angularjs.org/1.4.7/angular-route.js"></script>
	<script src="https://code.angularjs.org/1.4.7/angular-messages.js"></script>
	<script src='<c:url value="/static/js/controller/bluelandApp.js"/>'></script>
	<!-- CSS Layer -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

	<!-- HEADER -->
	<div id="header">
		<c:if test="${not empty G1_HEADER_CONTENTS_VIEW_CONTROLLERS}">
			<c:forEach var="controller"
				items="${G1_HEADER_CONTENTS_VIEW_CONTROLLERS}">
				<script
					src='<c:url value="/static/js/controller/${controller}.js"/>'></script>
			</c:forEach>
		</c:if>
		<jsp:include
			page="/WEB-INF/views/includePage/${G1_HEADER_CONTENTS_VIEW_NAME}.jsp"></jsp:include>
	</div>
	<!-- /HEADER -->

	<!-- BODY CONTENTS -->
	<div id="contets">
		<c:if test="${not empty G1_CONTETS_VIEW_CONTROLLERS}">
			<c:forEach var="controller" items="${G1_CONTETS_VIEW_CONTROLLERS}">
				<script
					src='<c:url value="/static/js/controller/${controller}.js"/>'></script>
			</c:forEach>
		</c:if>
		<jsp:include
			page="/WEB-INF/views/includePage/${G1_CONTENTS_VIEW_NAME}.jsp"></jsp:include>
	</div>
	<!-- /BODY CONTENTS -->

	<!-- FOOTER -->
	<div id="footer">
		<c:if test="${not empty G1_FOOTER_CONTENTS_VIEW_CONTROLLERS}">
			<c:forEach var="controller"
				items="${G1_FOOTER_CONTENTS_VIEW_CONTROLLERS}">
				<script
					src='<c:url value="/static/js/controller/${controller}.js"/>'></script>
			</c:forEach>
		</c:if>
		<jsp:include
			page="/WEB-INF/views/includePage/${G1_FOOTER_CONTENTS_VIEW_NAME}.jsp"></jsp:include>
	</div>
	<!-- /FOOTER  -->
</body>
</html>