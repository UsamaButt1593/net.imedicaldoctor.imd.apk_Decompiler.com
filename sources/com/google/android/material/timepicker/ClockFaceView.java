package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;

class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {
    private static final float a4 = 0.001f;
    private static final int b4 = 12;
    private static final String c4 = "";
    /* access modifiers changed from: private */
    public final ClockHandView L3;
    /* access modifiers changed from: private */
    public final Rect M3;
    private final RectF N3;
    private final Rect O3;
    /* access modifiers changed from: private */
    public final SparseArray<TextView> P3;
    private final AccessibilityDelegateCompat Q3;
    private final int[] R3;
    private final float[] S3;
    /* access modifiers changed from: private */
    public final int T3;
    private final int U3;
    private final int V3;
    private final int W3;
    private String[] X3;
    private float Y3;
    private final ColorStateList Z3;

    public ClockFaceView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void U() {
        RectF f2 = this.L3.f();
        TextView X = X(f2);
        for (int i2 = 0; i2 < this.P3.size(); i2++) {
            TextView textView = this.P3.get(i2);
            if (textView != null) {
                textView.setSelected(textView == X);
                textView.getPaint().setShader(W(f2, textView));
                textView.invalidate();
            }
        }
    }

    @Nullable
    private RadialGradient W(RectF rectF, TextView textView) {
        textView.getHitRect(this.M3);
        this.N3.set(this.M3);
        textView.getLineBounds(0, this.O3);
        RectF rectF2 = this.N3;
        Rect rect = this.O3;
        rectF2.inset((float) rect.left, (float) rect.top);
        if (!RectF.intersects(rectF, this.N3)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.N3.left, rectF.centerY() - this.N3.top, rectF.width() * 0.5f, this.R3, this.S3, Shader.TileMode.CLAMP);
    }

    @Nullable
    private TextView X(RectF rectF) {
        float f2 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i2 = 0; i2 < this.P3.size(); i2++) {
            TextView textView2 = this.P3.get(i2);
            if (textView2 != null) {
                textView2.getHitRect(this.M3);
                this.N3.set(this.M3);
                this.N3.union(rectF);
                float width = this.N3.width() * this.N3.height();
                if (width < f2) {
                    textView = textView2;
                    f2 = width;
                }
            }
        }
        return textView;
    }

    private static float Y(float f2, float f3, float f4) {
        return Math.max(Math.max(f2, f3), f4);
    }

    private void a0(@StringRes int i2) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.P3.size();
        boolean z = false;
        for (int i3 = 0; i3 < Math.max(this.X3.length, size); i3++) {
            TextView textView = this.P3.get(i3);
            if (i3 >= this.X3.length) {
                removeView(textView);
                this.P3.remove(i3);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.e0, this, false);
                    this.P3.put(i3, textView);
                    addView(textView);
                }
                textView.setText(this.X3[i3]);
                textView.setTag(R.id.U2, Integer.valueOf(i3));
                int i4 = (i3 / 12) + 1;
                textView.setTag(R.id.F2, Integer.valueOf(i4));
                if (i4 > 1) {
                    z = true;
                }
                ViewCompat.H1(textView, this.Q3);
                textView.setTextColor(this.Z3);
                if (i2 != 0) {
                    textView.setContentDescription(getResources().getString(i2, new Object[]{this.X3[i3]}));
                }
            }
        }
        this.L3.t(z);
    }

    public void M(int i2) {
        if (i2 != L()) {
            super.M(i2);
            this.L3.o(L());
        }
    }

    /* access modifiers changed from: protected */
    public void O() {
        super.O();
        for (int i2 = 0; i2 < this.P3.size(); i2++) {
            this.P3.get(i2).setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    public int V() {
        return this.L3.e();
    }

    /* access modifiers changed from: package-private */
    public void Z(int i2) {
        this.L3.p(i2);
    }

    public void c(String[] strArr, @StringRes int i2) {
        this.X3 = strArr;
        a0(i2);
    }

    public void d(float f2, boolean z) {
        if (Math.abs(this.Y3 - f2) > a4) {
            this.Y3 = f2;
            U();
        }
    }

    public void e(@FloatRange(from = 0.0d, to = 360.0d) float f2) {
        this.L3.q(f2);
        U();
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo).l1(AccessibilityNodeInfoCompat.CollectionInfoCompat.f(1, this.X3.length, false, 1));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        U();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int Y = (int) (((float) this.W3) / Y(((float) this.U3) / ((float) displayMetrics.heightPixels), ((float) this.V3) / ((float) displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Y, 1073741824);
        setMeasuredDimension(Y, Y);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Ic);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.M3 = new Rect();
        this.N3 = new RectF();
        this.O3 = new Rect();
        this.P3 = new SparseArray<>();
        this.S3 = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.v7, i2, R.style.uk);
        Resources resources = getResources();
        ColorStateList a2 = MaterialResources.a(context, obtainStyledAttributes, R.styleable.x7);
        this.Z3 = a2;
        LayoutInflater.from(context).inflate(R.layout.f0, this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.E2);
        this.L3 = clockHandView;
        this.T3 = resources.getDimensionPixelSize(R.dimen.G9);
        int colorForState = a2.getColorForState(new int[]{16842913}, a2.getDefaultColor());
        this.R3 = new int[]{colorForState, colorForState, a2.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = AppCompatResources.a(context, R.color.qc).getDefaultColor();
        ColorStateList a3 = MaterialResources.a(context, obtainStyledAttributes, R.styleable.w7);
        setBackgroundColor(a3 != null ? a3.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                if (!ClockFaceView.this.isShown()) {
                    return true;
                }
                ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                ClockFaceView.this.M(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.L3.j()) - ClockFaceView.this.T3);
                return true;
            }
        });
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.Q3 = new AccessibilityDelegateCompat() {
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                int intValue = ((Integer) view.getTag(R.id.U2)).intValue();
                if (intValue > 0) {
                    accessibilityNodeInfoCompat.j2((View) ClockFaceView.this.P3.get(intValue - 1));
                }
                accessibilityNodeInfoCompat.m1(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.j(0, 1, intValue, 1, false, view.isSelected()));
                accessibilityNodeInfoCompat.k1(true);
                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6657j);
            }

            public boolean j(View view, int i2, Bundle bundle) {
                if (i2 != 16) {
                    return super.j(view, i2, bundle);
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                view.getHitRect(ClockFaceView.this.M3);
                long j2 = uptimeMillis;
                float centerX = (float) ClockFaceView.this.M3.centerX();
                float centerY = (float) ClockFaceView.this.M3.centerY();
                ClockFaceView.this.L3.onTouchEvent(MotionEvent.obtain(uptimeMillis, j2, 0, centerX, centerY, 0));
                ClockFaceView.this.L3.onTouchEvent(MotionEvent.obtain(uptimeMillis, j2, 1, centerX, centerY, 0));
                return true;
            }
        };
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        c(strArr, 0);
        this.U3 = resources.getDimensionPixelSize(R.dimen.ia);
        this.V3 = resources.getDimensionPixelSize(R.dimen.ja);
        this.W3 = resources.getDimensionPixelSize(R.dimen.N9);
    }
}
