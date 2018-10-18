package prova3;

import prova3.Tipo;

public class Quiosque implements Tipo {
	
	private double TUS;
	private double novaTaxa;

	public Quiosque() {
		this.TUS = 500;
	}

	@Override
	public String getTipo() {
		return "QUIOSQUE";
	}

	@Override
	public double calculaTaxasDevidas(double valorArrecadado) {
		double TA = 0;
		if(valorArrecadado >= 500) {
			TA  = valorArrecadado * 0.05;
		}
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
