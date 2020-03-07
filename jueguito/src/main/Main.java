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
	int contEnemigos = 0;
	int enemigosEliminados = 0;
	int maxEnemigos = 6;
	int pantalla;
	String textoFinal;
	
	public static void main(String[] args) {
		
		PApplet.main("main.Main");

	}
	public void settings() {
		size(800,800);
		
	}
	
	
	public void setup() {
		pantalla=0;
	}
	
	public void draw() {
		
		switch(pantalla) {
		
			case 0:
				
				background(0);
				textSize(50);
				fill(255);
				text("SPACE INVADERS",200,400);
				fill(255,0,0);
				textSize(30);
				text("JUGAR",350,600);
				
				text("x:"+mouseX+"y:"+ mouseY,mouseX,mouseY);
				
				break;
				
			case 1:
				
				background(0);
				
				//pintar enemigos
				if(cont%25==0 &&  contEnemigos<maxEnemigos) {	
					enemigos.add(new EnemigoControlador(new Enemigo(200,200),new EnemigoVista(this)));
					contEnemigos ++;
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
							enemigosEliminados++;
							break;
						}
					}	
				}
				
				// PINTA HEROE 
			
				ayuda.pintar();
				text(ayuda.getVida(),100,100);
				//heroe pierde vidas
				
				if(enemigos.size() > 0 && enemigos.get(0).getPosY()>=600) {
					ayuda.setVida(ayuda.getVida()-1);
					enemigos.clear();
					balas.clear();
					contEnemigos = 0;
					enemigosEliminados = 0;
				}
				
				if (enemigosEliminados==maxEnemigos) {
					textoFinal= "GANASTE";
					pantalla=2;
				}
				
				if (ayuda.getVida()==0) {
					textoFinal= "PERDISTE";
					pantalla=2;
				}
				break;
				
			case 2:
				background(0);
				textSize(50);
				fill(255);
				text(textoFinal,200,400);
				
				break;
				
		
				
				
		}// cierra switch	
		
		
	}// cierre draw 
	
	
	public void mousePressed() {
		
	if(mouseX>353 && mouseX<435 && mouseY>581 && mouseY<605) {
		
		pantalla=1;
	}
	
	}// cierra mouse
	
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
