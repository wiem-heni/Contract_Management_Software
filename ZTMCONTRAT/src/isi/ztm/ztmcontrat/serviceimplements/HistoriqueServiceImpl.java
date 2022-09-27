package isi.ztm.ztmcontrat.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.ztm.ztmcontrat.daointerface.IHistoriqueDao;
import isi.ztm.ztmcontrat.entite.Historique;
import isi.ztm.ztmcontrat.serviceinterface.IHistoriqueService;

@Transactional
@Service
public class HistoriqueServiceImpl implements IHistoriqueService {
	@Autowired
	private IHistoriqueDao HistoriqueDao;
	
	public HistoriqueServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void ajouterHistorique(Historique h) {
		HistoriqueDao.ajouterHistorique(h);		
	}


	public void modifierHistorique(Historique h) {
		HistoriqueDao.modifierHistorique(h);		
	}

	
	public List<Historique> listAllHistorique() {
		// TODO Auto-generated method stub
		return HistoriqueDao.listAllHistorique();
	}

}
