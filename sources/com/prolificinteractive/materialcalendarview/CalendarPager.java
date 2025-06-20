package com.prolificinteractive.materialcalendarview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

class CalendarPager extends ViewPager {
    private boolean v4 = true;

    public CalendarPager(@NonNull Context context) {
        super(context);
    }

    public boolean b0() {
        return this.v4;
    }

    public boolean canScrollHorizontally(int i2) {
        return this.v4 && super.canScrollHorizontally(i2);
    }

    public boolean canScrollVertically(int i2) {
        return this.v4 && super.canScrollVertically(i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.v4 && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.v4 && super.onTouchEvent(motionEvent);
    }

    public void setPagingEnabled(boolean z) {
        this.v4 = z;
    }

    public CalendarPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
