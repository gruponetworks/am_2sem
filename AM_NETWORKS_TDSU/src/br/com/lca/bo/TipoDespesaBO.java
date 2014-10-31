package br.com.lca.bo;

import java.util.ArrayList;

import br.com.lca.beans.despesa.TipoDespesa;
import br.com.lca.dao.factory.DAOFactory;
import br.com.lca.dao.interfaces.TipoDespesaDAO;
import br.com.lca.exception.LcaExpection;

public class TipoDespesaBO {
	
	public static TipoDespesaBO INSTANCE;

	private TipoDespesaBO() {

	}

	public static TipoDespesaBO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new TipoDespesaBO();
		}
		return INSTANCE;
	}
	
	public ArrayList<TipoDespesa> obterListaTipoDespesa() throws LcaExpection{
		TipoDespesaDAO tipoDespesaDAO = DAOFactory.getTipoDespesaDAO();
		return tipoDespesaDAO.obterListaTipoDespesa();
	}
}
