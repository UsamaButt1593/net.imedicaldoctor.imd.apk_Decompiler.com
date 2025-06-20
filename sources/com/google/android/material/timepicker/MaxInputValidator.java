package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

class MaxInputValidator implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private int f22080a;

    public MaxInputValidator(int i2) {
        this.f22080a = i2;
    }

    public int a() {
        return this.f22080a;
    }

    public void b(int i2) {
        this.f22080a = i2;
    }

    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i4, i5, charSequence.subSequence(i2, i3).toString());
            if (Integer.parseInt(sb.toString()) <= this.f22080a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
