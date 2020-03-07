package main;

import processing.core.PApplet;


import java.util.ArrayList;

import modelo.Balas;
import modelo.Enemigo;
import modelo.Heroe;
import vista.BalasVista;
import vista.HeroeVista;
import vista.EnemigoVista;
import controlador.BalasControlador;
import controlador.EnemigoControlador;
import controlador.HeroeControlador;

public class Main extends PApplet {
	
	// lista de enemigos
	ArrayList<EnemigoControlador> enemigos = new ArrayList<EnemigoControlador>();
	
	// lista de balas
	ArrayList<BalasControlador> balas = new ArrayList<BalasControlador>();
	
	//CREAR OBJETO TIPO HEROE
	Heroe modelo = new Heroe(200,600);
	HeroeVista vista = new HeroeVista(this);
	HeroeControlador ayuda = new HeroeControlador(modelo,vista); 
	
	// variable contador para separar enmigos
	int cont=0;
	
	public static void main(String[] args) {
		
		PApplet.main("main.Main");

	}
	public void settings() {
		size(800,800);
		
	}
	
	
	public void setup() {		
	}
	
	public void draw() {
		
		background(0);
		//pintar enemigos
		if(cont%25==0 && enemigos.size()<12) {	
		enemigos.add(new EnemigoControlador(new Enemigo(200,200),new EnemigoVista(this)));
		}
		cont++;
		
		// recorrer arraylist para pintar enemigos
		for(int i=0;i<enemigos.size();i++) {
			enemigos.get(i).pintar();
			enemigos.get(i).move();
		}
		
		// recorrer arraylist para pintar balas
		
		for(int i=0;i<balas.size();i++) {
			balas.get(i).pintar();
			balas.get(i).move();
		}
		
		// eliminar enemigo de arraylist
	
		for(int i=0; i<enemigos.size();i++) {
			for(int j=0; j< balas.size();j++) {
				if(balas.get(j).getPosX()>= enemigos.get(i).getPosX() &&
					balas.get(j).getPosX()<= enemigos.get(i).getPosX()+enemigos.get(i).getTamano()&&
					balas.get(j).getPosY()>= enemigos.get(i).getPosY() &&
					balas.get(j).getPosY()<= enemigos.get(i).getPosY()+enemigos.get(i).getTamano()) {
					
					enemigos.remove(i);
					balas.remove(j);
					
					break;
				}
			}	
			
			
		}
		
		// PINTA HEROE 
	
		ayuda.pintar();
		
		
		
		
	}// cierre draw 
	
	
	
	public void keyPressed() {
		
		if(keyCode == RIGHT) {
			ayuda.move(1);	
			
		}
		
		if(keyCode == LEFT) {
			ayuda.move(-1);	
			
		}
		
		if(key == 32) {
			//nuevo modelo de bala 
			//crea una nueva bala en la pos del heroe 
			Balas nMBala = new Balas(ayuda.getPosX()+ ayuda.getTam()/2, ayuda.getPosY());
			//nueva vista bala
			BalasVista nVBala = new BalasVista(this);
			//
			balas.add(new BalasControlador(nMBala,nVBala));	
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// cierre main 
