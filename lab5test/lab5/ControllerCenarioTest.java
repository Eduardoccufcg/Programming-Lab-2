package lab5;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;

import org.junit.Test;

/**
 *
 * Responsavel por testar a classe ControllerCenario.
 * 
 * @author Eduardo Pereira - 117210342
 */
public class ControllerCenarioTest {

	/**
	 * Controller para realizar os testes.
	 */
	private ControllerCenario controller;

	/**
	 * Usado para ordenar as aposta de um cenario nos testes.
	 */
	public Comparator<Cenario> ordenacao;

	/**
	 * Instancia o controller e inicializa o caixa e a ordenacao.
	 */

	@Before
	public void CriaController() {
		this.controller = new ControllerCenario(100, 0.1);
		this.ordenacao = new OrdenacaoNumeracao();

	}

	/**
	 * Testa inicializar o sistema.
	 */
	@Test
	public void testInicializa() {
		this.controller = new ControllerCenario(100, 0.1);
		assertEquals(this.controller.getCaixa(), 100);

	}

	/**
	 * Testa inicializar o sistema com caixa negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInicializaCaixaNegativa() {
		this.controller = new ControllerCenario(-10, 0.01);

	}

	/**
	 * Testa inicializar o sistema com caixa negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInicializaTaxaNegativa() {
		this.controller = new ControllerCenario(10, -0.01);

	}

	/**
	 * Testa o método getCaixa.
	 */
	@Test
	public void testGetCaixa() {
		assertEquals(this.controller.getCaixa(), 100);

	}

	/**
	 * Testa cadastrar um cenário com descrição vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraCenarioDescricaoVazia() {
		this.controller.cadastraCenario("");
	}

	/**
	 * Testa cadastrar um cenário com descrição nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraCenarioDescricaoNula() {
		this.controller.cadastraCenario(null);
	}

	/**
	 * Testa cadastrar um cenário bônus com descrição nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraCenarioBonusDescricaoNula() {
		this.controller.cadastraCenarioBonus(null, 100);
	}

	/**
	 * Testa cadastrar um cenário com bônus com descrição vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraCenarioBonusDescricaoVazia() {
		this.controller.cadastraCenarioBonus("", 1000);
	}

	/**
	 * Testa cadastrar um cenário com bônus com bonificação negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraCenarioBonusNegativo() {
		this.controller.cadastraCenarioBonus("Vai chover", -1);
	}

	/**
	 * Testa exibir um cenário.
	 */
	@Test
	public void testExibeCenario() {
		this.controller.cadastraCenario("Não Vai chover");
		assertEquals(this.controller.exibeCenario(1), "1 - Não Vai chover - Nao finalizado");
	}

	/**
	 * Testa exibir um cenário com bônus.
	 */
	@Test
	public void testExibeCenarioBonus() {

		this.controller.cadastraCenarioBonus("Não Vai chover", 10000);
		assertEquals(this.controller.exibeCenario(1), "1 - Não Vai chover - Nao finalizado - R$ 100,00");

	}

	/**
	 * Testa exibir um cenário com numeração negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibeCenarioNumeracaoNegativa() {
		this.controller.exibeCenario(-1);

	}

	/**
	 * Testa exibir um cenário não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibeCenarioNaoCadastrado() {
		this.controller.exibeCenario(-1);

	}

	/**
	 * Testa listar os cenários.
	 */
	@Test
	public void testListaCenarios() {
		this.controller.cadastraCenario("Não Vai chover");
		this.controller.cadastraCenario("Vai chover");

		assertEquals(this.controller.listaCenarios(), "1 - Não Vai chover - Nao finalizado" + System.lineSeparator()
				+ "2 - Vai chover - Nao finalizado" + System.lineSeparator());

	}

	/**
	 * Testa listar os cenários sem cenarios cadastrados.
	 */
	@Test
	public void testListaCenariosSemCenariosCadastrados() {
		assertEquals(this.controller.listaCenarios(), "");

	}

	/**
	 * Testa cadastrar uma aposta.
	 */
	@Test
	public void testCadastraAposta() {
		this.controller.cadastraCenario("Não Vai chover");

		this.controller.cadastraAposta(1, "EDUARDO", 10, "VAI ACONTECER");
		assertEquals(this.controller.totalDeApostas(1), 1);
	}

