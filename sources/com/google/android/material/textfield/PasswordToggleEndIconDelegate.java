package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.material.R;

class PasswordToggleEndIconDelegate extends EndIconDelegate {

    /* renamed from: e  reason: collision with root package name */
    private int f22059e = R.drawable.O0;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private EditText f22060f;

    /* renamed from: g  reason: collision with root package name */
    private final View.OnClickListener f22061g = new n(this);

    PasswordToggleEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout, @DrawableRes int i2) {
        super(endCompoundLayout);
        if (i2 != 0) {
            this.f22059e = i2;
        }
    }

    private boolean w() {
        EditText editText = this.f22060f;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean x(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EditText editText;
        PasswordTransformationMethod instance;
        EditText editText2 = this.f22060f;
        if (editText2 != null) {
            int selectionEnd = editText2.getSelectionEnd();
            if (w()) {
                editText = this.f22060f;
                instance = null;
            } else {
                editText = this.f22060f;
                instance = PasswordTransformationMethod.getInstance();
            }
            editText.setTransformationMethod(instance);
            if (selectionEnd >= 0) {
                this.f22060f.setSelection(selectionEnd);
            }
            r();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(CharSequence charSequence, int i2, int i3, int i4) {
        r();
    }

    /* access modifiers changed from: package-private */
    @StringRes
    public int c() {
        return R.string.X1;
    }

    /* access modifiers changed from: package-private */
    @DrawableRes
    public int d() {
        return this.f22059e;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return this.f22061g;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return !w();
    }

    /* access modifiers changed from: package-private */
    public void n(@Nullable EditText editText) {
        this.f22060f = editText;
        r();
    }

    /* access modifiers changed from: package-private */
    public void s() {
        if (x(this.f22060f)) {
            this.f22060f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* access modifiers changed from: package-private */
    public void u() {
        EditText editText = this.f22060f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
