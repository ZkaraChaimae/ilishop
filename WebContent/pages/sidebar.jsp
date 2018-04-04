				<%@page import="java.util.List"%>
<%@page import="dao.Produit"%>
<%@page import="dao.Categorie"%>
<%@page import="java.util.Iterator"%>
<% List<Categorie> categories = (List<Categorie>) request.getAttribute("categories"); %>
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->							
							
							<% for(Iterator<Categorie> itCat = categories.iterator(); itCat.hasNext();) { 
									Categorie cat = itCat.next();
							%>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="IndexHandler?id=<%=cat.getId_cat()%>&action=categorie"><%= cat.getName() %></a></h4>
								</div>
							</div>
						<% 	} %>
						</div><!--/category-products-->
					</div>