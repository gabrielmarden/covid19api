package br.com.nedramdev.covid19api.repository;

import br.com.nedramdev.covid19api.model.Hospitalization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface HospitalizationRepository extends JpaRepository<Hospitalization,Long> {

    @Query(value = "select h from Hospitalization h " +
            "join h.diagnostics d " +
            "join d.id.disease s " +
            "where s.name like concat('%',:diseaseName,'%') ")
    Page<Hospitalization> findByDisease(@Param("diseaseName") String diseaseName, Pageable pageable);

}
