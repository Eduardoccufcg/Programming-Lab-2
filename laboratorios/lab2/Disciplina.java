package lab2;
import java.util.Arrays;

/**
 * Responsável pelo controle de registro de notas e verificar quem foram
 * os aprovados e reprovados em uma disciplina.
 * 
 * @author Eduardo Pereira - 117210342
 */
public class Disciplina{
    
    /**
     * Array com as notas do semestre
     */
    private double[] notas;
    
    /**
     * Carga horária da disciplina.
     */
    private int hora;
    
    /**
     * Nome da disciplina.
     */
    private String disciplina;
    
    /**
     * Pesos das notas
     */
    private int[] pesos;
    
    /**
     * Quantidade de notas
     */
    private int qtdnotas;
    
    /**
     * Constrói uma disciplina a partir de seu nome.
     * @param nomeDisciplina nome da disciplina
     */
    public Disciplina(String nomeDisciplina){
        this.disciplina = nomeDisciplina;
        this.notas = new double[4];
        this.pesos = new int[4];
    }
    
    /**
     * Constrói uma disciplina a partir de seu nome e sua quantidade de notas.
     * @param nomeDisciplina nome da diciplina
     * @param qtdnotas quantidade de notas
     */
    public Disciplina(String nomeDisciplina,int qtdnotas){
        this.pesos = new int[qtdnotas];
        this.qtdnotas = qtdnotas;
        this.disciplina = nomeDisciplina;
        this.notas = new double[qtdnotas];
     
    }
    
    /**
     *Constrói uma disciplina a partir de seu nome, quantidade de notas
     * e seus pesos.
     * @param nomeDisciplina nome da disciplina
     * @param qtdnotas quantidade de notas
     * @param pesos quantidade de pesos
     */
    public Disciplina(String nomeDisciplina,int qtdnotas,int[] pesos){
        this.pesos = new int[qtdnotas];
        this.qtdnotas = qtdnotas;
        this.pesos = pesos;
        this.disciplina = nomeDisciplina;
        this.notas = new double[qtdnotas];
    }
    
    /**
     * Cadastra as horas da disciplina.
     * @param horas horas de aula 
     */
    public void cadastraHoras(int horas){
        this.hora += horas;
    }
    
    /**
     * Cadastra as notas da disciplina.
     * @param nota direcionamento de qual estágio essa nota pertence
     * @param valorNota valor de cada nota
     */
    public void cadastraNota(int nota, double valorNota){
        this.notas[nota-1] = valorNota;
    }
    
    /**
     * Retorna um double com a media da disciplina.
     * @param notas array contendo as notas da disciplina
     * @return média.
     */
    private double CalculaMedia(double[] notas,int[] pesos, int qtdnotas) {

        double soma = 0;
        double somaPesos = 0;
    	for(int i = 0; i < this.notas.length; i++){
            
            if (pesos[i] == 0){
                soma += notas[i];
                somaPesos = notas.length;  
            }else{
                soma += notas[i] * pesos[i];
                somaPesos += pesos[i];
            }
        }    
        double media = (double)soma / somaPesos;
    	return media;
    }
    
    /**
     * Retorna um tipo booleano true caso o aluno tenha atingido a média, caso
     * contrário false.
     * @return a situação do aluno, false para reprovado e true para aprovado.
     */ 
    public boolean aprovado(){
        return CalculaMedia(notas,pesos,qtdnotas)>= 7.0;
        
    }
    
    /**
     * Retorna a String que representa a situação da disciplina. Segue o formato
     * "DISCIPLINA  horas  média  arraydenotas".
     * @return um panorama geral da disciplina.
     */
    public String toString(){
        return disciplina + " " + hora + " " + (CalculaMedia(notas,pesos,qtdnotas)) + " " + Arrays.toString(notas);
        
    }

    /**
     * Retorna a Sring que representa o nome da disciplina. Segue o formato.
     * "DISCIPLINA"
     * @return o nome da disciplina
     */
    public String getNome(){
            return disciplina;
            
        }   
}
	
	
