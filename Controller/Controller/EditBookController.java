package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditBookController
 */
@WebServlet("/Edit")
public class EditBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("masach")!=null) {
			String masach = request.getParameter("masach");
			request.setAttribute("masach", masach);
			String tensach = request.getParameter("tensach");
			request.setAttribute("tensach", tensach);
			String soluong = request.getParameter("soluong");
			request.setAttribute("soluong", soluong);
			long gia = Long.parseLong(request.getParameter("gia"));
			request.setAttribute("gia", gia);
			String anh = request.getParameter("anh");
			request.setAttribute("anh", anh);
			String tacgia = request.getParameter("tacgia");
			request.setAttribute("tacgia", tacgia);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("suasach.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
