package org.hign.platform.practicafinal.assessment.application.internal.queryservices;

import org.hign.platform.practicafinal.assessment.domain.model.aggregates.Examiner;
import org.hign.platform.practicafinal.assessment.domain.model.queries.GetAllExaminersQuery;
import org.hign.platform.practicafinal.assessment.domain.model.queries.GetExaminerByIdQuery;
import org.hign.platform.practicafinal.assessment.domain.services.ExaminerQueryService;
import org.hign.platform.practicafinal.assessment.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExaminerQueryServiceImpl implements ExaminerQueryService {
    private final ExaminerRepository examinerRepository;

    public ExaminerQueryServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }
    @Override
    public Optional<Examiner> handle(GetExaminerByIdQuery query) {
        return examinerRepository.findById(query.id());
    }

    @Override
    public List<Examiner> handle(GetAllExaminersQuery query) {
        return examinerRepository.findAll();
    }
}
