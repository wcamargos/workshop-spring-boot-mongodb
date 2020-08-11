package com.wnweb.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnweb.curso.domain.User;
import com.wnweb.curso.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}

	/* TAMBEM NÃO DEU CERTO
	 * public User findById(String id) { User user = repo.findOne(id); return user;
	 * }
	 */
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		
		repo.deleteById(id);
	}
	/*
	 * METODO NÃO DÁ CERTO!! public User update(User obj) { User newObj =
	 * repo.findOne(obj.getId()); updateData(newObj, obj); return repo.save(newObj);
	 * }
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}
	 */
	
	
}
