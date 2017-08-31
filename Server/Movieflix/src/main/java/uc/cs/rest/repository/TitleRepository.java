package uc.cs.rest.repository;

import java.util.List;

import uc.cs.rest.entity.Title;

public interface TitleRepository {

	public List<Title> findAll();
	public List<Title> findByYear(String year);
	public List<Title> findByType(String type);
	public List<Title> findByGenre(String genre);
	public List<Title> sortByRatings();
	public List<Title> sortByYear();
	public List<Title> sortByVotes();
	public int findavgratings(String titleId);
	public Title findOne(String titleId);
	public Title create(Title mov);
	public Title update(Title mov);
	public void delete(Title mov);
	public List<Title> freeSearch(String searchVar);
	public List<Title> topTitle(String movietv);


}
