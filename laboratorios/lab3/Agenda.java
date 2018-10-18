package lab3;

/**
 * Respons�vel por gerenciar uma agenda com at� 100 contatos, com opera��es
 * de cadastrar, exibir e listar contatos.
 * 
 * @author Eduardo Pereira - 117210342
 */
public class Agenda {
	/**
	 * Array de contatos do tipo Contato.
	 */
    private Contato[] listadecontatos;
	
    /**
     * Constr�i uma agenda de contatos.
     */
    public Agenda() {
        this.listadecontatos = new Contato[100];	
    }

    /**
     * Retorna um booleano true caso o cadastro tenha sido realizado com sucesso, caso contr�rio retorna falso.
     * @param contato Objeto do tipo Contato
     * @param posicao Posicao do contato na agenda
     * 
     * @return um booleano true ou falso
     */
    public boolean cadastraContato(Contato contato,int posicao) {
        if(posicao < 1 || posicao > 100) {
            throw new ArrayIndexOutOfBoundsException("Posicao invalida") ;	
        }
        this.listadecontatos[posicao-1] = contato;
        return true;
    }

    /**
     * Retorna uma representacao em String do contato selecionado.Segue o formato.
     * "nome sobrenome numero".
     * @param posicao Posicao do contato da agenda
     * @return o toString do contato selecionado
     */
    public String exibeContato(int posicao) {
	if(posicao < 1 || posicao > 100) {
		throw new ArrayIndexOutOfBoundsException("Posicao invalida") ;		
	}
	if (this.listadecontatos[posicao-1] == null){
		throw new NullPointerException("Contato nao cadastrado") ;
	}
	return this.listadecontatos[posicao-1].toString();
    }

    /**
     * Retorna uma representa��o em String de todos os contatos da agenda.Segue o formato
     * "posi�ao nome sobrenome".
     * @param posicao Posi��o do contato da agenda
     * @return String de todos os contatos da agenda
     */
    public String listaTodos() {
        String contatos = "";
        for(int i = 0; i< this.listadecontatos.length; i++) {
            if (this.listadecontatos[i] != null){
                contatos += i+1 + " - " + this.listadecontatos[i].getNome() + System.lineSeparator();
            }
        }
		
        return contatos;
		
		
    }
	

		



}