	/**
	 * Testa cadastrar uma aposta com numeração do cenário negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaNumeracaoCenarioNegativa() {
		this.controller.cadastraCenario("Não Vai chover");

		this.controller.cadastraAposta(-1, "EDUARDO", 10, "VAI ACONTECER");
	}

	/**
	 * Testa cadastrar uma aposta em um cenário não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaCenarioNaoCadastrado() {
		this.controller.cadastraCenario("Não Vai chover");

		this.controller.cadastraAposta(6, "EDUARDO", 10, "VAI ACONTECER");
	}

	/**
	 * Testa cadastrar uma aposta com nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaNomeVazio() {
		this.controller.cadastraCenario("Não Vai chover");

		this.controller.cadastraAposta(1, "", 10, "VAI ACONTECER");
	}

	/**
	 * Testa cadastrar uma aposta com nome do apostador nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaNomeNulo() {
		this.controller.cadastraCenario("Não Vai chover");

		this.controller.cadastraAposta(1, null, 10, "VAI ACONTECER");
	}

	/**
	 * Testa cadastrar uma aposta com valor negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorNegativo() {
		this.controller.cadastraCenario("Não Vai chover");

		this.controller.cadastraAposta(1, "EDUARDO", -10, "VAI ACONTECER");
	}

	/**
	 * Testa cadastrar uma aposta com previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoVazia() {
		this.controller.cadastraCenario("Não Vai chover");

		this.controller.cadastraAposta(1, "EDUARDO", 10, "");
	}

	/**
	 * Testa cadastrar uma aposta com previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaPrevisaoNula() {
		this.controller.cadastraCenario("Não Vai chover");

		this.controller.cadastraAposta(1, "EDUARDO", 10, null);
	}

	/**
	 * Testa cadastrar uma aposta com previsão desconhecida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoDesconhecida() {
		this.controller.cadastraCenario("Não Vai chover");

		this.controller.cadastraAposta(1, "EDUARDO", 10, "TALVEZ");
	}

	/**
	 * Testa o valor total de todas das apostas de um cenário.
	 */
	@Test
	public void testValorTotalDeApostas() {
		this.controller.cadastraCenario("Não Vai chover");
		this.controller.cadastraAposta(1, "EDUARDO", 10, "VAI ACONTECER");
		assertEquals(this.controller.valorTotalDeApostas(1), 10);
	}

	/**
	 * Testa o valor total de todas das apostas de um cenário com numeração
	 * negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasNumeracaoNegativa() {
		this.controller.valorTotalDeApostas(-1);
	}

	/**
	 * Testa o valor total de todas das apostas de um cenário não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasCenarioNaoCadastrado() {
		this.controller.valorTotalDeApostas(3);
	}

	/**
	 * Testa o total de todas das apostas de um cenário.
	 */
	@Test
	public void testTotalDeApostas() {
		this.controller.cadastraCenario("Não Vai chover");
		this.controller.cadastraAposta(1, "EDUARDO", 10, "VAI ACONTECER");
		assertEquals(this.controller.totalDeApostas(1), 1);
	}

	/**
	 * Testa o total de todas das apostas de um cenário com numeração negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasNumeracaoNegativa() {
		this.controller.totalDeApostas(-1);
	}

	/**
	 * Testa o total de todas das apostas de um cenário não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasCenarioNaoCadastrado() {
		this.controller.totalDeApostas(2);
	}

	/**
	 * Testa fechar o cenário quando ele ocorreu.
	 */
	@Test
	public void testFechaCenarioOcorreu() {
		this.controller.cadastraCenario("Não Vai chover");
		this.controller.fechaCenario(1, true);
		assertEquals(this.controller.getEstadoCenario(1), "Finalizado (ocorreu)");
	}

	/**
	 * Testa fechar o cenário quando ele não ocorreu.
	 */
	@Test
	public void testFechaCenarioNaoOcorreu() {
		this.controller.cadastraCenario("Não Vai chover");
		this.controller.fechaCenario(1, false);
		assertEquals(this.controller.getEstadoCenario(1), "Finalizado (n ocorreu)");
	}

	/**
	 * Testa fechar um cenário com numeração negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFechaCenarioNumeracaoNegativo() {

		this.controller.fechaCenario(-1, false);

	}

	/**
	 * Testa fechar um cenário não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFechaCenarioNaoCadastrado() {

		this.controller.fechaCenario(2, false);

	}

	/**
	 * Testa o método getCaixaCenario.
	 */
	@Test
	public void testGetCaixaCenario() {

		this.controller.cadastraCenario("Não Vai chover");
		this.controller.cadastraAposta(1, "EDUARDO", 10, "VAI ACONTECER");
		this.controller.fechaCenario(1, false);
		assertEquals(this.controller.getCaixaCenario(1), 1);
	}

	/**
	 * Testa o método getCaixaCenario em um cenário sem apostas.
	 */
	@Test
	public void testGetCaixaCenarioSemAPostas() {
		this.controller.cadastraCenario("Não Vai chover");
		this.controller.fechaCenario(1, false);
		assertEquals(this.controller.getCaixaCenario(1), 0);
	}

