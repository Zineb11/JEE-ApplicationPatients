package ma.enset.springactivitepratique2;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.enset.springactivitepratique2.entities.Patient;
import ma.enset.springactivitepratique2.repositories.PatientRepository;

@SpringBootApplication
public class SpringAp2Application implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringAp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Ahmed",new Date(),1111,true));
	    patientRepository.save(new Patient(null,"Leila",new Date(),2222,false));
	    patientRepository.save(new Patient(null,"Jihane",new Date(),3333,false));
	    patientRepository.save(new Patient(null,"Saad",new Date(),4444,false));
	    patientRepository.save(new Patient(null,"Mehdi",new Date(),5555,true));
	    patientRepository.save(new Patient(null,"Yassine",new Date(),6666,true));
	    System.out.println("********************");
        patientRepository.findAll().forEach(p->{
        	System.out.println(p.toString());
        });
        System.out.println("********************");
        List<Patient>patients1=patientRepository.findByNomContains("a");
		patients1.forEach(p->{
			System.out.println(p.toString());
		});
        System.out.println("********************");
        List<Patient>patients2=patientRepository.findByEstMalade(true);
		patients2.forEach(p->{
			System.out.println(p.toString());
		});
        System.out.println("********************");
        List<Patient>patients3=patientRepository.findByNomContainsAndEstMalade("e", false);
        patients3.forEach(p->{
        	System.out.println(p.toString());
        });

	}

}
