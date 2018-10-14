package prova2;

abstract class Encomenda {
	protected int id;

	public Encomenda(int id) {
		this.id = id;
	}

	public abstract String toString();

	public abstract int retornaCusto();

}
