package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.MedicinePrescription;
import java.util.List;

public interface IMedicinePrescriptionService {
    
    public MedicinePrescription save(MedicinePrescription medicinePrescription);
    public void delete(Integer medicinePrescriptionId);
    public MedicinePrescription findById(Integer medicinePrescriptionId);
    public List<MedicinePrescription> findAll();
}
