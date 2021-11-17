
<%@page import="Bean.LoaiBean"%>
<%@page import="Bo.LoaiBo"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Thêm sách</title>
</head>
<body>
	<form class="form-horizontal" action="AddOneBookController"
		method="get" enctype="multipart/form-data">
		<fieldset>

			<!-- Form Name -->
			<legend>Thêm sách</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="txtmasach">Mã
					sách</label>
				<div class="col-md-4">
					<input id="txtmasach" name="txtmasach" placeholder="Mã sách"
						class="form-control input-md" required="" type="text">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="txttensach">Tên
					sách</label>
				<div class="col-md-4">
					<input id="txttensach" name="txttensach" placeholder="Tên sách"
						class="form-control input-md" required="" type="text">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="txtsoluong">Số
					lượng</label>
				<div class="col-md-4">
					<input id="txtsoluong" name="txtsoluong" placeholder="Số lượng"
						class="form-control input-md" required="" type="number">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="txtgia">Giá</label>
				<div class="col-md-4">
					<input id="txtgia" name="txtgia" placeholder="Giá"
						class="form-control input-md" required="" type="number">

				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="txtloai">Thể loại</label>
				<div class="col-md-4">
					<select id="txtloai" name="txtloai" class="form-control">
						<%
						LoaiBo lbo = new LoaiBo();
						ArrayList<LoaiBean> ds = lbo.GetLoai();
						for (LoaiBean l : ds) {
						%>
						<option value="<%=l.getMaloai()%>"><%=l.getTenloai()%></option>
						<%
						}
						%>
					</select>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="txtsotap">Số tập</label>
				<div class="col-md-4">
					<input id="txtsotap" name="txtsotap" placeholder="Số tập"
						class="form-control input-md" required="" type="number">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="txttacgia">Tác
					giả</label>
				<div class="col-md-4">
					<input id="txttacgia" name="txttacgia" placeholder="Tác giả"
						class="form-control input-md" required="" type="text">

				</div>
			</div>

			<!-- File Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="txtfile">Ảnh</label>
				<div class="col-md-4">
					<input id="txtfile" name="txtfile" class="input-file" type="file">
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="ok"></label>
				<div class="col-md-4">
					<input type="submit" id="ok" class="btn btn-primary"
						value="Thêm sách">
				</div>
			</div>

		</fieldset>
	</form>

</body>
</html>