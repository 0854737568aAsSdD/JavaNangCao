package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.GioHangBean;
import Bo.GioHangBo;
@WebServlet("/cart")
public class CartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			String a = req.getParameter("masach");
			String b = req.getParameter("tensach");
			String c = req.getParameter("tacgia");
			String d = req.getParameter("gia");
			String e = req.getParameter("anh");
			long giatien = Long.parseLong(d);
			long soluongmua = 1;
			GioHangBo ghbo = new GioHangBo();
			HttpSession session = req.getSession();
			if (session.getAttribute("giohang") == null) {
				ArrayList<GioHangBean> ghbean = new ArrayList<GioHangBean>();
				ghbean.add(ghbo.ThemDanhSach(a, b, c, giatien, soluongmua, giatien * soluongmua, e));
				session.setAttribute("giohang", ghbean);
			} else {
				ArrayList<GioHangBean> giohang = (ArrayList<GioHangBean>) session.getAttribute("giohang");
				int n = giohang.size();
				Boolean check = false;
				for (GioHangBean ghbean : giohang) {
					if (ghbean.getMasach().equals(a)) {
						ghbean.setSlmua(ghbean.getSlmua() + 1);
						check = true;
					}
				}
				if (check == false) {
					giohang.add(ghbo.ThemDanhSach(a, b, c, giatien, soluongmua, giatien * soluongmua, e));

				}
				session.setAttribute("giohang", giohang);
			}

			ArrayList<GioHangBean> giohang = (ArrayList<GioHangBean>) session.getAttribute("giohang");

			long n = ghbo.sotien(giohang);
			session.setAttribute("sotien", n);
			int soluong = giohang.size();
			session.setAttribute("soluongnhe", soluong);
			RequestDispatcher rd = req.getRequestDispatcher("home");
			rd.forward(req, resp);
		} catch (NumberFormatException nfex) {
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
