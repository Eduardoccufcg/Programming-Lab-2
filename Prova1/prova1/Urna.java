package prova1;

public class Urna {
	private Candidato candidatos[];
	private RegistroVoto votos[];
	
	public Urna(){
		
		candidatos = new Candidato[100];
		votos = new RegistroVoto[100];
		Candidato lola = new Candidato("Lola" ,"PJ", 10 );
		Candidato bolsanaro = new Candidato("Bolsanaro" ,"PKM", 11 );
		Candidato jalkimin = new Candidato("Jalkimin" ,"PSDD", 44 );
		Candidato ziro = new Candidato("Ziro Gomes" ,"PLP", 20 );
		Candidato marilia = new Candidato("Marilia" ,"PSBV", 25 );
		this.candidatos[0] = lola;
		this.candidatos[1] = bolsanaro;
		this.candidatos[2] = jalkimin;
		this.candidatos[3] = ziro;
		this.candidatos[4] = marilia;
		
		
		
	}
	
	public boolean votar(String tituloEleitor, int numeroCandidato, String horaDoVoto) {
		if(encontraCandidato(numeroCandidato) == false) {
			throw new IllegalArgumentException("Candidato não existe");
		}
		boolean votou = false;
		RegistroVoto eleitor = new RegistroVoto(tituloEleitor,horaDoVoto);
		if(jaVotou(eleitor) == false) {
			
			votou = true;
			for(int k = 0; k < this.votos.length;k++) {
				if(this.votos[k] == null) {
					votos[k] = eleitor;
					break;
				}
			}
			for(int x = 0; x < this.candidatos.length;x++) {
				if(this.candidatos[x] != null && this.candidatos[x].getId() == numeroCandidato) {
					candidatos[x].adicionaVoto();
					
				}
			}


		}
		
		return votou;
	}
	
	public  boolean jaVotou(RegistroVoto novo) {
		for(int d = 0; d < this.votos.length;d++) {
			if (this.votos[d] != null) {
				if(this.votos[d].equals(novo)){
				return true;
				}
			}					
		}
		return false;
	}
	
	public String listarVotos() {
		String lista = "";
		for(int i = 0; i < this.candidatos.length; i++) {
			if (this.candidatos[i] != null) {
				lista +=  candidatos[i].apuracaoCandidato() + System.lineSeparator();
			}
			
			
		}
		return lista;
	}
	
	public boolean checarUrna() {
		int apuracaototal = 0;
		for(int i = 0; i < this.candidatos.length; i++) {
			if(this.candidatos[i] != null) {
				apuracaototal += this.candidatos[i].getTotalVotos();
			}
			
		}
		int apuracaoregistro = 0;
		for(int d = 0; d < this.votos.length; d++) {
			if(this.votos[d] != null) {
				apuracaoregistro += 1;
				
			}
		}
		
		if (apuracaototal == apuracaoregistro) {
			return true;
		}else {
			return false;
		}
		
		
	}
	public boolean encontraCandidato(int numerocandidato){
		for(int i = 0 ; i < this.candidatos.length; i++) {
			if( this.candidatos[i] != null && this.candidatos[i].getId() == numerocandidato) {
				return true;	
			}
		}
		return false;
	}

}
		
			
