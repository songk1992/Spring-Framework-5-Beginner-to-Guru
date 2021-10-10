package guru.spring5.section2.repositories;

import guru.spring5.section2.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
