<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
  response.setHeader("Pragma" , "no-cache");
  response.setHeader("Expires" , "0");
  
  
  if (session.getAttribute("admin-username") == null){
	  response.sendRedirect(request.getContextPath() + "/admin/login");
  }
  %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <!--<div class="col-lg-12">
            <button class="add-catalog"><a href="${pageContext.request.contextPath}/admin/user/add">Thêm User</a></button>
          </div>  -->
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">User List</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">FullName</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone Number</th>
                        <th scope="col">Address</th>
                        <th scope="col">Create At</th>
                        <th scope="col">Update At</th>
                        <th scope="col">Action</th>
                      </tr>
                    </thead>
                    <tbody>
                  <c:forEach items="${userList}" var="user">
                      <tr>
                        <td>${user.fullname}</td>
                        <td>${user.email}</td>
                        <td>${user.phoneNumber}</td>
                        <td>${user.address}</td>
                        <td>${user.createAt}</td>
                        <td>${user.updateAt}</td>
        				        <td>
                          <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/user/delete?user-id=${user.id}">Delete</a></button>
                         
                          <button class="btn btn-success"><a href="${pageContext.request.contextPath}/admin/user/edit?user-id=${user.id}">Edit</a></button>
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
                  <a href="${pageContext.request.contextPath}/admin/user/list?page-id=${i}" class="${pageActive == i ? 'active' : ''}">${i}</a>
              </c:forEach>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>

  
    <jsp:include page = "./footer/footer.jsp" flush = "true" />