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
            <div class="card">
              <div class="card-body">
                <div class="card-title">Add Product</div>
                <hr>
                <form action="${pageContext.request.contextPath}/admin/product/add" method="post" enctype="multipart/form-data">
                
                  <div class="form-group">
                    <label for="input-1">Title</label>
                    <input type="text" class="form-control" id="input-1" placeholder="Title" name="product-title">
                  </div>
                  <div class="form-group">
                    <label for="input-2">Price</label>
                    <input type="text" class="form-control" id="input-2" placeholder="Price" name="product-price">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Discount</label>
                    <input type="text" class="form-control" id="input-3" placeholder="Discount" name="product-discount">
                  </div>
                  <div class="form-group">
	                  <label for="input-5">Category</label>
	                  <div>
	                    <select class="form-control valid" id="input-5" name="product-cate" aria-invalid="false">
	                    <c:forEach items="${catelist}" var="cate">
	                        <option value="${cate.id }">${cate.name }</option>
	                    </c:forEach>
	                    </select>
	                  </div>
	                </div>
                  <div class="form-group">
                    <label for="input-6">Create At</label> 
                    <input type="date" class="form-control the-date" id="input-6" placeholder="Create At" name="create-at">
                  </div>
                  <div class="form-group">
                    <label for="input-7">Update At</label> 
                    <input type="date" class="form-control the-date" id="input-7" placeholder="Update At" name="update-at">
                  </div>
                  <div class="form-group">
                    <label for="input-8">Availability</label>
                    <div>
                      <select class="form-control valid" id="input-8" name="product-status" required aria-invalid="false">
                          <option value="1">In Stock</option>
                          <option value="0">Out of Stock</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="input-9" class="col-form-label">Description</label>
                    <div>
                      <textarea class="form-control" rows="4" id="input-9" name="product-desc"></textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="input-4">Thumbnail</label>
                    <input type="file" class="form-control" name="product-thumbnail" id="input-4">
                  </div>
                 <div class="form-footer">
                    <button class="btn btn-danger"><i class="fa fa-times"></i><a href="${pageContext.request.contextPath}/admin/product/list">Cancel</a></button>
                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Add</button>
                </div>
                </form>

              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>
<script>
		var date = new Date();
		
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		
		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;
		
		var today = year + "-" + month + "-" + day;
		
		var dateElement = document.querySelectorAll(".the-date");
    for(let i = 0; i < dateElement.length; i++) {
      dateElement[i].value = today;
    }
</script>
<jsp:include page = "./footer/footer.jsp" flush = "true" />