package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.League;

/**
 * Servlet implementation class AddLeagueServlet
 */
@SuppressWarnings("serial")
@WebServlet("/add_league.do")
public class AddLeagueServlet extends HttpServlet {
	private String title;
	private int year;
	private String season;
	private List<String> errMsgs=null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLeagueServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processResponse(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processResponse(request, response);
	}

	protected void processResponse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		errMsgs = new LinkedList<String>();
		String tempYear = request.getParameter("year");
		try{
			year=Integer.parseInt(tempYear);
		}
		catch(Exception e) {
			errMsgs.add("year cant be empty");
		
			
		}
		season = request.getParameter("season");
		if(season.equals("Select")) {
			errMsgs.add("select a season");
		}
		
		title = request.getParameter("title");
		if(title.length()<=0) {
			errMsgs.add("Title field not empty");
		}

		if (!errMsgs.isEmpty()) {
			request.setAttribute("ERROR", errMsgs);

			RequestDispatcher view = request.getRequestDispatcher("/addLeagueAlternate.view");
			view.forward(request, response);

		}

		else {
			List<League> l=(List<League>) getServletContext().getAttribute("leaguelist");
			l.add(new League(title,year, season));
			
			//request.setAttribute("SUCCESS", new League(title,year, season));
			RequestDispatcher view = request.getRequestDispatcher("/list_leagues.view");
			view.forward(request, response);
		}

	}

}
