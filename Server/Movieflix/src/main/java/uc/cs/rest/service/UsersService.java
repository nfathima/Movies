package uc.cs.rest.service;


import uc.cs.rest.entity.Users;

public interface UsersService {

	public Users update(String userId,Users user);
	public Users findOne(String userId);
	public String findByName(String userName, String password);
	public void delete(String userId);
	public Users create(Users user);

}
