package prova2;

import java.util.HashSet;

import java.util.Set;

public class Pacotao extends Encomenda {
	
	private Set<Encomenda> encomendas;

	public Pacotao(int id) {
		
		super(id);
		this.encomendas = new HashSet<>();
	}
	@Override
	public int retornaCusto() {
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
	@Override
	public String toString() {
		return this.id + " Pacotão " + retornaCusto();
	}
	

}
