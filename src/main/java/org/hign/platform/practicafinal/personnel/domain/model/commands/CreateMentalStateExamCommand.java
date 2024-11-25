package org.hign.platform.practicafinal.personnel.domain.model.commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record  CreateMentalStateExamCommand(Long patiendId, String examinerNpi, String examDate, Integer orientationScore, Integer registrationScore, Integer attenAndCalScore, Integer recallScore, Integer languageScore){
    public CreateMentalStateExamCommand{
        if (orientationScore == null || orientationScore < 0 || orientationScore > 10) {
            throw new IllegalArgumentException("Orientation score must be between 0 and 10");
        }
        if (registrationScore == null || registrationScore < 0 || registrationScore > 3) {
            throw new IllegalArgumentException("Registration score must be between 0 and 3");
        }
        if (attenAndCalScore == null || attenAndCalScore < 0 || attenAndCalScore > 5) {
            throw new IllegalArgumentException("Attention and calculation score must be between 0 and 5");
        }
        if (recallScore == null || recallScore < 0 || recallScore > 3) {
            throw new IllegalArgumentException("Recall score must be between 0 and 3");
        }
        if (languageScore == null || languageScore < 0 || languageScore > 9) {
            throw new IllegalArgumentException("Language score must be between 0 and 9");
        }
        try {
            Date parsedExamDate = new SimpleDateFormat("yyyy-MM-dd").parse(examDate);
            if (parsedExamDate.after(new Date())) {
                throw new IllegalArgumentException("Exam date cannot be in the future");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid exam date format, expected YYYY-MM-DD", e);
        }
    }
}
