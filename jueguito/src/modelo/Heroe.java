package modelo;

public class Heroe extends Actor{
	// variables globales 
	
	private int vel1=30;
	private int tam=80;
	private int vida= 3; 
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public Heroe(int posX,int posY) {
		super(posX,posY);	
	}
	
	public void move(int movi) {
		
		//movimiento en X
		if (this.getPosX()+vel1 * movi<=600 && this.getPosX()+vel1*movi>=200) {
		//Suma vel
			this.setPosX(getPosX()+ vel1 * movi);
			
		}	
		
	}
	
	public void disparar() {
		
		
	}

	
	
	
	
	
	
	
	
	
	
	

}
