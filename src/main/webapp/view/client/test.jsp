<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value = "/view/client/assets" var="url"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<img src="${pageContext.request.contextPath}/view/client/assets/img/product/product-3.jpg" width = "200px" height = "200px">
	<c:forEach items = "${listCat}" var = "cat">
		<p>${cat.name}</p>
		<img src="${pageContext.request.contextPath}/view/client/assets/img/categories/${cat.thumbnail}" height = "100px" width = "100px">
	</c:forEach>
	<c:forEach items = "${listPro}" var = "pro">
		<p>${pro.title}</p>
		<img src="${pageContext.request.contextPath}/view/client/assets/img/product/${pro.thumbnail}" height = "100px" width = "100px">
	</c:forEach>
</body>
</html>