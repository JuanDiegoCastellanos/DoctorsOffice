
package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.Patient;
import com.misiontic.doctorsOffice.repositories.IPatientRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientServiceImpl implements IPatientService {
    
    @Autowired
    private IPatientRepo iPatientRepo;

    @Override
    @Transactional(readOnly = false)
    public Patient save(Patient patient) {
        return iPatientRepo.save(patient);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer patientId) {
        iPatientRepo.deleteById(patientId);
    }

    @Override
    @Transactional(readOnly = true)
    public Patient findById(Integer patientId) {
        return iPatientRepo.findById(patientId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> findAll() {
        return (List<Patient>) iPatientRepo.findAll();
    }
   
}
