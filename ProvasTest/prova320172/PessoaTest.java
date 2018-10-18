package prova320172;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PessoaTest {

	private Pessoa pessoa;

	@Before
	public void inicializa() {
		this.pessoa = new Pessoa("Eduardo", 10, 10, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaPessoaNomeVazio() {
		this.pessoa = new Pessoa("", 5, 5, 5);

	}

	@Test(expected = NullPointerException.class)
	public void testCriaPessoaNomeNulo() {
		this.pessoa = new Pessoa(null, 5, 5, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaPessoaAutoestimaMenorQueZero() {
		this.pessoa = new Pessoa("EDUARDO", -5, 5, 5);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaPessoaEmpatiaMenorQueZero() {
		this.pessoa = new Pessoa("EDUARDO", 5, -5, 5);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaPessoaExperienciaMenorQueZero() {
		this.pessoa = new Pessoa("EDUARDO", 5, 5, -5);

	}

	@Test
	public void testToString() {
		assertEquals(this.pessoa.toString(), "Eduardo - 10 - 10 - 10");
	}

	@Test
	public void testAtivarHabilidadePessoal() {
		this.pessoa.AtivarHabilidade("pessoal");
		assertEquals(this.pessoa.getNivelHabilidade(), 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtivarHabilidadeVazia() {
		this.pessoa.AtivarHabilidade("");

	}

	@Test(expected = NullPointerException.class)
	public void testAtivarHabilidadeNula() {
		this.pessoa.AtivarHabilidade(null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtivarHabilidadeNaoExiste() {
		this.pessoa.AtivarHabilidade("Superprofissional");

	}

	@Test
	public void testAtivarHabilidadeInterPessoal() {
		this.pessoa.AtivarHabilidade("interpessoal");
		assertEquals(this.pessoa.getNivelHabilidade(), 8);
	}

	@Test
	public void testAtivarHabilidadeProfisional() {
		this.pessoa.AtivarHabilidade("profissional");
		assertEquals(this.pessoa.getNivelHabilidade(), 1);
	}

	@Test
	public void testAtivarHabilidadeProfisionalExperienciaMenor7() {
		this.pessoa = new Pessoa("Eduardo", 6, 6, 6);
		this.pessoa.AtivarHabilidade("profissional");
		assertEquals(this.pessoa.getNivelHabilidade(), 0);
	}

	@Test
	public void testResolverProblemaHabilidadePessoal() {
		this.pessoa.AtivarHabilidade("pessoal");
		this.pessoa.resolverProblema(7);
		this.pessoa.resolverProblema(8);
		this.pessoa.resolverProblema(6);
		this.pessoa.resolverProblema(5);
		assertEquals(this.pessoa.getProblemasResolvidos(), 3);
	}

	@Test
	public void testResolverProblemaHabilidadeIntepessoal() {
		this.pessoa.AtivarHabilidade("interpessoal");
		this.pessoa.resolverProblema(7);
		this.pessoa.resolverProblema(8);
		this.pessoa.resolverProblema(6);
		this.pessoa.resolverProblema(5);
		assertEquals(this.pessoa.getProblemasResolvidos(), 4);
	}

	@Test
	public void testResolverProblemaHabilidadeProfissional() {
		this.pessoa.AtivarHabilidade("profissional");
		this.pessoa.resolverProblema(7);
		this.pessoa.resolverProblema(8);
		this.pessoa.resolverProblema(6);
		this.pessoa.resolverProblema(5);
		assertEquals(this.pessoa.getProblemasResolvidos(), 0);
	}

	@Test
	public void testResolverProblemaHabilidadeProfissionalExperienciaMenor7() {
		this.pessoa = new Pessoa("Eduardo", 6, 6, 6);
		this.pessoa.AtivarHabilidade("profissional");
		this.pessoa.resolverProblema(7);
		this.pessoa.resolverProblema(8);
		this.pessoa.resolverProblema(6);
		this.pessoa.resolverProblema(5);
		assertEquals(this.pessoa.getProblemasResolvidos(), 0);
	}

	@Test
	public void testGetNome() {
		assertEquals(this.pessoa.getNome(), "Eduardo");
	}

}
