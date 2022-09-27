package isi.ztm.ztmcontrat.serviceimplements;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.IDateDao;
import isi.ztm.ztmcontrat.serviceinterface.IDateService;

@Service
@Transactional
public class DateServiceImp implements IDateService{
	
	@Autowired
	private IDateDao dateDao;
	
	public IDateDao getDateDao() {
		return dateDao;
	}


	public void setDateDao(IDateDao dateDao) {
		this.dateDao = dateDao;
	}
	
	public Date DateNow() {
		
		return dateDao.DateNow();
	}

	
	public Date ConvertStringToDate(String st) {
		
		return dateDao.ConvertStringToDate(st);
	}

	
	public Date ConvertLongToDate(long L) {
		
		return dateDao.ConvertLongToDate(L);
	}

	
	public long ConvertDateToLong(Date dt) {
		
		return dateDao.ConvertDateToLong(dt);
	}
	
	

}
