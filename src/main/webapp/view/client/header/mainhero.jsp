<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<c:url value = "/view/client/assets" var="url"/>

<div class="container">
    <div class="row">
        <div class="col-lg-3">
            <div class="hero__categories">
                <div class="hero__categories__all">
                    <i class="fa fa-bars"></i>
                    <span>All departments</span>
                </div>
                <ul>
                    <c:forEach items = "${listCat}" var = "cat">
                        <li class="t-capitalize"><a href="${pageContext.request.contextPath}/category?catId=${cat.id}">${cat.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-lg-9">
            <div class="hero__search">
                <div class="hero__search__form">
                    <!-- <form action="${pageContext.request.contextPath}/search" method="get">
                        <div class="hero__search__categories">
                            All Categories
                            <span class="arrow_carrot-down"></span>
                        </div>
                        <input type="text" placeholder="What do yo u need?" id = "searchStr" name="searchStr">
                        <button type="submit" class="site-btn">SEARCH</button>
                    </form> -->
                </div>
                <div class="hero__search__phone">
                    <div class="hero__search__phone__icon">
                        <i class="fa fa-phone"></i>
                    </div>
                    <div class="hero__search__phone__text">
                        <h5>+65 11.188.888</h5>
                        <span>support 24/7 time</span>
                    </div>
                </div>
            </div>