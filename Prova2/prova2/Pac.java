package prova2;

public class Pac extends Encomenda{
	
	private int peso;
	
	public Pac(int peso, int id) {
		super(id);
		if(peso < 0) {
			throw new IllegalArgumentException();
		}
		this.peso = peso;
		
	}


	@Override
	public String toString() {
		return this.id  + " - " + this.peso + " kg";
	}


	@Override
	public int retornaCusto() {
		return 60 + 6 * this.peso;
	}
	
	

}
