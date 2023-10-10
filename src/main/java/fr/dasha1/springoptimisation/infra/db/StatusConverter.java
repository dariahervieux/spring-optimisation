package fr.dasha1.springoptimisation.infra.db;

import fr.dasha1.springoptimisation.domain.model.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status attribute) {
        if (attribute == null)
            return null;

        switch (attribute) {
            case NEW:
                return 1;

            case IN_PROGRESS:
                return 2;

            case DONE:
                return -1;
            default:
                throw new IllegalArgumentException(attribute + " not supported.");
        }
    }

    @Override
    public Status convertToEntityAttribute(Integer dbData) {
        if (dbData == null)
            return null;

        switch (dbData) {
            case 1:
                return Status.NEW;

            case 2:
                return Status.IN_PROGRESS;

            case -1:
                return Status.DONE;
            default:
                throw new IllegalArgumentException(dbData + " not supported.");
        }
    }

}
