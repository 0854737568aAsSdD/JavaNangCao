package Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.LichSuBean;
import Bean.SachBean;

public class LichSuDao {
	public ArrayList<LichSuBean> getLichSu(int makh) throws Exception {
		int[] array = new int[1000];
		ArrayList<LichSuBean> lsBeans = new ArrayList<LichSuBean>();
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "select MaHoaDon from hoadon where makh='" + makh + "'";
		System.out.println(sql);
		Statement statement = dc.cn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		int i = 0;
		while (rs.next()) {
			array[i] = rs.getInt("MaHoaDon");
			i++;
		}
		for (int j = 0; j < i; j++) {
			String query = "select MaChiTietHD,hoadon.NgayMua,ChiTietHoaDon.SoLuongMua,ChiTietHoaDon.masach,tensach,tacgia,gia,maloai,anh,maloai,damua"
					+ " from ChiTietHoaDon inner join sach " + "on ChiTietHoaDon.MaSach=sach.masach"
					+ " inner join hoadon " + "on ChiTietHoaDon.MaHoaDon=hoadon.MaHoaDon"
					+ " where ChiTietHoaDon.MaHoaDon='" + array[j] + "'";
			System.out.println(query);
			Statement statement2 = dc.cn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				LichSuBean sb = new LichSuBean();
				sb.setMasach(resultSet.getString("masach"));
				sb.setTensach(resultSet.getString("tensach"));
				sb.setTacgia(resultSet.getString("tacgia"));
				sb.setAnh(resultSet.getString("anh"));
				sb.setMaloai(resultSet.getString("maloai"));
				sb.setGia(resultSet.getLong("gia"));
				sb.setSoluong(resultSet.getInt("SoLuongMua"));
				sb.setDate(resultSet.getDate("NgayMua"));
				sb.setDamua(resultSet.getInt("damua"));
				sb.setMaChiTietHD(resultSet.getInt("MaChiTietHD"));
				lsBeans.add(sb);
			}
		}
		return lsBeans;
	}

}
