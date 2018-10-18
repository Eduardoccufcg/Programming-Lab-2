package prova3;

import prova3.Tipo;

public class Barraca implements Tipo {
	
	private double TUS;
	private double novaTaxa;
	
	

	public Barraca() {
		this.TUS = 1000;

	}

	@Override
	public String getTipo() {
		return "BARRACA";
	}

	@Override
	public double calculaTaxasDevidas(double valorArrecadado) {
		double TA = 0;
		TA  = valorArrecadado * 0.1;
		return TA + this.TUS + this.novaTaxa;
	}

	@Override
	public void adicionaTUS(double novaTaxa) {
		this.novaTaxa = novaTaxa;
		
	}
	@Override
	public double getTUS() {
		return this.TUS;
	}




}
