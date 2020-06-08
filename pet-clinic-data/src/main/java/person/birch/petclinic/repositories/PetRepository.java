package person.birch.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import person.birch.petclinic.model.Pet;

/**
 * @author Aleksandr Beryozkin
 */

public interface PetRepository extends CrudRepository<Pet, Long> {
}
