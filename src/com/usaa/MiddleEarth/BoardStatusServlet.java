package com.usaa.MiddleEarth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class BoardStatusServlet extends HttpServlet {
	public GameController gameController;

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public void init() {
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("action") != null ) {
			switch(request.getParameter("action")) {

			case ("start"):
				int numberOfPlayers = 2;
				
				if(request.getParameter("pNum") != null) {
					numberOfPlayers = Integer.parseInt(request.getParameter("pNum"));
				}
				
				gameController = new GameController();
				String start = gameController.newGame(numberOfPlayers);
			response.getWriter().append(start);
			response.getWriter().flush();
				break;


			case ("roll"):
				String moves = gameController.gamePlay();
			response.getWriter().append(moves);
			response.getWriter().flush();
			break;
			
			default:
				response.getWriter().append("No Request made!");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
