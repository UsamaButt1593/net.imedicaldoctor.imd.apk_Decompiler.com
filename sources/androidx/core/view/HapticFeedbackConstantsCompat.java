package androidx.core.view;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class HapticFeedbackConstantsCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6390a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6391b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6392c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f6393d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f6394e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f6395f = 6;

    /* renamed from: g  reason: collision with root package name */
    public static final int f6396g = 3;

    /* renamed from: h  reason: collision with root package name */
    public static final int f6397h = 7;

    /* renamed from: i  reason: collision with root package name */
    public static final int f6398i = 8;

    /* renamed from: j  reason: collision with root package name */
    public static final int f6399j = 9;

    /* renamed from: k  reason: collision with root package name */
    public static final int f6400k = 12;

    /* renamed from: l  reason: collision with root package name */
    public static final int f6401l = 13;

    /* renamed from: m  reason: collision with root package name */
    public static final int f6402m = 16;

    /* renamed from: n  reason: collision with root package name */
    public static final int f6403n = 17;
    public static final int o = 21;
    public static final int p = 22;
    public static final int q = 23;
    public static final int r = 24;
    public static final int s = 25;
    public static final int t = 26;
    public static final int u = 27;
    @VisibleForTesting
    static final int v = 0;
    @VisibleForTesting
    static final int w = 27;
    public static final int x = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackFlags {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackType {
    }

    private HapticFeedbackConstantsCompat() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        if (r6 != 17) goto L_0x002f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0044 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int a(int r6) {
        /*
            r0 = -1
            if (r6 != r0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 34
            r3 = 4
            r4 = 0
            r5 = 6
            if (r1 >= r2) goto L_0x0016
            switch(r6) {
                case 21: goto L_0x0015;
                case 22: goto L_0x0013;
                case 23: goto L_0x0015;
                case 24: goto L_0x0013;
                case 25: goto L_0x0011;
                case 26: goto L_0x0015;
                case 27: goto L_0x0013;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0016
        L_0x0011:
            r6 = 0
            goto L_0x0016
        L_0x0013:
            r6 = 4
            goto L_0x0016
        L_0x0015:
            r6 = 6
        L_0x0016:
            r2 = 30
            if (r1 >= r2) goto L_0x002f
            r2 = 12
            if (r6 == r2) goto L_0x002d
            r2 = 13
            if (r6 == r2) goto L_0x002b
            r2 = 16
            if (r6 == r2) goto L_0x002d
            r2 = 17
            if (r6 == r2) goto L_0x0030
            goto L_0x002f
        L_0x002b:
            r4 = 6
            goto L_0x0030
        L_0x002d:
            r4 = 1
            goto L_0x0030
        L_0x002f:
            r4 = r6
        L_0x0030:
            r6 = 27
            if (r1 >= r6) goto L_0x003f
            r6 = 7
            if (r4 == r6) goto L_0x0040
            r6 = 8
            if (r4 == r6) goto L_0x0040
            r6 = 9
            if (r4 == r6) goto L_0x0040
        L_0x003f:
            r0 = r4
        L_0x0040:
            r6 = 23
            if (r1 >= r6) goto L_0x0046
            if (r0 == r5) goto L_0x0047
        L_0x0046:
            r3 = r0
        L_0x0047:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.HapticFeedbackConstantsCompat.a(int):int");
    }
}
