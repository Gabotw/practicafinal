package org.hign.platform.practicafinal.assessment.infrastructure.persistence.jpa.repositories;

import org.hign.platform.practicafinal.assessment.domain.model.aggregates.Examiner;
import org.hign.platform.practicafinal.assessment.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExaminerRepository extends JpaRepository<Examiner, Long> {
    Optional<Examiner> findById(Long id);
    boolean existsByNpi(NationalProviderIdentifier npi);
}
