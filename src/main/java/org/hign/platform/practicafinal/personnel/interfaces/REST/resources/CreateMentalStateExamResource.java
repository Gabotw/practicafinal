package org.hign.platform.practicafinal.personnel.interfaces.REST.resources;

import java.util.Date;

public record CreateMentalStateExamResource(Long patiendId, String examinerNpi, String examDate, Integer orientationScore, Integer registrationScore, Integer attenAndCalScore, Integer recallScore, Integer languageScore) {
}
