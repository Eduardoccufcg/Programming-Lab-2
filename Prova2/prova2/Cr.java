package prova2;

public class Cr extends Encomenda {
	
	int id;
	int numeroFolhas;
	
	
	public Cr(int id, int numeroFolhas) {
		if (numeroFolhas < 0) {
			throw new IllegalArgumentException();
		}

		this.id = id;
		this.numeroFolhas = numeroFolhas;
	}


	@Override
	public String toString() {
		return this.id  + " - " + this.numeroFolhas + " folhas(s)";
	}


	@Override
	public int retornaCusto() {
		return this.numeroFolhas;
	}

}
