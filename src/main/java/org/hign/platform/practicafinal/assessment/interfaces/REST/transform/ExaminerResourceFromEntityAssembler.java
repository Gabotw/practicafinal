package org.hign.platform.practicafinal.assessment.interfaces.REST.transform;

import org.hign.platform.practicafinal.assessment.domain.model.aggregates.Examiner;
import org.hign.platform.practicafinal.assessment.interfaces.REST.resources.ExaminerResource;

public class ExaminerResourceFromEntityAssembler {
    public static ExaminerResource toResourceFromEntity(Examiner examiner) {
        return new ExaminerResource(examiner.getId(), examiner.getFirstName(), examiner.getLastName(), examiner.getNpi().nationalProviderIdentifier());
    }
}
