package lab5test;
import lab5.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Responsável pelo teste da classe Caixa.
 *
 * @author Eduardo Pereira - 117210342
 */
public class CaixaTest {
	/**
	 * Caixa que seŕa usada nos testes.
	 */
	private Caixa caixa;
	
    /**
     * Instancia um caixa que será usado nos testes.
     */
    @Before
	public void criaCaixa() {
		this.caixa = new Caixa(10,0.01);
	}
	
    /**
     * Testa construir um caixa com valor inicial negativo.
     */
    @Test(expected = IllegalArgumentException.class)
	public void testCriarCaixaValorInicialNegativa() {
		this.caixa = new Caixa(-2,0.01);
		
	}
	
    /**
     * Testa construir um caixa com taxa negativa.
     */
    @Test(expected = IllegalArgumentException.class)
	public void testCriarCaixaPorcentagemNegativa() {
		this.caixa = new Caixa(5,-2);
		
	}

    /**
     * Testa adicionar dinheiro após o fechamento de um cenário no caixa.
     */
    @Test
	public void testAdicionarDinheiroNoCaixa() {
		this.caixa.adicionaDinheiroCaixa(20);
		assertEquals(this.caixa.getCaixa(),30);
	}
	
    /**
     * Testa o método getCaixa.
     */
    @Test
	public void testGetCaixa() {
		assertEquals(this.caixa.getCaixa(),10);
	}
	
    /**
     * Testa o método getPorcentagem.
     */
    @Test
	public void testGetPorcentagem() {
		assertTrue(this.caixa.getTaxa() == 0.01);
	}
	

}
