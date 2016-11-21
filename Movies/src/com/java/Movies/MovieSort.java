/*package com.java.Movies;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Date;


public class MovieSort {
	
	
	public void mainMethod() {
		
		String movies = "C:\\Users\\Rakesh\\MovieDym.txt";
		
		String[] watched = new String[50];
		String [] unwatched =  new String[50];
		int w=0, u=0;
		FileOutputStream out;
	     PrintStream prt;
	     File f = new File(movies);
	     
	     
	     
	     System.out.println(f.length());
	     
	      if(f.exists()){
	     	 System.out.println("File exists");
	      }else{
	     	 System.out.println("File does not exist");
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
        	
        	 
        	 line = line.substring(0, length-12);
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
	     
	     for(int i=0;i<w; i++){
	    	 System.out.println(watched[i] + "\n");
	     }
	     
	     for(int k = 0; k<u ; k++){
	    	 for(int l = k+1; l<u; l++){
	    		 if(unwatched[l].compareToIgnoreCase(unwatched[k])<0){
	    			 String temp = unwatched[k];
	    			 unwatched[k] = unwatched[l];
	    			 unwatched[l] = temp;
	    		 }
	    	 }
	     }
	    	 System.out.println("\n\n\nUnwatched Movies: \n");
		     for(int j=0;j<u; j++){
		    	 System.out.println(unwatched[j] + "\n");
	    	 
	     }
		     try {
		    	 System.out.println("Starting File write...");
				out = new FileOutputStream(movies);
				prt = new PrintStream(out);
				//prt.println("*** Updated on: "+ new Date().toString()+" ***\n");
				//prt.println("*** Created by "+MovieSort.class.getName()+" ***\n\n");
				for(int i=0;i<w; i++){
					Data myData = new Data(watched[i]);
					myData.MovieDetails();
					System.out.println("Title: " + myData.getTitle());
					System.out.println("Year: " + myData.getYear());
					
					
			    	 //prt.println(watched[i]+ "  "+myData.getYear()+ "   " + myData.getIMDB_Rating());
			    	 
			     }
				prt.println();
				prt.println();
				for(int j=0;j<u; j++){
					Data myData = new Data(unwatched[j]);
					myData.MovieDetails();
					System.out.println("Title: " + myData.getTitle());
					System.out.println("Year: " + myData.getYear());
			    	// prt.println(unwatched[j] +  "  "+myData.getYear()+ "   " + myData.getIMDB_Rating());
		    	 
		     }
			
			     
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		   
		     System.out.println("File write completed.");

	         

}
}
*/