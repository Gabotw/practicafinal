package org.hign.platform.practicafinal.personnel.domain.model.commands;

import java.util.Date;

public record  CreateMentalStateExamCommand(Long patiendId, Long examinerNpi, Date examDate, Integer orientationScore, Integer registrationScore, Integer attenAndCalScore, Integer recallScore, Integer languageScore){}
