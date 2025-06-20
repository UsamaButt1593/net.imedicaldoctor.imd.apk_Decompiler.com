package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

public final class AccessibilityClickableSpanCompat extends ClickableSpan {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

    /* renamed from: d  reason: collision with root package name */
    public static final String f6619d = "ACCESSIBILITY_CLICKABLE_SPAN_ID";

    /* renamed from: a  reason: collision with root package name */
    private final int f6620a;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityNodeInfoCompat f6621b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6622c;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityClickableSpanCompat(int i2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i3) {
        this.f6620a = i2;
        this.f6621b = accessibilityNodeInfoCompat;
        this.f6622c = i3;
    }

    public void onClick(@NonNull View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(f6619d, this.f6620a);
        this.f6621b.S0(this.f6622c, bundle);
    }
}
