package model;

import java.util.ArrayList;

public class ServKnjizica extends Identifikator {
/*U sistemu je potrebno i voditi raèuna o 
 * servisnim knjižicama. 
 * Svaka servisna knjižica ima podatke o automobilu kojem pripada kao i 
 * listu servisa koji su obavljeni na tom automobilu
 * 
 */

private Automobil auto;
private ArrayList<ServisAutomobila> servlista;


public ServKnjizica() {
	super();
	auto = new Automobil();
	servlista = new ArrayList<ServisAutomobila>();
	
}
public ServKnjizica(int id,boolean obrisan,Automobil auto,ArrayList<ServisAutomobila> servlista) {
	super(id,obrisan);
	this.auto = auto;
	this.servlista = servlista;
	
	
}
public Automobil getAuto() {
	return auto;
}
public void setAuto(Automobil auto) {
	this.auto = auto;
}
public ArrayList<ServisAutomobila> getServlista() {
	return servlista;
}
public void setServlista(ArrayList<ServisAutomobila> servlista) {
	this.servlista = servlista;
}	
	


}
