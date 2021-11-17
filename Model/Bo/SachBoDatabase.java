package Bo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Bean.SachBean;
import Dao.DungChung;

public class SachBoDatabase {
	public   List<SachBean> getRecords(int start, int total) throws Exception
	{
		List<SachBean> list = new ArrayList<SachBean>();
		
			DungChung dc= new DungChung();
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement("select * from sach order by masach offset "+(start-1)*10+" rows fetch next "+total+" rows ONLY");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				SachBean sachBean = new SachBean();
				sachBean.setMasach(rs.getString(1));
				sachBean.setTensach(rs.getString(2));
				sachBean.setGia(rs.getLong(4));
				sachBean.setTacgia(rs.getString(9));
				sachBean.setAnh(rs.getString(7));
				sachBean.setMaloai(rs.getString(5));
				list.add(sachBean);
			}
		
		return list;
		
		}
	
	public  List<SachBean> TimMaLoai(String maloai,int start, int total) throws Exception
	{
		List<SachBean> list = new ArrayList<SachBean>();
		
			DungChung dc= new DungChung();
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement("select * from sach where maloai='"+maloai+"' order by maloai offset "+(start-1)*10+" rows fetch next "+total+" rows ONLY");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				SachBean sachBean = new SachBean();
				sachBean.setMasach(rs.getString(1));
				sachBean.setTensach(rs.getString(2));
				sachBean.setGia(rs.getLong(4));
				sachBean.setTacgia(rs.getString(9));
				sachBean.setAnh(rs.getString(7));
				sachBean.setMaloai(rs.getString(5));
				list.add(sachBean);
			}
			

		return list;
		
		}
	
	public  List<SachBean> TimMaLoailaysoluong(String maloai) throws Exception
	{
		List<SachBean> list = new ArrayList<SachBean>();
		
			DungChung dc= new DungChung();
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement("select * from sach where maloai='"+maloai+"' order by maloai  ");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				SachBean sachBean = new SachBean();
				sachBean.setMasach(rs.getString(1));
				sachBean.setTensach(rs.getString(2));
				sachBean.setGia(rs.getLong(4));
				sachBean.setTacgia(rs.getString(9));
				sachBean.setAnh(rs.getString(7));
				sachBean.setMaloai(rs.getString(5));
				list.add(sachBean);
			}
			

		return list;
		
		}


	
	public  List<SachBean> Timthemten(String key,int start, int total) throws Exception
	{
		List<SachBean> list = new ArrayList<SachBean>();
		
			DungChung dc= new DungChung();
			dc.KetNoi();
			String sql = "select * from sach where tensach like '%"+key+"%' or tacgia like'%"+key+"%' order by maloai offset "+(start-1)*10+" rows fetch next "+total+" rows ONLY";
			PreparedStatement ps = dc.cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				SachBean sachBean = new SachBean();
				sachBean.setMasach(rs.getString(1));
				sachBean.setTensach(rs.getString(2));
				sachBean.setGia(rs.getLong(4));
				sachBean.setTacgia(rs.getString(9));
				sachBean.setAnh(rs.getString(7));
				sachBean.setMaloai(rs.getString(5));
				list.add(sachBean);
			}
		
	    System.out.println("list size tìm theo tên : " +list.size());
	    System.out.println("select * from sach where tensach like '%"+key+"%' or tacgia like'%"+key+"%' order by maloai offset "+(start-1)*10+" rows fetch next "+total+" rows ONLY");
		return list;
		
		}
	
	public  List<SachBean> Timthemtensoluong(String key) throws Exception
	{
		List<SachBean> list = new ArrayList<SachBean>();
		
			DungChung dc= new DungChung();
			dc.KetNoi();
			String sql = "select * from sach where tensach like '%"+key+"%' or tacgia like'%"+key+"%' order by maloai";
			PreparedStatement ps = dc.cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				SachBean sachBean = new SachBean();
				sachBean.setMasach(rs.getString(1));
				sachBean.setTensach(rs.getString(2));
				sachBean.setGia(rs.getLong(4));
				sachBean.setTacgia(rs.getString(9));
				sachBean.setAnh(rs.getString(7));
				sachBean.setMaloai(rs.getString(5));
				list.add(sachBean);
			}
	
	    System.out.println("list size số lượng tìm theo tên : " +list.size());
	    System.out.println("select * from sach where tensach like '%"+key+"%' or tacgia like'%"+key+"%' order by maloai");   
		return list;
		
		}
	


	
}
