package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.LoaiBean;
import Bean.SachBean;

public class SachDao {
	public ArrayList<SachBean> getSach() throws Exception {
		ArrayList<SachBean> ds = new ArrayList<SachBean>();
		DungChung dc = new DungChung();
		dc.KetNoi();
		PreparedStatement ps = dc.cn.prepareStatement("select * from sach");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			SachBean sachBean = new SachBean();
			sachBean.setMasach(rs.getString(1));
			sachBean.setTensach(rs.getString(2));
			sachBean.setGia(rs.getLong(4));
			sachBean.setTacgia(rs.getString(9));
			sachBean.setAnh(rs.getString(7));
			sachBean.setMaloai(rs.getString(5));
			sachBean.setSoluong(rs.getInt(3));
			sachBean.setNgaynhap(rs.getDate(8));
			sachBean.setSotap(rs.getString(6));
			ds.add(sachBean);
		}
//b6: Dong all 
		rs.close();
		dc.cn.close();
		return ds;
	}

	public ArrayList<SachBean> getSachTheoTenLoai(String maloai) throws Exception {
		ArrayList<SachBean> ds = new ArrayList<SachBean>();
		DungChung dc = new DungChung();
		dc.KetNoi();
		PreparedStatement ps = dc.cn.prepareStatement("select * from sach where maloai='" + maloai + "'");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			SachBean sachBean = new SachBean();
			sachBean.setMasach(rs.getString(1));
			sachBean.setTensach(rs.getString(2));
			sachBean.setGia(rs.getLong(4));
			sachBean.setTacgia(rs.getString(9));
			sachBean.setAnh(rs.getString(7));
			sachBean.setMaloai(rs.getString(5));
			sachBean.setSoluong(rs.getInt(3));
			ds.add(sachBean);
		}
		// b6: Dong all
		rs.close();
		dc.cn.close();
		return ds;
	}

	public void themsach(String masach, String tensach, int soluong, long gia, String loai, int sotap, String anh,
			String tacgia) throws Exception {

		DungChung dc = new DungChung();
		dc.KetNoi();
		// Táº¡o lá»‡nh sql
		String sql = "insert into sach\r\n" + "values (?,?,?,?,?,?,?,GETDATE(),?)";
		// Táº¡o cÃ¢u lá»‡nh
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		cmd.setString(2, tensach);
		cmd.setInt(3, soluong);
		cmd.setLong(4, gia);
		cmd.setString(5, loai);
		cmd.setInt(6, sotap);
		cmd.setString(7, anh);
		cmd.setString(8, tacgia);
		cmd.executeUpdate();
		cmd.close();
		dc.cn.close();

	}

	public void DeleteSach(String masach) throws Exception {
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "delete from sach where masach=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		cmd.executeUpdate();
		cmd.close();
		dc.cn.close();
	}
	public void updateSach(String masach,String tensach, int soluong, long gia, String loai,int sotap,String anh,String tacgia){
		try {
			DungChung dc = new DungChung();
			dc.KetNoi();
			//Táº¡o lá»‡nh sql
			String sql = "update sach\r\n" + 
					"	set tensach = ?\r\n" + 
					"	,soluong = ?\r\n" + 
					"	,gia = ?\r\n" + 
					"	,maloai = ?\r\n" + 
					"	,sotap = ?\r\n" + 
					"	, anh = ?\r\n" + 
					"	, tacgia = ?\r\n" + 
					"where masach = ?";
			//Táº¡o cÃ¢u lá»‡nh
			PreparedStatement cmd = dc.cn.prepareStatement(sql);	
			cmd.setString(1, tensach);
			cmd.setInt(2, soluong);
			cmd.setLong(3, gia);
			cmd.setString(4, loai);
			cmd.setInt(5, sotap);
			cmd.setString(6, anh);
			cmd.setString(7, tacgia);
			cmd.setString(8, masach);
			cmd.executeUpdate();
			cmd.close();dc.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
