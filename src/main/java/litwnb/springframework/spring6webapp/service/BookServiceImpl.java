package litwnb.springframework.spring6webapp.service;

import litwnb.springframework.spring6webapp.domain.Book;
import litwnb.springframework.spring6webapp.repo.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepo.findAll();
    }
}
