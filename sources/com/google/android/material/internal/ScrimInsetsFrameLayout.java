package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout extends FrameLayout {
    Rect X2;
    private Rect Y2;
    private boolean Z2;
    private boolean a3;
    private boolean b3;
    private boolean c3;
    @Nullable
    Drawable s;

    public ScrimInsetsFrameLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.X2 != null && this.s != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            if (this.Z2) {
                this.Y2.set(0, 0, width, this.X2.top);
                this.s.setBounds(this.Y2);
                this.s.draw(canvas);
            }
            if (this.a3) {
                this.Y2.set(0, height - this.X2.bottom, width, height);
                this.s.setBounds(this.Y2);
                this.s.draw(canvas);
            }
            if (this.b3) {
                Rect rect = this.Y2;
                Rect rect2 = this.X2;
                rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
                this.s.setBounds(this.Y2);
                this.s.draw(canvas);
            }
            if (this.c3) {
                Rect rect3 = this.Y2;
                Rect rect4 = this.X2;
                rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
                this.s.setBounds(this.Y2);
                this.s.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void h(WindowInsetsCompat windowInsetsCompat) {
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.a3 = z;
    }

    public void setDrawLeftInsetForeground(boolean z) {
        this.b3 = z;
    }

    public void setDrawRightInsetForeground(boolean z) {
        this.c3 = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.Z2 = z;
    }

    public void setScrimInsetForeground(@Nullable Drawable drawable) {
        this.s = drawable;
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Y2 = new Rect();
        this.Z2 = true;
        this.a3 = true;
        this.b3 = true;
        this.c3 = true;
        TypedArray k2 = ThemeEnforcement.k(context, attributeSet, R.styleable.ls, i2, R.style.Re, new int[0]);
        this.s = k2.getDrawable(R.styleable.ms);
        k2.recycle();
        setWillNotDraw(true);
        ViewCompat.k2(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                if (scrimInsetsFrameLayout.X2 == null) {
                    scrimInsetsFrameLayout.X2 = new Rect();
                }
                ScrimInsetsFrameLayout.this.X2.set(windowInsetsCompat.p(), windowInsetsCompat.r(), windowInsetsCompat.q(), windowInsetsCompat.o());
                ScrimInsetsFrameLayout.this.h(windowInsetsCompat);
                ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.w() || ScrimInsetsFrameLayout.this.s == null);
                ViewCompat.t1(ScrimInsetsFrameLayout.this);
                return windowInsetsCompat.c();
            }
        });
    }
}
