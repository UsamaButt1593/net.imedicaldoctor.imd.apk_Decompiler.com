package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class MediaLoadData {

    /* renamed from: a  reason: collision with root package name */
    public final int f12149a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12150b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Format f12151c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12152d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Object f12153e;

    /* renamed from: f  reason: collision with root package name */
    public final long f12154f;

    /* renamed from: g  reason: collision with root package name */
    public final long f12155g;

    public MediaLoadData(int i2) {
        this(i2, -1, (Format) null, 0, (Object) null, C.f9084b, C.f9084b);
    }

    public MediaLoadData(int i2, int i3, @Nullable Format format, int i4, @Nullable Object obj, long j2, long j3) {
        this.f12149a = i2;
        this.f12150b = i3;
        this.f12151c = format;
        this.f12152d = i4;
        this.f12153e = obj;
        this.f12154f = j2;
        this.f12155g = j3;
    }
}
