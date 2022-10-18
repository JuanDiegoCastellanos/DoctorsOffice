
package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.MedicalPrescription;
import com.misiontic.doctorsOffice.repositories.IMedicalPrescriptionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicalPrescriptionServiceImpl implements IMedicalPrescriptionService{

    @Autowired
    private IMedicalPrescriptionRepo iMedicalPrescription;
    
    @Override
    @Transactional(readOnly = false)
    public MedicalPrescription save(MedicalPrescription medicalPrescription) {
        return iMedicalPrescription.save(medicalPrescription);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer medicalPrescriptionId) {
        iMedicalPrescription.deleteById(medicalPrescriptionId);
    }

    @Override
    @Transactional(readOnly = true)
    public MedicalPrescription findById(Integer medicalPrescriptionId) {
        return iMedicalPrescription.findById(medicalPrescriptionId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalPrescription> findAll() {
        return (List<MedicalPrescription>)iMedicalPrescription.findAll();
    }
   
}
