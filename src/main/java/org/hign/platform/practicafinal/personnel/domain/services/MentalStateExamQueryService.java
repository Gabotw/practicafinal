package org.hign.platform.practicafinal.personnel.domain.services;

import org.hign.platform.practicafinal.assessment.domain.model.queries.GetAllExaminersQuery;
import org.hign.platform.practicafinal.assessment.domain.model.queries.GetExaminerByIdQuery;
import org.hign.platform.practicafinal.personnel.domain.model.aggregates.MentalStateExam;

import java.util.List;
import java.util.Optional;

public interface MentalStateExamQueryService {
    Optional<MentalStateExam> handle(GetExaminerByIdQuery query);
    List<MentalStateExam> handle(GetAllExaminersQuery query);
}
