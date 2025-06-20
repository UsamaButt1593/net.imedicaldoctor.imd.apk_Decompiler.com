package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import java.util.Collection;

class MonthAdapter extends BaseAdapter {
    static final int Z2 = UtcDates.x().getMaximum(4);
    private static final int a3 = ((UtcDates.x().getMaximum(5) + UtcDates.x().getMaximum(7)) - 1);
    private static final int b3 = -1;
    final DateSelector<?> X;
    final CalendarConstraints X2;
    private Collection<Long> Y;
    @Nullable
    final DayViewDecorator Y2;
    CalendarStyle Z;
    final Month s;

    MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, @Nullable DayViewDecorator dayViewDecorator) {
        this.s = month;
        this.X = dateSelector;
        this.X2 = calendarConstraints;
        this.Y2 = dayViewDecorator;
        this.Y = dateSelector.F();
    }

    private String c(Context context, long j2) {
        return DateStrings.e(context, j2, l(j2), k(j2), g(j2));
    }

    private void f(Context context) {
        if (this.Z == null) {
            this.Z = new CalendarStyle(context);
        }
    }

    private boolean j(long j2) {
        for (Long longValue : this.X.F()) {
            if (UtcDates.a(j2) == UtcDates.a(longValue.longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean l(long j2) {
        return UtcDates.v().getTimeInMillis() == j2;
    }

    private void o(@Nullable TextView textView, long j2, int i2) {
        boolean z;
        CalendarItemStyle calendarItemStyle;
        TextView textView2 = textView;
        long j3 = j2;
        if (textView2 != null) {
            Context context = textView.getContext();
            String c2 = c(context, j3);
            textView2.setContentDescription(c2);
            boolean y = this.X2.k().y(j3);
            if (y) {
                textView2.setEnabled(true);
                boolean j4 = j(j3);
                textView2.setSelected(j4);
                calendarItemStyle = j4 ? this.Z.f21342b : l(j3) ? this.Z.f21343c : this.Z.f21341a;
                z = j4;
            } else {
                textView2.setEnabled(false);
                calendarItemStyle = this.Z.f21347g;
                z = false;
            }
            DayViewDecorator dayViewDecorator = this.Y2;
            if (dayViewDecorator == null || i2 == -1) {
                calendarItemStyle.f(textView2);
                return;
            }
            Month month = this.s;
            int i3 = month.Y;
            int i4 = month.X;
            Context context2 = context;
            int i5 = i3;
            int i6 = i2;
            boolean z2 = y;
            int i7 = i4;
            ColorStateList a2 = dayViewDecorator.a(context2, i5, i4, i6, z2, z);
            boolean z3 = z;
            calendarItemStyle.g(textView2, a2, this.Y2.k(context2, i5, i7, i6, z2, z3));
            Drawable c3 = this.Y2.c(context2, i5, i7, i6, z2, z3);
            Drawable g2 = this.Y2.g(context2, i5, i7, i6, z2, z3);
            String str = c2;
            Drawable d2 = this.Y2.d(context2, i5, i7, i6, z2, z3);
            boolean z4 = z;
            textView2.setCompoundDrawables(c3, g2, d2, this.Y2.b(context2, i5, i7, i6, z2, z4));
            textView2.setContentDescription(this.Y2.j(context2, i5, i7, i6, z2, z4, str));
        }
    }

    private void p(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (Month.c(j2).equals(this.s)) {
            int l2 = this.s.l(j2);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(l2) - materialCalendarGridView.getFirstVisiblePosition()), j2, l2);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i2) {
        return b() + (i2 - 1);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.s.j(this.X2.o());
    }

    @Nullable
    /* renamed from: d */
    public Long getItem(int i2) {
        if (i2 < b() || i2 > m()) {
            return null;
        }
        return Long.valueOf(this.s.k(n(i2)));
    }

    /* JADX WARNING: type inference failed for: r7v9, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0064  */
    @androidx.annotation.NonNull
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = 1
            android.content.Context r1 = r8.getContext()
            r5.f(r1)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            if (r7 != 0) goto L_0x001f
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r1 = com.google.android.material.R.layout.u0
            android.view.View r7 = r7.inflate(r1, r8, r2)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x001f:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L_0x0054
            com.google.android.material.datepicker.Month r8 = r5.s
            int r3 = r8.X2
            if (r7 < r3) goto L_0x002e
            goto L_0x0054
        L_0x002e:
            int r7 = r7 + r0
            r1.setTag(r8)
            android.content.res.Resources r8 = r1.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r2] = r3
            java.lang.String r3 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r3, r4)
            r1.setText(r8)
            r1.setVisibility(r2)
            r1.setEnabled(r0)
            goto L_0x005d
        L_0x0054:
            r7 = 8
            r1.setVisibility(r7)
            r1.setEnabled(r2)
            r7 = -1
        L_0x005d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L_0x0064
            return r1
        L_0x0064:
            long r2 = r6.longValue()
            r5.o(r1, r2, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean g(long j2) {
        for (Pair<Long, Long> pair : this.X.h()) {
            S s2 = pair.f6297b;
            if (s2 != null && ((Long) s2).longValue() == j2) {
                return true;
            }
        }
        return false;
    }

    public int getCount() {
        return a3;
    }

    public long getItemId(int i2) {
        return (long) (i2 / this.s.Z);
    }

    /* access modifiers changed from: package-private */
    public boolean h(int i2) {
        return i2 % this.s.Z == 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i2) {
        return (i2 + 1) % this.s.Z == 0;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean k(long j2) {
        for (Pair<Long, Long> pair : this.X.h()) {
            F f2 = pair.f6296a;
            if (f2 != null && ((Long) f2).longValue() == j2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return (b() + this.s.X2) - 1;
    }

    /* access modifiers changed from: package-private */
    public int n(int i2) {
        return (i2 - b()) + 1;
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        for (Long longValue : this.Y) {
            p(materialCalendarGridView, longValue.longValue());
        }
        DateSelector<?> dateSelector = this.X;
        if (dateSelector != null) {
            for (Long longValue2 : dateSelector.F()) {
                p(materialCalendarGridView, longValue2.longValue());
            }
            this.Y = this.X.F();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r(int i2) {
        return i2 >= b() && i2 <= m();
    }
}
