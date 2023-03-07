<%@page import="java.sql.ResultSet"%>
<%@page import="webdemo.mvc.context.DBContext"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <!-- <%
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
  response.setHeader("Pragma" , "no-cache");
  response.setHeader("Expires" , "0");
  
  
  if (session.getAttribute("admin-username") == null){
	  response.sendRedirect(request.getContextPath() + "/admin/login"); 
  }
  %> -->
  <!-- Start header section --> 
  <jsp:include page = "./header/header.jsp" flush = "true" /> 
    <div class="content-wrapper"> 
      <div class="container-fluid"> 
        <!--End Row--> 
 
 
        <div class="row"> 
          <div class="col-lg-12"> 
            <button class="add-catalog"><a href="${pageContext.request.contextPath}/admin/admin/add">Add Admin</a></button> 
          </div> 
          <div class="col-lg-12"> 
            <div class="card"> 
              <div class="card-body"> 
                <h5 class="card-title">Admin List</h5> 
                <div class="table-responsive">              
                  <table class="table table-striped"> 
                    <thead> 
                      <tr> 
                        <th scope="col">Email</th> 
                        <th scope="col">Name</th>
                        <th scope="col">Action</th>                        
                     </tr> 
                    </thead> 
                    <tbody> 
                  <c:forEach items="${adminList}" var="admin"> 
                      <tr>
                        <td>${admin.email}</td> 
        				        <td>${admin.name}</td> 
        				        <td> 
                           <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/admin/delete?admin-id=${admin.id}">Delete</a></button>
              
                          <button class="btn btn-success"><a href="${pageContext.request.contextPath}/admin/admin/edit?id=${admin.id}">Edit</a></button>
                        </td> 
                     </tr> 
                    </c:forEach> 
                    </tbody> 
                  </table> 
                </div> 
              </div> 
            </div> 
          </div>
          <div class="col-lg-12"> 
            <div class="product__pagination">
              <c:forEach begin = "1" end = "${endPage}" var = "i">
                  <a href="${pageContext.request.contextPath}/admin/admin/list?page-id=${i}" class="${pageActive == i ? 'active' : ''}">${i}</a>
              </c:forEach>
          </div> 
          </div> 
        </div> 
      </div> 
    </div> 
  
    <jsp:include page = "./footer/footer.jsp" flush = "true" />