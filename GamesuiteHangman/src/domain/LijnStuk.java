package domain;

public class LijnStuk extends Vorm{
	private Punt startPunt;
	private Punt eindPunt;
	
	public LijnStuk(Punt startPunt, Punt eindPunt){
		setStartEnEindPunt(startPunt, eindPunt);
		
	}

	public Punt getStartPunt() {
		return startPunt;
	}
	
	public Punt getEindPunt() {
		return eindPunt;
	}

	public void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
		if(startPunt == null || eindPunt == null){
			throw new DomainException("Startpunt en Eindpunt mogen niet leeg zijn");
		}
		this.startPunt = startPunt;
		this.eindPunt = eindPunt;
	}
	
	@Override
	public boolean equals(Object o){
		boolean result = false;
		
		if(o instanceof LijnStuk){
			LijnStuk l = (LijnStuk) o;
			if(this.getStartPunt().equals(l.getStartPunt()) && this.getEindPunt().equals(l.getEindPunt())){
				result = true;
			}
			}
		return result;
		}

	@Override
	public String toString(){
		return "Lijn: startpunt: " + startPunt.toString() + " - eindpunt: " + eindPunt.toString();		
	}
}
