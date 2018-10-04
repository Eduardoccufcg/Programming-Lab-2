package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Responsável por controlar todas as ações que podem ser feitas em um cenário.
 * Como cadastrar um cenário e cadastrar uma aposta.
 * 
 * @author Eduardo Pereira - 117210342
 */
public class ControllerCenario {

	/**
	 * Caixa do sistema
	 */
	private Caixa caixa;

	/**
	 * Mapa contendo os cenários.
	 */
	private Map<Integer, Cenario> cenarios;

	/**
	 * Retorna o valor acumulado no caixa.
	 * 
	 * @return um inteiro representando o caixa
	 */
	public int getCaixa() {
		return this.caixa.getCaixa();
	}

	/**
	 * Armazena o tipo de ordenacao a ser usado.
	 */
	public Comparator<Cenario> ordenacao;

	/**
	 * Contrói o controller a partir da taxa e o caixa inicial.
	 */
	public ControllerCenario(int caixa, double taxa) {
		this.caixa = new Caixa(caixa, taxa);
		this.cenarios = new HashMap<>();
		this.ordenacao = new OrdenacaoNumeracao();
	}

	/**
	 * Cadastra um cenário com bônus a partir de sua descrição e bonus.
	 * 
	 * @param descricao
	 *            Descrição do cenário
	 * @return o id do cenario
	 */

	public int cadastraCenario(String descricao) {

		int id = this.cenarios.size() + 1;

		Cenario cenario = new Cenario(descricao, id);

		this.cenarios.put(id, cenario);
		return id;

	}

	/**
	 * Cadastra um cenário a partir de sua descrição.
	 * 
	 * @param descricao
	 *            Descrição do cenário
	 * @return um inteiro
	 */
	public int cadastraCenarioBonus(String descricao, int bonus) {
		int id = this.cenarios.size() + 1;
		;
		CenarioBonus cenario = new CenarioBonus(descricao, id, bonus);
		this.caixa.removeDinheiroCaixa(bonus);
		this.cenarios.put(id, cenario);
		return id;
	}

	/**
	 * Retorna uma String representando a situação do cenário.
	 * 
	 * @param id
	 *            Número do cenário
	 * @return uma String
	 */
	public String exibeCenario(int id) {

		if (id <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return cenarios.get(id).toString();

	}

	/**
	 * Retorna uma lista contendo todos os cenários cadastrados.
	 * 
	 * @return uma String dos cenários
	 */
	public String listaCenarios() {
		String lista = "";
		for (Cenario cenario : this.cenarios.values()) {
			lista += cenario.toString() + System.lineSeparator();
		}
		return lista;
	}

	/**
	 * Cadastra uma aposta em um cenário.
	 * 
	 * @param id
	 *            Numero do cenário
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da Aposta
	 * @param previsao
	 *            Previsão sobre o cenário
	 * @return um booleano
	 */
	public void cadastraAposta(int id, String apostador, int valor, String previsao) {

		if (id <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}

		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}

		this.cenarios.get(id).cadastraAposta(apostador, valor, previsao);

	}

