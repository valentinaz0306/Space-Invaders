package vista;
import processing.core.PApplet;


public class EnemigoVista {
	private PApplet app;
	public EnemigoVista(PApplet app) {
		this.app = app;
	}
	public void pintarEnemigo(int posX, int posY, int tam) {
		app.fill(0,255,0);
		app.rect(posX,posY,tam,tam);
	}
}
