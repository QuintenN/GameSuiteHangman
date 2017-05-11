package domain;

import java.awt.Graphics;

public abstract class Vorm  implements Drawable{
	
	public Omhullende getOmhullende(){
		Omhullende o = new Omhullende(null, 0, 0);
		return o;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	

}
