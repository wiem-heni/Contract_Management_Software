package isi.ztm.ztmcontrat.daoimplements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import isi.ztm.ztmcontrat.daointerface.IDateDao;
import org.springframework.stereotype.Repository;


@Repository
public class DateDaoImp implements IDateDao {

	public Date DateNow() {

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");

		System.out.println("Current Date: " + ft.format(dNow));

		return dNow;
	}

	public Date ConvertStringToDate(String st) {

		Date date1 = null;

		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(st);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date1;
	}

	public Date ConvertLongToDate(long L) {

		Date dt = new Date(L);

		return dt;
	}

	public long ConvertDateToLong(Date dt) {

		return dt.getTime();
	}

	
	public Date ConvertStringToTime(String st) {
		Date date1 = null;

		try {
			date1 = new SimpleDateFormat("hh:mm").parse(st);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date1;
	}

}
