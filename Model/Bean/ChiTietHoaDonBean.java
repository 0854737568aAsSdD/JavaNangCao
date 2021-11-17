package Bean;

public class ChiTietHoaDonBean {
	private String MaSach;
	private int SoLuongMua;
	private int MaHoaDon;
	private int XacNhanDaMua;

	public ChiTietHoaDonBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDonBean(String maSach, int soLuongMua, int maHoaDon, int xacNhanDaMua) {
		super();
		MaSach = maSach;
		SoLuongMua = soLuongMua;
		MaHoaDon = maHoaDon;
		XacNhanDaMua = xacNhanDaMua;
	}

	public String getMaSach() {
		return MaSach;
	}

	public void setMaSach(String maSach) {
		MaSach = maSach;
	}

	public int getSoLuongMua() {
		return SoLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}

	public int getMaHoaDon() {
		return MaHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}

	public int getXacNhanDaMua() {
		return XacNhanDaMua;
	}

	public void setXacNhanDaMua(int xacNhanDaMua) {
		XacNhanDaMua = xacNhanDaMua;
	}

}
