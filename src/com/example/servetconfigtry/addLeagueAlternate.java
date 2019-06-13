package com.example.servetconfigtry;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addLeagueAlternate
 */
@WebServlet(
		urlPatterns = { 
				"/addLeagueAlternate", 
				"/addLeagueAlternate.view"
		}, 
		initParams = { 
				@WebInitParam(name = "season", value = "Select,Summer,Winter,Spring")
		})
public class addLeagueAlternate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String seasonList=null;
	private String[] seasonArr;
       
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		seasonList=config.getInitParameter("season");
		seasonArr=seasonList.split(",");
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public addLeagueAlternate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		List<String> l=(List<String>)request.getAttribute("ERROR");
		if(!(l==null)) {
			out.println("<font color='red'>Please correct the errors:</font><br/>");
			for(String s:l) {
				out.println("<font color='red'>"+s+"</font><br/>");
			}
		}
		//out.println("<link rel=\"stylesheet\" href=\"./WebContent/css/addLeagueAlternate.css\">");
		out.println("<form action='add_league.do' method='post'>");
		out.println("Title <input type='text' name='title'><br/>");
		out.println("Year <input type='text' name='year'><br/>");
		out.println("Season <select name='season'>");
		for(String s:seasonArr) {
			out.println("<option value="+s+">"+s+"</option>");
		}
		out.println("</select><br/>");
		
		out.println("<input type='submit' value='add league'></form>");
		
		
	}
}
