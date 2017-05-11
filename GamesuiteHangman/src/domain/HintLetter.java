package domain;

public class HintLetter {
	private char letter;
	private boolean geraden = false;
	
	public HintLetter(char letter){
		this.setLetter(letter);
	}	
	
	private void setLetter(char letter) {
		this.letter = letter;
		
	}

	public char getLetter() {
		return letter;
	}
	
	public boolean raad(char letter){
		
		if(("" + letter).toLowerCase().equals(("" + this.getLetter()).toLowerCase())){
			if(this.isGeraden()){
				return false;
			}
			setGeraden(true);
			return true;
		} else {
			return false;
		}
	}
	
	private void setGeraden(boolean geraden) {
		this.geraden = geraden;
	}

	public char toChar() {
		if(!this.isGeraden()){
			return '_';
		}
		return this.getLetter();
	}

	public boolean isGeraden(){
		return geraden;
	}
	
}
