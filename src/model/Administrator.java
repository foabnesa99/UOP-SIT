package model;
import model.Uloga;
public class Administrator extends Osoba{
	private int plata;
	
	public Administrator() {
		super();
		plata = 0;
		uloga = Uloga.Administrator;
	}
	
	public Administrator(int id,boolean obrisan,String ime, String prezime, long jmbg, String pol, String adresa, String brTelefona, String username,
			String password, int plata) {
		super(id,obrisan, ime, prezime, jmbg, pol, adresa, brTelefona, username, password);
		
		this.plata = plata;
		
	}

	public int getPlata() {
		return plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}

	public String toString() {
		return ime + " " + prezime;
	}
	
	
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Administrator a = (Administrator)obj;
		if (this.getId() == a.getId()) {
		return true;
		}
		else return false;
	}
		
}
