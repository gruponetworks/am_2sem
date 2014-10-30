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

@WebServlet("/processoServlet")
public class ProcessoServlet extends HttpServlet {

	private static final long serialVersionUID = -419799537927220260L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {

		String paginaRetorno = request.getParameter("paginaRetorno");

		switch (request.getParameter("operacao")) {

		case "listarProcesso":
			listarProcesso(request);
			break;
		case "verificaBloqueio":
			break;
		case "verificaEncerrado":
			break;
		}

		try {
			request.getRequestDispatcher(paginaRetorno).forward(request, response);
		} catch (ServletException excecao) {
			excecao.printStackTrace();
		} catch (IOException excecao) {
			excecao.printStackTrace();
		}
	}

	private void listarProcesso(HttpServletRequest request) {
		try {
			String numeroProcesso = request.getParameter("numeroDoProcesso");
			String nomeCliente = request.getParameter("nomeDoCliente");
			String periodoDataInicial = request.getParameter("dataDe");
			String periodoDataFinal = request.getParameter("dataAte");

			ArrayList<Processo> retornoBusca = new ArrayList<Processo>();

			if (isNotNullOrEmpty(numeroProcesso)) {

				retornoBusca = ProcessoBO.getInstance()
						.listarProcessoPorNumero(
								new Processo(Integer.parseInt(numeroProcesso)));

			} else if (isNotNullOrEmpty(nomeCliente)) {

				retornoBusca = ProcessoBO.getInstance()
						.listarProcessoPorCliente(
								new Cliente(nomeCliente.trim()));

			} else if (isNotNullOrEmpty(periodoDataInicial)
					&& isNotNullOrEmpty(periodoDataFinal)) {

				Calendar dataInicial = Calendar.getInstance();
				Calendar dataFinal = Calendar.getInstance();

				SimpleDateFormat formatoData = new SimpleDateFormat(
						"dd/MM/yyyy");

				dataInicial.setTime(formatoData.parse(periodoDataInicial));
				dataFinal.setTime(formatoData.parse(periodoDataFinal));

				retornoBusca = ProcessoBO.getInstance()
						.listarProcessoPorPeriodo(
								new Periodo(dataInicial, dataFinal));

			} else {
				request.setAttribute("mensagemErro",
						"Informe um número de processo, cliente ou período para busca.");
			}

			request.setAttribute("listaProcesso", retornoBusca);

		} catch (LcaExpection excecao) {
			request.setAttribute("mensagemErro", excecao.getMessage());
		} catch (NumberFormatException excecao) {
			request.setAttribute("mensagemErro",
					"Erro ao converter numérico, verifique os dados inseridos.");
		} catch (ParseException excecao) {
			request.setAttribute("mensagemErro",
					"Data Inválida, verifique os dados inseridos.");
		}
	}

	private boolean isNotNullOrEmpty(String string) {
		return !(string.equals(null) || string.isEmpty());
	}
}
