package domain;

import java.util.ArrayList;

public class HintWoord {
	private  ArrayList<HintLetter>woord= new ArrayList<>();
	private boolean geraden= false;
	

	public HintWoord(String woord) {
	setWoord(woord);
	}

	public String getWoord() {
		
		return toString();
	}

	private void setWoord(String w) {
		if (w==null|| w.equals("")){
			throw new DomainException("woord mag niet leeg zijn");
		}
		for(int i=0 ; i<w.length(); i++){
			HintLetter temp =new HintLetter(w.charAt(i));
			System.out.println(woord);
			woord.add(temp);
		}
	}
	public boolean raad(char letter){
		boolean raden= false;
		for(HintLetter i : woord){
			if(i.raad(letter) ){
				raden = true; 
			}
		
		}
		return raden;
	}

	public boolean isGeraden() {
		
		return this.geraden;
	}

	private void setGeraden(boolean geraden) {
		this.geraden = geraden;
	}

	@Override
	public String toString() {
		String result="";
		for(HintLetter i : woord ){
			result+="" + i;
		}
		return result;
	}
	

}
