package com.js.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.js.beans.NoteTaker;

@Repository
public interface NoteRepo extends JpaRepository<NoteTaker, Long> {

}
