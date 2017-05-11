package domain;

public class Omhullende {
	private Punt positieLinksBoven;
	private int breedte;
	private int hoogte;

	public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {	
		setPositieLinksBoven(positieLinksBoven);
		setBreedte(breedte);
		setHoogte(hoogte);
	}
	
	public void vindtParameters(Object obj){
		
		if(obj instanceof LijnStuk){
			LijnStuk l = (LijnStuk) obj;
			
			setBreedte(l.getEindPunt().getX() - l.getStartPunt().getX());
			
			if(l.getStartPunt().getY() < l.getEindPunt().getY()){
				setHoogte(l.getStartPunt().getY() - l.getEindPunt().getY());
				
				Punt p = new Punt(l.getStartPunt().getX(), l.getStartPunt().getY() + hoogte);
				setPositieLinksBoven(p);
			}		
			
			if(l.getStartPunt().getY() >= l.getEindPunt().getY()){
				setHoogte(l.getEindPunt().getY() - l.getStartPunt().getY());
				
				Punt p = new Punt(l.getStartPunt().getX(), l.getStartPunt().getY());
				setPositieLinksBoven(p);
			}
			

		}
		
		if(obj instanceof Driehoek){
			Driehoek d = (Driehoek) obj;
			Punt p1 = new Punt(d.getHoekPunt1().getX(),d.getHoekPunt1().getY());
			Punt p2 = new Punt(d.getHoekPunt2().getX(),d.getHoekPunt2().getY());
			Punt p3 = new Punt(d.getHoekPunt3().getX(),d.getHoekPunt3().getY());
			
			Punt berekend = new Punt(0,0);

			//p1 vergelijk p2 -> berekend
			if (p1.getX() < p2.getX()){	
				if(p1.getY() < p2.getY()){
					berekend = new Punt(p1.getX(),p1.getY());
				}
				if(p1.getY() > p2.getY()){
					berekend = new Punt(p1.getX(),p2.getY());
				}
			} 			
			if (p1.getX() > p2.getX()){
				if(p1.getY() < p2.getY()){
					berekend = new Punt(p2.getX(),p1.getY());
				}
				if(p1.getY() > p2.getY()){
					berekend = new Punt(p2.getX(),p2.getY());
				}
			}
			
			//berekend vergelijk p3 -> berekend
			if (berekend.getX() < p3.getX()){	
				if(berekend.getY() < p3.getY()){
					berekend = new Punt(berekend.getX(),berekend.getY());
				}
				if(berekend.getY() > p3.getY()){
					berekend = new Punt(berekend.getX(),p3.getY());
				}
			} 	
			if (berekend.getX() > p3.getX()){
				if(berekend.getY() < p3.getY()){
					berekend = new Punt(p3.getX(),berekend.getY());
				}
				if(berekend.getY() > p3.getY()){
					berekend = new Punt(p3.getX(),p3.getY());
				}
			}
			setPositieLinksBoven(berekend);	
		}
		
		if(obj instanceof Cirkel){
			Cirkel c = (Cirkel) obj;
			
			setBreedte(c.getMiddelpunt().getX() + 2 * c.getRadius());
			setHoogte(c.getMiddelpunt().getY() + 2 * c.getRadius());
			
			Punt p = new Punt(c.getMiddelpunt().getX() + c.getRadius() , c.getMiddelpunt().getY() + c.getRadius());
			setPositieLinksBoven(p);
		}
		
		if(obj instanceof Rechthoek){
			Rechthoek r = (Rechthoek)obj;
			
			setBreedte(r.getBreedte());
			setHoogte(r.getHoogte());
			setPositieLinksBoven(r.getLinkerBovenhoek());		
		}
	}

	public Punt getLinkerBovenhoek() {
		return positieLinksBoven;
	}

	public int getBreedte() {
		return breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setPositieLinksBoven(Punt positieLinksBoven) {
		if(positieLinksBoven == null){
			throw new DomainException("positie links boven is leeg");
		}
		this.positieLinksBoven = positieLinksBoven;
	}

	private void setBreedte(int breedte) {
		if(breedte < 0){
			throw new DomainException("breedte mag niet kleiner zijn dan nul"); 
		}
		this.breedte = breedte;
	}

	private void setHoogte(int hoogte) {
		if(hoogte < 0){
			throw new DomainException("hoogte mag niet kleiner zijn dan nul"); 
		}
		
		this.hoogte = hoogte;
	}
	
	public int getMinX(){
		return positieLinksBoven.getX();
	}
	
	public int getMinY(){
		return positieLinksBoven.getY();
	}
	
	public int getMaxX(){
		return positieLinksBoven.getX() + breedte;
	}

	public int getMaxY(){
		return positieLinksBoven.getY() + hoogte;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Omhullende){
			Omhullende o = (Omhullende) obj;
			if( (this.getLinkerBovenhoek().equals(o.getLinkerBovenhoek())) && (this.getBreedte() == o.getBreedte()) && (this.getHoogte() == o.getHoogte())){
				result = true;
			}
		}
		
		return result;
	}
	
	@Override
	public String toString(){
		return "Omhullende: " + getLinkerBovenhoek() + " - " + getBreedte() + " - " + getHoogte();		
	}
}