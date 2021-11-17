package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.GioHangBean;
import Bo.GioHangBo;

@WebServlet("/handle")
public class HandleController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		GioHangBo ghbo = new GioHangBo();
		String a = req.getParameter("xoa");
		if (a != null) {
			ArrayList<GioHangBean> ghbean = (ArrayList<GioHangBean>) session.getAttribute("giohang");
			int vitri = Integer.parseInt(a);
			ghbean.remove(vitri);
			long sotien = ghbo.sotien(ghbean);
			session.setAttribute("sotien", sotien);
			session.setAttribute("giohang", ghbean);
            
		}
		
		resp.sendRedirect("Cart.jsp");
	

	}
	

}
