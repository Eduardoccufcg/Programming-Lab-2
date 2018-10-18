package prova320172;


import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class SiReProTest {

	private SiRePro sirepro;

	@Before
	public void inicializa() throws IOException {
		sirepro = new SiRePro();
		sirepro.cadastrarPessoa("Eduardo", 10, 10, 10);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraPessoaNomeVazio() throws IOException {
		this.sirepro.cadastrarPessoa("", 10, 10, 10);

	}

	@Test(expected = NullPointerException.class)
	public void testCadastraPessoaNomeNulo() throws IOException {
		this.sirepro.cadastrarPessoa(null, 5, 5, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraPessoaAutoestimaMenorQueZero() throws IOException {
		this.sirepro.cadastrarPessoa("EDUARDO", -5, 5, 5);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraPessoaEmpatiaMenorQueZero() throws IOException {
		this.sirepro.cadastrarPessoa("EDUARDO", 5, -5, 5);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastraPessoaExperienciaMenorQueZero() throws IOException {
		this.sirepro.cadastrarPessoa("EDUARDO", 5, 5, -5);

	}

	@Test
	public void testRecuperarPessoa() {
		assertEquals(this.sirepro.recuperarPessoa("Eduardo"), "Eduardo - 10 - 10 - 10");

	}

	@Test
	public void testAtivarHabilidadePessoal() {
		this.sirepro.ativarHabilidade("Eduardo", "pessoal");
		assertEquals(this.sirepro.getHabilidade("Eduardo"), 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtivarHabilidadeVazia() {
		this.sirepro.ativarHabilidade("Eduardo", "");

	}

	@Test(expected = NullPointerException.class)
	public void testAtivarHabilidadeNula() {
		this.sirepro.ativarHabilidade(null, "pessoal");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtivarHabilidadeNaoExiste() {
		this.sirepro.ativarHabilidade("Eduardo", "Superpessoal");

	}

	@Test
	public void testAtivarHabilidadeInterPessoal() {

		this.sirepro.ativarHabilidade("Eduardo", "interpessoal");
		assertEquals(this.sirepro.getHabilidade("Eduardo"), 8);
	}

	@Test
	public void testAtivarHabilidadeProfissional() {

		this.sirepro.ativarHabilidade("Eduardo", "profissional");
		assertEquals(this.sirepro.getHabilidade("Eduardo"), 1);
	}

	@Test
	public void testAtivarHabilidadeProfisionalExperienciaMenor7() throws IOException {
		this.sirepro.cadastrarPessoa("Eduardo", 6, 6, 6);
		this.sirepro.ativarHabilidade("Eduardo", "profissional");
		assertEquals(this.sirepro.getHabilidade("Eduardo"), 0);

	}

	@Test
	public void testResolverProblemaHabilidadePessoal() {
		this.sirepro.ativarHabilidade("Eduardo", "pessoal");
		this.sirepro.resolverProblema("Eduardo", 7);
		this.sirepro.resolverProblema("Eduardo", 8);
		this.sirepro.resolverProblema("Eduardo", 6);
		this.sirepro.resolverProblema("Eduardo", 5);
		assertEquals(this.sirepro.getProblemasResolvidos("Eduardo"), 3);
	}

	@Test
	public void testResolverProblemaHabilidadeInterpessoal() {
		this.sirepro.ativarHabilidade("Eduardo", "interpessoal");
		this.sirepro.resolverProblema("Eduardo", 7);
		this.sirepro.resolverProblema("Eduardo", 8);
		this.sirepro.resolverProblema("Eduardo", 6);
		this.sirepro.resolverProblema("Eduardo", 5);
		assertEquals(this.sirepro.getProblemasResolvidos("Eduardo"), 4);

	}

	@Test
	public void testResolverProblemaHabilidadeProfissional() {
		this.sirepro.ativarHabilidade("Eduardo", "profissional");
		this.sirepro.resolverProblema("Eduardo", 7);
		this.sirepro.resolverProblema("Eduardo", 8);
		this.sirepro.resolverProblema("Eduardo", 6);
		this.sirepro.resolverProblema("Eduardo", 5);
		assertEquals(this.sirepro.getProblemasResolvidos("Eduardo"), 0);
	}

	@Test
	public void testResolverProblemaHabilidadeProfissionalExperienciaMenor7() throws IOException {
		this.sirepro.cadastrarPessoa("Eduardo", 6, 6, 6);
		this.sirepro.ativarHabilidade("Eduardo", "profissional");
		this.sirepro.resolverProblema("Eduardo", 7);
		this.sirepro.resolverProblema("Eduardo", 8);
		this.sirepro.resolverProblema("Eduardo", 6);
		this.sirepro.resolverProblema("Eduardo", 5);
		assertEquals(this.sirepro.getProblemasResolvidos("Eduardo"), 0);
	}

}
