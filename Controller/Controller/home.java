package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.GioHangBean;
import Bean.LoaiBean;
import Bean.SachBean;
import Bo.LoaiDatabase;
import Bo.SachBoDatabase;

/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
//			SachBo sbo = new SachBo();
			SachBoDatabase sachBoDatabase = new SachBoDatabase();
//			ArrayList<SachBean> list = sbo.getsach();
//			req.setAttribute("list", list);
//			LoaiBo lbo = new LoaiBo();
//			ArrayList<SachBean> dssach = sbo.getsach();
//			ArrayList<LoaiBean> dsloai = lbo.GetLoai();
//			String ml = req.getParameter("ml");
//			String key = req.getParameter("txttk");
//			req.setAttribute("soluong", (long) list.size());
//			if (ml != null) {
//				dssach = sbo.TimMaLoai(ml);
//				long sosach = sbo.Demsach(ml);
//				req.setAttribute("soluong", sosach);
//			} else if (key != null) {
//				dssach = sbo.TimChung(key);
//				long sosach = 0;
//				for (SachBean sach : dssach) {
//					sosach = sosach + 1;
//				}
//				req.setAttribute("soluong", sosach);
//			}
//			req.setAttribute("dsloai", dsloai);
//			req.setAttribute("dssach", dssach);
			// Dung database
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			ArrayList<GioHangBean> soluong = (ArrayList<GioHangBean>) session.getAttribute("giohang");
			if (soluong == null) {
			} else {
				int x = soluong.size();
				req.setAttribute("soluongsach", x);
			}
			if (req.getParameter("page") == null) {
				int pageid = 1;
				int total = 10;
				List<SachBean> temp = sachBoDatabase.getRecords(pageid, total);
				req.setAttribute("temp", temp);
				req.setAttribute("pageid", pageid);
				req.setAttribute("soluongsachmaloai",temp.size());
			} else {
				String spageid = req.getParameter("page");
				int pageid = Integer.parseInt(spageid);
				int total = 10;
				List<SachBean> temp = sachBoDatabase.getRecords(pageid, total);
				req.setAttribute("temp", temp);
				req.setAttribute("pageid", pageid);
				req.setAttribute("soluongsachmaloai",temp.size());
			}
			LoaiDatabase loaiDatabase = new LoaiDatabase();
			ArrayList<LoaiBean> ds = loaiDatabase.getLoaiDatabase();
			req.setAttribute("loai", ds);
			String maloai = req.getParameter("maloai");
			String txttk = req.getParameter("txttk");
//			List<SachBean> danhsach = (List<SachBean>) req.getAttribute("temp");
			if (maloai != null ) {
					String spageid = req.getParameter("page1");			
					int pageid1=1;
					if(spageid!=null)
					{	
						 pageid1 = Integer.parseInt(spageid);
					}	
					
					int total = 10;
					List<SachBean> temp1 = sachBoDatabase.TimMaLoai(maloai,pageid1, total);
					req.setAttribute("temp1", temp1);
					req.setAttribute("pageid1", pageid1);
					List<SachBean> temp2 = sachBoDatabase.TimMaLoailaysoluong(maloai);
					req.setAttribute("soluongsachmaloai", temp2.size());
					req.setAttribute("kiemtra", "kiemtra");
					req.setAttribute("maloai",maloai);
				}	
			else
			  if (txttk != null) {
				 String spageid = req.getParameter("page1");			
					int pageid1=1;
					if(spageid!=null)
					{	
						 pageid1 = Integer.parseInt(spageid);
					}		
					int total = 10;
					List<SachBean> temp1 = sachBoDatabase.Timthemten(txttk,pageid1, total);
					req.setAttribute("temp1", temp1);
					req.setAttribute("pageid1", pageid1);
					List<SachBean> temp2 = sachBoDatabase.Timthemtensoluong(txttk);
					req.setAttribute("soluongsachmaloai", temp2.size());
					req.setAttribute("kiemtra1", "kiemtra1");
					req.setAttribute("txttk",txttk);
			}
				RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, resp);
		}


		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
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
