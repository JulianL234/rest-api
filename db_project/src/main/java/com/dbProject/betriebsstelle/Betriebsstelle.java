package com.dbProject.betriebsstelle;


public class Betriebsstelle {
	
	private String name;
	private String kurzname;
	private String typ;
	
	public Betriebsstelle() {
	}
	
	public Betriebsstelle(String name, String kurzname, String typ) {
		this.name = name;
		this.kurzname = kurzname;
		this.typ = typ;
	}	
	
	public String getName() {
		return name;
	}

	public String getKurzname() {
		return kurzname;
	}

	public String getTyp() {
		return typ;
	}

	@Override
	public String toString() {
		return "Betriebsstelle [name=" + name + ", kurzname=" + kurzname + ", typ=" + typ + "]";
	}
}
