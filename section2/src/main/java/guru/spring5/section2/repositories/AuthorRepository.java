package guru.spring5.section2.repositories;

import guru.spring5.section2.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
