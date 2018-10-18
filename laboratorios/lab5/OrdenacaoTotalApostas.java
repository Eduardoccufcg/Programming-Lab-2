package lab5;

import java.util.Comparator;

/**
 * Responsavel por ordenar as apostas de um cenario a partir da quantidade de
 * apostas
 * 
 * @author Eduardo Pereira - 117210342
 *
 */
public class OrdenacaoTotalApostas implements Comparator<Cenario> {

	/**
	 * Compara dois cenarios.
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		if (cenario1.qtdApostas() - cenario2.qtdApostas() == 0) {
			return cenario1.getNumeracao() - cenario2.getNumeracao();
		}

		return cenario2.qtdApostas() - cenario1.qtdApostas();
	}

}
