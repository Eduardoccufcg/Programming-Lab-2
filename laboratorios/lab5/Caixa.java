package lab5;

/**
 * Responsável por gerir a movimentação de valores do sistema.
 * 
 * @author Eduardo Pereira - 117210342
 */
public class Caixa {

	/**
	 * Porcentagem de inicialização do sistema.
	 */
	private double taxa;

	/**
	 * Caixa do sistema.
	 */
	private int caixa;

	/**
	 * 
	 * Constrói o caixa a partir do valor inicial e porcentagem de ganho.
	 *
	 * @param dinheiroInicial
	 *            Valor inicial para inicialização do caixa.
	 * 
	 * @param porcentagem
	 *            Porcentagem inicial para inicialização do caixa.
	 * 
	 */
	public Caixa(int dinheiroInicial, double taxa) {

		if (dinheiroInicial < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}

		if (taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}

		this.caixa = dinheiroInicial;
		this.taxa = taxa;
	}

	/**
	 * Adiciona dinheiro ao caixa após um cenario ser fechado.
	 * 
	 * @param valor
	 *            Valor a ser adicionado
	 */
	public void adicionaDinheiroCaixa(int valor) {
		this.caixa += valor;

	}

	/**
	 * Remove dinheiro do caixa destinado a um cenário com bônus
	 * 
	 * @param valor
	 */
	public void removeDinheiroCaixa(int valor) {
		this.caixa -= valor;
	}

	/**
	 * Retorna um numero inteiro que representa a quantidade de centavos que contém
	 * no caixa.
	 * 
	 * @return o valor atual do caixa
	 */
	public int getCaixa() {
		return this.caixa;

	}

	/**
	 * Retorna um double com a porcentagem que inicializou o sistema.
	 * 
	 * @return a porcetagem usada para a inicialização do sistema.
	 */
	public double getTaxa() {
		return this.taxa;
	}

}