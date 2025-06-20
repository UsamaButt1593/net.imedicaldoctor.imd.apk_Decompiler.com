package com.prolificinteractive.materialcalendarview;

import androidx.annotation.NonNull;
import org.threeten.bp.Period;

class MonthPagerAdapter extends CalendarPagerAdapter<MonthView> {

    public static class Monthly implements DateRangeIndex {

        /* renamed from: a  reason: collision with root package name */
        private final CalendarDay f27991a;

        /* renamed from: b  reason: collision with root package name */
        private final int f27992b;

        public Monthly(@NonNull CalendarDay calendarDay, @NonNull CalendarDay calendarDay2) {
            this.f27991a = CalendarDay.a(calendarDay.j(), calendarDay.g(), 1);
            this.f27992b = a(calendarDay2) + 1;
        }

        public int a(CalendarDay calendarDay) {
            return (int) Period.n(this.f27991a.c().W2(1), calendarDay.c().W2(1)).N();
        }

        public int getCount() {
            return this.f27992b;
        }

        public CalendarDay getItem(int i2) {
            return CalendarDay.b(this.f27991a.c().L2((long) i2));
        }
    }

    MonthPagerAdapter(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    /* access modifiers changed from: protected */
    public boolean I(Object obj) {
        return obj instanceof MonthView;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a0 */
    public MonthView x(int i2) {
        return new MonthView(this.f27957f, A(i2), this.f27957f.getFirstDayOfWeek(), this.w);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b0 */
    public int F(MonthView monthView) {
        return B().a(monthView.y());
    }

    /* access modifiers changed from: protected */
    public DateRangeIndex w(CalendarDay calendarDay, CalendarDay calendarDay2) {
        return new Monthly(calendarDay, calendarDay2);
    }
}
