package com.example.listener;

import javax.servlet.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.example.model.League;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Application Lifecycle Listener implementation class LeagueListListener
 *
 */
@WebListener
public class LeagueListListener implements ServletContextListener {

    String str=null;
    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context=sce.getServletContext();
    	
    	List<League> l=new ArrayList<League>();
    	str=(String)context.getInitParameter("leaguesFile");
    	System.out.println(str);
    	String[] arr=str.split(",");
    	League newleague=new League(arr[0],Integer.parseInt(arr[1]),arr[2]);
    	l.add(newleague);
    	context.setAttribute("leaguelist", l);
    	
    	
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
        // TODO Auto-generated method stub
    	str=null;
    	System.out.println("context destryoed");
   }
	
}
