package org.hign.platform.practicafinal.personnel.domain.services;

import org.hign.platform.practicafinal.personnel.domain.model.commands.CreateMentalStateExamCommand;

public interface MentalStateExamCommandService {
    Long handle(CreateMentalStateExamCommand command);
}
