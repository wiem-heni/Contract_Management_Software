package isi.ztm.ztmcontrat.daoimplements;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import isi.ztm.ztmcontrat.daointerface.IContratDao;
import isi.ztm.ztmcontrat.entite.Categorie;
import isi.ztm.ztmcontrat.entite.Cocontractant;
import isi.ztm.ztmcontrat.entite.Contrat;

@Repository
public class ContratDaoImpl implements IContratDao {

	@PersistenceContext
	EntityManager em;

	public ContratDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void ajouterContrat(Contrat c) {

		em.persist(c);

	}

	// em.remove(em.merge(c)); supprimer contrat
	public void modifierContrat(Contrat c) {

		em.merge(c);

	}

	public List<Contrat> listAllContrats() {
		List<Contrat> list = null;
		Query q = em.createQuery("select c from Contrat c ");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

	public Contrat rechercherContratById(int id) {

		return em.find(Contrat.class, id);
	}

	public Contrat rechercherContratByCode(String code) {

		Contrat found = null;

		Query q = em.createQuery("select c from Contrat c where c.codeContrat =:co");

		q.setParameter("co", code);

		try {
			found = (Contrat) q.getSingleResult();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return found;
	}

	public List<Contrat> listContratFerme() {
		List<Contrat> list = null;
		Query q = em.createQuery("select c from Contrat c where c.typeContrat =:type");
		q.setParameter("type", "ferme");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

	public List<Contrat> listContratFermeEnCours() {
		List<Contrat> list = null;
		Query q = em.createQuery("select c from Contrat c where c.typeContrat =:type and c.etatContrat =:etat");
		q.setParameter("type", "ferme");
		q.setParameter("etat", "en cours");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

	public List<Contrat> listContratFermeExpirer() {
		List<Contrat> list = listContratFerme();
		List<Contrat> l = new ArrayList<>();
		Date currentDate = new Date();
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getDateFin().before(currentDate) || list.get(i).getDateFin().equals(currentDate)) {

				l.add(list.get(i));
			}
		}
		return l;
	}

	public List<Contrat> listContratFermeAvantExpiration() {
		List<Contrat> list = listContratFerme();
		List<Contrat> l = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		Date currentDate = new Date();
		for (int i = 0; i < list.size(); i++) {
			try {
				String d = sdf.format(list.get(i).getDateFin());
				String c = sdf.format(currentDate);
				Date dateFin = sdf.parse(d);
				Date dateNow = sdf.parse(c);
				long diff = dateFin.getTime() - dateNow.getTime();
				float res = (diff / (1000 * 60 * 60 * 24));
				System.out.println("Nombre de jours entre les deux dates est: " + res);
				if ((res > 0) && (res < 31)) {

					l.add(list.get(i));
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return l;
	}

	public List<Contrat> listContratRenouvelable() {
		List<Contrat> list = null;
		Query q = em.createQuery("select c from Contrat c where c.typeContrat =:type");
		q.setParameter("type", "renouvelable");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

	public List<Contrat> listContratRenouvelableEnCours() {
		List<Contrat> list = null;
		Query q = em.createQuery("select c from Contrat c where c.typeContrat =:type and c.etatContrat =:etat");
		q.setParameter("type", "renouvelable");
		q.setParameter("etat", "en cours");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

	public List<Contrat> listContratRenouvelableAvantExpiration() {
		List<Contrat> list = listContratRenouvelable();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		List<Contrat> l = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		Date currentDate = new Date();
		for (int i = 0; i < list.size(); i++) {
			c.setTime(list.get(i).getDateFin());

			int x = -list.get(i).getNb();
			if (list.get(i).getUnite().contains("jour")) {

				c.add(Calendar.DATE, x);
			} else if (list.get(i).getUnite().contains("mois")) {

				c.add(Calendar.MONTH, x);
			}

			else if (list.get(i).getUnite().contains("annee")) {
				c.add(Calendar.YEAR, x);
			}
			Date dateLimite = c.getTime();
			try {
				String d = sdf.format(dateLimite);
				String m = sdf.format(currentDate);
				Date dateFin = sdf.parse(d);
				Date dateNow = sdf.parse(m);
				long diff = dateFin.getTime() - dateNow.getTime();
				float res = (diff / (1000 * 60 * 60 * 24));
				System.out.println("Nombre de jours entre les deux dates est: " + res);
				if ((res > 0) && (res < 31)) {

					l.add(list.get(i));
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} // for

		return l;
	}

	public List<Contrat> listContratRenouvelableExpirer() {
		List<Contrat> list = listContratRenouvelable();
		List<Contrat> l = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		Date currentDate = new Date();

		for (int i = 0; i < list.size(); i++) {
			c.setTime(list.get(i).getDateFin());

			int x = -list.get(i).getNb();
			if (list.get(i).getUnite().contains("jour")) {

				c.add(Calendar.DATE, x);
			} else if (list.get(i).getUnite().contains("mois")) {

				c.add(Calendar.MONTH, x);
			}

			else if (list.get(i).getUnite().contains("annee")) {
				c.add(Calendar.YEAR, x);
			}
			Date dateLimite = c.getTime();

			if (dateLimite.before(currentDate)) {

				l.add(list.get(i));
			}
		}
		return l;
	}

	public int nbContratEnCours() {
		int x = listContratFermeEnCours().size();
		int y = listContratRenouvelableEnCours().size();
		return x + y;
	}

	public int nbContratFermeEnCours() {
		int x = listContratFermeEnCours().size();
		return x;
	}

	public int nbContratRenouvelableEnCours() {
		int x = listContratRenouvelableEnCours().size();
		return x;
	}

	public int nbContratRenouvelableAvantExpiration() {
		int x = listContratRenouvelableAvantExpiration().size();
		return x;
	}

	public int nbContratRenouvelableExpirer() {
		int x = listContratRenouvelableExpirer().size();
		return x;
	}

	public int nbContratFermeExpirer() {
		int x = listContratFermeExpirer().size();
		return x;
	}

	public int nbContratFermeAvantExpiration() {
		int x = listContratFermeAvantExpiration().size();
		return x;
	}

	public int nbContratExpirer() {
		int x = listContratFermeExpirer().size();
		int y = listContratRenouvelableExpirer().size();
		return x + y;
	}

	public String testEtatFerme(Contrat c) {
		String ch = "en cours";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date currentDate = new Date();

		try {
			String d = sdf.format(c.getDateFin());
			String x = sdf.format(currentDate);
			Date dateFin = sdf.parse(d);
			Date dateNow = sdf.parse(x);
			long diff = dateFin.getTime() - dateNow.getTime();
			float res = (diff / (1000 * 60 * 60 * 24));
			System.out.println("Nombre de jours entre les deux dates est: " + res);
			if ((res > 0) && (res < 31)) {
				System.out.println(res + " jours avant expiration");
				ch = "-30 jours avant expiration";
			}

			else if (c.getDateFin().before(currentDate) || c.getDateFin().equals(currentDate)) {

				ch = "expiré";

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return ch;

	}

	public String testEtatRenouvelable(Contrat c) {
		String ch = "en cours";
		Calendar f = Calendar.getInstance();
		Calendar t = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date currentDate = new Date();

		f.setTime(c.getDateFin());
		t.setTime(c.getDateRenouvellement());
		int x = -c.getNb();
		if (c.getUnite().contains("jour")) {

			f.add(Calendar.DATE, x);
		} else if (c.getUnite().contains("mois")) {

			f.add(Calendar.MONTH, x);
		}

		else if (c.getUnite().contains("annee")) {
			f.add(Calendar.YEAR, x);
		}
		Date dateLimite = f.getTime();
		Date dateRen = t.getTime();

		try {
			String d = sdf.format(dateLimite);
			String m = sdf.format(currentDate);
			String w = sdf.format(dateRen);

			Date dateFin = sdf.parse(d);
			Date dateNow = sdf.parse(m);
			Date dateRenou = sdf.parse(w);

			long diff = dateFin.getTime() - dateNow.getTime();
			float res = (diff / (1000 * 60 * 60 * 24));
			long dif = dateRenou.getTime() - dateNow.getTime();
			float ress = (dif / (1000 * 60 * 60 * 24));

			System.out.println("Nombre de jours  est: " + ress);

			if (dateLimite.before(currentDate) || dateLimite.equals(currentDate)) {
				ch = "expiré";
				System.out.println("expiré");
			}

			else if (ress == 0 || ress < 0) {
				ch = "atteint préavis";
			} else if ((ress > 0) && (ress < 31)) {
				ch = ress + " jours avant préavis";
			}

			else if ((res > 0) && (res < 31)) {
				ch = res + " jours avant expiration";
				System.out.println("-30 jours avant expiration");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return ch;

	}

	public String testEtat(Contrat c) {
		String ch = "";
		if (c.getTypeContrat().equals("Ferme")) {
			ch = testEtatFerme(c);
		} else if (c.getTypeContrat().equals("Renouvelable")) {
			ch = testEtatRenouvelable(c);
		}
		return ch;
	}

	public void renouveler(Contrat c) {
		Date currentDate = new Date();
		Calendar m = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		m.setTime(c.getDateRenouvellement());

		int x = c.getNombre();
		if (c.getPeriode().contains("jour")) {

			m.add(Calendar.DATE, x);
		} else if (c.getPeriode().contains("mois")) {

			m.add(Calendar.MONTH, x);
		}

		else if (c.getPeriode().contains("annee")) {
			m.add(Calendar.YEAR, x);
		}

		Date dateLimite = m.getTime();

		if (dateLimite.before(c.getDateFin())) {
			try {
				String d = sdf.format(dateLimite);
				Date dateFin = sdf.parse(d);

				c.setDateRenouvellement(dateFin);
				c.setDateAugmentation(currentDate);
				float r = c.getCout() + ((c.getCout() * c.getTaux()) / 100);
				c.setCout(r);

				c.setEtatContrat("En cours");
			}

			catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public Date DateRenouveler(Contrat c) {

		Calendar m = Calendar.getInstance();
		m.setTime(c.getDateDebut());

		int x = c.getNombre();
		if (c.getPeriode().contains("jour")) {

			m.add(Calendar.DATE, x);
		} else if (c.getPeriode().contains("mois")) {

			m.add(Calendar.MONTH, x);
		}

		else if (c.getPeriode().contains("annee")) {
			m.add(Calendar.YEAR, x);
		}
		int d = -c.getNb();
		if (c.getUnite().contains("jour")) {

			m.add(Calendar.DATE, d);
		} else if (c.getUnite().contains("mois")) {

			m.add(Calendar.MONTH, d);
		}

		else if (c.getUnite().contains("annee")) {
			m.add(Calendar.YEAR, d);
		}

		Date dateLimite = m.getTime();

		return dateLimite;
	}

	public List<Contrat> listContratRenouvelableAtteintPreavis() {
		List<Contrat> list = listContratRenouvelable();
		List<Contrat> l = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String ch = testEtatRenouvelable(list.get(i));
			if (ch.equals("atteint préavis")) {
				l.add(list.get(i));
			}

		}
		return l;
	}

	public List<Contrat> listContratRenouvelableAvantPreavis() {
		List<Contrat> list = listContratRenouvelable();
		List<Contrat> l = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String ch = testEtatRenouvelable(list.get(i));
			if (ch.contains("jours avant préavis")) {
				l.add(list.get(i));
			}

		}
		return l;
	}

	public int nbContratRenouvelableAvantPreavis() {
		int x = listContratRenouvelableAvantPreavis().size();
		return x;
	}

	public int nbContratRenouvelableAtteintPreavis() {
		int x = listContratRenouvelableAtteintPreavis().size();
		return x;
	}

	public void fermer(Contrat c) {
		c.setEtatContrat("annulé");
		c.setTypeContrat("Ferme");
		c.setDelaiPreavis("");
		c.setPeriodeContrat("");
		c.setTaux(0);
	}

	public List<Contrat> listContratAnnuler() {
		List<Contrat> list = null;
		Query q = em.createQuery("select c from Contrat c where c.etatContrat =:etat");

		q.setParameter("etat", "annulé");

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
	}

	public int nbContratAnnuler() {
		int x = listContratAnnuler().size();
		return x;
	}

	public List<Contrat> rechercheParCritere(Cocontractant co, String obj, String type, Categorie cat, String an, String prix,
			Date d, Date f) {
		List<Contrat> res = null;
		List<Contrat> list = null;
		int val1 = 0;
		float val2 = 0;

		boolean test = false;
		boolean test1 = false;
		boolean test2 = false;
		boolean test3 = false;
		boolean test4 = false;
		boolean test5 = false;
		boolean test6 = false;
		boolean test7 = false;
		boolean test8 = false;
		
		
		boolean testType = false;

		if (an.length() != 0) {
			val1 = Integer.parseInt(an);
		}
		if (prix.length() != 0) {
			val2 = Float.parseFloat(prix);
		}
		String req = "select c from Contrat c where ";
		if (co != null) {
			req = req + "c.cocontractant =:c";
			test = true;
			test1 = true;

		}
		if (obj.length() != 0) {
			if (test == false) {
				req = req + "c.objetContrat =:ob";
				test = true;
				test2 = true;
			} else {
				req = req + " and c.objetContrat =:ob";
				test = true;
				test2 = true;

			}

		}
		if (type.length() != 0) {
			if (test == false) {
				if(type.equals("Tous")) {

				req = req + "c.typeContrat =:zz or c.typeContrat =:yy";
				test = true;
				test3 = true;
				testType=true;} else {
					req = req + "c.typeContrat =:t";
					test = true;
					test3 = true;
				}
			} else { if(type.equals("Tous")) {
				testType=true;
				req = req + " and c.typeContrat =:zz or c.typeContrat =:yy";
			test = true;
			test3 = true;}
			else {
				
			
				req = req + " and c.typeContrat =:t";
				test = true;
				test3 = true;
			}
			}
		}

		if (d != null) {
			if (test == false) {
				req = req + "c.dateDebut =:debu";
				test = true;
				test4 = true;

			} else {
				req = req + " and c.dateDebut =:debu";
				test = true;
				test4 = true;

			}

		}
		if (f != null) {
			if (test == false) {
				req = req + "c.dateFin =:fi";
				test = true;
				test5 = true;

			} else {
				req = req + " and c.dateFin =:fi";
				test = true;
				test5 = true;

			}
		}
		if (an.length() != 0) {
			if (test == false) {
				req = req + "c.anneeSignature =:a";
				test = true;
				test6 = true;

			} else {
				req = req + " and c.anneeSignature =:a";
				test = true;
				test6 = true;

			}

		}
		if (prix.length() != 0) {
			if (test == false) {
				req = req + "c.cout =:c";
				test = true;
				test7 = true;

			} else {
				req = req + " and c.cout =:c";
				test = true;
				test7 = true;

			}

		}
		if (cat != null) {
			if (test == false) {
				req = req + "c.categorie =:ca";
				test = true;
				test8 = true;

			} else {
				req = req + " and c.categorie =:ca";
				test = true;
				test8 = true;

			}

		}
		if (test == false) {
			list = listAllContrats();
		}

		else if (test == true) {
			Query q = em.createQuery(req);
			if (test1 == true) {
				q.setParameter("c", co);
			}
			if (test2 == true) {
				q.setParameter("ob", obj);
			}
			if (test3 == true) {
				if (testType == true) {
					q.setParameter("zz", "renouvelable");
					q.setParameter("yy", "ferme");

				}else {
					q.setParameter("t", type);
				}
				
			}
			if (test4 == true) {
				q.setParameter("debu", d);
			}
			if (test5 == true) {
				q.setParameter("fi", f);
			}
			if (test6 == true) {
				q.setParameter("a", val1);
			}
			if (test7 == true) {
				q.setParameter("c", val2);
			}
			if (test8 == true) {
				q.setParameter("ca", cat);
			}
			try {

				res = q.getResultList();

				if (res == null) {
					list = null;

				} else if (res != null) {
					list = res;
				}

			} catch (NoResultException e) {
				// TODO: handle exception
			}
		}

		return list;
	}

	
	public List<String> listNotif() {
        ArrayList<String> res = new ArrayList<String>();
        List<Contrat> list= listPourNotif();
     
       if (list!=null) {
    	   for (int i = 0; i < list.size(); i++) {
   			String ch="Le contrat ' "+list.get(i).getCodeContrat()+" ' a "+list.get(i).getEtatContrat()+" !";
               res.add(ch);
   		}
	}
       
       
		return res;
	}

	
	public List<Contrat> listPourNotif() {
    
		
		List<Contrat> list = null;
		String genre = "% jours avant préavis";
		Query q = em.createQuery("select c from Contrat c where c.typeContrat =:type and (c.etatContrat =:etat or c.etatContrat like :genre)");
		q.setParameter("type", "renouvelable");
		q.setParameter("etat", "atteint préavis");
		q.setParameter("genre", genre);
	

		try {

			list = q.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return list;
		
	}

	
	public int nbNotif() {
		 List<String> list= listNotif();
		 int x=0;
		 if (list!=null) {
			x=listNotif().size();
		}
		 return x;
	}


}