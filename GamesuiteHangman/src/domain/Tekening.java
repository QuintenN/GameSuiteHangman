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
		if( naam==null ||naam.equals("")){
			throw new IllegalArgumentException("naam mag niet leeg zijn");
		}
		this.naam = naam;
	}

	public String getNaam(){
		return this.naam;	
	}
	
	public void voegToe(Vorm vorm){
		if(vorm instanceof LijnStuk){
			LijnStuk l = (LijnStuk) vorm;
			if(l.getStartPunt().getX()<this.getMinX() || l.getStartPunt().getX()>this.getMaxX() || l.getStartPunt().getY()<this.getMinY() || l.getStartPunt().getY()>this.getMaxY()){
				if(l.getEindPunt().getX()<this.getMinX() || l.getEindPunt().getX()>this.getMaxX() || l.getEindPunt().getY()<this.getMinY() || l.getEindPunt().getY()>this.getMaxY()){
					throw new DomainException();
				}
			}
		}
		if(vorm instanceof Driehoek){
			Driehoek d = (Driehoek) vorm;
			if(d.getHoekPunt1().getX()<this.getMinX() || d.getHoekPunt1().getX()>this.getMaxX() || d.getHoekPunt1().getY()<this.getMinY() || d.getHoekPunt1().getY()>this.getMaxY()){
				if(d.getHoekPunt2().getX()<this.getMinX() || d.getHoekPunt2().getX()>this.getMaxX() || d.getHoekPunt2().getY()<this.getMinY() || d.getHoekPunt2().getY()>this.getMaxY()){
					if(d.getHoekPunt3().getX()<this.getMinX() || d.getHoekPunt3().getX()>this.getMaxX() || d.getHoekPunt3().getY()<this.getMinY() || d.getHoekPunt3().getY()>this.getMaxY()){
						throw new DomainException();
					}
				}
			}
		}
		if(vorm instanceof Cirkel){
			Cirkel c = (Cirkel) vorm;
			if(c.getMiddelpunt().getX()-c.getRadius()<this.getMinX() || c.getMiddelpunt().getY()-c.getRadius()<this.getMinY() || c.getMiddelpunt().getX()+c.getRadius()>this.getMaxX() || c.getMiddelpunt().getY()+c.getRadius()>this.getMaxY()){
				throw new DomainException();
			}
		}
		if(vorm instanceof Rechthoek){
			Rechthoek h = (Rechthoek) vorm;
			if(h.getLinkerBovenhoek().getX()<this.getMinX() || h.getLinkerBovenhoek().getX()>this.getMaxX() || h.getLinkerBovenhoek().getY()<this.getMinY() || h.getLinkerBovenhoek().getY()>this.getMaxY()){
				if(h.getLinkerBovenhoek().getX()+h.getBreedte()>this.getMaxX() || h.getLinkerBovenhoek().getY()+h.getHoogte() > this.getMaxY()){
					throw new DomainException();
				}
			}
		}
		vormen.add(vorm);
	}
	
	public int getMinX() {
		return MIN_X;
	}

	public int getMinY() {
		return MIN_Y;
	}

	public int getMaxX() {
		return MAX_X;
	}

	public int getMaxY() {
		return MAX_Y;
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
