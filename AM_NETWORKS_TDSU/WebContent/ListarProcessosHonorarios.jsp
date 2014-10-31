<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Advocacia LCA</title>
<%@ include file="header.jsp"%>
</head>
<body>

	<!-- Adicionar o menu.. -->
	<%@ include file="menu.jsp"%>

	<div class="container">
		<h1>Listar Processos Honorários</h1>
		<c:if test="${not empty mensagemErro}">
			<div class="alert alert-danger">${mensagemErro}</div>
		</c:if>
		<fieldset>
			<form action="processoServlet" method="post">
				<div class="panel panel-default">
					<div class="panel-body">

						<!-- Campo que define a ação na serlvet -->
						<input type="hidden" name="paginaRetorno"
							value="ListarProcessosHonorarios.jsp"> <input
							type="hidden" name="acao" value="listarProcesso">
						<div class="row">
							<div class="form-group col-md-4">
								<label for="nr">Número do Processo</label> <input type="text"
									name="numeroDoProcesso" class="form-control" id="nr"
									placeholder="Número do Processo" /> <br> <label
									for="nome">Nome do Cliente</label> <input type="text"
									name="nomeDoCliente" class="form-control" id="nome"
									placeholder="Nome do Cliente" /> <br>

								<div>
									<label for="dataInicio">Período</label> <input type="date"
										name="dataDe" class="form-control" id="dataInicio" /> <label
										for="dataFim">até</label> <input type="date" name="dataAte"
										class="form-control" id="dataFim" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<input type="submit" value="Buscar" class="btn btn-success" />
				</div>
			</form>

		</fieldset>
	</div>
	<br>
	<br>
	<div class="container">
		<table class="table">
			<tr>
				<th>Número</th>
				<th>Descrição</th>
				<th>Clientes</th>
				<th>Ação</th>
			</tr>

			<c:forEach var="processo" items="${listaProcesso}">
				<tr>
					<td>${processo.codigo}</td>
					<td>${processo.descricao}</td>
					<td>${processo.cliente.nome}</td>
					<td><c:url value="honorarioServlet" var="lancarHonorario">
							<c:param name="acao" value="lancarHonorario" />
							<c:param name="codigoProcesso" value="${processo.codigo}" />
							<c:param name="nomeCliente" value="${processo.cliente.nome}"></c:param>
						</c:url> <a href="${lancarHonorario}"
						onclick="return confirm('Tem certeza?')" class="btn btn-default">
							Lançar Honorário </a> <c:url value="honorarioServlet"
							var="listarHonorario">
							<c:param name="acao" value="listarHonorario" />
							<c:param name="codigoProcesso" value="${processo.codigo}" />
						</c:url> <a href="${listarHonorario}" class="btn btn-default">
							Consultar Honorário </a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>


