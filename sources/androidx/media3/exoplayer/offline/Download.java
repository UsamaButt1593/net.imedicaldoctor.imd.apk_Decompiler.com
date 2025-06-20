package androidx.media3.exoplayer.offline;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class Download {

    /* renamed from: i  reason: collision with root package name */
    public static final int f11756i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f11757j = 1;

    /* renamed from: k  reason: collision with root package name */
    public static final int f11758k = 2;

    /* renamed from: l  reason: collision with root package name */
    public static final int f11759l = 3;

    /* renamed from: m  reason: collision with root package name */
    public static final int f11760m = 4;

    /* renamed from: n  reason: collision with root package name */
    public static final int f11761n = 5;
    public static final int o = 7;
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 0;

    /* renamed from: a  reason: collision with root package name */
    public final DownloadRequest f11762a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11763b;

    /* renamed from: c  reason: collision with root package name */
    public final long f11764c;

    /* renamed from: d  reason: collision with root package name */
    public final long f11765d;

    /* renamed from: e  reason: collision with root package name */
    public final long f11766e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11767f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11768g;

    /* renamed from: h  reason: collision with root package name */
    final DownloadProgress f11769h;

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FailureReason {
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public Download(DownloadRequest downloadRequest, int i2, long j2, long j3, long j4, int i3, int i4) {
        this(downloadRequest, i2, j2, j3, j4, i3, i4, new DownloadProgress());
    }

    public long a() {
        return this.f11769h.f11818a;
    }

    public float b() {
        return this.f11769h.f11819b;
    }

    public boolean c() {
        int i2 = this.f11763b;
        return i2 == 3 || i2 == 4;
    }

    public Download(DownloadRequest downloadRequest, int i2, long j2, long j3, long j4, int i3, int i4, DownloadProgress downloadProgress) {
        Assertions.g(downloadProgress);
        boolean z = false;
        Assertions.a((i4 == 0) == (i2 != 4));
        if (i3 != 0) {
            if (!(i2 == 2 || i2 == 0)) {
                z = true;
            }
            Assertions.a(z);
        }
        this.f11762a = downloadRequest;
        this.f11763b = i2;
        this.f11764c = j2;
        this.f11765d = j3;
        this.f11766e = j4;
        this.f11767f = i3;
        this.f11768g = i4;
        this.f11769h = downloadProgress;
    }
}
