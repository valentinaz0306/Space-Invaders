package main;

import processing.core.PApplet;


import java.util.ArrayList;

import modelo.Enemigo;
import modelo.Heroe;
import vista.HeroeVista;
import vista.EnemigoVista;
import controlador.EnemigoControlador;
import controlador.HeroeControlador;

public class Main extends PApplet {
	
	// lista de enemigos
	ArrayList<EnemigoControlador> enemigos = new ArrayList<EnemigoControlador>();
	
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
		// recorrer arraylist para pintar enemigos
		for(int i=0;i<enemigos.size();i++) {
			enemigos.get(i).pintar();
			enemigos.get(i).move();
		}
		cont++;
		//System.out.println("enemigos: "+enemigos.size());
		//System.out.println("cont: "+cont);
		
		
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
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// cierre main 
