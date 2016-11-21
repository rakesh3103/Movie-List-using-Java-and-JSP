package com.java.Movies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Editedmovies
 */
@WebServlet("/Editedmovies")
public class Editedmovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String movies = "C:\\Users\\Rakesh\\MovieDym.txt";
		String[] watched = new String[50];
		String [] unwatched =  new String[50];
		int w=0, u=0;
		FileOutputStream out;
	     PrintStream prt;
	     String newMovie = request.getParameter("movie");
         String action = request.getParameter("Action");
         System.out.println(action);
         System.out.println(newMovie);
         if(action!=null && action.equals("true") && newMovie!=null){
        	 newMovie = "*"+newMovie;
        	 System.out.println("In if loop");
        	 
         }
         System.out.println(newMovie);
         if(newMovie!=null){
        	 
    	     FileWriter fileWriter = new FileWriter(movies, true);
    	     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    	     bufferedWriter.write(newMovie);
    	     System.out.println(newMovie);
    	     bufferedWriter.close();
        	 
         }
	     
	     
		try{
		     FileInputStream fStream = new FileInputStream(movies);
	         BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
	         int h=3;
	         while(in.ready()){
	        	 String line = in.readLine();
	        	 if( h !=0){
	        		line = "";
	        		 h--;
	        
	         
	        	 }
	        	 if(!line.isEmpty()){
	            	 //System.out.println(line);
	            	 
	            	 int length = line.length();
	            	
	            	 
	            	 //line = line.substring(0, length-12);
	            	 //System.out.println(line);
	             char x = line.charAt(0);
	             if(x == '*' ){
	            	 //System.out.println("This movie is watched: " + line);
	            	 
	            	 watched[w] = line;
	            	 w++;
	             }
	             else{
	            	 unwatched[u] = line;
	            	 u++;
	             //System.out.println("This movie is NOT watched: " + line);
	             }
	             }
	             }
	    	     }catch(IOException e){System.out.println("Error: " + e);
	    	     }
		String[] wDelete = new String[w];
		String[] unwDelete = new String[u];
		String[] wModify = new String[w];
		String[] unwModify = new String[u];
		//response.getWriter().append("In Edited class");
		out = new FileOutputStream(movies);
		prt = new PrintStream(out);
		prt.println("*** Updated on: "+ new Date().toString()+" ***\n");
		prt.println("*** Created by "+WebClass.class.getName()+" ***\n\n");
	for(int i = 0 ; i<w; i++){
		
		// newMovie[i] = request.getParameter("Watched");
		
          wDelete[i] = request.getParameter("wDelete["+i+"]");
          wModify[i] = request.getParameter("Watched["+i+"]");
          if(wModify[i] == null){
        	  //response.getWriter().append("\nMovies to move to unwatched list are: " + watched[i]);
        	  watched[i] = watched[i].substring(1);
          }
          
          if(wDelete[i]!= null){
        	  //response.getWriter().append("\nMovies to delete in watched list are: " + watched[i]);
        	  watched[i]= "";
          }
          
          
          prt.println(watched[i]);
        }
	//response.getWriter().append("\n\n");
	prt.println();
	prt.println();
	
	for(int j = 0 ; j<u; j++){
		//System.out.println("newMovie is :" + newMovie[i]);
		unwModify[j] = request.getParameter("unWatched["+j+"]");
		unwDelete[j] = request.getParameter("unwDelete["+j+"]");
		if(unwModify[j] != null){
      	 // response.getWriter().append("\nMovies to move to watched list are: " + unwatched[j]);
      	unwatched[j] = "*"+unwatched[j];
        }
		if(unwDelete[j]!= null){
      	 // response.getWriter().append("\nMovies to delete in unwatched list are: " + unwatched[j]);
      	  unwatched[j]= "";
        }
		prt.println(unwatched[j]);
		//response.getWriter().append("\nUnWatched Delete["+j+"] is :" + unwDelete[j]);
	}
	response.sendRedirect("WebClass");
	
	prt.close(); 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
