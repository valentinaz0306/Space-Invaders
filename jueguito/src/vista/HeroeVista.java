package vista;

import processing.core.PApplet;

public class HeroeVista {
	private PApplet app;
	public HeroeVista(PApplet app) {
		this.app = app;
	}
	public void pintarHeroe(int posX, int posY, int tam) {
		app.fill(255,0,0);
		app.rect(posX,posY,tam,tam);
	}

}
