package com.usaa.MiddleEarth;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class BoardStatusServlet extends HttpServlet {
	public GameController gameController;
	
	public CookieJar cookieJar = new CookieJar();

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public void init() {
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random R = new Random();
		
		boolean hasSessionCookie = false;
		for(Cookie cookie : request.getCookies()) {
			System.out.println(cookie.getName());
			if(cookie.getName().equals("Session")) {
				hasSessionCookie = true;
			}
		}
		
		if(!hasSessionCookie) {
			Cookie cookie = new Cookie("Session",R.nextInt() % 100000000 + "");
			response.addCookie(cookie);
		}
		
		if(request.getParameter("action") != null ) {
			switch(request.getParameter("action")) {

			case ("start"):
				
				int numberOfPlayers = 2;
				
				if(request.getParameter("pNum") != null) {
					numberOfPlayers = Integer.parseInt(request.getParameter("pNum"));
				}
				
				GameController game = null;
				for(Cookie cookie : request.getCookies()) {
					if(cookie.getName().equals("Session")) {
						game = cookieJar.GetGameByCookie(cookie);
					}
				}
				
				gameController = game;
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
