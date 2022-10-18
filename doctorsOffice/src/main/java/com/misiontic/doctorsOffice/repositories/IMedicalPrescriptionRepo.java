package com.misiontic.doctorsOffice.repositories;

import com.misiontic.doctorsOffice.domain.MedicalPrescription;
import org.springframework.data.repository.CrudRepository;

public interface IMedicalPrescriptionRepo extends CrudRepository<MedicalPrescription, Integer>{
    
}
