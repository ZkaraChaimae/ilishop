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
    <title>Login | ilishop</title>
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
<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Vous avez un compte ? Coonectez-vous !</h2>
						<p>${Erreur}</p>
						<form action="ConnexionHandler" method="post">
							<input type="text" id="login" name="login" placeholder="E-mail/Telephone" />
							<input type="password" id="psd" name="psd" placeholder="Mot de passe" />
							<button type="submit" class="btn btn-default">Se connecter</button>
						</form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>Nouvel utilisateur</h2>
						<p>${CompteExistant}</p>
						<form action="InscriptionHandler" method="post">
							<input type="text" id="nom" name="nom" placeholder="Nom"/>
							<input type="text" id="prenom" name="prenom" placeholder="Prénom"/>
							<input type="text" id="tel" name="tel" placeholder="Telephone"/>
							<input type="email" id="email" name="email" placeholder="Email"/>
							<input type="text" id="adr" name="adr" placeholder="Adresse"/>
							<input type="text" id="ville" name="ville" placeholder="Ville"/>
							<input type="password" id="psd" name="psd" placeholder="Password"/>
							<button type="submit" class="btn btn-default">S'inscrire</button>
						</form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->


	
</body>
</html>