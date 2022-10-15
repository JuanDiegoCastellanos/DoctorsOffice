
package edu.co.unab.DoctorsOffice.repositories;

import edu.co.unab.DoctorsOffice.domain.Patient;
import org.springframework.data.repository.CrudRepository;

public interface IPatientRepo extends CrudRepository<Patient,Integer> {
    
}
