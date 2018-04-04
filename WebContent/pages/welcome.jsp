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
<title>welcome</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>Libelle</th>
			<th>Quantité</th>
		</tr>
		<%
			Panier panier = (Panier) request.getSession().getAttribute("panier");
			if(panier != null)	{
				for(Iterator<LignePanier> it = panier.getLignesPanier().iterator(); it.hasNext();)	{
					LignePanier lp = (LignePanier) it.next();
		%>
		<tr>
			<td><%=lp.getProduit().getLibelle()%></td>
			<td><%=lp.getQte()%></td>
		</tr>
		<%
			}
			}
		%>
	</table>

</body>
</html>