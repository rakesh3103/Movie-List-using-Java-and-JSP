package com.java.Movies;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


public class Data{
	String movie;
	String title ;
    String year;
    String rated ;
    String IMDB_Rating;
    String Release_date ;
    String runtime;
    String genre ;
    String director;
    String actors;
    String plot;
    String language;
    String country;
    String awards;
    String poster;
    String metascore;
    String imdbvotes;
    String imdbID;
    String type;
	public String getMovie() {
		return movie;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getRated() {
		return rated;
	}

	public String getIMDB_Rating() {
		return IMDB_Rating;
	}

	public String getRelease_date() {
		return Release_date;
	}

	public String getRuntime() {
		return runtime;
	}

	public String getGenre() {
		return genre;
	}

	public String getDirector() {
		return director;
	}

	public String getActors() {
		return actors;
	}

	public String getPlot() {
		return plot;
	}

	public String getLanguage() {
		return language;
	}

	public String getCountry() {
		return country;
	}

	public String getAwards() {
		return awards;
	}

	public String getPoster() {
		return poster;
	}

	public String getMetascore() {
		return metascore;
	}

	public String getImdbvotes() {
		return imdbvotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public String getType() {
		return type;
	}

	public Data(String movie){
		this.movie = movie;
	}
	
	public void MovieDetails() throws IOException {
		DataRetrive newdataRetrive = new DataRetrive(movie);
		newdataRetrive.movieData();
		
		String filepath = "C:\\Users\\Rakesh\\Movieinfo.xml";
		File xmlFile = new File(filepath);
		
        
		
		
		
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(xmlFile); 
	        doc.getDocumentElement().normalize(); 
	        //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	        NodeList nList = doc.getElementsByTagName("movie");
	        //System.out.println("----------------------------");
	        for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	                   // System.out.println("\nCurrent Element :" + nNode.getNodeName());
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element eElement = (Element) nNode; 
	            title = eElement.getAttribute("title");
	            year = eElement.getAttribute("year");
	             rated = eElement.getAttribute("rated");
	            IMDB_Rating = eElement.getAttribute("imdbRating");
	            Release_date = eElement.getAttribute("released");
	            runtime = eElement.getAttribute("runtime");
	            genre = eElement.getAttribute("genre");
	            director = eElement.getAttribute("director");
	            actors = eElement.getAttribute("actors");
	            plot = eElement.getAttribute("plot");
	            language = eElement.getAttribute("language");
	            country = eElement.getAttribute("country");
	            awards = eElement.getAttribute("awards");
	            poster = eElement.getAttribute("poster");
	            metascore = eElement.getAttribute("metascore");
	            imdbvotes = eElement.getAttribute("imdbVotes");
	            imdbID = eElement.getAttribute("imdbID");
	            type = eElement.getAttribute("type");
	            
	            
	            
	           /* System.out.println("Title : " + title);
	            System.out.println("Year : " + year);
	            System.out.println("Rated : " + rated);
	            System.out.println("ReleaseDate : " + Release_date);
	            System.out.println("Run time : " + runtime);
	            System.out.println("Genre : " + genre);
	            System.out.println("Director : " + director);
	            System.out.println("Actors : " + actors);
	            System.out.println("Plot : " + plot);
	            System.out.println("Language : " + language);
	            System.out.println("Country : " + country);
	            System.out.println("Awards : " + awards);
	            System.out.println("Poster : " + poster);
	            System.out.println("Meta Score : " + metascore);
	            System.out.println("IMDB Votes : " + imdbvotes);
	            System.out.println("IMDB ID : " + imdbID);
	            System.out.println("Type : " + type);*/
	            
	            
	            }
	        }
			
			
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}