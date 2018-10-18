package prova320172;

public class Pessoal implements Habilidade {

	@Override
	public double getNivelHabilidade(int autoestima, int empatia, int experiencia) {
		return 0.5 * autoestima + 0.3 * (experiencia / 10.0) + 0.2 * empatia;
	}

}
