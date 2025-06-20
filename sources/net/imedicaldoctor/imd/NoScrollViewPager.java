package net.imedicaldoctor.imd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class NoScrollViewPager extends ViewPager {
    private boolean v4 = true;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return this.v4 && super.onInterceptTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.v4 && super.onTouchEvent(motionEvent);
    }

    public void setPagingEnabled(boolean z) {
        this.v4 = z;
    }

    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
