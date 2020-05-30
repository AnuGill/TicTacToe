package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameBean;

@WebServlet("/playController")
public class PlayController extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletContext context = getServletContext();
		GameBean game = (GameBean) context.getAttribute("game");
		char currentPlayer = game.getCurrentPlayer();
		try {
			int location = Integer.parseInt(request.getParameter("location"));
			Map<Integer, Character> matrix = game.getMatrix();
			if(matrix.get(location) == '-') {
				matrix.put(location, currentPlayer);
				game.markLocation(location, currentPlayer);
				currentPlayer = currentPlayer == 'O' ? 'X' : 'O';
				game.setCurrentPlayer(currentPlayer);
			}
		}
		catch(Exception e) {	
		}
		game.checkResults();
		request.getRequestDispatcher("GameBoard.jsp").forward(request, response);
	}
}
