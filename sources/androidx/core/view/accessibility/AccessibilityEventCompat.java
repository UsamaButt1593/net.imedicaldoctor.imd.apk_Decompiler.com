package androidx.core.view.accessibility;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class AccessibilityEventCompat {
    public static final int A = 64;
    public static final int B = 128;
    public static final int C = 256;
    public static final int D = 512;
    public static final int E = 1024;
    public static final int F = 2048;
    public static final int G = 4096;
    public static final int H = -1;
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final int f6623a = 128;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final int f6624b = 256;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final int f6625c = 512;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final int f6626d = 1024;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final int f6627e = 2048;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final int f6628f = 4096;
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public static final int f6629g = 8192;

    /* renamed from: h  reason: collision with root package name */
    public static final int f6630h = 16384;

    /* renamed from: i  reason: collision with root package name */
    public static final int f6631i = 32768;

    /* renamed from: j  reason: collision with root package name */
    public static final int f6632j = 65536;

    /* renamed from: k  reason: collision with root package name */
    public static final int f6633k = 131072;

    /* renamed from: l  reason: collision with root package name */
    public static final int f6634l = 262144;

    /* renamed from: m  reason: collision with root package name */
    public static final int f6635m = 524288;

    /* renamed from: n  reason: collision with root package name */
    public static final int f6636n = 1048576;
    public static final int o = 2097152;
    public static final int p = 4194304;
    public static final int q = 8388608;
    public static final int r = 16777216;
    public static final int s = 67108864;
    public static final int t = 0;
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 4;
    public static final int x = 8;
    public static final int y = 16;
    public static final int z = 32;

    @RequiresApi(34)
    static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static boolean a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.isAccessibilityDataSensitive();
        }

        @DoNotInline
        static void b(AccessibilityEvent accessibilityEvent, boolean z) {
            accessibilityEvent.setAccessibilityDataSensitive(z);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ContentChangeType {
    }

    private AccessibilityEventCompat() {
    }

    @Deprecated
    public static void a(AccessibilityEvent accessibilityEvent, AccessibilityRecordCompat accessibilityRecordCompat) {
        accessibilityEvent.appendRecord((AccessibilityRecord) accessibilityRecordCompat.g());
    }

    @Deprecated
    public static AccessibilityRecordCompat b(AccessibilityEvent accessibilityEvent) {
        return new AccessibilityRecordCompat(accessibilityEvent);
    }

    public static int c(@NonNull AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getAction();
    }

    @SuppressLint({"WrongConstant"})
    public static int d(@NonNull AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static int e(@NonNull AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getMovementGranularity();
    }

    @Deprecated
    public static AccessibilityRecordCompat f(AccessibilityEvent accessibilityEvent, int i2) {
        return new AccessibilityRecordCompat(accessibilityEvent.getRecord(i2));
    }

    @Deprecated
    public static int g(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getRecordCount();
    }

    public static boolean h(@NonNull AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.a(accessibilityEvent);
        }
        return false;
    }

    public static void i(@NonNull AccessibilityEvent accessibilityEvent, boolean z2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.b(accessibilityEvent, z2);
        }
    }

    public static void j(@NonNull AccessibilityEvent accessibilityEvent, int i2) {
        accessibilityEvent.setAction(i2);
    }

    public static void k(@NonNull AccessibilityEvent accessibilityEvent, int i2) {
        accessibilityEvent.setContentChangeTypes(i2);
    }

    public static void l(@NonNull AccessibilityEvent accessibilityEvent, int i2) {
        accessibilityEvent.setMovementGranularity(i2);
    }
}
