package prova3;



import java.util.Collections;
import java.util.LinkedHashMap;

import java.util.Map;

import prova3.CNPJNaoCadastradoException;
import prova3.DesempenhoFinanceiro;
import prova3.Ecom;
import prova3.IdInvalidoException;
import prova3.MaiorArrecadacao;
import prova3.MaiorTaxaCobrada;

public class Sistema {
	
	Map<String, Ecom> ecoms;
	
	DesempenhoFinanceiro<Ecom> desempenho;
	
	public Sistema() {
		this.ecoms = new LinkedHashMap<>();
	}
	public void cadastraEcom(String nomeFantasia, String CNPJ, String proprietario, int idTipo) throws IdInvalidoException {
		if(!this.ecoms.containsKey(CNPJ)) {
			Ecom ecom = new Ecom(nomeFantasia, CNPJ,  proprietario,  idTipo);
			this.ecoms.put(CNPJ, ecom);
		}
		
	}
	public String recuperarEcom(String CNPJ) throws CNPJNaoCadastradoException {
		if(this.ecoms.containsKey(CNPJ)) {
			throw new CNPJNaoCadastradoException();
		}
		
		return this.ecoms.get(CNPJ).toString();
		
	}
	public void alterarTipoEcom(String CNPJ, int IdTipo) throws IdInvalidoException {
		this.ecoms.get(CNPJ).alterarTipoEcom(IdTipo);
	}
	public void informarValorArrecadado(String CNPJ, double valor) {
		this.ecoms.get(CNPJ).adicionarValorArrecadado(valor);
	}
	public double consultaTaxasDevidas(String CNPJ) {
		return this.ecoms.get(CNPJ).consultarTaxaDevidas();
		
	}
	public double consultarTotalArrecadao(String CNPJ) {
		return this.ecoms.get(CNPJ).getValorArrecadado();
		
	}
	@SuppressWarnings("unchecked")
	public String consultarMaiorArrecadao() {
		desempenho = new MaiorArrecadacao<Ecom>();
		Ecom ecom = Collections.max(ecoms.values(),desempenho);
		return ecom.toString();
	}
	public String consultarMaiorTaxaCobrada() {
		desempenho = new MaiorTaxaCobrada<Ecom>();
		Ecom ecom = Collections.max(ecoms.values(),desempenho);
		return ecom.toString();
	}

	


}
