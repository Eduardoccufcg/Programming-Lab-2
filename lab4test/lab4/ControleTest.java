package lab4;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

/**
 * Responsável pelo teste da classe Controle.
 *
 * @author Eduardo Pereira - 117210342
 */
public class ControleTest {

	/**
	 * Representa o controle que vai ser usado no teste
	 */
	Controle c1;

	/**
	 * Instancia o controle antes da realização do teste.
	 */
	@Before

	public void criaControle() {
		c1 = new Controle();

	}

	/**
	 * Testa cadastrar um aluno no controle.
	 */
	@Test
	public void testCadastraAluno() {
		assertTrue(c1.cadastraAluno("11", "EDUARDO", "CC"));
	}

	/**
	 * Testa cadastrar o mesmo aluno mais de uma vez.
	 */
	@Test
	public void testCadastraAlunoNovamente() {
		c1.cadastraAluno("11", "EDUARDO", "CC");
		assertFalse(c1.cadastraAluno("11", "EDUARDO", "CC"));
	}

	/**
	 * Testa cadastrar um aluno com matrícula vazia no controle.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoMatriculaVazia() {
		c1.cadastraAluno("", "EDUARDO", "CC");
	}

	/**
	 * Testa cadastrar um aluno com matrícula nula no controle.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoMatriculaNula() {
		c1.cadastraAluno(null, "EDUARDO", "CC");
	}

	/**
	 * Testa cadastrar um aluno com nome vazio no controle.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoNomeVazio() {
		c1.cadastraAluno("11", "", "CC");
	}

	/**
	 * Testa cadastrar um aluno com nome nulo no controle.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoNomeNulo() {
		c1.cadastraAluno("11", null, "CC");
	}

	/**
	 * Testa cadastrar um aluno com curso vazio no controle.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoCursoVazio() {
		c1.cadastraAluno("11", "EDUARDO", "");
	}

	/**
	 * Testa cadastrar um aluno com curso nulo no controle.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraAlunoCursoNulo() {
		c1.cadastraAluno("11", "EDUARDO", null);
	}

	/**
	 * Testa exibir um aluno.
	 */
	@Test
	public void testExibeAluno() {
		c1.cadastraAluno("11", "EDUARDO", "CC");
		assertEquals(c1.exibeAluno("11"), "Aluno: 11 - EDUARDO - CC" + System.lineSeparator());
	}

	/**
	 * Testa a exibir um aluno a partir de uma matrícula vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibeAlunoMatriculaVazia() {
		c1.exibeAluno("");
	}

	/**
	 * Testa a exibição de um aluno a partir de uma matrícula nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testExibeAlunoMatriculaNula() {
		c1.exibeAluno(null);
	}

	/**
	 * Testa a exibição de um aluno não cadastrado.
	 */
	@Test
	public void testExibeAlunoNaoCadastrado() {
		assertEquals(c1.exibeAluno("12"), "Aluno não cadastrado." + System.lineSeparator());
	}

	/**
	 * Testa cadastrar um grupo.
	 */
	@Test
	public void testCadastraGrupo() {
		assertTrue(c1.cadastraGrupo("P2"));
	}

	/**
	 * Testa cadastrar o mesmo grupo mais de uma vez.
	 */
	@Test
	public void testCadastraGrupoNovamente() {
		c1.cadastraGrupo("P2");
		assertFalse(c1.cadastraGrupo("P2"));
	}

	/**
	 * Testa cadastrar um grupo a partir de um nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraGrupoNomeVazio() {
		c1.cadastraGrupo("");
	}

	/**
	 * Testa cadastrar um grupo a partir de um nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastraGrupoNomeNulo() {
		c1.cadastraGrupo(null);
	}

	/**
	 * Testa alocar um aluno em um grupo.
	 */
	@Test
	public void testAlocaAlunoGrupo() {
		c1.cadastraAluno("11", "EDUARDO", "CC");
		c1.cadastraGrupo("P2");
		assertEquals(c1.alocaAlunoGrupo("11", "P2"), "ALUNO ALOCADO!" + System.lineSeparator());
	}

	/**
	 * Testa alocar um aluno não cadastrado em um grupo.
	 */
	@Test
	public void testAlocaAlunoEmGrupoNaoCadastrado() {
		c1.cadastraGrupo("P2");
		assertEquals(c1.alocaAlunoGrupo("11", "P2"), "Aluno não cadastrado." + System.lineSeparator());
	}

	/**
	 * 
	 * Testa alocar um aluno em um grupo não cadastrado.
	 */
	@Test
	public void testAlocaAlunoGrupoNaoCadastrado() {
		c1.cadastraAluno("11", "EDUARDO", "CC");
		assertEquals(c1.alocaAlunoGrupo("11", "P2"), "Grupo não cadastrado." + System.lineSeparator());
	}

