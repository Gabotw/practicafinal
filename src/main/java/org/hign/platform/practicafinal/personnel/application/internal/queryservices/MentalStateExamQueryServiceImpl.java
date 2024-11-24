package org.hign.platform.practicafinal.personnel.application.internal.queryservices;

import org.hign.platform.practicafinal.assessment.domain.model.queries.GetAllExaminersQuery;
import org.hign.platform.practicafinal.assessment.domain.model.queries.GetExaminerByIdQuery;
import org.hign.platform.practicafinal.personnel.domain.model.aggregates.MentalStateExam;
import org.hign.platform.practicafinal.personnel.domain.services.MentalStateExamQueryService;
import org.hign.platform.practicafinal.personnel.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;

import java.util.List;
import java.util.Optional;

public class MentalStateExamQueryServiceImpl implements MentalStateExamQueryService {
    private final MentalStateExamRepository mentalStateExamRepository;

    public MentalStateExamQueryServiceImpl(MentalStateExamRepository mentalStateExamRepository) {
        this.mentalStateExamRepository = mentalStateExamRepository;
    }

    @Override
    public Optional<MentalStateExam> handle(GetExaminerByIdQuery query) {
        return mentalStateExamRepository.findById(query.id());
    }

    @Override
    public List<MentalStateExam> handle(GetAllExaminersQuery query) {
        return mentalStateExamRepository.findAll();
    }
}
