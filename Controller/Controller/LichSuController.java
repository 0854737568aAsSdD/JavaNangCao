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

import Bean.KhachHangBean;
import Bean.LichSuBean;
import Bo.LichSuBo;

/**
 * Servlet implementation class LichSuController
 */
@WebServlet("/LichSuController")
public class LichSuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LichSuController() {
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
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			LichSuBo bo = new LichSuBo();
			HttpSession session = request.getSession();
			KhachHangBean kh = (KhachHangBean) session.getAttribute("khachhang");
			ArrayList<LichSuBean> sbean = bo.getLichSu(kh.getMakh());
			request.setAttribute("history", sbean);

		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher rd = request.getRequestDispatcher("History.jsp");
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
