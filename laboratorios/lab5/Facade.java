package lab5;

import easyaccept.EasyAccept;

/**
 * Responsavel por abstrair as ações do controller para o usuario.
 *
 * @author Eduardo Pereira - 117210342
 */
public class Facade {

	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "testeseasy/us1_test.txt", "testeseasy/us2_test.txt",
				"testeseasy/us3_test.txt", "testeseasy/us4_test.txt", "testeseasy/us5_test.txt",
				"testeseasy/us6_test.txt", "testeseasy/us7_test.txt" };
		EasyAccept.main(args);
	}

	private ControllerCenario controller;

	/**
	 * Inicializa sistema recebendo o caixa inicial e a taxa.
	 *
	 * @param caixa
	 *            Caixa inicil
	 * @param taxa
	 *            Taxa do sistema
	 */
	public void inicializa(int caixa, double taxa) {
		this.controller = new ControllerCenario(caixa, taxa);
	}

	/**
	 * Retorna o valor acumulado no caixa.
	 *
	 * @return um inteiro representando o caixa
	 */
	public int getCaixa() {
		return this.controller.getCaixa();

	}

	/**
	 * Cadastra um cenario a partir de sua descricao.
	 *
	 * @param descricao
	 *            Descricao do cenario
	 * @return um booleano
	 */
	public int cadastrarCenario(String descricao) {
		return this.controller.cadastraCenario(descricao);

	}

	/**
	 * Cadastra um cenario a partir de sua descricao.
	 *
	 * @param descricao
	 *            Descricao do cenario
	 * @param bonus
	 *            Bonus do cenario
	 * @return um booleano
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		return this.controller.cadastraCenarioBonus(descricao, bonus);

	}

	/**
	 * Retorna uma representação em String de um cenario.
	 *
	 * @param cenario
	 *            Numero do cenario
	 * @return uma String
	 */
	public String exibirCenario(int cenario) {
		return this.controller.exibeCenario(cenario);

	}

	/**
	 * Retorna uma String contendo todos os cenarios cadastrados.
	 *
	 * 
	 * @return uma String
	 */
	public String exibirCenarios() {
		return this.controller.listaCenarios();
	}

	/**
	 * Cadastra uma aposta em um cenario.
	 *
	 * @param cenario
	 *            Numero do cenario
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da Aposta
	 * @param previsao
	 *            Previsão sobre o cenario
	 * @return um booleano
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.controller.cadastraAposta(cenario, apostador, valor, previsao);
	}

	/**
	 * Cadastra uma aposta assegurada por valor.
	 * 
	 * @param cenario
	 *            Numero do cenario
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsao da aposta
	 * @param valorAssegurado
	 *            Valor assegurado
	 * @param custo
	 *            Custo do seguro
	 * @return id da aposta
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao,
			int valorAssegurado, int custo) {
		return this.controller.cadastraApostaSeguroValor(cenario, apostador, valor, previsao, valorAssegurado, custo);
	}

	/**
	 * Cadastra uma aposta assegurada por taxa.
	 * 
	 * @param cenario
	 *            Numero do cenario
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsao da aposta
	 * @param taxa
	 *            Taxa do seguro
	 * @param custo
	 *            Custo do seguro
	 * @return id da aposta
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) {
		return this.controller.cadastraApostaSeguroTaxa(cenario, apostador, valor, previsao, taxa, custo);
	}

	/**
	 * Retorna a soma de todas as apostas de um cenario.
	 *
	 * @param cenario
	 *            Numero do cenario.
	 * @return um inteiro
	 */
	public int valorTotalDeApostas(int cenario) {
		return this.controller.valorTotalDeApostas(cenario);

	}

	/**
	 * Retorna o numero de apostas cadastradas em um cenario.
	 *
	 * @param cenario
	 *            Numero do cenario
	 * @return um inteiro representando a quantidade de apostas
	 */
	public int totalDeApostas(int cenario) {
		return this.controller.totalDeApostas(cenario);
	}

	/**
	 * Retorna uma lista contendo todas as apostas de um cenário.
	 *
	 * @param cenario
	 *            Numero do cenario
	 * @return uma String contendo todas as apostas
	 */
	public String exibeApostas(int cenario) {
		return this.controller.exibeApostas(cenario);
	}

	/**
	 * Fecha um cenario a partir do seu numero a partir de um booleano true caso o
	 * cenario tenha acontecido. e false caso contrario.
	 *
	 * @param cenario
	 *            Numero do cenario
	 * @param ocorreu
	 *            Booleano true ou false
	 *
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.controller.fechaCenario(cenario, ocorreu);

	}

	/**
	 * Retorna o valor que vai para o caixa do sistema.
	 *
	 * @param cenario
	 *            Numero do cenario
	 * @return um inteiro
	 */
	public int getCaixaCenario(int cenario) {
		return this.controller.getCaixaCenario(cenario);
	}

	/**
	 * Retorna o valor que vai ser repartido aos ganhadores.
	 *
	 * @param cenario
	 *            Numero do cenario
	 * @return um double do valor do rateio
	 */
	public int getTotalRateioCenario(int cenario) {

		return this.controller.getTotalRateioCenario(cenario);
	}

	/**
	 * Altera uma aposta assegurada por taxa por uma aposta assegurada por valor.
	 * 
	 * @param cenario
	 *            Id do cenario
	 * 
	 * @param apostaAssegurada
	 *            Aposta Segurada
	 * @param taxa
	 *            Taxa
	 * @return o Id
	 */

	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {

		return this.controller.alterarSeguroValor(cenario, apostaAssegurada, valor);

	}

	/**
	 * Altera uma aposta assegurada por valor por uma aposta assegurada por taxa.
	 * 
	 * @param cenario
	 *            Id do cenario
	 * 
	 * @param apostaAssegurada
	 *            Aposta Segurada
	 * @param taxa
	 *            Taxa
	 * @return o Id
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {

		return this.controller.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);

	}

	/**
	 * Altera a ordem que os cenarios serao listados. Sendo elas : por numeracao,
	 * descricao ou total de apostas
	 * 
	 * @param ordem
	 *            Ordem
	 */
	public void alterarOrdem(String ordem) {
		this.controller.alteraOrdem(ordem);
	}

	/**
	 * Exibe o cenario ordenado.
	 * 
	 * @param cenario
	 *            Id do cenario
	 * @return uma lista contendo as apostas do cenario ordenado
	 */
	public String exibirCenarioOrdenado(int cenario) {
		return this.controller.exibeCenarioOrdenado(cenario);
	}

}
