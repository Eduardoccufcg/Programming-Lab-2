package prova3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import prova3.Restaurante;

public class RestauranteTest {

	Restaurante restaurante;

	@Before
	public void inicializa() {
		this.restaurante = new Restaurante ();
	}
	@Test
	public void testGetTipo() {
		assertEquals(this.restaurante.getTipo(),"RESTAURANTE");
	}


}
