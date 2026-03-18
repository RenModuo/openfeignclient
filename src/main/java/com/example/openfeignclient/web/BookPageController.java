package com.example.openfeignclient.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookPageController {

	@GetMapping("/book-manager")
	public String bookManagerPage() {
		return "books";
	}
}