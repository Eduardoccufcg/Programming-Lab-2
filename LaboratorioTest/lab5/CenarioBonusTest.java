package lab5;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CenarioBonusTest {
	
	CenarioBonus cenario;

	@Before
	public void criaCenarioBonus() {
		this.cenario = new CenarioBonus("Hoje Vai Chover", 1, 1000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstroiCenarioBonusDescricaoVazia() {
		this.cenario = new CenarioBonus("",1,1000);
	}
	
	@Test(expected = NullPointerException.class)
	public void testConstroiCenarioBonusDescricaoNula() {
		this.cenario = new CenarioBonus(null,1,1000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstroiCenarioBonusComBonusNegativo() {
		this.cenario = new CenarioBonus("Vou tirar 10",1,-2);
	}
	
	@Test 
	public void testToString() {
		assertEquals(this.cenario.toString(),"1 - Hoje Vai Chover - Nao finalizado - R$ 10,00");
		
		
	}
	@Test
	public void testGetBonus() {
		assertEquals(this.cenario.getBonus(),1000);
	}

	

}
