package person.birch.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import person.birch.petclinic.model.Speciality;

/**
 * @author Aleksandr Beryozkin
 */

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
