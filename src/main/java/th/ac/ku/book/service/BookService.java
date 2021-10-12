package th.ac.ku.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.book.model.Book;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.book.url}")
    private String url;

    public List<Book> getAll() {
        ResponseEntity<Book[]> response =
                restTemplate.getForEntity(url, Book[].class);
        Book[] restaurants = response.getBody();
        return Arrays.asList(restaurants);
    }

    public Book create(Book book) {
        return restTemplate.postForObject(url, book, Book.class);
    }
}
