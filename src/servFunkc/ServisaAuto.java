package servFunkc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

import model.Administrator;
import model.Automobil;
import model.Musterija;
import model.ServDeo;
import model.ServKnjizica;
import model.ServisAutomobila;
import model.Serviser;
import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;
import model.Automobil.VrstaGoriva;
import model.ServisAutomobila.Status;
import model.Serviser.Specijalizacija;



public class ServisaAuto {
	public static ServisaAuto servis12 = new ServisaAuto();
	private ArrayList<Automobil> auti = new ArrayList<Automobil>();
	private ArrayList<ServDeo> delovi = new ArrayList<ServDeo>();
	private ArrayList<ServisAutomobila> servisi = new ArrayList<ServisAutomobila>();
	private ArrayList<ServKnjizica> knjizica = new ArrayList<ServKnjizica>();
	private ArrayList<Musterija> musterije = new ArrayList<Musterija>();
	private ArrayList<Serviser> serv = new ArrayList<Serviser>();
	private ArrayList<Administrator> admini = new ArrayList<Administrator>();
	
	public ArrayList<Automobil> getAuti() {
		return auti;
	}
	public void dodajAuto(Automobil auto) {
		this.auti.add(auto);
	}

	public void obrisiAuto(Automobil auto) {
		this.auti.remove(auto);
	}
	
	public Automobil nadjiAuto(int id) {
		for (Automobil auto : auti) {
			if (auto.getId() == id) {
				return auto;
			}
		}
		return null;
	}
	
	public ArrayList<Administrator> getAdmin() {
		return admini;
	}
	public void dodajAdmin(Administrator admin) {
		this.admini.add(admin);
	}

	public void obrisiAdmin(Administrator admin) {
		this.admini.remove(admin);
	}
	
	public Administrator nadjiAdmin(int id) {
		for (Administrator admin : admini) {
			if (admin.getId() == id) {
				return admin;
			}
		}
		return null;
	}
	
