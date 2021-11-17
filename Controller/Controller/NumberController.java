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

@WebServlet("/number")
public class NumberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GioHangBo ghbo = new GioHangBo();
		HttpSession session = req.getSession();
		String txtvitri = req.getParameter("vitri");
		String txtsoluong = req.getParameter("soluong");
		int vitri = Integer.parseInt(txtvitri);
		long soluong = Long.parseLong(txtsoluong);
		ArrayList<GioHangBean> ghbean = (ArrayList<GioHangBean>) session.getAttribute("giohang");
		ghbean.get(vitri).setSlmua(soluong);
		long sotien = ghbo.sotien(ghbean);
		session.setAttribute("sotien", sotien);
		session.setAttribute("giohang", ghbean);
		resp.sendRedirect("Cart.jsp");
	}
}
