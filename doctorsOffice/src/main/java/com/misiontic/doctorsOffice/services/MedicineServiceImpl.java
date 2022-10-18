package com.misiontic.doctorsOffice.services;

import com.misiontic.doctorsOffice.domain.Medicine;
import com.misiontic.doctorsOffice.repositories.IMedicineRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicineServiceImpl implements IMedicineService{

    @Autowired
    private IMedicineRepo iMedicineRepo;
    
    @Override
    @Transactional(readOnly = false)
    public Medicine save(Medicine medicine) {
        return iMedicineRepo.save(medicine);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer medicineId) {
        iMedicineRepo.deleteById(medicineId);
    }

    @Override
    @Transactional(readOnly = true)
    public Medicine findById(Integer medicineId) {
        return iMedicineRepo.findById(medicineId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Medicine> findAll() {
        return (List<Medicine>) iMedicineRepo.findAll();
    }
    
}
