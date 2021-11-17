<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
        String tb=(String)request.getAttribute("tb");
       out.print(tb);
    %>
  <hr>Thu vien the:<hr>
 		 ${tb} 
 <hr>   Dung java <br>
    <%
       String[] ht=(String[])session.getAttribute("ht");
       for(String h: ht)
    	   out.print(h);
    %>
  <hr>Thu vien the session: <br>
    <c:forEach items="${sessionScope.ht }" var="h">
         ${h}
     </c:forEach>  
     <hr>   Dung java <br>
<%
       ArrayList<LoaiBean> dsloai=(ArrayList<LoaiBean> )request.getAttribute("dsloai");
       for(LoaiBean L: dsloai)
    	   out.print(L.getMaloai()+":"+L.getTenloai());
    %>
 <hr>Thu vien the session: <br>
     <c:forEach items="${dsloai}" var="L"> 
          ${L.getMaloai() } <hr>
           ${L.getTenloai() } <hr>
     </c:forEach>
</body>
</html>