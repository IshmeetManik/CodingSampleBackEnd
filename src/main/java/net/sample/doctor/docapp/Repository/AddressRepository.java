package net.sample.doctor.docapp.Repository;

import net.sample.doctor.docapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
