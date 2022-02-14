package com.js.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.beans.NoteTaker;
import com.js.repo.NoteRepo;

@Service
public class NoteDao {

	@Autowired
	private NoteRepo repo;

	public int saveNote(NoteTaker note) {
		repo.save(note);
		return 1;
	}
	
	public int updateNote(NoteTaker note) {
		repo.save(note);
		return 2;
	}

	public List<NoteTaker> getAllNote() {
		List<NoteTaker> list = repo.findAll();
		return list;

	}

	public String deleteRow(long id) {
		repo.deleteById(id);
		return "Success";
	}

	public NoteTaker getNoteById(long id) {
		Optional<NoteTaker> optional = repo.findById(id);
		NoteTaker noteTaker = optional.get();
		return noteTaker;
	}

}
