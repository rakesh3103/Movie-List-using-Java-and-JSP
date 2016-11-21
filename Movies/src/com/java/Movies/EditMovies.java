package com.java.Movies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditMovies
 */
@WebServlet("/EditMovies")
public class EditMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditMovies() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String movies = "C:\\Users\\Rakesh\\MovieDym.txt";
        String newMovie = request.getParameter("movie");
        String action = request.getParameter("Action");
        if(action!=null && action.equals("true")){
       	 newMovie = "*"+newMovie;
       	 
        }
        if(newMovie!=null){
       	 
   	     FileWriter fileWriter = new FileWriter(movies, true);
   	     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
   	     bufferedWriter.write(newMovie);
   	     bufferedWriter.close();
       	 
        }
        
		
		String[] watched = new String[50];
		String [] unwatched =  new String[50];
		int w=0, u=0;
		FileOutputStream out;
	     PrintStream prt;
	     //out = new FileOutputStream(movies);

	     //prt = new  PrintStream(out);
	    // prt.println(newMovie);
	     //File f = new File(movies);
	     
	     
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
	            	 System.out.println(line);
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
	    	     //System.out.println("Watched Movies: \n");
	    	     
	    	     for(int k = 0; k<w ; k++){
	    	    	 for(int l = k+1; l<w; l++){
	    	    		 if(watched[l].compareToIgnoreCase(watched[k])<0){
	    	    			 String temp = watched[k];
	    	    			 watched[k] = watched[l];
	    	    			 watched[l] = temp;
	    	    		 }
	    	    	 }
	    	     }
	    	     
	    	    /* for(int i=0;i<w; i++){
	    	    	 System.out.println(watched[i] + "\n");
	    	     }*/
	    	     
	    	     for(int k = 0; k<u ; k++){
	    	    	 for(int l = k+1; l<u; l++){
	    	    		 if(unwatched[l].compareToIgnoreCase(unwatched[k])<0){
	    	    			 String temp = unwatched[k];
	    	    			 unwatched[k] = unwatched[l];
	    	    			 unwatched[l] = temp;
	    	    		 }
	    	    	 }
	    	     }
	    	    	 /*System.out.println("\n\n\nUnwatched Movies: \n");
	    		     for(int j=0;j<u; j++){
	    		    	 System.out.println(unwatched[j] + "\n");
	    		    	 
	    		    	 ArrayList<> v = new ArrayList<Name>();
	    	    	 
	    	     }*/
	    	     ArrayList<MovieDataBean> watchedArray = new ArrayList<MovieDataBean>();
	    	     ArrayList<MovieDataBean> unwatchedArray = new ArrayList<MovieDataBean>();
	    		     try {
	    		    	 System.out.println("Starting File write...");
	    		    	 
	    				out = new FileOutputStream(movies);
	    				prt = new PrintStream(out);
	    				prt.println("*** Updated on: "+ new Date().toString()+" ***\n");
	    				prt.println("*** Created by "+WebClass.class.getName()+" ***\n\n");
	    				for(int i=0;i<w; i++){
	    					Data myData = new Data(watched[i].substring(1));
	    					myData.MovieDetails();
	    					MovieDataBean myMovieBean = new MovieDataBean();
	    					String year =  myData.getYear();
	    					String IMDBrating = myData.getIMDB_Rating();
	    					String IMDBID = myData.getImdbID();
	    					String plot = myData.getPlot();
	    					String poster = myData.getPoster();
	    				    String runtime = myData.getRuntime() ;
	    				    if(runtime == null || runtime.equals("N/A")){
	    						runtime = "0000";
	    					}
	    					if(poster == null || poster.equals("N/A")){
	    						poster = "resources/NoImageAvailable.jpg";
	    					}
	    					if(plot == null){
	    						plot = "N/A";
	    					}
	    					if(IMDBID == null){
	    						IMDBID = "N/A";
	    						
	    					}
	    					if(year == null){
	    						year = "N/A";
	    						
	    					}
	    					if(IMDBrating == null){
	    						IMDBrating = "N/A";
	    						
	    					}
	    					myMovieBean.setMovie(watched[i]);
	    					myMovieBean.setTitle(myData.getTitle());
	    					myMovieBean.setYear(year);
	    					myMovieBean.setIMDB_Rating(IMDBrating);
	    					myMovieBean.setImdbID(IMDBID);
	    					myMovieBean.setPlot(plot);
	    					
	    					myMovieBean.setPoster(poster);
	    					myMovieBean.setRuntime(runtime);
	    					System.out.println("Title: " + myData.getTitle());
	    					System.out.println("Year: " + myData.getYear());
	    					request.setAttribute("title", myMovieBean.getTitle());
	    					request.setAttribute("year", myMovieBean.getYear());
	    					request.setAttribute("IMDB_rating", myMovieBean.getIMDB_Rating());
	    					watchedArray.add(myMovieBean);
	    					
	    					//response.getWriter().append(watched[i]+ "  "+myData.getYear()+ "   " + myData.getIMDB_Rating()+"\n");
	    					//response.getWriter().append("<br>");	    					
	    			    	 prt.println(watched[i]);
	    			    	 
	    			     }
	    				//dispatcher.forward(request, response);
	    				prt.println();
	    				prt.println();
	    				response.getWriter().append("\n");
	    				response.getWriter().append("\n");
	    				for(int j=0;j<u; j++){
	    					Data myData = new Data(unwatched[j]);
	    					myData.MovieDetails();
	    					MovieDataBean myMovieBean = new MovieDataBean();
	    					String year =  myData.getYear();
	    					String IMDBrating = myData.getIMDB_Rating();
	    					String IMDBID = myData.getImdbID();
	    					String plot = myData.getPlot();
	    					String date = myData.getRelease_date();
	    					String poster = myData.getPoster();
	    					String runtime = myData.getRuntime() ;
	    				    if(runtime == null || runtime.equals("N/A")){
	    						runtime = "0000";
	    					}
	    					if(poster == null || poster.equals("N/A")){
	    						poster = "resources/NoImageAvailable.jpg";
	    					}
	    					if(date == null){
	    						date = "N/A";
	    					}
	    					if(plot == null){
	    						plot = "N/A";
	    					}
	    					if(IMDBID == null){
	    						IMDBID = "N/A";
	    						
	    					}
	    					
	    					if(year == null){
	    						year = "N/A";
	    						
	    					}
	    					if(IMDBrating == null){
	    						IMDBrating = "N/A";
	    						
	    					}
	    					myMovieBean.setMovie(unwatched[j]);
	    					myMovieBean.setTitle(myData.getTitle());
	    					myMovieBean.setYear(year);
	    					myMovieBean.setIMDB_Rating(IMDBrating);
	    					myMovieBean.setImdbID(IMDBID);
	    					myMovieBean.setRelease_date(date);
	    					myMovieBean.setPoster(poster);
	    					myMovieBean.setPlot(plot);
	    					myMovieBean.setRuntime(runtime);
	    					System.out.println("Title: " + myData.getTitle());
	    					System.out.println("Year: " + myData.getYear());
	    					request.setAttribute("title", myMovieBean.getTitle());
	    					request.setAttribute("year", myMovieBean.getYear());
	    					request.setAttribute("IMDB_rating", myMovieBean.getIMDB_Rating());
	    					unwatchedArray.add(myMovieBean);
	    					//response.getWriter().append(unwatched[j]+ "  "+myData.getYear()+ "   " + myData.getIMDB_Rating()+"\n");
	    					//response.getWriter().append("<br>");
	    			    	prt.println(unwatched[j]);
	    		    	 
	    		     }
	    				request.setAttribute("WatchedMovieArray", watchedArray);
	    				request.setAttribute("unWatchedArray", unwatchedArray);
	    				RequestDispatcher dispatcher = request.getRequestDispatcher("EditMovies.jsp");
	    				dispatcher.forward(request, response);
	    				 prt.close(); 
	    				
	    				
	    				return;
	    			
	    				
	    			} catch (IOException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}finally{
	    				//prt.close();
	    			}
	    		 
	    		  
	    		     System.out.println("File write completed.");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
