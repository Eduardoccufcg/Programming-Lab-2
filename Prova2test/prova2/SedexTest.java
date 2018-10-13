package prova2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SedexTest {

	private Sedex sedex;

	@Before
	public void test() {
		sedex = new Sedex(1, 1,1);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCriaSedexPesoNegativo() {
		sedex = new Sedex(1,-1,1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriaSedexVolumeNegativo() {
		sedex = new Sedex(1,1,-1);
	}
	

	
	@Test
	public void testToString() {
		assertEquals(this.sedex.toString(),"1 - 1 kg 1 m3");
	}
	@Test
	public void testRetornaCusto() {
		assertEquals(this.sedex.retornaCusto(),222);
	}
}
