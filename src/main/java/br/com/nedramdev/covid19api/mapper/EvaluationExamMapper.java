package br.com.nedramdev.covid19api.mapper;


import br.com.nedramdev.covid19api.dto.ExamRequest;
import br.com.nedramdev.covid19api.model.EvaluationExam;
import br.com.nedramdev.covid19api.model.EvaluationExamPK;
import br.com.nedramdev.covid19api.model.Exam;
import br.com.nedramdev.covid19api.model.Hospitalization;

 public  class EvaluationExamMapper {

     public static ExamRequest evaluationExamToDTO(EvaluationExam evaluationExam){

        ExamRequest dto = new ExamRequest();
        dto.setExamId(evaluationExam.getId().getExam().getId());
        dto.setResultDate(evaluationExam.getResultDate());
        dto.setCollectDate(evaluationExam.getCollectDate());
        dto.setHospitalizationId(evaluationExam.getId().getHospitalization().getId());

        return dto;
    }

     public static EvaluationExam dtoToEvaluationExam(ExamRequest dto){

        EvaluationExam ev = new EvaluationExam();
        Hospitalization hospitalization = new Hospitalization();
        Exam exam = new Exam();

        hospitalization.setId(dto.getHospitalizationId());
        exam.setId(dto.getExamId());

        EvaluationExamPK pk = new EvaluationExamPK(hospitalization,exam);

        ev.setId(pk);
        ev.setCollectDate(dto.getCollectDate());
        ev.setResultDate(dto.getResultDate());
        ev.setResult(dto.getResultDetails());

        return ev;
    }

}
