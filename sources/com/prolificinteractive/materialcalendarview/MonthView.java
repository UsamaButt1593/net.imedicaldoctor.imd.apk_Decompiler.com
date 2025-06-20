package com.prolificinteractive.materialcalendarview;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

@SuppressLint({"ViewConstructor"})
class MonthView extends CalendarPagerView {
    public MonthView(@NonNull MaterialCalendarView materialCalendarView, CalendarDay calendarDay, DayOfWeek dayOfWeek, boolean z) {
        super(materialCalendarView, calendarDay, dayOfWeek, z);
    }

    /* access modifiers changed from: protected */
    public void b(Collection<DayView> collection, LocalDate localDate) {
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 7; i3++) {
                a(collection, localDate);
                localDate = localDate.J2(1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int h() {
        return this.e3 ? 7 : 6;
    }

    /* access modifiers changed from: protected */
    public boolean j(CalendarDay calendarDay) {
        return calendarDay.g() == g().g();
    }

    public CalendarDay y() {
        return g();
    }
}
