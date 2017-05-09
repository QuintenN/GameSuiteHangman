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
		if(breedte <= 0){
			throw new DomainException("breedte mag niet kleiner zijn dan nul"); 
		}
		this.breedte = breedte;
	}

	private void setHoogte(int hoogte) {
		if(hoogte <= 0){
			throw new DomainException("hoogte mag niet kleiner zijn dan nul"); 
		}
		
		this.hoogte = hoogte;
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