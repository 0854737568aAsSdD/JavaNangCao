<%@page import="java.util.ArrayList"%>
<%@page import="Bean.SachBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Store</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>    
     <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
    rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style.css">
        
  <style type="text/css">

  
  </style>
</head>
<body>
<%
List<SachBean> ds = (List<SachBean>) request.getAttribute("list"); 
int index = (int) request.getAttribute("pageid");
int dem=0;
%>
    <div class="container">
        <div class="navbar">
            <div class="logo">
                <a href="index.html"><img src="images/logo.png" width="125px"></a>
            </div>
            <nav>
                <ul id="MenuItems">
                    <li><a href="index.html">Home</a></li>
                    <li><a href="products.html">Products</a></li>
                    <li><a href="">About</a></li>
                    <li><a href="">Contact</a></li>
                    <li><a href="account.html">Account</a></li>
                </ul>
            </nav>
            <a href="cart.html"><img src="images/cart.png" width="30px" height="30px"></a>
            <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
        </div>
    </div>
    </div>
    <table>
    <tr>
    <td>
    Xin chao
    <a href="Home"> click me </a>
    </td>
    <td>
    <div class="small-container">
    
    <div class="row">
    <table>
			<%for(int i=0;i<ds.size();i++) { %>
			<tr>
			<%while(dem<ds.size()) {%>
			<div>
							
						<td>
							<div class="col-4">
								<img src="<%=ds.get(dem).getAnh()%>" width="50px"><br><a href="cart?masach=<%= ds.get(dem).getMasach()%>&tensach=<%= ds.get(dem).getTensach()%>&tacgia=<%=ds.get(dem).getTacgia()%>&gia=<%=ds.get(dem).getGia()%>&anh=<%= ds.get(dem).getAnh() %>">">Add to cart</a>
								<p><%= ds.get(dem).getTensach()%></p>
								<p>
									<%=ds.get(dem).getTacgia()%></p>
								<p>
									<%=ds.get(dem).getGia()%></p>
								<div class="rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star-o"></i>
								</div>
								<p><%=ds.get(dem).getGia()%>
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
    </div>
    
    
    
    </td>
    </tr>
    </table>
        <div class="page-btn" style="text-align: center;">    
         <span> <a href="ViewServlet?page=<%= index-1%>">&#8592;</a></span>
            <span><a href="ViewServlet?page=1">1</a></span>
            <span><a href="ViewServlet?page=2">2</a></span>
            <span>....</a></span>
            <span>....</a></span>
            <span>....</a></span>         
            <span><a href="ViewServlet?page=18">18</a></span>
            <span><a href="ViewServlet?page=19">19</a></span>
                
         <span> <a href="ViewServlet?page=<%= index%>">&#8594;</a></span>
        </div>
</body>
</html>