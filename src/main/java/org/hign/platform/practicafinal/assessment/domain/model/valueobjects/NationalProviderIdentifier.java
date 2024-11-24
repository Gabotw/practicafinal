package org.hign.platform.practicafinal.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;
@Embeddable
public record NationalProviderIdentifier(String nationalProviderIdentifier) {
    public NationalProviderIdentifier {
        if (nationalProviderIdentifier == null || nationalProviderIdentifier.isEmpty()) {
            throw new IllegalArgumentException("National Provider Identifier cannot be null or empty");
        }
        try {
            UUID.fromString(nationalProviderIdentifier);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("National Provider Identifier must be a valid UUID", e);
        }
    }
}