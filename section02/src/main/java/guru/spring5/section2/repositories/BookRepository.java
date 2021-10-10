package guru.spring5.section2.repositories;

import guru.spring5.section2.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
