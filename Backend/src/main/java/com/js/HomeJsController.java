package com.js;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.js.beans.NoteTaker;
import com.js.service.NoteDao;

@RestController
public class HomeJsController {
	
	@Autowired
	private NoteDao dao;
	
//	@RequestMapping(path = "/add", method = RequestMethod.POST, consumes = {"application/json"})
	@CrossOrigin
	@PostMapping("/add")
	public void save(@RequestBody NoteTaker note) {
		System.out.println("Inserting");
		dao.saveNote(note);
		
	}
	
	
	@CrossOrigin
	@GetMapping("/show")
	public List<NoteTaker> showAll(){
		List<NoteTaker> list = dao.getAllNote();
//		System.out.println(list);
		return list;
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public void deleteData(@PathVariable("id") long id) {
		String row = dao.deleteRow(id);
//		System.out.println(row);
	}
	
	@CrossOrigin
	@GetMapping("/user/{id}")
	public NoteTaker getSingleNote(@PathVariable("id") long id) {
		NoteTaker noteTaker = dao.getNoteById(id);
//		System.out.println(noteTaker);
		return noteTaker;

		
		
	}
	
	@CrossOrigin
	@PutMapping("/update")
	public void updateUser(@RequestBody NoteTaker note) {
		System.out.println("Updating"+note.getnId());
		
		NoteTaker newNote = new NoteTaker(note.getnId(), note.getTopicName(), note.getNote());
		dao.updateNote(newNote);
		
		
	}
	
	

}
