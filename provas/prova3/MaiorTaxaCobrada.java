package prova3;

import prova3.DesempenhoFinanceiro;
import prova3.Ecom;

public class MaiorTaxaCobrada<T> implements DesempenhoFinanceiro<T> {

	@Override
	public int compare(T o1, T o2) {
		if (((Ecom) o1).consultarTaxaDevidas() > ((Ecom) o2).consultarTaxaDevidas()) {
			return 1;
		} else if (((Ecom) o1).consultarTaxaDevidas() < ((Ecom) o2).consultarTaxaDevidas()) {
			return -1;
		} else {
			return 0;
		}
	}

}
