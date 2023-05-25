package com.example.sidiayapi.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum StatusesEnum {
    NOT_FORMED(1, "Не сформирована"),
    NEW(2, "Новая"),
    EVALUATED(3, "Оценена"),
    REJECTED(4, "Отклонена"),
    ACCEPTED(5, "Принята"),
    SUSPENDED(6, "Приостановлена"),
    COMPLETED(7, "Выполнена"),
    QUALITY_CHECKING(8, "Проверка качества"),
    CLOSED(9, "Закрыта"),
    FOR_REVISION(10, "На рассмотрение"),
    CANCELED(11, "Отменена");

    public final int value;
    public final String label;

    StatusesEnum(int value, String label) {

        this.value = value;
        this.label = label;

    }

    public static StatusesEnum getByValue(int value) {
        return Arrays.stream(StatusesEnum.values()).filter(it -> it.value == value).findFirst().orElse(null);
    }
}
