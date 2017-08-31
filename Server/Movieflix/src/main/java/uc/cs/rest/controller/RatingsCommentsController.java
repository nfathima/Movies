package uc.cs.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uc.cs.rest.entity.RatingsComments;
import uc.cs.rest.service.RatingsCommentsService;

@RestController
@CrossOrigin(origins = "*")
public class RatingsCommentsController {

	@Autowired
	RatingsCommentsService service;

	@RequestMapping(method=RequestMethod.GET,path="{id}/AvgRatings", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Double findavgratings(@PathVariable("id") String titleId)
	{
		return service.findavgratings(titleId);
	}

	@RequestMapping(method=RequestMethod.GET,path="{id}/Comments", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<RatingsComments> findComments(@PathVariable("id") String titleId)
	{
		return service.findComments(titleId);
	}

	@RequestMapping(method=RequestMethod.POST, path="{id}/PostRatingsAndComments", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public RatingsComments create(@RequestBody RatingsComments r,@PathVariable("id") String titleId)
	{

		return service.create(r,titleId);
	}



	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String ratingId)
	{
		service.delete(ratingId);
	}
}
