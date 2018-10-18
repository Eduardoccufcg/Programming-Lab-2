package lab2;

/**
* Responsável por verificar o fluxo de espaço utilizado em um laboratório
* @author Eduardo Pereira - 117210342
*/
public class ContaLaboratorio{
	
	/**
	* Nome do laboratório .
	*/
	private String nomeLaboratorio;
        
	/**
	* Cota (limite de espaço) em mbytes.
	*/
	private int cota;
        
	/**
	*  Espaço ocupado em mbytes.
	*/
	private int espacoOcupado;

        /**
         * Constrói um laboratório a partir de seu nome.
         * @param nomeLaboratorio 
         */
	
	public ContaLaboratorio(String nomeLaboratorio) {
		
		this.nomeLaboratorio = nomeLaboratorio;	
		this.cota = 2000;
		this.espacoOcupado = 0;
	}
	
	/**
	 * Contrói um laboratório a partir de seu nome e cota(limite de espaço).
	 * @param nomeLaboratorio
	 * @param cota
	 */
	
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
		this.espacoOcupado = 0;
	}
	
	/**
	* Consome o espaço ocupado que é passado como parâmetro.
        * @param mbytes
	*/
	
	public void consomeEspaco(int mbytes) {
		
		this.espacoOcupado += mbytes;		
	}
	
	/**
	* libera o espaço ocupado que é passado como parâmetro.
        * @param mbytes
	*/
	
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado -= mbytes;
		
	}
	
	/**
	 * Retorna um tipo booleano representando se a cota foi atingida.Se
         * a cota(limite de espaço atingida retorna true caso contrario false.
	 * @return um tipo booleano que representa se a cota foi atingida
	 */
	
	public boolean atingiuCota() {
            return espacoOcupado >= cota;
	}
        /**
         * Retorna a String que representa quanto tem de espaço ocupado
         * em relação a cota(limite de espaço). Segue o formato
         * "NOME DO LABORATÓRIO - Espaço Ocupado / Cota".
         * @return uma String com a situação da utilização de espaço
         */
	public String toString() {
		return nomeLaboratorio + " " + espacoOcupado + "/" + cota;
	}
        
        /**
        * Retorna a Sring que representa o nome do laboratório. Segue o formato.
        * "nome do laboratório"
        * @return o nome do laboratório
        */
        public String getNome(){
            return nomeLaboratorio;
            
        }
	
}