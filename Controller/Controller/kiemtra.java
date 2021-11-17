package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.KhachHangBean;
import Bo.KhachHangBoDatabase;

/**
 * Servlet implementation class kiemtra
 */
@WebServlet("/kiemtra")
public class kiemtra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kiemtra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("name");
		KhachHangBoDatabase khbo = new KhachHangBoDatabase();
		ArrayList<KhachHangBean> list = khbo.getkhachhang();
	    int n = list.size();
	    System.out.println(n);
	    boolean kt = true;
	    for(int i=0;i<n;i++)
	    {
	    	if(list.get(i).getTendn().equals(username))
	    	{
	    		kt = false;
	    	}
	    }
	    if(kt==true)
	    {
	    	request.setAttribute("kiemtra", "kiemtra");
	    	request.setAttribute("trave", "trave");
	    	request.setAttribute("username", username);
	    }
	    else
	    	if(kt==false)
	    {
	    	request.setAttribute("trave", "trave");
	    	request.setAttribute("kiemtra", null);
	    }
	    RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
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
