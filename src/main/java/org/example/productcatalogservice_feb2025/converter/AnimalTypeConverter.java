package org.example.productcatalogservice_feb2025.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AnimalTypeConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return attribute;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null || (!dbData.equals("DOG") && !dbData.equals("COW"))) {
            return "UNKNOWN";
        }
        return dbData;
    }
}
