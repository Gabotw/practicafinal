package org.hign.platform.practicafinal.personnel.interfaces.REST.transform;

import org.hign.platform.practicafinal.personnel.interfaces.REST.resources.CreateMentalStateExamResource;
import org.hign.platform.practicafinal.personnel.domain.model.commands.CreateMentalStateExamCommand;

public class CreateMentalStateExamCommandFromAssembler {
    public static CreateMentalStateExamCommand toCommandFromResource(CreateMentalStateExamResource resource) {
        return new CreateMentalStateExamCommand(resource.patiendId(), resource.examinerNpi(), resource.examDate(), resource.orientationScore(), resource.registrationScore(), resource.attenAndCalScore(), resource.recallScore(), resource.languageScore());
    }
}
