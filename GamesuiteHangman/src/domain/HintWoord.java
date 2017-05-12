package domain;

import java.util.ArrayList;

public class HintWoord {
	private  ArrayList<HintLetter>woord= new ArrayList<>();
	private boolean geraden= false;
	

	public HintWoord(String woord) {
	setWoord(woord);
	}

	public String getWoord() {
		String res = "";
		for(HintLetter i : this.woord){
			res += i.getLetter();
		}
		return res;
	}

	private void setWoord(String w) {
		if (w==null|| w.equals("")){
			throw new DomainException("woord mag niet leeg zijn");
		}
		for(int i=0 ; i<w.length(); i++){
			HintLetter temp =new HintLetter(w.charAt(i));
			woord.add(temp);
		}
	}
	public boolean raad(char letter){
		boolean raden= false;
		System.out.println("test");
		for(HintLetter i : woord){
			
			if(i.raad(letter)){

				raden = true; 
			}
			this.setGeraden(true);
			for(HintLetter j: woord){
			
				if(!j.isGeraden()) this.setGeraden(false);
				
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
		result += woord.get(0).toChar();
		for(int i = 1; i<woord.size(); i++){
			result+=" " + woord.get(i).toChar();
		}
		System.out.println(result);
		return result;
	}
	

}
