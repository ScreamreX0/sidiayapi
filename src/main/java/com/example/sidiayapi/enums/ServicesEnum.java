package com.example.sidiayapi.enums;

public enum ServicesEnum {
    NPO(1, new JobTitlesEnum[]{JobTitlesEnum.MECHANICAL_ENGINEER}),
    ENERGO(2, new JobTitlesEnum[]{JobTitlesEnum.ELECTRICAL_ENGINEER}),
    KIP(3, new JobTitlesEnum[]{JobTitlesEnum.METROLOGIST}),
    WELDING(4, new JobTitlesEnum[]{JobTitlesEnum.WELDER}),
    PRS(5, new JobTitlesEnum[]{JobTitlesEnum.EXPLORATION_GEOLOGIST}),
    RESEARCH(6, new JobTitlesEnum[]{JobTitlesEnum.EXPLORATION_GEOLOGIST}),
    CONSTRUCTION_WORKS(7, new JobTitlesEnum[]{JobTitlesEnum.BUILDER});

    public final int value;
    public final JobTitlesEnum[] responsible;

    ServicesEnum(int value, JobTitlesEnum[] responsible) {
        this.value = value;
        this.responsible = responsible;
    }
}
