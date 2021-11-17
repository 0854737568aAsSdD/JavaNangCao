<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Contact V4</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor1/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor1/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor1/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor1/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor1/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor1/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>


	<div class="container-contact100">
		<div class="wrap-contact100">
			<form class="contact100-form validate-form"
				action="UpdateOneBookController" method="post"
				enctype="multipart/form-data">
				<span class="contact100-form-title"> Sửa Sách </span>
				<div>
					<c:if test="${suasach !=null}">
						<h3 style="color: red; font-family: serif; font-size: 20px;">
							Update Book Complete!</h3>
						<a href="Admin"> Back To Admin Page!</a>
					</c:if>
				</div>

				<div class="wrap-input100 validate-input"
					data-validate="Name is required">
					<span class="label-input100">Mã Sách</span> <input id="txtmasach"
						name="txtmasach" placeholder="Mã sách" class="input100"
						required="" type="text" value='<c:out value="${masach }"></c:out>'>
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input"
					data-validate="Name is required">
					<span class="label-input100">Tên Sách</span> <input id="txtmasach"
						name="txttensach" placeholder="Tên Sách" class="input100"
						required="" type="text"
						value='<c:out value="${tensach }"></c:out>'> <span
						class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input"
					data-validate="Name is required">
					<span class="label-input100">Tác Giả</span> <input id="txttacgia"
						name="txttacgia" placeholder="Tác giả" class="input100"
						required="" type="text" value='<c:out value="${tacgia }"></c:out>'>
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input"
					data-validate="Name is required">
					<span class="label-input100">Giá</span> <input id="txtgia"
						name="txtgia" placeholder="Giá" class="input100" required=""
						type="number" value='<c:out value="${gia }"></c:out>'> <span
						class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input"
					data-validate="Name is required">
					<span class="label-input100">Số Lượng</span> <input id="txtsoluong"
						name="txtsoluong" placeholder="Số lượng" class="input100"
						required="" type="number"
						value='<c:out value="${soluong }"></c:out>'> <span
						class="focus-input100"></span>
				</div>
				<div class="wrap-input100 input100-select">
					<span class="label-input100">Thể Loại</span>
					<div>
						<select class="selection-2" name="service"
							onchange="genderChanged(this)">
							<option selected>Chọn loại sách</option>
							<c:forEach items="${loaisach}" var="l">
								<option value="${l.getMaloai() }"><c:out
										value="${l.getTenloai() }"></c:out></option>
							</c:forEach>
						</select>
					</div>
					<script language="javascript">
						function genderChanged(obj) {
							var value = obj.value;
							result.value = value;
						}
					</script>
					<span class="focus-input100"></span> <input type="hidden"
						id="result" value="" name="txtloai" class="input100" />
				</div>

				<div class="wrap-input100 validate-input"
					data-validate="Name is required">
					<span class="label-input100">Số Tập</span> <input id="txtsotap"
						name="txtsotap" placeholder="Số tập" class="input100" required=""
						type="text" value='<c:out value="${sotap }"></c:out>'> <span
						class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input"
					data-validate="Name is required">
					<span class="label-input100">Ảnh</span> <img alt=""
						src="<c:out value="${anh}"></c:out>" style="width: 75px"> <input
						id="txtfile" name="txtfile" placeholder="Ảnh" class="input100"
						required="" type="file"> <span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn">
							<span> Submit <i class="fa fa-long-arrow-right m-l-7"
								aria-hidden="true"></i>
							</span>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>



	<div id="dropDownSelect1"></div>


</body>
</html>
>
