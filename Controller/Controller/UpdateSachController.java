package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Bo.SachBo;

/**
 * Servlet implementation class UpdateSachController
 */
@WebServlet("/UpdateSachController")
public class UpdateSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSachController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String nameimg = null;
		String urlimage = null, masach = null, tensach = null, tacgia = null, loai = null;
		int soluong = 0, sotap = 0;
		int gia = 0;
		// TODO Auto-generated method stub
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		// String dirUrl1 = request.getServletContext().getRealPath("") + File.separator
		// + "files";
		// response.getWriter().println(dirUrl1);

		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Láº¥y vá»� cÃ¡c Ä‘á»‘i tÆ°á»£ng gá»­i lÃªn
			// duyá»‡t qua cÃ¡c Ä‘á»‘i tÆ°á»£ng gá»­i lÃªn tá»« client gá»“m file vÃ  cÃ¡c
			// control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Náº¿u ko pháº£i cÃ¡c control=>upfile lÃªn
					// xá»­ lÃ½ file
					nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Láº¥y Ä‘Æ°á»�ng dáº«n hiá»‡n táº¡i, chá»§ Ã½ xá»­ lÃ½ trÃªn dirUrl Ä‘á»ƒ cÃ³
						// Ä‘Æ°á»�ng dáº«n Ä‘Ãºng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
						int vt = dirUrl.indexOf(".metadata");
						dirUrl = dirUrl.substring(0, vt - 1) + "\\NhaSachMinhKhai\\image_sach";
//					urlimage = dirUrl;
//					response.getWriter().println(urlimage);

						File dir = new File(dirUrl);
						if (!dir.exists()) {// náº¿u ko cÃ³ thÆ° má»¥c thÃ¬ táº¡o ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// táº¡o file
						try {
							fileItem.write(file);// lÆ°u file
							System.out.println("UPLOAD THÃ€NH CÃ”NG...!");
							System.out.println("Ä�Æ°á»�ng dáº«n lÆ°u file lÃ : " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("txtmasach")) {
						masach = fileItem.getString("utf-8");
						response.getWriter().println(masach);
					}
					if (tentk.equals("txttensach")) {
						tensach = fileItem.getString("utf-8");
						response.getWriter().println(tensach);
					}
					if (tentk.equals("txtsoluong")) {
						soluong = Integer.parseInt(fileItem.getString());
						response.getWriter().println(soluong);
					}
					if (tentk.equals("txtgia")) {
						gia = Integer.parseInt(fileItem.getString());
						response.getWriter().println(gia);
					}
					if (tentk.equals("txtloai")) {
						loai = fileItem.getString("utf-8");
						response.getWriter().println(loai);
					}
					if (tentk.equals("txtsotap")) {
						sotap = Integer.parseInt(fileItem.getString());
						response.getWriter().println(sotap);
					}
					if (tentk.equals("txttacgia")) {
						tacgia = fileItem.getString("utf-8");
						response.getWriter().println(tacgia);
					}
					if (tentk.equals("txtanh")) {
						urlimage = fileItem.getString("utf-8");
					}
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		if (nameimg != null && nameimg != "")
			urlimage = "image_sach/" + nameimg;

//		response.getWriter().println(masach);
//		response.getWriter().println(tensach);
//		response.getWriter().println(soluong);
//		response.getWriter().println(gia);
//		response.getWriter().println(loai);
//		response.getWriter().println(sotap);
//		response.getWriter().println(urlimage);
//		response.getWriter().println(tacgia);	
		try {
			SachBo sbo = new SachBo();
			sbo.updateSach(masach, tensach, soluong, gia, loai, sotap, loai, tacgia);
		} catch (Exception e) {
			// TODO: handle exception
		}
//		RequestDispatcher rd = request.getRequestDispatcher("Admin");
//		rd.forward(request, response);
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
