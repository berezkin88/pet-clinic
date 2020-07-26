package person.birch.petclinic.formatters;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import person.birch.petclinic.model.PetType;
import person.birch.petclinic.services.PetTypeService;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

/**
 * @author Aleksandr Beryozkin
 */

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService service;

    public PetTypeFormatter(PetTypeService service) {
        this.service = service;
    }

    @Override
    public PetType parse(String s, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = service.findAll();
        for (PetType type : findPetTypes) {
            if (type.getName().equals(s)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + s, 0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