	/**
	 * Testa o método getCaixaCenario em um cenário com numeração nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioNumeracaoNegativa() {
		this.controller.getCaixaCenario(-1);
	}

	/**
	 * Testa o método getCaixaCenario em um cenário não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioNaoCadastrado() {
		this.controller.getCaixaCenario(2);
	}

	/**
	 * Testa o método getCaixaCenario em um cenário ainda aberto.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioAberto() {

		this.controller.cadastraCenario("Não Vai chover");
		this.controller.cadastraAposta(1, "EDUARDO", 10, "VAI ACONTECER");
		this.controller.getCaixaCenario(1);
	}

	/**
	 * Testa o método getTotalRateioCenario.
	 */
	@Test
	public void testGetTotalRateioCenario() {
		this.controller.cadastraCenario("Não Vai chover");
		this.controller.cadastraAposta(1, "EDUARDO", 10, "VAI ACONTECER");
		this.controller.fechaCenario(1, false);
		assertTrue(this.controller.getTotalRateioCenario(1) == 9.0);
	}

	/**
	 * Testa o método getTotalRateioCenario em um cenário sem apostas.
	 */
	@Test
	public void testGetTotalRateioCenarioSemAPostas() {
		this.controller.cadastraCenario("Não Vai chover");
		this.controller.fechaCenario(1, false);
		assertTrue(this.controller.getTotalRateioCenario(1) == 0.0);
	}

	/**
	 * Testa o método getTotalRateioCenario em um cenário com numeração negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetTotalRateioCenarioNumeracaoNegativa() {
		this.controller.getTotalRateioCenario(-1);
	}

	/**
	 * Testa o método getTotalRateioCenario em um cenário não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetTotalRateioCenarioNaoCadastrado() {
		this.controller.getTotalRateioCenario(2);
	}

	/**
	 * Testa o método getTotalRateioCenario em um cenário aberto.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetTotalRateioCenarioAberto() {

		this.controller.cadastraCenario("Não Vai chover");
		this.controller.cadastraAposta(1, "EDUARDO", 10, "VAI ACONTECER");
		this.controller.getTotalRateioCenario(1);
	}

	/**
	 * Testa o método getEstadoCenario.
	 */
	@Test
	public void testGetEstadoCenario() {

		this.controller.cadastraCenario("Não Vai chover");
		assertEquals(this.controller.getEstadoCenario(1), "Nao finalizado");
	}

