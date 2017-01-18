package com.acz.demoapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acz.demoapp.domain.Persona;
import com.acz.demoapp.service.PersonaService;

@RestController
public class PersonaRest {

	@Autowired
	private PersonaService personaService;

	@RequestMapping(value = "/persona/", method = RequestMethod.GET)
	public ResponseEntity<List<Persona>> listAllUsers() {
		try {
			List<Persona> users = personaService.findAll();
			if (users.isEmpty()) {
				return new ResponseEntity<List<Persona>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<Persona>>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Persona>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> getUser(@PathVariable("id") long id) {
		System.out.println("Fetching  with id " + id);
		try {
			Persona user = personaService.findById(id);
			if (user == null) {
				System.out.println(" with id " + id + " not found");
				return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Persona>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Persona>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// -------------------Create
	@RequestMapping(value = "/persona/", method = RequestMethod.POST)
	public ResponseEntity<Boolean> insert(@RequestBody Persona p) {
		try {
			personaService.insert(p);
			return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}
		
		//------------------- Update
	     
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Persona> updateUser(@PathVariable("id") long id, @RequestBody Persona user) {
		System.out.println("Updating  " + id);
		try {
			Persona currentUser = personaService.findById(id);

			if (currentUser == null) {
				System.out.println(" with id " + id + " not found");
				return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
			}
			
			 currentUser.setNombre(user.getNombre());
			 currentUser.setEmail(user.getEmail());

			personaService.update(currentUser);
			return new ResponseEntity<Persona>(currentUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Persona>(HttpStatus.BAD_REQUEST);
		}
	}
	    
	    //------------------- Delete
	     
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Persona> deleteUser(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting  with id " + id);
		try {
			Persona user = personaService.findById(id);
			if (user == null) {
				System.out.println("Unable to delete.  with id " + id + " not found");
				return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
			}
			personaService.deleteById(id);
			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Persona>(HttpStatus.BAD_REQUEST);
		}
	}
	 
	     
	    //------------------- Delete All
	     
	    @RequestMapping(value = "/persona/", method = RequestMethod.DELETE)
	public ResponseEntity<Persona> deleteAllUsers() {
		try {
			System.out.println("Deleting All ");
			personaService.deleteAll();
			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<Persona>(HttpStatus.BAD_REQUEST);
		}
	}

}
