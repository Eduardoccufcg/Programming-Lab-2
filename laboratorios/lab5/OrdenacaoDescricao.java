package lab5;

import java.util.Comparator;

/**
 * Responsável por ordenar as apostas de um cenario a partir da sua descrição.
 * 
 * @author Eduardo Pereira - 117210342
 *
 */
public class OrdenacaoDescricao implements Comparator<Cenario> {
	/**
	 * Compara dois cenarios.
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {

		if (cenario1.getDescricao().compareTo(cenario2.getDescricao()) == 0) {
			return cenario1.getNumeracao() - cenario2.getNumeracao();
		}
		return cenario1.getDescricao().compareTo(cenario2.getDescricao());
	}

}
