package lab5;

/**
 * Representa um seguro de um aposta asssegurada por valor.
 * 
 * @author Eduardo Pereira - 117210342
 *
 */
public class SeguroValor extends Seguro {

	/**
	 * Valor retirado do caixa caso a aposta seja perdedora.
	 */
	private int valorAssegurado;

	/**
	 * Constrói um seguro por valor.
	 * 
	 * @param valorAssegurado
	 *            valor Assegurado
	 */
	public SeguroValor(int valorAssegurado) {
		if(valorAssegurado <= 0) {
			throw new IllegalArgumentException("Valor assegurado não pode ser menor que zero.");
		}

		this.valorAssegurado = valorAssegurado;
	}

	/**
	 * Retorna o valor assegurado.
	 * 
	 * @return um inteiro
	 */
	@Override
	public int getValor() {
		return this.valorAssegurado;
	}

	/**
	 * Representação textual de um seguro por valor.
	 * 
	 * @return uma String
	 */
	@Override
	public String toString() {
		String resultado = String.format("%.2f", (double) this.valorAssegurado);
		return " - ASSEGURADA(VALOR) - R$ " + resultado;
	}

}
