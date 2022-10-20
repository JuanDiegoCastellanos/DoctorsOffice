
package com.misiontic.doctorsOffice.controllers;

import com.misiontic.doctorsOffice.domain.Doctor;
import com.misiontic.doctorsOffice.services.DoctorServiceImpl;
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
@RequestMapping("/doctor")
public class DoctorController {
        
    @Autowired
    private DoctorServiceImpl doctorServiceImpl;
    
    @PostMapping(value = "/")
    public ResponseEntity<Doctor> add(@RequestBody Doctor doctor){
        Doctor doctorObj = doctorServiceImpl.save(doctor);
        return new ResponseEntity<>(doctorObj, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Doctor> delete(@PathVariable Integer id){
        Doctor doctorObj = doctorServiceImpl.findById(id);
        if(doctorObj != null){
            doctorServiceImpl.delete(id);
        }else{
            return new ResponseEntity<>(doctorObj,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(doctorObj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Doctor> update(@RequestBody Doctor doctor){
        Doctor doctorObj = doctorServiceImpl.findById(doctor.getDoctorId());
        if(doctorObj!=null){
            doctorObj.setDoctorName(doctor.getDoctorName());
            doctorObj.setDoctorLastname(doctor.getDoctorLastname());
            doctorObj.setDoctorAge(doctor.getDoctorAge());
            doctorObj.setDoctorGender(doctor.getDoctorGender());
            doctorObj.setDoctorDocument(doctor.getDoctorDocument());
            doctorObj.setDoctorDocumentType(doctor.getDoctorDocumentType());
            doctorObj.setDoctorPhoneNumber(doctor.getDoctorPhoneNumber());
            doctorServiceImpl.save(doctorObj);
        }else{
            return new ResponseEntity<>(doctorObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(doctorObj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Doctor> getAll(){
        return doctorServiceImpl.findAll();
    }

    @GetMapping("/list/{id}")
    public Doctor getById(@PathVariable Integer id){
        return doctorServiceImpl.findById(id);
    }
}
