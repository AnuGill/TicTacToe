<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "model.GameBean"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tic Tac Toe</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style type="text/css">
body{
	background-color: black;
	color: white;
}
table.table-board tr td {
	height: 6rem;
	width: 6rem;
	font-size: 6rem;
	text-align: center;
}

table.table-board tr td a {
	text-decoration: none;
}
</style>
</head>
<body>
<div class="container">
<% GameBean game = (GameBean) getServletContext().getAttribute("game"); %>

<h1 class="display-1 text-center">Tic-Tac-Toe</h1>
<br>

<%
	if(game.isGameOver()){
		if(game.isGameDraw()){ %>
			<h3 class="display-6 text-center">It's a Draw!</h3>
		<%
		} 
		else{
		 %>
			<h3 class="display-6 text-center">Congratulations Player <%= game.getWinner() %> won!</h3>
	<%
		} %>
		<center><a class = "btn btn-primary" href = "newGame">Play Again?</a></center>
		<% } else{ %>
		<h3 class="display-6 text-center">Player <%= game.getCurrentPlayer()%>'s Turn</h3>
		<%} %>
<br>
<div class="row">
	<div class="col-sm-6 offset-sm-3">
		<table class="table table-bordered table-board">
			<tr>
				<td>
					<a href="playController?location=0">
						<%= game.getMatrix().get(0) %>
					</a>
				</td>
				<td>
					<a href="playController?location=1">
						<%= game.getMatrix().get(1) %>
					</a>
				</td>
				<td>
					<a href="playController?location=2">
						<%= game.getMatrix().get(2) %>
					</a>
				</td>
			</tr>
			
			<tr>
				<td>
					<a href="playController?location=3">
						<%= game.getMatrix().get(3) %>
					</a>
				</td>
				<td>
					<a href="playController?location=4">
						<%= game.getMatrix().get(4) %>
					</a>
				</td>
				<td>
					<a href="playController?location=5">
						<%= game.getMatrix().get(5) %>
					</a>
				</td>
			</tr>
			
			<tr>
				<td>
					<a href="playController?location=6">
						<%= game.getMatrix().get(6) %>
					</a>
				</td>
				<td>
					<a href="playController?location=7">
						<%= game.getMatrix().get(7) %>
					</a>
				</td>
				<td>
					<a href="playController?location=8">
						<%= game.getMatrix().get(8) %>
					</a>
				</td>
			</tr>
		</table>
	</div>	
</div>
	
</div>
</body>
</html>