package domain;


public class Cirkel {
	
	
	

	private int radius;
	private Punt middelpunt;
	public Cirkel(Punt middelpunt, int radius){
		
	}
	public int getRadius() {
		return radius;
	}
	private void setRadius(int radius) {
		this.radius = radius;
	}
	private Punt getMiddelpunt() {
		return middelpunt;
	}
	private void setMiddelpunt(Punt middelpunt) {
		this.middelpunt = middelpunt;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Cirkel  ){			
			if( this.getRadius()==((Cirkel) o).getRadius() && this.getMiddelpunt().equals(((Cirkel) o).getMiddelpunt())
		}
	}
	
	@Override
	public String toString() {
		return "Cirkel [radius=" + radius + "]";
	}
	

}
