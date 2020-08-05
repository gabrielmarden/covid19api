package br.com.nedramdev.covid19api.repository;

import br.com.nedramdev.covid19api.model.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosticRepository extends JpaRepository<Diagnostic, Long> {

    @Query(value = "select * from diagnostic d where d.disease_id = :diseaseId",nativeQuery = true)
    List<Diagnostic> findByDisease(@Param("diseaseId") Long id);

    @Query(value = "select * from diagnostic d where d.hospitalization_id = :hospitalizationId",nativeQuery = true)
    List<Diagnostic> findByHospitalization(@Param("hospitalizationId") Long id);

}
