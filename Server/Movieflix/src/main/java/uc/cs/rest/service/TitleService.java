package uc.cs.rest.service;

import java.util.List;


import uc.cs.rest.entity.Title;


public interface TitleService {
	public List<Title> findAll();
	public List<Title> findByYear(String year);
	public List<Title> findByType(String type);
	public List<Title> findByGenre(String genre);
	public Title findOne(String titleId);
	public int findavgratings(String titleId);
	public List<Title> sortByRatings();
	public List<Title> sortByYear();
	public List<Title> sortByVotes();
	public Title create(Title mov);
	public Title update(String titleId, Title mov);
	public void delete(String titleId);
	public List<Title> freeSearch(String searchVar);
	public List<Title> topRated(String movietv);
}
