package com.misiontic.doctorsOffice.controllers;

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

import com.misiontic.doctorsOffice.domain.Medicine;
import com.misiontic.doctorsOffice.services.MedicineServiceImpl;


@RestController
@CrossOrigin("*")
@RequestMapping("/medicine")
public class MedicineController {
    
    @Autowired
    private MedicineServiceImpl medicineServiceImpl;
    
    @PostMapping(value = "/")
    public ResponseEntity<Medicine> add(@RequestBody Medicine medicine){
        Medicine medicineObj = medicineServiceImpl.save(medicine);
        return new ResponseEntity<>(medicineObj, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Medicine> delete(@PathVariable Integer id){
          Medicine medicineObj = medicineServiceImpl.findById(id);
        if(medicineObj!= null){
            medicineServiceImpl.delete(id);
        }else{
            return new ResponseEntity<>(medicineObj,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(medicineObj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Medicine> update(@RequestBody Medicine medicine){
        Medicine medicineObj = medicineServiceImpl.findById(medicine.getMedicineId());
        if(medicineObj!=null){
            medicineObj.setMedicineName(medicine.getMedicineName());
            medicineObj.setLaboratory(medicine.getLaboratory());
            medicineServiceImpl.save(medicineObj);
        }else{
            return new ResponseEntity<>(medicineObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(medicineObj,HttpStatus.OK);
    }
    
     @GetMapping("/list")
    public List<Medicine> getAll(){
        return medicineServiceImpl.findAll();
    }

    @GetMapping("/list/{id}")
    public Medicine getById(@PathVariable Integer id){
        return medicineServiceImpl.findById(id);
    }
}
