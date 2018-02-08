package addressbook;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long> {

    List<AddressBook> findByOwner(@Param("owner") String owner);

    AddressBook findById(@Param("id") int id);

}
