package com.usaa.MiddleEarth;

import java.util.ArrayList;

import javax.servlet.http.Cookie;

public class CookieJar {
	private ArrayList<Cookie> cookies = new ArrayList<Cookie>();
	private ArrayList<GameController> gameControllers = new ArrayList<GameController>();

	public CookieJar() {
		// TODO Auto-generated constructor stub
	}
	
	public void addCookie(Cookie cookie,GameController game) {
		cookies.add(cookie);
	}
	
	public boolean hasCookie(Cookie cookie) {
		if(cookies.contains(cookie)) {
			return true;
		}
		
		return false;
	}
	
	public GameController GetGameByCookie(Cookie cookie) {
		for(int i = 0; i < cookies.size(); i++ ) {
			if(cookie == cookies.get(i)) {
				return gameControllers.get(i);
			}
		}
		
		GameController game = new GameController();
		
		gameControllers.add(game);
		cookies.add(cookie);
		
		return game;
 	}

}
