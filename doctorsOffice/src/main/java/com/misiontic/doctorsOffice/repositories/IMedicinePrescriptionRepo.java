package com.misiontic.doctorsOffice.repositories;

import com.misiontic.doctorsOffice.domain.MedicinePrescription;
import org.springframework.data.repository.CrudRepository;

public interface IMedicinePrescriptionRepo extends CrudRepository<MedicinePrescription, Integer> {
    
}
