package prova320172;

public class Pessoa {
	String nome;
	int autoestima;
	int empatia;
	int experiencia;
	private Habilidade habilidade;
	private int problemasResolvidos;

	public Pessoa(String nome, int autoestima, int empatia, int experiencia) {
		if ("".equals(nome)) {
			throw new IllegalArgumentException("Nome nao pode ser vazio ou nulo");
		}
		if (nome == null) {
			throw new NullPointerException("Nome nao pode ser vazio ou nulo");
		}
		if (autoestima < 0) {
			throw new IllegalArgumentException("autoestima nao pode ser menor que zero");
		}
		if (empatia < 0) {
			throw new IllegalArgumentException("empatia nao pode ser menor que zero");
		}
		if (experiencia < 0) {
			throw new IllegalArgumentException("experiencia nao pode ser menor que zero");
		}

		this.nome = nome;
		this.autoestima = autoestima;
		this.empatia = empatia;
		this.experiencia = experiencia;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.autoestima + " - " + this.empatia + " - " + this.experiencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public void AtivarHabilidade(String hab) {
		if ("".equals(hab)) {
			throw new IllegalArgumentException("Habilidade nao pode ser vazia");
		}
		if (hab == null) {
			throw new NullPointerException("Habilidade nao pode ser nula");
		}

		if ("pessoal".equals(hab)) {
			this.habilidade = new Pessoal();
		} else if ("profissional".equals(hab)) {
			this.habilidade = new Profissional();
		} else if ("interpessoal".equals(hab)) {
			this.habilidade = new Interpessoal();
		} else {
			throw new IllegalArgumentException("Habilidade nao existe");
		}

	}

	public int getNivelHabilidade() {
		return (int) this.habilidade.getNivelHabilidade(autoestima, empatia, experiencia);
	}

	public void resolverProblema(int nivelProblema) {

		if (getNivelHabilidade() >= nivelProblema) {
			this.problemasResolvidos += 1;

		}
	}

	public int getProblemasResolvidos() {
		return this.problemasResolvidos;
	}

	public String getNome() {
		return this.nome;
	}

}
