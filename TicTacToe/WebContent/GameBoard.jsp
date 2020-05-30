<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "model.GameBean"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

    
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
<h1 class="display-1 text-center">Tic-Tac-Toe</h1>
<br>

<c:if test = "${game.gameOver == true }">
	<c:if test="${game.gameDraw == true }">
		<h3 class="display-6 text-center">It's a Draw!</h3>
	</c:if>
	<c:if test="${game.gameDraw == false }">
		<h3 class="display-6 text-center">Congratulations Player ${game.winner} won!</h3>
	</c:if>
	<center><a class = "btn btn-primary" href = "newGame">Play Again?</a></center>
</c:if> 
<c:if test="${game.gameOver == false }">
	<h3 class="display-6 text-center">Player ${game.currentPlayer}'s Turn</h3>
</c:if>
<% GameBean game = (GameBean) getServletContext().getAttribute("game"); %> 
<br>
<div class="row">
	<div class="col-sm-6 offset-sm-3">
		<table class="table table-bordered table-board">
			<tr>
				<td>
					<a href="playController?location=0">
						${game.matrix[(0).intValue()]}
					</a>
				</td>
				<td>
					<a href="playController?location=1">
						${game.matrix[(1).intValue()]}
					</a>
				</td>
				<td>
					<a href="playController?location=2">
						${game.matrix[(2).intValue()]}
					</a>
				</td>
			</tr>
			
			<tr>
				<td>
					<a href="playController?location=3">
						${game.matrix[(3).intValue()]}
					</a>
				</td>
				<td>
					<a href="playController?location=4">
						${game.matrix[(4).intValue()]}
					</a>
				</td>
				<td>
					<a href="playController?location=5">
						${game.matrix[(5).intValue()]}
					</a>
				</td>
			</tr>
			
			<tr>
				<td>
					<a href="playController?location=6">
						${game.matrix[(6).intValue()]}
					</a>
				</td>
				<td>
					<a href="playController?location=7">
						${game.matrix[(7).intValue()]}
					</a>
				</td>
				<td>
					<a href="playController?location=8">
						${game.matrix[(8).intValue()]}
					</a>
				</td>
			</tr>
		</table>
	</div>	
</div>
	
</div>
</body>
</html>