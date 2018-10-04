package lab5;

import java.util.Comparator;

/**
 * Responsável por ordenar as apostas de um cenário a partir de sua numeração.
 * 
 * @author Eduardo Pereira - 117210342
 *
 */
public class OrdenacaoNumeracao implements Comparator<Cenario> {
	/**
	 * Compara dois cenarios.
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		return cenario1.getNumeracao() - cenario2.getNumeracao();
	}

}
