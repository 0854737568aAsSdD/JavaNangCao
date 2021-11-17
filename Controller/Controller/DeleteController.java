package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.SachBo;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/Delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
    	 String masach = request.getParameter("masach");
         response.getWriter().print(masach);
         SachBo sbo = new SachBo();
         sbo.DeleteSach(masach);
	} catch (Exception e) {
		// TODO: handle exception
	}
      RequestDispatcher rd = request.getRequestDispatcher("Admin");
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
