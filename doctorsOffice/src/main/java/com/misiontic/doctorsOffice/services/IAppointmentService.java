package com.misiontic.doctorsOffice.services;
import com.misiontic.doctorsOffice.domain.Appointment;
import java.util.List;

public interface IAppointmentService {
    
    public Appointment save(Appointment appointment);
    public void delete(Integer appointmentId);
    public Appointment findById(Integer appointmentId);
    public List<Appointment> findAll();
}
