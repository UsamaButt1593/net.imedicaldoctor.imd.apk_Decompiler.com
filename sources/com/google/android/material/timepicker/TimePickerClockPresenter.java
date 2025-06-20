package com.google.android.material.timepicker;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;

class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {
    private static final String[] Y2 = {"12", IcyHeaders.a3, ExifInterface.Y4, ExifInterface.Z4, "4", "5", "6", "7", "8", "9", "10", "11"};
    private static final String[] Z2 = {"00", IcyHeaders.a3, ExifInterface.Y4, ExifInterface.Z4, "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    private static final String[] a3 = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    private static final int b3 = 30;
    private static final int c3 = 6;
    /* access modifiers changed from: private */
    public final TimeModel X;
    private boolean X2 = false;
    private float Y;
    private float Z;
    private final TimePickerView s;

    public TimePickerClockPresenter(TimePickerView timePickerView, TimeModel timeModel) {
        this.s = timePickerView;
        this.X = timeModel;
        b();
    }

    private String[] j() {
        return this.X.Y == 1 ? Z2 : Y2;
    }

    private int k() {
        return (this.X.d() * 30) % 360;
    }

    private void l(int i2, int i3) {
        TimeModel timeModel = this.X;
        if (timeModel.X2 != i3 || timeModel.Z != i2) {
            this.s.performHapticFeedback(4);
        }
    }

    private void n() {
        TimeModel timeModel = this.X;
        int i2 = 1;
        if (timeModel.Y2 == 10 && timeModel.Y == 1 && timeModel.Z >= 12) {
            i2 = 2;
        }
        this.s.P(i2);
    }

    private void o() {
        TimePickerView timePickerView = this.s;
        TimeModel timeModel = this.X;
        timePickerView.b(timeModel.Z2, timeModel.d(), this.X.X2);
    }

    private void p() {
        q(Y2, TimeModel.b3);
        q(a3, TimeModel.a3);
    }

    private void q(String[] strArr, String str) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = TimeModel.b(this.s.getResources(), strArr[i2], str);
        }
    }

    public void a() {
        this.s.setVisibility(0);
    }

    public void b() {
        if (this.X.Y == 0) {
            this.s.Z();
        }
        this.s.L(this);
        this.s.W(this);
        this.s.V(this);
        this.s.T(this);
        p();
        c();
    }

    public void c() {
        this.Z = (float) k();
        TimeModel timeModel = this.X;
        this.Y = (float) (timeModel.X2 * 6);
        m(timeModel.Y2, false);
        o();
    }

    public void d(float f2, boolean z) {
        if (!this.X2) {
            TimeModel timeModel = this.X;
            int i2 = timeModel.Z;
            int i3 = timeModel.X2;
            int round = Math.round(f2);
            TimeModel timeModel2 = this.X;
            if (timeModel2.Y2 == 12) {
                timeModel2.o((round + 3) / 6);
                this.Y = (float) Math.floor((double) (this.X.X2 * 6));
            } else {
                int i4 = (round + 15) / 30;
                if (timeModel2.Y == 1) {
                    i4 %= 12;
                    if (this.s.M() == 2) {
                        i4 += 12;
                    }
                }
                this.X.l(i4);
                this.Z = (float) k();
            }
            if (!z) {
                o();
                l(i2, i3);
            }
        }
    }

    public void e(float f2, boolean z) {
        this.X2 = true;
        TimeModel timeModel = this.X;
        int i2 = timeModel.X2;
        int i3 = timeModel.Z;
        if (timeModel.Y2 == 10) {
            this.s.Q(this.Z, false);
            AccessibilityManager accessibilityManager = (AccessibilityManager) ContextCompat.s(this.s.getContext(), AccessibilityManager.class);
            if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                m(12, true);
            }
        } else {
            int round = Math.round(f2);
            if (!z) {
                this.X.o(((round + 15) / 30) * 5);
                this.Y = (float) (this.X.X2 * 6);
            }
            this.s.Q(this.Y, z);
        }
        this.X2 = false;
        o();
        l(i3, i2);
    }

    public void f(int i2) {
        this.X.p(i2);
    }

    public void g(int i2) {
        m(i2, true);
    }

    public void h() {
        this.s.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void m(int i2, boolean z) {
        boolean z2 = i2 == 12;
        this.s.O(z2);
        this.X.Y2 = i2;
        this.s.c(z2 ? a3 : j(), z2 ? R.string.x0 : this.X.c());
        n();
        this.s.Q(z2 ? this.Y : this.Z, z);
        this.s.a(i2);
        this.s.S(new ClickActionDelegate(this.s.getContext(), R.string.u0) {
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.o1(view.getResources().getString(TimePickerClockPresenter.this.X.c(), new Object[]{String.valueOf(TimePickerClockPresenter.this.X.d())}));
            }
        });
        this.s.R(new ClickActionDelegate(this.s.getContext(), R.string.w0) {
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.o1(view.getResources().getString(R.string.x0, new Object[]{String.valueOf(TimePickerClockPresenter.this.X.X2)}));
            }
        });
    }
}
