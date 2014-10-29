package br.com.lca.dao.interfaces;

import java.util.ArrayList;

import br.com.lca.beans.processo.Cliente;
import br.com.lca.beans.processo.Periodo;
import br.com.lca.beans.processo.Processo;
import br.com.lca.exception.LcaExpection;


public interface ProcessoDAO {
	
	public ArrayList<Processo> listarProcessoPorNumero(Processo processo) throws LcaExpection;
	public ArrayList<Processo> listarProcessoPorCliente(Cliente cliente) throws LcaExpection;
	public ArrayList<Processo> listarProcessoPorPeriodo(Periodo periodo) throws LcaExpection;
	public int obterSituacao(Processo processo) throws LcaExpection;
	public boolean estaEncerrado(Processo processo) throws LcaExpection;
}
