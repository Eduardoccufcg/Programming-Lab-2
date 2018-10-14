package prova3;

public class Opiniao {



	private String autorComentario;
	private int nota;
	private String comentario;
	private String recomenda;

	public Opiniao(String autorComentario, int nota, String comentario) {
		if(nota < 1 || nota > 5) {
			throw new IllegalArgumentException("Nota fora do intervalo de 1 a 5");
		}
		this.autorComentario = autorComentario;
		this.nota = nota;
		this.comentario = comentario;
		if(nota > 3){
			this.recomenda = "recomendou esse livro";
			
		}else {
			this.recomenda = "nao recomendou esse livro";
		}
	}

	@Override
	public String toString() {
		return this.autorComentario + " " + this.recomenda  + System.lineSeparator() + "Nota: " + this.nota + System.lineSeparator() + this.comentario;
	}

	public int getNota() {
		return nota;
	}
	
	

}
