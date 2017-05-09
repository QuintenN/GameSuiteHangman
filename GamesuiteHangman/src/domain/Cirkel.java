package domain;


public class Cirkel {
	
	
	

	private int radius;
	private Punt middelpunt;
	public Cirkel(Punt middelpunt, int radius){
		setMiddelpunt(middelpunt);
		setRadius(radius);
	}
	public int getRadius() {
		return radius;
	}
	private void setRadius(int radius) {
		if(radius<=0){
			throw new IllegalArgumentException("radius moet groter zijn dan nul");
		}
		this.radius = radius;
	}
	public Punt getMiddelpunt() {
		return middelpunt;
	}
	private void setMiddelpunt(Punt middelpunt) {
		if(middelpunt==null){
			throw new IllegalArgumentException("middelpunt mag niet leeg zijn ");
		}
		this.middelpunt = middelpunt;
	}
	
	@Override
	public boolean equals(Object o){
		if (o==null){
			throw new IllegalArgumentException("crikel mag niet leeg zijn ");
		}
		if(o instanceof Cirkel  ){	
			Cirkel c= (Cirkel)o;
			
			if( this.getRadius()==c.getRadius() && this.getMiddelpunt().equals( c.getMiddelpunt())){
				return true;
				
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Cirkel [radius=" + radius + "]";
	}
	

}
