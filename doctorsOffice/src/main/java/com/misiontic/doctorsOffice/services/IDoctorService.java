package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.Doctor;
import java.util.List;

public interface IDoctorService {
    
    public Doctor save(Doctor doctor);
    public void delete(Integer doctorId);
    public Doctor findById(Integer doctorId);
    public List<Doctor> findAll();
}
