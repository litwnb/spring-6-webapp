package litwnb.springframework.spring6webapp.repo;

import litwnb.springframework.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
