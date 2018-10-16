package prova1test;
import prova1.Candidato;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CandidatoTest {
	Candidato lola;
	Candidato bolsanaro;
	@Before
	public void Criacandidato() {
		lola = new Candidato("Lola" ,"PJ", 10 );
		bolsanaro = new Candidato("Bolsanaro" ,"PKM", 11 );
	}
	@Test
	public void testatoString() {
		assertEquals(lola.toString(), "Lola - PJ - 10");
		
	}
	@Test
	public void testasetNome() {
		lola.setNome("Lole");
		assertEquals(lola.getNome(),"Lole");
	}
	@Test
	public void testagetNome(){
		assertEquals(lola.getNome(), "Lola");
		
	}
	@Test
	public void testgetTotalVotos() {
		assertEquals(lola.getTotalVotos(),0);
	}
	@Test
	public void testaadicionaVoto() {
		lola.adicionaVoto();
		assertEquals(lola.getTotalVotos(),1);
		
	}
	@Test
	public void testapuracaoCandidato() {
		assertEquals(lola.apuracaoCandidato(),"10 - 0 votos");
	}
	@Test
	public void testaEqualsTrue(){
		lola = new Candidato("Lola" ,"PJ", 10 );
		bolsanaro = new Candidato("Bolsanaro" ,"PKM", 10 );
		assertTrue(lola.equals(bolsanaro));
	}
	@Test
	public void testaEqualsFalse() {
		lola = new Candidato("Lola" ,"PJ", 10 );
		bolsanaro = new Candidato("Bolsanaro" ,"PKM", 11 );
		assertFalse(lola.equals(bolsanaro));
		
	}
}
