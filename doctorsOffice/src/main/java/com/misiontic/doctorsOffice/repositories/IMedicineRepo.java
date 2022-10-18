package com.misiontic.doctorsOffice.repositories;

import com.misiontic.doctorsOffice.domain.Medicine;
import org.springframework.data.repository.CrudRepository;

public interface IMedicineRepo extends CrudRepository<Medicine, Integer>{
    
}
