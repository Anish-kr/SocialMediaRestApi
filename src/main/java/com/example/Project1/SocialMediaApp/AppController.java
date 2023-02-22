package com.example.Project1.SocialMediaApp;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class AppController {

	private DaoService service;

	public AppController(DaoService service) {
		super();
		this.service = service;
	}
	
	//get method for all user
	@GetMapping("/social/users")
	public List<Users> getAllUser() {
		
		return service.allUserList();
		}
	
	//get method for 1 user
	@GetMapping("/social/users/{id}") 
	public Users getOneUser(@PathVariable int id)
		{
			Users Oneuser=service.oneUser(id);
			if(Oneuser==null)
			{
			 throw new UserNotFoundException(null);
			}
			else
				return Oneuser;
		 
		}
	

	//Post Method for 1 user
	@PostMapping("/social/users")
	public ResponseEntity<Users> postOneUser(@Valid @RequestBody Users user)
		{
			Users newUser=service.addOneUser(user) ;
			
			URI location=
					ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}")
					.buildAndExpand(newUser.getId()).toUri();
			return ResponseEntity.created(location).build();
			
			
		}
	

	
	//delete method for 1 user
	@DeleteMapping("/social/users/{id}")
	public void deleteOneUser(@PathVariable int id)
		{
			service.deleteOneUser(id);			
		}
		
}
