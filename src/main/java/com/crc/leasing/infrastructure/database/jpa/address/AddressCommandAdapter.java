package com.crc.leasing.infrastructure.database.jpa.address;

import com.crc.leasing.domain.model.address.Address;
import com.crc.leasing.domain.model.address.AddressRepository;
import com.crc.leasing.infrastructure.mapper.DaoMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddressCommandAdapter implements AddressRepository {
    @PersistenceContext
    EntityManager entityManager;
    AddressCommandRepositoryDAO addressCommandRepositoryDAO;
    DaoMapper daoMapper;


    @Override
    public Address save(Address address) {
        try {
            addressCommandRepositoryDAO.save(daoMapper.mapToAddressDAO(address));
        } catch (InvalidDataAccessApiUsageException e) {
            // Determine the reason why the entity is detached
            // Reattach the entity to the persistence context
            AddressDAO attachedAddress = entityManager.merge(daoMapper.mapToAddressDAO(address));
            // Use the correct method to persist or save the entity
            addressCommandRepositoryDAO.save(attachedAddress);
        }
        return address;
    }
}
