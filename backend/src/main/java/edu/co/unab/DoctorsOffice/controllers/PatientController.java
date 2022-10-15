package edu.co.unab.DoctorsOffice.controllers;

import edu.co.unab.DoctorsOffice.domain.Patient;
import edu.co.unab.DoctorsOffice.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping(value = "/")
    public ResponseEntity<Patient> add(@RequestBody Patient patient){
        Patient patientObj = patientService.save(patient);
        return new ResponseEntity<>(patientObj, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Patient> delete(@PathVariable Integer patientId){
        Patient patientObj = patientService.getById(patientId);
        if(patientObj != null){
            patientService.delete(patientId);
        }else{
            return new ResponseEntity<>(patientObj,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(patientObj, HttpStatus.OK);
    }
    @PutMapping(value = "/")
    public ResponseEntity<Patient> update(@RequestBody Patient patient){
        Patient patientObj = patientService.getById(patient.getPatientId());
        if(patient!=null){
            patientObj.setPatientName(patient.getPatientName());
            patientObj.setPatientLastname(patient.getPatientLastname());
            patientObj.setPatientAge(patient.getPatientAge());
            patientObj.setPatientGender(patient.getPatientGender());
            patientObj.setPatientDocument(patient.getPatientDocument());
            patientObj.setPatientDocumentType(patient.getPatientDocumentType());
            patientObj.setPatientPhoneNumber(patient.getPatientPhoneNumber());
            patientObj.setPatientEps(patient.getPatientEps());
            patientService.save(patientObj);
        }else{
            return new ResponseEntity<>(patientObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(patientObj,HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<Patient> getAll(){
        return patientService.getAll();
    }

    @GetMapping("/list/{id}")
    public Patient getById(@PathVariable Integer patientId){
        return patientService.getById(patientId);
    }


}
