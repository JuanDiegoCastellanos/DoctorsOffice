package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.Medicine;
import java.util.List;

public interface IMedicineService {
    
    public Medicine save(Medicine medicine);
    public void delete(Integer medicineId);
    public Medicine findById(Integer medicineId);
    public List<Medicine> findAll();
}
