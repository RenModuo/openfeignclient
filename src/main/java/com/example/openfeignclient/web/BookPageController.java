package com.example.openfeignclient.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookPageController {

	@GetMapping({"/books", "/books.html", "/book-manager"})
	public String booksPage() {
		return "books";
	}
}