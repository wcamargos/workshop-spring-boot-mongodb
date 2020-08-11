package com.wnweb.curso.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wnweb.curso.domain.User;
import com.wnweb.curso.dto.UserDto;
import com.wnweb.curso.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	private UserService 	service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDto>> findAll(){
		List<User> list = service.findAll();
		List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	/*
	 * TUDO CERTO E NÃO DEU
	 * 
	 * @RequestMapping(value = "/{id}", method=RequestMethod.GET)
	 * public ResponseEntity<UserDto> findById(@PathVariable String id){ 
	 * User user = service.findById(id); return ResponseEntity.ok().body(new UserDto(user)); }
	 */
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDto objDto){
		User obj = UserDto.fromDto(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable String id){ 
		service.delete(id);
		return ResponseEntity.noContent().build(); 
		}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<UserDto> update(@RequestBody UserDto objDto, @PathVariable String id ){
		User obj = UserDto.fromDto(objDto);
		obj.setId(id);
		//obj = service.update(obj); NÃO DEU CERTO ESSE MÉTODO
		return ResponseEntity.noContent().build();
	}
	/*
	 * @RequestMapping(value = "/{id}/posts", method=RequestMethod.GET) public
	 * ResponseEntity<List<Post>> findPosts(@PathVariable String id){ User obj =
	 * service.findById(id); return ResponseEntity.ok().body(obj.getPosts()); }
	 */
	
}
