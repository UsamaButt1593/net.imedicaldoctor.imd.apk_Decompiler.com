package com.prolificinteractive.materialcalendarview.format;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import org.threeten.bp.format.DateTimeFormatter;

public class DateFormatTitleFormatter implements TitleFormatter {

    /* renamed from: c  reason: collision with root package name */
    private final DateTimeFormatter f28152c;

    public DateFormatTitleFormatter() {
        this(DateTimeFormatter.p(TitleFormatter.f28156a));
    }

    public CharSequence a(CalendarDay calendarDay) {
        return this.f28152c.d(calendarDay.c());
    }

    public DateFormatTitleFormatter(DateTimeFormatter dateTimeFormatter) {
        this.f28152c = dateTimeFormatter;
    }
}