	/**
	 * Cadastra uma aposta assegurada por valor a partir do id do cenário, nome do
	 * apostador, o valor da aposta e a previsão "VAI ACONTECER" OU "N VAI
	 * ACONTECER", valor assegurado e custo.
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
	public int cadastraApostaSeguroValor(int id, String apostador, int valor, String previsao, int valorAssegurado,
			int custo) {

		if (id <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
		}
		this.caixa.adicionaDinheiroCaixa(custo);
		return this.cenarios.get(id).cadastraApostaSeguraValor(apostador, valor, previsao, valorAssegurado, custo);

	}

	/**
	 * Cadastra uma aposta assegurada por taxa a partir do id do cenário, nome do
	 * apostador, o valor da aposta e a previsão "VAI ACONTECER" OU "N VAI
	 * ACONTECER", taxa e custo.
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
	public int cadastraApostaSeguroTaxa(int id, String apostador, int valor, String previsao, double taxa, int custo) {

		if (id <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		}
		this.caixa.adicionaDinheiroCaixa(custo);
		return this.cenarios.get(id).cadastraApostaSeguraTaxa(apostador, valor, previsao, taxa, custo);

	}

	/**
	 * Retorna a soma de todas as apostas de um cenário.
	 * 
	 * @param cenario
	 *            Numero do cenario.
	 * @return um inteiro
	 */
	public int valorTotalDeApostas(int id) {

		if (id <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(id).valorTotalApostas();

	}

	/**
	 * Retorna o número de apostas cadastradas em um cenário.
	 * 
	 * @param cenario
	 *            Número do cenário
	 * @return um inteiro representando a quantidade de apostas
	 */
	public int totalDeApostas(int id) {

		if (id <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}

		return this.cenarios.get(id).qtdApostas();

	}

	/**
	 * Retorna uma lista contendo todas as apostas de um cenário.
	 * 
	 * @param cenario
	 *            Número do cenário
	 * @return uma String contendo todas as apostas
	 */
	public String exibeApostas(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("Erro ao exibir apostas de cenario: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException("Erro ao exibir apostas de cenario: Cenario nao cadastrado");
		}

		return this.cenarios.get(id).listaApostas();

	}

	/**
	 * Fecha um cenário a partir do seu número a partir de um booleano true caso o
	 * cenario tenha acontecido. e false caso contrário.
	 * 
	 * @param cenario
	 *            Número do cenário
	 * @param ocorreu
	 *            Booleano true ou false
	 * 
	 */
	public void fechaCenario(int id, boolean ocorreu) {
		if (id <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}

		this.cenarios.get(id).fechaCenario(ocorreu);
		this.cenarios.get(id).calculaValorPerdedores(ocorreu);
		this.caixa.adicionaDinheiroCaixa((int) (this.cenarios.get(id).getValorPerdedores() * this.caixa.getTaxa()));
		this.caixa.removeDinheiroCaixa(this.cenarios.get(id).getValorAssegurado());

	}

	/**
	 * Retorna o valor que vai para o caixa do sistema.
	 * 
	 * @param id
	 *            Número do cenario
	 * @return um inteiro
	 */
	public int getCaixaCenario(int id) {

		if (id <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		if (this.cenarios.get(id).getEstado().equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		return (int) (this.cenarios.get(id).getValorPerdedores() * this.caixa.getTaxa());

	}

	/**
	 * Retorna o valor que vai ser repartido aos ganhadores.
	 * 
	 * @param id
	 *            Numero do cenário
	 * @return um inteiro representando o valor do rateio
	 */
	public int getTotalRateioCenario(int id) {

		if (id <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}

		if (this.cenarios.get(id).getEstado().equals("Nao finalizado")) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}

		return this.cenarios.get(id).getValorPerdedores()
				- (int) (this.cenarios.get(id).getValorPerdedores() * this.caixa.getTaxa())
				+ this.cenarios.get(id).getBonus();

	}

	/**
	 * Retorna o estado do cenario.
	 * 
	 * @param id
	 *            Numero do cenario
	 * 
	 * @return String do estado
	 */
	public String getEstadoCenario(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("Erro na consulta do Estado do cenario: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException("Erro na consulta do Estado do cenario: Cenario nao cadastrado");
		}

		return this.cenarios.get(id).getEstado();
	}

	/**
	 * Altera uma aposta assegurada por taxa por uma aposta assegurada por valor.
	 * 
	 * @param id
	 *            Id do cenário
	 * 
	 * @param apostaAssegurada
	 *            Aposta Segurada
	 * @param taxa
	 *            Taxa
	 * @return o Id
	 */
	public int alterarSeguroValor(int id, int apostaAssegurada, int valor) {

		if (id <= 0) {
			throw new IllegalArgumentException("Erro na consulta do Estado do cenario: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException("Erro na consulta do Estado do cenario: Cenario nao cadastrado");
		}
		return this.cenarios.get(id).alterarSeguroValor(apostaAssegurada, valor);

	}

	/**
	 * Altera uma aposta assegurada por valor por uma aposta assegurada por taxa.
	 * 
	 * @param id
	 *            Id do cenário
	 * 
	 * @param apostaAssegurada
	 *            Aposta Segurada
	 * @param taxa
	 *            Taxa
	 * @return o Id
	 */
	public int alterarSeguroTaxa(int id, int apostaAssegurada, double taxa) {

		if (id <= 0) {
			throw new IllegalArgumentException("Erro na consulta do Estado do cenario: Cenario invalido");
		}
		if (!(this.cenarios.containsKey(id))) {
			throw new IllegalArgumentException("Erro na consulta do Estado do cenario: Cenario nao cadastrado");
		}
		return this.cenarios.get(id).alterarSeguroTaxa(apostaAssegurada, taxa);

	}

	/**
	 * Altera a ordem que os cenarios serão listados. Sendo elas : por numeracao,
	 * descricao ou total de apostas
	 * 
	 * @param ordem
	 *            Ordem
	 */
	public void alteraOrdem(String ordem) {
		if (ordem == null || ordem.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}

		if (ordem.equals("nome")) {
			this.ordenacao = new OrdenacaoDescricao();

		} else if (ordem.equals("apostas")) {
			this.ordenacao = new OrdenacaoTotalApostas();
		} else if (ordem.equals("cadastro")) {
			this.ordenacao = new OrdenacaoNumeracao();
		} else {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}

	}

	/**
	 * Exibe o cenário ordenado.
	 * 
	 * @param cenario
	 *            Id do cenário
	 * @return uma lista contendo as apostas do cenario ordenado
	 */
	public String exibeCenarioOrdenado(int cenario) {

		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario invalido");
		}

		if (!(this.cenarios.containsKey(cenario))) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		}
		ArrayList<Cenario> listaDeCenarios = new ArrayList<Cenario>(cenarios.values());
		Collections.sort(listaDeCenarios, this.ordenacao);
		return listaDeCenarios.get(cenario - 1).toString();
	}

}
