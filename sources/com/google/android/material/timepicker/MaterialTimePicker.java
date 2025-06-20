package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.timepicker.TimePickerView;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.LinkedHashSet;
import java.util.Set;

public final class MaterialTimePicker extends DialogFragment implements TimePickerView.OnDoubleTapListener {
    public static final int b5 = 0;
    public static final int c5 = 1;
    static final String d5 = "TIME_PICKER_TIME_MODEL";
    static final String e5 = "TIME_PICKER_INPUT_MODE";
    static final String f5 = "TIME_PICKER_TITLE_RES";
    static final String g5 = "TIME_PICKER_TITLE_TEXT";
    static final String h5 = "TIME_PICKER_POSITIVE_BUTTON_TEXT_RES";
    static final String i5 = "TIME_PICKER_POSITIVE_BUTTON_TEXT";
    static final String j5 = "TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES";
    static final String k5 = "TIME_PICKER_NEGATIVE_BUTTON_TEXT";
    static final String l5 = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    /* access modifiers changed from: private */
    public final Set<View.OnClickListener> F4 = new LinkedHashSet();
    /* access modifiers changed from: private */
    public final Set<View.OnClickListener> G4 = new LinkedHashSet();
    private final Set<DialogInterface.OnCancelListener> H4 = new LinkedHashSet();
    private final Set<DialogInterface.OnDismissListener> I4 = new LinkedHashSet();
    private TimePickerView J4;
    private ViewStub K4;
    @Nullable
    private TimePickerClockPresenter L4;
    @Nullable
    private TimePickerTextInputPresenter M4;
    @Nullable
    private TimePickerPresenter N4;
    @DrawableRes
    private int O4;
    @DrawableRes
    private int P4;
    @StringRes
    private int Q4 = 0;
    private CharSequence R4;
    @StringRes
    private int S4 = 0;
    private CharSequence T4;
    @StringRes
    private int U4 = 0;
    private CharSequence V4;
    /* access modifiers changed from: private */
    public MaterialButton W4;
    private Button X4;
    /* access modifiers changed from: private */
    public int Y4 = 0;
    private TimeModel Z4;
    private int a5 = 0;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public TimeModel f22071a = new TimeModel();
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Integer f22072b;
        /* access modifiers changed from: private */
        @StringRes

        /* renamed from: c  reason: collision with root package name */
        public int f22073c = 0;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f22074d;
        /* access modifiers changed from: private */
        @StringRes

        /* renamed from: e  reason: collision with root package name */
        public int f22075e = 0;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f22076f;
        /* access modifiers changed from: private */
        @StringRes

        /* renamed from: g  reason: collision with root package name */
        public int f22077g = 0;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f22078h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f22079i = 0;

