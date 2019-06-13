package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.League;

/**
 * Servlet implementation class ListLeagueServlet
 */
@WebServlet({ "/ListLeagueServlet", "/list_leagues.view" })
public class ListLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<League> leagueList = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		 leagueList = new ArrayList<League>();
		 leagueList=(List<League>) getServletContext().getAttribute("leaguelist");
		 
		 
//		 leagueList.add( new League("World cup",2019,"summer"));
//		 leagueList.add( new League("Summer volley",2020,"winter"));
//		 leagueList.add(new League("Championship",2018,"spring"));
		 out.println("<html><head><title>The list of leagues</title></head><body><table border='1'><tr><th>Title</th><th>Year</th><th>Season</th></tr>");
		 
		 for(League l:leagueList) {
			 out.println("<tr><td>"+l.getTitle()+"</td><td>"+l.getYear()+"</td><td>"+l.getSeason()+"</td></tr>");
		 }
		 out.println("</table></body></html>");
	}


}
