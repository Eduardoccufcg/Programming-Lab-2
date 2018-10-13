package prova2;

import java.util.HashMap;
import java.util.Map;

public class Eliane {

	int numeracao;
	int idpacotao;

	private Map<Integer, Encomenda> encomendas;
	private Map<Integer, Pacotao> pacotes;

	public Eliane() {
		this.pacotes = new HashMap<>();
		this.encomendas = new HashMap<>();
		this.numeracao = 100000000;
		this.idpacotao = 1;
	}

	private int geraCodigo() {
		return this.numeracao++;

	}

	private int geraIdPacotao() {
		return this.idpacotao++;
	}

	int cadastraPac(int peso) {
		int id = geraCodigo();
		Encomenda pac = new Pac(peso, id);
		this.encomendas.put(id, pac);
		return id;
	}

	int cadastraSedex(int peso, int volume) {
		int id = geraCodigo();
		Encomenda sedex = new Sedex(peso, volume, id);
		this.encomendas.put(id, sedex);
		return id;

	}

	int cadastraCr(int folhas) {
		int id = geraCodigo();
		Encomenda cr = new Cr(id, folhas);
		this.encomendas.put(id, cr);
		return id;

	}

	public String recuperaEncomenda(int codigo) {
		return this.encomendas.get(codigo).toString();

	}

	public int recuperaCusto(int codigo) {
		return this.encomendas.get(codigo).retornaCusto();

	}

	public int criaPacotao() {
		int idPacotao = geraIdPacotao();
		Pacotao pacotao = new Pacotao(idPacotao);
		this.pacotes.put(idPacotao, pacotao);
		return idPacotao;

	}

	public void adicionaElemento(int idpacotao, int codigoEncomenda) {
		Pacotao pacotao = this.pacotes.get(idpacotao);
		Encomenda encomenda = this.encomendas.get(codigoEncomenda);
		if (this.pacotes.get(idpacotao).existeEncomenda(encomenda)) {
			throw new IllegalArgumentException("Encomenda ja está no pacotão");
		}
		pacotao.adicionaEncomenda(encomenda);
	}

	public int recuperaCustoPacotao(int idPacotao) {
		return this.pacotes.get(idPacotao).recuperaCusto();

	}

}
