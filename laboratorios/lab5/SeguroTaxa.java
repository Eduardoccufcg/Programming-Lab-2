package lab5;

/**
 * Representa um seguro de um aposta asssegurada por taxa.
 * 
 * @author Eduardo Pereira - 117210342
 *
 */
public class SeguroTaxa extends Seguro {
	/**
	 * Valor da aposta.
	 */
	private int valorAposta;
	/**
	 * Taxa do seguro.
	 */
	private double taxa;

	/**
	 * Constrói um seguro por taxa
	 * 
	 * @param valorAposta
	 *            Valor da aposta
	 * @param taxa
	 *            Taxa do seguro
	 */
	public SeguroTaxa(int valorAposta, double taxa) {
		if(taxa < 0) {
			throw new IllegalArgumentException("Taxa não pode ser menor que 0");
		}
		
		if(valorAposta < 0) {
			throw new IllegalArgumentException("Valor da aposta não pode ser menor que 0");
		}
		this.taxa = taxa;
		this.valorAposta = valorAposta;
	}

	/**
	 * Retorna o valor da aposta.
	 * 
	 * @return um inteiro
	 */
	@Override
	public int getValor() {
		return (int) (this.valorAposta * this.taxa);
	}

	/**
	 * Representação textual de um seguro por taxa.
	 * 
	 * @return uma String
	 */
	@Override
	public String toString() {
		String resultado = String.format("%.0f%%", this.taxa * 100);
		return " - ASSEGURADA(TAXA) - " + resultado;

	}
}
