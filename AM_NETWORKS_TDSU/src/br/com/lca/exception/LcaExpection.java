package br.com.lca.exception;

/**
 * Classe utilizada para tratamento de todas exceções do sistema.
 * 
 */

public class LcaExpection extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7534533095724519967L;

	public LcaExpection(String descricaoExcecao) {
		super(descricaoExcecao);
	}
}
