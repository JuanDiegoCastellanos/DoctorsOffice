package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.Appointment;
import com.misiontic.doctorsOffice.repositories.IAppointmentRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppointmentServiceImpl implements IAppointmentService{

    @Autowired
    private IAppointmentRepo iAppointmentRepo;
    
    @Override
    @Transactional(readOnly = false)
    public Appointment save(Appointment appointment) {
        return iAppointmentRepo.save(appointment);
    }
       

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer appointmentId) {
        iAppointmentRepo.deleteById(appointmentId);
    }
        

    @Override
    @Transactional(readOnly = true)
    public Appointment findById(Integer appointmentId) {
        return iAppointmentRepo.findById(appointmentId).orElse(null);
    }
        
    @Override
    @Transactional(readOnly = true)
    public List<Appointment> findAll() {
        return (List<Appointment>) iAppointmentRepo.findAll();
    }
        
}
