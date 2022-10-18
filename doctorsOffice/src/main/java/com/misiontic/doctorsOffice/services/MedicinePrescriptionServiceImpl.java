package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.MedicinePrescription;
import com.misiontic.doctorsOffice.repositories.IMedicinePrescriptionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicinePrescriptionServiceImpl implements IMedicinePrescriptionService{
 
    @Autowired
    private IMedicinePrescriptionRepo iMedicinePrescriptionRepo;

    @Override
    @Transactional(readOnly = false)
    public MedicinePrescription save(MedicinePrescription medicinePrescription) {
        return iMedicinePrescriptionRepo.save(medicinePrescription);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer medicinePrescriptionId) {
        iMedicinePrescriptionRepo.deleteById(medicinePrescriptionId);
    }

    @Override
    @Transactional(readOnly = true)
    public MedicinePrescription findById(Integer medicinePrescriptionId) {
        return iMedicinePrescriptionRepo.findById(medicinePrescriptionId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicinePrescription> findAll() {
        return (List<MedicinePrescription>) iMedicinePrescriptionRepo.findAll();
    }
    
    
}
