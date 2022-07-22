package by.iba.sfpetclinic.services;

import by.iba.sfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}

