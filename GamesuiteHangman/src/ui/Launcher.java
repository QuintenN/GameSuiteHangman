package ui;

import javax.swing.JOptionPane;
import domain.Cirkel;
import domain.DomainException;
import domain.Driehoek;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Tekening;

public class Launcher {

	public static void main(String[] args) {
		
		Tekening tekening = new Tekening("naam");
		Speler speler = new Speler("naam");
		
		
		
		
		String naam = "";
		
		while(!Speler.isGeldigeNaam(naam)){
		try {
			naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
			speler = new Speler(naam);
			JOptionPane.showMessageDialog(null," " + speler, " " + naam, JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
		boolean correcteTekeningNaam = false;
		
		while (correcteTekeningNaam == false) {
			try {
				naam = JOptionPane.showInputDialog("Wat is de naam van de tekening");
				tekening = new Tekening(naam);
				JOptionPane.showMessageDialog(null," " + tekening, " " + naam, JOptionPane.INFORMATION_MESSAGE);
				correcteTekeningNaam = true;
			} catch (DomainException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		}
		
		boolean gevonden = false;
		
		while(!gevonden){
		
		Object [] shapes = {"Cirkel", "Rechthoek", "LijnStuk", "Driehoek", "Quit"};
		String keuze = (String) JOptionPane.showInputDialog(null, "wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		switch (keuze) {
		case "Cirkel":
			int radius = 0;
				
			boolean geldigpunt1 = false;
			boolean geldigpunt2 = false;
				
			int xpunt1 = 0;
			int ypunt1 = 0;
				
			while(geldigpunt1 == false && geldigpunt2 == false){
			
				try {
					xpunt1 = Integer.parseInt(JOptionPane.showInputDialog("X coordinaat van het punt:"));
					ypunt1 = Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het punt:"));
					geldigpunt1 = true;
					geldigpunt2 = true;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "De coordinaten die je probeerde in te voeren zijn niet correct");
				}		
				}
				Punt punt1 = new Punt(xpunt1, ypunt1);
				JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt1 );
			
				
				
				boolean correcteradius = false;
				while(correcteradius == false){
					try{
				radius = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel:"));
				Cirkel cirkel = new Cirkel(punt1, radius);
				
				JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt:" + cirkel);
				tekening.voegToe(cirkel);
				correcteradius = true;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Radius mag niet leeg zijn");
				} catch (DomainException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
			}
				}
				
			break;
			
		case "Rechthoek":
				
				boolean geldigpunt3 = false;
				boolean geldigpunt4 = false;
				
				int xpunt2 = 0;
				int ypunt2 = 0;
				
				Punt Rechthoekpunt = new Punt(0, 0);
				
				Rechthoek rechthoek = new Rechthoek(Rechthoekpunt, 0, 0);
				
				while(geldigpunt3 == false && geldigpunt4 == false){
			
				try {
					xpunt2 = Integer.parseInt(JOptionPane.showInputDialog("X coordinaat van het punt:"));
					ypunt2 = Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het punt:"));
					geldigpunt3 = true;
					geldigpunt4 = true;
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "De coordinaten die je probeerde in te voeren zijn niet correct");
				}		
				}
				Punt punt2 = new Punt(xpunt2, ypunt2);
				JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt2 );
				
				int breedte = 1;
				int hoogte = 1;
				
				boolean breedtegevonden = false;
				boolean hoogtegevonden = false;
				
				while(breedtegevonden == false){
				try {
					breedte = Integer.parseInt(JOptionPane.showInputDialog("Breedte van de rechthoek:"));
					rechthoek = new Rechthoek(punt2, breedte, hoogte);
					tekening.voegToe(rechthoek);
					breedtegevonden = true;
				} catch (DomainException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "De breedte is niet correct");
				}
					
				}
				
				
				
				while(hoogtegevonden == false){
					try {
						hoogte = Integer.parseInt(JOptionPane.showInputDialog("hoogte van de rechthoek:"));
						rechthoek = new Rechthoek(punt2, breedte, hoogte);
						hoogtegevonden = true;
					} catch (DomainException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "De breedte is niet correct");
					}
					}
				
					rechthoek = new Rechthoek(punt2, breedte, hoogte);
					JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + rechthoek);
			break;
		
		case "LijnStuk":
				
				boolean geldigpunt5 = false;
				boolean geldigpunt6 = false;
				
				int xpunt3 = 0;
				int ypunt3 = 0;
				
				while(geldigpunt5 == false && geldigpunt6 == false){
			
				try {
					xpunt3 = Integer.parseInt(JOptionPane.showInputDialog("X coordinaat van het punt:"));
					ypunt3 = Integer.parseInt(JOptionPane.showInputDialog("Y coordinaat van het punt:"));
					geldigpunt5 = true;
					geldigpunt6 = true;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}		
				}
				
