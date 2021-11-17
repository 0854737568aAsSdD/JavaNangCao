package Bo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Bean.KhachHangBean;
import Bean.SachBean;
import Dao.DungChung;
import Dao.KhachHangDao;
import Dao.KhachHangDaoDatabase;

public class KhachHangBoDatabase {
	KhachHangDaoDatabase kdao = new KhachHangDaoDatabase();
	public ArrayList<KhachHangBean> getkhachhang()
	{
		return kdao.getCheck();
	}
	
	public KhachHangBean check(int taikhoan, String matkhau)
	{
		 ArrayList<KhachHangBean> ds = kdao.getCheck();
		 int n = ds.size();
		for(int i=0;i<n;i++)
		{
			if(ds.get(i).getMakh()==taikhoan && ds.get(i).getMatkhau().equals(matkhau))
				return ds.get(i);
		}
		return null;
			
	}
	

}
