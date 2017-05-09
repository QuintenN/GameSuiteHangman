package domain;

public class Driehoek{
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
	

	
	
}
