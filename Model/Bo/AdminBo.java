package Bo;

import Bean.AdminBean;
import Dao.AdminDao;

public class AdminBo {
	AdminDao admindao = new AdminDao();
    public AdminBean Check(String TenDangNhap, String MatKhau) throws Exception
    {  	
    	return admindao.ktdn(TenDangNhap, MatKhau);
    }
}
