package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

final class MaterialCalendarGridView extends GridView {
    private final boolean X2;
    private final Calendar s;

    public MaterialCalendarGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a(int i2, Rect rect) {
        int b2;
        if (i2 == 33) {
            b2 = getAdapter().m();
        } else if (i2 == 130) {
            b2 = getAdapter().b();
        } else {
            super.onFocusChanged(true, i2, rect);
            return;
        }
        setSelection(b2);
    }

    private View c(int i2) {
        return getChildAt(i2 - getFirstVisiblePosition());
    }

    private static int d(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean e(@Nullable Long l2, @Nullable Long l3, @Nullable Long l4, @Nullable Long l5) {
        return l2 == null || l3 == null || l4 == null || l5 == null || l4.longValue() > l3.longValue() || l5.longValue() < l2.longValue();
    }

    @NonNull
    /* renamed from: b */
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(@NonNull Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter b2 = getAdapter();
        DateSelector<?> dateSelector = b2.X;
        CalendarStyle calendarStyle = b2.Z;
        int max = Math.max(b2.b(), getFirstVisiblePosition());
        int min = Math.min(b2.m(), getLastVisiblePosition());
        Long d2 = b2.getItem(max);
        Long d3 = b2.getItem(min);
        Iterator<Pair<Long, Long>> it2 = dateSelector.h().iterator();
        while (it2.hasNext()) {
            Pair next = it2.next();
            F f2 = next.f6296a;
            if (f2 == null) {
                materialCalendarGridView = this;
            } else if (next.f6297b != null) {
                Long l2 = (Long) f2;
                long longValue = l2.longValue();
                Long l3 = (Long) next.f6297b;
                long longValue2 = l3.longValue();
                if (!e(d2, d3, l2, l3)) {
                    boolean s2 = ViewUtils.s(this);
                    if (longValue < d2.longValue()) {
                        if (b2.h(max)) {
                            i9 = 0;
                        } else {
                            View c2 = materialCalendarGridView.c(max - 1);
                            i9 = !s2 ? c2.getRight() : c2.getLeft();
                        }
                        i2 = i9;
                        i3 = max;
                    } else {
                        materialCalendarGridView.s.setTimeInMillis(longValue);
                        i3 = b2.a(materialCalendarGridView.s.get(5));
                        i2 = d(materialCalendarGridView.c(i3));
                    }
                    if (longValue2 > d3.longValue()) {
                        if (b2.i(min)) {
                            i8 = getWidth();
                        } else {
                            View c3 = materialCalendarGridView.c(min);
                            i8 = !s2 ? c3.getRight() : c3.getLeft();
                        }
                        i4 = i8;
                        i5 = min;
                    } else {
                        materialCalendarGridView.s.setTimeInMillis(longValue2);
                        i5 = b2.a(materialCalendarGridView.s.get(5));
                        i4 = d(materialCalendarGridView.c(i5));
                    }
                    int itemId = (int) b2.getItemId(i3);
                    int i10 = max;
                    int i11 = min;
                    int itemId2 = (int) b2.getItemId(i5);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        MonthAdapter monthAdapter = b2;
                        int numColumns2 = (numColumns + getNumColumns()) - 1;
                        View c4 = materialCalendarGridView.c(numColumns);
                        int top = c4.getTop() + calendarStyle.f21341a.e();
                        Iterator<Pair<Long, Long>> it3 = it2;
                        int bottom = c4.getBottom() - calendarStyle.f21341a.b();
                        if (!s2) {
                            i6 = numColumns > i3 ? 0 : i2;
                            i7 = i5 > numColumns2 ? getWidth() : i4;
                        } else {
                            int i12 = i5 > numColumns2 ? 0 : i4;
                            int width = numColumns > i3 ? getWidth() : i2;
                            i6 = i12;
                            i7 = width;
                        }
                        canvas.drawRect((float) i6, (float) top, (float) i7, (float) bottom, calendarStyle.f21348h);
                        itemId++;
                        materialCalendarGridView = this;
                        itemId2 = itemId2;
                        b2 = monthAdapter;
                        it2 = it3;
                    }
                    materialCalendarGridView = this;
                    max = i10;
                    min = i11;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        if (z) {
            a(i2, rect);
        } else {
            super.onFocusChanged(false, i2, rect);
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!super.onKeyDown(i2, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i2) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    public void onMeasure(int i2, int i3) {
        if (this.X2) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(ViewCompat.x, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setSelection(int i2) {
        if (i2 < getAdapter().b()) {
            i2 = getAdapter().b();
        }
        super.setSelection(i2);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof MonthAdapter) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = UtcDates.x();
        if (MaterialDatePicker.E3(getContext())) {
            setNextFocusLeftId(R.id.A0);
            setNextFocusRightId(R.id.M0);
        }
        this.X2 = MaterialDatePicker.G3(getContext());
        ViewCompat.H1(this, new AccessibilityDelegateCompat() {
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.l1((Object) null);
            }
        });
    }
}
