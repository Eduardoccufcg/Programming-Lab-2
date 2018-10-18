package prova3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import prova3.Barraca;

public class BarracaTest {
	
	Barraca barraca;

	@Before
	public void inicializa() {
		this.barraca = new Barraca ();
	}
	@Test
	public void testGetTipo() {
		assertEquals(this.barraca.getTipo(),"BARRACA");
	}


}
