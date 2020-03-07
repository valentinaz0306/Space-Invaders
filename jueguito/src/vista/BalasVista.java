package vista;

import processing.core.PApplet;


public class BalasVista {
	private PApplet app;
	public BalasVista(PApplet app) {
		this.app = app;
	}
	public void pintarBalas(int posX, int posY, int tam) {
		app.fill(255);
		app.ellipse(posX,posY,tam,tam);
	}
}

