package br.com.lca.dao.interfaces;

import java.util.List;
import br.com.lca.exception.LcaExpection;

public interface CRUD <T>{
	
	public List<T> obter(T parametros) throws LcaExpection;
	public boolean incluir(T parametros) throws LcaExpection;
	public boolean alterar(T parametros) throws LcaExpection;
	public boolean excluir(T parametros) throws LcaExpection;
}
