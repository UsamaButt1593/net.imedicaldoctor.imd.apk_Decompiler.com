package net.imedicaldoctor.imd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

public class iMDSlidingPaneLayout extends SlidingPaneLayout {
    boolean x3 = getContext().getSharedPreferences("default_preferences", 0).getBoolean("lockfull", true);

    public iMDSlidingPaneLayout(Context context) {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.x3 || l() || findViewById(R.id.f1010menu_button) == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public iMDSlidingPaneLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public iMDSlidingPaneLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
