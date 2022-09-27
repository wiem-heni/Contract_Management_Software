package isi.ztm.ztmcontrat.daoimplements;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.opencsv.CSVWriter;

import isi.ztm.ztmcontrat.daointerface.IExportToCSVDao;
@Repository
public class ExportToCSVImpl implements IExportToCSVDao{
	@PersistenceContext
	EntityManager em;
	public ExportToCSVImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public void WriteDataToCSVFile() {
		File fileContrat = new File("contrat.csv");
		List<String[]>	data = new ArrayList<String[]>();
		
		data.add(new String[] { "codeContrat", "Cocontractant", "objet", "type", "Catégorie", "Date début",
				"Date Fin", "Année signature", "Statut", "Coût/prix","Periode renouvellement", "Delais préavis", "Taux d'augmentation", "Date d'augmentation", "Observation"});
		List<String[]>  list = null;
		Query q = em.createQuery("SELECT c.codeContrat, co.nom, c.objetContrat, c.typeContrat, cat.nom, c.dateDebut, c.dateFin, c.anneeSignature, c.etatContrat, c.cout, c.periodeContrat, c.delaiPreavis, c.taux, c.dateAugmentation, c.observation from Contrat as c join c.categorie as cat join c.cocontractant as co ");


		try { 

			 	list = q.getResultList();
				for (String[] str : list) {
				data.add(str);
				}
			 	
				System.out.println("Fin extraire data contrat");

			 	
			 	

		} catch (NoResultException e) {
			// TODO: handle exception
		}
		try {

			System.out.println("Debut export .csv");
			// create FileWriter object with file as parameter
//			FileWriter outputfile = new FileWriter(file);
			
			 FileOutputStream fos = new FileOutputStream(fileContrat); 
			 OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

			// create CSVWriter with '|' as separator
			CSVWriter writer = new CSVWriter(osw, ';', CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

			writer.writeAll(data);

			// closing writer connection
			writer.close();
			data.clear();
			data = new ArrayList<String[]>();

			System.out.println("Fin export .csv");

		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

}
