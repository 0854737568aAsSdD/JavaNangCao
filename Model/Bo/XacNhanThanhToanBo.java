package Bo;

import Dao.XacNhanThanhToanDao;

public class XacNhanThanhToanBo {
	XacNhanThanhToanDao xacnhan = new XacNhanThanhToanDao();

	public void XacNhanThanhToan(int makh) throws Exception {
		xacnhan.XacNhanThanhToan(makh);
	}

	public void XacNhanAdmin(int machitiet) throws Exception {
		xacnhan.XacNhanAdmin(machitiet);
	}
	
	public void XacNhanChoMotQuyen(int machitiet) throws Exception {
		xacnhan.XacNhanThanhToanMotQuyen(machitiet);
	}
	
}
