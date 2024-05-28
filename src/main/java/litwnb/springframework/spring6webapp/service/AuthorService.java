package litwnb.springframework.spring6webapp.service;

import litwnb.springframework.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
