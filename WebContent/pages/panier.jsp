<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="dao.LignePanier"%>
<%@page import="dao.Panier"%>
<%@page import="java.util.Iterator"%>
<%@page import="dao.Produit"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Panier | ilishop</title>
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
<%@ include file="header.jsp" %>
<form action="PanierHandler" method="post">
<section id="cart_items">
		<div class="container">
		
		
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="<%= request.getContextPath() %>/index">Home</a></li>
				  <li class="active">Mon Panier</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Produit</td>
							<td class="description"></td>
							<td class="price">Prix</td>
							<td class="quantity">Quantité</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					
					<% Panier panier = (Panier) request.getSession().getAttribute("panier");
						if(panier != null)	{
							int total = 0; 
							double sousTotal = 0;
							for(Iterator<LignePanier> it = panier.getLignesPanier().iterator(); it.hasNext();)	{
							LignePanier lp = (LignePanier) it.next(); 
							sousTotal = lp.getQte() * lp.getProduit().getPrix();
							total += sousTotal;
							%>
					
						<tr>
							<td class="cart_product">
								<a href=""><img src="<%= request.getContextPath() %>/pages/images/cart/one.png" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a ><%= lp.getProduit().getLibelle() %></a></h4>
								<p><%= lp.getProduit().getDescription() %></p>
							</td>
							<td class="cart_price">
								<p><%= lp.getProduit().getPrix() %></p>
							</td>
							<td><input class="cart_quantity_input" id="<%= lp.getProduit().getIdProduit() %>"
								name="<%= lp.getProduit().getIdProduit() %>" type="number" min="1"
								max="<%= lp.getProduit().getQte() %>" value="<%= lp.getQte() %>">
							</td>
							<td class="cart_total">
								<p class="cart_total_price">MAD <%= sousTotal %></p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="PanierHandler?id=<%=lp.getProduit().getIdProduit()%>&action=remove"><i class="fa fa-times"></i></a>
							</td>
						</tr>

				<% } %>
						
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->
	
	<section id="do_action">
		<div class="container">
			<div class="row">
				
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Sous-Total <span>MAD <%= total %></span></li>
							<li>Couts de transport <span>Gratuits</span></li>
							<li>Total <span>MAD <%= total %></span></li>
						</ul>
							<input class="btn btn-default check_out" type="submit" value="Commander">
					</div>
				</div>
			</div>
		</div>
		<% } %>
	</section><!--/#do_action-->
</form>
</body>
</html>