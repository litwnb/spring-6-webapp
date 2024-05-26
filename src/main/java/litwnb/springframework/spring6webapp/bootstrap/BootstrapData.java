package litwnb.springframework.spring6webapp.bootstrap;

import litwnb.springframework.spring6webapp.domain.Author;
import litwnb.springframework.spring6webapp.domain.Book;
import litwnb.springframework.spring6webapp.repo.AuthorRepo;
import litwnb.springframework.spring6webapp.repo.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public BootstrapData(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Author king = new Author();
        king.setFirstName("Steven");
        king.setLastName("King");

        Book petCemetery = new Book();
        petCemetery.setTitle("Pet Cemetery");
        petCemetery.setIsbn("1234");

        Author kingSaved = authorRepo.save(king);
        Book petCemeterySaved = bookRepo.save(petCemetery);

        Author rand = new Author();
        rand.setFirstName("Ayn");
        rand.setLastName("Rand");

        Book fountainhead = new Book();
        fountainhead.setTitle("The Fountainhead");
        fountainhead.setIsbn("1357");

        Author randSaved = authorRepo.save(rand);
        Book fountainheadSaved = bookRepo.save(fountainhead);

        kingSaved.getBooks().add(petCemeterySaved);
        randSaved.getBooks().add(fountainheadSaved);

        authorRepo.save(kingSaved);
        authorRepo.save(randSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepo.count());
        System.out.println("Book count: " + bookRepo.count());
    }
}
