package br.com.lca.beans.processo;

import java.util.Calendar;

public class Processo {

	private int codigo;
	private String descricao;
	private Calendar dataAbertura;
	private Calendar dataFechamento;
	private int situacao;
	
	Cliente cliente;
	Advogado advogado;

	public Processo() {
		
	}

	public Processo(int codigo, String descricao, Calendar dataAbertura,
			Calendar dataFechamento, int situacao, Cliente cliente,
			Advogado advogado) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.situacao = situacao;
		this.cliente = cliente;
		this.advogado = advogado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Calendar getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}
}
