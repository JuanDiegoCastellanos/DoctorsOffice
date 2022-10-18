package com.misiontic.doctorsOffice.repositories;

import com.misiontic.doctorsOffice.domain.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface IDoctorRepo extends CrudRepository<Doctor, Integer>{
    
}
