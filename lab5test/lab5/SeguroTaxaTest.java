package lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Responsavel pelos testes da classe SeguroTaxa.
 * 
 * @author Eduardo Pereira - 117210342
 *
 */

public class SeguroTaxaTest {

	/**
	 * Seguro usado nos testes.
	 */
	private SeguroTaxa seguro;

	/**
	 * Instancia o seguro que será usada nos testes.
	 */
	@Before
	public void criaSeguro() {
		this.seguro = new SeguroTaxa(100, 0.45);
	}

	/**
	 * Testa construir um seguro assegurado por taxa com taxa negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstruirSeguroTaxaNegativa() {
		this.seguro = new SeguroTaxa(100, -0.45);
	}
	
	/**
	 * Testa construir um seguro assegurado por taxa com valor da aposta negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstruirSeguroTaxaValorApostaNegativa() {
		this.seguro = new SeguroTaxa(-100, 2.0);
	}

	/**
	 * Testa o método getValor.
	 */
	@Test
	public void testGetValor() {
		assertEquals(this.seguro.getValor(), 45);
	}

	/**
	 * Testa o toString.
	 */
	@Test
	public void testToString() {
		assertEquals(this.seguro.toString(), " - ASSEGURADA(TAXA) - 45%");
	}

}
