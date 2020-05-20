package person.birch.petclinic.services;

import person.birch.petclinic.model.Owner;
import person.birch.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
