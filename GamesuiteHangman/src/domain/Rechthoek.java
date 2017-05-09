package domain;

public class Rechthoek {

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
			if (breedte<=0){
				throw new DomainException();
			}
			this.breedte = breedte;
		}


		public int getHoogte() {
			return hoogte;
		}


		private void setHoogte(int hoogte) {
			if (hoogte<=0){
				throw new DomainException();
			}
			this.hoogte = hoogte;
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
		

		@Override
		public String toString() {
			return "Rechthoek [breedte=" + breedte + ", hoogte=" + hoogte + ", linkerbovenhoek=" + linkerbovenhoek
					+ "]";
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
			if (breedte != other.breedte)
				return false;
			if (hoogte != other.hoogte)
				return false;
			if (linkerbovenhoek == null) {
				if (other.linkerbovenhoek != null)
					return false;
			} else if (!linkerbovenhoek.equals(other.linkerbovenhoek))
				return false;
			return true;
		}
		
}