				Punt punt3 = new Punt(xpunt3, ypunt3);
				JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt3 );
				
				
				int xbeginPunt = 0;
				int ybeginPunt = 0;
				int xeindPunt = 0;
				int yeindPunt = 0;
				
				Punt beginpunt = new Punt(xbeginPunt, ybeginPunt);
				Punt eindpunt = new Punt(xeindPunt, yeindPunt);
				LijnStuk lijnstuk = new LijnStuk(beginpunt, eindpunt);
				
				boolean correctbeginPunt = false;
				
				while (correctbeginPunt == false) {
					try {
						xbeginPunt = Integer.parseInt(JOptionPane.showInputDialog("X_positie van het beginPunt van het lijnstuk"));
						ybeginPunt = Integer.parseInt(JOptionPane.showInputDialog("Y_positie van het beginPunt van het lijnstuk"));
						beginpunt = new Punt(xbeginPunt, ybeginPunt);
						JOptionPane.showMessageDialog(null, "U heeft een correct beginPunt aangemaakt: " + beginpunt );
						correctbeginPunt = true;
					} catch (DomainException e) {
						JOptionPane.showMessageDialog(null, e.getMessage() );
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Het beginpunt is niet correct");
						}
				}
				
				boolean correcteindPunt = false;
				
				while (correcteindPunt == false) {
					try {
						xeindPunt = Integer.parseInt(JOptionPane.showInputDialog("X_positie van het eindPunt van het lijnstuk"));
						yeindPunt = Integer.parseInt(JOptionPane.showInputDialog("Y_positie van het eindPunt van het lijnstuk"));
						eindpunt = new Punt(xbeginPunt, yeindPunt);
						JOptionPane.showMessageDialog(null, "U heeft een correct eindPunt aangemaakt: " + eindpunt );
						correcteindPunt = true;
					} catch (DomainException e) {
						JOptionPane.showMessageDialog(null, e.getMessage() );
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Het eindpunt is niet correct");
						}
				}
				
				lijnstuk = new LijnStuk(beginpunt, eindpunt);
				tekening.voegToe(lijnstuk);
				JOptionPane.showMessageDialog(null, "U heeft een correct lijnstuk aangemaak: " + lijnstuk);
				
			break;
		case "Driehoek":
		
			
			
			
			int hoekpunt1x = 1;
			int hoekpunt1y = 1;
			int hoekpunt2x = 3;
			int hoekpunt2y = 3;
			int hoekpunt3x = 3;
			int hoekpunt3y = 1;
			
			Punt hoekPunt1 = new Punt(hoekpunt1x, hoekpunt1y);
			Punt hoekPunt2 = new Punt(hoekpunt2x, hoekpunt2y);
			Punt hoekPunt3 = new Punt(hoekpunt3x, hoekpunt3y);
			
			Driehoek driehoek = new Driehoek(hoekPunt1, hoekPunt2, hoekPunt3);
			
			
			boolean correcthoekPunt1 = false;
			boolean correcthoekPunt2 = false;
			boolean correcthoekPunt3 = false;

			while (correcthoekPunt1 == false) {
				try {
					hoekpunt1x = Integer.parseInt(JOptionPane.showInputDialog("Geef de x-waarde van het eerste hoekpunt."));
					hoekpunt1y = Integer.parseInt(JOptionPane.showInputDialog("Geef de y-waarde het eerste hoekpunt."));
					hoekPunt1 = new Punt(hoekpunt1x,hoekpunt1y);
					JOptionPane.showMessageDialog(null, "U heeft een correct hoekpunt aangemaakt: " + hoekPunt1 );
					correcthoekPunt1 = true;
				} catch (DomainException e) {
					JOptionPane.showMessageDialog(null, e.getMessage() );
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Het eerste hoekpunt is niet correct");
					}
			}
			
			while (correcthoekPunt2 == false) {
				try {
					hoekpunt2x = Integer.parseInt(JOptionPane.showInputDialog("Geef de x-waarde van het tweede hoekpunt."));
					hoekpunt2y = Integer.parseInt(JOptionPane.showInputDialog("Geef de y-waarde het tweede hoekpunt."));
					hoekPunt2 = new Punt(hoekpunt2x,hoekpunt2y);
					JOptionPane.showMessageDialog(null, "U heeft een correct hoekpunt aangemaakt: " + hoekPunt2 );
					correcthoekPunt2 = true;
				} catch (DomainException e) {
					JOptionPane.showMessageDialog(null, e.getMessage() );
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Het tweede hoekpunt is niet correct");
					}
			}
			
			while (correcthoekPunt3 == false) {
				try {
					hoekpunt3x = Integer.parseInt(JOptionPane.showInputDialog("Geef de x-waarde van het derde hoekpunt."));
					hoekpunt3y = Integer.parseInt(JOptionPane.showInputDialog("Geef de y-waarde het derde hoekpunt."));
					hoekPunt3 = new Punt(hoekpunt3x,hoekpunt3y);
					JOptionPane.showMessageDialog(null, "U heeft een correct hoekpunt aangemaakt: " + hoekPunt3 );
					correcthoekPunt3 = true;
				} catch (DomainException e) {
					JOptionPane.showMessageDialog(null, e.getMessage() );
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Het derde hoekpunt is niet correct");
					}
			}
			
			try {
				driehoek = new Driehoek(hoekPunt1, hoekPunt2, hoekPunt3);
				tekening.voegToe(driehoek);
				JOptionPane.showMessageDialog(null,	"U heeft een correcte driehoek aangemaakt: " + driehoek);
			} catch (DomainException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			break;
			
		case "Quit":
				JOptionPane.showMessageDialog(null, "bedankt");
				gevonden = true;
			break;
		default:
			break;
		}
		}
		GameHoofdScherm view = new GameHoofdScherm(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
		
	}

}
