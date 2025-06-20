package com.prolificinteractive.materialcalendarview;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

@SuppressLint({"ViewConstructor"})
class WeekView extends CalendarPagerView {
    public WeekView(@NonNull MaterialCalendarView materialCalendarView, CalendarDay calendarDay, DayOfWeek dayOfWeek, boolean z) {
        super(materialCalendarView, calendarDay, dayOfWeek, z);
    }

    /* access modifiers changed from: protected */
    public void b(Collection<DayView> collection, LocalDate localDate) {
        for (int i2 = 0; i2 < 7; i2++) {
            a(collection, localDate);
            localDate = localDate.J2(1);
        }
    }

    /* access modifiers changed from: protected */
    public int h() {
        return this.e3 ? 2 : 1;
    }

    /* access modifiers changed from: protected */
    public boolean j(CalendarDay calendarDay) {
        return true;
    }
}
