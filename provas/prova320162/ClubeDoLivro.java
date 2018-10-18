package prova320162;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.Map;

public class ClubeDoLivro {

	private Map<String, Livro> livros;

	public ClubeDoLivro() {
		this.livros = new HashMap<>();

	}

	public void adicionaLivro(String titulo, String autor, String ano, String isbn) throws Exception {
		Livro livro = new Livro(titulo, autor, ano, isbn);

		if (!this.livros.containsKey(isbn)) {
			this.livros.put(isbn, livro);
		} else {
			throw new IllegalArgumentException("Livro ja pertence ao acervo.");
		}

	}

	/**
	 * Importa dados de um arquivo csv
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 */
	public void importaLivros(String file) throws FileNotFoundException {

		FileReader reader;
		LineNumberReader linha;

		try {

			reader = new FileReader(file);
			linha = new LineNumberReader(reader);

			while (linha.ready()) {
				String[] dados = linha.readLine().split(", ");
				Livro livro = new Livro(dados[0], dados[1], dados[2], dados[3]);
				this.livros.put(livro.getIsbn(), livro);

			}

		} catch (IOException e) {
			System.out.println("Erro");
		}

	}

	public String buscaLivro(String isbn) throws Exception {
		
		if(this.livros.containsKey(isbn)) {
			return this.livros.get(isbn).toString();
		}else{
			throw new NullPointerException("O livro nao esta no nosso acervo");
		}

	}

	public void armazenaDados() throws IOException {
		ObjectOutputStream gravaObject;

		try {
			gravaObject = new ObjectOutputStream(new FileOutputStream("provas" + File.separator+ "prova320162" + File.separator + "dados.txt"));
			gravaObject.writeObject(this.livros);
			gravaObject.close();

		} catch (IOException e) {
			throw new IOException("Problem!");

		}

	}

	public void carregaDados() throws ClassNotFoundException, IOException {
		ObjectInputStream a;
		FileInputStream b;

		try {
			b = new FileInputStream("provas" + File.separator + "dados.txt");
			a = new ObjectInputStream(b);
			Object obj = a.readObject();
			Map<String, Livro> livros = (HashMap<String, Livro>) obj;
			this.livros = livros;
			a.close();

		} catch (IOException e) {
			throw new IOException("Problem!");

		}
	}

	public void adicionaOpiniao(String isbn, int nota, String autor, String comentario) throws Exception {
		this.livros.get(isbn).adicionaOpiniao(nota, autor, comentario);

	}

	public double getNotaGeral(String isbn) throws Exception {
		return this.livros.get(isbn).getNotaGeral();
	}

	public String listaOpinioes(String isbn) throws Exception {
		return this.livros.get(isbn).listaOpinioes();

	}

	@SuppressWarnings("unchecked")
	public String ranking(int n) throws Exception {
		String lista = "";
		if(n > livros.size()) {
			throw new IllegalArgumentException("Nao ha livros suficientes no acervo");
		}
		ArrayList <Livro> livros = new ArrayList<>(this.livros.values());
		Collections.sort(livros);
		for(int  i = 0; i < n; i++ ) {
			lista += livros.get(i).toString() + " " +  livros.get(i).getQtdOpinioes() + System.lineSeparator();
			
			
		}
		return lista;
	}

}
