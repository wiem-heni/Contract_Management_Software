package ztm.ztmContrat.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class BatchEnvoieMail {

	public BatchEnvoieMail() {

		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	public String testEtatFerme(String dateF) {
		String ch = "en cours";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat format_en  = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();

		try {
			
			  Date date_en = format_en.parse(dateF);
		        String temps_fr = sdf.format(date_en);
			
			String x = sdf.format(currentDate);
			Date dateFin = sdf.parse(temps_fr);
			Date dateNow = sdf.parse(x);
			long diff = dateFin.getTime() - dateNow.getTime();
			float res = (diff / (1000 * 60 * 60 * 24));
			System.out.println("Nombre de jours entre les deux dates est: " + res);
			if ((res > 0) && (res < 31)) {
				System.out.println(res + " jours avant expiration");
				ch = "-30 jours avant expiration";
			}

			else if (dateFin.before(currentDate) || dateFin.equals(currentDate)) {

				ch = "expiré";

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return ch;

	}
	
	
	
	
	
	
	public String testEtatRenouvelable(String dateF, String dateR, String nb, String unit) throws ParseException {
		String ch = "en cours";
		Calendar f = Calendar.getInstance();
		Calendar t = Calendar.getInstance();
		 SimpleDateFormat format_en  = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date currentDate = new Date();
		int val = 0;
        Date date_en = format_en.parse(dateF);
        String temps_fr = sdf.format(date_en);
        Date date_en_e = format_en.parse(dateR);
        String temps_fr_r = sdf.format(date_en_e);
		


		Date dateRenouvellement = sdf.parse(temps_fr_r);
		Date dateFinal = sdf.parse(temps_fr);
		
		f.setTime(dateFinal);
		t.setTime(dateRenouvellement);
		val = Integer.parseInt(nb);
		int x = -val;
		if (unit.contains("jour")) {

			f.add(Calendar.DATE, x);
		} else if (unit.contains("mois")) {

			f.add(Calendar.MONTH, x);
		}

		else if (unit.contains("annee")) {
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

	final String username = "zitounatamkeencontrat@gmail.com";

	final String password = "a276021dm";
	Properties props = new Properties();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BatchEnvoieMail c = new BatchEnvoieMail();

		Connection con = null;

		// create a List which contains String array
		List<String[]> data = new ArrayList<String[]>();
		List<String[]> dataNouv = new ArrayList<String[]>();

		con = c.connectToDataBaseMysql(con);

		data = c.ExportContratData(data, con);
        try {
			dataNouv=c.testEtat(data);
		} catch (ParseException e) {
			System.out.println("problem heeeeeere");
			e.printStackTrace();
		}
		c.sendEmail("elheniwiem20@gmail.com", dataNouv);
c.updateData(dataNouv, con);
		c.CloseConnectionMysql(con);

	}
	
	
	
	public List<String[]> testEtat(List<String[]> data) throws ParseException{
		
		
		for (String[] str : data) {
		if (str[0].equals("Renouvelable")) {
			try {
				String ch=testEtatRenouvelable( str[5],  str[6],  str[7],  str[8]);
					str[4]=ch;	
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else if (str[0].equals("Ferme")) {
			String ch=testEtatFerme(str[5]);

				str[4]=ch;
		}	
		}
		for (String[] str : data) {
			for (int j = 0; j < str.length; j++) {
				System.out.println(str[j]);;
			}
		}
		return data;
		
	}
	
	

	public void sendEmail(String receiver, List<String[]> data) {

		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.host", "outlook.office365.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
			message.setSubject("Etat contrat ZTM");
			String object = "";
			for (String[] str : data) {
				
				if (str[4].equals("expiré")) {
					object = object +"Le contrat "+str[1]+" dont l'objet est "+str[2]+" et dont le cocontractant est "+str[3]+" est "+str[4]+"\n";
						System.out.print(object);}
						else if (str[4].contains("jours avant expiration")) {
					object = object +"Le contrat "+str[1]+" dont l'objet est "+str[2]+" et dont le cocontractant est "+str[3]+" a "+str[4]+"\n";

						}
						else if (str[4].contains("jours avant préavis")) {
				  object = object +"Le contrat "+str[1]+" dont l'objet est "+str[2]+" et dont le cocontractant est "+str[3]+" a "+str[4]+"\n";

								}
						
				    else if (str[4].contains("atteint préavis")) {
					object = object +"Le contrat "+str[1]+" dont l'objet est "+str[2]+" et dont le cocontractant est "+str[3]+" a "+str[4]+"\n";

								}}
		
			message.setText(object);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public Connection CloseConnectionMysql(Connection con) {

		try {
			con.close();
			System.out.println("connection Base de données fermé");
			System.out.println("Export terminé");
		} catch (SQLException e) {
			System.out.println("Problème de fermeture connection");
			e.printStackTrace();
		}
		return con;
	}

	public Connection connectToDataBaseMysql(Connection con) {

		System.out.println("Vous commencez connecter BD");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		// here sonoo is database name, root is username and password
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tamkeen", "root", "root");
			System.out.println("Vous connectez BD avec succès");
		} catch (SQLException e) {
			System.out.println("Problème connection BD");
			e.printStackTrace();
		}

		return con;

	}

	public List<String[]> ExportContratData(List<String[]> data, Connection con) {

		ResultSet rs = null;

		System.out.println("Début extraire data contrat");

		// create a List which contains String array
		data = new ArrayList<String[]>();

		String reqListContrat = "SELECT c.typeContrat as typ ,c.codeContrat as code, c.objetContrat as obj, co.nom as nomCocontractant, c.etatContrat as statut, c.dateFin as dateF, c.dateRenouvellement as dateR, c.nb as nombre, c.unite as unit from Contrat c join Cocontractant co on c.co_id=co.id";

		try {
			PreparedStatement preparedStmt = con.prepareStatement(reqListContrat);

			rs = preparedStmt.executeQuery();

			while (rs.next()) {

				data.add(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });

			}

		} catch (SQLException e) {
			System.out.println("problem");
			e.printStackTrace();
		}

		System.out.println("Fin extraire data contrat");
		return data;

	}
	public void updateData(List<String[]> data, Connection con) {


		System.out.println("Début update data contrat");


		
		
		for (String[] str : data) {
			
		String reqListContrat = "update Contrat c set c.etatContrat ='"+str[4]+"' where c.codeContrat ='"+str[1]+"'";
                  
		try {
			PreparedStatement preparedStmt = con.prepareStatement(reqListContrat);
			
			 preparedStmt.executeUpdate(reqListContrat);

	

		} catch (SQLException e) {
			System.out.println("problem updaaaaaate");
			e.printStackTrace();
		}
		}
		System.out.println("Fin update data contrat");

	}
}
