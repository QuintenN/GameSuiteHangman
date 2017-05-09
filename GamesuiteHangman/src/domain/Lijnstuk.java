package domain;

public class Lijnstuk {
	private Punt startPunt;
	private Punt eindPunt;
	
	public Lijnstuk(Punt startPunt, Punt eindPunt){
		setStartPunt(startPunt);
		setEindPunt(eindPunt);
	}

	private Punt getStartPunt() {
		return startPunt;
	}
	
	private Punt getStartPunt() {
		return eindPunt;
	}

	private void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
		if(startPunt == null){
			throw new DomainException("Startpunt en Eindpunt mogen niet leeg zijn");
		}
		this.startPunt = startPunt;
		this.eindPunt = eindPunt;
	}
	
	@Override
	public boolean equals(Object o){
		boolean result = false;
		
		if(p instanceof LijnStuk){
			Lijnstuk l = (Lijnstuk) o;
			if(this.getStartPunt().equals(l.getStartPunt()) && this.getEindPunt().equals(l.getEindPunt())){
				result = true;
			}
			return result;
			}
		}
	}

	@Override
	public String toString(){
		String out = "Lijn: startpunt: " + startPunt.toString() + " - eindpunt: " + eindPunt.toString();		
	}
}
