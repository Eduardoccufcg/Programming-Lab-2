package prova3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import prova3.Quiosque;

public class QuiosqueTest {

	Quiosque quiosque;

	@Before
	public void inicializa() {
		this.quiosque = new Quiosque ();
	}
	@Test
	public void testGetTipo() {
		assertEquals(this.quiosque.getTipo(),"QUIOSQUE");
	}



}
