package lab5test;
import lab5.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Responsavel pelos testes da classe SeguroValor.
 * 
 * @author Eduardo Pereira - 117210342
 *
 */

public class SeguroValorTest {
	
	/**
	 * Seguro usado nos testes.
	 */
	private SeguroValor seguro;
	

	/**
	 * Instancia o seguro que será usada nos testes.
	 */
	@Before
	public void criaSeguro() {
		this.seguro = new SeguroValor(100);
	}
	
	/**
	 * Testa construir um seguro assegurado por valor com valor assegurado negativo..
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstruirSeguroValorAsseguradoNegativo() {
		this.seguro = new SeguroValor(-100);
	}

	/**
	 * Testa o método getValor.
	 */
	@Test
	public void testGetValor() {
		assertEquals(this.seguro.getValor(), 100);
	}
	
	/**
	 * Testa o toString.
	 */
	@Test
	public void testToString() {
		assertEquals(this.seguro.toString(), " - ASSEGURADA(VALOR) - R$ 100,00");
	}

}
