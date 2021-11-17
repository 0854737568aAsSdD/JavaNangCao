package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.KhachHangBean;
import Bean.SachBean;
import Dao.DungChung;

/**
 * Servlet implementation class History
 */
@WebServlet("/History")
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public History() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    HttpSession session = request.getSession();
	    KhachHangBean kh = (KhachHangBean) session.getAttribute("khachhang");
	    int[] array = new int[1000];
	    ArrayList<SachBean> sbBeans = new ArrayList<SachBean>();
	    try {
	    	DungChung dc = new DungChung();
	    	dc.KetNoi();
	    	String sql = "select MaHoaDon from hoadon where makh='"+kh.getMakh()+"'";
	    	System.out.println(sql);
	    	Statement statement = dc.cn.createStatement();
	    	ResultSet rs=statement.executeQuery(sql);	
	    	int i=0;
	    	while(rs.next())
	    	{
	    		array[i] = rs.getInt("MaHoaDon");
	    		i++; 		
	    	}
	    	for(int j=0;j<i;j++)
	    	{
	    		String query="select hoadon.NgayMua,ChiTietHoaDon.SoLuongMua,ChiTietHoaDon.masach,tensach,tacgia,gia,maloai,anh,maloai,damua"
	    				+ " from ChiTietHoaDon inner join sach "
	    				+ "on ChiTietHoaDon.MaSach=sach.masach"
	    				+ " inner join hoadon "
	    				+ "on ChiTietHoaDon.MaHoaDon=hoadon.MaHoaDon"	    				
	    				+ " where ChiTietHoaDon.MaHoaDon='"+array[j]+"'";
		    	System.out.println(query);
		    	Statement statement2 = dc.cn.createStatement();
		    	ResultSet resultSet =statement.executeQuery(query);
		    	while(resultSet.next())
		    	{
		    		SachBean sb = new SachBean();
		    		sb.setMasach(resultSet.getString("masach"));
				    sb.setTensach(resultSet.getString("tensach"));
				    sb.setTacgia(resultSet.getString("tacgia"));
				    sb.setAnh(resultSet.getString("anh"));
				    sb.setMaloai(resultSet.getString("maloai"));
				    sb.setGia(resultSet.getLong("gia"));
				    sb.setSoluong(resultSet.getInt("SoLuongMua"));
				    sb.setDate(resultSet.getDate("NgayMua"));
				    sb.setDamua(resultSet.getInt("damua"));
		    		sbBeans.add(sb);		    		
		    	}
	    	}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	    request.setAttribute("history", sbBeans);
	    RequestDispatcher rd = request.getRequestDispatcher("History.jsp");
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
