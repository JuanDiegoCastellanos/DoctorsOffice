package edu.co.unab.DoctorsOffice.services;

import edu.co.unab.DoctorsOffice.domain.Patient;
import edu.co.unab.DoctorsOffice.repositories.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService{

    @Autowired
    private IPatientRepo iPatientRepo;

    @Override
    @Transactional(readOnly = false)
    public Patient save(Patient patient) {
        return iPatientRepo.save(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> getAll() {
        return (List<Patient>) iPatientRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Patient getById(Integer patientId) {
        return iPatientRepo.findById(patientId).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer patientId) {
        iPatientRepo.deleteById(patientId);
    }
}
