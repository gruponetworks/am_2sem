package br.com.lca.dao.interfaces;

import java.util.List;

import br.com.lca.beans.processo.Cliente;
import br.com.lca.beans.processo.Periodo;
import br.com.lca.beans.processo.Processo;
import br.com.lca.exception.LcaExpection;


public interface ProcessoDAO {
	
	public List<Processo> listarProcessoPorNumero(Processo processo) throws LcaExpection;
	public List<Processo> listarProcessoPorCliente(Cliente cliente) throws LcaExpection;
	public List<Processo> listarProcessoPorPeriodo(Periodo periodo) throws LcaExpection;
	public int obterSituacao(Processo processo) throws LcaExpection;
	public boolean estaEncerrado(Processo processo) throws LcaExpection;
}
