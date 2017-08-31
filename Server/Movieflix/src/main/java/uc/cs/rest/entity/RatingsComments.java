package uc.cs.rest.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
@NamedQuery(name = "RatingsComments.findAvgRatings", query = "select avg(r.ratings) from RatingsComments r where r.title.titleId = :pMovieId"),
@NamedQuery(name = "RatingsComments.findComments", query = "select c from RatingsComments c where c.title.titleId = :pMovieId")})
public class RatingsComments {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator="customUUID")
	private String ratcomId;
	private String userName;
	private int ratings;

	private String comments;

	@ManyToOne
	private Title title;

	public String getRatcomId() {
		return ratcomId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setRatcomId(String ratcomId) {
		this.ratcomId = ratcomId;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Title getMovies() {
		return title;
	}
	public void setMovies(Title title) {
		this.title = title;
	}



}
