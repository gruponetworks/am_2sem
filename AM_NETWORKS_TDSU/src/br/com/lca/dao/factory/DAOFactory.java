package br.com.lca.dao.factory;

import br.com.lca.dao.implementation.HonorarioDAO;
import br.com.lca.dao.implementation.ProcessoDAO;

public abstract class DAOFactory {
	
	public static ProcessoDAO getProcessoDAO(){
		return new ProcessoDAO();
	}
	public static HonorarioDAO getHonorarioDAO(){
		return new HonorarioDAO();
	}
}
