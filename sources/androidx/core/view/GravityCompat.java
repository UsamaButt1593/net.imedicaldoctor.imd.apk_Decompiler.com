package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;

public final class GravityCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6386a = 8388608;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6387b = 8388611;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6388c = 8388613;

    /* renamed from: d  reason: collision with root package name */
    public static final int f6389d = 8388615;

    private GravityCompat() {
    }

    public static void a(int i2, int i3, int i4, @NonNull Rect rect, int i5, int i6, @NonNull Rect rect2, int i7) {
        Gravity.apply(i2, i3, i4, rect, i5, i6, rect2, i7);
    }

    public static void b(int i2, int i3, int i4, @NonNull Rect rect, @NonNull Rect rect2, int i5) {
        Gravity.apply(i2, i3, i4, rect, rect2, i5);
    }

    public static void c(int i2, @NonNull Rect rect, @NonNull Rect rect2, int i3) {
        Gravity.applyDisplay(i2, rect, rect2, i3);
    }

    public static int d(int i2, int i3) {
        return Gravity.getAbsoluteGravity(i2, i3);
    }
}
