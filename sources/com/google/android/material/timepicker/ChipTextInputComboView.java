package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

class ChipTextInputComboView extends FrameLayout implements Checkable {
    private final TextInputLayout X2;
    private final EditText Y2;
    private TextWatcher Z2;
    private TextView a3;
    /* access modifiers changed from: private */
    public final Chip s;

    private class TextFormatter extends TextWatcherAdapter {
        private static final String X = "00";

        private TextFormatter() {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.s.setText(ChipTextInputComboView.this.d(X));
                return;
            }
            String a2 = ChipTextInputComboView.this.d(editable);
            Chip b2 = ChipTextInputComboView.this.s;
            if (TextUtils.isEmpty(a2)) {
                a2 = ChipTextInputComboView.this.d(X);
            }
            b2.setText(a2);
        }
    }

    public ChipTextInputComboView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public String d(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.Y2.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.Y2.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.Y2.setFilters(inputFilterArr);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public CharSequence e() {
        return this.s.getText();
    }

    public TextInputLayout f() {
        return this.X2;
    }

    public void g(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.H1(this.s, accessibilityDelegateCompat);
    }

    public void h(boolean z) {
        this.Y2.setCursorVisible(z);
    }

    public void i(CharSequence charSequence) {
        this.a3.setText(charSequence);
    }

    public boolean isChecked() {
        return this.s.isChecked();
    }

    public void j(CharSequence charSequence) {
        String d2 = d(charSequence);
        this.s.setText(d2);
        if (!TextUtils.isEmpty(d2)) {
            this.Y2.removeTextChangedListener(this.Z2);
            this.Y2.setText(d2);
            this.Y2.addTextChangedListener(this.Z2);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        k();
    }

    public void setChecked(boolean z) {
        this.s.setChecked(z);
        this.Y2.setVisibility(z ? 0 : 4);
        this.s.setVisibility(z ? 8 : 0);
        if (isChecked()) {
            ViewUtils.z(this.Y2, false);
        }
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.s.setOnClickListener(onClickListener);
    }

    public void setTag(int i2, Object obj) {
        this.s.setTag(i2, obj);
    }

    public void toggle() {
        this.s.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.i0, this, false);
        this.s = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.j0, this, false);
        this.X2 = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.Y2 = editText;
        editText.setVisibility(4);
        TextFormatter textFormatter = new TextFormatter();
        this.Z2 = textFormatter;
        editText.addTextChangedListener(textFormatter);
        k();
        addView(chip);
        addView(textInputLayout);
        this.a3 = (TextView) findViewById(R.id.L2);
        editText.setId(ViewCompat.D());
        ViewCompat.e2(this.a3, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
