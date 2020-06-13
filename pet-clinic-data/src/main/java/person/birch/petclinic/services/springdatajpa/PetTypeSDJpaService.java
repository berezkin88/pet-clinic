package person.birch.petclinic.services.springdatajpa;

import org.aspectj.weaver.Iterators;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import person.birch.petclinic.model.PetType;
import person.birch.petclinic.repositories.PetTypeRepository;
import person.birch.petclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Aleksandr Beryozkin
 */
@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> output = new HashSet<>();
        petTypeRepository.findAll().forEach(output::add);
        return output;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
