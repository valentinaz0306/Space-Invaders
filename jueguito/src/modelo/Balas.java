package modelo;

public class Balas extends Actor{
	
	 private int vel2= 10;
	 private int tam= 20;
			 
	public int getTam() {
		return tam;
	}


	public void setTam(int tam) {
		this.tam = tam;
	}


	public Balas(int posX,int posY) {
		super(posX,posY);
	}
	
	
	public void move() {
	
		this.setPosY(getPosY() - vel2 );
		
		
	}
	
	
}
