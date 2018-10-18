
package lab2;

import java.util.ArrayList;

/**
 * Responsável por representar um aluno no sistema COISA com
 * um conjunto de disciplinas, contas de laboratório
 * e de cantina e um objeto que represente sua saúde.
 * 
 * @author Eduardo Pereira - 117210342
 */

public class Aluno {
    
    /**
     * Nome do aluno.
     */
    private String aluno;
    
    /**
     * ArrayList para armazenar as contas de laboratório.
     */
    private ArrayList < ContaLaboratorio > laboratorios;
    
    /**
     * ArrayList para armazenar as cantinas.
     */
    private ArrayList < ContaCantina > cantinas;
    
    /**
     * ArrayList para armazenar as disciplinas.
     */
    private ArrayList < Disciplina > disciplinas;
    
    /**
     * Objeto para armazenar a saúde do aluno.
     */
    private Saude saude;
    
    /**
     * Constroí um aluno a partir de seu nome.
     * @param aluno nome do aluno
     */
    public Aluno(String aluno){
        this.aluno = aluno;
        this.laboratorios = new ArrayList <>();
        this.cantinas = new ArrayList <>();
        this.disciplinas = new ArrayList <>();
        this.saude = new Saude();
    }
    
    /**
     * Cadastra um laboratório a partir de seu nome.
     * @param nomeLaboratorio nome do laboratório
     */
    public void cadastraLaboratorio(String nomeLaboratorio){
        ContaLaboratorio laboratory = new  ContaLaboratorio(nomeLaboratorio);
        this.laboratorios.add(laboratory);
    }

    /**
     * Cadastra um laboratório a partir de seu nome e cota(limite de espaço).
     * @param nomeLaboratorio nome do laboratório
     * @param cota cota(limite de espaço)
     */
    public void cadastraLaboratorio(String nomeLaboratorio, int cota){
        ContaLaboratorio laboratory = new  ContaLaboratorio(nomeLaboratorio,cota);
        this.laboratorios.add(laboratory);
    }
    
    /**
     * Consome o espaço do laboratório em mbytes.
     * @param nomeLaboratorio nome do laboratório
     * @param mbytes espaço consumido
     */
    public void consomeEspaco(String nomeLaboratorio, int mbytes){
        int indice = encontraLaboratorio(nomeLaboratorio);
        laboratorios.get(indice).consomeEspaco(mbytes);
    }
    
    /**
     * Libera o espaço do laboratório em mbytes.
     * @param nomeLaboratorio nome do laboratório
     * @param mbytes espaço liberado
     */
    public void liberaEspaco(String nomeLaboratorio, int mbytes){
        int indice = encontraLaboratorio(nomeLaboratorio);
        laboratorios.get(indice).liberaEspaco(mbytes);
    }
    
    /**
     * Retorna um tipo booleano representando se a cota foi atingida.Se
     * a cota(limite de espaço atingida retorna true caso contrario false.
     * @param nomeLaboratorio nome do laboratório
     * @return um tipo booleano que representa se a cota foi atingida
     */
    public boolean atingiuCota(String nomeLaboratorio){
      int indice = encontraLaboratorio(nomeLaboratorio);
      return laboratorios.get(indice).atingiuCota();      
    }
    
    /**
     * Retorna a String que representa quanto tem de espaço ocupado
     * em relação a cota(limite de espaço) do laboratório selecionado. Segue o formato
     * "NOME DO LABORATÓRIO - Espaço Ocupado / Cota".
     * @param nomeLaboratorio nome do laboratório
     * 
     * @return uma String com a situação da utilização de espaço
     */
    public String laboratorioToString(String nomeLaboratorio){
        int indice = encontraLaboratorio(nomeLaboratorio);
        return laboratorios.get(indice).toString();
    
    }
    
    /**
     * Cadastra uma disciplina a partir de seu nome.
     * @param nomeDisciplina nome da disciplina
     */
    public void cadastraDisciplina(String nomeDisciplina){
        Disciplina disci = new  Disciplina(nomeDisciplina);
        this.disciplinas.add(disci);
    }
    
    /**
     * Cadastra as horas de aulas da disciplina escolhida.
     * @param nomeDisciplina nome da disciplina
     * @param horas horas da disciplina
     */
    public void cadastraHoras(String nomeDisciplina, int horas){
        int indice = encontraDisciplina(nomeDisciplina);
        this.disciplinas.get(indice).cadastraHoras(horas);
    }
    
