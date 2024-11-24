package org.hign.platform.practicafinal.assessment.domain.services;

import org.hign.platform.practicafinal.assessment.domain.model.aggregates.Examiner;
import org.hign.platform.practicafinal.assessment.domain.model.queries.GetAllExaminersQuery;
import org.hign.platform.practicafinal.assessment.domain.model.queries.GetExaminerByIdQuery;
import org.hign.platform.practicafinal.assessment.domain.model.queries.GetExaminerByNpiQuery;

import java.util.List;
import java.util.Optional;

public interface ExaminerQueryService {
    Optional<Examiner> handle(GetExaminerByIdQuery query);
    List<Examiner> handle(GetAllExaminersQuery query);
    Optional<Examiner> handle(GetExaminerByNpiQuery query);
}
