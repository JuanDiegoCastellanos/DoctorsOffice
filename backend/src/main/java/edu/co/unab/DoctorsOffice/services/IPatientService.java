package edu.co.unab.DoctorsOffice.services;

import edu.co.unab.DoctorsOffice.domain.Patient;

import java.util.List;

public interface IPatientService {
    public Patient save(Patient patient);
    public List<Patient> getAll();
    public Patient getById(Integer patientId);
    public void delete(Integer patientId);



}
