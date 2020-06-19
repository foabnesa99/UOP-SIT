package model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;

public class ServisAutomobila extends Identifikator {
//Za svaki servis se evidentiraju sledeæi podaci: Automobil koji se servisira, 
	//serviser koji vrši servis, termin (datum i vreme) servisa, 
	//kratak opis i lista delova koji su upotrebljeni u toku servisa i status servisa. • 

	
protected Automobil.MarkaVozila marka;
protected Automobil.ModeliAuto model;
protected Serviser serv;
protected LocalDateTime termin;
protected String opis;
protected ArrayList<ServDeo> delovi;
protected Status status;
public enum Status{
	NijeZakazan,
	Zakazan,
	U_Toku,
	Zavrsen,
	Otkazan;
}

public ServisAutomobila() {
	super();
	termin =LocalDateTime.now() ;
	opis = "Opis kvara";
	status = Status.NijeZakazan;
	
}


public ServisAutomobila(int id, boolean obrisan,MarkaVozila marka,ModeliAuto model,Serviser serv,LocalDateTime termin,String opis, 
		 Status status,	ArrayList<ServDeo> delovi ) {
	super(id,obrisan);
	this.marka=marka;
	this.model = model;
	this.serv = serv;
	this.termin=termin;
	this.opis=opis;
	this.delovi=delovi;
	this.status=status;
	
	
}





public Automobil.MarkaVozila getMarka() {
	return marka;
}


public void setMarka(Automobil.MarkaVozila marka) {
	this.marka = marka;
}


public Automobil.ModeliAuto getModel() {
	return model;
}


public void setModel(Automobil.ModeliAuto model) {
	this.model = model;
}


public Serviser getServ() {
	return serv;
}


public void setServ(Serviser serv) {
	this.serv = serv;
}


public LocalDateTime getTermin() {
	return termin;
}


public void setTermin(LocalDateTime termin) {
	this.termin = termin;
}


public String getOpis() {
	return opis;
}


public void setOpis(String opis) {
	this.opis = opis;
}


public ArrayList<ServDeo> getDelovi() {
	return delovi;
}


public void setDelovi(ArrayList<ServDeo> delovi) {
	this.delovi = delovi;
}


public Status getStatus() {
	return status;
}


public void setStatus(Status status) {
	this.status = status;
}

public String toString() {
	return marka + " " + model + " " + status;
}


public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	ServisAutomobila a = (ServisAutomobila)obj;
	if (this.getId() == a.getId()) {
	return true;
	}
	else return false;
}



}
