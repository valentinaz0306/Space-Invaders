package controlador;

import modelo.Enemigo;
import vista.EnemigoVista;

public class EnemigoControlador {
	private Enemigo modelo;
	private EnemigoVista vista;
	public EnemigoControlador(Enemigo modelo,EnemigoVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	public void move() {
		modelo.move();
	}
	public void pintar(){
		vista.pintarEnemigo(modelo.getPosX(), modelo.getPosY(), modelo.getTamano());
	}
	public void setPosX(int posX) {
		modelo.setPosX(posX);
	}
	public void setPosY(int posY) {
		modelo.setPosY(posY);
	}
	public int getPosX(){
		return modelo.getPosX();
	}
	public int getPosY(){
		return modelo.getPosY();
	}
	public int getTamano() {
		return modelo.getTamano();
	}
}
