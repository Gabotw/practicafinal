package org.hign.platform.practicafinal.personnel.infrastructure.persistence.jpa.repositories;

import org.hign.platform.practicafinal.personnel.domain.model.aggregates.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long> {
    Optional<MentalStateExam> findByPatientId(Long patientId);
    boolean existsByPatientId(Long patientId);
}
