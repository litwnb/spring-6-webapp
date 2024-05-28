package litwnb.springframework.spring6webapp.service;

import litwnb.springframework.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
