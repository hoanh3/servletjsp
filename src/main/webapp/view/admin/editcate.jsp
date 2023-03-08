<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Edit Category</div>
                <hr>
          	
	                <form action="${pageContext.request.contextPath}/admin/cate/edit" method="post">
	                  <div class="form-group">
	                    <label for="input-1">ID</label>
	                    <input type="text" class="form-control" readonly id="input-1" placeholder="ID" name="cate-id" value="${category.id}">
	                  </div>
	                  <div class="form-group">
	                    <label for="input-2">Name</label>
	                    <input type="text" class="form-control" id="input-2" placeholder="Name" name="cate-name" value="${category.name}">
	                  </div>
					  <div class="form-group">
	                    <label for="input-3">Thumbnail</label>
	                    <input type="text" class="form-control" id="input-3" placeholder="Name" name="cate-thumbnail" value="${category.thumbnail}">
	                  </div>
	                  <div class="form-footer">
	                      <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/cate/list">Cancel</a></button>
                         
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