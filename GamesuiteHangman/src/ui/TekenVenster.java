package ui;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import domain.Cirkel;
import domain.DomainException;
import domain.Driehoek;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import domain.Vorm;

public class TekenVenster extends Canvas {

	private static final long serialVersionUID = 1L;
	private Tekening tekening = null;

	public TekenVenster(Tekening tekening) {
		this.setPreferredSize(new Dimension(400, 400));
		setTekening(tekening);
	}

	private void setTekening(Tekening tekening) {
		if (tekening == null)
			throw new DomainException("Tekening mag niet null zijn");
		this.tekening = tekening;
	}

	public void teken() {
		repaint();
	}

	@Override
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));
		Vorm vorm = new Vorm() {
			
			@Override
			public void teken(Graphics graphics) {
				// TODO Auto-generated method stub
				
			}
		};
		Tekening tekening = new Tekening("");
		for (int i = 0; i < tekening.getAantalVormen(); i++) {
			vorm = tekening.getVorm(i);
			if(vorm instanceof Cirkel){
				graphics.drawOval(vorm.getOmhullende().getMinX(), vorm
						.getOmhullende().getMinY(), vorm.getOmhullende()
						.getBreedte(), vorm.getOmhullende().getHoogte());
			}
			if(vorm instanceof Rechthoek){
				graphics.drawRect(((Rechthoek) vorm).getLinkerBovenhoek().getX(), ((Rechthoek) vorm)
						.getLinkerBovenhoek().getY(), ((Rechthoek) vorm).getBreedte(), ((Rechthoek) vorm)
						.getHoogte());
			}
			if(vorm instanceof LijnStuk){
				graphics.drawLine(((LijnStuk) vorm).getStartPunt().getX(), ((LijnStuk) vorm)
						.getStartPunt().getY(), ((LijnStuk) vorm).getEindPunt().getX(), ((LijnStuk) vorm)
						.getEindPunt().getY());
			if(vorm instanceof Driehoek){
				int[] xPoints = { ((Driehoek) vorm).getHoekPunt1().getX(), ((Driehoek) vorm).getHoekPunt2().getX(),
							((Driehoek) vorm).getHoekPunt3().getX() };
				int[] yPoints = { ((Driehoek) vorm).getHoekPunt1().getY(), ((Driehoek) vorm).getHoekPunt2().getY(),
						((Driehoek) vorm).getHoekPunt3().getY() };
				graphics.drawPolygon(xPoints, yPoints, 3);
				
			}	
			}	
			}	
		}
	}