    /**
     * Cadastra as notas da disciplina selecionada.
     * @param nomeDisciplina nome da disciplina
     * @param nota escolher qual das notas será cadastrada
     * @param valorNota valor da nota
     */
    public void cadastraNota(String nomeDisciplina, int nota, double valorNota){
        int indice = encontraDisciplina(nomeDisciplina);
        this.disciplinas.get(indice).cadastraNota(nota,valorNota);
    }
    
    /**
    * Retorna um tipo booleano true caso o aluno tenha atingido a média, caso
    * contrário false.
    * @param nomeDisciplina
    * @return a situação do aluno, false para reprovado e true para aprovado.
    */ 
    public boolean aprovado(String nomeDisciplina){
        int indice = encontraDisciplina(nomeDisciplina);
        return this.disciplinas.get(indice).aprovado();
    
    }

    /**
    * Retorna a String que representa a situação da disciplina. Segue o formato
    * "DISCIPLINA horas  média  arraydenotas".
    * @param nomeDisciplina nome da disciplina
    * @return um panorama geral da disciplina.
    */
    public String disciplinaToString(String nomeDisciplina){
       int indice = encontraDisciplina(nomeDisciplina);
       return this.disciplinas.get(indice).toString(); 
    }
    
    /**
     * Cadastra uma cantina a partir de seu nome.
     * @param nomeCantina nome da cantina
     */
    public void cadastraCantina(String nomeCantina){
        ContaCantina canteen = new ContaCantina(nomeCantina);
        this.cantinas.add(canteen);
    
    }
    
    /**
     * Cadastra um lanche em uma cantina.
     * @param nomeCantina nome da cantina
     * @param qtdItens quantidade de itens
     * @param valorCentavos valor do lanche
     */
    public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos){
        int indice = encontraCantina(nomeCantina);
        this.cantinas.get(indice).cadastraLanche(qtdItens,valorCentavos);
    }
    
    /**
     * Paga a conta em uma cantina.
     * @param nomeCantina
     * @param valorCentavos 
     */
    public void pagarConta(String nomeCantina, int valorCentavos){
        int indice = encontraCantina(nomeCantina);
        this.cantinas.get(indice).pagaConta(valorCentavos);
    }
    
    /**
    * Retorna a String que representa a conta da cantina. No formato
    * "Nome da Cantina  Quantidades de itens Valor em centavos "
    * @param nomeCantina nome da cantina
    * @return a representação em String o atual estado da conta
    */
    public String cantinaToString(String nomeCantina){
        int indice = encontraCantina(nomeCantina);
        return this.cantinas.get(indice).toString();
    
    }
    
    /**
     * Define um novo valor a saúde mental.
     * @param valor estado da saúde mental
     */
    public void defineSaudeMental(String valor){
        this.saude.defineSaudeMental(valor);
    
    }
    
    /**
    * Define um novo valor a saude física.
    * @param valor estado da saúde física
    */
    public void defineSaudeFisica(String valor){
        this.saude.defineSaudeFisica(valor);
    
    }
    
    /**
     * Retorna uma String com o estado geral da sáude.
     * @return o estado da saúde no geral
     */
    public String getStatusGeral(){
        return this.saude.getStatusGeral();
        
    }
    
    /**
     * Encontra a cantina a ser alterada.
     * @param nomeCantina nome da cantina
     * @return o indice da cantina no Arraylist cantinas.
     */
    private int encontraCantina(String nomeCantina){
        for(int i = 0; i < this.cantinas.size(); i++){
            if(this.cantinas.get(i).getNome().equals(nomeCantina)){
                return i;
            }
        
        }
        return -1 ;
    }
    
    /**
     * Encontra a disciplina a ser alterada.
     * @param nomeDisciplina nome da disciplina
     * @return o indice da disciplina no Arraylist disciplinas.
     */
    private int encontraDisciplina(String nomeDisciplina){
        for(int i = 0; i < this.disciplinas.size(); i++){
            if(this.disciplinas.get(i).getNome().equals(nomeDisciplina)){
                return i;
            }
        
        }
        return -1 ;
    }
    
    /**
     * Encontra o laboratório a ser alterado
     * @param nomeLaboratorio
     * @return o indice do laboratório no Arraylist laboratorios.
     */
    private int encontraLaboratorio(String nomeLaboratorio){
        for(int i = 0; i < this.laboratorios.size(); i++){
            if(this.laboratorios.get(i).getNome().equals(nomeLaboratorio)){
                return i;
            }
        
        }
        return -1 ;
    }
}
