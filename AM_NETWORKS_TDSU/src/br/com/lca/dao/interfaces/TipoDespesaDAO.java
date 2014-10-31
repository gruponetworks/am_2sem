package br.com.lca.dao.interfaces;

import java.util.ArrayList;

import br.com.lca.beans.despesa.TipoDespesa;
import br.com.lca.exception.LcaExpection;

public interface TipoDespesaDAO {
	public ArrayList<TipoDespesa> obterListaTipoDespesa() throws LcaExpection;
}
