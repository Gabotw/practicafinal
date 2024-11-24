package org.hign.platform.practicafinal.assessment.domain.services;

import org.hign.platform.practicafinal.assessment.domain.model.commands.CreateExaminerCommand;

public interface ExaminerCommandService {
    Long handle(CreateExaminerCommand command);
}
