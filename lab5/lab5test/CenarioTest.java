package lab5test;
import lab5.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Responsável pelo testes da classe Cenario.
 * 
 * @author Eduardo Pereira - 117210342
 */
public class CenarioTest {
	/**
	 * Cenario usado nos testes.
	 */

	Cenario cenario;

	/**
	 * Cenario usado nos testes.
	 */
	Cenario cenario1;

	/**
	 * Instancia o cenario usado nos testes.
	 */
	@Before
	public void criaCenario() {
		this.cenario = new Cenario("Vai chover", 1);
		this.cenario.cadastraAposta("EDUARDO PEREIRA", 1, "N VAI ACONTECER");
		this.cenario.cadastraAposta("DUDU", 244, "VAI ACONTECER");

	}

	/**
	 * Testa construir cenario com descriçao vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstroiCenarioDescricaoVazia() {
		this.cenario = new Cenario("", 1);
	}

	/**
	 * Testa construir cenario com descriçao nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testConstroiCenarioDescricaoNula() {
		this.cenario = new Cenario(null, 1);
	}

	/**
	 * Testa toString da classe Cenario.
	 */
	@Test
	public void testToString() {
		;
		assertEquals(this.cenario.toString(), "1 - Vai chover - Nao finalizado");
	}

	/**
	 * Testa listar as apostas de um cenário.
	 */
	@Test
	public void testListaApostas() {

		assertEquals(this.cenario.listaApostas(), "EDUARDO PEREIRA - R$1 - N VAI ACONTECER" + System.lineSeparator()
				+ "DUDU - R$244 - VAI ACONTECER" + System.lineSeparator());
	}

	/**
	 * Testa listar apostas em um cenário sem apostas cadastradas.
	 */
	@Test
	public void testListaApostasEmCenarioSemAPostas() {
		this.cenario1 = new Cenario("Vai chover", 1);
		assertEquals(this.cenario1.listaApostas(), "");
	}

	/**
	 * Testa a quantidade de apostas cadastradas.
	 */
	@Test
	public void testQtdApostas() {
		assertEquals(this.cenario.qtdApostas(), 2);
	}

	/**
	 * Testa valor total das apostas (a soma de todas as apostas de um cenário).
	 */
	@Test
	public void testValorTotalApostas() {

		assertEquals(this.cenario.valorTotalApostas(), 245);
	}

	/**
	 * Testa fechar cenário que não ocorreu.
	 */
	@Test
	public void testFechaCenarioNaoOcorreu() {
		this.cenario.fechaCenario(false);
		assertEquals(this.cenario.getEstado(), "Finalizado (n ocorreu)");
	}

	/**
	 * Testa fechar cenário que ocorreu.
	 */
	@Test
	public void testFechaCenarioOcorreu() {
		this.cenario.fechaCenario(true);
		assertEquals(this.cenario.getEstado(), "Finalizado (ocorreu)");
	}

	/**
	 * Testa cadastrar aposta com nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaApostadorVazio() {
		this.cenario.cadastraAposta("", 10, "VAI ACONTECER");
	}

	/**
	 * Testa cadastrar aposta com nome do apostador nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaApostadorNulo() {
		this.cenario.cadastraAposta(null, 10, "VAI ACONTECER");
	}

	/**
	 * Testa cadastrar aposta com valor da aposta negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorNegativa() {
		this.cenario.cadastraAposta("EDUARDO", -20, "VAI ACONTECER");
	}

	/**
	 * Testa cadastrar aposta com previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoVazia() {
		this.cenario.cadastraAposta("EDUARDO", 10, "");
	}

	/**
	 * Testa cadastrar aposta com previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaPrevisaoNula() {
		this.cenario.cadastraAposta("EDUARDO", 10, null);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaTaxaApostadorVazio() {
		this.cenario.cadastraApostaSeguraTaxa("", 10, "VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com nome do apostador nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaTaxaApostadorNulo() {
		this.cenario.cadastraApostaSeguraTaxa(null, 10, "VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com valor da aposta negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaTaxaValorNegativa() {
		this.cenario.cadastraApostaSeguraTaxa("EDUARDO", -20, "VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaTaxaPrevisaoVazia() {
		this.cenario.cadastraApostaSeguraTaxa("EDUARDO", 10, "", 0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaTaxaPrevisaoNula() {
		this.cenario.cadastraApostaSeguraTaxa("EDUARDO", 10, null, 0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com taxa negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaTaxaNegativa() {
		this.cenario.cadastraApostaSeguraTaxa("EDUARDO", 20, "VAI ACONTECER", -0.01, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por taxa com custo negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaTaxaCustoNegativo() {
		this.cenario.cadastraApostaSeguraTaxa("EDUARDO", 10, "", 0.01, -50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorApostadorVazio() {
		this.cenario.cadastraApostaSeguraValor("", 10, "VAI ACONTECER", 200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com nome do apostador nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaValorApostadorNulo() {
		this.cenario.cadastraApostaSeguraValor(null, 10, "VAI ACONTECER", 200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com valor da aposta negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorValorNegativa() {
		this.cenario.cadastraApostaSeguraValor("EDUARDO", -20, "VAI ACONTECER", 200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorPrevisaoVazia() {
		this.cenario.cadastraApostaSeguraValor("EDUARDO", 10, "", 200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraApostaValorPrevisaoNula() {
		this.cenario.cadastraApostaSeguraValor("EDUARDO", 10, null, 200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com valor assegurado negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorAsseguradoNegativo() {
		this.cenario.cadastraApostaSeguraValor("EDUARDO", 20, "VAI ACONTECER", -200, 50);
	}

	/**
	 * Testa cadastrar aposta assegurada por valor com custo negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaValorCustoNegativo() {
		this.cenario.cadastraApostaSeguraValor("EDUARDO", 10, "", 200, -50);
	}

	/**
	 * Testa calcular o valor total das apostas perdedoras em um cenário que
	 * ocorreu.
	 */
	@Test
	public void testCalculaValorPerdedoresCenarioOcorreu() {
		this.cenario.calculaValorPerdedores(true);

		assertTrue(this.cenario.getValorPerdedores() == 1);

	}

	/**
	 * Testa calcular o valor total das apostas perdedoras em um cenário que não
	 * ocorreu.
	 */
	@Test
	public void testCalculaValorPerdedoresCenarioNaoOcorreu() {
		this.cenario.calculaValorPerdedores(true);
		assertEquals(this.cenario.getValorPerdedores(), 1);
	}

	/**
	 * Testa o métódo getValorPerdedores.
	 */
	@Test
	public void testGetValorPerdedores() {
		this.cenario.calculaValorPerdedores(false);
		assertEquals(this.cenario.getValorPerdedores(),244);
	}

	/**
	 * Testa o métódo getEstado.
	 */
	@Test
	public void testGetEstado() {
		assertEquals(this.cenario.getEstado(), "Nao finalizado");
	}
	

}
