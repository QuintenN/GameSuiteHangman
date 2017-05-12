package domain;

import java.awt.Color;
import java.awt.Graphics;

public class Rechthoek extends Vorm{

		private int breedte;
		private int hoogte;
		private Punt linkerbovenhoek;
		
		public  Rechthoek(Punt linkerbovenhoek, int breedte, int hoogte ){
			setBreedte(breedte);
			setHoogte(hoogte);
			setLinkerbovenhoek(linkerbovenhoek);
		}
		

		public int getBreedte() {
			return breedte;
		}


		private void setBreedte(int breedte) {
			if (isGeldigeBreedte(breedte) == false){
				throw new DomainException("Breedte mag niet kleiner zijn dan 0");
			}
			this.breedte = breedte;
		}
		
		public static boolean isGeldigeBreedte(int breedte){
			if(breedte <= 0) return false;
			return true;
		}


		public int getHoogte() {
			return hoogte;
		}


		private void setHoogte(int hoogte) {
			if (isGeldigeHoogte(hoogte)== false){
				throw new DomainException("Hoogte mag niet kleiner zijn dan 0");
			}
			this.hoogte = hoogte;
		}
		
		public static boolean isGeldigeHoogte(int hoogte){
			if(hoogte <= 0) return false;
			return true;
		}


		public Punt getLinkerBovenhoek() {
			return linkerbovenhoek;
		}


		private void setLinkerbovenhoek(Punt linkerbovenhoek) {
			if (linkerbovenhoek==null){
				throw new DomainException();
			}
			this.linkerbovenhoek = linkerbovenhoek;
		}
		
		public Omhullende getOmhullende(){
			Omhullende o = new Omhullende(linkerbovenhoek, breedte, hoogte);
			return o;
		}

		@Override
		public String toString() {
			return "Rechthoek: " + getLinkerBovenhoek() + " - breedte: " + getBreedte() + " - hoogte: " + getHoogte();
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Rechthoek other = (Rechthoek) obj;
			if (this.breedte != other.breedte)
				return false;
			if (this.hoogte != other.hoogte)
				return false;
			if (this.linkerbovenhoek == null) {
				if (other.linkerbovenhoek != null)
					return false;
			} else if (!linkerbovenhoek.equals(other.linkerbovenhoek))
				return false;
			return true;
		}


		@Override
		public void teken(Graphics graphics) {
			graphics.setColor(Color.BLUE);
			graphics.drawRect(linkerbovenhoek.getX(), linkerbovenhoek.getY(), getBreedte(), getHoogte());
			
		}
		
}
