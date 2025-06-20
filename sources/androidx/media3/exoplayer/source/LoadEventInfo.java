package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@UnstableApi
public final class LoadEventInfo {

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicLong f12141h = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    public final long f12142a;

    /* renamed from: b  reason: collision with root package name */
    public final DataSpec f12143b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f12144c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, List<String>> f12145d;

    /* renamed from: e  reason: collision with root package name */
    public final long f12146e;

    /* renamed from: f  reason: collision with root package name */
    public final long f12147f;

    /* renamed from: g  reason: collision with root package name */
    public final long f12148g;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LoadEventInfo(long r13, androidx.media3.datasource.DataSpec r15, long r16) {
        /*
            r12 = this;
            r3 = r15
            android.net.Uri r4 = r3.f9779a
            java.util.Map r5 = java.util.Collections.emptyMap()
            r8 = 0
            r10 = 0
            r0 = r12
            r1 = r13
            r6 = r16
            r0.<init>(r1, r3, r4, r5, r6, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.LoadEventInfo.<init>(long, androidx.media3.datasource.DataSpec, long):void");
    }

    public static long a() {
        return f12141h.getAndIncrement();
    }

    public LoadEventInfo(long j2, DataSpec dataSpec, Uri uri, Map<String, List<String>> map, long j3, long j4, long j5) {
        this.f12142a = j2;
        this.f12143b = dataSpec;
        this.f12144c = uri;
        this.f12145d = map;
        this.f12146e = j3;
        this.f12147f = j4;
        this.f12148g = j5;
    }
}
