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
		<h1>Listar Processos</h1>
		<c:if test="${not empty msg}">
			<div class="alert alert-success">
				${msg}
			</div>
		</c:if>
		<c:if test="${not empty erro}">
			<div class="alert alert-danger">
				${erro}
			</div>
		</c:if>
		<form action="produtoServlet" method="post">
		<fieldset>
		
			<!-- Campo que define a ação na serlvet -->
			<input type="hidden" name="acao" value="cadastrar">
			<div class="row">
			
				<!-- Labels -->	
				<div class="form-group col-md-4">
					<label for="nome">Nome do Cliente</label> 
					<input type="text" name="nomeDoCliente" class="form-control" id="nome" placeholder="Nome do Cliente" />
				
				<br>
				<class="form-group col-md-4">
					<label for="nr">Número do Processo</label>
					<input type="text" name="numeroDoProcesso" class="form-control" id="nr" placeholder="Número do Processo"/>
				<br>
				<div class="form-group col-md-4">
					<label for="ddt">Periodo</label>
					<input type="date" name ="date" class="form-control" id="ddtt"/>		
				</div>
				
				<div class="form-group col-md-4">
					<label for="ddt">até</label>
					<input type="date" name ="date" class="form-control" id="ddtt"/>
				</div>
				
			</div>
									
		</div>
			
			<!-- Botão -->
			<div class="form-group">
				<input type="submit" value="Buscar" class="btn btn-success"/>
			</div>
			
		</form>
	</div>
	</fieldset>
	
<!-- Início da tabela -->
<div class="container">
		<table class="table">
			<tr>
				<th>Número</th>
				<th>Descrição</th>
				<th>Clientes</th>
				<th>Ação</th>
			</tr>
			
			<tr>
				<td>001</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
				<td><input name="LHonor001" type="submit" value="Lançar Honorário" class="btn btn-success"/>
					<input name="CHonor001" type="submit" value="Consultar Honorário" class="btn btn-success"/>
				</td>
			</tr>
			
			<tr>
				<td>002</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
				<td><input name="LHonor002" type="submit" value="Lançar Honorário" class="btn btn-success"/>
					<input name="CHonor002" type="submit" value="Consultar Honorário" class="btn btn-success"/>
				</td>
			</tr>
			
			<tr>
				<td>003</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
				<td><input name="LHonor003" type="submit" value="Lançar Honorário" class="btn btn-success"/>
					<input name="CHonor003" type="submit" value="Consultar Honorário" class="btn btn-success"/>
				</td>
			</tr>
			
			<tr>
				<td>004</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
				<td><input name="LHonor004" type="submit" value="Lançar Honorário" class="btn btn-success"/>
					<input name="CHonor004" type="submit" value="Consultar Honorário" class="btn btn-success"/>
				</td>
			</tr>
			 			
		</table>
	</div>
</body>
</html>


