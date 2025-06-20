package net.imedicaldoctor.imd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

public class NestedScrollWebView extends WebView implements NestedScrollingChild {
    public static final String b3 = "NestedScrollWebView";
    private final int[] X2;
    private final int[] Y2;
    private int Z2;
    private final NestedScrollingChildHelper a3;
    private int s;

    public NestedScrollWebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.a3.a(f2, f3, z);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.a3.b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.a3.c(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.a3.f(i2, i3, i4, i5, iArr);
    }

    public boolean e() {
        return getContext().getSharedPreferences("default_preferences", 0).getBoolean("NestedScroll", true);
    }

    public boolean hasNestedScrollingParent() {
        return this.a3.k();
    }

    public boolean isNestedScrollingEnabled() {
        if (!e()) {
            return false;
        }
        return this.a3.m();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!e()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int c2 = MotionEventCompat.c(motionEvent);
            if (c2 == 0) {
                this.Z2 = 0;
            }
            int y = (int) motionEvent.getY();
            motionEvent.offsetLocation(0.0f, (float) this.Z2);
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 == 2) {
                        int i2 = this.s - y;
                        if (dispatchNestedPreScroll(0, i2, this.Y2, this.X2)) {
                            i2 -= this.Y2[1];
                            obtain.offsetLocation(0.0f, (float) this.X2[1]);
                            this.Z2 += this.X2[1];
                        }
                        int scrollY = getScrollY();
                        this.s = y - this.X2[1];
                        if (i2 < 0) {
                            int max = Math.max(0, scrollY + i2);
                            int i3 = i2 - (max - scrollY);
                            if (dispatchNestedScroll(0, max - i3, 0, i3, this.X2)) {
                                int i4 = this.s;
                                int i5 = this.X2[1];
                                this.s = i4 - i5;
                                obtain.offsetLocation(0.0f, (float) i5);
                                this.Z2 += this.X2[1];
                            }
                        }
                        obtain.recycle();
                        return super.onTouchEvent(obtain);
                    } else if (c2 != 3) {
                        return false;
                    }
                }
                stopNestedScroll();
            } else {
                this.s = y;
                startNestedScroll(2);
            }
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (e()) {
            this.a3.p(z);
        }
    }

    public boolean startNestedScroll(int i2) {
        return this.a3.r(i2);
    }

    public void stopNestedScroll() {
        this.a3.t();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.X2 = new int[2];
        this.Y2 = new int[2];
        this.a3 = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }
}
