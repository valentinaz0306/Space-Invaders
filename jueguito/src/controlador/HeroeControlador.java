package controlador;

import modelo.Heroe;
import vista.HeroeVista;

public class HeroeControlador {
	private Heroe modelo;
	private HeroeVista vista;
	public HeroeControlador(Heroe modelo,HeroeVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	public void move(int movi) {
		modelo.move(movi);
	}
	public void pintar(){
		vista.pintarHeroe(modelo.getPosX(), modelo.getPosY(), modelo.getTam());
	}
	public int getPosX() {
		return modelo.getPosX();
	}
	public void setPosX(int posX) {
		modelo.setPosX(posX);
	}
	public int getPosY() {
		return modelo.getPosY();
	}
	public void setPosY(int posY) {
		modelo.setPosY(posY);
	}
	public int getTam(){
		return modelo.getTam();
	}
	// get and sets vidaaa
	public int getVida(){
		return modelo.getVida();
	}
	public void setVida(int Vida){
		 modelo.setVida(Vida);
	}
 
}
