<%@page import="Bean.KhachHangBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="mystyle.css"> 
  <style type="text/css">
body{
font-family: 'Montserrat', sans-serif;
    font-size: 18px;
}
.navbar{
    display: flex;
    align-items: center;
    padding: 20px;
}
nav{
    flex: 1;
    text-align: right;
}
nav ul{
    display: block;
    list-style-type: none;
}
  </style>
</head>

<body>
<%
KhachHangBean khbean = (KhachHangBean)session.getAttribute("khachhang");
if(khbean==null)
{}
int soluong;
if(request.getAttribute("soluongsach") == null)
{
	soluong=0;
}
else
{
	soluong = (int) request.getAttribute("soluongsach");
	}
	out.print(soluong);
	
	%>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Nhà Sách Minh Khai</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="Demo00.jsp">Home</a></li>
                    <li><a href="Demo00.jsp">Products</a></li>
                    <li><a href="Demo00.jsp">About</a></li>
                    <li><a href="Demo00.jsp">Contact</a></li>
                    <li><a href="Demo00.jsp">Account</a></li>
                    <li> <a href="giohang.jsp"><img src="images/cart.png" width="30px" height="30px"></a></li>
                    
    </ul>
    <%if(khbean!=null){ %>
    <ul> 
					<li> <img alt="" src="images/avatar.jpg" width="80px"> <p>Hello, <%= khbean.getHoten() %> </p>
					<a href="Cus?dangxuat=1">Log out</a>
					 </li>
					</ul>
					<%} %>
  </div>
</nav>

<div margin-left="380px">
<h2 class="gioithieu3">GIỚI THIỆU VỀ NHÀ SÁCH MINH KHAI (CÔNG TY MINH KHAI S.G)</h2>
    <hr width="700px">
    <p class="gioithieu4">
        Từ năm 1998 đến nay, Nhà sách Minh Khai đã và đang tiếp tục nhận được sự tín nhiệm của đông đảo bạn đọc gần xa cũng như sự tín nhiệm của các cơ quan, trường học trong và ngoài nước. Sự tín nhiệm đó chính là nguồn động lực lớn giúp Nhà sách luôn cố gắng hoàn thiện hơn nữa để phục vụ quý khách ngày một tốt hơn.</p>
    <table>
        <tr>   <div class="gioithieu0">
                <img src="http://www.minhkhai.com.vn/store2/images/mk1.jpg" alt="" width="290px">
                <img src="anh trang.png" alt="" width=74px>
                <img src="http://www.minhkhai.com.vn/store2/images/mk2.jpg" alt="" width="290px">
        
            </div></tr>
     <br>
           <tr>
            <div class="gioithieu0">
                <img src="http://www.minhkhai.com.vn/store2/images/mk3.jpg" alt="" width="290px">
                <img src="anh trang.png" alt="" width=74px>
                <img src="http://www.minhkhai.com.vn/store2/images/mk4.jpg" alt="" width="290px">
            
                </div>

           </tr>
            

    </table>
        <p class="gioithieu4">Với tổng diện tích 1.200m2, không gian rộng rãi, trang bị máy lạnh thoáng mát, đội ngũ nhân viên phục vụ ân cần. Chủng loại sách phong phú với khoảng 35.000 đầu sách, đa dạng các mặt hàng: Văn phòng phẩm, Dụng cụ học sinh, Băng đĩa, Quà lưu niệm, Đồ chơi, …

            Nhà sách Minh Khai chuyên cung cấp sỉ và lẻ các mặt hàng sau tại chỗ hoặc tận nơi theo yêu cầu, nhanh chóng và tiện lợi:</p>
<ul class="gioithieu1">
<li>Sách</li>
<li>Báo và Tạp chí</li>
<li>Băng đĩa nhạc</li>
<li>Văn phòng phẩm và quà tặng, lưu niệm, ...</li>

