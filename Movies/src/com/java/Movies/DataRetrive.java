package com.java.Movies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;


public class DataRetrive {
 String movie;
	
	public DataRetrive(String movie){
		this.movie = movie;
		//System.out.println("Movie set: " + movie);
	}
	
	
	
    public String getMovie() {
		return movie;
	}
    


	
    public void movieData() throws IOException{
    	
    	String updatedMovie = movie.replaceAll(" ", "%20");
    	String newUrl =  "http://www.omdbapi.com/?t="+updatedMovie+"&r=xml";
    	String filepath = "C:\\Users\\Rakesh\\Movieinfo.xml";
    	FileOutputStream out;
	     PrintStream prt;
	     File f = new File(filepath);
        URL url = new URL(newUrl);

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;
        

        
        
        out = new FileOutputStream(filepath);
		prt = new PrintStream(out);
		while ((line = br.readLine()) != null) {
           // System.out.println(line);
            prt.println(line);
        }
		prt.close();
		
    
}
}
    