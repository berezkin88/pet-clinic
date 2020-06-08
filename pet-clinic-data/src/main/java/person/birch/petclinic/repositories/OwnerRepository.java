package person.birch.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import person.birch.petclinic.model.Owner;

/**
 * @author Aleksandr Beryozkin
 */

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
