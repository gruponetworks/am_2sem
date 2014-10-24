package br.com.lca.beans.despesa;

import java.util.Calendar;

public class Despesa {

	private int codigo;
	private Calendar dataLancamento;
	private double valor;
	private String observacao;
	private int numeroProcesso;
	
	private TipoDespesa tipoDespesa;

	public Despesa() {

	}

	public Despesa(int codigo, Calendar dataLancamento, double valor,
			String observacao, int numeroProcesso, TipoDespesa tipoDespesa) {
		this.codigo = codigo;
		this.dataLancamento = dataLancamento;
		this.valor = valor;
		this.observacao = observacao;
		this.numeroProcesso = numeroProcesso;
		this.tipoDespesa = tipoDespesa;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
}
