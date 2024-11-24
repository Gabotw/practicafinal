package org.hign.platform.practicafinal.assessment.interfaces.REST.transform;

import org.hign.platform.practicafinal.assessment.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.practicafinal.assessment.interfaces.REST.resources.CreateExaminerResource;

public class CreateExaminerCommandFromAssembler {
    public static CreateExaminerCommand toCommandFromResource(CreateExaminerResource resource) {
        return new CreateExaminerCommand(resource.firstName(), resource.lastName(), resource.npi());
    }
}
