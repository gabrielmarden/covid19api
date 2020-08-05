package br.com.nedramdev.covid19api.repository;

import br.com.nedramdev.covid19api.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long> {
}
