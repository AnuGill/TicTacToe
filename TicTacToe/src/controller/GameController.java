package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameBean;


@WebServlet("/gameController")
public class GameController extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher rd;
		GameBean game = (GameBean) context.getAttribute("game");
		if(game.isGameOver()) {
			context.removeAttribute("game");
			rd = request.getRequestDispatcher("newGame");
		}
		else {
			rd = request.getRequestDispatcher("playController");
		}
		rd.forward(request, response);
	}

}
