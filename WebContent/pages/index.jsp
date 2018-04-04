<%@page import="dao.LignePanier"%>
<%@page import="dao.Panier"%>
<%@page import="java.util.Iterator"%>
<%@page import="dao.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | ilishop</title>
    <link href="<%= request.getContextPath() %>/pages/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/pages/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/pages/css/prettyPhoto.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/pages/css/price-range.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/pages/css/animate.css" rel="stylesheet">
	<link href="<%= request.getContextPath() %>/pages/css/main.css" rel="stylesheet">
	<link href="<%= request.getContextPath() %>/pages/css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="<%= request.getContextPath() %>/pages/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%= request.getContextPath() %>/pages/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%= request.getContextPath() %>/pages/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%= request.getContextPath() %>/pages/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%= request.getContextPath() %>/pages/images/ico/apple-touch-icon-57-precomposed.png">

</head>
<body>
<% List<Produit> produits = (List<Produit>) request.getAttribute("produits"); %>
<%@ include file="header.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-sm-3">
			<%@ include file="sidebar.jsp" %>
		</div>
		
		<div class="col-sm-9 padding-right">
			<div class="features_items"><!--features_items-->
				<h2 class="title text-center">Produits</h2>
				<% for(Iterator<Produit> it = produits.iterator(); it.hasNext();)	{
								Produit produit = (Produit) it.next(); %>
					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="<%= request.getContextPath() %>/pages/images/home/product1.jpg" alt="" />
										<h2>MAD <%= produit.getPrix() %></h2>
											<p><%= produit.getDescription() %> - En reste <%= produit.getQte() %> en stock</p>
											<a href="IndexHandler?id=<%=produit.getIdProduit()%>&action=addToCart" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
								</div>
								<div class="product-overlay">
									<div class="overlay-content">
										<h2>MAD <%= produit.getPrix() %></h2>
											<p><%= produit.getLibelle() %></p>
												<a href="IndexHandler?id=<%=produit.getIdProduit()%>&action=addToCart" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<% } %>
			</div><!--features_items-->
		</div>
	</div>
</div>	

</body>
</html>