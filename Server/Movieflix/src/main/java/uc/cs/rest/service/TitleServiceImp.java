package uc.cs.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import uc.cs.rest.entity.Title;
import uc.cs.rest.entity.Users;
import uc.cs.rest.exception.NotFoundException;
import uc.cs.rest.repository.TitleRepository;
import uc.cs.rest.repository.UsersRepository;

@Service
public class TitleServiceImp implements TitleService{

	@Autowired
	TitleRepository repository;

	@Autowired

	@Override
	public List<Title> findAll() {

		return repository.findAll();
	}

	@Override
	public Title findOne(String titleId) {

		Title existing=repository.findOne(titleId);
		if(existing==null)
		{
			throw new NotFoundException("Title with id:" + titleId + "not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Title create(Title mov) {

		return repository.create(mov);
	}

	@Override
	@Transactional
	public Title update(String titleId, Title mov) {



		Title existing=repository.findOne(titleId);
		if(existing==null)
		{
			throw new NotFoundException("Title with id: " + titleId + " not found");
		}
		return repository.update(mov);
	}

	@Override
	@Transactional
	public void delete(String titleId) {


		Title existing=repository.findOne(titleId);
		if(existing==null)
		{
			throw new NotFoundException("Title with id: " + titleId + " not found");
		}
		repository.delete(existing);
	}

	@Override
	public List<Title> findByYear(String year) {

		List<Title> existing=repository.findByYear(year);
		if(existing==null)
		{
			throw new NotFoundException("There are no titles found in the year " + year);
		}
		return existing;
	}

	@Override
	public List<Title> findByType(String type) {

		List<Title> existing=repository.findByType(type);
		if(existing==null)
		{
			throw new NotFoundException("There are no titles found ofthis type " + type);
		}
		return existing;
	}

	@Override
	public List<Title> findByGenre(String genre) {

		List<Title> existing=repository.findByGenre(genre);
		if(existing==null)
		{
			throw new NotFoundException("There are no titles found in the " + genre + "genre.");
		}
		return existing;
	}

	@Override
	public List<Title> sortByRatings() {

		return repository.sortByRatings();
	}

	@Override
	public List<Title> sortByYear() {
		return repository.sortByYear();
	}

	@Override
	public List<Title> sortByVotes() {
		return repository.sortByVotes();
	}

	@Override
	public int findavgratings(String titleId) {
		return repository.findavgratings(titleId);

	}

	@Override
	public List<Title> freeSearch(String searchVar) {

		return repository.freeSearch(searchVar);
	}

	@Override
	public List<Title> topRated(String movietv) {

		List<Title> existing=repository.topTitle(movietv);
		if(existing==null)
		{
			throw new NotFoundException("There are no titles found of this type " + movietv);
		}
		return existing;
	}

}
