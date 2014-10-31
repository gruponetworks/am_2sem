package br.com.lca.dao.interfaces;

import java.util.ArrayList;

import br.com.lca.beans.honorario.Honorario;
import br.com.lca.beans.processo.Processo;
import br.com.lca.exception.LcaExpection;

public interface HonorarioDAO extends CRUD<Honorario>{
	public ArrayList<Honorario> listarHonorarioPorNumero(Honorario honorario) throws LcaExpection;
}
