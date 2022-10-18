package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.Schedule;
import com.misiontic.doctorsOffice.repositories.IScheduleRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleServiceImpl implements IScheduleService{

    @Autowired
    private IScheduleRepo iScheduleRepo;
    
    @Override
    @Transactional(readOnly = false)
    public Schedule save(Schedule schedule) {
        return iScheduleRepo.save(schedule);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer scheduleId) {
        iScheduleRepo.deleteById(scheduleId);
    }

    @Override
    @Transactional(readOnly = true)
    public Schedule findById(Integer scheduleId) {
        return iScheduleRepo.findById(scheduleId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Schedule> findAll() {
        return (List<Schedule>) iScheduleRepo.findAll();
    }
    
}
