package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.LoaiBean;
import Bo.LoaiBo;

/**
 * Servlet implementation class TauVuTru
 */
@WebServlet("/TauVuTru")
public class TauVuTru extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TauVuTru() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LoaiBo lbo = new LoaiBo();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			if (request.getParameter("masach") != null) {
				String masach = request.getParameter("masach");
				request.setAttribute("masach", masach);
				String tensach = request.getParameter("tensach");
				request.setAttribute("tensach", tensach);
				String soluong = request.getParameter("soluong");
				request.setAttribute("soluong", soluong);
				long gia = Long.parseLong(request.getParameter("gia"));
				request.setAttribute("gia", gia);
				String maloai = request.getParameter("maloai");
				request.setAttribute("maloai", maloai);
				int sotap = Integer.parseInt(request.getParameter("sotap"));
				request.setAttribute("sotap", sotap);
				String anh = request.getParameter("anh");
				request.setAttribute("anh", anh);
				String tacgia = request.getParameter("tacgia");
				request.setAttribute("tacgia", tacgia);
				ArrayList<LoaiBean> lbean = lbo.GetLoai();
				request.setAttribute("loaisach", lbean);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		RequestDispatcher rd = request.getRequestDispatcher("UpdateSachDutru.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
