package org.hign.platform.practicafinal.personnel.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import org.hign.platform.practicafinal.assessment.domain.model.aggregates.Examiner;
import org.hign.platform.practicafinal.personnel.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.practicafinal.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Entity
public class MentalStateExam  extends AuditableAbstractAggregateRoot <MentalStateExam>{
    private Long patientId;
    private String examinerNpi;
    private Date examnDate;
    private Integer orientationScore;
    private Integer registrationScore;
    private Integer attenAndCalScore;
    private Integer recallScore;
    private Integer languageScore;

    @ManyToOne
    @JoinColumn(name = "examiner_id")
    private Examiner examiner;

    public MentalStateExam() {
        this.patientId = 0L;
        this.examinerNpi = "";
        this.examnDate = new Date();
        this.orientationScore = 0;
        this.registrationScore = 0;
        this.attenAndCalScore = 0;
        this.recallScore = 0;
        this.languageScore = 0;
    }
    public MentalStateExam(Long patientId, String examinerNpi, String examnDate, Integer orientationScore, Integer registrationScore, Integer attenAndCalScore, Integer recallScore, Integer languageScore) throws ParseException {
        this.patientId = patientId;
        this.examinerNpi = examinerNpi;
        this.examnDate = new SimpleDateFormat("yyyy-MM-dd").parse(examnDate);
        this.orientationScore = orientationScore;
        this.registrationScore = registrationScore;
        this.attenAndCalScore = attenAndCalScore;
        this.recallScore = recallScore;
        this.languageScore = languageScore;
    }
    public MentalStateExam(CreateMentalStateExamCommand command) throws  ParseException {
        this.patientId = command.patiendId();
        this.examinerNpi = command.examinerNpi();
        this.examnDate = new SimpleDateFormat("yyyy-MM-dd").parse(command.examDate());
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.attenAndCalScore = command.attenAndCalScore();
        this.recallScore = command.recallScore();
        this.languageScore = command.languageScore();
    }
}
