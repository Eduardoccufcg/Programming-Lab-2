package prova2;

public class Facade {
	
	Eliane eliane;
	
	public void InicializaSistema() {
		this.eliane = new Eliane();
	}
	public int cadastraPac(int peso) {
		return this.eliane.cadastraPac(peso);
	}
	
	public int cadastraSedex(int peso, int volume) {
		return this.eliane.cadastraSedex(peso,volume);
	}
	
	public int cadastraCr(int numFolhas) {
		return this.eliane.cadastraCr(numFolhas);
	}
	public String recuperaEncomeda(int codigo) {
		return this.eliane.recuperaEncomenda(codigo);
	}
	public int recuperaCusto(int codigo) {
		return this.eliane.recuperaCusto(codigo);
		
	}
	public int cadastraPacotao() {
		return this.eliane.criaPacotao();
	}
	public void adicionarElementoPacotao(int idPacotao, int codigoEncomenda) {
		this.eliane.adicionaElemento(idPacotao, codigoEncomenda);
		
	}
	public int recuperaCustoPacotao(int idPacotao) {
		return this.eliane.recuperaCustoPacotao(idPacotao);
	}
	
	

}
