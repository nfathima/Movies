package uc.cs.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import uc.cs.rest.entity.Title;
import uc.cs.rest.service.TitleService;

@CrossOrigin(origins = "*")
@RestController
public class TitleController {
	@Autowired
	TitleService service;
	@RequestMapping(method=RequestMethod.GET,path="Title/All", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> findAll()
	{
		return service.findAll();
	}


	@RequestMapping(method=RequestMethod.GET,path="TitleSearch/{id2}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> freeSearch(@PathVariable("id2") String searchVar)
	{
		return service.freeSearch(searchVar);
	}


	@RequestMapping(method=RequestMethod.GET, path="Title/Year/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> findByYear(@PathVariable("id") String year)
	{
		return service.findByYear(year);
	}

	@RequestMapping(method=RequestMethod.GET, path="Title/Type/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> findByType(@PathVariable("id") String type)
	{
		return service.findByType(type);
	}

	@RequestMapping(method=RequestMethod.GET, path="Title/Genre/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> findByGenre(@PathVariable("id") String genre)
	{
		return service.findByGenre(genre);
	}

	@RequestMapping(method=RequestMethod.GET, path="Title/SortByRatings", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByRatings()
	{
		return service.sortByRatings();
	}
	@RequestMapping(method=RequestMethod.GET, path="Title/SortByYear", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByYear()
	{
		return service.sortByYear();
	}

	@RequestMapping(method=RequestMethod.GET, path="Title/SortByVotes", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByVotes()
	{
		return service.sortByVotes();
	}

	@RequestMapping(method=RequestMethod.GET, path="TopMovies", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> topRatedMovies()
	{
		return service.topRated("movies");
	}


	@RequestMapping(method=RequestMethod.GET, path="TopTVSeries", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> topRatedTVseries()
	{
		return service.topRated("tvseries");

	}


	@RequestMapping(method=RequestMethod.GET, path="Title/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title findOne(@PathVariable("id") String titleId)
	{
		return service.findOne(titleId);
	}

	@RequestMapping(method=RequestMethod.POST, path="Title",produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title create(@RequestBody Title title)
	{
		return service.create(title);
	}
	@RequestMapping(method=RequestMethod.PUT, path="Title/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title update(@PathVariable("id") String titleId,@RequestBody Title mov)
	{
		return service.update(titleId,mov);
	}
	@RequestMapping(method=RequestMethod.DELETE, path="Title/{id}")
	public void delete(@PathVariable("id") String titleId)
	{
		service.delete(titleId);
	}

}
