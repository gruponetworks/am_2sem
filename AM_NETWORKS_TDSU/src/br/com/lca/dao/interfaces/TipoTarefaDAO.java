package br.com.lca.dao.interfaces;

import java.util.ArrayList;

import br.com.lca.beans.despesa.TipoDespesa;
import br.com.lca.beans.honorario.TipoTarefa;
import br.com.lca.exception.LcaExpection;

public interface TipoTarefaDAO {
	public ArrayList<TipoTarefa> obterListaTipoTarefa() throws LcaExpection;
}
