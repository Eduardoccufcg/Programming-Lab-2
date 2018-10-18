package prova320162;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Livro implements Serializable, Comparable<Livro>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String autor;
	private String ano;
	private String isbn;
	private Avaliacao avaliacao;
	
	
	private List<Opiniao> opinioes;

	public Livro(String titulo, String autor, String ano, String isbn) {
		this.opinioes = new ArrayList<>();
		this.avaliacao = new AvaliacaoSimplificada();
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void adicionaOpiniao(int nota, String autor, String comentario) throws Exception {
		Opiniao opiniao = new Opiniao(autor, nota, comentario);
		this.opinioes.add(opiniao);
		alteraAvaliacao(getQtdOpinioes());
	}
	

	public String listaOpinioes() throws Exception {
		String lista = "Opinioes:" + System.lineSeparator();
		for(Opiniao opiniao : this.opinioes){
			lista += opiniao.toString() + System.lineSeparator();
			
		}
		return lista;
	
	}
	public int getQtdOpinioes() {
		return this.opinioes.size();
	}
	
	public double getNotaGeral() {
		return this.avaliacao.getNotaGeral(opinioes);
		
	}
	private void alteraAvaliacao(int n) {
		if(n >= 5) {
			this.avaliacao = new AvaliacaoDetalhada();
			
		}
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public String getIsbn() {
		return this.isbn;
	}

	@Override
	public String toString() {
		return this.titulo + " " + "(ISBN " + this.isbn + "), " + this.ano + "." + System.lineSeparator() + this.autor;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (isbn != other.isbn)
			return false;
		return true;
	}

	@Override
	public int compareTo(Livro livro) {
		if(this.getQtdOpinioes() < livro.getQtdOpinioes()) {
			return 1;
		}
		if(this.getQtdOpinioes() > livro.getQtdOpinioes()) {
			return -1;
		}
		return 0;
	}

}
