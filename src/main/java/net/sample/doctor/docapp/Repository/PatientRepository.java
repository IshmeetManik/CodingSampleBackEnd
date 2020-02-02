package net.sample.doctor.docapp.Repository;

import net.sample.doctor.docapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PatientRepository extends PagingAndSortingRepository<Patient,Long> {
}
