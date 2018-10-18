package prova3;

import prova3.Barraca;
import prova3.Ecom;
import prova3.IdInvalidoException;
import prova3.Quiosque;
import prova3.Restaurante;
import prova3.Tipo;

public class Ecom{

	private String nomeFantasia;
	private String cnpj;
	private String proprietario;
	private int idTipo;
	private Tipo tipo;
	private double valorArrecadado;

	public Ecom(String nomeFantasia, String CNPJ, String proprietario, int idTipo) throws IdInvalidoException {
		if (idTipo != 1 || idTipo != 2 || idTipo != 3) {
			throw new IdInvalidoException("id inválido");
		}
		if (idTipo == 1) {
			this.tipo = new Quiosque();
			this.tipo.getTUS();
		} else if (idTipo == 2) {
			this.tipo = new Barraca();
		} else if (idTipo == 3) {
			this.tipo = new Restaurante();
		}
		this.nomeFantasia = nomeFantasia;
		this.cnpj = CNPJ;

		this.proprietario = proprietario;
		this.idTipo = idTipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Ecom other = (Ecom) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

	public void alterarTipoEcom(int idTipo) throws IdInvalidoException {
		if (idTipo != 1 || idTipo != 2 || idTipo != 3) {
			throw new IdInvalidoException("id inválido");
		}

		double novaTaxa = this.tipo.getTUS();

		if (idTipo == 1) {

			this.tipo = new Quiosque();

		} else if (idTipo == 2) {
			this.tipo = new Barraca();
		} else if (idTipo == 3) {
			this.tipo = new Restaurante();
		}
		this.tipo.adicionaTUS(novaTaxa);

	}

	@Override
	public String toString() {
		return this.nomeFantasia + "*" + this.cnpj + "*" + this.proprietario + "*" + this.tipo.getTipo();
	}

	public void adicionarValorArrecadado(double valor) {
		this.valorArrecadado += valor;

	}

	public double consultarTaxaDevidas() {
		return this.tipo.calculaTaxasDevidas(valorArrecadado);

	}

	public double getValorArrecadado() {
		return this.valorArrecadado;
	}

}
