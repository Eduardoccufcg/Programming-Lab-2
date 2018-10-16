package prova2test;
import prova2.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CrTest {

	private Cr cr;

	@Before
	public void test() {
		cr = new Cr(1, 10);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCriaCrNumeroFolhasNegativas() {
		cr = new Cr(1,-1);
	}
	@Test
	public void testToString() {
		assertEquals(this.cr.toString(),"1 - 10 folhas(s)");
	}
	@Test
	public void testRetornaCusto() {
		assertEquals(this.cr.retornaCusto(),10);
	}

}
