package com.prolificinteractive.materialcalendarview;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.prolificinteractive.materialcalendarview.CalendarPagerView;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;

abstract class CalendarPagerAdapter<V extends CalendarPagerView> extends PagerAdapter {

    /* renamed from: e  reason: collision with root package name */
    private final ArrayDeque<V> f27956e;

    /* renamed from: f  reason: collision with root package name */
    protected final MaterialCalendarView f27957f;

    /* renamed from: g  reason: collision with root package name */
    private final CalendarDay f27958g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private TitleFormatter f27959h = TitleFormatter.f28157b;

    /* renamed from: i  reason: collision with root package name */
    private Integer f27960i = null;

    /* renamed from: j  reason: collision with root package name */
    private Integer f27961j = null;

    /* renamed from: k  reason: collision with root package name */
    private Integer f27962k = null;

    /* renamed from: l  reason: collision with root package name */
    private int f27963l = 4;

    /* renamed from: m  reason: collision with root package name */
    private CalendarDay f27964m = null;

    /* renamed from: n  reason: collision with root package name */
    private CalendarDay f27965n = null;
    private DateRangeIndex o;
    private List<CalendarDay> p = new ArrayList();
    private WeekDayFormatter q = WeekDayFormatter.f28158a;
    private DayFormatter r;
    private DayFormatter s;
    private List<DayViewDecorator> t;
    private List<DecoratorResult> u;
    private boolean v;
    boolean w;

    CalendarPagerAdapter(MaterialCalendarView materialCalendarView) {
        DayFormatter dayFormatter = DayFormatter.f28154b;
        this.r = dayFormatter;
        this.s = dayFormatter;
        this.t = new ArrayList();
        this.u = null;
        this.v = true;
        this.f27957f = materialCalendarView;
        this.f27958g = CalendarDay.p();
        ArrayDeque<V> arrayDeque = new ArrayDeque<>();
        this.f27956e = arrayDeque;
        arrayDeque.iterator();
        R((CalendarDay) null, (CalendarDay) null);
    }

    private void H() {
        Z();
        Iterator<V> it2 = this.f27956e.iterator();
        while (it2.hasNext()) {
            ((CalendarPagerView) it2.next()).r(this.p);
        }
    }

    private void Z() {
        CalendarDay calendarDay;
        int i2 = 0;
        while (i2 < this.p.size()) {
            CalendarDay calendarDay2 = this.p.get(i2);
            CalendarDay calendarDay3 = this.f27964m;
            if ((calendarDay3 != null && calendarDay3.l(calendarDay2)) || ((calendarDay = this.f27965n) != null && calendarDay.m(calendarDay2))) {
                this.p.remove(i2);
                this.f27957f.K(calendarDay2);
                i2--;
            }
            i2++;
        }
    }

    public CalendarDay A(int i2) {
        return this.o.getItem(i2);
    }

    public DateRangeIndex B() {
        return this.o;
    }

    @NonNull
    public List<CalendarDay> C() {
        return Collections.unmodifiableList(this.p);
    }

    public int D() {
        return this.f27963l;
    }

