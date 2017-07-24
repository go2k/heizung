package com.sabel.heizung;

public class Messung implements Comparable<Messung> {

	private String zeitpunkt;
	private double at;
	private double vlt;
	private double rlt;
	private double rlst;
	private double wwt;
	private double wwst;

	public Messung() {
		super();
	}

	public Messung(String zeitpunkt, double at, double vlt, double rlt, double rlst, double wwt, double wwst) {
		super();
		this.zeitpunkt = zeitpunkt;
		this.at = at;
		this.vlt = vlt;
		this.rlt = rlt;
		this.rlst = rlst;
		this.wwt = wwt;
		this.wwst = wwst;
	}

	public void setZeitpunkt(String zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}

	public void setAt(double at) {
		this.at = at;
	}

	public void setVlt(double vlt) {
		this.vlt = vlt;
	}

	public void setRlt(double rlt) {
		this.rlt = rlt;
	}

	public void setRlst(double rlst) {
		this.rlst = rlst;
	}

	public void setWwt(double wwt) {
		this.wwt = wwt;
	}

	public void setWwst(double wwst) {
		this.wwst = wwst;
	}

	public String getZeitpunkt() {
		return zeitpunkt;
	}

	public double getAt() {
		return at;
	}

	public double getVlt() {
		return vlt;
	}

	public double getRlt() {
		return rlt;
	}

	public double getRlst() {
		return rlst;
	}

	public double getWwt() {
		return wwt;
	}

	public double getWwst() {
		return wwst;
	}

	@Override
	public String toString() {
		return "MessZP: " + zeitpunkt + "   Aussent.: " + at + "   Vorlauft.: " + vlt + "   Rücklauft.: " + rlt
				+ "   Rücklaufsollt.: " + rlst + "   Warmwassert.: " + wwt + "   Warmwassersollt.: " + wwst;
	}

	public String toJson() {
		String ret = "";

		ret += "{";
			ret += "\"Messung\":{\n" ;
				ret += "\"Messzeitpunkt\":\"" + zeitpunkt + "\",\n";
				ret += "\"Aussentemperatur\":\"" + zeitpunkt + "\",\n";
				ret += "\"Vorlauftemperatur\":\"" + zeitpunkt + "\",\n";
				ret += "\"Rücklauftemperatur\":\"" + zeitpunkt + "\",\n";
				ret += "\"Rücklaufsolltemperatur\":\"" + zeitpunkt + "\",\n";
				ret += "\"Warmwassertemperatur\":\"" + zeitpunkt + "\",\n";
				ret += "\"Warmwassersolltemperatur\":\"" + zeitpunkt + "\"\n";
			ret += "}\n" ;
		ret += "}\n";

		return ret;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(at);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rlst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rlt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vlt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(wwst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(wwt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((zeitpunkt == null) ? 0 : zeitpunkt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Messung other = (Messung) obj;
		if (Double.doubleToLongBits(at) != Double.doubleToLongBits(other.at))
			return false;
		if (Double.doubleToLongBits(rlst) != Double.doubleToLongBits(other.rlst))
			return false;
		if (Double.doubleToLongBits(rlt) != Double.doubleToLongBits(other.rlt))
			return false;
		if (Double.doubleToLongBits(vlt) != Double.doubleToLongBits(other.vlt))
			return false;
		if (Double.doubleToLongBits(wwst) != Double.doubleToLongBits(other.wwst))
			return false;
		if (Double.doubleToLongBits(wwt) != Double.doubleToLongBits(other.wwt))
			return false;
		if (zeitpunkt == null) {
			if (other.zeitpunkt != null)
				return false;
		} else if (!zeitpunkt.equals(other.zeitpunkt))
			return false;
		return true;
	}

	@Override
	public int compareTo(Messung o) {
		return 0;

	}

}
