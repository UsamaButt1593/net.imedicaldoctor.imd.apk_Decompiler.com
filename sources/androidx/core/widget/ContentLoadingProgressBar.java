package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

public class ContentLoadingProgressBar extends ProgressBar {
    private static final int c3 = 500;
    private static final int d3 = 500;
    boolean X2;
    boolean Y2;
    boolean Z2;
    private final Runnable a3;
    private final Runnable b3;
    long s;

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @UiThread
    public void f() {
        this.Z2 = true;
        removeCallbacks(this.b3);
        this.Y2 = false;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.s;
        long j3 = currentTimeMillis - j2;
        if (j3 >= 500 || j2 == -1) {
            setVisibility(8);
        } else if (!this.X2) {
            postDelayed(this.a3, 500 - j3);
            this.X2 = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.X2 = false;
        this.s = -1;
        setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.Y2 = false;
        if (!this.Z2) {
            this.s = System.currentTimeMillis();
            setVisibility(0);
        }
    }

    private void i() {
        removeCallbacks(this.a3);
        removeCallbacks(this.b3);
    }

    /* access modifiers changed from: private */
    @UiThread
    public void k() {
        this.s = -1;
        this.Z2 = false;
        removeCallbacks(this.a3);
        this.X2 = false;
        if (!this.Y2) {
            postDelayed(this.b3, 500);
            this.Y2 = true;
        }
    }

    public void e() {
        post(new d(this));
    }

    public void j() {
        post(new c(this));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.s = -1;
        this.X2 = false;
        this.Y2 = false;
        this.Z2 = false;
        this.a3 = new a(this);
        this.b3 = new b(this);
    }
}
