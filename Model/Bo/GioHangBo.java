package Bo;

import java.util.ArrayList;

import Bean.GioHangBean;


public class GioHangBo {
	public GioHangBean ThemDanhSach (String masach,String tensach,String tacgia,Long gia,Long slmua,Long thanhtien,String anh)
	{
		GioHangBean ghban = new GioHangBean();
		ghban.setMasach(masach);
	  ghban.setTensach(tensach);
	  ghban.setTacgia(tacgia);
	  ghban.setGia(gia);
	  ghban.setSlmua(slmua);
	  ghban.setThanhtien(thanhtien);
	  ghban.setAnh(anh);
		return ghban;
	}
	public long sotien(ArrayList<GioHangBean> a )
	{
		long salary = 0;
		for(int i=0;i<a.size();i++)
		{
			salary = salary+a.get(i).getThanhtien();
		}
		return salary;
	}

}
