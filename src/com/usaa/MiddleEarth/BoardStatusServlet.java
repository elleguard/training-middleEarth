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
		gameController = new GameController();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		switch(request.getParameter("action")) {

		case ("start"):
			response.getWriter(GameController.newGame());
			break;


		case ("roll"):
			String moves = gameController.gamePlay();
		response.getWriter().append(moves);
		response.getWriter().flush();
		break;
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
