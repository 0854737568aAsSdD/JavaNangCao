package Bean;

public class GioHangBean {
	private String masach;
    private String tensach;
    private String tacgia;
    private Long gia;
    private Long slmua;
    private Long thanhtien;
    private String anh;
	public GioHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GioHangBean(String masach, String tensach, String tacgia, Long gia, Long slmua, Long thanhtien, String anh) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.slmua = slmua;
		this.thanhtien = gia*slmua;
		this.anh=anh;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
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
	public Long getSlmua() {
		return slmua;
	}
	public void setSlmua(Long slmua) {
		this.slmua = slmua;
	}
	public Long getThanhtien() {
		return gia*slmua;
	}
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
}
