package org.hign.platform.practicafinal.personnel.interfaces.REST.transform;

import org.hign.platform.practicafinal.personnel.interfaces.REST.resources.MentalStateExamResource;
import org.hign.platform.practicafinal.personnel.domain.model.aggregates.MentalStateExam;

public class MentalStateExamResourceFromEntityAssembler {
    public static MentalStateExamResource toResourceFromEntity(MentalStateExam entity) {
        return new MentalStateExamResource(entity.getId(), entity.getPatientId(), entity.getExaminerNpi(), entity.getExamnDate(), entity.getOrientationScore(), entity.getRegistrationScore(), entity.getAttenAndCalScore(), entity.getRecallScore(), entity.getLanguageScore());
    }
}
