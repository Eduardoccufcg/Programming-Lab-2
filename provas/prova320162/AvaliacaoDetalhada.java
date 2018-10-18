package prova320162;

import java.util.List;

public class AvaliacaoDetalhada implements Avaliacao {

	@Override
	public double getNotaGeral(List<Opiniao> opinioes) {
		int soma = 0;
		for (Opiniao opiniao : opinioes) {
			soma += opiniao.getNota();
		}

		return (double)soma / opinioes.size();
	}

}
