package person.birch.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import person.birch.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private static final long ownerID= 1L;
    private static final String OWNER_NAME = "Smith";
    private static final Owner testOwner = Owner.builder().id(ownerID).lastName(OWNER_NAME).build();

    private OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(testOwner);
    }

    @Test
    void findAll() {
        Set<Owner> actual = ownerMapService.findAll();

        assertEquals(1, actual.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerID);
        Set<Owner> actual = ownerMapService.findAll();

        assertEquals(0, actual.size());
    }

    @Test
    void delete() {
        ownerMapService.delete(testOwner);
        Set<Owner> actual = ownerMapService.findAll();

        assertEquals(0, actual.size());
    }

    @Test
    void findById() {
        Owner actual = ownerMapService.findById(1L);

        assertEquals(ownerID, actual.getId());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(2L).build();

        ownerMapService.save(owner);
        Set<Owner> actualSet = ownerMapService.findAll();

        assertEquals(2, actualSet.size());
    }

    @Test
    void saveExistingId() {
        Owner owner = Owner.builder().id(ownerID).build();

        ownerMapService.save(owner);
        Set<Owner> actualSet = ownerMapService.findAll();

        assertEquals(1, actualSet.size());
    }

    @Test
    void saveNoId() {
        Owner owner = Owner.builder().build();

        Owner actualOwner = ownerMapService.save(owner);
        Set<Owner> actualSet = ownerMapService.findAll();

        assertEquals(2, actualSet.size());
        assertNotNull(actualOwner.getId());
    }

    @Test
    void findByLastName() {
        Owner actual = ownerMapService.findByLastName(OWNER_NAME);

        assertNotNull(actual);
        assertEquals(OWNER_NAME, actual.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner actual = ownerMapService.findByLastName("foo");

        assertNull(actual);
    }
}