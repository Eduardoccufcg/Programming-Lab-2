package prova320172;

public class Interpessoal implements Habilidade {

	@Override
	public double getNivelHabilidade(int autoestima, int empatia, int experiencia) {
		return 0.3 * autoestima + 0.2 * (experiencia / 10.0) + 0.5 * empatia;
	}

}
