package br.com.lca.dao.factory;

import br.com.lca.dao.implementation.HonorarioDAO;
import br.com.lca.dao.implementation.ProcessoDAO;
import br.com.lca.dao.implementation.TipoDespesaDAO;
import br.com.lca.dao.implementation.TipoTarefaDAO;


public abstract class DAOFactory {
	
	public static TipoDespesaDAO getTipoDespesaDAO(){
		return new TipoDespesaDAO();
	}
	public static TipoTarefaDAO getTipoTarefaDAO(){
		return new TipoTarefaDAO();
	}
	
	public static ProcessoDAO getProcessoDAO(){
		return new ProcessoDAO();
	}
	public static HonorarioDAO getHonorarioDAO(){
		return new HonorarioDAO();
	}
}
