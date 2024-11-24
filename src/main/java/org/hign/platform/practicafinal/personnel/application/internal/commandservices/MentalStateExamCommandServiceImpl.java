package org.hign.platform.practicafinal.personnel.application.internal.commandservices;

import org.hign.platform.practicafinal.personnel.domain.model.aggregates.MentalStateExam;
import org.hign.platform.practicafinal.personnel.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.practicafinal.personnel.domain.services.MentalStateExamCommandService;
import org.hign.platform.practicafinal.personnel.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;
import org.springframework.stereotype.Service;

@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamCommandService {
    private final MentalStateExamRepository mentalStateExamRepository;

    public MentalStateExamCommandServiceImpl(MentalStateExamRepository mentalStateExamRepository) {
        this.mentalStateExamRepository = mentalStateExamRepository;
    }

    @Override
    public Long handle(CreateMentalStateExamCommand command) {
        if (mentalStateExamRepository.existsByPatientId(command.patiendId())) {
            throw new IllegalArgumentException("Mental state exam already exists for patientId");
        }
        var mentalStateExam = new MentalStateExam(command.patiendId(), command.examinerNpi(), command.examDate(), command.orientationScore(), command.registrationScore(), command.attenAndCalScore(), command.recallScore(), command.languageScore());
        try{
            mentalStateExamRepository.save(mentalStateExam);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving mental state exam");
        }
        return mentalStateExam.getId();
    }
}
