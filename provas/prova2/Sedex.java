package prova2;

public class Sedex extends Encomenda {

	int peso;
	int volume;
	
	@Override
	public String toString() {
		return this.id + " - " + this.peso + " kg " + this.volume + " m3";

	}

	public Sedex(int id, int peso, int volume) {
		super(id);
		if (peso < 0 || volume < 0) {
			throw new IllegalArgumentException();
		}
			this.peso = peso;
		this.volume = volume;
	}

	@Override
	public int retornaCusto() {
		return 100 + (22 * this.peso) + (100 * this.volume);
	}

}
