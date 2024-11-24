package org.hign.platform.practicafinal.assessment.application.acl;

import org.hign.platform.practicafinal.assessment.domain.model.queries.GetExaminerByNpiQuery;
import org.hign.platform.practicafinal.assessment.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.practicafinal.assessment.domain.services.ExaminerCommandService;
import org.hign.platform.practicafinal.assessment.domain.services.ExaminerQueryService;
import org.hign.platform.practicafinal.assessment.interfaces.acl.ExaminerContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExaminerContextFacadeImpl implements ExaminerContextFacade {
    private final ExaminerQueryService examinerQueryService;

    public ExaminerContextFacadeImpl(ExaminerQueryService examinerQueryService) {
        this.examinerQueryService = examinerQueryService;
    }

    public Long fecthExaminerByNpi(String npi) {
        var getExaminerByNpiQuery = new GetExaminerByNpiQuery(new NationalProviderIdentifier(npi));
        var examiner = examinerQueryService.handle(getExaminerByNpiQuery);
        return examiner.isEmpty() ? Long.valueOf(0L) : examiner.get().getId();
    }
}
