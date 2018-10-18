package prova2;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PacTest {
	
	private Pac pac;

	@Before
	public void test() {
		pac = new Pac(10, 1);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCriaPacPesoNegativo() {
		pac = new Pac(-20,1);
	}
	@Test
	public void testToString() {
		assertEquals(this.pac.toString(),"1 - 10 kg");
	}
	@Test
	public void testRetornaCusto() {
		assertEquals(this.pac.retornaCusto(),120);
	}
	

}
