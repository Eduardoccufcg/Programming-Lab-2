package prova2;

public class Cr extends Encomenda {
	
	
	int numeroFolhas;
	
	
	public Cr(int id, int numeroFolhas) {
		super(id);
		if (numeroFolhas < 0) {
			throw new IllegalArgumentException();
		}

		
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
