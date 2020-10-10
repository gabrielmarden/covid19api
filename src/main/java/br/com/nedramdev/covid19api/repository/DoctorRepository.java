package br.com.nedramdev.covid19api.repository;

import br.com.nedramdev.covid19api.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    List<Doctor> findByHospitalId(Long id);
}
