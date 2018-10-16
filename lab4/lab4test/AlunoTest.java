package lab4test;
import lab4.*;
import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

/**
 * Respons�vel pelos testes da classe Aluno.
 *
 * @author Eduardo - 117210342
 *
 */
public class AlunoTest {

	/**
	 * Representa um aluno que vai ser usado no teste.
	 */
	private Aluno aluno1;

	/**
	 * Representa um aluno que vai ser usado no teste.
	 */
	private Aluno aluno2;

	/**
	 * Representa um aluno que vai ser usado no teste.
	 */
	private Aluno aluno3;

	/**
	 * Instancia os alunos do tipo Aluno antes de ocorrer o teste.
	 */
	@Before
	public void criaAluno() {

		aluno1 = new Aluno("117210342", "EDUARDO PEREIRA", "CI�NCIA DA COMPUTA��O");
		aluno2 = new Aluno("112255", "LEIDIANE PEREIRA", "FISIOTERAPIA");
		aluno3 = new Aluno("117210342", "EDUARDO SANTOS", "CI�NCIA DA COMPUTA��O");
	}

	/**
	 * Testa construir um aluno com a matr�cula vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstroiAlunoMatriculaVazia() {

		aluno1 = new Aluno("", "EDUARDO PEREIRA", "CI�NCIA DA COMPUTA��O");

	}

	/**
	 * Testa construir um aluno com a matr�cula nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testConstroiAlunoMatriculaNula() {

		aluno1 = new Aluno(null, "EDUARDO PEREIRA", "CI�NCIA DA COMPUTA��O");

	}

	/**
	 * Testa construir um aluno com o nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstroiAlunoNomeVazio() {

		aluno1 = new Aluno("117210342", "", "CI�NCIA DA COMPUTA��O");

	}

	/**
	 * Testa construir um aluno com o nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testConstroiAlunoNomeNulo() {

		aluno1 = new Aluno("117210342", null, "CI�NCIA DA COMPUTA��O");

	}

	/**
	 * Testa construir um aluno com o curso vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstroiAlunoCursoVazio() {

		aluno1 = new Aluno("117210342", "EDUARDO PEREIRA", "");

	}

	/**
	 * Testa construir um aluno com o curso nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testConstroiAlunoCursoNulo() {

		aluno1 = new Aluno("117210342", "EDUARDO PEREIRA", null);

	}

	/**
	 * Testa se dois alunos s�o diferentes(matr�culas diferentes).
	 */
	@Test
	public void testEqualsFalse() {
		assertFalse(aluno1.equals(aluno2));
	}

	/**
	 * Testa se dois alunos s�o iguais(matr�culas iguais).
	 */
	@Test
	public void testEqualsTrue() {
		assertTrue(aluno1.equals(aluno3));
	}

	/**
	 * Testa o Equals com o aluno nulo.
	 */
	@Test
	public void testEqualsNulo() {
		aluno1 = null;
		assertFalse(aluno3.equals(aluno1));
	}

	/**
	 * Testa o hashCode de dois alunos com a mesma matr�cula.
	 */
	@Test
	public void testHashcode() {
		aluno2 = new Aluno("117210342", "EDUARDO PEREIRA", "CI�NCIA DA COMPUTA��O");
		assertTrue(aluno1.hashCode() == aluno2.hashCode());
	}

	/**
	 * Testa o met�do toString da classe Aluno.
	 */
	@Test
	public void testToString() {
		assertEquals(aluno1.toString(), "117210342 - EDUARDO PEREIRA - CI�NCIA DA COMPUTA��O");
	}

}
