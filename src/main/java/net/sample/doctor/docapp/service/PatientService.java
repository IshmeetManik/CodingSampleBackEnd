package net.sample.doctor.docapp.service;

import net.sample.doctor.docapp.exception.ResourceNotFoundException;
import net.sample.doctor.docapp.model.Patient;

import java.util.List;

public interface PatientService {

    public List<Patient> getAllPatient(Integer pageNo, Integer pageSize);
    public Patient getPatientById(Long id) throws ResourceNotFoundException;
    public Patient updatePatient(Long id,Patient patient) throws ResourceNotFoundException;
    public void deletePatient(Long id)throws ResourceNotFoundException;
    public Patient createPatient(Patient patient);


}
