package com.sabel.heizung;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Datenbank {

	private List<Messung> messungen;

	public Datenbank() {
		super();
		this.messungen = new ArrayList<>();
	}

	public boolean messungHinzufuegen(Messung messung) {

		if (messung != null) {
			messungen.add(messung);
			return true;
		} else {
			return false;
		}
	}

	public int gibAnzahlMessungen() {
		return messungen.size();
	}

	
	public void protokollEinlesen(File file) throws FileNotFoundException {

		if (!file.exists() && file.canRead()) {
			throw new FileNotFoundException();
		}

		BufferedReader br = null;
		br = new BufferedReader(new FileReader(file));

		try {
			String line = "";
			line = br.readLine();
			Messung messung = null;
			while ((line = br.readLine()) != null) {

				String[] splits = line.split("[,]");

				messung = new Messung(splits[0], Double.parseDouble(splits[1]), Double.parseDouble(splits[2]),
						Double.parseDouble(splits[3]), Double.parseDouble(splits[4]), Double.parseDouble(splits[5]),
						Double.parseDouble(splits[6]));
				messungHinzufuegen(messung);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	
	public void messungenAusgeben() {

		for (Messung messung : messungen) {
			System.out.println(messung.toString());
		}
	}
	
	

	public String toJson() {
		String ret = "";

		ret += "{";
			ret += "\"Messungen\":{\n" ;
			for (Messung messung : messungen) {
				ret += messung.toJson();
			}
			ret += "}\n" ;
		ret += "}\n";

		return ret;

	}

	public Messung gibMessung(int nr) {

		if (nr > 0 && nr <= messungen.size()) {
			return messungen.get(nr);
		} else {
			return null;

		}

	}

}
