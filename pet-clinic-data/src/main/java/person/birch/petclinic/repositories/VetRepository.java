package person.birch.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import person.birch.petclinic.model.Vet;

/**
 * @author Aleksandr Beryozkin
 */

public interface VetRepository extends CrudRepository<Vet, Long> {
}