	/**
	 * Testa o método getEstadoCenario em um cenário com numeração negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetEstadoCenarionumeracaoNegativa() {
		this.controller.getEstadoCenario(-1);
	}

	/**
	 * Testa o método getEstadoCenario em um cenário não cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetEstadocenarioNaoCadastrado() {
		this.controller.getEstadoCenario(2);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaTaxaApostadorVazio() {
		this.controller.cadastraApostaSeguroTaxa(1, "", 10, "VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com nome do apostador nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaTaxaApostadorNulo() {
		this.controller.cadastraCenario("vai chover");
		this.controller.cadastraApostaSeguroTaxa(1, null, 10, "VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com valor da aposta negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaTaxaValorNegativa() {
		this.controller.cadastraApostaSeguroTaxa(1, "EDUARDO", -20, "VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaTaxaPrevisaoVazia() {
		this.controller.cadastraApostaSeguroTaxa(1, "EDUARDO", 10, "", 0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaTaxaPrevisaoNula() {
		this.controller.cadastraCenario("vai chover");
		this.controller.cadastraApostaSeguroTaxa(1, "EDUARDO", 10, null, 0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com taxa negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaTaxaNegativa() {
		this.controller.cadastraApostaSeguroTaxa(1, "EDUARDO", 20, "VAI ACONTECER", -0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com custo negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaTaxaCustoNegativo() {
		this.controller.cadastraApostaSeguroTaxa(1, "EDUARDO", 10, "", 0.01, -50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorApostadorVazio() {
		this.controller.cadastraApostaSeguroValor(1, "", 10, "VAI ACONTECER", 200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com nome do apostador nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaValorApostadorNulo() {
		this.controller.cadastraCenario("vai chover");
		this.controller.cadastraApostaSeguroValor(1, null, 10, "VAI ACONTECER", 200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com valor da aposta negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorValorNegativa() {
		this.controller.cadastraApostaSeguroValor(1, "EDUARDO", -20, "VAI ACONTECER", 200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorPrevisaoVazia() {
		this.controller.cadastraApostaSeguroValor(1, "EDUARDO", 10, "", 200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaValorPrevisaoNula() {
		this.controller.cadastraCenario("vai chover");
		this.controller.cadastraApostaSeguroValor(1, "EDUARDO", 10, null, 200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com valor assegurado negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorAsseguradoNegativo() {
		this.controller.cadastraApostaSeguroValor(1, "EDUARDO", 20, "VAI ACONTECER", -200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com custo negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorCustoNegativo() {
		this.controller.cadastraApostaSeguroValor(1, "EDUARDO", 10, "", 200, -50);
	}

	/**
	 * Testa alterar seguro taxa para seguro valor com cenario com id negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlterarSeguroValorIdNegativo() {
		this.controller.alterarSeguroValor(-1, 100, 20);
	}

	/**
	 * Testa alterar seguro taxa para seguro valor com id aposta negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlterarSeguroValorApostaAsseguradaNegativa() {
		this.controller.alterarSeguroValor(1, -100, 20);
	}

	/**
	 * Testa alterar seguro taxa para seguro valor com valor negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlterarSeguroValorApostaValorNegativo() {
		this.controller.alterarSeguroValor(1, 100, -20);
	}

	/**
	 * Testa alterar seguro taxa para seguro valor em cenario nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlterarSeguroValorCenarioNaoCadastrado() {
		this.controller.alterarSeguroValor(5, 100, 20);
	}

	/**
	 * Testa alterar seguro valor para seguro taxa com id cenario negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlterarSeguroTaxaIdNegativo() {
		this.controller.alterarSeguroTaxa(-1, 100, 20);
	}

	/**
	 * Testa alterar seguro valor para seguro taxa de um aposta com id aposta
	 * negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlterarSeguroTaxaApostaAsseguradaNegativa() {
		this.controller.alterarSeguroTaxa(1, -100, 0.05);
	}

	/**
	 * Testa alterar seguro valor para seguro taxa de um aposta com valor negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlterarSeguroValorApostaTaxaNegativa() {
		this.controller.alterarSeguroTaxa(1, 100, -1.5);
	}

	/**
	 * Testa alterar seguro valor para seguro taxa em cenario nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlterarSeguroTaxaCenarioNaoCadastrado() {
		this.controller.alterarSeguroTaxa(5, 100, 1.5);
	}

	/**
	 * Testa alterar ordem na exibicao das apostas de um cenario com ordem nula.
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraOrdemNula() {
		this.controller.alteraOrdem(null);
	}

	/**
	 * Testa alterar ordem na exibicao das apostas de um cenario com ordem vazia.
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraOrdemVazia() {
		this.controller.alteraOrdem("");
	}

	/**
	 * Testa alterar ordem na exibicao das apostas de um cenario com ordem
	 * inexistente.
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraOrdemInexistente() {
		this.controller.alteraOrdem("valorApostas");
	}

	/**
	 * Testa exibir cenario ordenado com id negativo.
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibeCenarioOrdenadoIdNegativo() {
		this.controller.exibeCenarioOrdenado(-10);
	}

	/**
	 * Testa exibir cenario ordenado com cenario nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibeCenarioOrdenadoCenarioNaoCadastrado() {
		this.controller.exibeCenarioOrdenado(2);
	}

	/**
	 * Testa exibir cenario ordenado por numeracao.
	 */
	@Test
	public void testExibeCenarioOrdenadoNumeracao() {
		this.controller.cadastraCenario("Vai chover");
		this.controller.cadastraCenario("Vai fazer sol");
		assertEquals(this.controller.exibeCenarioOrdenado(1), "1 - Vai chover - Nao finalizado");

	}

	/**
	 * Testa exibir cenario ordenado por qtdApostas.
	 */
	@Test
	public void testExibeCenarioOrdenadoqtdApostas() {
		this.controller.alteraOrdem("apostas");
		this.controller.cadastraCenario("Vai chover");
		this.controller.cadastraCenario("Vai fazer sol");
		this.controller.cadastraAposta(2, "Eduardo", 1000, "N VAI ACONTECER");
		this.controller.cadastraAposta(2, "Eduardo", 1000, "VAI ACONTECER");
		assertEquals(this.controller.exibeCenarioOrdenado(1), "2 - Vai fazer sol - Nao finalizado");

	}

	/**
	 * Testa exibir cenario ordenado por qtdApostas.
	 */
	@Test
	public void testExibeCenarioOrdenadoDescricao() {
		this.controller.alteraOrdem("nome");
		this.controller.cadastraCenario("Vai chover");
		this.controller.cadastraCenario("Hoje tiro 7");
		assertEquals(this.controller.exibeCenarioOrdenado(1), "2 - Hoje tiro 7 - Nao finalizado");

	}
}
