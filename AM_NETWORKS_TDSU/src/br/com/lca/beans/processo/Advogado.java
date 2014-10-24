package br.com.lca.beans.processo;

public class Advogado {

	private int codigo;
	private double valorHora;

	public Advogado() {

	}

	public Advogado(int codigo, double valorHora) {
		super();
		this.codigo = codigo;
		this.valorHora = valorHora;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
}
