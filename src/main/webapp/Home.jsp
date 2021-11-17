<%@page import="java.util.List"%>
<%@page import="Bean.KhachHangBean"%>
<%@page import="Bean.LoaiBean"%>
<%@page import="java.util.Random"%>
<%@page import="Bean.SachBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Store</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style.css">
</head>
</head>
<body>
	<%
	String kiemtra = (String) request.getAttribute("kiemtra");
	String kiemtra1 = (String) request.getAttribute("kiemtra1");
	List<SachBean> listdatabse = (List<SachBean>) request.getAttribute("loaisachdatabse");
	if (listdatabse == null) {
	}
	ArrayList<LoaiBean> dsloai = (ArrayList<LoaiBean>) request.getAttribute("loai");
	List<SachBean> temp = (List<SachBean>) request.getAttribute("temp");
	List<SachBean> temp1 = (ArrayList<SachBean>) request.getAttribute("temp1");
	int soluongnhe = 0;
	if (session.getAttribute("soluongnhe") != null) {
		soluongnhe = (int) session.getAttribute("soluongnhe");
	}
	int index = (int) request.getAttribute("pageid");
	int soluongsachmaloai = 10;
	if (request.getAttribute("soluongsachmaloai") == null) {
	} else {
		soluongsachmaloai = (int) request.getAttribute("soluongsachmaloai");
	}
	KhachHangBean khbean = (KhachHangBean) session.getAttribute("khachhang");
	String check = (String) request.getAttribute("saithongtin");
	String logout = (String) request.getAttribute("logout");
	//long sosach = (long) request.getAttribute("soluong");
	Random random = new Random();
	int dem = 0;
	//int soluong;
	//if(request.getAttribute("soluongsach") == null)
	//{
	//	soluong=0;
	///}
	//else
	//{
	//soluong = (int) request.getAttribute("soluongsach");
	//}
	%>
	<%
	if (request.getAttribute("signup") != null) {
	%>
	<script>
		window.alert("Bạn đã đăng ký thành công");
	</script>
	<%
	}
	%>

	<%
	if (request.getAttribute("username") != null) {
	%>
	<script>
		window
				.alert("Bạn đã đăng ký thất bại vì trùng username vui lòng đăng ký lại");
	</script>
	<%
	}
	%>


	<div class="header">
		<div class="container">
			<div class="navbar">
				<div class="logo">
					<a href="home"><img
						src="http://www.minhkhai.com.vn/store2/images/minhkhai-logo.png"
						width="400px"></a>
				</div>
				<nav>
					<ul id="MenuItems">
						<li><a href="home">Home</a></li>
						<li><a href="DangNhapAdmin.jsp">Admin</a></li>
						<li><a href="About.jsp">About</a></li>
						<li><a href="LichSuController">History</a></li>
						<li><a href="SignUp.jsp">Account</a></li>
					</ul>
					<%
					if (khbean == null || logout != null) {
					%>
					<ul>
						<li><button type="button" class="btn btn-primary"
								data-toggle="modal" data-target="#myModal">Sign in</button> <!-- The Modal -->
							<div class="modal" id="myModal">
								<div class="modal-dialog">
									<div class="modal-content">

										<!-- Modal Header -->
										<div class="modal-header">
											<p class="modal-title">Sign in</p>
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>

										<!-- Modal body -->
										<div class="modal-body">
											<form action="Cus" method="get">
												<div class="form-group">
													<label for="email">User:</label> <input type="text"
														class="form-control" placeholder="Enter user" id="email"
														name="txtuser">
												</div>
												<div class="form-group">
													<label for="pwd">Password:</label> <input type="password"
														class="form-control" placeholder="Enter password" id="pwd"
														name="txtpwd">
												</div>
												<button type="submit" class="btn btn-primary">Submit</button>
											</form>
										</div>

										<!-- Modal footer -->
										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal">Close</button>
										</div>

									</div>
								</div>
							</div></li>
					</ul>
					<%
					} else {
					%>
					<ul>
						<li><img alt="" src="images/avatar.jpg" width="80px">
							<p>
								Hello ,
								<%=khbean.getHoten()%>
							</p> <a href="Cus?dangxuat=1">Log out</a></li>
					</ul>
					<%
					}
					%>
					<%
					if (check != null) {
					%>
					<script>
						window.alert("Đăng Nhập Sai");
					</script>
					<%
					}
					%>
					<p></p>
					<a href="Cart.jsp"><img src="images/cart.png" width="30px">
					</a>
					<p>
						(<%=soluongnhe%>)
					</p>
			</div>
			<div class="row">
				<div class="col-2">
					<h1>
						Book is mylife<br>And i love it
					</h1>
					<p>Tell me the book you read and I will tell you what kind of
						person you are</p>
					<a href="http://it.husc.edu.vn/gv/nhha/" class="btn">Explore
						Now &#8594;</a>
				</div>
				<div>
					<img
						src="http://static.ybox.vn/2017/3/21/5cade000-0ddd-11e7-a84a-2e995a9a3302.jpg"
						width="800px">
				</div>
			</div>
		</div>
	</div>

	<!-- ------------- featured categorries ---------------- -->
	<div class="categories">
		<div class="small-container">
			<div class="row">
				<div class="col-3">
					<img
						src="https://th.bing.com/th/id/OIP._drYrhs-f_ONkjurM13JAgHaE1?w=300&h=196&c=7&r=0&o=5&pid=1.7">
				</div>
				<div class="col-3">
					<img alt=""
						src="https://file.vfo.vn/hinh/2018/03/hinh-anh-hinh-nen-quyen-sach-dep-nhat-1.jpg">
				</div>
				<div class="col-3">
					<img alt=""
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRiJJWNov73_EVGXvwggWYYXS3JOxkhx3X0Pg&usqp=CAU">
				</div>

			</div>
		</div>

	</div>
	<!-- ------------- featured products ---------------- -->
	<div class="small-container">

		<h2 class="title">Theme Of Book</h2>
		<%
		for (LoaiBean k : dsloai) {
		%>
		<a class="no1" href="home?maloai=<%=k.getMaloai()%>"
			" style="font-size: 18px" data-level="0" data-catid="161"
			style="text-indent: 0px;"><span
			class="glyphicon glyphicon-chevron-right" style="text-indent: 0px"></span><%=k.getTenloai()%></a>
		<hr>
		<%
		}
		%>
		<h2 class="title">Search Book</h2>

		<div class="row">
			<form action="home" method="get">
				<input type="text" name="txttk" placeholder="Write for search">
				<input type="submit" name="tim" value="Search"
					class="btn btn-primary">
			</form>
		</div>
		<h2 class="title">Latest Products</h2>
		<h3 class="title">
			Book Number:
			<%=soluongsachmaloai%>
		</h3>
		<
		<div class="small-container">
			<%
			if (kiemtra == null && kiemtra1 == null) {
			%>
			<div class="row">
				<table>
					<%
					for (int i = 0; i < temp.size(); i++) {
					%>
					<tr>
						<%
						while (dem < temp.size()) {
						%>
						<div>

							<td>
								<div class="col-4">
									<img src="<%=temp.get(dem).getAnh()%>" width="50px"><br>
									<a
										href="cart?masach=<%=temp.get(dem).getMasach()%>&tensach=<%=temp.get(dem).getTensach()%>&tacgia=<%=temp.get(dem).getTacgia()%>&gia=<%=temp.get(dem).getGia()%>&anh=<%=temp.get(dem).getAnh()%>">">Add
										to cart</a>
									<p><%=temp.get(dem).getTensach()%></p>
									<p>
										<%=temp.get(dem).getTacgia()%></p>
									<p>
										<%=temp.get(dem).getGia()%></p>
									<div class="rating">
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star-o"></i>
									</div>
									<p><%=temp.get(dem).getGia()%>
									</p>
								</div>
							</td>


							<%
							dem = dem + 1;
							%>
						</div>
						<%
						if (dem % 3 == 0) {
							break;
						}
						%>

						<%
						}
						%>
					</tr>
					<%
					}
					%>
				</table>
			</div>
			<%
			} else {
			%>

			<div class="row">
				<table>
					<%
					for (int i = 0; i < temp1.size(); i++) {
					%>
					<tr>
						<%
						while (dem < temp1.size()) {
						%>
						<div>

							<td>
								<div class="col-4">
									<img src="<%=temp1.get(dem).getAnh()%>" width="50px"><br>
									<a
										href="cart?masach=<%=temp1.get(dem).getMasach()%>&tensach=<%=temp1.get(dem).getTensach()%>&tacgia=<%=temp1.get(dem).getTacgia()%>&gia=<%=temp1.get(dem).getGia()%>&anh=<%=temp1.get(dem).getAnh()%>">">Add
										to cart</a>
									<p><%=temp1.get(dem).getTensach()%></p>
									<p>
										<%=temp1.get(dem).getTacgia()%></p>
									<p>
										<%=temp1.get(dem).getGia()%></p>
									<div class="rating">
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star-o"></i>
									</div>
									<p><%=temp1.get(dem).getGia()%>
									</p>
								</div>
							</td>


							<%
							dem = dem + 1;
							%>
						</div>
						<%
						if (dem % 3 == 0) {
							break;
						}
						%>

						<%
						}
						%>
					</tr>
					<%
					}
					%>
				</table>
			</div>
			<%
			}
			%>


		</div>

	</div>



	<%
	if (kiemtra == null & kiemtra1 == null) {
	%>
	<div class="page-btn" style="text-align: center;">
		<span> <a href="home?page=<%=index - 1%>">&#8592;</a></span> <span><a
			href="home?page=1">1</a></span> <span><a href="home?page=2">2</a></span> <span>....</a></span>
		<span>....</a></span> <span>....</a></span> <span><a
			href="home?page=18">18</a></span> <span><a href="home?page=19">19</a></span>

		<span> <a href="home?page=<%=index + 1%>">&#8594;</a></span>
	</div>
	<%
	} else if (kiemtra != null)
	try {
		int index1 = (int) request.getAttribute("pageid1");
		String maloai = (String) request.getAttribute("maloai");
		String txttk = (String) request.getAttribute("txttk");
	%>
	<div class="page-btn" style="text-align: center;">
		<span> <a href="home?page1=<%=index1 - 1%>&maloai=<%=maloai%>">&#8592;</a></span>
		<%
		int i = 0;
		soluongsachmaloai = (int) request.getAttribute("soluongsachmaloai");
		while (soluongsachmaloai > 10) {
			i = i + 1;
			soluongsachmaloai = soluongsachmaloai - 10;
		%>
		<span><a href="home?page1=<%=i%>&maloai=<%=maloai%>"><%=i%></a></span>
		<%
		}
		%>
		<%
		if (soluongsachmaloai <= 10) {
		%>
		<span><a href="home?page1=<%=i + 1%>&maloai=<%=maloai%>"><%=i + 1%></a></span>
		<%
		}
		%>

		<span> <a href="home?page1=<%=index1 + 1%>&maloai=<%=maloai%> ">&#8594;</a></span>
		<%
		} catch (Exception e) {
		%>
		<%
		}
		else if (kiemtra1 != null) {
		try {
		int index1 = (int) request.getAttribute("pageid1");
		String txttk = (String) request.getAttribute("txttk");
		%>
		<div class="page-btn" style="text-align: center;">
			<span> <a href="home?page1=<%=index1 - 1%>&txttk=<%=txttk%>">&#8592;</a></span>
			<%
			int i = 0;
			soluongsachmaloai = (int) request.getAttribute("soluongsachmaloai");
			while (soluongsachmaloai > 10) {
				i = i + 1;
				soluongsachmaloai = soluongsachmaloai - 10;
			%>
			<span><a href="home?page1=<%=i%>&txttk=<%=txttk%> "><%=i%></a></span>
			<%
			}
			%>
			<%
			if (soluongsachmaloai <= 10) {
			%>
			<span><a href="home?page1=<%=i + 1%>&txttk=<%=txttk%> "><%=i + 1%></a></span>
			<%
			}
			%>

			<span> <a href="home?page1=<%=index1 + 1%>&txttk=<%=txttk%> ">&#8594;</a></span>
			<%
			} catch (Exception e) {
			%>
			<%
			}
			%>
			<%
			}
			%>
		
</body>
</html>