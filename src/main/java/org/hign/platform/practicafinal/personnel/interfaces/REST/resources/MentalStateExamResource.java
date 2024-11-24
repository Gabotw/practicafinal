package org.hign.platform.practicafinal.personnel.interfaces.REST.resources;

import java.util.Date;

public record MentalStateExamResource(Long Id, Long patiendId, String examinerNpi, Date examDate, Integer orientationScore, Integer registrationScore, Integer attenAndCalScore, Integer recallScore, Integer languageScore) {
}
