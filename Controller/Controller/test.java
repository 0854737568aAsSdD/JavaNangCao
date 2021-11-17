package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.LoaiBean;
import Bean.SachBean;
import Bo.LoaiDatabase;
import Dao.DungChung;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      HttpSession session = request.getSession();
//			try {
//				ArrayList<SachBean> ds = new ArrayList<SachBean>();
//						DungChung dc= new DungChung();
//						dc.KetNoi();
//						Statement statement = dc.cn.createStatement();
//						ResultSet resultSet = statement.executeQuery("select *from sach");
//						{
//							while(resultSet.next())
//					    	{
//								ds.add(new SachBean(resultSet.getString("masach"),
//										resultSet.getString("tensach"),
//										resultSet.getString("tacgia"),
//										resultSet.getLong("gia"),
//										resultSet.getString("anh"),
//										resultSet.getString("maloai")
//										));
//					    	}
//							session.setAttribute("Test", ds);
//						}
//
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//			response.sendRedirect("TestDatabase.jsp");
//		LoaiDatabase loaiDatabase = new LoaiDatabase();
//		ArrayList<LoaiBean> ds = loaiDatabase.getLoaiDatabase();
//		response.getWriter().print(ds.size());
		String tenloaisach = request.getParameter("loaisach");
		response.getWriter().print(tenloaisach);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
