package com.misiontic.doctorsOffice.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.doctorsOffice.domain.Patient;
import com.misiontic.doctorsOffice.services.PatientServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientServiceImpl;

    @PostMapping(value = "/")
    public ResponseEntity<Patient> add(@RequestBody Patient patient) {
        Patient patientObj = patientServiceImpl.save(patient);
        return new ResponseEntity<>(patientObj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Patient> delete(@PathVariable Integer id) {
        Patient patientObj = patientServiceImpl.findById(id);
        if (patientObj != null) {
            patientServiceImpl.delete(id);
        } else {
            return new ResponseEntity<>(patientObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(patientObj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Patient> update(@RequestBody Patient patient) {
        Patient patientObj = patientServiceImpl.findById(patient.getPatientId());
        if (patientObj != null) {
            patientObj.setPatientName(patient.getPatientName());
            patientObj.setPatientLastname(patient.getPatientLastname());
            patientObj.setPatientAge(patient.getPatientAge());
            patientObj.setPatientGender(patient.getPatientGender());
            patientObj.setPatientDocument(patient.getPatientDocument());
            patientObj.setPatientDocumentType(patient.getPatientDocumentType());
            patientObj.setPatientPhoneNumber(patient.getPatientPhoneNumber());
            patientObj.setPatientEps(patient.getPatientEps());
            patientServiceImpl.save(patientObj);
        } else {
            return new ResponseEntity<>(patientObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(patientObj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Patient> getAll() {
        return (List<Patient>) patientServiceImpl.findAll();
    }

    @GetMapping("/list/{id}")
    public Patient getById(@PathVariable Integer id) {
        return patientServiceImpl.findById(id);
    }
}
