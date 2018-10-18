package prova3;

import prova3.CNPJNaoCadastradoException;
import prova3.IdInvalidoException;
import prova3.Sistema;

public class Facade {

	Sistema sistema;

	public void inicializa() {
		sistema = new Sistema();
	}

	public void cadastraEcom(String nomeFantasia, String CNPJ, String proprietario, int idTipo)
			throws IdInvalidoException {
		this.sistema.cadastraEcom(nomeFantasia, CNPJ, proprietario, idTipo);
	}

	public String recuperarEcom(String CNPJ) throws CNPJNaoCadastradoException {
		return this.sistema.recuperarEcom(CNPJ);

	}

	public void alterarTipoEcom(String CNPJ, int IdTipo) throws IdInvalidoException {
		this.sistema.alterarTipoEcom(CNPJ, IdTipo);
	}

	public void informarValorArrecadado(String CNPJ, double valor) {
		this.sistema.informarValorArrecadado(CNPJ, valor);

	}

	public double consultaTaxasDevidas(String CNPJ) {
		return this.sistema.consultaTaxasDevidas(CNPJ);

	}

	public double consultarTotalArrecadao(String CNPJ) {
		return this.sistema.consultarTotalArrecadao(CNPJ);

	}
	public String consultarMaiorArrecadacao() {
		return this.sistema.consultarMaiorArrecadao();
	}
	public String consultarMaiorTaxaCobrada() {
		return this.sistema.consultarMaiorTaxaCobrada();
	}

}
