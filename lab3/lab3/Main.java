package lab3;

import java.util.Scanner;

/**
 * Respons�vel por exibir o menu e gerenciar as a��es da agenda.
 * 
 * @author Eduardo Pereira - 117210342
 */
public class Main {
	
    private static Scanner input;

    /**
     * 
     * @param args
     */
    public static void main(String[] args){
        Agenda agenda = new Agenda();
        String opcao = "";
        input = new Scanner(System.in);    
        
        while(!opcao.equals("S")){
    		   
            System.out.println("\n(C)adastrar Contato");
            System.out.println("(L)istar Contatos");
            System.out.println("(E)xibir Contatos");
            System.out.println("(S)air");
            System.out.print(System.lineSeparator() + "Op��o> ");
                    
            opcao = input.nextLine();
            if(opcao.equals("E")){

            	System.out.print("Contato> ");
                int numero = Integer.parseInt(input.nextLine());
                try {
                    System.out.println(System.lineSeparator() + agenda.exibeContato(numero));
                }catch (ArrayIndexOutOfBoundsException erroindice) {
                    System.out.println(erroindice.getMessage());
                }catch(NullPointerException contatonaoexiste) {
                	System.out.println(contatonaoexiste.getMessage());
                }
     
            } else if(opcao.equals("L")){
            	
                System.out.println(agenda.listaTodos());
                
            } else if(opcao.equals("C")){
            	
            	System.out.print(System.lineSeparator() + "Posi��o: ");
                int posicao = Integer.parseInt(input.nextLine()); 
                System.out.print("Nome: ");
                String nome = input.nextLine(); 
                System.out.print("Sobrenome: ");
                String sobrenome = input.nextLine(); 
                System.out.print("Telefone: ");
                String telefone = input.nextLine();
                
                try {
                    Contato contact  = new Contato(nome,sobrenome,telefone);
                    if((agenda.cadastraContato(contact, posicao)) == true) {
                	System.out.println("CADASTRO REALIZADO!");
                    }
                }catch (ArrayIndexOutOfBoundsException erroindice) {
                    System.out.println(erroindice.getMessage());
                }

                
            }else if(!opcao.equals("C") && !opcao.equals("L") && !opcao.equals("E") && !opcao.equals("S")){
            	System.out.println("OP��O INV�LIDA");
            }
                   
        }
	
    }

}