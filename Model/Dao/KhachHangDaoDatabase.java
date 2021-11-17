package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.KhachHangBean;
import Bean.SachBean;

public class KhachHangDaoDatabase {
	public  ArrayList<KhachHangBean> getCheck()
	{
		ArrayList<KhachHangBean> khbean = new ArrayList<KhachHangBean>();
		DungChung dc= new DungChung();
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement("select * from KhachHang");
			ResultSet rs = ps.executeQuery();		
			while(rs.next())
			{
			KhachHangBean kh = new KhachHangBean();
			kh.setMakh(rs.getInt(1));
			kh.setHoten(rs.getString(2));
			kh.setDiachi(rs.getString(5));
			kh.setMatkhau(rs.getString(7));
			kh.setTendn(rs.getString(3));
			khbean.add(kh);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return khbean;
	}
}
