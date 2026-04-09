package com.example.openfeignclient.web;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;

class BookPageControllerTest {

	@Test
	void shouldReturnBooksView() {
		BookPageController controller = new BookPageController();

		assertEquals("books", controller.booksPage());
	}

	@Test
	void shouldExposeBooksRoutes() throws NoSuchMethodException {
		Method method = BookPageController.class.getMethod("booksPage");
		GetMapping getMapping = method.getAnnotation(GetMapping.class);

		assertArrayEquals(new String[] {"/books", "/books.html", "/book-manager"}, getMapping.value());
	}
}
