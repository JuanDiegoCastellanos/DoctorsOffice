package com.misiontic.doctorsOffice.controllers;

import com.misiontic.doctorsOffice.domain.MedicalPrescription;
import com.misiontic.doctorsOffice.services.MedicalPrescriptionServiceImpl;
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

@RestController
@CrossOrigin("*")
@RequestMapping("/medicalprescription")
public class MedicalPrescriptionController {

    @Autowired
    private MedicalPrescriptionServiceImpl medicalPrescriptionServiceImpl;

    @PostMapping(value = "/")
    public ResponseEntity<MedicalPrescription> add(@RequestBody MedicalPrescription medicalPrescription) {
        MedicalPrescription medicalPrescriptionObj = medicalPrescriptionServiceImpl.save(medicalPrescription);
        return new ResponseEntity<>(medicalPrescriptionObj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MedicalPrescription> delete(@PathVariable Integer id) {
        MedicalPrescription medicalPrescriptionObj = medicalPrescriptionServiceImpl.findById(id);
        if (medicalPrescriptionObj != null) {
            medicalPrescriptionServiceImpl.delete(id);
        } else {
            return new ResponseEntity<>(medicalPrescriptionObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(medicalPrescriptionObj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<MedicalPrescription> update(@RequestBody MedicalPrescription medicalPrescription){
        MedicalPrescription medicalPrescriptionObj = medicalPrescriptionServiceImpl.findById(medicalPrescription.getMedicalprescriptionId());
        if(medicalPrescriptionObj!=null){
            medicalPrescriptionObj.setDate(medicalPrescription.getDate());
            medicalPrescriptionObj.setAmountMedicines(medicalPrescription.getAmountMedicines());
            medicalPrescriptionObj.setDoctor(medicalPrescription.getDoctor());
            medicalPrescriptionObj.setPatient(medicalPrescription.getPatient());
            medicalPrescriptionServiceImpl.save(medicalPrescriptionObj);
        }else{
            return new ResponseEntity<>(medicalPrescriptionObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(medicalPrescriptionObj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<MedicalPrescription> getAll(){
        return medicalPrescriptionServiceImpl.findAll();
    }

    @GetMapping("/list/{id}")
    public MedicalPrescription getById(@PathVariable Integer id){
        return medicalPrescriptionServiceImpl.findById(id);
    }
    
    
}
