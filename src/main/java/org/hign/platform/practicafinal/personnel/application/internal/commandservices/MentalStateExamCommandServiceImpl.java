package org.hign.platform.practicafinal.personnel.application.internal.commandservices;

import org.hign.platform.practicafinal.personnel.application.internal.outboundservices.acl.ExternalExaminerService;
import org.hign.platform.practicafinal.personnel.domain.model.aggregates.MentalStateExam;
import org.hign.platform.practicafinal.personnel.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.practicafinal.personnel.domain.services.MentalStateExamCommandService;
import org.hign.platform.practicafinal.personnel.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamCommandService {
    private static final Logger logger = LoggerFactory.getLogger(MentalStateExamCommandServiceImpl.class);
    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExternalExaminerService externalExaminerService;

    public MentalStateExamCommandServiceImpl(MentalStateExamRepository mentalStateExamRepository, ExternalExaminerService externalExaminerService) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.externalExaminerService = externalExaminerService;
    }

    @Transactional
    @Override
    public Long handle(CreateMentalStateExamCommand command) {
        if (mentalStateExamRepository.existsByPatientId(command.patiendId())) {
            throw new IllegalArgumentException("Mental state exam already exists for patientId");
        }

        var examinerNpi = externalExaminerService.fetchExaminerByNpi(command.examinerNpi())
                .orElseThrow(() -> new IllegalArgumentException("Invalid examinerNpi"));

        try {
            var mentalStateExam = new MentalStateExam(command.patiendId(), examinerNpi, command.examDate(), command.orientationScore(), command.registrationScore(), command.attenAndCalScore(), command.recallScore(), command.languageScore());
            mentalStateExamRepository.save(mentalStateExam);
            return mentalStateExam.getId();
        } catch (ParseException e) {
            logger.error("Error parsing exam date", e);
            throw new IllegalArgumentException("Invalid exam date format", e);
        } catch (Exception e) {
            logger.error("Error saving mental state exam", e);
            throw new IllegalArgumentException("Error saving mental state exam", e);
        }
    }
}