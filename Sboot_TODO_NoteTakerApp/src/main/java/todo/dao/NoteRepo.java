package todo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import todo.entity.Note;

public interface NoteRepo extends JpaRepository<Note, Integer> {

	@Query("select n from Note n order by n.addedDate desc")						// "from User usr" , this query will also work same way ; but "select user" is somewhat more readable 
	public List<Note> getAllNotesOrderByDate();
	
}
