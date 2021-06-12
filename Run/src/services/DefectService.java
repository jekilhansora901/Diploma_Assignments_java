package services;

import util.DAOException;
import bean.DefectProducts;
import dao.DefectDaoImpl;

public class DefectService {
	
	DefectDaoImpl dao = new DefectDaoImpl();
	
	public long addDefect(DefectProducts product) throws DAOException,Exception {
		return dao.addDefect(product);
	}
	
//	public int updateDefectDetails(DefectProducts product) throws DAOException, Exception{	
//		return dao.updateDefectDetails(product);
//	}
//	
//	public DefectProducts viewDefectDetails(int defectId) throws Exception{
//		return dao.viewDefectDetails(defectId);
//	}
//	
//	public boolean deleteDefectProduct(DefectProducts product) throws Exception{
//		return dao.deleteDefectProduct(product);
//	}
//	
}
