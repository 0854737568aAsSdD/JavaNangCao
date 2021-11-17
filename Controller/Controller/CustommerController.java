package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.KhachHangBean;
import Bo.KhachHangBo;
import Bo.KhachHangBoDatabase;

@WebServlet("/Cus")
public class CustommerController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  try {
		  req.setCharacterEncoding("utf-8");
		  resp.setCharacterEncoding("utf-8");
		  HttpSession session = req.getSession();
		  String user = req.getParameter("txtuser");
		  String pwd = req.getParameter("txtpwd");
		  if(req.getParameter("dangxuat")==null)
		  {
			  KhachHangBo khbo = new KhachHangBo();
			  KhachHangBean khachhang = khbo.check(user, pwd);
				  session.setAttribute("khachhang", khachhang);
				  if(khachhang==null)
				  {
					  if(user !=null || pwd !=null)
					  {
						  req.setAttribute("saithongtin", "saithongtin");	  
					  }
				  }
				  else
				  {
					  session.setAttribute("giohang", null);
					  session.setAttribute("soluongnhe", null);
				  }
			
		  }
		  else
		  {
			  KhachHangBo khbo = new KhachHangBo();
			  KhachHangBean khachhang = new KhachHangBean();
			  khachhang=null;
			  session.setAttribute("khachhang", khachhang);
			  req.setAttribute("logout", "logout");
		  }
			   RequestDispatcher rd = req.getRequestDispatcher("/home");
				rd.forward(req, resp);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
