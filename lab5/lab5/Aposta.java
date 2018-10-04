package lab5;

/**
 * Representa uma aposta no sistema de apostas.
 *
 * @author Eduardo Pereira
 */
public class Aposta {
	
	/**
	 * Seguro que compõem uma aposta.
	 */
	private Seguro seguro;

	/**
	 * Nome do apostador.
	 */
	private String apostador;

	/**
	 * Valor da aposta.
	 */
	private int valor;

	/**
	 * Previsão da aposta.
	 */
	private String previsao;

	/**
	 *
	 * Constrói uma aposta a partir do nome do apostador, o valor da aposta e a
	 * previsão "VAI ACONTECER" OU "N VAI ACONTECER".
	 *
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta
	 */
	public Aposta(String apostador, int valor, String previsao) {

		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao.trim().isEmpty() || previsao == null) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");

		}
		if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}

		if (apostador.trim().isEmpty() || apostador == null) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");

		}
		this.seguro = new Seguro();

		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}

	/**
	 * Constrói uma aposta assegurada por taxa a partir do nome do apostador, o
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
	public Aposta(String apostador, int valor, String previsao, double taxa, int custo) {

		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao.trim().isEmpty() || previsao == null) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");

		}
		if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}

		if (apostador.trim().isEmpty() || apostador == null) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");

		}
		if(custo <= 0) {
			throw new IllegalArgumentException();
		}

		this.seguro = new SeguroTaxa(this.valor, taxa);
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;

	}

	/**
	 * Constrói uma aposta assegurada por valor a partir do nome do apostador, o
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
	 */
	public Aposta(String apostador, int valor, String previsao, int valorAssegurado, int custo) {

		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao.trim().isEmpty() || previsao == null) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");

		}
		if (!(previsao.equals("VAI ACONTECER") || previsao.equals("N VAI ACONTECER"))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}

		if (apostador.trim().isEmpty() || apostador == null) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");

		}
		if(valorAssegurado <= 0) {
			throw new IllegalArgumentException();
		}
		if(custo <= 0) {
			throw new IllegalArgumentException();
		}
		this.seguro = new SeguroValor(valorAssegurado);

		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;

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

		this.seguro = new SeguroValor(valor);
		return apostaAssegurada;

	}

	/**
	 * Altera uma aposta assegurada por valor por uma aposta assegurada por taxa.
	 * 
	 * @param apostaAssegurada Aposta assegurada
	 * @param taxa Taxa
	 * @return o Id
	 */

	public int alterarSeguroTaxa(int apostaAssegurada, double taxa) {

		this.seguro = new SeguroTaxa(this.valor, taxa);
		return apostaAssegurada;

	}

	/**
	 * Retorna o valor da aposta.
	 * 
	 * @return valor da aposta
	 */
	public int getValor() {
		return this.valor;
	}

	/**
	 * Retorna a previsão da aposta.
	 * 
	 * @return previsão da aposta
	 */
	public String getPrevisao() {
		return this.previsao;
	}

	/**
	 * Retorna o objeto seguro associado a aposta.
	 * 
	 * @return um seguro
	 */
	public Seguro getSeguro() {
		return this.seguro;
	}

	/**
	 * Retorna uma representação em String da aposta, no formato: "Nome do apostador
	 * - valor da aposta - previsao".
	 * 
	 * @return uma String representando a aposta
	 */
	@Override
	public String toString() {
		return this.apostador + " - " + "R$" + this.valor + " - " + this.previsao + this.seguro.toString();
	}

}
