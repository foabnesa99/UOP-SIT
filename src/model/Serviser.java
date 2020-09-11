package model;

public class Serviser extends Osoba{
	
	private int plata;
	public enum Specijalizacija{
		Automehanièar, 
		AutoElektrièar,
		Vulkanizer,  
		Limar 
		
		
	}
	protected Specijalizacija spec;
	
	public Serviser() {
		super();
		plata = 0;
		spec = Specijalizacija.AutoElektrièar;
		uloga = Uloga.Serviser;
		
		
	}
	
	
	
	public Serviser(int id,boolean obrisan,String ime, String prezime, long jmbg, String pol, String adresa, String brTelefona, String username,
			String password, int plata,Specijalizacija spec) {
		super(id,obrisan, ime,prezime, jmbg, pol, adresa, brTelefona, username, password);
		
		this.plata = plata;
		this.spec = spec;
		
	}


	public int getPlata() {
		return plata;
	}


	public void setPlata(int plata) {
		this.plata = plata;
	}


	public Specijalizacija getSpec() {
		return spec;
	}


	public void setSpec(Specijalizacija spec) {
		this.spec = spec;
	}

	public String toString() {
		return ime + " " + prezime;
	}
	
	
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Serviser s = (Serviser)obj;
		if (this.getId() == s.getId()) {
		return true;
		}
		else return false;
	}
	

	
	
}
