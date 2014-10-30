<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Produtos</title>
<%@ include file="header.jsp" %>

</head>
<body>
<%@ include file="menu.jsp" %>
	<div class="container">
		<h1>Lista de Produtos</h1>
		<table class="table">
			<tr>
				<th>Descrição</th>
				<th>Preço</th>
				<th>Estoque</th>
				<th>Categoria</th>
				<th>Data de Cadastro</th>
				<th></th>
			</tr>
			<c:forEach var="p" items="${produtos}">
				<tr>
					<td>${p.descricao}</td>
					<td>
						<fmt:formatNumber value="${p.preco}" type="currency"/>
					</td>
					<td>${p.estoque}</td>
					<td>${p.categoria}</td>
					<td>
						<!-- Formatar a data, .time -> recupera o Date -->
						<fmt:formatDate value="${p.dataCadastro.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<!-- Montando o destino do link -->
						<c:url value="produtoServlet" var="link">
							<c:param name="acao" value="excluir"/>
							<c:param name="codigo" value="${p.codigo}"/>
						</c:url>
						<a href="${link}" onclick="return confirm('Tem certeza?')" class="btn btn-danger">
							Apagar
						</a>
						<!-- Montando o destino do link de editar -->
						<c:url value="produtoServlet" var="link2">
							<c:param name="acao" value="carregar"/>
							<c:param name="codigo" value="${p.codigo }"/>
						</c:url>
						<a href="${link2}" class="btn btn-warning">
							Editar
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>



