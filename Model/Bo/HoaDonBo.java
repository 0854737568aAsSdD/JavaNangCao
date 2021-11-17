package Bo;

import Dao.HoaDonDao;

public class HoaDonBo {
	HoaDonDao hddao = new HoaDonDao();
	public void getHoaDon(int makh) throws Exception
	{
		hddao.getHoaDon(makh);
	}

}
