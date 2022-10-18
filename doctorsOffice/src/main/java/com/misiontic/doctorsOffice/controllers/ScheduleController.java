package com.misiontic.doctorsOffice.controllers;

import com.misiontic.doctorsOffice.domain.Schedule;
import com.misiontic.doctorsOffice.services.ScheduleServiceImpl;
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
@RequestMapping("/schedule")
public class ScheduleController {
    
    @Autowired
    private ScheduleServiceImpl scheduleServiceImpl;
    
     @PostMapping(value = "/")
    public ResponseEntity<Schedule> add(@RequestBody Schedule schedule){
        Schedule scheduleObj = scheduleServiceImpl.save(schedule);
        return new ResponseEntity<>(scheduleObj, HttpStatus.OK);
    }
    
     
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Schedule> delete(@PathVariable Integer scheduleId){
          Schedule scheduleObj = scheduleServiceImpl.findById(scheduleId);
        if(scheduleObj!= null){
            scheduleServiceImpl.delete(scheduleId);
        }else{
            return new ResponseEntity<>(scheduleObj,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(scheduleObj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Schedule> update(@RequestBody Schedule schedule){
        Schedule scheduleObj = scheduleServiceImpl.findById(schedule.getScheduleId());
        if(schedule!=null){
            scheduleObj.setScheduleWeek(schedule.getScheduleWeek());
            scheduleObj.setScheduleDay(schedule.getScheduleDay());
            scheduleObj.setScheduleHour(schedule.getScheduleHour());
            scheduleObj.setDoctor(schedule.getDoctor());
            scheduleServiceImpl.save(scheduleObj);
        }else{
            return new ResponseEntity<>(scheduleObj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(scheduleObj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Schedule> getAll(){
        return scheduleServiceImpl.findAll();
    }

    @GetMapping("/list/{id}")
    public Schedule getById(@PathVariable Integer scheduleId){
        return scheduleServiceImpl.findById(scheduleId);
    }
    
}
