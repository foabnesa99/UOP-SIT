package model;

import java.util.Scanner;
import java.util.StringJoiner;



public class Musterija extends Osoba{
	private short nagrBodovi;
	
	public Musterija() {
		super();
		nagrBodovi = 0;
		
	}
	public Musterija(int id,boolean obrisan,String ime, String prezime, long jmbg, String pol, String adresa, String brTelefona, String username,
			String password, short nagrBodovi) {
		super(id, obrisan,ime, prezime, jmbg, pol, adresa, brTelefona, username, password);
		
		this.nagrBodovi=nagrBodovi;
	}

	public short getNagrBodovi() {
		return nagrBodovi;
	}

	public void setNagrBodovi(short nagrBodovi) {
		this.nagrBodovi = nagrBodovi;
	}
/*	public String WriteToString() {
		StringJoiner line = new StringJoiner("|");
		line.add(super.WriteToString()).add(this.getNagrBodovi()+"");
		return line.toString();
 		}*/	
	@Override
	public String toString() {
		return ime + " " + prezime;
	}
	
	
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Musterija m = (Musterija)obj;
		if (this.getId() == m.getId()) {
		return true;
		}
		else return false;
	}

	
	
}
