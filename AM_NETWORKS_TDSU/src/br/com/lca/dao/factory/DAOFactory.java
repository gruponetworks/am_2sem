package br.com.lca.dao.factory;

import br.com.lca.dao.implementation.DespesaDAO;
import br.com.lca.dao.implementation.ProcessoDAO;
import br.com.lca.dao.implementation.TipoDespesaDAO;


public abstract class DAOFactory {
	
	public static DespesaDAO getDespesaDAO(){
		return new DespesaDAO();
	}
	
	public static TipoDespesaDAO getTipoDespesaDAO(){
		return new TipoDespesaDAO();
	}
	
	public static ProcessoDAO getProcessoDAO(){
		return new ProcessoDAO();
	}
}
