package br.com.lca.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lca.beans.processo.Cliente;
import br.com.lca.beans.processo.Periodo;
import br.com.lca.beans.processo.Processo;
import br.com.lca.bo.ProcessoBO;
import br.com.lca.exception.LcaExpection;

@WebServlet("/honorarioServlet")
public class HonorarioServlet extends HttpServlet {

	private static final long serialVersionUID = -3572841073817401522L;

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

		case "listarHonorario":
			listarHonorario(request);
			break;
		case "lancarHonorario":
			break;
		case "editarHonorario":
			break;
		case "exluirHonorario":
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
	
	private void listarHonorario(HttpServletRequest request) {
		try {
			String numeroProcesso = request.getParameter("numeroDoProcesso");

			ArrayList<Processo> retornoBusca = new ArrayList<Processo>();

			if (isNotNullOrEmpty(numeroProcesso)) {

				retornoBusca = ProcessoBO.getInstance()
						.listarProcessoPorNumero(
								new Processo(Integer.parseInt(numeroProcesso)));
			} else {
				request.setAttribute("mensagemErro",
						"Informe um número de processo.");
			}

			request.setAttribute("listaHonorario", retornoBusca);

		} catch (LcaExpection excecao) {
			request.setAttribute("mensagemErro", excecao.getMessage());
		} catch (NumberFormatException excecao) {
			request.setAttribute("mensagemErro",
					"Erro ao converter numérico, verifique os dados inseridos.");
		}
	}
	
	private boolean isNotNullOrEmpty(String string) {
		return !(string.equals(null) || string.trim().isEmpty());
	}

}
