package model;

import java.util.StringJoiner;
import model.Uloga;
public class Osoba extends Identifikator{

	protected String ime;
	protected String prezime;
	protected long jmbg;
	protected String pol;
	protected String adresa;
	protected String brTelefona;
	protected String username;
	protected String password;
	protected Uloga uloga;
	public Osoba(int id,boolean obrisan,String ime ,String prezime, long jmbg, String pol,String adresa ,String brTelefona, String username,
			String password) {
		super(id,obrisan);
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.adresa = adresa;
		this.brTelefona = brTelefona;
		this.username = username;
		this.password = password;

	}
	

	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public long getJmbg() {
		return jmbg;
	}

	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrTelefona() {
		return brTelefona;
	}

	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Osoba() {
		super();
		this.ime="Ime";
		this.prezime="Prezime";
		this.jmbg=0000000000000;
		this.pol="Pol";
		this.adresa="Adresa";
		this.brTelefona="0660000000";
		this.username="user";
		this.password="pass";
		
		
		
		
		
	}

public String WriteToString() {
		
		StringJoiner line = new StringJoiner("|");
		line.add(this.getId()+"").add(this.getIme()).add(this.getPrezime()).add(Long.toString((this.getJmbg()))).add(this.getPol()).add(this.getAdresa()).add(this.getBrTelefona());
		line.add(this.getUsername()).add(this.getPassword());
		line.add(this.isObrisan()+"");
		return line.toString();
		
	}

	@Override
	public String toString() {
		return "" + username + ", id=" + id + "";
	}
	
}
