package prova320172;

public class Profissional implements Habilidade {

	@Override
	public double getNivelHabilidade(int autoestima, int empatia, int experiencia) {
		if(autoestima < 7 || empatia < 7) {
			return (experiencia / 10.0) * 0.9;
		}
		return experiencia / 10.0;
	}

}
