package Bo;

import java.util.ArrayList;

import Bean.LichSuBean;
import Dao.LichSuDao;

public class LichSuBo {
	LichSuDao ls = new LichSuDao();
	public ArrayList<LichSuBean> getLichSu(int makh) throws Exception
	{
		return ls.getLichSu(makh);
	}

}
