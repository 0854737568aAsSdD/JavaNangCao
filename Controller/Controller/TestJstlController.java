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

import Bean.SachBean;
import Bo.LoaiBo;
import Bo.SachBo;

/**
 * Servlet implementation class TestJstlController
 */
@WebServlet("/TestJstlController")
public class TestJstlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestJstlController() {
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
			HttpSession session = request.getSession();
			String[] ht = { "hao", "thientruc", "Duc", "Khai" };
			session.setAttribute("ht", ht);
			request.setAttribute("tb", "xin chao");
			LoaiBo lbo = new LoaiBo();
			request.setAttribute("dsloai", lbo.GetLoai());
			SachBo sbo = new SachBo();
			ArrayList<SachBean> ds = sbo.getsach();
			request.setAttribute("sach", ds);
		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher rd = request.getRequestDispatcher("TestJstl.jsp");
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
