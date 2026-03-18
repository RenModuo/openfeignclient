package com.example.openfeignclient.feign;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.openfeignclient.book.Book;

@RestController
@RequestMapping("/feign/books")
public class FeignBookController {

	private final BookFeignClient bookFeignClient;

	public FeignBookController(BookFeignClient bookFeignClient) {
		this.bookFeignClient = bookFeignClient;
	}

	@GetMapping
	public List<Book> getBooks() {
		return bookFeignClient.getBooks();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable Integer id) {
		return bookFeignClient.getBook(id);
	}

	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book savedBook = bookFeignClient.createBook(book);
		return ResponseEntity.ok(savedBook);
	}

	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
		return bookFeignClient.updateBook(id, book);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
		bookFeignClient.deleteBook(id);
		return ResponseEntity.noContent().build();
	}
}