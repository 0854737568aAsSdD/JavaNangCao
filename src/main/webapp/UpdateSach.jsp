<%@page import="Bean.LoaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.LoaiBo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Sửa sách</title>
</head>
<body>
<form class="form-horizontal" action="UpdateSachController" method="post" enctype="multipart/form-data">
<fieldset>

<!-- Form Name -->
<legend>Chỉnh sửa thông tin sách</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="txtmasach">Mã sách</label>  
  <div class="col-md-4">
  <input id="txtmasach" name="txtmasach" readonly="readonly" value="<%=request.getAttribute("masach")%>" placeholder="Mã sách" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="txttensach">Tên sách</label>  
  <div class="col-md-4">
  <input id="txttensach" name="txttensach" value="<%=request.getAttribute("tensach")%>" placeholder="Tên sách" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="txtsoluong">Số lượng</label>  
  <div class="col-md-4">
  <input id="txtsoluong" name="txtsoluong" value="<%=request.getAttribute("soluong")%>" placeholder="Số lượng" class="form-control input-md" required="" type="number">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="txtgia">Giá</label>  
  <div class="col-md-4">
  <input id="txtgia" name="txtgia" value="<%=request.getAttribute("gia")%>" placeholder="Giá" class="form-control input-md" required="" type="number">
    
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
          for(LoaiBean l: ds){%>
          		<option  value="<%=l.getMaloai()%>" <%if(l.getMaloai().equals(request.getAttribute("maloai"))){%> selected="selected"<%}%>><%=l.getTenloai()%></option>
          <%} %>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="txtsotap">Số tập</label>  
  <div class="col-md-4">
  <input id="txtsotap" name="txtsotap" value="<%=request.getAttribute("sotap")%>" placeholder="Số tập" class="form-control input-md" required="" type="number">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="txttacgia">Tác giả</label>  
  <div class="col-md-4">
  <input id="txttacgia" name="txttacgia" value="<%=request.getAttribute("tacgia")%>" placeholder="Tác giả" class="form-control input-md" required="" type="text">
    
  </div>
</div>

 <!-- img input -->
<div class="form-group">
  <label class="col-md-4 control-label" for="txtfile">Ảnh</label>
  <div class="col-md-4">
  	<input id="txtanh" name="txtanh" type="hidden" value="<%=request.getAttribute("anh")%>">
    <img id="img" name="oldimg" src="<%=request.getAttribute("anh")%>" style="height: 100px; width: 70px;">
  </div>
</div> 

 <!-- File Button --> 
<div class="form-group">
  <label class="col-md-4 control-label" for="txtfile">Thay Đổi Ảnh</label>
  <div class="col-md-4">
    <input id="txtfile" name="txtfile" class="input-file" type="file" >
  </div>
</div>

<!-- Button -->
<div class="form-group">
	<label class="col-md-4 control-label" for="ok"></label>
  <div class="col-md-4">
    <input type="submit" id="ok" class="btn btn-primary" value="Lưu" onclick="getSrc()">
    <a href="admincontroller"><input class="btn btn-primary" type="button" value="Hủy bỏ"></a>
  </div>
</div>

</fieldset>
</form>
   
</body>
</html>