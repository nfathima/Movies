package uc.cs.rest.service;



import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uc.cs.rest.entity.Users;
import uc.cs.rest.exception.AlreadyExistsException;
import uc.cs.rest.exception.NotFoundException;
import uc.cs.rest.exception.PwdMisMatchException;
import uc.cs.rest.repository.UsersRepository;

@Service
public class UsersServiceImp implements UsersService{

	@Autowired
	UsersRepository repository;

	@Override
	@Transactional
	public Users create(Users user) {
		List<Users> existing=repository.CheckuserName(user.getUserName());

		if(existing!=null)
		{
			throw new AlreadyExistsException("This Username is in use by other user. Choose any other name.");
		}

     if(!(user.getPassword().equals(user.getRepeatPassword())))
    	 throw new PwdMisMatchException("Password and repeat password do not match");

    	 return repository.create(user);

	}

	@Override
	public Users findOne(String userId) {
		Users existing=repository.findOne(userId);
		if(existing==null)
		{
			throw new NotFoundException("User with id:" + userId + "not found");
		}
		return existing;
	}



	@Override
	@Transactional
	public Users update(String userId,Users user) {
		Users existing=repository.findOne(userId);
		if(existing==null)
		{
			throw new NotFoundException("User with id: " + userId + " not found");
		}

		return repository.update(user);

	}

	@Override
	@Transactional
	public void delete(String userId) {
		Users existing=repository.findOne(userId);
		if(existing==null)
		{
			throw new NotFoundException("User with id: " + userId + " not found");
		}
	repository.delete(existing);
	}

	@Override
	public String findByName(String userName, String password) {
		return repository.findByName(userName, password);
	}



}
