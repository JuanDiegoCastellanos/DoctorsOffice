package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.Doctor;
import com.misiontic.doctorsOffice.repositories.IDoctorRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorServiceImpl implements IDoctorService{

    @Autowired
    private IDoctorRepo iDoctorRepo;
    
    @Override
    @Transactional(readOnly = false)
    public Doctor save(Doctor doctor) {
       return iDoctorRepo.save(doctor);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer doctorId) {
        iDoctorRepo.deleteById(doctorId);
    }  

    @Override
    @Transactional(readOnly = true)
    public Doctor findById(Integer doctorId) {
        return iDoctorRepo.findById(doctorId).orElse(null);
    }
       
    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findAll() {
        return (List<Doctor>) iDoctorRepo.findAll();
    }
        
    
}
