package com.prolificinteractive.materialcalendarview.format;

import androidx.annotation.NonNull;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatter;

public class DateFormatDayFormatter implements DayFormatter {

    /* renamed from: c  reason: collision with root package name */
    private final DateTimeFormatter f28151c;

    public DateFormatDayFormatter() {
        this(DateTimeFormatter.q("d", Locale.getDefault()));
    }

    @NonNull
    public String a(@NonNull CalendarDay calendarDay) {
        return this.f28151c.d(calendarDay.c());
    }

    public DateFormatDayFormatter(@NonNull DateTimeFormatter dateTimeFormatter) {
        this.f28151c = dateTimeFormatter;
    }
}
