package lab4;

/**
 * Respons�vel por representar um aluno no controle. Todo aluno tem matr�cula,
 * nome e curso.
 *
 * @author Eduardo Pereira - 117210342
 */
public class Aluno {

    /**
     * Matr�cula do aluno.
     */
    private String matricula;

    /**
     * Curso do aluno.
     */
    private String curso;

    /**
     * Nome do aluno.
     */
    private String nome;

    /**
     * Constr�i um aluno a partir de sua matr�cula, nome e curso. Com
     * tratamentos de exce��es.
     *
     * @param matricula Matr�cula do aluno
     *
     *
     * @param nome Nome do aluno
     *
     *
     * @param curso Curso do aluno
     *
     *
     */
    public Aluno(String matricula, String nome, String curso) {

        if (matricula == null) {
            throw new NullPointerException("Matr�cula nula");
        } else if (nome == null) {

            throw new NullPointerException("Nome nulo");
        } else if (curso == null) {

            throw new NullPointerException("Curso nulo");
        }

        if (matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("Matr�cula inv�lida");

        } else if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inv�lido");

        } else if (curso.trim().isEmpty()) {
            throw new IllegalArgumentException("Curso inv�lido");
        }

        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;

    }

    /**
     * Gera uma representa��o n�merica que identifica o  objeto.
     *
     * @return um inteiro
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    /**
     * Retorna um tipo booleano true caso dois objetos tiverem o mesmo nome,
     * caso contr�rio false.
     *
     * @param obj Objeto a ser testado
     *
     *
     * @return um booleano falso ou verdadeiro
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) obj;
        if (matricula == null) {
            if (other.matricula != null) {
                return false;
            }
        } else if (!matricula.equals(other.matricula)) {
            return false;
        }
        return true;
    }

    /**
     * Retorna uma representacao em String do Aluno. Segue o formato: "matricula
     * - nome - curso".
     *
     * @return a reprentacao em String do aluno
     */
    @Override
    public String toString() {
        return this.matricula + " - " + this.nome + " - " + this.curso;

    }

}
