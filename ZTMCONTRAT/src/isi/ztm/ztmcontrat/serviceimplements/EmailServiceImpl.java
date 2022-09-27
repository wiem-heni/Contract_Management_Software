package isi.ztm.ztmcontrat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.IEmailDao;
import isi.ztm.ztmcontrat.serviceinterface.IEmailService;


@Service
@Transactional
public class EmailServiceImpl implements IEmailService{

	@Autowired
	private IEmailDao emailDao;
	
	

	public IEmailDao getEmailDao() {
		return emailDao;
	}



	public void setEmailDao(IEmailDao emailDao) {
		this.emailDao = emailDao;
	}



	public void sendEmail(String receiver, String object) {
		
		emailDao.sendEmail(receiver, object);
	}

}

	
	
