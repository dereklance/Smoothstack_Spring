package com.smoothstack.dec2020.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.dec2020.model.Author;
import com.smoothstack.dec2020.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	@RequestMapping(path = "authors/{authorId}", method = RequestMethod.GET)
	public Author getAuthorById(@PathVariable int authorId, HttpServletResponse res) {
		Author author = authorService.getAuthorById(authorId);
		if (author == null) {
//			throw new ResponseStatusException(
//					HttpStatus.NOT_FOUND, "Resource not found."
//			);
			res.setStatus(HttpStatus.NOT_FOUND.value());
			return null;
		}
		return author;
	}
	
	@RequestMapping(path = "authors", method = RequestMethod.GET)
	public List<Author> getAuthors(HttpServletResponse res) {
		List<Author> authors = authorService.getAuthors();
		if (authors == null) {
			res.setStatus(HttpStatus.NOT_FOUND.value());
			return null;
		}
		return authors;
	}
}
