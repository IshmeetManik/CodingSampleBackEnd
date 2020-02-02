package net.sample.doctor.docapp.service;

import net.sample.doctor.docapp.Repository.AddressRepository;
import net.sample.doctor.docapp.Repository.PatientRepository;
import net.sample.doctor.docapp.exception.ResourceNotFoundException;
import net.sample.doctor.docapp.model.Address;
import net.sample.doctor.docapp.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PatientServiceImpl implements  PatientService {

    @Autowired
    private PatientRepository repository;
    @Autowired
    private AddressRepository addressRepository;



    @Override
    public List<Patient> getAllPatient(Integer pageNo, Integer pageSize) {
        if(pageNo==null){
            Page<Patient> pagedResult = repository.findAll(Pageable.unpaged());
            if(pagedResult.hasContent()) {
                return pagedResult.getContent();
            } else {
                return Collections.emptyList();
            }
        }

        if(pageSize==null)
        {pageSize=10;}
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<Patient> pagedResult = repository.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return Collections.emptyList();
        }

    }

    @Override
    public Patient getPatientById(Long id) throws ResourceNotFoundException {
        Patient patient=repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient  not found for this id :: " + id));
        return patient;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Patient updatePatient(Long id,Patient patient) throws ResourceNotFoundException {
        deletePatient(id);
        Set<Address> addressList=patient.getAddressSet();
        patient.setAddressSet(Collections.emptySet());
        patient =createPatient(patient);
        if( addressList.size() > 0 )
        {
            for(Address address:addressList){
                address.setPatient(patient);
                addressRepository.save(address);

            } ;
        }
       return  patient;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePatient(Long id) throws ResourceNotFoundException {
        Patient employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + id));
        repository.delete(employee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Patient createPatient(Patient patient) {
        return repository.save(patient);
    }
}
