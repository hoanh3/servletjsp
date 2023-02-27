<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<c:url value = "/view/client/assets" var="url"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<!-- <c:forEach items = "${listCat}" var = "cat">
		<c:set var = "str" value = "${cat.name}"/>
		<c:set var = "catName" value = "${fn:split(str, ' ')}"/>
		<c:set var = "catNames" value = "${fn:join(catName, '-')}"/>
		<p>${catNames}</p>
	</c:forEach> -->


	<!-- <c:forEach items = "${listCat}" var = "cat">
		<p>${cat.name}</p>
		<img src="${pageContext.request.contextPath}/view/client/assets/img/categories/${cat.thumbnail}" height = "100px" width = "100px">
	</c:forEach> -->
	<c:forEach items = "${listPro}" var = "pro" begin = "0" end = "2">
		<p>${pro.title}</p>
		<img src="${pageContext.request.contextPath}/view/client/assets/img/product/${pro.thumbnail}" height = "100px" width = "100px">
	</c:forEach>
	<c:forEach items = "${listPro}" var = "pro" begin = "3" end = "5">
		<p>${pro.title}</p>
		<img src="${pageContext.request.contextPath}/view/client/assets/img/product/${pro.thumbnail}" height = "100px" width = "100px">
	</c:forEach>
</body>
</html>