package com.misiontic.doctorsOffice.services;
import com.misiontic.doctorsOffice.domain.Appointment;
import java.util.List;

public interface IAppointmentService {
    
    public Appointment save(Appointment appointment);
    public void delete(Integer id);
    public Appointment findById(Integer id);
    public List<Appointment> findAll();
}
