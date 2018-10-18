package lab2;
/**
 * Responsável por verificar e classificar a saude mental e física de uma pessoa.
 * @author Eduardo Pereira - 117210342
 */
public class Saude{
    /**
     * Intensidade da saúde mental (forte ou fraca).
     */
    private String valorMental;
    /**
     * Intensidade da saude mental ( forte ou fraca).
     */
    private String valorFisica;
    /**
     * Estado da saúde física (fraca, ok ou boa).
     */
    private String saude;
  
    private String emoji = "";
    /**
     * Constrói a saúde com valor prefixado "boa" para valorMental e
     * valorFísica.
     */
    
    public Saude() {
	this.valorMental = "boa";
	this.valorFisica = "boa";
		
    }
    /**
     * Define um novo valor a saúde mental.
     * @param valor estado da saúde mental
     */
    public void defineSaudeMental(String valor) {
	this.valorMental = valor;
    }
    /**
     * Define um novo valor a saude física.
     * @param valor estado da saúde física
     */
    public void defineSaudeFisica(String valor) {
	this.valorFisica = valor;
    }

    /**
     * Define um emoji que representa a saúde do aluno.
     * @param valor emoji
     */
    public void definirEmoji(String valor){
        this.emoji = valor;
    }
    /**
     * Retorna uma String com o estado geral da sáude.
     * @return o estado da saúde no geral
     */
    public String getStatusGeral() {
		
	if(valorMental.equals("fraca") && valorFisica.equals("fraca")) {
		saude = "fraca";	
	}else if(valorMental.equals("boa") && valorFisica.equals("fraca")) {
		saude = "ok";
	}else if (valorMental.equals("fraca") && valorFisica.equals("boa")) {
		saude = "ok";
	}else {
		saude = "boa";
	}
        if (emoji.equals("")) {
            return saude;
        }else{
            if (valorMental != "boa" || valorFisica != "boa"){
                return saude;
                
            }else{
                return saude + " " + emoji;
            }
        }
			
    }
    
	
}