    /* access modifiers changed from: protected */
    public int E() {
        Integer num = this.f27962k;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public abstract int F(V v2);

    public void G() {
        this.u = new ArrayList();
        for (DayViewDecorator next : this.t) {
            DayViewFacade dayViewFacade = new DayViewFacade();
            next.a(dayViewFacade);
            if (dayViewFacade.g()) {
                this.u.add(new DecoratorResult(next, dayViewFacade));
            }
        }
        Iterator<V> it2 = this.f27956e.iterator();
        while (it2.hasNext()) {
            ((CalendarPagerView) it2.next()).o(this.u);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean I(Object obj);

    public boolean J() {
        return this.w;
    }

    public CalendarPagerAdapter<?> K(CalendarPagerAdapter<?> calendarPagerAdapter) {
        calendarPagerAdapter.f27959h = this.f27959h;
        calendarPagerAdapter.f27960i = this.f27960i;
        calendarPagerAdapter.f27961j = this.f27961j;
        calendarPagerAdapter.f27962k = this.f27962k;
        calendarPagerAdapter.f27963l = this.f27963l;
        calendarPagerAdapter.f27964m = this.f27964m;
        calendarPagerAdapter.f27965n = this.f27965n;
        calendarPagerAdapter.p = this.p;
        calendarPagerAdapter.q = this.q;
        calendarPagerAdapter.r = this.r;
        calendarPagerAdapter.s = this.s;
        calendarPagerAdapter.t = this.t;
        calendarPagerAdapter.u = this.u;
        calendarPagerAdapter.v = this.v;
        return calendarPagerAdapter;
    }

    public void L(CalendarDay calendarDay, CalendarDay calendarDay2) {
        this.p.clear();
        LocalDate r2 = LocalDate.r2(calendarDay.j(), calendarDay.g(), calendarDay.d());
        LocalDate c2 = calendarDay2.c();
        while (true) {
            if (r2.A(c2) || r2.equals(c2)) {
                this.p.add(CalendarDay.b(r2));
                r2 = r2.J2(1);
            } else {
                H();
                return;
            }
        }
    }

    public void M(CalendarDay calendarDay, boolean z) {
        if (z) {
            if (!this.p.contains(calendarDay)) {
                this.p.add(calendarDay);
            } else {
                return;
            }
        } else if (this.p.contains(calendarDay)) {
            this.p.remove(calendarDay);
        } else {
            return;
        }
        H();
    }

    public void N(int i2) {
        if (i2 != 0) {
            this.f27961j = Integer.valueOf(i2);
            Iterator<V> it2 = this.f27956e.iterator();
            while (it2.hasNext()) {
                ((CalendarPagerView) it2.next()).l(i2);
            }
        }
    }

    public void O(DayFormatter dayFormatter) {
        DayFormatter dayFormatter2 = this.s;
        if (dayFormatter2 == this.r) {
            dayFormatter2 = dayFormatter;
        }
        this.s = dayFormatter2;
        this.r = dayFormatter;
        Iterator<V> it2 = this.f27956e.iterator();
        while (it2.hasNext()) {
            ((CalendarPagerView) it2.next()).m(dayFormatter);
        }
    }

    public void P(DayFormatter dayFormatter) {
        this.s = dayFormatter;
        Iterator<V> it2 = this.f27956e.iterator();
        while (it2.hasNext()) {
            ((CalendarPagerView) it2.next()).n(dayFormatter);
        }
    }

    public void Q(List<DayViewDecorator> list) {
        this.t = list;
        G();
    }

    public void R(CalendarDay calendarDay, CalendarDay calendarDay2) {
        this.f27964m = calendarDay;
        this.f27965n = calendarDay2;
        Iterator<V> it2 = this.f27956e.iterator();
        while (it2.hasNext()) {
            CalendarPagerView calendarPagerView = (CalendarPagerView) it2.next();
            calendarPagerView.q(calendarDay);
            calendarPagerView.p(calendarDay2);
        }
        if (calendarDay == null) {
            calendarDay = CalendarDay.a(this.f27958g.j() - 200, this.f27958g.g(), this.f27958g.d());
        }
        if (calendarDay2 == null) {
            calendarDay2 = CalendarDay.a(this.f27958g.j() + 200, this.f27958g.g(), this.f27958g.d());
        }
        this.o = w(calendarDay, calendarDay2);
        l();
        H();
    }

    public void S(int i2) {
        this.f27960i = Integer.valueOf(i2);
        Iterator<V> it2 = this.f27956e.iterator();
        while (it2.hasNext()) {
            ((CalendarPagerView) it2.next()).s(i2);
        }
    }

    public void T(boolean z) {
        this.v = z;
        Iterator<V> it2 = this.f27956e.iterator();
        while (it2.hasNext()) {
            ((CalendarPagerView) it2.next()).t(this.v);
        }
    }

    public void U(int i2) {
        this.f27963l = i2;
        Iterator<V> it2 = this.f27956e.iterator();
        while (it2.hasNext()) {
            ((CalendarPagerView) it2.next()).u(i2);
        }
    }

    public void V(boolean z) {
        this.w = z;
    }

    public void W(@Nullable TitleFormatter titleFormatter) {
        if (titleFormatter == null) {
            titleFormatter = TitleFormatter.f28157b;
        }
        this.f27959h = titleFormatter;
    }

    public void X(WeekDayFormatter weekDayFormatter) {
        this.q = weekDayFormatter;
        Iterator<V> it2 = this.f27956e.iterator();
        while (it2.hasNext()) {
            ((CalendarPagerView) it2.next()).v(weekDayFormatter);
        }
    }

    public void Y(int i2) {
        if (i2 != 0) {
            this.f27962k = Integer.valueOf(i2);
            Iterator<V> it2 = this.f27956e.iterator();
            while (it2.hasNext()) {
                ((CalendarPagerView) it2.next()).w(i2);
            }
        }
    }

    public void b(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        CalendarPagerView calendarPagerView = (CalendarPagerView) obj;
        this.f27956e.remove(calendarPagerView);
        viewGroup.removeView(calendarPagerView);
    }

    public int e() {
        return this.o.getCount();
    }

    public int f(@NonNull Object obj) {
        int F;
        if (!I(obj)) {
            return -2;
        }
        CalendarPagerView calendarPagerView = (CalendarPagerView) obj;
        if (calendarPagerView.g() != null && (F = F(calendarPagerView)) >= 0) {
            return F;
        }
        return -2;
    }

    public CharSequence g(int i2) {
        return this.f27959h.a(A(i2));
    }

    @NonNull
    public Object j(@NonNull ViewGroup viewGroup, int i2) {
        CalendarPagerView x = x(i2);
        x.setContentDescription(this.f27957f.getCalendarContentDescription());
        x.setAlpha(0.0f);
        x.t(this.v);
        x.v(this.q);
        x.m(this.r);
        x.n(this.s);
        Integer num = this.f27960i;
        if (num != null) {
            x.s(num.intValue());
        }
        Integer num2 = this.f27961j;
        if (num2 != null) {
            x.l(num2.intValue());
        }
        Integer num3 = this.f27962k;
        if (num3 != null) {
            x.w(num3.intValue());
        }
        x.u(this.f27963l);
        x.q(this.f27964m);
        x.p(this.f27965n);
        x.r(this.p);
        viewGroup.addView(x);
        this.f27956e.add(x);
        x.o(this.u);
        return x;
    }

    public boolean k(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void v() {
        this.p.clear();
        H();
    }

    /* access modifiers changed from: protected */
    public abstract DateRangeIndex w(CalendarDay calendarDay, CalendarDay calendarDay2);

    /* access modifiers changed from: protected */
    public abstract V x(int i2);

    /* access modifiers changed from: protected */
    public int y() {
        Integer num = this.f27961j;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int z(CalendarDay calendarDay) {
        if (calendarDay == null) {
            return e() / 2;
        }
        CalendarDay calendarDay2 = this.f27964m;
        if (calendarDay2 != null && calendarDay.m(calendarDay2)) {
            return 0;
        }
        CalendarDay calendarDay3 = this.f27965n;
        return (calendarDay3 == null || !calendarDay.l(calendarDay3)) ? this.o.a(calendarDay) : e() - 1;
    }
}
