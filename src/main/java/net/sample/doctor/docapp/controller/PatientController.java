package net.sample.doctor.docapp.controller;


import net.bytebuddy.asm.Advice;
import net.sample.doctor.docapp.exception.ResourceNotFoundException;
import net.sample.doctor.docapp.model.Address;
import net.sample.doctor.docapp.model.Patient;
import net.sample.doctor.docapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*", allowCredentials = "true")
public class PatientController {

@Autowired
private PatientService service ;

    @GetMapping("/patients")
    public List<Patient> getAllEmployees(@RequestParam(value="pageNo",required = false) Integer pageNo,@RequestParam(value="size",required=false) Integer pageSize) {
        return service.getAllPatient(pageNo,pageSize);
    }
    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") Long patientId)throws ResourceNotFoundException{
        Patient patient=null;
        try{
            patient =service.getPatientById(patientId);
        }
        catch(ResourceNotFoundException e){
            throw e ;
        }
        return ResponseEntity.ok().body(patient);
    }
    @DeleteMapping("/patient/{id}")
    public Map<String,Boolean> deletePatient(@PathVariable(value = "id") Long patientId)throws ResourceNotFoundException{
        Patient patient=null;
        try{
            service.deletePatient(patientId);
        }
        catch(ResourceNotFoundException e){
            throw e ;
        }
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PostMapping("/patient")
    public Patient createPatient(@Valid @RequestBody Patient patient){
        if( patient.getAddressSet().size() > 0 )
        {
            patient.getAddressSet().stream().forEach( address -> {
                address.setPatient( patient );
            } );
        }



    return service.createPatient(patient);
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id")Long patientId,@Valid @RequestBody Patient patientDetails) throws ResourceNotFoundException {
        Patient patient=null;
        try{
//            service.deletePatient(patientId);
//            Set<Address> addressList=patientDetails.getAddressSet();
//            patientDetails.setAddressSet(Collections.emptySet());
//            patient =service.createPatient(patientDetails);
//            if( addressList.size() > 0 )
//            {
//                for(Address address:addressList){
//                    address.setPatient(patient);
//                    service.updatePatient(address);
//
//                } ;
//            }
           patient =service.updatePatient(patientId,patientDetails);
        }
        catch(ResourceNotFoundException e){
            throw e ;
        }
        return ResponseEntity.ok().body(patient);

    }


}