</ul>
<table>
    <tr>
        <div class="gioithieu0">
            <img src="http://www.minhkhai.com.vn/store2/images/mk5.jpg" alt="" width="290px">
            <img src="anh trang.png" alt="" width=74px>
            <img src="http://www.minhkhai.com.vn/store2/images/mk6.jpg" alt="" width="290px">
        
            </div>

       </tr>
</table>
<p class="gioithieu4">Khi đặt mua hàng tại nhà sách của chúng tôi, quý khách sẽ giảm được khá nhiều những chi phí vì được hưởng các loại hình dịch vụ miễn phí và Quý khách còn được hưởng chiết khấu cao. Ngoài việc cung cấp sỉ và lẻ các mặt hàng phong phú như trên, Nhà sách Minh Khai còn phục vụ Quý khách các dịch vụ sau:
</p>     
<ul class="gioithieu1">
    <li>• Dịch vụ bán hàng qua mạng Internet (giao hàng tận nơi)</li>
</ul>  
<p class="gioithieu4">Thăm website minhkhai.vn, Quý khách có thể lựa chọn và đặt mua những loại Sách, Báo & Tạp chí, Băng Đĩa, Văn Phòng Phẩm, Quà lưu niệm, ... mà mình cần.
</p>
<table>
    <tr>
        <div class="gioithieu0">
            <img src="http://www.minhkhai.com.vn/store2/images/mk7.jpg" alt="" width="290px">
            <img src="anh trang.png" alt="" width=74px>
            <img src="http://www.minhkhai.com.vn/store2/images/mk8.jpg" alt="" width="290px">
        
            </div>

       </tr>
</table>
<p class="gioithieu4">Đặc biệt, Nhà sách Minh Khai còn liên kết với Amazon.com để phục vụ nhu cầu mua sách ngoại văn thuộc các thể loại, chuyên đề khác nhau.
	
    Khi mua sách ngoại văn từ Amazon.com thông qua minhkhai.vn, Quý khách sẽ tiết kiệm được khá nhiều tiền bạc và thời gian. Hình thức thanh toán: Tiền mặt hoặc Chuyển khoản hoặc thẻ Tín dụng.
    
    Chúng tôi sẽ giao đủ chủng loại và số lượng mà khách yêu cầu với đầy đủ chứng từ hợp lệ. Với phương châm: Càng ngày càng phục vụ khách hàng tốt hơn, nhà sách Minh Khai chúng tôi rất hân hạnh được đáp ứng những yêu cầu của quý khách.</p>
 <center>
        Các bạn muốn biết thêm thông tin, xin liên hệ địa chỉ:

<br><b>Công ty TNHH Minh Khai S.G </b>
<br>249 - Nguyễn Thị Minh Khai, phường Nguyễn Cư Trinh, Quận 1 
<br>TP. Hồ Chí Minh - Việt Nam
<br>Tel: 08 39 250 590 – 08 39 250 591 (Xin số 38 - Gặp bộ phận bán hàng qua mạng)
<br>E-mail:  mk.book@minhkhai.vn - mk.book@minhkhai.com.vn
        </center>

        <center>
            <br>
            <img src="http://www.minhkhai.com.vn/store2/images/paymentall.png"> <br><br>
            
            <b>Copyright @1999-2020 MINHKHAI.VN All rights Reserved.</b> <br>
                        Công Ty TNHH Minh Khai S.G (Nhà sách Minh Khai) <br>249 Nguyễn Thị Minh Khai, F. Nguyễn Cư Trinh, Q.1, Tp. Hồ Chí Minh<br>
        	                Giấy chứng nhận đăng ký kinh doanh số: 4102019159<br>
            Mã số doanh nghiệp 0303209716 - Đăng ký thay đổi lần 6 ngày 30/07/2010<br>
                                 Ðiện Thoại (028)39250590 - (028)39250591 -Fax: (028)39257837<br>
            
            
            Website: <a href="http://www.minhkhai.vn">www.minhkhai.vn</a> và <a href="http://www.minhkhai.com.vn">www.minhkhai.com.vn</a><br>
                                    E-mail: <b>mk.book@minhkhai.com.vn</b> <br></center>

   
   </td>
   </div>
   
</body>
</html>