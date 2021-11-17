package Bean;

import java.util.ArrayList;

public class TaiKhoanBean {
	private KhachHangBean khbean;
	private ArrayList<GioHangBean> ds;
	public TaiKhoanBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoanBean(KhachHangBean khbean, ArrayList<GioHangBean> ds) {
		super();
		this.khbean = khbean;
		this.ds = ds;
	}
	public KhachHangBean getKhbean() {
		return khbean;
	}
	public void setKhbean(KhachHangBean khbean) {
		this.khbean = khbean;
	}
	public ArrayList<GioHangBean> getDs() {
		return ds;
	}
	public void setDs(ArrayList<GioHangBean> ds) {
		this.ds = ds;
	}
}
