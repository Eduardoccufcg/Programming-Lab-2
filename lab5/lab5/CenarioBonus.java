package lab5;

/**
 * Representa um Cenario com bonus.
 * 
 * @author Eduardo Pereira - 117210342
 *
 */
public class CenarioBonus extends Cenario {
	/**
	 * Bonus do cenario.
	 */
	private int bonus;

	/**
	 * Constroi um cenario bonus.
	 * 
	 * @param descricao
	 *            Descrição do cenario
	 * @param numeracao
	 *            Id do cenario
	 * @param bonus
	 *            Bônus do cenario
	 */
	public CenarioBonus(String descricao, int numeracao, int bonus) {
		super(descricao, numeracao);
		if (bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		this.bonus = bonus;

	}

	/**
	 * Retorna a representação textual de um cenario bonus.
	 * 
	 * @return uma String
	 */
	@Override
	public String toString() {
		String resultado = String.format("%.2f", this.bonus * 0.01);
		return super.toString() + " - R$ " + resultado;
	}

	/**
	 * Retorna o bonus do cenario.
	 * 
	 * @return um inteiro
	 */
	@Override
	public int getBonus() {
		return this.bonus;
	}

}
