package com.prolificinteractive.materialcalendarview;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

public class WeekPagerAdapter extends CalendarPagerAdapter<WeekView> {

    public static class Weekly implements DateRangeIndex {

        /* renamed from: a  reason: collision with root package name */
        private final CalendarDay f28147a;

        /* renamed from: b  reason: collision with root package name */
        private final int f28148b;

        /* renamed from: c  reason: collision with root package name */
        private final DayOfWeek f28149c;

        public Weekly(@NonNull CalendarDay calendarDay, @NonNull CalendarDay calendarDay2, DayOfWeek dayOfWeek) {
            this.f28149c = dayOfWeek;
            this.f28147a = b(calendarDay);
            this.f28148b = a(calendarDay2) + 1;
        }

        private CalendarDay b(@NonNull CalendarDay calendarDay) {
            return CalendarDay.b(calendarDay.c().q0(WeekFields.f(this.f28149c, 1).b(), 1));
        }

        public int a(CalendarDay calendarDay) {
            return (int) ChronoUnit.WEEKS.e(this.f28147a.c(), calendarDay.c().q0(WeekFields.f(this.f28149c, 1).b(), 1));
        }

        public int getCount() {
            return this.f28148b;
        }

        public CalendarDay getItem(int i2) {
            return CalendarDay.b(this.f28147a.c().M2((long) i2));
        }
    }

    public WeekPagerAdapter(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    public /* bridge */ /* synthetic */ CalendarDay A(int i2) {
        return super.A(i2);
    }

    public /* bridge */ /* synthetic */ DateRangeIndex B() {
        return super.B();
    }

    @NonNull
    public /* bridge */ /* synthetic */ List C() {
        return super.C();
    }

    public /* bridge */ /* synthetic */ int D() {
        return super.D();
    }

    public /* bridge */ /* synthetic */ void G() {
        super.G();
    }

    /* access modifiers changed from: protected */
    public boolean I(Object obj) {
        return obj instanceof WeekView;
    }

    public /* bridge */ /* synthetic */ boolean J() {
        return super.J();
    }

    public /* bridge */ /* synthetic */ CalendarPagerAdapter K(CalendarPagerAdapter calendarPagerAdapter) {
        return super.K(calendarPagerAdapter);
    }

    public /* bridge */ /* synthetic */ void L(CalendarDay calendarDay, CalendarDay calendarDay2) {
        super.L(calendarDay, calendarDay2);
    }

    public /* bridge */ /* synthetic */ void M(CalendarDay calendarDay, boolean z) {
        super.M(calendarDay, z);
    }

    public /* bridge */ /* synthetic */ void N(int i2) {
        super.N(i2);
    }

    public /* bridge */ /* synthetic */ void O(DayFormatter dayFormatter) {
        super.O(dayFormatter);
    }

    public /* bridge */ /* synthetic */ void P(DayFormatter dayFormatter) {
        super.P(dayFormatter);
    }

    public /* bridge */ /* synthetic */ void Q(List list) {
        super.Q(list);
    }

    public /* bridge */ /* synthetic */ void R(CalendarDay calendarDay, CalendarDay calendarDay2) {
        super.R(calendarDay, calendarDay2);
    }

    public /* bridge */ /* synthetic */ void S(int i2) {
        super.S(i2);
    }

    public /* bridge */ /* synthetic */ void T(boolean z) {
        super.T(z);
    }

    public /* bridge */ /* synthetic */ void U(int i2) {
        super.U(i2);
    }

    public /* bridge */ /* synthetic */ void V(boolean z) {
        super.V(z);
    }

    public /* bridge */ /* synthetic */ void W(@Nullable TitleFormatter titleFormatter) {
        super.W(titleFormatter);
    }

    public /* bridge */ /* synthetic */ void X(WeekDayFormatter weekDayFormatter) {
        super.X(weekDayFormatter);
    }

    public /* bridge */ /* synthetic */ void Y(int i2) {
        super.Y(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a0 */
    public WeekView x(int i2) {
        return new WeekView(this.f27957f, A(i2), this.f27957f.getFirstDayOfWeek(), this.w);
    }

    public /* bridge */ /* synthetic */ void b(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        super.b(viewGroup, i2, obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b0 */
    public int F(WeekView weekView) {
        return B().a(weekView.g());
    }

    public /* bridge */ /* synthetic */ int e() {
        return super.e();
    }

    public /* bridge */ /* synthetic */ int f(@NonNull Object obj) {
        return super.f(obj);
    }

    public /* bridge */ /* synthetic */ CharSequence g(int i2) {
        return super.g(i2);
    }

    @NonNull
    public /* bridge */ /* synthetic */ Object j(@NonNull ViewGroup viewGroup, int i2) {
        return super.j(viewGroup, i2);
    }

    public /* bridge */ /* synthetic */ boolean k(@NonNull View view, @NonNull Object obj) {
        return super.k(view, obj);
    }

    public /* bridge */ /* synthetic */ void v() {
        super.v();
    }

    /* access modifiers changed from: protected */
    public DateRangeIndex w(CalendarDay calendarDay, CalendarDay calendarDay2) {
        return new Weekly(calendarDay, calendarDay2, this.f27957f.getFirstDayOfWeek());
    }

    public /* bridge */ /* synthetic */ int z(CalendarDay calendarDay) {
        return super.z(calendarDay);
    }
}