	public void ucitajAdmin() {
		try {
		File file = new File("src/dba/admin.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		
		while ((line = reader.readLine()) != null) {
			try {
			
			String[] split = line.split("\\|");
			int id = Integer.parseInt(split[0]);
			boolean obrisan = Boolean.parseBoolean(split[1]);
			String ime = split[2];
			String prezime = split[3];
			long jmbg = Long.parseLong(split[4]);
			String pol = split[5];
			String adresa = split[6];
			String brTelefona = split[7];
			String username = split[8];
			String password = split[9];
			int plata = Integer.parseInt(split[10]);
			
			

			
			Administrator admin = new Administrator(id,obrisan,ime,prezime,jmbg,pol,adresa,brTelefona,username,password,plata);
			
			servis12.admini.add(admin);
			
			}
			 catch (NumberFormatException nfe) { nfe.printStackTrace(); }
		}
		reader.close();
	} catch (IOException e) {
		System.out.println("Greska pri ucitavanju Administratora");
		e.printStackTrace();
	}


}

	
	public void sacuvajAdmin() {
		try {
			File file = new File("src/dba/admin.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String stringa = "";
			for (Administrator admin : admini) {
				stringa += admin.getId()+ "|" + admin.isObrisan() + "|" + admin.getIme()+"|"+admin.getPrezime()+"|"+admin.getJmbg()+"|"+ 
			admin.getPol()+"|"+admin.getAdresa()+"|"+admin.getBrTelefona()+"|"+admin.getUsername()+"|"+admin.getPassword()+"|"
						+admin.getPlata()+"\n";
			}
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sacuvajAdmin(Administrator admin) {
		try {
			File file = new File("src/dba/admin.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
			String stringa = "";
			
				stringa += admin.getId()+ "|" + admin.isObrisan() + "|" + admin.getIme()+"|"+admin.getPrezime()+"|"+admin.getJmbg()+"|"+ 
			admin.getPol()+"|"+admin.getAdresa()+"|"+admin.getBrTelefona()+"|"+admin.getUsername()+"|"+admin.getPassword()+"|"
						+admin.getPlata()+"\n";
			
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<ServDeo> getDelovi() {
		return delovi;
	}
	
	public void dodajDeo(ServDeo deo) {
		this.delovi.add(deo);
	}

	public void obrisiDeo(ServDeo deo) {
		this.delovi.remove(deo);
	}
	
	public ServDeo nadjiDeo(int id) {
		for (ServDeo deo : delovi) {
			if (deo.getId() == id) {
				return deo;
			}
		}
		return null;
	}
	
	public void ucitajDeo() {
		try {
			File file = new File("src/dba/delovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = reader.readLine()) != null) {
				try {
				
				String[] split = line.split("\\|");
				int id = Integer.parseInt(split[0]);
				boolean obrisan = Boolean.parseBoolean(split[1]);
				String markaint = split[2];
				String modelint = split[3];
				MarkaVozila marka = MarkaVozila.valueOf(markaint);
				ModeliAuto model = ModeliAuto.valueOf(modelint);
				String naziv = split[4];
				int cena = Integer.parseInt(split[5]);
				
				ServDeo deo = new ServDeo(id,obrisan,marka,model,naziv,cena);
				
				servis12.delovi.add(deo);
				
				}
				 catch (NumberFormatException nfe) { nfe.printStackTrace(); }
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska pri ucitavanju Servisnog Dela");
			e.printStackTrace();
		}
	
	
	}
	
	public void sacuvajDeo(ServDeo deo) {
		try {
			File file = new File("src/dba/delovi.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
			String stringa = "";
			
				stringa += deo.getId()+ "|" + deo.isObrisan() + "|" + deo.getMarkaVoz()+"|"+deo.getModelVoz()+"|"+deo.getNazivDela()+"|"+ 
			deo.getCena()+"\n";
			
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sacuvajDeo() {
		try {
			File file = new File("src/dba/delovi.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String stringa = "";
			for(ServDeo deo : delovi) {
				stringa += deo.getId()+ "|" + deo.isObrisan() + "|" + deo.getMarkaVoz()+"|"+deo.getModelVoz()+"|"+deo.getNazivDela()+"|"+ 
			deo.getCena()+"\n";
			}
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Musterija nadjiMusteriju(int id) {
		for (Musterija must : musterije) {
			if (must.getId() == id) {
				return must;
			}
		}
		return null;
	}
	
	public void dodajMusteriju(Musterija must) {
		this.musterije.add(must);
	}
	
	
	
	public void dodajServis(ServisAutomobila servis) {
		this.servisi.add(servis);
	}

	public void obrisiServis(ServisAutomobila servis) {
		this.servisi.remove(servis);
	}
	
	public ServisAutomobila nadjiServis(int id) {
		for (ServisAutomobila servis : servisi) {
			if (servis.getId() == id) {
				return servis;
			}
		}
		return null;
	}
	
	
	public void ucitajServis() {
		try {
			File file = new File("src/dba/servis.txt");
			
			ServisaAuto.servis12.ucitajAutomobile();
			ServisaAuto.servis12.ucitajDeo();
			ServisaAuto.servis12.ucitajServisera();
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = reader.readLine()) != null) {
				try {
				
				String[] split = line.split("\\|");
				int i = 0;
				int id = Integer.parseInt(split[i++]);
				boolean obrisan = Boolean.parseBoolean(split[i++]);
				String markaint = split[i++];
				MarkaVozila marka = MarkaVozila.valueOf(markaint);
				String modelint = split[i++];
				ModeliAuto model = ModeliAuto.valueOf(modelint);
				int serviserint = Integer.parseInt(split[i++]);
				Serviser serviser = ServisaAuto.servis12.nadjiServ(serviserint);
				LocalDateTime termin = LocalDateTime.parse(split[i++]);
				String opis = split[i++];
				ArrayList<ServDeo> delovi = new ArrayList<ServDeo>();
				String statusint = split[i++];
				ServisAutomobila.Status status = Status.valueOf(statusint);
				while(i<split.length) {
					int deoid = Integer.parseInt(split[i++]);
					ServDeo naziv = ServisaAuto.servis12.nadjiDeo(deoid);
					delovi.add(naziv);
				}
				

				
				ServisAutomobila novi = new ServisAutomobila();
				novi.setId(id);
				novi.setMarka(marka);
				novi.setModel(model);
				novi.setDelovi(delovi);
				novi.setObrisan(obrisan);
				novi.setOpis(opis);
				novi.setServ(serviser);
				novi.setStatus(status);
				novi.setTermin(termin);
				
				servis12.servisi.add(novi);
				
				}
				 catch (NumberFormatException nfe) { nfe.printStackTrace(); }
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska pri ucitavanju Servisa");
			e.printStackTrace();
		}

	
	}
	
	
	public void sacuvajServis() {
		try {
			File file = new File("src/dba/servis.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String stringa = "";
			for (ServisAutomobila servis : servisi) {
				stringa += servis.getId()+ "|" + servis.isObrisan() + "|" + servis.getMarka()+"|"+servis.getModel()+"|"+servis.getServ().getId()+"|"+ 
			servis.getTermin()+"|"+servis.getOpis()+"|"+servis.getStatus()+"|";
			StringJoiner stringJoiner = new StringJoiner("|");
			for(ServDeo deo : servis.getDelovi()) {
				stringJoiner.add(deo.getId()+"");
			}
			stringa+=stringJoiner.toString()+"\n";
			}
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sacuvajServis(ServisAutomobila servis) {
		try {
			File file = new File("src/dba/servis.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
			String stringa = "";
			
			stringa += servis.getId()+ "|" + servis.isObrisan() + "|" + servis.getMarka()+"|"+servis.getModel()+"|"+servis.getServ().getId()+"|"+ 
					servis.getTermin()+"|"+servis.getOpis()+"|"+servis.getStatus()+"|";
					StringJoiner stringJoiner = new StringJoiner("|");
					for(ServDeo deo : servis.getDelovi()) {
						stringJoiner.add(deo.getId()+"");
					}
					stringa+=stringJoiner.toString()+"\n";
					
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Serviser> getServ() {
		return serv;
	}
	
	public void dodajServ(Serviser serviser) {
		this.serv.add(serviser);
	}

	public void obrisiServ(Serviser serviser) {
		this.serv.remove(serviser);
	}
	
	public Serviser nadjiServ(int id) {
		for (Serviser serviser : serv) {
			if (serviser.getId() == id) {
				return serviser;
			}
		}
		return null;
	}
	
	public void ucitajKnjizicu() {
		try {
			File file = new File("src/dba/servisnaknjizica.txt");
			
			ServisaAuto.servis12.ucitajAutomobile();
			ServisaAuto.servis12.ucitajServis();
			
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = reader.readLine()) != null) {
				try {
				
				String[] split = line.split("\\|");
				int i = 0;
				int id = Integer.parseInt(split[i++]);
				boolean obrisan = Boolean.parseBoolean(split[i++]);
				
				int autoint = Integer.parseInt(split[i++]);
				Automobil auto = ServisaAuto.servis12.nadjiAuto(autoint);
				
				ArrayList<ServisAutomobila> servisi = new ArrayList<ServisAutomobila>();
				
				while(i<split.length) {
					int servid = Integer.parseInt(split[i++]);
					ServisAutomobila ser = ServisaAuto.servis12.nadjiServis(servid);
					servisi.add(ser);
				}
				

				
				ServKnjizica novi = new ServKnjizica();
				novi.setId(id);
				novi.setObrisan(obrisan);
				novi.setAuto(auto);
				novi.setServlista(servisi);
				
				servis12.knjizica.add(novi);
				
				}
				 catch (NumberFormatException nfe) { nfe.printStackTrace(); }
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska pri ucitavanju Servisne Knjizice");
			e.printStackTrace();
		}
	}
	
	
	public void sacuvajKnjizica(ServKnjizica knjiz) {
		try {
			File file = new File("src/dba/servisnaknjizica.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
			String stringa = "";
			
			stringa += knjiz.getId()+ "|" + knjiz.isObrisan() + "|" + knjiz.getAuto().getId() + "|";
					StringJoiner stringJoiner = new StringJoiner("|");
					for(ServisAutomobila servis : knjiz.getServlista()) {
						stringJoiner.add(servis.getId()+"");
					}
					stringa+=stringJoiner.toString()+"\n";
					
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public void sacuvajKnjizica() {
		try {
			File file = new File("src/dba/servisnaknjizica.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
			String stringa = "";
			for(ServKnjizica knjiz : knjizica) {
			stringa += knjiz.getId()+ "|" + knjiz.isObrisan() + "|" + knjiz.getAuto().getId() + "|";
					StringJoiner stringJoiner = new StringJoiner("|");
					for(ServisAutomobila servis : knjiz.getServlista()) {
						stringJoiner.add(servis.getId()+"");
					}
					stringa+=stringJoiner.toString()+"\n";
			}
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void ucitajServisera() {
		try {
			File file = new File("src/dba/serviser.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = reader.readLine()) != null) {
				try {
				
				String[] split = line.split("\\|");
				int id = Integer.parseInt(split[0]);
				boolean obrisan = Boolean.parseBoolean(split[1]);
				String ime = split[2];
				String prezime = split[3];
				long jmbg = Long.parseLong(split[4]);
				String pol = split[5];
				String adresa = split[6];
				String brTelefona = split[7];
				String username = split[8];
				String password = split[9];
				int plata = Integer.parseInt(split[10]);
				String specint = split[11];
				Specijalizacija spec = Specijalizacija.valueOf(specint);
				

				
				Serviser serviser = new Serviser(id,obrisan,ime,prezime,jmbg,pol,adresa,brTelefona,username,password,plata,spec);
				
				servis12.serv.add(serviser);
				
				}
				 catch (NumberFormatException nfe) { nfe.printStackTrace(); }
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska pri ucitavanju Servisera");
			e.printStackTrace();
		}
	
	
	}
	
	
	public void sacuvajServisera() {
		try {
			File file = new File("src/dba/serviser.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String stringa = "";
			for (Serviser serviser : serv) {
				stringa += serviser.getId()+ "|" + serviser.isObrisan() + "|" + serviser.getIme()+"|"+serviser.getPrezime()+"|"+serviser.getJmbg()+"|"+ 
			serviser.getPol()+"|"+serviser.getAdresa()+"|"+serviser.getBrTelefona()+"|"+serviser.getUsername()+"|"+serviser.getPassword()+"|"
						+serviser.getPlata()+"|" +serviser.getSpec()+"\n";
			}
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void sacuvajServisera(Serviser serviser) {
		try {
			File file = new File("src/dba/serviser.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
			String stringa = "";
			
				stringa += serviser.getId()+ "|" + serviser.isObrisan() + "|" + serviser.getIme()+"|"+serviser.getPrezime()+"|"+serviser.getJmbg()+"|"+ 
			serviser.getPol()+"|"+serviser.getAdresa()+"|"+serviser.getBrTelefona()+"|"+serviser.getUsername()+"|"+serviser.getPassword()+"|"
						+serviser.getPlata()+"|" +serviser.getSpec()+"\n";
			
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ServisAutomobila> getServis() {
		return servisi;
	}
	
	public ArrayList<ServKnjizica> getKnjizica() {
		return knjizica;
	}
	
	public void dodajServKnJiz(ServKnjizica knjiz) {
		this.knjizica.add(knjiz);
	}

	public void obrisiServKnjiz(ServKnjizica knjiz) {
		this.knjizica.remove(knjiz);
	}
	
	public ServKnjizica nadjiServKnjiz(int id) {
		for (ServKnjizica knjiz : knjizica ) {
			if (knjiz.getId() == id) {
				return knjiz;
			}
		}
		return null;
	}
	
	
	
	
	public ArrayList<Musterija> getMusterija() {
		return musterije;
	}
	
	public void ucitajMusteriju() {
		try {
			File file = new File("src/dba/musterija.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = reader.readLine()) != null) {
				try {
				
				String[] split = line.split("\\|");
				int id = Integer.parseInt(split[0]);
				boolean obrisan = Boolean.parseBoolean(split[1]);
				String ime = split[2];
				String prezime = split[3];
				long jmbg = Long.parseLong(split[4]);
				String pol = split[5];
				String adresa = split[6];
				String brTelefona = split[7];
				String username = split[8];
				String password = split[9];
				short nagrbodovi = Short.parseShort(split[10]);
				

				
				Musterija must = new Musterija(id,obrisan,ime,prezime,jmbg,pol,adresa,brTelefona,username,password,nagrbodovi);
				//System.out.println(musterije);
				servis12.musterije.add(must);
				
				}
				 catch (NumberFormatException nfe) { nfe.printStackTrace(); }
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska pri ucitavanju Musterije");
			e.printStackTrace();
		}
	
	
	}
	
	
	public void ucitajAutomobile() {
		try {
			File file = new File("src/dba/auto.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				int id = Integer.parseInt(split[0]);
				boolean obrisan = Boolean.parseBoolean(split[1]);
				Musterija musterija = servis12.nadjiMusteriju(Integer.parseInt(split[2])); 
				
				String markaint = split[3];
				String modelint = split[4];
				MarkaVozila marka = MarkaVozila.valueOf(markaint);
				ModeliAuto model = ModeliAuto.valueOf(modelint);
				short godproiz = Short.parseShort(split[5]);
				int zaprMotora = Integer.parseInt(split[6]);
				int snagaMotora = Integer.parseInt(split[7]);
				String gorivoint = split[8];
				VrstaGoriva vrstagor = VrstaGoriva.valueOf(gorivoint);
				
				
				Automobil auto = new Automobil(id,obrisan,musterija,marka,model,godproiz,zaprMotora,snagaMotora,vrstagor);
				auti.add(auto);
				Arrays.toString(auti.toArray());
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska pri ucitavanju automobila");
			e.printStackTrace();
		}
		
	}

	public void sacuvajMusteriju() {
		try {
			File file = new File("src/dba/musterija.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String stringa = "";
			for (Musterija must : musterije) {
				stringa += must.getId()+ "|" + must.isObrisan() + "|" + must.getIme()+"|"+must.getPrezime()+"|"+must.getJmbg()+"|"+ 
			must.getPol()+"|"+must.getAdresa()+"|"+must.getBrTelefona()+"|"+must.getUsername()+"|"+must.getPassword()+"|"+must.getNagrBodovi()+"\n";
			}
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * int id,boolean obrisan,String ime, String prezime, long jmbg, String pol, String adresa, String brTelefona, String username,
			String password, short nagrBodovi
		 */
		
	}
	
	
	public void sacuvajMusteriju(Musterija must) {
		try {
			File file = new File("src/dba/musterija.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
			String stringa = "";
			
				stringa += must.getId()+ "|" + must.isObrisan() + "|" + must.getIme()+"|"+must.getPrezime()+"|"+must.getJmbg()+"|"+ 
			must.getPol()+"|"+must.getAdresa()+"|"+must.getBrTelefona()+"|"+must.getUsername()+"|"+must.getPassword()+"|"+must.getNagrBodovi()+"\n";
			
			br.write(stringa);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void sacuvajAuto() {
	try {
		File file = new File("src/dba/auto.txt");
		BufferedWriter br = new BufferedWriter(new FileWriter(file));
		String stringa = "";
		for (Automobil auto : auti) {
			stringa += auto.getId()+ "|" + auto.isObrisan() + "|" + auto.getVlasnik().getId() + "|" + auto.getMarka() + "|" + auto.getModel() + "|" +
					auto.getGodProiz() + "|" +auto.getZaprMotora()+ "|" +auto.getSnagaMotora() + "|" + auto.getVrstaGoriva() +"\n";
		}
		br.write(stringa);
		br.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
public void sacuvajAuto(Automobil auto) {
	try {
		File file = new File("src/dba/auto.txt");
		BufferedWriter br = new BufferedWriter(new FileWriter(file,true));
		String stringa = "";
		
			stringa += auto.getId()+ "|" + auto.isObrisan() + "|" + auto.getVlasnik().getId() + "|" + auto.getMarka() + "|" + auto.getModel() + "|" +
					auto.getGodProiz() +"|" +auto.getZaprMotora()+  "|" + auto.getSnagaMotora() + "|" + auto.getVrstaGoriva() +"\n";
		
		br.write(stringa);
		br.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}



public void izmeniServis(ServisAutomobila servis) {
	
	servisi.set(servisi.indexOf(servis),servis);
	sacuvajServis();
	
}


public void izmeniAuto(Automobil auto) {
	
	auti.set(auti.indexOf(auto),auto);
	sacuvajAuto();
	
}

public void izmeniKnjizicu(ServKnjizica knji) {
	
	knjizica.set(knjizica.indexOf(knji),knji);
	sacuvajKnjizica();
	
}

public void izmeniMusteriju(Musterija must) {
	musterije.set(musterije.indexOf(must), must);
	sacuvajMusteriju();
}
public void izmeniServisera(Serviser serviser) {
	serv.set(serv.indexOf(serviser), serviser);
	sacuvajServisera();
}
public void izmeniAdmin(Administrator administrator) {
	
	admini.set(admini.indexOf(administrator), administrator);
	sacuvajAdmin();
}

public void izmeniDeo(ServDeo deo) {
	delovi.set(delovi.indexOf(deo), deo);
	sacuvajDeo();
}

public boolean LoginMusterija(String username,String pass){
	for(Musterija m : musterije) {
		if(m.getUsername().equals(username) && m.getPassword().equals(pass))return true;
		
		}
	return false;
	
}

public boolean LoginAdmin(String username,String pass){
	for(Administrator a : admini) {
		if(a.getUsername().equals(username) && a.getPassword().equals(pass))return true;
		
		}
	return false;
	
}

public boolean LoginServiser(String username,String pass){
	for(Serviser s : serv) {
		if(s.getUsername().equals(username) && s.getPassword().equals(pass))return true;
		
		}
	return false;
	
}
	/*
 * int id,Musterija vlasnik, MarkaVozila marka, ModeliAuto model, short godProiz, int zaprMotora,
			int snagaMotora, VrstaGoriva vrstaGor,boolean obrisan
 */
	
	

}
