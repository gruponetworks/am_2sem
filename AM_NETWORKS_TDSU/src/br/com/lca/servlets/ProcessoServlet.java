package br.com.lca.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
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
