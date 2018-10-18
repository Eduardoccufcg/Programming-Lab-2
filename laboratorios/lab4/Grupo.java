package lab4;

import java.util.HashSet;

/**
 * Respons�vel por representar um grupo no controle. Todo grupo tem um nome.
 *
 * @author Eduardo Pereira - 117210342
 */
public class Grupo {

    /**
     * Conjunto de alunos que comp�em o grupo.
     */
    private HashSet<Aluno> alunosDoGrupo;
    /**
     * Nome do grupo.
     */
    private String nome;

    /**
     * Constr�i um grupo a partir de seu nome. Com tratamento de exce��es.
     *
     * @param nome Nome do grupo
     *
     */
    public Grupo(String nome) {

        if (nome == null) {
            throw new NullPointerException("Nome nulo");
        } else if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inv�lido");
        }

        this.nome = nome;
        this.alunosDoGrupo = new HashSet<>();
    }

    /**
     * Gera uma representa��o n�merica do objeto.
     *
     * @return um inteiro
     */ 
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.toLowerCase().hashCode());
		return result;
	}
    
    /**
     * Retorna um tipo booleano true caso dois objetos tiverem o mesmo nome,
     * caso contr�rio false.
     *
     * @param obj Objeto a ser testado
     *
     * @return um booleano falso ou verdadeiro
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Grupo))
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.toLowerCase().equals(other.nome.toLowerCase()))
			return false;
		return true;
	}

    /**
     *
     * Aloca um aluno no grupo.Caso ele seja alocado � retornado true, caso
     * contr�rio false.
     *
     * @param aluno Aluno a ser alocado
     *
     * @return um boleano false ou verdadeiro
     */
    public boolean alocaAluno(Aluno aluno) {
        if (aluno == null) {
            throw new NullPointerException("Aluno inv�lido");
        }
        return this.alunosDoGrupo.add(aluno);
    }

    /**
     * Gera uma representa��o em String dos alunos que comp�em o grupo.No
     * formato: "* matr�cula - nome - curso"
     *
     * @return a lista de alunos de um grupo.
     */
    @Override
    public String toString() {
        String lista = "Alunos do grupo " + this.nome + ":" + System.lineSeparator();
        for (Aluno aluno : alunosDoGrupo) {
            lista += "* " + aluno.toString() + System.lineSeparator();
        }
        return lista;

    }

}
