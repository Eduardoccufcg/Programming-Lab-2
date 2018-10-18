package prova320162;



public class Main {

	public static void main(String[] args) throws Exception {
		ClubeDoLivro livros = new ClubeDoLivro();
		livros.adicionaLivro("AA", "GG", "1980","444");
		livros.adicionaLivro("AAF", "GG", "1981","445");
		livros.adicionaLivro("AAQ", "GG", "1982","446");
		livros.adicionaLivro("AAH", "GG", "1983","447");
		livros.adicionaOpiniao("447",4, "Eduardo", "Massa");
		livros.adicionaOpiniao("447",5, "Eduardo", "Massa");
		livros.adicionaOpiniao("447",3, "Eduardo", "Massa");
		livros.adicionaOpiniao("447",5, "Eduardo", "Massa");
		livros.adicionaOpiniao("447",5, "Eduardo", "Massa");
		System.out.println(livros.getNotaGeral("447"));
		System.out.println(livros.listaOpinioes("447"));
		
		livros.adicionaOpiniao("444",5, "Eduardo", "Massa");
		livros.adicionaOpiniao("444",5, "Eduardo", "Massa");
		livros.adicionaOpiniao("444",5, "Eduardo", "Massa");
		
		livros.adicionaOpiniao("446",5, "Eduardo", "Massa");
		livros.adicionaOpiniao("446",5, "Eduardo", "Massa");
		
		livros.adicionaOpiniao("445",5, "Eduardo", "Massa");
		
		
		
		
		
		System.out.println(livros.ranking(4));
		
		
	}

}
