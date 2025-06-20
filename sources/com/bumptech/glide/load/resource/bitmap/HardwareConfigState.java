package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;

public final class HardwareConfigState {
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    static final int f18301f = 128;

    /* renamed from: g  reason: collision with root package name */
    private static final int f18302g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static final File f18303h = new File("/proc/self/fd");

    /* renamed from: i  reason: collision with root package name */
    private static final int f18304i = 50;

    /* renamed from: j  reason: collision with root package name */
    private static final int f18305j = 700;

    /* renamed from: k  reason: collision with root package name */
    private static final int f18306k = 20000;

    /* renamed from: l  reason: collision with root package name */
    private static volatile HardwareConfigState f18307l;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18308a = d();

    /* renamed from: b  reason: collision with root package name */
    private final int f18309b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18310c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private int f18311d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private boolean f18312e = true;

    @VisibleForTesting
    HardwareConfigState() {
        int i2;
        if (Build.VERSION.SDK_INT >= 28) {
            this.f18309b = 20000;
            i2 = 0;
        } else {
            this.f18309b = 700;
            i2 = 128;
        }
        this.f18310c = i2;
    }

    public static HardwareConfigState a() {
        if (f18307l == null) {
            synchronized (HardwareConfigState.class) {
                try {
                    if (f18307l == null) {
                        f18307l = new HardwareConfigState();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18307l;
    }

    private synchronized boolean b() {
        try {
            boolean z = true;
            int i2 = this.f18311d + 1;
            this.f18311d = i2;
            if (i2 >= 50) {
                this.f18311d = 0;
                int length = f18303h.list().length;
                if (length >= this.f18309b) {
                    z = false;
                }
                this.f18312e = z;
                if (!z && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.f18309b);
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f18312e;
    }

    private static boolean d() {
        String str = Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        String substring = str.substring(0, 7);
        substring.hashCode();
        char c2 = 65535;
        switch (substring.hashCode()) {
            case -1398613787:
                if (substring.equals("SM-A520")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1398431166:
                if (substring.equals("SM-G930")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1398431161:
                if (substring.equals("SM-G935")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1398431073:
                if (substring.equals("SM-G960")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1398431068:
                if (substring.equals("SM-G965")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1398343746:
                if (substring.equals("SM-J720")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1398222624:
                if (substring.equals("SM-N935")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return Build.VERSION.SDK_INT != 26;
            default:
                return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        r5 = r2.f18310c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(int r3, int r4, boolean r5, boolean r6) {
        /*
            r2 = this;
            r0 = 0
            if (r5 == 0) goto L_0x001d
            boolean r5 = r2.f18308a
            if (r5 == 0) goto L_0x001d
            int r5 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r5 < r1) goto L_0x001d
            if (r6 == 0) goto L_0x0010
            goto L_0x001d
        L_0x0010:
            int r5 = r2.f18310c
            if (r3 < r5) goto L_0x001d
            if (r4 < r5) goto L_0x001d
            boolean r3 = r2.b()
            if (r3 == 0) goto L_0x001d
            r0 = 1
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.HardwareConfigState.c(int, int, boolean, boolean):boolean");
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean e(int i2, int i3, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean c2 = c(i2, i3, z, z2);
        if (c2) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return c2;
    }
}
