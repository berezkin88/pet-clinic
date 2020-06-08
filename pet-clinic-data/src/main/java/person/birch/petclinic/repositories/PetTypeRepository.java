package person.birch.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import person.birch.petclinic.model.PetType;

/**
 * @author Aleksandr Beryozkin
 */

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
