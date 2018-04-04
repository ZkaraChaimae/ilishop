<header id="header"><!--header-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.html"><img src="<%= request.getContextPath() %>/pages/images/home/logo.png" alt="" /></a>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<% if(request.getSession().getAttribute("compte") == null) { %>
									<li><a href="<%= request.getContextPath() %>/Connexion"><i class="fa fa-user"></i> Se connecter</a></li>
								<% } else { %>
									<li><a href="<%= request.getContextPath() %>/Deconnexion"><i class="fa fa-user"></i> Se deconnecter</a></li>
								<% } %>
								<li><a href="<%= request.getContextPath() %>/Panier"><i class="fa fa-shopping-cart"></i> Panier</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->