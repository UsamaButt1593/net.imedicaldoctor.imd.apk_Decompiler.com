package com.prolificinteractive.materialcalendarview.format;

import androidx.annotation.NonNull;
import com.prolificinteractive.materialcalendarview.CalendarDay;

public interface DayFormatter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28153a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static final DayFormatter f28154b = new DateFormatDayFormatter();

    @NonNull
    String a(@NonNull CalendarDay calendarDay);
}
