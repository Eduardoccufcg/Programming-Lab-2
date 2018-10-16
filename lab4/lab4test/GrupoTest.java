package lab4test;
import lab4.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Respons�vel pelo teste da classe Grupo.
 *
 * @author Eduardo - 117210342
 *
 */
public class GrupoTest {

	/**
	 * Representa um grupo que vai ser usado no teste.
	 */
	private Grupo g1;

	/**
	 * Representa um grupo que vai ser usado no teste.
	 */
	private Grupo g2;

	/**
	 * Representa um aluno que vai ser usado no teste.
	 */
	private Aluno aluno1;

	/**
	 * Representa um aluno que vai ser usado no teste.
	 */
	private Aluno aluno2;

	/**
	 * Instancia um grupo e alunos antes de realizar um teste.
	 */
	@Before
	public void criaGrupoAlunos() {
		g1 = new Grupo("Slack");
		aluno1 = new Aluno("117210342", "EDUARDO PEREIRA", "CI�NCIA DA COMPUTA��O");
		aluno2 = new Aluno("112255", "LEIDIANE PEREIRA", "FISIOTERAPIA");
	}

	/**
	 * Testa construir um grupo com o nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstroiGrupoMatriculaVazia() {
		g1 = new Grupo("");

	}

	/**
	 * Testa construir um grupo com o nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testConstroiGrupoMatriculaNula() {

		g1 = new Grupo(null);

	}

	/**
	 * Testa alocar um aluno em um grupo.
	 */
	@Test
	public void testAlocaAluno() {
		assertTrue(g1.alocaAluno(aluno1));
	}

	/**
	 * Testa alocar um aluno nulo em um grupo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAlocaAlunoNulo() {
		g1.alocaAluno(null);
	}

	/**
	 * Testa o toString da classe Grupo.
	 */
	@Test
	public void testToString() {
		g1.alocaAluno(aluno1);
		g1.alocaAluno(aluno2);
		String res = g1.toString();
		assertEquals(res,
				"Alunos do grupo Slack:" + System.lineSeparator()
						+ "* 117210342 - EDUARDO PEREIRA - CI�NCIA DA COMPUTA��O" + System.lineSeparator()
						+ "* 112255 - LEIDIANE PEREIRA - FISIOTERAPIA" + System.lineSeparator());
	}

	/**
	 * Testa o toString da classe Grupo para um grupo sem nenhum aluno.
	 */
	@Test
	public void testToStringSemAlunos() {

		String res = g1.toString();
		assertEquals(res, "Alunos do grupo Slack:" + System.lineSeparator());
	}

	/**
	 * Testa se dois grupos s�o iguais(mesmo nome).
	 */
	@Test
	public void testEqualsTrue() {
		g2 = new Grupo("Slack");
		assertTrue(g1.equals(g2));
	}

	/**
	 * Testa se dois grupos s�o diferentes(nomes diferentes).
	 */
	@Test
	public void testEqualsFalse() {
		g2 = new Grupo("P2");
		assertFalse(g1.equals(g2));
	}

	/**
	 * Testa Equals com grupo nulo.
	 */
	@Test
	public void testEqualsNull() {
		g2 = null;
		assertFalse(g1.equals(g2));

	}

	/**
	 * Testa equals com dois grupos com o mesmo nome, mas com diferen�as entre
	 * letras mai�sculas e min�sculas.
	 */
	@Test
	public void testEqualsGrupoMesmoNome() {
		g2 = new Grupo("SlACk");
		assertTrue(g1.equals(g2));

	}

	/**
	 * Testa o hashCode de dois grupos com o mesmo nome.
	 */
	@Test
	public void testHashcode() {
		g1 = new Grupo("SLACK");
		g2 = new Grupo("SLACK");
		assertTrue(g1.hashCode() == g2.hashCode());
	}

	/**
	 * Testa o hashCode de dois grupos com o mesmo nome, mas
	 * com diferen�as entre letras mai�sculas e min�sculas.
	 */
	@Test
	public void testHashcodeNomesIguaisDiferencasLetras() {
		g1 = new Grupo("SLACK");
		g2 = new Grupo("slack");
		assertTrue(g1.hashCode() == g2.hashCode());
	}

}