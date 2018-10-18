package lab4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Respons�vel por gerenciar os alunos e grupos do controle.
 *
 * @author Eduardo Pereira - 117210342
 */
public class Controle {

    /**
     * Mapa que armazena e manipula os alunos cadastrados no controle.
     */
    private HashMap<String, Aluno> alunos;

    /**
     * Mapa que armazena e manipula os grupos cadastrados no controle.
     */
    private HashMap<String, Grupo> grupos;
    
    /**
     * Lista que armazena e manipula os alunos que responderam quest�es no quadro.
     */
    private ArrayList<Aluno> alunosQueResponderam;

    /**
     * Constr�i o controle sem param�tros.
     */
    public Controle() {

        alunos = new HashMap<>();
        grupos = new HashMap<>();
        alunosQueResponderam = new ArrayList<>();
    }

    /**
     * Cadastra o aluno no controle. Retorna um booleano true caso o
     * cadastro do aluno tenha sido realizado com sucesso, caso contr�rio
     * false.
     *
     * @param matricula Matr�cula do aluno
     * @param nome Nome do aluno
     * @param curso Curso do Aluno
     *
     * @return um booleano true ou false
     */
    public boolean cadastraAluno(String matricula, String nome, String curso) {
        if (!existeAluno(matricula)) {
            Aluno aluno = new Aluno(matricula, nome, curso);
            this.alunos.put(matricula, aluno);
            return true;
        }
        return false;

    }

    /**
     * Verifica se um aluno j� est� cadastrado no controle. Retorna um booleano
     * true caso o aluno exista caso contr�rio retorna falso.
     *
     * @param matricula Matr�cula do aluno
     * @return um booleano true ou false
     */
    private boolean existeAluno(String matricula) {
        if (matricula == null) {
            throw new NullPointerException("Matr�cula nula");
        }
        if (matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("Matr�cula inv�lida");
        }

        return this.alunos.containsKey(matricula);

    }

    /**
     * Retorna uma representa��o em String do aluno a partir de sua matr�cula.
     *
     * @param matricula Matricula do aluno
     * @return uma String com a matr�cula, nome e curso do aluno, caso ele
     * esteja cadastrado. Caso contr�rio "Aluno n�o cadastrado"
     */
    public String exibeAluno(String matricula) {
        if (matricula == null) {
            throw new NullPointerException("Matr�cula nula");
        }
        if (matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("Matr�cula inv�lida");
        }

        if (existeAluno(matricula)) {
            return "Aluno: " + this.alunos.get(matricula).toString() + System.lineSeparator();
        } else {
            return "Aluno n�o cadastrado." + System.lineSeparator();
        }

    }

    /**
     * Cadastra um grupo no controle. Retorna um booleano true caso o
     * cadastro do grupo tenha sido realizado com sucesso, caso contr�rio false.
     *
     * @param nome Nome do grupo
     * @return um booleano true ou falso
     */
    public boolean cadastraGrupo(String nome) {

        if (!existeGrupo(nome)) {
            Grupo grupo = new Grupo(nome);
            this.grupos.put(nome.toLowerCase(), grupo);
            return true;
        }
        return false;

    }

    /**
     * Verifica se um grupo j� est� cadastrado no controle. Retorna um booleano
     * true caso o aluno exista caso contr�rio retorna falso.
     *
     * @param nome Nome do grupo
     * @return um booleano true ou false
     */
    private boolean existeGrupo(String nome) {
        if (nome == null) {
            throw new NullPointerException("Nome nulo");
        }
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inv�lido");
        }
        return this.grupos.containsKey(nome.toLowerCase());

    }

    /**
     * Aloca um aluno em um grupo.Caso o aluno n�o esteja cadastrado � retornado
     * "Aluno n�o cadastrado.". Se o grupo n�o estiver cadastrado retorna "Grupo
     * n�o cadastrado.".Se nenhum desses casos ocorrer � retornado "ALUNO
     * ALOCADO!".
     *
     * @param matricula Matr�cula do aluno a ser alocado no grupo
     * @param nomeGrupo Nome do grupo
     * @return uma String com a situa��o da aloca��o do aluno
     */
    public String alocaAlunoGrupo(String matricula, String nomeGrupo) {
        String retorno = "";
        if (!existeAluno(matricula)) {
            retorno += "Aluno n�o cadastrado." + System.lineSeparator();
        }
        if (!existeGrupo(nomeGrupo)) {
            retorno += "Grupo n�o cadastrado." + System.lineSeparator();
        }
        if (existeAluno(matricula) && existeGrupo(nomeGrupo)) {
            Aluno aluno = this.alunos.get(matricula);
            Grupo grupo = this.grupos.get(nomeGrupo.toLowerCase());
            grupo.alocaAluno(aluno);
            retorno += "ALUNO ALOCADO!" + System.lineSeparator();
        }
        return retorno;

    }

    /**
     * Retorna uma representa��o em String dos alunos do grupo, caso ele esteja
     * cadastrado. Se o grupo n�o estiver cadastrado � retornado "Grupo n�o
     * cadastrado.".
     *
     * @param nomeGrupo Nome do grupo
     * @return uma String com os alunos do grupo ou "Grupo n�o cadastrado."
     */
    public String imprimeGrupo(String nomeGrupo) {
        if (nomeGrupo == null) {
            throw new NullPointerException("Nome nulo");
        }
        if (nomeGrupo.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inv�lido");
        }
        if (existeGrupo(nomeGrupo)) {
            return this.grupos.get(nomeGrupo.toLowerCase()).toString();

        } else {
            return "Grupo n�o cadastrado." + System.lineSeparator();
        }

    }

    /**
     * Retorna um booleano true caso o cadastro seja realizado com sucesso, se
     * o aluno n�o estiver cadastro retorna false.
     *
     * @param matricula Matr�cula do aluno que respondeu no quadro
     * @return um booleano true ou false
     */
    public boolean registraAlunoRespondeu(String matricula) {
        if (existeAluno(matricula)) {
            Aluno aluno = this.alunos.get(matricula);
            this.alunosQueResponderam.add(aluno);
            return true;
        }
        return false;

    }

    /**
     * Retorna uma String com todos os alunos que responderam no quadro.
     *
     * @return uma String com alunos
     */
    public String listaAlunosRespoderam() {
        String alunosResponderam = "";
        for (int i = 0; i < this.alunosQueResponderam.size(); i++) {
            alunosResponderam += (i + 1) + ". " + this.alunosQueResponderam.get(i).toString() + System.lineSeparator();
        }
        return alunosResponderam;
    }

}
