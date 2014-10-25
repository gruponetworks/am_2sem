package br.com.lca.bo;

public class ProcessoBO {
	
	public static ProcessoBO instance;

	private ProcessoBO() {

	}

	public static ProcessoBO getInstace() {

		if (instance.equals(null)) {
			instance = new ProcessoBO();
		}
		return instance;
	}
}
