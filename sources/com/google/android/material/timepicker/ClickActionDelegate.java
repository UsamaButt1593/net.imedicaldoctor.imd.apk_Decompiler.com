package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class ClickActionDelegate extends AccessibilityDelegateCompat {

    /* renamed from: d  reason: collision with root package name */
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat f22069d;

    public ClickActionDelegate(Context context, int i2) {
        this.f22069d = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, context.getString(i2));
    }

    public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.g(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.b(this.f22069d);
    }
}
