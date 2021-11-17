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
 * Servlet implementation class AddOneBookController
 */
@WebServlet("/AddOneBookController")
public class AddOneBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOneBookController() {
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
		String nameimg = null, tensach = null, tacgia = null;
		String urlimage = null, masach = null, loai = null;
		int soluong = 0, sotap = 0;
		long gia = 0;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "files";
		response.getWriter().println(dirUrl1);
		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "image_sach";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("txtmasach")) {
						masach = fileItem.getString("utf-8");
					}
					if (tentk.equals("txttensach")) {
						tensach = fileItem.getString("utf-8");
					}
					if (tentk.equals("txtsoluong")) {
						soluong = Integer.parseInt(fileItem.getString());
					}
					if (tentk.equals("txtgia")) {
						gia = Long.parseLong(fileItem.getString());
					}
					if (tentk.equals("txtloai")) {
						loai = fileItem.getString("utf-8");
					}
					if (tentk.equals("txtsotap")) {
						sotap = Integer.parseInt(fileItem.getString());
					}
					if (tentk.equals("txttacgia")) {
						tacgia = fileItem.getString("utf-8");
					}
				}

			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		urlimage = "image_sach/" + nameimg;
		SachBo sbo = new SachBo();
		try {
			sbo.themsach(masach, tensach, soluong, gia, loai, sotap, urlimage, tacgia);
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("themsach", "themsach");
		RequestDispatcher rd = request.getRequestDispatcher("Tramtrungchuyen");
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
