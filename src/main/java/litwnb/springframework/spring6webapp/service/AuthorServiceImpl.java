package litwnb.springframework.spring6webapp.service;

import litwnb.springframework.spring6webapp.domain.Author;
import litwnb.springframework.spring6webapp.repo.AuthorRepo;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepo.findAll();
    }
}
