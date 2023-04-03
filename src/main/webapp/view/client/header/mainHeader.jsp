<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="webdemo.mvc.models.Cart" %>
<c:url value="/view/client/assets" var="url" />

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ogani | Template</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
            rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="${url}/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="${url}/css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="${url}/css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="${url}/css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="${url}/css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="${url}/css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="${url}/css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="${url}/css/style.css" type="text/css">
        <link rel="stylesheet" href="${url}/css/custom.css" type="text/css">
    </head>
    <body>
        <%
            Object object=session.getAttribute("cart");
            Cart cart=null;
            if(object !=null) {
                cart=(Cart) object;
            }else {
                cart=new Cart();
            }
            String cartSize=String.valueOf(cart.getCartSize());
            String cartTotalMoney=String.valueOf(cart.getTotalMoney());
            session.setAttribute("cartSize", cartSize);
            session.setAttribute("cartTotalMoney", cartTotalMoney);
            out.println("<input type='hidden' id='cartSize' name='cartSize' value='"+ cartSize +"'>");
            out.println("<input type='hidden' id='cartTotalMoney' name='cartTotalMoney' value='"+ cartTotalMoney +"'>");
        %>
        <!-- <c:set var="cartSize" scope="session" value="${}"/>
        <c:set var="cartTotalMoney" scope="session" value="${}"/> -->
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Humberger Begin -->
        <div class="humberger__menu__overlay"></div>
        <div class="humberger__menu__wrapper">
            <div class="humberger__menu__logo">
                <a href=""><img src="${url}/img/logo.png" alt=""></a>
            </div>
            <div class="humberger__menu__cart">
                <ul>
                    <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                    <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>${sessionScope.cartSize}</span></a></li>
                </ul>
                <div class="header__cart__price">item: <span>${sessionScope.cartSize}</span></div>
            </div>
            <div class="humberger__menu__widget">
                <div class="header__top__right__language">
                    <img src="${url}/img/language.png" alt="">
                    <div>English</div>
                    <span class="arrow_carrot-down"></span>
                    <ul>
                        <li><a href="#">Spanis</a></li>
                        <li><a href="#">English</a></li>
                    </ul>
                </div>
                <div class="header__top__right__auth">
                    <c:if test = "${sessionScope.user != null}">
                        <a href="${pageContext.request.contextPath}/logout"><i class="fa fa-user"></i> Logout</a>
                    </c:if>
                    <c:if test = "${sessionScope.user == null}">
                        <a href="${pageContext.request.contextPath}/login"><i class="fa fa-user"></i> Login</a>
                    </c:if>
                </div>
            </div>
            <nav class="humberger__menu__nav mobile-menu">
                <ul>
                    <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/shop">Shop</a></li>
                    <li><a href="#">Pages</a>
                        <ul class="header__menu__dropdown">
                            <li><a href="./shop-details.html">Shop Details</a></li>
                            <li><a href="${pageContext.request.contextPath}/shopcart">Shoping Cart</a></li>
                            <li><a href="./checkout.html">Check Out</a></li>
                            <li><a href="./blog-details.html">Blog Details</a></li>
                        </ul>
                    </li>
                    <li><a href="./blog.html">Blog</a></li>
                    <li><a href="./contact.html">Contact</a></li>
                </ul>
            </nav>
            <div id="mobile-menu-wrap"></div>
            <div class="header__top__right__social">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-linkedin"></i></a>
                <a href="#"><i class="fa fa-pinterest-p"></i></a>
            </div>
            <div class="humberger__menu__contact">
                <ul>
                    <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                    <li>Free Shipping for all Order of $99</li>
                </ul>
            </div>
        </div>
        <!-- Humberger End -->

        <!-- Header Section Begin -->
        <header class="header">
            <div class="header__top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__left">
                                <ul>
                                    <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                                    <li>Free Shipping for all Order of $99</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__right">
                                <div class="header__top__right__social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                    <a href="#"><i class="fa fa-pinterest-p"></i></a>
                                </div>
                                <div class="header__top__right__language">
                                    <img src="${url}/img/language.png" alt="">
                                    <div>English</div>
                                    <span class="arrow_carrot-down"></span>
                                    <ul>
                                        <li><a href="#">Spanis</a></li>
                                        <li><a href="#">English</a></li>
                                    </ul>
                                </div>
                                <div class="header__top__right__auth">
                                    <c:if test = "${sessionScope.user != null}">
                                        <a href="logout"><i class="fa fa-user"></i> Logout</a>
                                    </c:if>
                                    <c:if test = "${sessionScope.user == null}">
                                        <a href="login"><i class="fa fa-user"></i> Login</a>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <a href=""><img src="${url}/img/logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                            <ul>
                                <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                                <li><a href="${pageContext.request.contextPath}/shop">Shop</a></li>
                                <li><a href="#">Pages</a>
                                    <ul class="header__menu__dropdown">
                                        <li><a href="./shop-details.html">Shop Details</a></li>
                                        <li><a href="${pageContext.request.contextPath}/shopcart">Shoping Cart</a></li>
                                        <li><a href="./checkout.html">Check Out</a></li>
                                        <li><a href="./blog-details.html">Blog Details</a></li>
                                    </ul>
                                </li>
                                <li><a href="./blog.html">Blog</a></li>
                                <li><a href="./contact.html">Contact</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                        <div class="header__cart">
                            <ul>
                                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                                <li><a href="${pageContext.request.contextPath}/shopcart"><i class="fa fa-shopping-bag"></i> <span class="cartSize">${sessionScope.cartSize}</span></a></li>
                            </ul>
                            <div class="header__cart__price">item: <span class="cartPrice">${sessionScope.cartSize}</span></div>
                        </div>
                    </div>
                </div>
                <div class="humberger__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
        <!-- Header Section End -->