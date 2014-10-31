<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advocacia LCA</title>

<!-- Fun��o para calcular hora do advogado
<script type="text/javascript">

  function calcular(){
    var qtdehoras = parseFloat(document.form1.qtdeDeHoras.value);
    var valorhora = parseFloat(document.form1.valorHora.value);
    window.alert(qtdehoras * valorhora);
  }

</script>
 -->
 
 
</head>
<body>
<!-- Adicionar o menu.. -->
	<%@ include file="header.jsp"%>
	
	<div class="container">
		<h1>Lan�ar Honor�rios</h1>
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
				<th>N�mero</th>
				<th>Descri��o</th>
				<th>Cliente</th>
			</tr>
			
			<tr>
				<td>001</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
				<td>Lorem ipsum dolor sit amet, consectetur</td>
			</tr>
				
		</table>
	</div>
		
			<br>
			<!-- Campo que define a a��o na serlvet -->
			<input type="hidden" name="acao" value="cadastrar">
			<div class="row">
			
			<!-- Labels -->	
					<div class="form-group col-md-4">
					<label for="nomehonor">Nome do Honor�rio</label>
					<input type="text" name="nomeDoHonorario" class="form-control" id="nomehonor" placeholder="Nome do Honor�rio" />
					
				<br>
				<class="form-group col-md-4">
					<label for="datahonor">Data do Honor�rio</label>
					<input type="date" name ="dataDoHonorario" class="form-control" id="datahonor"/>		
				
				<br>
				<class="form-group col-md-4">
					<label for="qtdehoras">Quantidade de Horas</label>
					<input type="text" name="qtdeDeHoras" class="form-control" id="qtdehoras" placeholder="00:00"/>
				<br>
					
				<class="form-group col-md-4">
  					<label for="observhonor">Observa��es</label>
  					<textarea name="observacoes" class="form-control" cols="10" rows="5"  id="observhonor"></textarea> 
	
				<br>
				<!-- Bot�o -->
				<div class="form-group">
					<input type="submit" value="Salvar" class="btn btn-success"/>
				</div>

				<br><br><br><br>
								<class="form-group">
					<input type="submit" value="Listar Honor�rios" class="btn btn-success"/>
				<class="form-group">
					<input type="submit" value="Consultar Novo Honor�rio" class="btn btn-success"/>
				</div>
			</div>
				
				<!-- Caixa para fazer o c�lculo de horas
				<div class="form-group col-md-4">
					<label for="totalhonor">Total do Honor�rio</label>
					<input type="text" name="totalDoHonorario" class="form-control" id="totalhonor"/>
				</div>
				<br>
				
				--Calcular Horas do Advogado
				<div class="form-group col-md-4">
					<label for="valorhora">Valor Hora do Honor�rio</label>
					<input type="text" name="valorHora" class="form-control" id="valorhora"/>
				</div>
				 -->
		</form>

	</div>
</body>
</html>