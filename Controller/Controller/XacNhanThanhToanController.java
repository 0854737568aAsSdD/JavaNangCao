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
import Bo.XacNhanThanhToanBo;

/**
 * Servlet implementation class XacNhanThanhToanController
 */
@WebServlet("/XacNhanThanhToanController")
public class XacNhanThanhToanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XacNhanThanhToanController() {
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
			HttpSession session = request.getSession();
			XacNhanThanhToanBo xacnhan = new XacNhanThanhToanBo();
			KhachHangBean kh = (KhachHangBean) session.getAttribute("khachhang");
			xacnhan.XacNhanThanhToan(kh.getMakh());
		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher rd = request.getRequestDispatcher("LichSuController");
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
