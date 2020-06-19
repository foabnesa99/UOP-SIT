package model;

import java.util.ArrayList;
import java.util.List;

import model.Musterija;

public class Automobil extends Identifikator {
	protected Musterija vlasnik;
	protected MarkaVozila marka;
	protected ModeliAuto model;
	short godProiz;
	int zaprMotora;
	int snagaMotora;
	protected VrstaGoriva vrstaGor;
	
	public enum VrstaGoriva {
		Benzin,
		Dizel,
		TNG,
		Metan
		
		
	}

	public enum MarkaVozila {
		Peugeot(1), VW(2), Opel(3), BMW(4), Audi(5),Null(6);

		private List<ModeliAuto> modeli;
		private int redniBr;

		MarkaVozila(int redniBr) {
			this.redniBr = redniBr;
			ArrayList<ModeliAuto> model = new ArrayList<ModeliAuto>();
			for (ModeliAuto m : ModeliAuto.values()) {
				if (m.getMarka()==redniBr) {
					model.add(m);
				}
				this.modeli = model;

			}

		}
		
		
		public List<ModeliAuto> getModeli() {
			return modeli;
		}


		public int getRedniBr() {
			return redniBr;
		}
	
	}

	public enum ModeliAuto {
		_307(1), _208(1),_1007(1), Golf(2), Pasat(2),Polo(2),Insignia(3),
		Corsa(3),Astra(3),
		_520(4), _320(4),M3(4), A3(5),A4(5),A6(5),Null(6);

		private final int marka;

		ModeliAuto(int marka) {
			this.marka = marka;
		}

		public int getMarka() {
			return marka;
		}

		
	}
	public Automobil() {
		super();
		marka = MarkaVozila.Null;
		model = ModeliAuto.Null;
		godProiz = 0;
		zaprMotora = 0;
		snagaMotora = 0;
		vrstaGor = VrstaGoriva.Benzin;
		
	}
	
	
	public Automobil(int id,boolean obrisan,Musterija vlasnik, MarkaVozila marka, ModeliAuto model, short godProiz, int zaprMotora,
			int snagaMotora, VrstaGoriva vrstaGor) {
		super(id,obrisan);
		this.vlasnik = vlasnik;
		this.marka = marka;
		this.model = model;
		this.godProiz = godProiz;
		this.zaprMotora = zaprMotora;
		this.snagaMotora = snagaMotora;
		this.vrstaGor = vrstaGor;
	}

	public Musterija getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Musterija vlasnik) {
		this.vlasnik = vlasnik;
	}

	public MarkaVozila getMarka() {
		return marka;
	}

	public void setMarka(MarkaVozila marka) {
		this.marka = marka;
	}

	public ModeliAuto getModel() {
		return model;
	}

	public void setModel(ModeliAuto model) {
		this.model = model;
	}

	public short getGodProiz() {
		return godProiz;
	}

	public void setGodProiz(short godProiz) {
		this.godProiz = godProiz;
	}

	public int getZaprMotora() {
		return zaprMotora;
	}

	public void setZaprMotora(int zaprMotora) {
		this.zaprMotora = zaprMotora;
	}

	public int getSnagaMotora() {
		return snagaMotora;
	}

	public void setSnagaMotora(int snagaMotora) {
		this.snagaMotora = snagaMotora;
	}

	public VrstaGoriva getVrstaGoriva() {
		return vrstaGor;
	}

	public void setVrstaGoriva(VrstaGoriva vrstaGor) {
		this.vrstaGor = vrstaGor;
	}
	@Override
	public String toString() {
		String s = "Automobil: " + super.toString() + 
				"\nMusterija: "; 
				s += "\n" + vlasnik +  
				"\nMarka Vozila: " + this.marka +
				"Model Vozila :" + this.model +
				"Godina proizvodnje:" + this.godProiz+
				"Zapremina motora:" + this.zaprMotora + 
				"Snaga motora:" + this.snagaMotora + 
				"Vrsta goriva:" + this.vrstaGor;
				
		return s;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Automobil a = (Automobil)obj;
		if (this.getId() == a.getId()) {
		return true;
		}
		else return false;
	}

	
	
}
