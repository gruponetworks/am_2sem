<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advocacia LCA</title>
</head>
<body>
<!-- Adicionar o menu.. -->
	<%@ include file="header.jsp"%>
	
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
		
		<!-- Tabela com os dados do cliente -->
		<div class="container">
		<table class="table">
			<tr>
				<th>Número</th>
				<th>Descrição</th>
				<th>Clientes</th>
			</tr>
			
			<tr>
				<td>001</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
			</tr>
				
		</table>
	</div>
		
		
		
		<fieldset>
		
			<!-- Campo que define a ação na serlvet -->
			<input type="hidden" name="acao" value="cadastrar">
			<div class="row">
			
				<!-- Labels -->	
				<div class="form-group col-md-4">
					<label for="nomedesp">Nome da Despesa</label> 
					<input type="text" name="nomeDaDespesa" class="form-control" id="nomedesp" placeholder="Nome da Despesa" />
				<br>
				<class="form-group col-md-4">
					<label for="datadesp">Data da Despesa</label>
					<input type="date" name ="dataDaDespesa" class="form-control" id="datadesp"/>		
				
				<br>
				<class="form-group col-md-4">
					<label for="valordesp">Valor da Despesa</label>
					<input type="text" name="valorDaDespesa" class="form-control" id="valordesp" placeholder="Valor da Despesa"/>
				<br>
				<class="form-group col-md-4">
					<label for="observdesp">Observações</label>
					<input type="text" name="observacoesDesp" class="form-control" id="observdesp" placeholder="Observações"/>
			
				<!-- Botão -->
				<class="form-group">
					<input type="submit" value="Salvar" class="btn btn-success"/>
			</div>
		</div>
		</form>
		
	</div>
	</fieldset>
	
<!-- Início da tabela -->



</body>
</html>