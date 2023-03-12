<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />

    <div class="content-wrapper">
      <div class="container-fluid">
        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Edit Product</div>
                <hr>
                <form method="post" action="${pageContext.request.contextPath}/admin/product/edit">
                
                 <div class="form-group">
                    <label for="input-1">Product Code</label>
                    <input type="text" class="form-control" readonly="readonly" id="input-1" placeholder="Product Code" name="product-id" value="${product.id}">
                  </div>
                  
                  <div class="form-group">
                    <label for="input-2">Title</label>
                    <input type="text" class="form-control" id="input-2" placeholder="Title" name="product-title" value="${product.title}">
                  </div>
                  <div class="form-group">
                    <label for="input-2">Price</label>
                    <input type="text" class="form-control" id="input-2" placeholder="Price" name="product-price" value="${product.price}">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Discount</label>
                    <input type="text" class="form-control" id="input-3" placeholder="Discount" name="product-discount" value="${product.discount}">
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
                    <input type="date" class="form-control the-date" id="input-6" placeholder="Create At" name="create-at" value="${product.createAt}">
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
                      <textarea class="form-control" rows="4" id="input-9" name="product-desc">${product.description}</textarea>
                    </div>
                  </div>
                  <!-- <div class="form-group">
                    <label for="input-4">Thumbnail</label>
                    <input type="file" class="form-control" name="product-thumbnail" id="input-4">
                  </div> -->
                  <div class="form-footer">
                        <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/product/list">Cancel</a></button>
                            
                        <button type="submit" class="btn btn-success">Update</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>
  
    <jsp:include page = "./footer/footer.jsp" flush = "true" />