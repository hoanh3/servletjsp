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
                <div class="card-title">Edit User</div>
                <hr>
                <form action="${pageContext.request.contextPath}/admin/user/edit" method="post">
                  <div class="form-group">
                    <label for="input-1">ID</label>
                    <input type="text" class="form-control" id="input-1" readonly="readonly" placeholder="ID" value="${user.id}" name="user-id">
                  </div>
                  <div class="form-group">
                    <label for="input-2">FullName</label>
                    <input type="text" class="form-control" id="input-2" placeholder="FullName" value="${user.fullname}" name="user-fullname">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Email</label>
                    <input type="text" class="form-control" id="input-3" placeholder="Email" value="${user.email}" name="user-email">
                  </div>
                  <div class="form-group">
                    <label for="input-4">Phone Number</label>
                    <input type="text" class="form-control" id="input-4" placeholder="Phone Number" value="${user.phoneNumber}" name="user-phoneNumber">
                  </div>
                  <div class="form-group">
                    <label for="input-5">Address</label>
                    <input type="text" class="form-control" id="input-5" placeholder="Address" value="${user.address}" name="user-address">
                  </div>
                  <div class="form-group">
                    <label for="myinput">Password</label>
                    <input type="password" class="form-control" id="myinput" placeholder="Mật khẩu" value="${user.password}" name="user-password">
                    <input type="checkbox" onclick="myFunction1()">Show Password
                    <script>function myFunction1() {
                    	  var x = document.getElementById("myinput");
                    	  if (x.type === "password") {
                    	    x.type = "text";
                    	  } else {
                    	    x.type = "password";
                    	  }
                    	}
					          </script>                   
                  </div>
                  <div class="form-group">
                    <label for="input-6">Create At</label>
                    <input type="date" class="form-control" id="input-6" placeholder="Create At" value="${user.createAt}" name="user-createAt">
                  </div>

                  <div class="form-group">
                    <label for="input-7">Update At</label>
                    <input type="date" class="form-control" id="input-7" placeholder="Update At" value="${user.updateAt}" name="user-updateAt">
                  </div>
                  
                  <div class="form-group">
                    <button class="btn btn-danger"><a href="${pageContext.request.contextPath}/admin/user/list">Cancel</a></button>
                         
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