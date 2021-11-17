package Controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.IntBinaryOperator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.GioHangBean;
import Bean.KhachHangBean;
import Dao.DungChung;

/**
 * Servlet implementation class DatHang
 */
@WebServlet("/DatHang")
public class DatHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		KhachHangBean kh = (KhachHangBean) session.getAttribute("khachhang");
		if (kh == null) {
			request.setAttribute("xacnhan", "xacnhan");
		} else {
			try {
				ArrayList<GioHangBean> ghbean = (ArrayList<GioHangBean>) session.getAttribute("giohang");
				DungChung dc = new DungChung();
				dc.KetNoi();
				int n = ghbean.size();
				int x = 0;
				int a = 0;
				Date date = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
				String sql = " insert into hoadon(makh,NgayMua,damua) " + "values('" + kh.getMakh() + "','"
						+ ft.format(date) + "','" + 0 + "')";
				System.out.println(sql);
				PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
				x = preparedStatement.executeUpdate();
				Statement statement = dc.cn.createStatement();
				String query = "select * from hoadon";
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					a = rs.getInt("MaHoaDon");
				}

				for (int i = 0; i < n; i++) {
					String struct = " insert into ChiTietHoaDon(MaSach,SoLuongMua,MaHoaDon,XacNhanDaMua)" + "values('"
							+ ghbean.get(i).getMasach() + "','" + ghbean.get(i).getSlmua() + "','" + a + "','" + 0
							+ "')";
					System.out.println(struct);
					PreparedStatement preparedStatement1 = dc.cn.prepareStatement(struct);
					x = preparedStatement1.executeUpdate();
				}
				request.setAttribute("kiemtra", "kiemtra");

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
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
