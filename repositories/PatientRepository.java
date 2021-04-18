package ma.enset.springactivitepratique2.repositories;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.enset.springactivitepratique2.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
	public List<Patient>findByNomContains(String nom);
	public List<Patient>findByEstMalade(boolean estMalade);
	public List<Patient>findByNomContainsAndEstMalade(String nom,boolean estMalade);
	public Page<Patient>findByNomContains(String kw,Pageable pageable);
	
}
