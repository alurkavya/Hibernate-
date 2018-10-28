package com.caps.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_info")
public class Person {
	@Id @Column(name="person_id")
	private int personId;
	
	@Column(name="person_name")
	private String personName;
	
	@Column(name="person_age")
	private Double personage;
	
	@Column(name="person_mail")
	private String personmail;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Double getPersonage() {
		return personage;
	}

	public void setPersonage(Double personage) {
		this.personage = personage;
	}

	public String getPersonmail() {
		return personmail;
	}

	public void setPersonmail(String personmail) {
		this.personmail = personmail;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personage=" + personage
				+ ", personmail=" + personmail + "]";
	}
	
	
	/*public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getSummmary() {
		return summmary;
	}
	public void setSummmary(String summmary) {
		this.summmary = summmary;
	}
	public Double getRatings() {
		return ratings;
	}
	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", summmary=" + summmary + ", ratings="
				+ ratings + "]";
*/	
	}
