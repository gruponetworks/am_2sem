package br.com.lca.beans.honorario;

import java.util.Calendar;

public class Honorario {

	private int codigo;
	private Calendar dataLancamento;
	private double quantidadeHoras;
	private String observacao;
	private int numeroProcesso;

	private TipoTarefa tipoTarefa;

	public Honorario() {
		
	}

	public Honorario(int codigo, Calendar dataLancamento,
			double quantidadeHoras, String observacao, int numeroProcesso,
			TipoTarefa tipoTarefa) {
		this.codigo = codigo;
		this.dataLancamento = dataLancamento;
		this.quantidadeHoras = quantidadeHoras;
		this.observacao = observacao;
		this.numeroProcesso = numeroProcesso;
		this.setTipoTarefa(tipoTarefa);
	}

	public Honorario(int codigo) {
		this.codigo = codigo;
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

	public double getQuantidadeHoras() {
		return quantidadeHoras;
	}

	public void setQuantidadeHoras(double quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
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

	public TipoTarefa getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(TipoTarefa tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}
}
