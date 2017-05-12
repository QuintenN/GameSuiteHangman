package domain;

import java.awt.Graphics;

public abstract class Vorm  implements Drawable{
	private boolean zichtbaar = true;
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
	public boolean isZichtbaar(){
		return zichtbaar;
	}

	public void setZichtbaar(boolean zichtbaar){
		this.zichtbaar = zichtbaar;
	}
	

}
