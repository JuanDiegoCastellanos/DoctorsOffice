package com.misiontic.doctorsOffice.controllers;

import com.misiontic.doctorsOffice.domain.MedicinePrescription;
import com.misiontic.doctorsOffice.services.MedicinePrescriptionServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("/medicineprescription")
public class MedicinePrescriptionController {
    
    @Autowired
    private MedicinePrescriptionServiceImpl medicinePrescriptionServiceImpl;
    
    @PostMapping(value = "/")
    public ResponseEntity<MedicinePrescription> add(@RequestBody MedicinePrescription medicinePrescription){
        MedicinePrescription medicinePrescriptionObj = medicinePrescriptionServiceImpl.save(medicinePrescription);
        return new ResponseEntity<>(medicinePrescriptionObj, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MedicinePrescription> delete(@PathVariable Integer medicinePrescriptionId){
        MedicinePrescription medicinePrescriptionObj = medicinePrescriptionServiceImpl.findById(medicinePrescriptionId);
        if(medicinePrescriptionObj != null){
            medicinePrescriptionServiceImpl.delete(medicinePrescriptionId);
        }else{
            return new ResponseEntity<>(medicinePrescriptionObj,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(medicinePrescriptionObj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<MedicinePrescription> update(@RequestBody MedicinePrescription medicinePrescription){
        MedicinePrescription medicinePrescriptionObj = medicinePrescriptionServiceImpl.findById(medicinePrescription.getMedicinePrecriptionId());
        if(medicinePrescription!=null){
            medicinePrescriptionObj.setMedicalPrescription(medicinePrescription.getMedicalPrescription());
            medicinePrescriptionObj.setMedicine(medicinePrescription.getMedicine());
            medicinePrescriptionServiceImpl.save(medicinePrescriptionObj);
        }else{
            return new ResponseEntity<>(medicinePrescriptionObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(medicinePrescriptionObj,HttpStatus.OK);
    }
    
     @GetMapping("/list")
    public List<MedicinePrescription> getAll(){
        return medicinePrescriptionServiceImpl.findAll();
    }

    @GetMapping("/list/{id}")
    public MedicinePrescription getById(@PathVariable Integer medicinePrescriptionId){
        return medicinePrescriptionServiceImpl.findById(medicinePrescriptionId);
    }
}
