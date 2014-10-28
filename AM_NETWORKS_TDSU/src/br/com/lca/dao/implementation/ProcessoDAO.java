package br.com.lca.dao.implementation;

import java.util.List;

import br.com.lca.beans.processo.Cliente;
import br.com.lca.beans.processo.Periodo;
import br.com.lca.beans.processo.Processo;
import br.com.lca.exception.LcaExpection;

public class ProcessoDAO implements br.com.lca.dao.interfaces.ProcessoDAO {

	public ProcessoDAO() {

	}

	@Override
	public List<Processo> listarProcessoPorNumero(Processo processo)
			throws LcaExpection {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Processo> listarProcessoPorCliente(Cliente cliente)
			throws LcaExpection {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Processo> listarProcessoPorPeriodo(Periodo periodo)
			throws LcaExpection {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int obterSituacao(Processo processo) throws LcaExpection {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estaEncerrado(Processo processo) throws LcaExpection {
		// TODO Auto-generated method stub
		return false;
	}
}
