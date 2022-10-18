package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.Patient;
import java.util.List;

public interface IPatientService {
    
    public Patient save(Patient patient);
    public void delete(Integer patientId);
    public Patient findById(Integer patientId);
    public List<Patient> findAll();
}
