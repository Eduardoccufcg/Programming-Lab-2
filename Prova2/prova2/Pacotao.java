package prova2;

import java.util.HashSet;

import java.util.Set;

public class Pacotao {
	
	private Set<Encomenda> encomendas;
	int id;

	public Pacotao(int id) {
		
		this.id = id;
		this.encomendas = new HashSet<>();
	}
	public int recuperaCusto() {
		int custo = 0;
		
		for (Encomenda encomenda : this.encomendas) {
			custo += encomenda.retornaCusto();
		}
		return custo;
		
	}
	public boolean adicionaEncomenda(Encomenda encomenda) {
		return this.encomendas.add(encomenda);
	}
	public boolean existeEncomenda(Encomenda encomenda) {
		if (this.encomendas.contains(encomenda)) {
			return true;
			
		}
		return false;
		
	}
	

}
