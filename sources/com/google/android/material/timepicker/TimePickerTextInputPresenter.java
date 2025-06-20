package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.timepicker.TimePickerView;
import java.lang.reflect.Field;
import java.util.Locale;

class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {
    /* access modifiers changed from: private */
    public final TimeModel X;
    private final ChipTextInputComboView X2;
    private final TextWatcher Y = new TextWatcherAdapter() {
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.X.o(0);
                    return;
                }
                TimePickerTextInputPresenter.this.X.o(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };
    private final ChipTextInputComboView Y2;
    private final TextWatcher Z = new TextWatcherAdapter() {
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.X.l(0);
                    return;
                }
                TimePickerTextInputPresenter.this.X.l(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };
    private final TimePickerTextInputKeyController Z2;
    private final EditText a3;
    private final EditText b3;
    private MaterialButtonToggleGroup c3;
    private final LinearLayout s;

    public TimePickerTextInputPresenter(LinearLayout linearLayout, final TimeModel timeModel) {
        this.s = linearLayout;
        this.X = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.M2);
        this.X2 = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.J2);
        this.Y2 = chipTextInputComboView2;
        int i2 = R.id.L2;
        ((TextView) chipTextInputComboView.findViewById(i2)).setText(resources.getString(R.string.J0));
        ((TextView) chipTextInputComboView2.findViewById(i2)).setText(resources.getString(R.string.I0));
        int i3 = R.id.d5;
        chipTextInputComboView.setTag(i3, 12);
        chipTextInputComboView2.setTag(i3, 10);
        if (timeModel.Y == 0) {
            o();
        }
        AnonymousClass3 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                TimePickerTextInputPresenter.this.g(((Integer) view.getTag(R.id.d5)).intValue());
            }
        };
        chipTextInputComboView2.setOnClickListener(r0);
        chipTextInputComboView.setOnClickListener(r0);
        chipTextInputComboView2.c(timeModel.g());
        chipTextInputComboView.c(timeModel.j());
        this.a3 = chipTextInputComboView2.f().getEditText();
        this.b3 = chipTextInputComboView.f().getEditText();
        this.Z2 = new TimePickerTextInputKeyController(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.g(new ClickActionDelegate(linearLayout.getContext(), R.string.u0) {
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.o1(view.getResources().getString(timeModel.c(), new Object[]{String.valueOf(timeModel.d())}));
            }
        });
        chipTextInputComboView.g(new ClickActionDelegate(linearLayout.getContext(), R.string.w0) {
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.o1(view.getResources().getString(R.string.x0, new Object[]{String.valueOf(timeModel.X2)}));
            }
        });
        b();
    }

    private void f() {
        this.a3.addTextChangedListener(this.Z);
        this.b3.addTextChangedListener(this.Y);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z) {
        if (z) {
            this.X.p(i2 == R.id.H2 ? 1 : 0);
        }
    }

    private void k() {
        this.a3.removeTextChangedListener(this.Z);
        this.b3.removeTextChangedListener(this.Y);
    }

    private static void m(EditText editText, @ColorInt int i2) {
        Class<TextView> cls = TextView.class;
        try {
            Context context = editText.getContext();
            Field declaredField = cls.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i3 = declaredField.getInt(editText);
            Field declaredField2 = cls.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable b2 = AppCompatResources.b(context, i3);
            b2.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, new Drawable[]{b2, b2});
        } catch (Throwable unused) {
        }
    }

    private void n(TimeModel timeModel) {
        k();
        Locale locale = this.s.getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.a3, new Object[]{Integer.valueOf(timeModel.X2)});
        String format2 = String.format(locale, TimeModel.a3, new Object[]{Integer.valueOf(timeModel.d())});
        this.X2.j(format);
        this.Y2.j(format2);
        f();
        p();
    }

    private void o() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.s.findViewById(R.id.I2);
        this.c3 = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new e(this));
        this.c3.setVisibility(0);
        p();
    }

    private void p() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.c3;
        if (materialButtonToggleGroup != null) {
            materialButtonToggleGroup.e(this.X.Z2 == 0 ? R.id.G2 : R.id.H2);
        }
    }

    public void a() {
        this.s.setVisibility(0);
        g(this.X.Y2);
    }

    public void b() {
        f();
        n(this.X);
        this.Z2.a();
    }

    public void c() {
        n(this.X);
    }

    public void g(int i2) {
        this.X.Y2 = i2;
        boolean z = false;
        this.X2.setChecked(i2 == 12);
        ChipTextInputComboView chipTextInputComboView = this.Y2;
        if (i2 == 10) {
            z = true;
        }
        chipTextInputComboView.setChecked(z);
        p();
    }

    public void h() {
        View focusedChild = this.s.getFocusedChild();
        if (focusedChild != null) {
            ViewUtils.r(focusedChild, false);
        }
        this.s.setVisibility(8);
    }

    public void i() {
        this.X2.setChecked(false);
        this.Y2.setChecked(false);
    }

    public void l() {
        boolean z = false;
        this.X2.setChecked(this.X.Y2 == 12);
        ChipTextInputComboView chipTextInputComboView = this.Y2;
        if (this.X.Y2 == 10) {
            z = true;
        }
        chipTextInputComboView.setChecked(z);
    }
}
