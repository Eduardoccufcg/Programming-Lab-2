package lab2;
/**
 * Responsável por controlar uma conta em uma cantina com operaçoes
 * de compra e pagamento.
 * 
 * @author Eduardo Pereira - 117210342
 */

public class ContaCantina{
    
    /**
     * Nome da Cantina.
     */
    private String nomeDaCantina;
    
    /**
     * Quantidade de Itens Vendidos.
     */
    private int qtdItens;
    
    /**
     * Valor da venda do tipo inteiro.
     */
    private int valorCentavos;
    
    /**
     * Array de detalhes.
     */
    private String[] detalhes = new String[5];
    
    /**
     * Constrói uma conta em uma cantina a partir de seu nome.
     * @param nomeDaCantina o nome da cantina
     */
    public ContaCantina(String nomeDaCantina) {
        this.nomeDaCantina = nomeDaCantina;
    }
    
    /**
     * Adiciona a quantidade de itens e também o preço da venda.
     * @param qtdItens quantidade de itens vendidos
     * @param valorCentavos valor do produto
     */
    public void cadastraLanche(int qtdItens, int valorCentavos) {
        this.qtdItens += qtdItens;
        this.valorCentavos += valorCentavos;
    }
    
    /**
     * Adiciona a quantidade de itens, preço em centavos e detalhes da venda
     * @param qtdItens quantidade de itens
     * @param valorCentavos valor em centavos
     * @param detalhes detalhes do produto
     */
    public void cadastraLanche(int qtdItens, int valorCentavos,  String detalhes){
        this.qtdItens += qtdItens;
        this.valorCentavos += valorCentavos;
        int i = 0;
        while(i <this.detalhes.length-1 ){
            String a = this.detalhes[i];
            this.detalhes[i] = this.detalhes[i+1];
            this.detalhes[i+1] = a;    
            i++;
        }
        this.detalhes[4] = detalhes;
    }
    
    /**
     * Remove da conta o valor que foi pago.
     * @param valorCentavos valor do produto
     */
    public void pagaConta(int valorCentavos) {
        this.valorCentavos -= valorCentavos;
    }
    
    /**
     * Retorna a String que representa a conta da cantina. No formato
     * "Nome da Cantina  Quantidades de itens Valor em centavos "
     * @return a representação em String o atual estado da conta
     */
    public String toString() {
        return nomeDaCantina + " " + qtdItens + " " + valorCentavos;
    }
    
    /**
     * Retorna a String que representa os ultimos 5 detalhes.No formato
     * "detalhe1, detalhe2, detalhe3, detalhe4, detalhe5"
     * @return a representação em string dos ultimos 5 detalhes
     */
    public String listarDetalhes(){
        String a = "";
        for(int i = 0; i < detalhes.length;i ++){
            if (i != 4){
               a += detalhes[i] + ", "; 
            }else{
                a += detalhes[i];
            }
            
        }
        return a;
        
        
    }

    /**
     * Retorna a Sring que representa o nome da cantina. Segue o formato.
     * "nome da cantina"
     * @return o nome da cantina
     */
    public String getNome(){
            return nomeDaCantina;
            
        }
	
}

