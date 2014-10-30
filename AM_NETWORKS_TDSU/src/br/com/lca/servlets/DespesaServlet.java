package br.com.lca.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/despesaServlet")
public class DespesaServlet extends HttpServlet{

	private static final long serialVersionUID = 1638518602436894349L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {

		String paginaRetorno = request.getParameter("paginaRetorno");

		switch (request.getParameter("acao")) {

		case "listarDespesa":
			break;
		case "lancarDespesa":
			break;
		case "editarDespesa":
			break;
		case "exluirDespesa":
			break;
		}

		try {
			request.getRequestDispatcher(paginaRetorno).forward(request,
					response);
		} catch (ServletException excecao) {
			excecao.printStackTrace();
		} catch (IOException excecao) {
			excecao.printStackTrace();
		}
	}
}
