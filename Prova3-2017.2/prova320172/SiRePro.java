
package prova320172;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class SiRePro {

	private Map<String, Pessoa> pessoas;

	public SiRePro() {

		this.pessoas = new LinkedHashMap<>();
	}

	public void cadastrarPessoa(String nome, int autoestima, int empatia, int ep) throws IOException {
		this.pessoas.put(nome, new Pessoa(nome, autoestima, empatia, ep));
		armazenaNomes();
	}

	public String recuperarPessoa(String nome) {

		return this.pessoas.get(nome).toString();

	}

	public String listarPessoas() {
		String lista = "";

		for (Pessoa pessoa : this.pessoas.values()) {
			lista += pessoa.toString() + System.lineSeparator();
		}
		return lista;
	}

	public void ativarHabilidade(String nomePessoa, String hab) {
		this.pessoas.get(nomePessoa).AtivarHabilidade(hab);
	}

	public int getHabilidade(String nomePessoa) {
		return this.pessoas.get(nomePessoa).getNivelHabilidade();
	}

	public void resolverProblema(String nomePessoa, int nivelProblema) {
		this.pessoas.get(nomePessoa).resolverProblema(nivelProblema);
	}

	public int getProblemasResolvidos(String nomePessoa) {
		return this.pessoas.get(nomePessoa).getProblemasResolvidos();
	}

	public void armazenaNomes() throws IOException {

		FileWriter arq = new FileWriter("Prova3-2017.2" + File.separator + "dados.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		String lista = "";

		for (Pessoa pessoa : this.pessoas.values()) {
			lista += pessoa.getNome() + System.lineSeparator();
		}
		
		gravarArq.print(lista);
		arq.close();

	}

}
