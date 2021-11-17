package Controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.KhachHangBean;
import Bo.KhachHangBo;
import Bo.KhachHangBoDatabase;
import Dao.DungChung;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
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
			HttpSession session = request.getSession();
			KhachHangBoDatabase khbo = new KhachHangBoDatabase();
			ArrayList<KhachHangBean> list = khbo.getkhachhang();
		    int n = list.size();
			String name = request.getParameter("name");
			System.out.println(name);
			int dem =0;
			for(int i=0;i<n;i++)
			{
				if(list.get(i).getTendn().equals(name))
				{
					request.setAttribute("username", "username");	
					dem=1;
				}
			}
			if(dem==0)
			{
			String fullname = request.getParameter("fullname");
			String address = request.getParameter("address");
			String email = request.getParameter("email");    
			String numberphone = request.getParameter("numberphone");
			String password = request.getParameter("pwd");
			DungChung dc = new DungChung();
			dc.KetNoi();
			String sql = "insert into KhachHang( hoten, tendn, pass, diachi, email, sodt) "
					+ "values (N'"+fullname+"',N'"+name+"','"+password+"',N'"+address+"','"+email+"','"+numberphone+"')";	
			System.out.println(sql);
			if(name!=null || password !=null)
			{
				PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
				int x = preparedStatement.executeUpdate();
				request.setAttribute("signup", x);
			}
			}
			RequestDispatcher rd = request.getRequestDispatcher("home");
			rd.forward(request, response);						
		}
	
	catch (Exception e) {
		// TODO: handle exception
	} 
	}
	
      
      	
   


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
