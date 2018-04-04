<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body>
	<p>${CompteExistant}</p>
	<form action="InscriptionHandler" method="post">
		<table border="1">
			<tr>
				<td>Nom</td>
				<td><input type="text" id="nom" name="nom"></td>
			</tr>
			<tr>
				<td>Prénom</td>
				<td><input type="text" id="prenom" name="prenom"></td>
			</tr>
			<tr>
				<td>Téléphone</td>
				<td><input type="text" id="tel" name="tel"></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" id="email" name="email"></td>
			</tr>
			<tr>
				<td>Addresse</td>
				<td><input type="text" id="adr" name="adr"></td>
			</tr>
			<tr>
				<td>Ville</td>
				<td><input type="text" id="ville" name="ville"></td>
			</tr>
			<tr>
				<td>Mot de passe</td>
				<td><input type="password" id="psd" name="psd"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="S'inscrire" ></td>
			</tr>
		</table>
	</form>
</body>
</html>