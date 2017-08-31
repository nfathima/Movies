package uc.cs.rest.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import uc.cs.rest.exception.InvalidRequestException;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Title.findAll", query="SELECT m from Title m order by m.year DESC"),
	@NamedQuery(name="Title.findByYear", query="SELECT m from Title m WHERE m.year=:pYear"),
	@NamedQuery(name="Title.findByType", query="SELECT m from Title m WHERE m.type = :pType"),
	@NamedQuery(name="Title.findByGenre", query="SELECT m from Title m WHERE m.genre = :pGenre"),
	@NamedQuery(name="Title.sortByRatings", query="SELECT m from Title m order by m.imdbRatings DESC"),
	@NamedQuery(name="Title.sortByYear", query="SELECT m from Title m order by m.year DESC"),
	@NamedQuery(name="Title.sortByVotes", query="SELECT m from Title m order by m.imdbVotes DESC"),
	@NamedQuery(name="Title.topTitle", query="SELECT m from Title m WHERE LOWER(m.type)=:pType order by m.imdbRatings DESC"),
	@NamedQuery(name="Title.freeSearch", query="SELECT m from Title m WHERE LOWER(CONCAT(m.titleId,m.name,m.imdbRatings,"
			+ "m.type,m.year,m.genre,m.imdbVotes,m.director,m.actors,m.plot)) LIKE LOWER(:pString)"),
	@NamedQuery(name="Title.findByThree", query="SELECT m from Title m WHERE m.year=:pYear AND m.type=:pType AND m.genre=:pGenre")})

public class Title {

	//Declaration of attribute names in database table Title
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator="customUUID")
	private String titleId;

	private String name;
	private float imdbRatings;

	private String type;

	private String year;
	private String genre;
	private int imdbVotes;
	private String director;
	private String actors;

	private String plot;


	@Override
	public String toString() {
		return "Title [imdbRatings=" + imdbRatings + ", type=" + type + ", year=" + year + ", genre=" + genre
				+ ", imdbVotes=" + imdbVotes + ", director=" + director + ", actors=" + actors + ", plot=" + plot + "]";
	}



	public String getTitleId() {
		return titleId;
	}



	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMovieId() {
		return titleId;
	}
	public void setMovieId(String titleId) {
		this.titleId = titleId;
	}

	public float getImdbRatings() {
		return imdbRatings;
	}
	public void setImdbRatings(float imdbRatings) {
		this.imdbRatings = imdbRatings;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if(type.toLowerCase().equals("movies") || type.toLowerCase().equals("tvseries"))
		this.type = type;
		else
			throw new InvalidRequestException("Type of the title should be movies or tvseries");
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}

}
