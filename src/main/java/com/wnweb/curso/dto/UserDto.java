package com.wnweb.curso.dto;

import java.io.Serializable;

import com.wnweb.curso.domain.User;

public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String id;
	private String name;
	private String email;
	
	UserDto(){
	}
	
	public UserDto(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}
	
	public static User fromDto(UserDto objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
