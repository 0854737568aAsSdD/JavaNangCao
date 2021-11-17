package Controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.AdminBean;
import Bean.LoaiBean;
import Bean.SachBean;
import Bo.AdminBo;
import Bo.LoaiBo;
import Bo.SachBo;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/Admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
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
			LoaiBo lbo = new LoaiBo();
			SachBo sbo = new SachBo();
			ArrayList<LoaiBean> lbean = lbo.GetLoai();
			ArrayList<SachBean> sbean = sbo.getsach();
			String loaisach = request.getParameter("txtloai");
			String timkiem = request.getParameter("txttk");
			request.setAttribute("loaisach", lbean);
			if(loaisach==null)
			{		
			request.setAttribute("tensach", sbean);
            }
			else
			{
				sbean = sbo.getSachTheoTenLoai(loaisach);
				request.setAttribute("tensach", sbean);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
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
