package lab5test;
import lab5.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Responsável por testar a classe Seguro.
 * 
 * @author Eduardo Pereira - 117210342
 *
 */
public class SeguroTest {

	/**
	 * Seguro usado nos testes.
	 */
	private Seguro seguro;

	/**
	 * Instancia o seguro que será usada nos testes.
	 */
	@Before
	public void criaSeguro() {
		this.seguro = new Seguro();
	}

	/**
	 * Testa o método getValor.
	 */
	@Test
	public void testGetValor() {
		assertEquals(this.seguro.getValor(), 0);
	}

	/**
	 * Testa o toString.
	 */
	@Test
	public void testToString() {
		assertEquals(this.seguro.toString(), "");
	}
}
