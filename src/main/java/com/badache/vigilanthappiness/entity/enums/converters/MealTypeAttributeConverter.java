package com.badache.vigilanthappiness.entity.enums.converters;

import com.badache.vigilanthappiness.entity.enums.MealType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MealTypeAttributeConverter implements AttributeConverter<MealType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(MealType mealType) {
        if (mealType == null)   {
            return null;
        }

        return switch (mealType) {
            case MATIN -> 1;
            case MIDI -> 2;
            case SOIR -> 3;
            case MIXTE -> 4;
        };
    }

    @Override
    public MealType convertToEntityAttribute(Integer dbData) {
        if (dbData == null)  {
            return null;
        }

        return switch (dbData) {
            case 1 -> MealType.MATIN;
            case 2 -> MealType.MIDI;
            case 3 -> MealType.SOIR;
            case 4 -> MealType.MIXTE;
            default -> throw new IllegalArgumentException("meal type code " + dbData + " not supported");
        };
    }
}
