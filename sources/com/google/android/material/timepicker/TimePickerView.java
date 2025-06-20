package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;

class TimePickerView extends ConstraintLayout implements TimePickerControls {
    static final String N3 = "android.view.View";
    private final Chip E3;
    private final Chip F3;
    private final ClockHandView G3;
    private final ClockFaceView H3;
    private final MaterialButtonToggleGroup I3;
    private final View.OnClickListener J3;
    private OnPeriodChangeListener K3;
    /* access modifiers changed from: private */
    public OnSelectionChange L3;
    /* access modifiers changed from: private */
    public OnDoubleTapListener M3;

    interface OnDoubleTapListener {
        void g();
    }

    interface OnPeriodChangeListener {
        void f(int i2);
    }

    interface OnSelectionChange {
        void g(int i2);
    }

    public TimePickerView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z) {
        OnPeriodChangeListener onPeriodChangeListener;
        if (z && (onPeriodChangeListener = this.K3) != null) {
            onPeriodChangeListener.f(i2 == R.id.H2 ? 1 : 0);
        }
    }

    private void X() {
        Chip chip = this.E3;
        int i2 = R.id.d5;
        chip.setTag(i2, 12);
        this.F3.setTag(i2, 10);
        this.E3.setOnClickListener(this.J3);
        this.F3.setOnClickListener(this.J3);
        this.E3.setAccessibilityClassName(N3);
        this.F3.setAccessibilityClassName(N3);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Y() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                OnDoubleTapListener K = TimePickerView.this.M3;
                if (K == null) {
                    return false;
                }
                K.g();
                return true;
            }
        });
        AnonymousClass3 r1 = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        this.E3.setOnTouchListener(r1);
        this.F3.setOnTouchListener(r1);
    }

    private void a0(Chip chip, boolean z) {
        chip.setChecked(z);
        ViewCompat.J1(chip, z ? 2 : 0);
    }

    public void L(ClockHandView.OnRotateListener onRotateListener) {
        this.G3.b(onRotateListener);
    }

    /* access modifiers changed from: package-private */
    public int M() {
        return this.H3.V();
    }

    public void O(boolean z) {
        this.G3.n(z);
    }

    /* access modifiers changed from: package-private */
    public void P(int i2) {
        this.H3.Z(i2);
    }

    public void Q(float f2, boolean z) {
        this.G3.r(f2, z);
    }

    public void R(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.H1(this.E3, accessibilityDelegateCompat);
    }

    public void S(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.H1(this.F3, accessibilityDelegateCompat);
    }

    public void T(ClockHandView.OnActionUpListener onActionUpListener) {
        this.G3.u(onActionUpListener);
    }

    /* access modifiers changed from: package-private */
    public void U(@Nullable OnDoubleTapListener onDoubleTapListener) {
        this.M3 = onDoubleTapListener;
    }

    /* access modifiers changed from: package-private */
    public void V(OnPeriodChangeListener onPeriodChangeListener) {
        this.K3 = onPeriodChangeListener;
    }

    /* access modifiers changed from: package-private */
    public void W(OnSelectionChange onSelectionChange) {
        this.L3 = onSelectionChange;
    }

    public void Z() {
        this.I3.setVisibility(0);
    }

    public void a(int i2) {
        boolean z = false;
        a0(this.E3, i2 == 12);
        Chip chip = this.F3;
        if (i2 == 10) {
            z = true;
        }
        a0(chip, z);
    }

    @SuppressLint({"DefaultLocale"})
    public void b(int i2, int i3, int i4) {
        this.I3.e(i2 == 1 ? R.id.H2 : R.id.G2);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.a3, new Object[]{Integer.valueOf(i4)});
        String format2 = String.format(locale, TimeModel.a3, new Object[]{Integer.valueOf(i3)});
        if (!TextUtils.equals(this.E3.getText(), format)) {
            this.E3.setText(format);
        }
        if (!TextUtils.equals(this.F3.getText(), format2)) {
            this.F3.setText(format2);
        }
    }

    public void c(String[] strArr, @StringRes int i2) {
        this.H3.c(strArr, i2);
    }

    public void e(float f2) {
        this.G3.q(f2);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && i2 == 0) {
            this.F3.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.J3 = new View.OnClickListener() {
            public void onClick(View view) {
                if (TimePickerView.this.L3 != null) {
                    TimePickerView.this.L3.g(((Integer) view.getTag(R.id.d5)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.k0, this);
        this.H3 = (ClockFaceView) findViewById(R.id.D2);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.I2);
        this.I3 = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new f(this));
        this.E3 = (Chip) findViewById(R.id.N2);
        this.F3 = (Chip) findViewById(R.id.K2);
        this.G3 = (ClockHandView) findViewById(R.id.E2);
        Y();
        X();
    }
}
