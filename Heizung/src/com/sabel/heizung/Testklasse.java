package com.sabel.heizung;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Testklasse {

	public static void main(String[] args) throws FileNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Datenbank db = new Datenbank();

		db.protokollEinlesen(new File("files\\heizung.csv"));
		
		LogDAO logdao = new LogDAO() ;
		
		logdao.insertLog(db);
		
		

		System.out.println(db.gibAnzahlMessungen());

		// db.messungenAusgeben();

		Messung m = db.gibMessung(200);
		System.out.println(m.toString());
		//System.out.println(m.toJson());
		
		//System.out.println(db.toJson());
		
		
		m = db.gibMessung(0);

		if (m != null) {
			System.out.println(m.toString());
		}

		m = db.gibMessung(3000);
		if (m != null) {
			System.out.println(m.toString());
		}
		
		
	}

}
