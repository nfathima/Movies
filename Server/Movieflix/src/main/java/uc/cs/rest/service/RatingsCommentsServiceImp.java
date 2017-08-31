package uc.cs.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uc.cs.rest.entity.Title;
import uc.cs.rest.entity.RatingsComments;
import uc.cs.rest.repository.TitleRepository;
import uc.cs.rest.repository.RatingsCommentsRepository;


@Service
public class RatingsCommentsServiceImp implements RatingsCommentsService{

	@Autowired
	RatingsCommentsRepository repository;

	@Autowired
	TitleRepository movrepository;

	@Override
	@Transactional
	public RatingsComments create(RatingsComments r, String titleId) {
		Title m=movrepository.findOne(titleId);
		r.setMovies(m);
		return repository.create(r);
	}

	public List<RatingsComments> findComments(String titleId)
	{
		return repository.findComments(titleId);
	}
	@Override
	public Double findavgratings(String titleId) {
		return repository.findavgratings(titleId);
	}

	@Override
	@Transactional
	public void delete(String ratingId) {
		repository.delete(ratingId);
	}


}
