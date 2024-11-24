package org.hign.platform.practicafinal.assessment.application.internal.commandservices;

import org.hign.platform.practicafinal.assessment.domain.model.aggregates.Examiner;
import org.hign.platform.practicafinal.assessment.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.practicafinal.assessment.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.practicafinal.assessment.domain.services.ExaminerCommandService;
import org.hign.platform.practicafinal.assessment.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {
    private final ExaminerRepository examinerRepository;

    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @Override
    public Long handle(CreateExaminerCommand command) {
        NationalProviderIdentifier npi = new NationalProviderIdentifier(command.npi());

        if(examinerRepository.existsByNpi(npi)) {
            throw new IllegalArgumentException("Examiner with NPI already exists");
        }
        var examiner = new Examiner(command.firstName(), command.lastName(), npi.nationalProviderIdentifier());
        try{
            examinerRepository.save(examiner);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving examiner: " + e.getMessage());
        }
        return examiner.getId();
    }
}
