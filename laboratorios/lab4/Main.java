package lab4;

import java.util.Scanner;

/**
 * Respons�vel por realizar as a��es da classe Controle.
 *
 * @author Eduardo Pereira - 117210342
 */
public class Main {

	/**
	 * Objeto que gerencia as entradas.
	 */
	private static Scanner input;
	/**
	 * Objeto que representa o controle.
	 */
	private static Controle controle;

	/**
	 * Fun��o principal.
	 * 
	 * @param args N�o � usado
	 * 
	 *            
	 */
	public static void main(String[] args) {

		controle = new Controle();
		input = new Scanner(System.in);
		char opcao = '\u0000';
		while (opcao != 'O') {

			exibeMenu();

			opcao = input.next().charAt(0);
			input.nextLine();
			switch (opcao) {

			case 'C':

				cadastraAluno();

				break;

			case 'E':

				exibeAluno();

				break;

			case 'N':

				cadastraGrupo();

				break;

			case 'A':

				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				String subOpcao = input.nextLine();
				if (subOpcao.equals("A")) {

					alocaAlunoNoGrupo();

				} else if (subOpcao.equals("I")) {

					imprimeGrupo();

				} else {

					System.out.println("Op��o Inv�lida" + System.lineSeparator());
				}

				break;
			case 'R':

				registrarAlunoRespondeu();

				break;
			case 'I':

				System.out.print(
						"Alunos:" + System.lineSeparator() + controle.listaAlunosRespoderam() + System.lineSeparator());

				break;
			default:

				if (opcao != 'O') {

					System.out.println("Op��o Inv�lida" + System.lineSeparator());
				}

			}
		}

	}

	/**
	 * Fun��o que exibe o menu de op��es.
	 */
	private static void exibeMenu() {

		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
		System.out.print(System.lineSeparator() + "Op��o> ");
	}

	/**
	 * Fun��o que cadastra o aluno no controle.
	 */
	private static void cadastraAluno() {

		System.out.print("Matr�cula: ");
		String matricula = input.nextLine();
		System.out.print("Nome: ");
		String nome = input.nextLine();
		System.out.print("Curso: ");
		String curso = input.nextLine();
		if (controle.cadastraAluno(matricula, nome, curso)) {
			System.out.println("CADASTRO REALIZADO!" + System.lineSeparator());

		} else {
			System.out.println("ALUNO J� CADASTRADO!" + System.lineSeparator());
		}

	}

	/**
	 * Fun��o que exibe o aluno selecionado.
	 */
	private static void exibeAluno() {
		System.out.print("Matr�cula: ");
		String matricula = input.nextLine();
		System.out.println(controle.exibeAluno(matricula));
	}

	/**
	 * Fun��o que cadastra um grupo.
	 */
	private static void cadastraGrupo() {

		System.out.print("Grupo: ");
		String nomeGrupo = input.nextLine();
		if (controle.cadastraGrupo(nomeGrupo)) {
			System.out.println("CADASTRO REALIZADO!" + System.lineSeparator());

		} else {
			System.out.println("GRUPO J� CADASTRADO!" + System.lineSeparator());
		}

	}

	/**
	 * Fun��o que aloca um aluno em um grupo.
	 */
	private static void alocaAlunoNoGrupo() {
		System.out.print("Matr�cula: ");
		String matricula = input.nextLine();
		System.out.print("Grupo: ");
		String nomeGrupo = input.nextLine();
		System.out.println(controle.alocaAlunoGrupo(matricula, nomeGrupo));

	}

	/**
	 * Fun��o que imprime todos os alunos de um grupo.
	 */
	private static void imprimeGrupo() {

		System.out.print("Grupo: ");
		String nomeGrupo = input.nextLine();
		System.out.println(controle.imprimeGrupo(nomeGrupo));

	}

	/**
	 * Fun��o que registra o aluno que respondeu no quadro.
	 */
	private static void registrarAlunoRespondeu() {
		System.out.print("Matr�cula: ");
		String matricula = input.nextLine();
		if (controle.registraAlunoRespondeu(matricula)) {
			System.out.println("ALUNO REGISTRADO!" + System.lineSeparator());

		} else {
			System.out.println("Aluno n�o cadastrado." + System.lineSeparator());

		}

	}

}
