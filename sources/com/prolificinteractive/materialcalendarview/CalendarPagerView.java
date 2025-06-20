package com.prolificinteractive.materialcalendarview;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

abstract class CalendarPagerView extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {
    protected static final int g3 = 7;
    protected static final int h3 = 6;
    protected static final int i3 = 1;
    private final ArrayList<DecoratorResult> X2 = new ArrayList<>();
    private final DayOfWeek Y2;
    protected int Z2 = 4;
    private MaterialCalendarView a3;
    private CalendarDay b3;
    private CalendarDay c3 = null;
    private CalendarDay d3 = null;
    protected boolean e3;
    private final Collection<DayView> f3;
    private final ArrayList<WeekDayView> s = new ArrayList<>();

    protected static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams() {
            super(-2, -2);
        }
    }

    public CalendarPagerView(@NonNull MaterialCalendarView materialCalendarView, CalendarDay calendarDay, DayOfWeek dayOfWeek, boolean z) {
        super(materialCalendarView.getContext());
        ArrayList arrayList = new ArrayList();
        this.f3 = arrayList;
        this.a3 = materialCalendarView;
        this.b3 = calendarDay;
        this.Y2 = dayOfWeek;
        this.e3 = z;
        setClipChildren(false);
        setClipToPadding(false);
        if (z) {
            c(k());
        }
        b(arrayList, k());
    }

    private void c(LocalDate localDate) {
        for (int i2 = 0; i2 < 7; i2++) {
            WeekDayView weekDayView = new WeekDayView(getContext(), localDate.j1());
            weekDayView.setImportantForAccessibility(2);
            this.s.add(weekDayView);
            addView(weekDayView);
            localDate = localDate.J2(1);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Collection<DayView> collection, LocalDate localDate) {
        DayView dayView = new DayView(getContext(), CalendarDay.b(localDate));
        dayView.setOnClickListener(this);
        dayView.setOnLongClickListener(this);
        collection.add(dayView);
        addView(dayView, new LayoutParams());
    }

    /* access modifiers changed from: protected */
    public abstract void b(Collection<DayView> collection, LocalDate localDate);

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* renamed from: e */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public DayOfWeek f() {
        return this.Y2;
    }

    /* access modifiers changed from: protected */
    public CalendarDay g() {
        return this.b3;
    }

    /* access modifiers changed from: protected */
    public abstract int h();

    /* access modifiers changed from: protected */
    public void i() {
        DayViewFacade dayViewFacade = new DayViewFacade();
        for (DayView next : this.f3) {
            dayViewFacade.h();
            Iterator<DecoratorResult> it2 = this.X2.iterator();
            while (it2.hasNext()) {
                DecoratorResult next2 = it2.next();
                if (next2.f27972a.b(next.h())) {
                    next2.f27973b.b(dayViewFacade);
                }
            }
            next.a(dayViewFacade);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean j(CalendarDay calendarDay);

    /* access modifiers changed from: protected */
    public LocalDate k() {
        LocalDate V2 = g().c().q0(WeekFields.f(this.Y2, 1).b(), 1);
        int value = f().getValue() - V2.j1().getValue();
        if (!MaterialCalendarView.T(this.Z2) ? value > 0 : value >= 0) {
            value -= 7;
        }
        return V2.J2((long) value);
    }

    public void l(int i2) {
        for (DayView textAppearance : this.f3) {
            textAppearance.setTextAppearance(getContext(), i2);
        }
    }

    public void m(DayFormatter dayFormatter) {
        for (DayView m2 : this.f3) {
            m2.m(dayFormatter);
        }
    }

    public void n(DayFormatter dayFormatter) {
        for (DayView n2 : this.f3) {
            n2.n(dayFormatter);
        }
    }

    /* access modifiers changed from: package-private */
    public void o(List<DecoratorResult> list) {
        this.X2.clear();
        if (list != null) {
            this.X2.addAll(list);
        }
        i();
    }

    public void onClick(View view) {
        if (view instanceof DayView) {
            this.a3.I((DayView) view);
        }
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(CalendarPagerView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CalendarPagerView.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        int width = getWidth();
        int childCount = getChildCount();
        int i7 = width;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (LocalUtils.a()) {
                int i11 = i7 - measuredWidth;
                childAt.layout(i11, i9, i7, i9 + measuredHeight);
                i7 = i11;
            } else {
                int i12 = measuredWidth + i8;
                childAt.layout(i8, i9, i12, i9 + measuredHeight);
                i8 = i12;
            }
            if (i10 % 7 == 6) {
                i9 += measuredHeight;
                i7 = width;
                i8 = 0;
            }
        }
    }

    public boolean onLongClick(View view) {
        if (!(view instanceof DayView)) {
            return false;
        }
        this.a3.J((DayView) view);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i4);
        if (View.MeasureSpec.getMode(i4) == 0 || mode == 0) {
            throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
        }
        int i5 = size / 7;
        int h2 = size2 / h();
        setMeasuredDimension(size, size2);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(h2, 1073741824));
        }
    }

    public void p(CalendarDay calendarDay) {
        this.d3 = calendarDay;
        x();
    }

    public void q(CalendarDay calendarDay) {
        this.c3 = calendarDay;
        x();
    }

    public void r(Collection<CalendarDay> collection) {
        for (DayView next : this.f3) {
            next.setChecked(collection != null && collection.contains(next.h()));
        }
        postInvalidate();
    }

    public void s(int i2) {
        for (DayView p : this.f3) {
            p.p(i2);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(boolean z) {
        for (DayView next : this.f3) {
            next.setOnClickListener(z ? this : null);
            next.setClickable(z);
        }
    }

    public void u(int i2) {
        this.Z2 = i2;
        x();
    }

    public void v(WeekDayFormatter weekDayFormatter) {
        Iterator<WeekDayView> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().w(weekDayFormatter);
        }
    }

    public void w(int i2) {
        Iterator<WeekDayView> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().setTextAppearance(getContext(), i2);
        }
    }

    /* access modifiers changed from: protected */
    public void x() {
        for (DayView next : this.f3) {
            CalendarDay h2 = next.h();
            next.r(this.Z2, h2.o(this.c3, this.d3), j(h2));
        }
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams();
    }
}
