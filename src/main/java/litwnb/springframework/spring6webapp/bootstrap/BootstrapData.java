package litwnb.springframework.spring6webapp.bootstrap;

import litwnb.springframework.spring6webapp.domain.Author;
import litwnb.springframework.spring6webapp.domain.Book;
import litwnb.springframework.spring6webapp.domain.Publisher;
import litwnb.springframework.spring6webapp.repo.AuthorRepo;
import litwnb.springframework.spring6webapp.repo.BookRepo;
import litwnb.springframework.spring6webapp.repo.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootstrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
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
        petCemeterySaved.getAuthors().add(kingSaved);
        fountainheadSaved.getAuthors().add(randSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Penguin Books");
        publisher.setAddress("20 Vauxhall Bridge Rd");
        publisher.setCity("London");
        publisher.setZipCode("SW1V2SA");
        Publisher savedPublisher = publisherRepo.save(publisher);

        petCemeterySaved.setPublisher(publisher);
        fountainheadSaved.setPublisher(publisher);

        authorRepo.save(kingSaved);
        authorRepo.save(randSaved);
        bookRepo.save(petCemeterySaved);
        bookRepo.save(fountainheadSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepo.count());
        System.out.println("Book count: " + bookRepo.count());
        System.out.println("Publisher count " + publisherRepo.count());
    }
}
