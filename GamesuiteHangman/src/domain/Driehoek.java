package domain;

public class Driehoek extends Vorm{
	private Punt hoekPunt1;
	private Punt hoekPunt2;
	private Punt hoekPunt3;
	
	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3){
		setHoekPunten(hoekPunt1,hoekPunt2,hoekPunt3);
	}
	public void setHoekPunten(Punt hoekPunt1 , Punt hoekPunt2, Punt hoekPunt3){
		if((hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null) || 
		((hoekPunt2.getX() - hoekPunt1.getX()) * (hoekPunt3.getY()-hoekPunt1.getY()) == (hoekPunt3.getX() - hoekPunt1.getX()) * (hoekPunt2.getY()-hoekPunt1.getY()))){
			throw new DomainException("Een hoekpunt is leeg of staat op eenzelfde lijn met de andere hoekpunten.");
		}
		this.hoekPunt1 = hoekPunt1;
		this.hoekPunt2 = hoekPunt2;
		this.hoekPunt3 = hoekPunt3;
	}

	public Punt getHoekPunt1() {
		return hoekPunt1;
	}

	public Punt getHoekPunt2() {
		return hoekPunt2;
	}

	public Punt getHoekPunt3() {
		return hoekPunt3;
	}
	
	@Override
	public boolean equals(Object o){
		boolean result = false;
		
		if(o instanceof Driehoek){
			Driehoek d = (Driehoek) o;
			if(this.getHoekPunt1().equals(d.getHoekPunt1()) && this.getHoekPunt2().equals(d.getHoekPunt2()) && this.getHoekPunt3().equals(d.getHoekPunt3())){
				result = true;
			}
			}
		return result;
		}

	@Override
	public String toString(){
		return "Driehoek: hoekpunt1: " + hoekPunt1.toString() + " - hoekpunt2: " + hoekPunt2.toString() + " - hoekpunt3: " + hoekPunt3.toString();		
	}
}
