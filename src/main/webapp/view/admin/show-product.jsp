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
          <div class="col-lg-12">
            <button class="add-catalog"><a href="${pageContext.request.contextPath}/admin/product/add">Add Product</a></button>
          </div>
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Product List</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Title</th>
                        <th scope="col">Thumbnail</th>
                        <th scope="col">Category</th>
                        <th scope="col">Price</th>
                        <th scope="col">Discount</th>
                        <th scope="col">Status</th>
                        <th scope="col">Create At</th>
                        <th scope="col">Update At</th>
                        <th scope="col">Action</th>
                      </tr>
                    </thead>
                    <tbody>
                     <c:forEach items="${productList}" var="product">
                      <tr>
                        <th scope="row">${product.id }</th>
                        <td>${product.title }</td>
                        <td><img style="    width: 110px;height: 67px; object-fit: cover;border: 1px solid #fff;" src="${pageContext.request.contextPath}/view/client/assets/img/product/${product.thumbnail}" alt="${product.title}"></td>
                        <td>${product.categoryId.name}</td>
                        <td>${product.price}</td>
                        <td>${product.discount}</td>
                        <td>
                          <c:choose>
                            <c:when test="${product.availability == 1}"> 
                              <c:out value="In Stock"/>
                            </c:when>
                            <c:otherwise>
                              <c:out value="Out of Stock"/>
                            </c:otherwise>
                          </c:choose>
                        </td>
                        <td>${product.createAt}</td>
                        <td>${product.updateAt}</td>
                        <td>
                            <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/product/delete?id=${product.id}">Delete</a></button>
                         
                          <button class="btn btn-success"><a href="${pageContext.request.contextPath}/admin/product/edit?id=${product.id}">Edit</a></button>
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
                  <a href="${pageContext.request.contextPath}/admin/product/list?page-id=${i}" class="${pageActive == i ? 'active' : ''}">${i}</a>
              </c:forEach>
          </div> 
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>

  
    <jsp:include page = "./footer/footer.jsp" flush = "true" />