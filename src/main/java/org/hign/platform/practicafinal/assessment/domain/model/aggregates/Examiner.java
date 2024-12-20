package org.hign.platform.practicafinal.assessment.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import org.hign.platform.practicafinal.assessment.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.practicafinal.assessment.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.practicafinal.personnel.domain.model.aggregates.MentalStateExam;
import org.hign.platform.practicafinal.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.List;

@Getter
@Entity
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {
    private String firstName;
    private String lastName;
    @Embedded
    private NationalProviderIdentifier npi;

    @OneToMany(mappedBy = "examiner")
    private List<MentalStateExam> mentalStateExams;

    public Examiner() {
        this.firstName = "";
        this.lastName = "";
        this.npi = new NationalProviderIdentifier("00000000-0000-0000-0000-000000000000");
    }
    public Examiner(String firstName, String lastName, String npi ) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.npi = new NationalProviderIdentifier(npi);
    }
    public Examiner(CreateExaminerCommand command) {
        this();
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.npi = new NationalProviderIdentifier(command.npi());
    }
}
