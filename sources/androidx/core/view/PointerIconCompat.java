package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

public final class PointerIconCompat {

    /* renamed from: b  reason: collision with root package name */
    public static final int f6462b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6463c = 1000;

    /* renamed from: d  reason: collision with root package name */
    public static final int f6464d = 1001;

    /* renamed from: e  reason: collision with root package name */
    public static final int f6465e = 1002;

    /* renamed from: f  reason: collision with root package name */
    public static final int f6466f = 1003;

    /* renamed from: g  reason: collision with root package name */
    public static final int f6467g = 1004;

    /* renamed from: h  reason: collision with root package name */
    public static final int f6468h = 1006;

    /* renamed from: i  reason: collision with root package name */
    public static final int f6469i = 1007;

    /* renamed from: j  reason: collision with root package name */
    public static final int f6470j = 1008;

    /* renamed from: k  reason: collision with root package name */
    public static final int f6471k = 1009;

    /* renamed from: l  reason: collision with root package name */
    public static final int f6472l = 1010;

    /* renamed from: m  reason: collision with root package name */
    public static final int f6473m = 1011;

    /* renamed from: n  reason: collision with root package name */
    public static final int f6474n = 1012;
    public static final int o = 1013;
    public static final int p = 1014;
    public static final int q = 1015;
    public static final int r = 1016;
    public static final int s = 1017;
    public static final int t = 1018;
    public static final int u = 1019;
    public static final int v = 1020;
    public static final int w = 1021;
    public static final int x = 1000;

    /* renamed from: a  reason: collision with root package name */
    private final PointerIcon f6475a;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static PointerIcon a(Bitmap bitmap, float f2, float f3) {
            return PointerIcon.create(bitmap, f2, f3);
        }

        @DoNotInline
        static PointerIcon b(Context context, int i2) {
            return PointerIcon.getSystemIcon(context, i2);
        }

        @DoNotInline
        static PointerIcon c(Resources resources, int i2) {
            return PointerIcon.load(resources, i2);
        }
    }

    private PointerIconCompat(PointerIcon pointerIcon) {
        this.f6475a = pointerIcon;
    }

    @NonNull
    public static PointerIconCompat a(@NonNull Bitmap bitmap, float f2, float f3) {
        return Build.VERSION.SDK_INT >= 24 ? new PointerIconCompat(Api24Impl.a(bitmap, f2, f3)) : new PointerIconCompat((PointerIcon) null);
    }

    @NonNull
    public static PointerIconCompat c(@NonNull Context context, int i2) {
        return Build.VERSION.SDK_INT >= 24 ? new PointerIconCompat(Api24Impl.b(context, i2)) : new PointerIconCompat((PointerIcon) null);
    }

    @NonNull
    public static PointerIconCompat d(@NonNull Resources resources, int i2) {
        return Build.VERSION.SDK_INT >= 24 ? new PointerIconCompat(Api24Impl.c(resources, i2)) : new PointerIconCompat((PointerIcon) null);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Object b() {
        return this.f6475a;
    }
}
