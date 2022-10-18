package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.Schedule;
import java.util.List;

public interface IScheduleService {
    
    public Schedule save(Schedule schedule);
    public void delete(Integer scheduleId);
    public Schedule findById(Integer scheduleId);
    public List<Schedule> findAll();
}
