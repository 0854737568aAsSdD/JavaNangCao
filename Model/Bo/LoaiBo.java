package Bo;

import java.util.ArrayList;

import Bean.LoaiBean;
import Dao.LoaiDao;

public class LoaiBo  {
	 LoaiDao ldao=new LoaiDao();
	  public ArrayList<LoaiBean> GetLoai() throws Exception{
		  return ldao.getLoaiSach();
	  }
}
