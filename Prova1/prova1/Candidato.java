package prova1;

public class Candidato {

	private String nome;
	private String partido;
	private int id;
	private int totalvotos;

	public Candidato(String nome, String partido, int id) {

		this.nome = nome;
		this.partido = partido;
		this.id = id;
		this.totalvotos = 0;

	}

	public void setNome(String nome) {
		this.nome = nome;

	}

	public String getNome() {
		return this.nome;
	}

	public String toString() {
		return this.nome + " - " + this.partido + " - " + this.id;

	}

	public int getId() {
		return this.id;
	}

	public int getTotalVotos() {

		return this.totalvotos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Candidato other = (Candidato) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void adicionaVoto() {
		this.totalvotos += 1;
	}

	public String apuracaoCandidato() {
		return this.id + " - " + this.totalvotos + " " + "votos";
	}

}
