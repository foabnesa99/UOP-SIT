package model;

import model.Automobil.MarkaVozila;
import model.Automobil.ModeliAuto;

public class ServDeo extends Identifikator{
/*
 * Za svaki servisni deo potrebno je evidentirati: 
 * marku i model automobila za koji je deo namenjen, 
 * naziv dela i njegovu cenu. 
 * 
 */

protected Automobil.MarkaVozila markaVoz;
protected Automobil.ModeliAuto modelVoz;
protected String nazivDela;
protected int cena;


public ServDeo() {
	super();
	markaVoz = MarkaVozila.Null;
	modelVoz = ModeliAuto.Null;
	nazivDela = " ";
	cena = 0;
	
	
}
public ServDeo(int id,boolean obrisan,MarkaVozila markaVoz,ModeliAuto modelVoz ,String nazivDela, int cena) {
	super(id,obrisan);
	this.markaVoz = markaVoz;
	this.modelVoz = modelVoz;
	this.nazivDela = nazivDela;
	this.cena = cena;
	
	
	
}
public Automobil.MarkaVozila getMarkaVoz() {
	return markaVoz;
}
public void setMarkaVoz(Automobil.MarkaVozila markaVoz) {
	this.markaVoz = markaVoz;
}
public Automobil.ModeliAuto getModelVoz() {
	return modelVoz;
}
public void setModelVoz(Automobil.ModeliAuto modelVoz) {
	this.modelVoz = modelVoz;
}
public String getNazivDela() {
	return nazivDela;
}
public void setNazivDela(String nazivDela) {
	this.nazivDela = nazivDela;
}
public int getCena() {
	return cena;
}
public void setCena(int cena) {
	this.cena = cena;
}
public String toString() {
	return markaVoz + " " + modelVoz + " " + nazivDela;
}


public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	ServDeo a = (ServDeo)obj;
	if (this.getId() == a.getId()) {
	return true;
	}
	else return false;
}


}
