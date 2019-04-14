package com.mebcorp.articleApp.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mebcorp.articleApp.entities.Article;
import com.mebcorp.articleApp.entities.Author;
import com.mebcorp.articleApp.models.ApplicationModel;
import com.mebcorp.articleApp.models.Response;
import com.mebcorp.articleApp.utils.Static;

@RequestMapping("/api")
@RestController
public class AuthorsController {
	@Autowired
	private ApplicationModel application;
	private List<String> messages;

	@PostConstruct
	public void init() {
		messages = application.getMessages();
	}
	
	
	
	@GetMapping("/authors")
	public ResponseEntity<?> getAllAuthors() {
    
		if (messages != null) {
			return new ResponseEntity<>(messages, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		try {
			return new ResponseEntity<>(new Response(0,application.getAllAuthors()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(Static.getErreursForException(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/author/{id}")
	public Response getAuthorById(@PathVariable Long id) {
		if (messages != null) {
			return new Response(-1, messages);
		}
		try {
			return new Response(0, application.getAuthorById(id));
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
	}
	
	@GetMapping("/author/{id}/articles")
	public Response getAuthorArticles(@PathVariable Long id) {
		if (messages != null) {
			return new Response(-1, messages);
		}
		try {
			return new Response(0, application.getAuthorArticles(id));
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
	}
	

	@GetMapping("/articles")
	public Response getArticles() {
		if (messages != null) {
			return new Response(-1, messages);
		}
		try {
			return new Response(0, application.getAllArticles());
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
	}
	

	@GetMapping("/article/{id}")
	public Response getArticleById(@PathVariable Long id) {
		if (messages != null) {
			return new Response(-1, messages);
		}
		try {
			return new Response(0, application.getArticleById(id));
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
	}
	

	@GetMapping("/article/{id}/author")
	public Response getArticleAuthor(@PathVariable Long id) {
		if (messages != null) {
			return new Response(-1, messages);
		}
		try {
			return new Response(0, application.getArticleAuthor(id));
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
	}
	

	@PostMapping("/author/new")
	public Response createAuthor(@RequestBody Author post) {
		if (messages != null) {
			return new Response(-1, messages);
		}
		
		try {
			application.createAuthor(post);
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
		
		return new Response(0, null);
	}
	
	@PostMapping("/author/{id}/update")
	public Response updateAuthor(@PathVariable Long id, @RequestBody Author post) {
		if (messages != null) {
			return new Response(-1, messages);
		}
		
		try {
			application.updateAuthor(id, post);
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
		
		return new Response(0, null);
	}
	
	@PostMapping("/author/{id}/delete")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Response deleteAuthor(@PathVariable Long id) {
		if (messages != null) {
			return new Response(-1, messages);
		}
		
		try {
			application.deleteAuthor(id);
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
		
		return new Response(0, null);
	}
	
	@PostMapping("/article/new/{idAuthor}")
	public Response createArticle(@PathVariable Long idAuthor, @RequestBody Article post) {
		if (messages != null) {
			return new Response(-1, messages);
		}
		
		try {
			application.createArticle(idAuthor, post);
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
		
		return new Response(0, null);
	}
	
	@PostMapping("/article/{id}/update")
	public Response updateArticle(@PathVariable Long id, @RequestBody Article post) {
		if (messages != null) {
			return new Response(-1, messages);
		}
		
		try {
			application.updateArticle(id, post);
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
		
		return new Response(0, null);
	}
	
	@PostMapping("/article/{id}/delete")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Response deleteArticle(@PathVariable Long id) {
		if (messages != null) {
			return new Response(-1, messages);
		}
		
		try {
			application.deleteArticle(id);
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
		
		return new Response(0, null);
	}
	

}
