package br.com.lca.dao.factory;

import br.com.lca.dao.implementation.ProcessoDAO;

public abstract class DAOFactory {
	
	public static ProcessoDAO getProcessoDAO(){
		return new ProcessoDAO();
	}
}
