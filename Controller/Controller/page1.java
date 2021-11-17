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

import Bean.SachBean;

/**
 * Servlet implementation class page1
 */
@WebServlet("/page1")
public class page1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public page1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("page1") == null) {
				int pageid = 0;
				int total = pageid + 10;
				List<SachBean> sbean = new ArrayList<SachBean>();
				List<SachBean> danhsach1 = (List<SachBean>) request.getAttribute("danhsach");
				for (pageid = 0; pageid < total; pageid++) {
					sbean.add(danhsach1.get(pageid));
				}
				request.setAttribute("temp", sbean);
				request.setAttribute("kiemtra1", "kiemtra1");
				request.setAttribute("soluongsachmaloai", danhsach1.size());
			} else if (request.getParameter("page1") != null) {
				String spageid = request.getParameter("page1");
				int pageid = Integer.parseInt(spageid);
				pageid = pageid * 10 - 10;
				int total = pageid + 10;
				List<SachBean> sbean = new ArrayList<SachBean>();
				List<SachBean> danhsach1 = (List<SachBean>) request.getAttribute("danhsach");
				while (pageid < total) {
					sbean.add(danhsach1.get(pageid));
					pageid = pageid + 1;
				}
				request.setAttribute("temp", sbean);
				request.setAttribute("kiemtra1", "kiemtra1");
				request.setAttribute("soluongsachmaloai", danhsach1.size());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
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
