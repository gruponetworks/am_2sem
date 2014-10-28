package br.com.lca.beans.processo;

import java.util.Calendar;

public class Periodo {

	private Calendar dataInicial;
	private Calendar dataFinal;

	public Periodo() {

	}

	public Periodo(Calendar dataInicial, Calendar dataFinal) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public Calendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Calendar getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}
}
