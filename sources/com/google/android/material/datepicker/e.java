package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

public final /* synthetic */ class e {
    public static /* synthetic */ void a(EditText[] editTextArr, View view, boolean z) {
        int length = editTextArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (!editTextArr[i2].hasFocus()) {
                i2++;
            } else {
                return;
            }
        }
        ViewUtils.r(view, false);
    }

    public static void c(@NonNull EditText... editTextArr) {
        if (editTextArr.length != 0) {
            c cVar = new c(editTextArr);
            for (EditText onFocusChangeListener : editTextArr) {
                onFocusChangeListener.setOnFocusChangeListener(cVar);
            }
            EditText editText = editTextArr[0];
            editText.postDelayed(new d(editText), 100);
        }
    }
}
