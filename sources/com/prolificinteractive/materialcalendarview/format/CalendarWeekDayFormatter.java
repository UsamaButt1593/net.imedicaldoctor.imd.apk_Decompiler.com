package com.prolificinteractive.materialcalendarview.format;

import java.util.Locale;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.format.TextStyle;

public final class CalendarWeekDayFormatter implements WeekDayFormatter {
    public CharSequence a(DayOfWeek dayOfWeek) {
        return dayOfWeek.c(TextStyle.SHORT, Locale.getDefault());
    }
}
