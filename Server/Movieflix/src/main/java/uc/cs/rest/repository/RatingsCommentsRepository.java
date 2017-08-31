package uc.cs.rest.repository;

import java.util.List;

import uc.cs.rest.entity.RatingsComments;

public interface RatingsCommentsRepository {
	public Double findavgratings(String titleId);
	public List<RatingsComments> findComments(String titleId);
	public RatingsComments create(RatingsComments r);
	public void delete(String ratingId);
}
