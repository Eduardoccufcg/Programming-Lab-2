package lab3;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Eduardo Pereira -117210342
 */
public class AgendaTest {
    Agenda  agenda;
    
    Contato contato1,contato2,contato3,contato4;
    
    /**
     * Constr�i uma agenda para servir de base para os testes
     */
    @Before
    public void criaAgenda() {
        agenda = new Agenda();
        this.contato1 = new Contato("EDUARDO","PEREIRA","987599658");
        this.contato2 = new Contato("DUDU","P","5454545787");
        this.contato3 = new Contato("PEREIRA","EDUARDO","987499658");
        this.contato4 = new Contato("EDUARDO","SANTOS","987599658");
    }
	
    /**
     * Testa cadastrar contato na posi��o m�nima(1).
     */
    @Test
    public void testaCadastraContatoPosicaoMinima(){
        assertEquals(agenda.cadastraContato(contato1, 1),true);

    }

    /**
     * Testa cadastrar contato na posi��o limite(100).
     */
    @Test
    public void testaCadastraContatoPosicaoLimite(){
        assertEquals(agenda.cadastraContato(contato1, 100),true);
		
    }

    /**
     * Testa cadastrar contato em uma posi��o acima do limite. 
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testaCadastraContatoPosicaoAcimaLimite(){
        agenda.cadastraContato(contato1, 101);
		
    }

    /**
     * Testa cadastrar contato em uma posi��o abaixo da posi��o m�nima. 
     */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testaCadastraContatoPosicaoAbaixoMinima(){
        agenda.cadastraContato(contato1, 0);
    }

    /**
     * Testa exibir contato que se encontra na posi��o m�nima.
     */
    @Test
    public void testaExibeContatoPosicaoMinima() {
        agenda.cadastraContato(contato1, 1);
        assertEquals(agenda.exibeContato(1),"EDUARDO PEREIRA - 987599658");
    }
 
    /**
     * Testa exibir contato que se encontra na posi��o Limite.
     */
    @Test 
    public void testaExibeContatoPosicaoLimite() {
        agenda.cadastraContato(contato1, 100);
        assertEquals(agenda.exibeContato(100),"EDUARDO PEREIRA - 987599658");
    }

    /**
     * Testa exibir contato que n�o existe, est� abaixo da posi��o m�nima
     */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testaExibeContatoPosicaoAbaixoMinima() {
        agenda.exibeContato(0);
	
    }

    /**
     * Testa exibir contato que n�o existe, est� acima do limite.
     */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testaExibeContatoPosicaoAcimaLimite() {
        agenda.exibeContato(101);

    }

    /**
     * Testa listar todos os contatos da agenda.
     */
    @Test
    public void testalistaTodos(){
        agenda.cadastraContato(contato1, 1);
        agenda.cadastraContato(contato2, 2);
        String resultado = "1 - EDUARDO PEREIRA" + System.lineSeparator() + "2 - DUDU P" + System.lineSeparator();
        assertEquals(agenda.listaTodos(),resultado);
    }

}
