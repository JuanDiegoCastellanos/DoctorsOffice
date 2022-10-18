package com.misiontic.doctorsOffice.repositories;

import com.misiontic.doctorsOffice.domain.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface IScheduleRepo extends CrudRepository<Schedule, Integer>{
    
}
