package Bo;

import java.util.ArrayList;

import Bean.ThongTinThanhToanBean;
import Dao.ThongTinThanhToanDao;

public class ThongTinThanhToanBo {
	ThongTinThanhToanDao thongtin = new ThongTinThanhToanDao();

	public ArrayList<ThongTinThanhToanBean> getThanhToan() throws Exception {
		return thongtin.getThanhToan();
	}
	
	

}
