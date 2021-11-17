package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.KhachHangBean;

public class KhachHangDao {
	public KhachHangBean ktdm(String un,String pass) throws Exception{
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select * from KhachHang where tendn='"+un+"'and  pass='"+pass+"'" ;
		System.out.println(sql);
		  PreparedStatement cmd= dc.cn.prepareStatement(sql);
		   ResultSet rs= cmd.executeQuery();
		   if(rs.next()==false)
		   {
			   return null;
		   }
		   else
		   {
				KhachHangBean kh = new KhachHangBean();
				kh.setMakh(rs.getInt(1));
				kh.setHoten(rs.getString(2));
				kh.setDiachi(rs.getString(3));
				kh.setMatkhau(rs.getString(7));
				kh.setTendn(rs.getString(6));
			   return kh;
		   }
		   
	   }
}
