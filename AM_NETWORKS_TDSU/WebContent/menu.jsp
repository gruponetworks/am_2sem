<div class="navbar navbar-default">
	<div class="navbar-header">
		<!-- Página inicial -->
		<a href="index.jsp" class="navbar-brand"></a>
	</div>
	<!-- Links do menu -->
	<ul class="nav navbar-nav">
		<li class="dropdown">
			<a href="#" class="dropdown-toggle"	
			data-toggle="dropdown">
				Despesas <span class="caret"></span>
			</a>
			
			<ul class="dropdown-menu">
				<li><a href="cadastro-produto.jsp">Lançar Despesas</a></li>
				<li><a href="produtoServlet?acao=listar">Consultar Despesas</a></li>
			</ul>
		</li>		
	</ul>

	<!-- Links do menu -->
	<ul class="nav navbar-nav">
		<li class="dropdown">
			<a href="#" class="dropdown-toggle"	
			data-toggle="dropdown">
				Honorários <span class="caret"></span>
			</a>
			<ul class="dropdown-menu">
				<li><a href="cadastro-produto.jsp">Lançar Honorários</a></li>
				<li><a href="produtoServlet?acao=listar">Consultar Honorários</a></li>
			</ul>
		</li>		
	</ul>
</div>