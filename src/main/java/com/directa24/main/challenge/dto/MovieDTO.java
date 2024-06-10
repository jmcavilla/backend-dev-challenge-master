package com.directa24.main.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDTO {

	@JsonProperty("Title")
	public String title;
	@JsonProperty("Year")
	public String year;
	@JsonProperty("Rated")
	public String rated;
	@JsonProperty("Released")
	public String released;
	@JsonProperty("Runtime")
	public String runtime;
	@JsonProperty("Genre")
	public String genre;
	@JsonProperty("Director")
	public String director;
	@JsonProperty("Writer")
	public String writer;
	@JsonProperty("Actors")
	public String actors;
	@Override
	public String toString() {
		return "MovieDTO [title=" + title + ", year=" + year + ", rated=" + rated + ", released=" + released
				+ ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer=" + writer
				+ ", actors=" + actors + "]";
	}
	
	

}
