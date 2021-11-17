package Bo;

import java.util.ArrayList;

import Bean.SachBean;
import Dao.SachDao;

public class SachBo {
	SachDao sdao=new SachDao();
	   public ArrayList<SachBean> getsach() throws Exception{
		   return  sdao.getSach();
	   }
	   public ArrayList<SachBean> getSachTheoTenLoai(String maloai) throws Exception{
		   return  sdao.getSachTheoTenLoai(maloai);
	   }
		public void themsach(String masach,String tensach, int soluong, long gia, String loai,int sotap,String anh,String tacgia) throws Exception{
			sdao.themsach(masach, tensach, soluong, gia, loai, sotap, anh, tacgia);
		}
		public void DeleteSach(String masach) throws Exception
		{
			sdao.DeleteSach(masach);
		}
		public void updateSach(String masach,String tensach, int soluong, long gia, String loai,int sotap,String anh,String tacgia) throws Exception
		{
			sdao.updateSach(masach, tensach, soluong, gia, loai, sotap, anh, tacgia);
		}
	   public ArrayList<SachBean> TimMaLoai(String maloai) throws Exception{
		   ArrayList<SachBean> tam = sdao.getSach();
		   ArrayList<SachBean> tam1 = new ArrayList<SachBean>(); 
		   for(SachBean s1:tam)
		   {
			   if(s1.getMaloai().equals(maloai))
			   {
				   tam1.add(s1);
			   }
		   }	   
		return tam1;
		   //Tra ve all sach co ma loai: maloai
	   }
	   public ArrayList<SachBean> TimChung(String key) throws Exception{
		   ArrayList<SachBean> temp= sdao.getSach();
		   ArrayList<SachBean> temp1= new ArrayList<SachBean>();
		   for(SachBean temp2: temp) {
			   if(temp2.getTacgia().toLowerCase().trim().contains(key.toLowerCase().trim())||
					   temp2.getTensach().toLowerCase().trim().contains(key.toLowerCase().trim()) )
				   temp1.add(temp2);
		   }
		 
		   
	return temp1;
		   //Tra ve all sach co ten sach hoac tac gia =key (tương doi)
	   }
	   public Long Demsach(String maloai)  throws Exception{
		long dem =0;
		ArrayList<SachBean> sbean= sdao.getSach();
		for(int i=0;i<sbean.size();i++)
		{
			if(sbean.get(i).getMaloai().equals(maloai))
				dem=dem+1;
			
		}
		return dem;
		
		  // Dem xem co ? sach co ma loai: maloai
	   }
}
