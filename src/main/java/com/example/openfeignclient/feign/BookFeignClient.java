package com.example.openfeignclient.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.openfeignclient.book.Book;

@FeignClient(name = "bookApiClient", url = "${book.api.url}")
public interface BookFeignClient {

	@GetMapping("/books")
	List<Book> getBooks();

	@GetMapping("/books/{id}")
	Book getBook(@PathVariable Integer id);

	@PostMapping("/books")
	Book createBook(@RequestBody Book book);

	@PutMapping("/books/{id}")
	Book updateBook(@PathVariable Integer id, @RequestBody Book book);

	@DeleteMapping("/books/{id}")
	void deleteBook(@PathVariable Integer id);
}