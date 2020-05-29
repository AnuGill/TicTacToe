package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GameBean;

@WebServlet("/newGame")
public class NewGameController extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		GameBean game = new GameBean();
		ServletContext ctx = getServletContext();
		ctx.setAttribute("game", game);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		GameBean game = (GameBean) ctx.getAttribute("game");
		if(game == null) {
			GameBean newGame = new GameBean();
			ctx.setAttribute("game", newGame);
		}
		request.getRequestDispatcher("gameController").forward(request, response);
	}

}
