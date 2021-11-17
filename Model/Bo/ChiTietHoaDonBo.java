package Bo;

import java.util.ArrayList;

import Bean.GioHangBean;
import Bean.SachBean;
import Dao.ChiTietHoaDonDao;

public class ChiTietHoaDonBo {
	ChiTietHoaDonDao chitiet = new ChiTietHoaDonDao();

	public void getChiTietHoaDon(ArrayList<GioHangBean> ds) throws Exception {
		chitiet.getChiTietHoaDon(ds);
	}
}
