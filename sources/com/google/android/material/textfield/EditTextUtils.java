package com.google.android.material.textfield;

import android.widget.EditText;
import androidx.annotation.NonNull;

class EditTextUtils {
    private EditTextUtils() {
    }

    static boolean a(@NonNull EditText editText) {
        return editText.getInputType() != 0;
    }
}
