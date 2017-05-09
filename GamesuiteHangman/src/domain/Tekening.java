package domain;

import java.util.ArrayList;

public class Tekening {

	private String naam;
	ArrayList<Vorm> vormen;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_Y = 399;
	
	
	public Tekening(String naam) {
	setNaam(naam);
	vormen = new ArrayList<>();
	}
		
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getNaam(){
		return this.naam;	
	}
	
	public void voegToe(Vorm vorm){
		vormen.add(vorm);
	}
	
	public void verwijder(Vorm vorm){
		vormen.remove(vorm);
	}

	public Vorm getVorm(int i){
		return vormen.get(i);
	}
	
	public int getAantalVormen(){
		return vormen.size();				
	}
	
	public boolean bevat(Vorm vorm){
		return vormen.contains(vorm);
	}
	
	@Override
	public String toString() {
		return "tekening met naam " + this.naam + " bestaat uit " + vormen.size(); 
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Tekening){
			Tekening t = (Tekening) obj;
			if(this.getNaam().equals(t.getNaam())){
				result = true;
			}
		}
		
		return result;
	}
}
