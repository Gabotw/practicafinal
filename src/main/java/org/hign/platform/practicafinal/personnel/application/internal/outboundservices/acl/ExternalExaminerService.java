package org.hign.platform.practicafinal.personnel.application.internal.outboundservices.acl;

import org.hign.platform.practicafinal.assessment.interfaces.acl.ExaminerContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalExaminerService {
    private final ExaminerContextFacade examinerContextFacade;

    public ExternalExaminerService(ExaminerContextFacade examinerContextFacade) {
        this.examinerContextFacade = examinerContextFacade;
    }

    public Optional<String> fetchExaminerByNpi(String npi) {
        var examinerId = examinerContextFacade.fecthExaminerByNpi(npi);
        return examinerId == 0L ? Optional.empty() : Optional.of(npi);
    }
}