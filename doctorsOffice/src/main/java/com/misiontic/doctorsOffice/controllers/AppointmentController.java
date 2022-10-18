package com.misiontic.doctorsOffice.controllers;

import com.misiontic.doctorsOffice.domain.Appointment;
import com.misiontic.doctorsOffice.services.AppointmentServiceImpl;
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
@RequestMapping("/appointment")
public class AppointmentController {
    
     @Autowired
    private AppointmentServiceImpl appointmentServiceImpl;
    
    @PostMapping(value = "/")
    public ResponseEntity<Appointment> add(@RequestBody Appointment appointment){
        Appointment appointmentObj = appointmentServiceImpl.save(appointment);
        return new ResponseEntity<>(appointmentObj, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Appointment> delete(@PathVariable Integer appointmentId){
        Appointment appointmentObj = appointmentServiceImpl.findById(appointmentId);
        if(appointmentObj != null){
            appointmentServiceImpl.delete(appointmentId);
        }else{
            return new ResponseEntity<>(appointmentObj,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(appointmentObj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Appointment> update(@RequestBody Appointment appointment){
        Appointment appointmentObj = appointmentServiceImpl.findById(appointment.getAppointmentId());
        if(appointment!=null){
            appointmentObj.setDate(appointment.getDate());
            appointmentObj.setHour(appointment.getHour());
            appointmentObj.setDoctor(appointment.getDoctor());
            appointmentObj.setPatient(appointment.getPatient());
            appointmentServiceImpl.save(appointmentObj);
        }else{
            return new ResponseEntity<>(appointmentObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(appointmentObj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Appointment> getAll(){
        return appointmentServiceImpl.findAll();
    }

    @GetMapping("/list/{id}")
    public Appointment getById(@PathVariable Integer apppointmentId){
        return appointmentServiceImpl.findById(apppointmentId);
    }
    
}
