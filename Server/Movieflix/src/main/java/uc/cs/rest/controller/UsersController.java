package uc.cs.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import uc.cs.rest.entity.Users;
import uc.cs.rest.service.UsersService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/Users")
public class UsersController {

	@Autowired
	UsersService service;

	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users create(@RequestBody Users user)
	{
		return service.create(user);
	}

	@RequestMapping(method=RequestMethod.GET, path="{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users findOne(@PathVariable("id") String userId)
	{
		return service.findOne(userId);
	}

	@RequestMapping(method=RequestMethod.POST, path="userName/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String findByName(@PathVariable("id") String userName, @RequestBody String password)
	{
		System.out.println("password"+password+"Username"+userName);
		String suc=service.findByName(userName, password);
		System.out.println(suc);
		return suc;
	}

	@RequestMapping(method=RequestMethod.PUT, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users update(@PathVariable("id") String userId,@RequestBody Users user)
	{
		return service.update(userId,user);
	}
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String userId)
	{
		service.delete(userId);
	}

}
