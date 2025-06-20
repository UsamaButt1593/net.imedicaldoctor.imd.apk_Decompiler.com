package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

class TimePickerTextInputKeyController implements TextView.OnEditorActionListener, View.OnKeyListener {
    private final ChipTextInputComboView X;
    private final TimeModel Y;
    private boolean Z = false;
    private final ChipTextInputComboView s;

    TimePickerTextInputKeyController(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.s = chipTextInputComboView;
        this.X = chipTextInputComboView2;
        this.Y = timeModel;
    }

    private void b(EditText editText) {
        if (editText.getSelectionStart() == 0 && editText.length() == 2) {
            editText.getText().clear();
        }
    }

    private void c(int i2) {
        boolean z = false;
        this.X.setChecked(i2 == 12);
        ChipTextInputComboView chipTextInputComboView = this.s;
        if (i2 == 10) {
            z = true;
        }
        chipTextInputComboView.setChecked(z);
        this.Y.Y2 = i2;
    }

    private boolean d(int i2, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (i2 >= 7 && i2 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
            c(12);
            return true;
        }
        b(editText);
        return false;
    }

    private boolean e(int i2, KeyEvent keyEvent, EditText editText) {
        if (i2 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            c(10);
            return true;
        }
        b(editText);
        return false;
    }

    public void a() {
        TextInputLayout f2 = this.s.f();
        TextInputLayout f3 = this.X.f();
        EditText editText = f2.getEditText();
        EditText editText2 = f3.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        boolean z = i2 == 5;
        if (z) {
            c(12);
        }
        return z;
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (this.Z) {
            return false;
        }
        this.Z = true;
        EditText editText = (EditText) view;
        boolean e2 = this.Y.Y2 == 12 ? e(i2, keyEvent, editText) : d(i2, keyEvent, editText);
        this.Z = false;
        return e2;
    }
}
