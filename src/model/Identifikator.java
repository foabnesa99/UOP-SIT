package model;

public class Identifikator {
protected int id;
protected boolean obrisan;


public Identifikator() {
	id=0;
	obrisan = false;
	
}

public Identifikator(int id,boolean obrisan) {
	this.id = id;
	this.obrisan = obrisan;
	
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public boolean isObrisan() {
	return obrisan;
}

public void setObrisan(boolean obrisan) {
	this.obrisan = obrisan;
}

public void setIdFromFile(int id) {
	this.id=id;
}


}
