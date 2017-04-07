package com.cts.springjpa.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.springjpa.model.User;
import com.cts.springjpa.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") int id){
		User user = userService.getUser(id);
		if( user !=null){
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/getlist",method=RequestMethod.GET)
	public ResponseEntity<?> getAllUsers(){
		List<User> userList = userService.getAllUsers();
		if(!userList.isEmpty()){
			return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody User user){
		if(userService.addUser(user)>0){
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody User user){
		if(userService.updateUser(user)>0){
			return new ResponseEntity<>(HttpStatus.OK);		
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
		if(userService.deleteUser(id)>0){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
