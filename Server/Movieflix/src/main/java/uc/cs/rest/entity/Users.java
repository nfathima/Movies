package uc.cs.rest.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import uc.cs.rest.exception.InvalidRequestException;

@Entity
@Table
@NamedQueries({@NamedQuery(name="Users.findByName", query="SELECT u from Users u WHERE u.userName=:pUserName")})
public class Users {
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator="customUUID")
	private String userId;

	@Column(unique=true)
	private String userName;


	private String privilege;


	private String password;


	private String repeatPassword;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		if(privilege.toLowerCase().equals("admin")||privilege.toLowerCase().equals("user"))
		this.privilege = privilege;
		else throw new InvalidRequestException("Privileges can have only one of the two values: 'user' and 'admin'");
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}


}
