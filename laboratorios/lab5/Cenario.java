package lab5;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um cenario em sistema de apostas.
 *
 * @author Eduardo Pereira - 117210342
 */
public class Cenario {

	/**
	 * Lista contendo as apostas.
	 */
	private List<Aposta> apostas;

	/**
	 * Descrição do cenario.
	 */
	private String descricao;

	/**
	 * Estado do cenario.
	 */
	private String estado;

	/**
	 * Numeração do cenario.
	 */
	private int numeracao;

	/**
	 * Valor das apostas perdedoras.
	 */
	private int valorApostasPerdedores;

	/**
	 * Valor destinado ao caixa pelas apostas asseguradas perdedoras
	 */
	private int valorAssegurado;

	/**
	 * Constrói um cenario a partir de sua descricao e numeracao.
	 *
	 * @param descricao
	 *            Descrição do cenario
	 * @param numeracao
	 *            Numeração do cenario
	 */
	public Cenario(String descricao, int numeracao) {

		if (descricao == null) {
			throw new NullPointerException("Erro no cadastro de cenario: Descricao nao pode ser nula");
		}

		if (descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}

		this.descricao = descricao;
		this.estado = "Nao finalizado";
		this.apostas = new ArrayList<>();
		this.numeracao = numeracao;
	}

	/**
	 * Retorna uma representação textual do cenario no formato: "Numeracao -
	 * Descricao - Estado"
	 *
	 * @return uma String representando o cenario
	 */
	@Override
	public String toString() {
		return this.numeracao + " - " + this.descricao + " - " + this.estado;
	}

	/**
	 * Retorna uma lista contendo todas as apostas do cenario.
	 *
	 * @return uma String com as apostas
	 */
	public String listaApostas() {
		String lista = "";
		for (int i = 0; i < this.apostas.size(); i++) {
			lista += this.apostas.get(i).toString() + System.lineSeparator();

		}
		return lista;
	}

	/**
	 * Retorna a quantidade de apostas cadastradas em um cenario.
	 *
	 * @return um inteiro
	 */
	public int qtdApostas() {
		return this.apostas.size();
	}

	/**
	 * Retorna a soma de todas apostas cadastradas no cenario.
	 *
	 * @return um inteiro
	 */
	public int valorTotalApostas() {
		int total = 0;
		for (int i = 0; i < this.apostas.size(); i++) {
			total += this.apostas.get(i).getValor();

		}
		return total;

	}

	/**
	 * Cadastra uma aposta no cenario a partir do nome do apostador, valor da aposta
	 * e a previsao. retorna true caso não haja nenhuma excecao.
	 *
	 *
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão do apostador
	 *
	 * @return true
	 */
	public void cadastraAposta(String apostador, int valor, String previsao) {

		Aposta aposta = new Aposta(apostador, valor, previsao);
		this.apostas.add(aposta);

	}

	/**
	 * Cadastra uma aposta assegurada por valor a partir do nome do apostador, o
	 * valor da aposta e a previsão "VAI ACONTECER" OU "N VAI ACONTECER", valor
	 * assegurado e custo.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta
	 * @param valorAssegurado
	 *            Valor Assegurado
	 * @param custo
	 *            Custo da aposta
	 * 
	 * @return o Id
	 */

	public int cadastraApostaSeguraValor(String apostador, int valor, String previsao, int valorAssegurado, int custo) {

		Aposta aposta = new Aposta(apostador, valor, previsao, valorAssegurado, custo);
		this.apostas.add(aposta);
		return this.apostas.size();

	}

	/**
	 * Cadastra uma aposta assegurada por taxa a partir do nome do apostador, o
	 * valor da aposta e a previsão "VAI ACONTECER" OU "N VAI ACONTECER", taxa e
	 * custo.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta
	 * @param taxa
	 *            Taxa
	 * @param custo
	 *            Custo
	 */
	public int cadastraApostaSeguraTaxa(String apostador, int valor, String previsao, double taxa, int custo) {

		Aposta aposta = new Aposta(apostador, valor, previsao, taxa, custo);
		this.apostas.add(aposta);
		return this.apostas.size();

	}

	/**
	 * Altera uma aposta assegurada por taxa por uma aposta assegurada por valor.
	 * 
	 * @param apostaAssegurada
	 *            Id da Aposta
	 * @param valor
	 *            Valor Assegurado
	 * @return o Id da aposta
	 */

	public int alterarSeguroValor(int apostaAssegurada, int valor) {

		return this.apostas.get(apostaAssegurada - 1).alterarSeguroValor(apostaAssegurada, valor);

	}

	/**
	 * Altera uma aposta assegurada por valor por uma aposta assegurada por taxa.
	 * 
	 * @param apostaAssegurada
	 *            Aposta Segurada
	 * @param taxa
	 *            Taxa
	 * @return o Id
	 */

	public int alterarSeguroTaxa(int apostaAssegurada, double taxa) {

		return this.apostas.get(apostaAssegurada - 1).alterarSeguroTaxa(apostaAssegurada, taxa);

	}

	/**
	 * Fecha o cenario a partir de um booleano representando se o cenario
	 * ocorreu(true) ou não ocorreu(false).
	 *
	 * @param ocorreu
	 *            Um booleano true ou false
	 */
	public void fechaCenario(boolean ocorreu) {

		if (this.estado.equals("Finalizado (ocorreu)") || this.estado.equals("Finalizado (n ocorreu)")) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");

		}

		if (ocorreu) {
			this.estado = "Finalizado (ocorreu)";
		} else {
			this.estado = "Finalizado (n ocorreu)";
		}

	}

	/**
	 * Calcula a soma das apostas perdedoras e o valor assegurado debitado do caixa.
	 *
	 * @param ocorreu
	 *            Um booleano
	 * @return um inteiro
	 */
	public void calculaValorPerdedores(boolean ocorreu) {

		int valor = 0;
		String previsao = "";
		if (ocorreu) {
			previsao = "VAI ACONTECER";
		} else {
			previsao = "N VAI ACONTECER";
		}

		for (Aposta aposta : this.apostas) {
			if (!aposta.getPrevisao().equals(previsao)) {
				valor += aposta.getValor();
				this.valorAssegurado += aposta.getSeguro().getValor();

			}
		}

		this.valorApostasPerdedores = valor;
	}

	/**
	 * Retorna soma das apostas perdedoras.
	 *
	 * @return um inteiro
	 */
	public int getValorPerdedores() {
		return this.valorApostasPerdedores;
	}

	/**
	 * Retorna o estado atual do cenário.
	 *
	 * @return uma String
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Metodo getBonus implementado na classe CenarioBonus.
	 * 
	 * @return o bonus de um cenario
	 */
	public int getBonus() {

		return 0;
	}

	/**
	 * Retorna o valor debitado do caixa, quando as apostas perdedoras são
	 * asseguradas.
	 * 
	 * @return um inteiro
	 */
	public int getValorAssegurado() {
		return valorAssegurado;
	}

	/**
	 * Retorna a numeracao do cenario
	 * 
	 * @return numeracao
	 */
	public int getNumeracao() {
		return this.numeracao;
	}

	/**
	 * Retorna a descricao do cenario.
	 * 
	 * @return descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}

}
