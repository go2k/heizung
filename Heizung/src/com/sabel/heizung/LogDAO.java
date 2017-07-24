package com.sabel.heizung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogDAO {

	private static String url = "jdbc:mysql://localhost/heizung";
	private static String user = "root";
	private static String pw = "root";
	private static String sqlInsert = "insert into log values (?,?,?,?,?,?,?)";
	private Connection con;
	private PreparedStatement prepStat;

	public LogDAO() throws SQLException {
		con = DriverManager.getConnection(url, user, pw);
		prepStat = con.prepareStatement(sqlInsert);
	}

	public boolean insertLog(Datenbank db) {

		try {
			Messung m;
			for (int i = 1; i < db.gibAnzahlMessungen(); i++) {
				m = db.gibMessung(i);
				prepStat.setString(1, m.getZeitpunkt());
				prepStat.setDouble(2, m.getAt());
				prepStat.setDouble(3, m.getVlt());
				prepStat.setDouble(4, m.getRlt());
				prepStat.setDouble(5, m.getRlst());
				prepStat.setDouble(6, m.getWwt());
				prepStat.setDouble(7, m.getWwst());
				prepStat.execute();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (prepStat != null) {
				try {
					prepStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return false;

	}

	public boolean insertMessung(Messung m) {

		try {
			prepStat.setString(1, m.getZeitpunkt());
			prepStat.setDouble(2, m.getAt());
			prepStat.setDouble(3, m.getVlt());
			prepStat.setDouble(4, m.getRlt());
			prepStat.setDouble(5, m.getRlst());
			prepStat.setDouble(6, m.getWwt());
			prepStat.setDouble(7, m.getWwst());
			prepStat.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (prepStat != null) {
				try {
					prepStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return false;

	}

}
