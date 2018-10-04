package lab3;

/**
 * Respons�vel por representar um contato. Todo contato possui
 * nome, sobrenome e numero. 
 * 
 * @author Eduardo Pereira - 117210342
 */
public class Contato {
	
	/**
	 * Nome do contato.
	 */
    private String nome;
    
    /**
     * Sobrenome do contato.
     */
    private String sobrenome;
    
    /**
     * N�mero do contato.
     */
    private String numero;
	
    /**
     * Constr�i um contato com tratamentos de exce��es.
     * @param nome Nome do contato
     * @param sobrenome Sobrenome do contato
     * @param numero N�mero do telefone
     */
    public Contato(String nome,String sobrenome, String numero){
        if(nome.trim().equals("")) {
            throw new  IllegalArgumentException("Nome Inv�lido");
        }
        if(sobrenome.trim().equals("")){
            throw new  IllegalArgumentException("Sobrenome Inv�lido");
        }
        if (numero.trim().equals("")) {
            throw new  IllegalArgumentException("N�mero Inv�lido");
        }
		
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
	
    }

    /**
     * Retorna uma representa��o em String do contato. Segue o formato.
     * "nome sobrenome numero"
     * 
     * @return a reprenta��o em String do contato
     */
    @Override
    public String toString() {
    	
        return this.nome + " " +this.sobrenome + " - " + this.numero;
		
    }
    /**
     * Retorna uma representa��o num�rica do objeto.
     * 
     * @return um inteiro
     */
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
    /**
     * Retorna um tipo booleano true caso dois objetos tiverem o mesmo nome, caso contr�rio false.
     * 
     * @return um booleano falso ou verdadeiro
     */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Contato))
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
     * Retorna uma representa��o em String do nome e sobrenome do contato. Segue o formato.
     * "nome sobrenome"
     * 
     * @return representa��o em String do nome e sobrenome do contato
     */
    public String getNome(){
        return this.nome + " " + this.sobrenome;
    }
	
    
}