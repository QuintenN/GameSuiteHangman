package domain;

public class Speler {
	
	String naam;
	int score;
	
	public Speler(String naam) {
		setNaam(naam);
		setScore(0);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if(naam == null || naam.trim().isEmpty()) throw new DomainException("De spelersnaam mag niet null of leeg zijn");
		this.naam = naam;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if(score < 0) throw new DomainException();
		this.score = score;
	}
	
	public int addToScore(int aantal){
		if((getScore()+aantal) < 0) throw new DomainException("foute score");
		return score+=aantal;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Speler){
			Speler s = (Speler) obj;
			if(this.getNaam().equals(s.getNaam()) && this.getScore() == s.getScore()){
				result = true;
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return "De speler met naam" + getNaam() + " heeft als score " + getScore() + ".";
	}

	
	
}
