package Bo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.LoaiBean;
import Dao.DungChung;

public class LoaiDatabase {
	public ArrayList<LoaiBean> getLoaiDatabase()
	{
		ArrayList<LoaiBean> ds = new ArrayList<LoaiBean>();
		DungChung dc = new DungChung();
		try {
			dc.KetNoi();
			Statement statement = dc.cn.createStatement();
			ResultSet rs = statement.executeQuery("select * from loai");
			while(rs.next())
			{
				ds.add(new LoaiBean(rs.getString(1),rs.getString(2)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ds;
	}

}
