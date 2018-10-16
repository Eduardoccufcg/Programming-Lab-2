package lab3test;
import lab3.*;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Respons�vel pelos testes da classe Contato
 * @author Eduardo Pereira - 117210342
 */
public class ContatoTest {
    private Contato contato;
        

    /**
     * Testa cadastrar contato com nome vazio.
     */
    @Test(expected = IllegalArgumentException.class)
	
    public void CriaContatoNomeVazio() {
        this.contato = new Contato("","PEREIRA","987599658");
		
    }

    /**
     * Testa cadastrar contato com sobrenome vazio.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCriaContatoSobrenomeVazio() {
        this.contato = new Contato("EDUARDO","","987599658");
    }

    /**
     * Testa cadastrar contato com telefone vazio.
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestCriaContatoTelefoneVazio() {
	this.contato = new Contato("EDUARDO","PEREIRA","");
    }
	
    /**
     * Testa cadastrar contato com nome formado apenas por espa�os.
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestCriaContatoNomeSoEspaco() {
        this.contato = new Contato("   ","PEREIRA","987599658");	
    }

    /**
     * Testa cadastrar contato com sobrenome formado apenas por espa�os.
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestCriaContatoSobrenomeSoEspaco() {
        this.contato = new Contato("EDUARDO","    ","987599658");
    }

    /**
     * Testa cadastrar contato com telefone formado apenas por espa�os.
     */
    @Test(expected = IllegalArgumentException.class)
	
    public void TestCriaContatoTelefoneSoEspaco() {
        this.contato = new Contato("EDUARDO","PEREIRA","    ");
    }

    /**
     * Testa o m�todo getNome da classe Contato.
     */
    @Test
    public void TestaGetNome() {
    	this.contato = new Contato("EDUARDO","PEREIRA","987599658");
        assertEquals(this.contato.getNome(),"EDUARDO PEREIRA");
		
    }

    /**
     * Testa o m�todo toString da classe Contato.
     */
    @Test
    public void TestaToString() {
    	this.contato = new Contato("EDUARDO","PEREIRA","987599658");
        assertEquals(this.contato.toString(),"EDUARDO PEREIRA - 987599658");
    }
    /**
     * Testa se dois contatos s�o iguais(tem o mesmo nome).
     */
    @Test
    public void TestaEqualsTrue() {
    	contato = new Contato("Eduardo", "Pereira", "987599658");
		Contato contato1 = new Contato("Eduardo", "Pereira", "987599658");
		assertTrue(contato.equals(contato1));
    }
    /**
     * Testa se dois contatos s�o diferentes(nomes diferentes).
     */
    @Test
    public void TestaEqualsFalse() {
    	contato = new Contato("Eduardo", "Pereira", "987599658");
		Contato contato1 = new Contato("Edvaldo", "Pereira", "987599658");
		assertFalse(contato.equals(contato1));
    }


}
