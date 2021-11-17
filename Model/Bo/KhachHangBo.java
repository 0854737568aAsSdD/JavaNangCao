package Bo;

import java.util.ArrayList;

import Bean.KhachHangBean;
import Dao.KhachHangDao;

public class KhachHangBo {
	KhachHangDao kdao = new KhachHangDao();
	
	public KhachHangBean check(String taikhoan, String matkhau) throws Exception
	{
		return kdao.ktdm(taikhoan, matkhau);			
	}
}
