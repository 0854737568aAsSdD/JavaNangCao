package Bean;

import java.sql.Date;


public class SachBean {
	private String masach;
    private String tensach; 
    private String tacgia;
    private Long gia;
    private String anh;
    private String maloai;
    private String sotap;
    private Date ngaynhap;
    private int soluong;
    private Date date;
    private int damua;
	public SachBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SachBean(String masach, String tensach, String tacgia, Long gia, String anh, String maloai, String sotap,
			Date ngaynhap, int soluong, Date date, int damua) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.anh = anh;
		this.maloai = maloai;
		this.sotap = sotap;
		this.ngaynhap = ngaynhap;
		this.soluong = soluong;
		this.date = date;
		this.damua = damua;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getSotap() {
		return sotap;
	}
	public void setSotap(String sotap) {
		this.sotap = sotap;
	}
	public Date getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDamua() {
		return damua;
	}
	public void setDamua(int damua) {
		this.damua = damua;
	}
	
    
}