package isi.ztm.ztmcontrat.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.IExportToCSVDao;
import isi.ztm.ztmcontrat.serviceinterface.IExportService;
@Service
@Transactional
public class ExportServiceImpl implements IExportService{
	@Autowired
	private IExportToCSVDao exportDao;
	public ExportServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void WriteDataToCSVFile() {
        exportDao.WriteDataToCSVFile();	
	}

}
