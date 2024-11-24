package org.hign.platform.practicafinal.personnel.domain.model.aggregates;

import jakarta.persistence.Entity;
import lombok.Getter;
import org.hign.platform.practicafinal.personnel.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.practicafinal.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.Date;

@Getter
@Entity
public class MentalStateExam  extends AuditableAbstractAggregateRoot <MentalStateExam>{
    private Long patientId;
    private Long examinerNpi;
    private Date examnDate;
    private Integer orientationScore;
    private Integer registrationScore;
    private Integer attenAndCalScore;
    private Integer recallScore;
    private Integer languageScore;

    public MentalStateExam() {
        this.patientId = 0L;
        this.examinerNpi = 0L;
        this.examnDate = new Date();
        this.orientationScore = 0;
        this.registrationScore = 0;
        this.attenAndCalScore = 0;
        this.recallScore = 0;
        this.languageScore = 0;
    }
    public MentalStateExam(Long patientId, Long examinerNpi, Date examnDate, Integer orientationScore, Integer registrationScore, Integer attenAndCalScore, Integer recallScore, Integer languageScore) {
        this.patientId = patientId;
        this.examinerNpi = examinerNpi;
        this.examnDate = examnDate;
        this.orientationScore = orientationScore;
        this.registrationScore = registrationScore;
        this.attenAndCalScore = attenAndCalScore;
        this.recallScore = recallScore;
        this.languageScore = languageScore;
    }
    public MentalStateExam(CreateMentalStateExamCommand command) {
        this.patientId = command.patiendId();
        this.examinerNpi = command.examinerNpi();
        this.examnDate = command.examDate();
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.attenAndCalScore = command.attenAndCalScore();
        this.recallScore = command.recallScore();
        this.languageScore = command.languageScore();
    }
}
