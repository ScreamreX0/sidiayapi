package com.example.sidiayapi.enums;

public enum JobTitlesEnum {
    SECTION_CHIEF(1, DepartmentsEnum.OIL_AND_GAS_PRODUCTION),
    CHIEF_ENGINEER(18, DepartmentsEnum.OIL_AND_GAS_PRODUCTION),
    DISPATCHER(2, null),
    OPERATOR(3, DepartmentsEnum.OIL_AND_GAS_PRODUCTION),
    DESIGN_ENGINEER(4, DepartmentsEnum.OIL_AND_GAS_PRODUCTION),
    PROCESS_ENGINEER(5, DepartmentsEnum.OIL_AND_GAS_PRODUCTION),
    MECHANICAL_ENGINEER(6, DepartmentsEnum.OIL_AND_GAS_PRODUCTION),
    ELECTRICAL_ENGINEER(7, DepartmentsEnum.OIL_AND_GAS_PRODUCTION),
    QUALITY_CONTROLLER(8, null),
    METROLOGIST(9, DepartmentsEnum.OIL_AND_GAS_PRODUCTION),
    WELDER(10, DepartmentsEnum.OIL_AND_GAS_PRODUCTION),
    BUILDER(11, DepartmentsEnum.OIL_AND_GAS_PRODUCTION),
    CHIEF_GEOLOGIST(19, DepartmentsEnum.GEOLOGY),
    DESIGN_GEOLOGIST(12, DepartmentsEnum.GEOLOGY),
    GEOPHYSICIST(13, DepartmentsEnum.GEOLOGY),
    HYDROGEOLOGIST(14, DepartmentsEnum.GEOLOGY),
    LABORATORY_ASSISTANT(15, DepartmentsEnum.GEOLOGY),
    EXPLORATION_GEOLOGIST(16, DepartmentsEnum.GEOLOGY);

    public final int value;
    public final DepartmentsEnum department;

    JobTitlesEnum(int value, DepartmentsEnum department) {
        this.value = value;
        this.department = department;
    }

    public static JobTitlesEnum getByValue(int value) {
        for (JobTitlesEnum jobTitleEnum : JobTitlesEnum.values()) {
            if (jobTitleEnum.value == value) return jobTitleEnum;
        }
        return null;
    }
}
