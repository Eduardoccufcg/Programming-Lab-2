package prova3;

import prova3.Tipo;

public class Restaurante implements Tipo {
	
	
	private double TUS;
	private double novaTaxa;
	
	

	public Restaurante() {
		this.TUS = 5000;
	}


	@Override
	public String getTipo() {
		return "RESTAURANTE";
	}

	
	@Override
	public double calculaTaxasDevidas(double valorArrecadado) {
		double TA = 0;
		int bonus = (int) (valorArrecadado) / 1000;
		TA = valorArrecadado * 0.2 - bonus;
	
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
