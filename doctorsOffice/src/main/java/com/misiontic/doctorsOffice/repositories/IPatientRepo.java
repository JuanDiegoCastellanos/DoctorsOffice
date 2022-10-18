package com.misiontic.doctorsOffice.repositories;

import com.misiontic.doctorsOffice.domain.Patient;
import org.springframework.data.repository.CrudRepository;

public interface IPatientRepo extends CrudRepository<Patient, Integer> {
    
}
