package prova1;

public class RegistroVoto {
	
	private String tituloEleitor;
	private String horaVotacao;

	public RegistroVoto(String tituloEleitor, String horaVotacao) {
		

		this.tituloEleitor = tituloEleitor;
		this.horaVotacao = horaVotacao;

    }
    public String getTituloEleitor() {
    	return tituloEleitor;
    }

    public String getHoraVotacao() {

         return horaVotacao;

    }
    @Override

    public boolean equals(Object obj) {
    	if(obj instanceof RegistroVoto){
    		RegistroVoto novo = (RegistroVoto) obj;
    		return getTituloEleitor() == novo.getTituloEleitor();
    	}
            return false;
    }


        @Override

        public String toString() {

        	return "Titulo de eleitor: " + getTituloEleitor() + " hora votacao: " + getHoraVotacao();

        }

}


