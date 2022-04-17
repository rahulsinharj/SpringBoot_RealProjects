package todo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import todo.dao.NoteRepo;
import todo.entity.Note;

@Controller
public class NoteController {
	
	@Autowired
	private NoteRepo noteRepo;
	
	@GetMapping("/home")
	public String home()
	{
		System.out.println("Inside /index controller");
		return "home";
	}
	
	@GetMapping("/add-notes")
	public String addNotes()
	{
		System.out.println("Inside /add-notes controller");
		return "add_notes";
	}
	
	@PostMapping("/save-notes")
	public String saveNotes(@RequestParam("title") String title, @RequestParam("content") String content)
	{
		System.out.println("Inside /save-notes controller");
		Note note = new Note(title, content.trim().replaceAll("/^\s*|\s*$/g","") , new Date());
		this.noteRepo.save(note);
		
		return "redirect:/view-notes";
	}
	
	@GetMapping("/view-notes")
	public String viewNotes(Model model)
	{
		System.out.println("Inside /view-notes controller");
		
		List<Note> allNotes = this.noteRepo.getAllNotesOrderByDate();		 // this.noteRepo.findAll();
		model.addAttribute("allNotes", allNotes);
		
		return "view_notes";
	}
	
	@PostMapping("/delete-note")
	public String deleteNote(@RequestParam("note_id") int noteId)
	{
		System.out.println("noteId : "+noteId);
		this.noteRepo.deleteById(noteId);
		
		return "redirect:/view-notes";
	}
	
	@PostMapping("/edit-note")
	public String editNote(@RequestParam("note_id") int noteId, Model model)
	{
		System.out.println("noteId : "+noteId);
		Note editNote = this.noteRepo.findById(noteId).get();
		model.addAttribute("note",editNote);
		
		return "edit";
	}
	
	@PostMapping("/save-updated-notes")
  //public String saveUpdatedNotes(@RequestParam("noteId") int noteId, @RequestParam("title") String title, @RequestParam("content") String content)
	public String saveUpdatedNotes(@ModelAttribute("note") Note note)
	{
		System.out.println("Inside /update-notes controller : "+note);
		Note updateNote = this.noteRepo.findById(note.getId()).get();
		updateNote.setTitle(note.getTitle());
		updateNote.setContent(note.getContent().trim().replaceAll("/^\s*|\s*$/g",""));
		updateNote.setAddedDate(new Date());
		
		this.noteRepo.save(updateNote);
		
		return "redirect:/view-notes";
	}
}
