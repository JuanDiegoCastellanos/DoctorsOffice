package com.misiontic.doctorsOffice.repositories;

import com.misiontic.doctorsOffice.domain.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface IAppointmentRepo extends CrudRepository<Appointment, Integer> {
    
}