	/**
	 * Testa alocar um aluno não cadastrado em um grupo não cadastrado.
	 */
	@Test
	public void testAlocaAlunoNaoCadastradoEmGrupoNaoCadastrado() {
		assertEquals(c1.alocaAlunoGrupo("11", "P2"),
				"Aluno não cadastrado." + System.lineSeparator() + "Grupo não cadastrado." + System.lineSeparator());
	}

	/**
	 * Testa alocar um aluno com matrícula vazia em um grupo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlocaAlunoGrupoMatriculaVazia() {
		c1.cadastraAluno("11", "EDUARDO", "CC");
		c1.cadastraGrupo("P2");
		c1.alocaAlunoGrupo("", "P2");
	}

	/**
	 * Testa alocar um aluno com matrícula nula em um grupo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAlocaAlunoGrupoMatriculaNula() {
		c1.cadastraAluno("11", "EDUARDO", "CC");
		c1.cadastraGrupo("P2");
		c1.alocaAlunoGrupo(null, "P2");
	}

	/**
	 * Testa alocar um aluno com nome vazio em um grupo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlocaAlunoGrupoNomeVazio() {
		c1.cadastraAluno("11", "EDUARDO", "CC");
		c1.cadastraGrupo("P2");
		c1.alocaAlunoGrupo("11", "");
	}

	/**
	 * Testa alocar um aluno com nome nulo em um grupo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAlocaAlunoGrupoNomeNulo() {
		c1.cadastraAluno("11", "EDUARDO", "CC");
		c1.cadastraGrupo("P2");
		c1.alocaAlunoGrupo("11", null);
	}

	/**
	 * Testa imprimir alunos de um grupo.
	 */
	@Test
	public void testImprimeGrupo() {
		c1.cadastraAluno("11", "EDUARDO", "CC");
		c1.cadastraAluno("12", "DUDU", "CC");
		c1.cadastraGrupo("P2");
		c1.alocaAlunoGrupo("11", "P2");
		c1.alocaAlunoGrupo("12", "P2");
		String res = c1.imprimeGrupo("P2");
		assertEquals(res, "Alunos do grupo P2:" + System.lineSeparator() + "* 12 - DUDU - CC" + System.lineSeparator()
				+ "* 11 - EDUARDO - CC" + System.lineSeparator());

	}

	/**
	 * Testa imprimir alunos de um grupo não cadastrado.
	 */
	@Test
	public void testImprimeGrupoNaoCadastrado() {
		String res = c1.imprimeGrupo("P2");
		assertEquals(res, "Grupo não cadastrado." + System.lineSeparator());

	}

	/**
	 * Testa imprimir alunos de um grupo sem alunos alocados.
	 */
	@Test
	public void testImprimeGrupoVazio() {
		c1.cadastraGrupo("P2");
		String res = c1.imprimeGrupo("P2");
		assertEquals(res, "Alunos do grupo P2:" + System.lineSeparator());

	}

	/**
	 * Testa imprimir alunos de um grupo a partir de um nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testImprimegrupoNomeVazio() {
		c1.imprimeGrupo("");
	}

	/**
	 * Testa imprimir alunos de um grupo a partir de um nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testImprimegrupoNomeNulo() {
		c1.imprimeGrupo(null);
	}

	/**
	 * Testa registrar um aluno que respondeu no quadro.
	 */
	@Test
	public void testRegistraAlunoRespondeu() {
		c1.cadastraAluno("11", "EDUARDO", "CC");
		assertTrue(c1.registraAlunoRespondeu("11"));

	}

	/**
	 * Testa registrar um aluno que respondeu no quadro a partir de um aluno não
	 * cadastrado no controle.
	 */
	@Test
	public void testRegistraAlunoRespondeuAlunoNaoCadastrado() {
		c1.cadastraAluno("11", "EDUARDO", "CC");
		assertFalse(c1.registraAlunoRespondeu("12"));

	}

	/**
	 * Testa registrar um aluno que respondeu no quadro a partir de uma matrícula
	 * vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRegistraAlunoRespondeuMatriculaVazia() {
		c1.registraAlunoRespondeu("");

	}

	/**
	 * Testa registrar um aluno que respondeu no quadro a partir de uma matrícula
	 * nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testRegistraAlunoRespondeuMatriculaNula() {
		c1.registraAlunoRespondeu(null);

	}

	/**
	 * Testa listar os alunos que responderam no quadro sem nenhum aluno registrado.
	 */
	@Test
	public void testListaAlunosRespoderam() {

		c1.cadastraAluno("11", "EDUARDO", "CC");
		c1.cadastraAluno("12", "DUDU", "CC");
		c1.registraAlunoRespondeu("11");
		c1.registraAlunoRespondeu("12");
		String res = c1.listaAlunosRespoderam();
		assertEquals(res,
				"1. 11 - EDUARDO - CC" + System.lineSeparator() + "2. 12 - DUDU - CC" + System.lineSeparator());

	}

	/**
	 * Testa listar os alunos que responderam no quadro sem nenhum aluno registrado.
	 */
	@Test
	public void testListaAlunosRespoderamSemAlunos() {

		String res = c1.listaAlunosRespoderam();
		assertEquals(res, "");

	}

}
