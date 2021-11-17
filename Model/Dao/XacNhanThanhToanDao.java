package Dao;

import java.sql.PreparedStatement;

public class XacNhanThanhToanDao {
	public void XacNhanThanhToan(int makh) throws Exception
	{
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "update hoadon "
				+ "set damua = 1 "
				+ "where makh = '"+makh+"'";
		System.out.println(sql);
		PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
		preparedStatement.executeUpdate();	
	}
	
	public void XacNhanAdmin(int machitiet) throws Exception
	{
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "update ChiTietHoaDon "
				+ "set XacNhanDaMua = 1 "
				+ "from ChiTietHoaDon inner join "
				+ "hoadon on "
				+ "ChiTietHoaDon.MaHoaDon = hoadon.MaHoaDon "
				+ "where MaChiTietHD='"+machitiet+"'";				
		System.out.println(sql);
		PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
		preparedStatement.executeUpdate();	
	}
	
	public void XacNhanThanhToanMotQuyen(int machitiet) throws Exception
	{
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "update hoadon "
				+ "set damua = 1 "
				+ "from hoadon inner join "
				+ "ChiTietHoaDon on "
				+ "ChiTietHoaDon.MaHoaDon = hoadon.MaHoaDon"
				+ "where MaChiTietHd = '"+machitiet+"'";
		System.out.println(sql);
		PreparedStatement preparedStatement = dc.cn.prepareStatement(sql);
		preparedStatement.executeUpdate();	
	}

}
