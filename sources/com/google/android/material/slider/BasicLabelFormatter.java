package com.google.android.material.slider;

import androidx.annotation.NonNull;
import java.util.Locale;

public final class BasicLabelFormatter implements LabelFormatter {

    /* renamed from: e  reason: collision with root package name */
    private static final long f21930e = 1000000000000L;

    /* renamed from: f  reason: collision with root package name */
    private static final int f21931f = 1000000000;

    /* renamed from: g  reason: collision with root package name */
    private static final int f21932g = 1000000;

    /* renamed from: h  reason: collision with root package name */
    private static final int f21933h = 1000;

    @NonNull
    public String a(float f2) {
        if (f2 >= 1.0E12f) {
            return String.format(Locale.US, "%.1fT", new Object[]{Float.valueOf(f2 / 1.0E12f)});
        } else if (f2 >= 1.0E9f) {
            return String.format(Locale.US, "%.1fB", new Object[]{Float.valueOf(f2 / 1.0E9f)});
        } else if (f2 >= 1000000.0f) {
            return String.format(Locale.US, "%.1fM", new Object[]{Float.valueOf(f2 / 1000000.0f)});
        } else if (f2 >= 1000.0f) {
            return String.format(Locale.US, "%.1fK", new Object[]{Float.valueOf(f2 / 1000.0f)});
        } else {
            return String.format(Locale.US, "%.0f", new Object[]{Float.valueOf(f2)});
        }
    }
}
