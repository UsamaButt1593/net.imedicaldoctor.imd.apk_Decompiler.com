package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {

    /* renamed from: g  reason: collision with root package name */
    public static final int f9017g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f9018h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static final int f9019i = 2;

    /* renamed from: a  reason: collision with root package name */
    private final int f9020a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9021b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9022c;

    /* renamed from: d  reason: collision with root package name */
    private int f9023d;

    /* renamed from: e  reason: collision with root package name */
    private Callback f9024e;

    /* renamed from: f  reason: collision with root package name */
    private VolumeProvider f9025f;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void a(VolumeProvider volumeProvider, int i2) {
            volumeProvider.setCurrentVolume(i2);
        }
    }

    public static abstract class Callback {
        public abstract void a(VolumeProviderCompat volumeProviderCompat);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i2, int i3, int i4) {
        this(i2, i3, i4, (String) null);
    }

    public final int a() {
        return this.f9023d;
    }

    public final int b() {
        return this.f9021b;
    }

    public final int c() {
        return this.f9020a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final String d() {
        return this.f9022c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: androidx.media.VolumeProviderCompat$2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: androidx.media.VolumeProviderCompat$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: androidx.media.VolumeProviderCompat$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.media.VolumeProviderCompat$1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object e() {
        /*
            r8 = this;
            android.media.VolumeProvider r0 = r8.f9025f
            if (r0 != 0) goto L_0x0028
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L_0x001c
            androidx.media.VolumeProviderCompat$1 r0 = new androidx.media.VolumeProviderCompat$1
            int r4 = r8.f9020a
            int r5 = r8.f9021b
            int r6 = r8.f9023d
            java.lang.String r7 = r8.f9022c
            r2 = r0
            r3 = r8
            r2.<init>(r4, r5, r6, r7)
        L_0x0019:
            r8.f9025f = r0
            goto L_0x0028
        L_0x001c:
            androidx.media.VolumeProviderCompat$2 r0 = new androidx.media.VolumeProviderCompat$2
            int r1 = r8.f9020a
            int r2 = r8.f9021b
            int r3 = r8.f9023d
            r0.<init>(r1, r2, r3)
            goto L_0x0019
        L_0x0028:
            android.media.VolumeProvider r0 = r8.f9025f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media.VolumeProviderCompat.e():java.lang.Object");
    }

    public void f(int i2) {
    }

    public void g(int i2) {
    }

    public void h(Callback callback) {
        this.f9024e = callback;
    }

    public final void i(int i2) {
        this.f9023d = i2;
        Api21Impl.a((VolumeProvider) e(), i2);
        Callback callback = this.f9024e;
        if (callback != null) {
            callback.a(this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public VolumeProviderCompat(int i2, int i3, int i4, @Nullable String str) {
        this.f9020a = i2;
        this.f9021b = i3;
        this.f9023d = i4;
        this.f9022c = str;
    }
}
