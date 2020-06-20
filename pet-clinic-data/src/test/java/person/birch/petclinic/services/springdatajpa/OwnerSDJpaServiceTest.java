package person.birch.petclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import person.birch.petclinic.model.Owner;
import person.birch.petclinic.repositories.OwnerRepository;
import person.birch.petclinic.repositories.PetRepository;
import person.birch.petclinic.repositories.PetTypeRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private static final long ownerID= 1L;
    private static final String OWNER_NAME = "Smith";
    private static final Owner testOwner = Owner.builder().id(ownerID).lastName(OWNER_NAME).build();

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(eq(OWNER_NAME))).thenReturn(testOwner);

        Owner actual = ownerSDJpaService.findByLastName(OWNER_NAME);

        verify(ownerRepository, times(1)).findByLastName(anyString());

        assertNotNull(actual);
        assertEquals(OWNER_NAME, actual.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(null);

        Owner actual = ownerSDJpaService.findByLastName("foo");

        verify(ownerRepository, times(1)).findByLastName(anyString());

        assertNull(actual);
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(List.of(testOwner));

        Set<Owner> actual = ownerSDJpaService.findAll();

        verify(ownerRepository, times(1)).findAll();

        assertFalse(actual.isEmpty());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(eq(ownerID))).thenReturn(Optional.of(testOwner));

        Owner actual = ownerSDJpaService.findById(ownerID);

        verify(ownerRepository, times(1)).findById(anyLong());

        assertNotNull(actual);
        assertEquals(ownerID, actual.getId());
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner actual = ownerSDJpaService.findById(2L);

        verify(ownerRepository, times(1)).findById(anyLong());

        assertNull(actual);
    }

    @Test
    void save() {
        when(ownerRepository.save(any(Owner.class))).thenReturn(testOwner);

        Owner actual = ownerSDJpaService.save(testOwner);

        verify(ownerRepository, times(1)).save(any(Owner.class));

        assertNotNull(actual);
        assertEquals(ownerID, actual.getId());
    }

    @Test
    void delete() {
        doNothing().when(ownerRepository).delete(any(Owner.class));

        ownerRepository.delete(testOwner);

        verify(ownerRepository, times(1)).delete(eq(testOwner));
    }

    @Test
    void deleteById() {
        doNothing().when(ownerRepository).deleteById(anyLong());

        ownerRepository.deleteById(ownerID);

        verify(ownerRepository, times(1)).deleteById(eq(ownerID));
    }
}