        @NonNull
        public MaterialTimePicker j() {
            return MaterialTimePicker.E3(this);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder k(@IntRange(from = 0, to = 23) int i2) {
            this.f22071a.m(i2);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder l(int i2) {
            this.f22072b = Integer.valueOf(i2);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder m(@IntRange(from = 0, to = 59) int i2) {
            this.f22071a.o(i2);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder n(@StringRes int i2) {
            this.f22077g = i2;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder o(@Nullable CharSequence charSequence) {
            this.f22078h = charSequence;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder p(@StringRes int i2) {
            this.f22075e = i2;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder q(@Nullable CharSequence charSequence) {
            this.f22076f = charSequence;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder r(@StyleRes int i2) {
            this.f22079i = i2;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder s(int i2) {
            TimeModel timeModel = this.f22071a;
            int i3 = timeModel.Z;
            int i4 = timeModel.X2;
            TimeModel timeModel2 = new TimeModel(i2);
            this.f22071a = timeModel2;
            timeModel2.o(i4);
            this.f22071a.m(i3);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder t(@StringRes int i2) {
            this.f22073c = i2;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder u(@Nullable CharSequence charSequence) {
            this.f22074d = charSequence;
            return this;
        }
    }

    private int A3() {
        int i2 = this.a5;
        if (i2 != 0) {
            return i2;
        }
        TypedValue a2 = MaterialAttributes.a(X1(), R.attr.Yc);
        if (a2 == null) {
            return 0;
        }
        return a2.data;
    }

    private TimePickerPresenter C3(int i2, @NonNull TimePickerView timePickerView, @NonNull ViewStub viewStub) {
        if (i2 == 0) {
            TimePickerClockPresenter timePickerClockPresenter = this.L4;
            if (timePickerClockPresenter == null) {
                timePickerClockPresenter = new TimePickerClockPresenter(timePickerView, this.Z4);
            }
            this.L4 = timePickerClockPresenter;
            return timePickerClockPresenter;
        }
        if (this.M4 == null) {
            this.M4 = new TimePickerTextInputPresenter((LinearLayout) viewStub.inflate(), this.Z4);
        }
        this.M4.i();
        return this.M4;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D3() {
        TimePickerPresenter timePickerPresenter = this.N4;
        if (timePickerPresenter instanceof TimePickerTextInputPresenter) {
            ((TimePickerTextInputPresenter) timePickerPresenter).l();
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public static MaterialTimePicker E3(@NonNull Builder builder) {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable(d5, builder.f22071a);
        if (builder.f22072b != null) {
            bundle.putInt(e5, builder.f22072b.intValue());
        }
        bundle.putInt(f5, builder.f22073c);
        if (builder.f22074d != null) {
            bundle.putCharSequence(g5, builder.f22074d);
        }
        bundle.putInt(h5, builder.f22075e);
        if (builder.f22076f != null) {
            bundle.putCharSequence(i5, builder.f22076f);
        }
        bundle.putInt(j5, builder.f22077g);
        if (builder.f22078h != null) {
            bundle.putCharSequence(k5, builder.f22078h);
        }
        bundle.putInt(l5, builder.f22079i);
        materialTimePicker.i2(bundle);
        return materialTimePicker;
    }

    private void J3(@Nullable Bundle bundle) {
        if (bundle != null) {
            TimeModel timeModel = (TimeModel) bundle.getParcelable(d5);
            this.Z4 = timeModel;
            if (timeModel == null) {
                this.Z4 = new TimeModel();
            }
            int i2 = 1;
            if (this.Z4.Y != 1) {
                i2 = 0;
            }
            this.Y4 = bundle.getInt(e5, i2);
            this.Q4 = bundle.getInt(f5, 0);
            this.R4 = bundle.getCharSequence(g5);
            this.S4 = bundle.getInt(h5, 0);
            this.T4 = bundle.getCharSequence(i5);
            this.U4 = bundle.getInt(j5, 0);
            this.V4 = bundle.getCharSequence(k5);
            this.a5 = bundle.getInt(l5, 0);
        }
    }

    private void N3() {
        Button button = this.X4;
        if (button != null) {
            button.setVisibility(T2() ? 0 : 8);
        }
    }

    /* access modifiers changed from: private */
    public void O3(MaterialButton materialButton) {
        if (materialButton != null && this.J4 != null && this.K4 != null) {
            TimePickerPresenter timePickerPresenter = this.N4;
            if (timePickerPresenter != null) {
                timePickerPresenter.h();
            }
            TimePickerPresenter C3 = C3(this.Y4, this.J4, this.K4);
            this.N4 = C3;
            C3.a();
            this.N4.c();
            Pair<Integer, Integer> w3 = w3(this.Y4);
            materialButton.setIconResource(((Integer) w3.first).intValue());
            materialButton.setContentDescription(b0().getString(((Integer) w3.second).intValue()));
            materialButton.sendAccessibilityEvent(4);
        }
    }

    private Pair<Integer, Integer> w3(int i2) {
        if (i2 == 0) {
            return new Pair<>(Integer.valueOf(this.O4), Integer.valueOf(R.string.M0));
        }
        if (i2 == 1) {
            return new Pair<>(Integer.valueOf(this.P4), Integer.valueOf(R.string.H0));
        }
        throw new IllegalArgumentException("no icon for mode: " + i2);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public TimePickerClockPresenter B3() {
        return this.L4;
    }

    public boolean F3(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.H4.remove(onCancelListener);
    }

    public boolean G3(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.I4.remove(onDismissListener);
    }

    public boolean H3(@NonNull View.OnClickListener onClickListener) {
        return this.G4.remove(onClickListener);
    }

    public boolean I3(@NonNull View.OnClickListener onClickListener) {
        return this.F4.remove(onClickListener);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void K3(@Nullable TimePickerPresenter timePickerPresenter) {
        this.N4 = timePickerPresenter;
    }

    public void L3(@IntRange(from = 0, to = 23) int i2) {
        this.Z4.l(i2);
        TimePickerPresenter timePickerPresenter = this.N4;
        if (timePickerPresenter != null) {
            timePickerPresenter.c();
        }
    }

    public void M3(@IntRange(from = 0, to = 59) int i2) {
        this.Z4.o(i2);
        TimePickerPresenter timePickerPresenter = this.N4;
        if (timePickerPresenter != null) {
            timePickerPresenter.c();
        }
    }

    public void Q0(@Nullable Bundle bundle) {
        super.Q0(bundle);
        if (bundle == null) {
            bundle = y();
        }
        J3(bundle);
    }

    @NonNull
    public final View U0(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.l0, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.T2);
        this.J4 = timePickerView;
        timePickerView.U(this);
        this.K4 = (ViewStub) viewGroup2.findViewById(R.id.O2);
        this.W4 = (MaterialButton) viewGroup2.findViewById(R.id.R2);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.W1);
        int i2 = this.Q4;
        if (i2 != 0) {
            textView.setText(i2);
        } else if (!TextUtils.isEmpty(this.R4)) {
            textView.setText(this.R4);
        }
        O3(this.W4);
        Button button = (Button) viewGroup2.findViewById(R.id.S2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                for (View.OnClickListener onClick : MaterialTimePicker.this.F4) {
                    onClick.onClick(view);
                }
                MaterialTimePicker.this.M2();
            }
        });
        int i3 = this.S4;
        if (i3 != 0) {
            button.setText(i3);
        } else if (!TextUtils.isEmpty(this.T4)) {
            button.setText(this.T4);
        }
        Button button2 = (Button) viewGroup2.findViewById(R.id.P2);
        this.X4 = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                for (View.OnClickListener onClick : MaterialTimePicker.this.G4) {
                    onClick.onClick(view);
                }
                MaterialTimePicker.this.M2();
            }
        });
        int i4 = this.U4;
        if (i4 != 0) {
            this.X4.setText(i4);
        } else if (!TextUtils.isEmpty(this.V4)) {
            this.X4.setText(this.V4);
        }
        N3();
        this.W4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                int unused = materialTimePicker.Y4 = materialTimePicker.Y4 == 0 ? 1 : 0;
                MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
                materialTimePicker2.O3(materialTimePicker2.W4);
            }
        });
        return viewGroup2;
    }

    @NonNull
    public final Dialog U2(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(X1(), A3());
        Context context = dialog.getContext();
        int i2 = R.attr.Xc;
        int i3 = R.style.sk;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, (AttributeSet) null, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.f20760io, i2, i3);
        this.P4 = obtainStyledAttributes.getResourceId(R.styleable.ko, 0);
        this.O4 = obtainStyledAttributes.getResourceId(R.styleable.lo, 0);
        int color = obtainStyledAttributes.getColor(R.styleable.jo, 0);
        obtainStyledAttributes.recycle();
        materialShapeDrawable.a0(context);
        materialShapeDrawable.p0(ColorStateList.valueOf(color));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        materialShapeDrawable.o0(ViewCompat.T(window.getDecorView()));
        return dialog;
    }

    public void X0() {
        super.X0();
        this.N4 = null;
        this.L4 = null;
        this.M4 = null;
        TimePickerView timePickerView = this.J4;
        if (timePickerView != null) {
            timePickerView.U((TimePickerView.OnDoubleTapListener) null);
            this.J4 = null;
        }
    }

    public void Z2(boolean z) {
        super.Z2(z);
        N3();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void g() {
        this.Y4 = 1;
        O3(this.W4);
        this.M4.l();
    }

    public void m1(@NonNull Bundle bundle) {
        super.m1(bundle);
        bundle.putParcelable(d5, this.Z4);
        bundle.putInt(e5, this.Y4);
        bundle.putInt(f5, this.Q4);
        bundle.putCharSequence(g5, this.R4);
        bundle.putInt(h5, this.S4);
        bundle.putCharSequence(i5, this.T4);
        bundle.putInt(j5, this.U4);
        bundle.putCharSequence(k5, this.V4);
        bundle.putInt(l5, this.a5);
    }

    public boolean o3(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.H4.add(onCancelListener);
    }

    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancel : this.H4) {
            onCancel.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismiss : this.I4) {
            onDismiss.onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    public void p1(@NonNull View view, @Nullable Bundle bundle) {
        super.p1(view, bundle);
        if (this.N4 instanceof TimePickerTextInputPresenter) {
            view.postDelayed(new c(this), 100);
        }
    }

    public boolean p3(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.I4.add(onDismissListener);
    }

    public boolean q3(@NonNull View.OnClickListener onClickListener) {
        return this.G4.add(onClickListener);
    }

    public boolean r3(@NonNull View.OnClickListener onClickListener) {
        return this.F4.add(onClickListener);
    }

    public void s3() {
        this.H4.clear();
    }

    public void t3() {
        this.I4.clear();
    }

    public void u3() {
        this.G4.clear();
    }

    public void v3() {
        this.F4.clear();
    }

    @IntRange(from = 0, to = 23)
    public int x3() {
        return this.Z4.Z % 24;
    }

    public int y3() {
        return this.Y4;
    }

    @IntRange(from = 0, to = 59)
    public int z3() {
        return this.Z4.X2;
    }
}
