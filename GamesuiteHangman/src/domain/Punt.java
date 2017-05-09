package domain;

public class Punt {


	int x, y;
	
	public Punt(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Punt){
			Punt p = (Punt) obj;
			if(this.getY() == p.y && this.getX() == p.x){
				result = true;
			}
		}
		
		return result;
	}

	@Override
	public String toString() {
		return "(" + getX() +", " + getY()+ ")";
	}

}
