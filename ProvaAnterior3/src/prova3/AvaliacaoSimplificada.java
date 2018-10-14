package prova3;

import java.util.List;

public class AvaliacaoSimplificada implements Avaliacao {

	@Override
	public double getNotaGeral(List<Opiniao> opinioes) {
		int maior = opinioes.get(0).getNota();
		for(Opiniao opiniao: opinioes) {
			if(opiniao.getNota() > maior) {
				maior = opiniao.getNota();
			}
		}
		return maior;
		
	}



}
