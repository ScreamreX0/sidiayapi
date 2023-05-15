package com.example.sidiayapi.enums;

public enum ServicesEnum {
    // Насосно-перекачивающее оборудование
    NPO(1, new JobTitlesEnum[]{JobTitlesEnum.MECHANICAL_ENGINEER}),

    // Работа с энергетическими системами
    ENERGO(2, new JobTitlesEnum[]{JobTitlesEnum.ELECTRICAL_ENGINEER}),

    // контрольно-измерительные приборы
    KIP(3, new JobTitlesEnum[]{JobTitlesEnum.METROLOGIST}),

    // Сварочные работы
    WELDING(4, new JobTitlesEnum[]{JobTitlesEnum.WELDER}),

    // Подготовка и разведка скважин
    PRS(5, new JobTitlesEnum[]{JobTitlesEnum.EXPLORATION_GEOLOGIST}),

    // Исследование
    RESEARCH(6, new JobTitlesEnum[]{JobTitlesEnum.EXPLORATION_GEOLOGIST}),

    // Строительные работы
    CONSTRUCTION_WORKS(7, new JobTitlesEnum[]{JobTitlesEnum.BUILDER});

    public final int value;
    public final JobTitlesEnum[] responsible;

    ServicesEnum(int value, JobTitlesEnum[] responsible) {
        this.value = value;
        this.responsible = responsible;
    }

    public static ServicesEnum getByValue(int value) {
        for (ServicesEnum serviceEnum : ServicesEnum.values()) {
            if (serviceEnum.value == value) return serviceEnum;
        }
        return null;
    }
}
