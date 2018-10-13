package prova2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PacotaoTest {
	
	private Encomenda encomenda1;
	
	
	private Pacotao pacotao;

	@Before
	public void test() {
		pacotao = new Pacotao(1);
		encomenda1 = new Cr(1,10);
	}
	@Test
	public void testAdicionaElemento() {
		assertTrue(this.pacotao.adicionaEncomenda(encomenda1));
		
	}
	@Test
	public void testExisteEncomendaTrue() {
		this.pacotao.adicionaEncomenda(encomenda1);
		assertTrue(this.pacotao.existeEncomenda(encomenda1));
	}
	@Test
	public void testExisteEncomendaFalse() {
		assertFalse(this.pacotao.existeEncomenda(encomenda1));
	}
	

}
