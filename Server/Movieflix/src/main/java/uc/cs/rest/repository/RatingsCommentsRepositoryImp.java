package uc.cs.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import uc.cs.rest.entity.RatingsComments;

@Repository
public class RatingsCommentsRepositoryImp implements RatingsCommentsRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Double findavgratings(String titleId) {
		TypedQuery<Double> query=em.createNamedQuery("RatingsComments.findAvgRatings",Double.class);
		query.setParameter("pMovieId",titleId);
		return query.getSingleResult();
	}

	public List<RatingsComments> findComments(String titleId) {
		TypedQuery<RatingsComments> query=em.createNamedQuery("RatingsComments.findComments",RatingsComments.class);
		query.setParameter("pMovieId",titleId);
		return query.getResultList();
	}

	@Override
	public RatingsComments create(RatingsComments r) {
		em.persist(r);
		return r;

	}

	@Override
	public void delete(String ratingId) {
		em.remove(ratingId);
	}

}
