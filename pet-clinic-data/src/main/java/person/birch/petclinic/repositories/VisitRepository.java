package person.birch.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import person.birch.petclinic.model.Visit;

/**
 * @author Aleksandr Beryozkin
 */

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
