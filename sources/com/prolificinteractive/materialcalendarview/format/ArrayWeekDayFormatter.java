package com.prolificinteractive.materialcalendarview.format;

import org.threeten.bp.DayOfWeek;

public class ArrayWeekDayFormatter implements WeekDayFormatter {

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence[] f28150b;

    public ArrayWeekDayFormatter(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            throw new IllegalArgumentException("Cannot be null");
        } else if (charSequenceArr.length == 7) {
            this.f28150b = charSequenceArr;
        } else {
            throw new IllegalArgumentException("Array must contain exactly 7 elements");
        }
    }

    public CharSequence a(DayOfWeek dayOfWeek) {
        return this.f28150b[dayOfWeek.getValue() - 1];
    }
}
