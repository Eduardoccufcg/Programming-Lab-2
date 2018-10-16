package lab5test;
import lab5.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Responsável por testar a classe Aposta.
 * 
 * @author Eduardo Pereira
 */
public class ApostaTest {

	/**
	 * Aposta que será usada nos testes.
	 */

	private Aposta aposta;

	/**
	 * Instancia a aposta que será usada nos testes.
	 */
	@Before
	public void criaAposta() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 100, "N VAI ACONTECER");
	}

	/**
	 * Testa construir uma aposta com nome do apostador nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarApostaApostadorNulo() {
		this.aposta = new Aposta(null, 100, "N VAI ACONTECER");

	}

	/**
	 * Testa construir uma aposta com nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaApostadorVazio() {
		this.aposta = new Aposta("", 100, "N VAI ACONTECER");

	}

	/**
	 * Testa construir uma aposta com valor negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaValorNegativo() {
		this.aposta = new Aposta("EDUARDO PEREIRA", -5, "N VAI ACONTECER");

	}

	/**
	 * Testa construir uma aposta com previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarApostaPrevisaoNula() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 100, null);

	}

	/**
	 * Testa construir uma aposta com previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaPrevisaoVazia() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 100, "");

	}

	/**
	 * Testa o método getValor.
	 */
	@Test
	public void testGetValor() {
		assertTrue(this.aposta.getValor() == 100);
	}

	/**
	 * Testa o método getPrevisao
	 */
	@Test
	public void testGetPrevisao() {
		assertEquals(this.aposta.getPrevisao(), "N VAI ACONTECER");
	}

	/**
	 * Testa o método toString
	 */
	@Test
	public void testToString() {
		assertEquals(this.aposta.toString(), "EDUARDO PEREIRA - R$100 - N VAI ACONTECER");
	}

	/**
	 * Testa construir uma aposta assegurada por taxa com nome do apostador nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarApostaAsseguradaValorApostadorNulo() {
		this.aposta = new Aposta(null, 100, "N VAI ACONTECER", 0.01, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por taxa com nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaAsseguradaValorApostadorVazio() {
		this.aposta = new Aposta("", 100, "N VAI ACONTECER", 0.01, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por taxa com valor negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaAsseguradaTaxaValorNegativo() {
		this.aposta = new Aposta("EDUARDO PEREIRA", -5, "N VAI ACONTECER", 0.01, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por taxa com previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarApostaAsseguradaTaxaPrevisaoNula() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 100, null, 0.01, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por taxa com previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaAsseguradaTaxaPrevisaoVazia() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 100, "", 0.01, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por taxa com taxa negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaAsseguradaTaxacomTaxaNegativa() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 125, "N VAI ACONTECER", -0.01, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por valor com custo negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaAsseguradaTaxaCustoNegativo() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 100, "N VAI ACONTECER", 0.01, -50);

	}

	/**
	 * Testa toString de uma aposta assegurada por taxa.
	 * 
	 */
	@Test
	public void testToStringApostaTaxa() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 100, "N VAI ACONTECER", 0.01, 50);
		assertEquals(this.aposta.toString(), "EDUARDO PEREIRA - R$100 - N VAI ACONTECER - ASSEGURADA(TAXA) - 1%");
	}

	/**
	 * Testa construir uma aposta assegurada por valor com nome do apostador nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarApostaAsseguradaTaxaApostadorNulo() {
		this.aposta = new Aposta(null, 100, "N VAI ACONTECER", 200, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por valor com nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaAsseguradaTaxaApostadorVazio() {
		this.aposta = new Aposta("", 100, "N VAI ACONTECER", 200, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por valor com valor da aposta negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaAsseguradaValorComApostaComValorNegativo() {
		this.aposta = new Aposta("EDUARDO PEREIRA", -5, "N VAI ACONTECER", 200, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por valor com previsão nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarApostaAsseguradaValorPrevisaoNula() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 100, null, 200, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por valor com previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaAsseguradaValorPrevisaoVazia() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 100, "", 200, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por valor com valor assegurado
	 * negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaAsseguradaValorcomValorAsseguradoNegativa() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 125, "N VAI ACONTECER", -200, 50);

	}

	/**
	 * Testa construir uma aposta assegurada por valor com custo negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaAsseguradaValorCustoNegativo() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 100, "N VAI ACONTECER", 200, -50);

	}

	/**
	 * Testa toString de uma aposta assegurada por Valor.
	 * 
	 */
	@Test
	public void testToStringApostaValor() {
		this.aposta = new Aposta("EDUARDO PEREIRA", 100, "N VAI ACONTECER", 200, 50);
		assertEquals(this.aposta.toString(),
				"EDUARDO PEREIRA - R$100 - N VAI ACONTECER - ASSEGURADA(VALOR) - R$ 200,00");
	}

}
