package uc.cs.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import uc.cs.rest.entity.Title;

@Repository
public class TitleRepositoryImp implements TitleRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Title> findAll() {
		TypedQuery<Title> query=em.createNamedQuery("Title.findAll",Title.class);
		return query.getResultList();
	}

	@Override
	public Title findOne(String titleId) {
		return em.find(Title.class, titleId);

	}

	@Override
	public List<Title> findByYear(String year) {
		TypedQuery<Title> query=em.createNamedQuery("Title.findByYear",Title.class);
		query.setParameter("pYear",year);
		return query.getResultList();

	}

	@Override
	public List<Title> findByType(String type) {
		TypedQuery<Title> query=em.createNamedQuery("Title.findByType",Title.class);
		query.setParameter("pType","%"+type+"%");
		return query.getResultList();

	}

	@Override
	public List<Title> findByGenre(String genre) {
		TypedQuery<Title> query=em.createNamedQuery("Title.findByGenre",Title.class);
		query.setParameter("pGenre","%"+genre+"%");
		return query.getResultList();

	}

	@Override
	public List<Title> sortByRatings() {
		TypedQuery<Title> query=em.createNamedQuery("Title.sortByRatings",Title.class);
		return query.getResultList();

	}

	@Override
	public List<Title> sortByYear() {
		TypedQuery<Title> query=em.createNamedQuery("Title.sortByYear",Title.class);
		return query.getResultList();

	}

	@Override
	public List<Title> sortByVotes() {
		TypedQuery<Title> query=em.createNamedQuery("Title.sortByVotes",Title.class);
		return query.getResultList();

	}

	@Override
	public int findavgratings(String titleId) {
		TypedQuery<Title> query=em.createNamedQuery("Title.findavgratings",Title.class);
		return query.getFirstResult();
	}

	@Override
	public Title create(Title mov) {
		em.persist(mov);
		return mov;

	}

	@Override
	public Title update(Title mov) {
		return em.merge(mov);

	}

	@Override
	public void delete(Title mov) {
		em.remove(mov);
	}

	@Override
	public List<Title> freeSearch(String searchVar) {
		TypedQuery<Title> query=em.createNamedQuery("Title.freeSearch",Title.class);
		query.setParameter("pString","%"+searchVar+"%");
		return query.getResultList();
	}

	@Override
	public List<Title> topTitle(String movietv) {
		TypedQuery<Title> query=em.createNamedQuery("Title.topTitle",Title.class);
		query.setParameter("pType",movietv.toLowerCase());
		query.setMaxResults(5);
		return query.getResultList();
	}
}
