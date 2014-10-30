<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Produto</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

<div class="container">
	<h2>Atualização de Produtos</h2>
	<form action="produtoServlet" method="post">
		<!-- Campo que define a ação na serlvet -->
		<input type="hidden" name="acao" value="editar">
		<input type="hidden" name="codigo" value="${p.codigo}">
		<div class="row">
			<div class="form-group col-md-4">
				<label for="desc">Descrição</label> 
				<input type="text" name="descricao" 
					class="form-control" id="desc" 
					value="${p.descricao}"/>
			</div>
			<div class="form-group col-md-4">
				<label for="preco">Preço</label>
				<input type="text" name="preco"
					class="form-control" id="preco"
					value="${p.preco}"/>
			</div>
			<div class="form-group col-md-4">
				<label for="qtd">Quantidade</label>
				<input type="text" name="quantidade"
					class="form-control" id="qtd"
					value="${p.estoque}"/>
			</div>
		</div>
		<div class="row">	
			<div class="form-group col-md-4">
				<label for="cat">Categoria</label>
				<select name="categoria" id="cat" 
					class="form-control">
					<option>Selecione</option>
					<option>Brinquedos</option>
					<option>Calçados</option>
					<option>Eletrônicos</option>
					<option>Telefonia</option>
					<option>Vestuário</option>
				</select>
			</div>
			<div class="form-group col-md-4">
				<label for="subc">Sub-Categoria</label>
				<select name="subcategoria" id="subc"
					class="form-control">
					<option>Selecione</option>
				</select>
			</div>	
			<div class="form-group col-md-4">
				<label for="data">Data Cadastro</label>
				<input type="text" name="data" id="data"
					class="form-control" readonly
					value="<fmt:formatDate 
							value="${p.dataCadastro.time}"
							pattern="dd/MM/yyyy"/>">
			</div>			
				
		</div>
		<div class="form-group">
			<input type="submit" value="Atualizar" 
					class="btn btn-success"/>
		</div>
	</form>
</div>

</body>
</html>



