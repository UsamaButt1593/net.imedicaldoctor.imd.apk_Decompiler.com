package androidx.media3.exoplayer;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class DecoderCounters {

    /* renamed from: a  reason: collision with root package name */
    public int f10098a;

    /* renamed from: b  reason: collision with root package name */
    public int f10099b;

    /* renamed from: c  reason: collision with root package name */
    public int f10100c;

    /* renamed from: d  reason: collision with root package name */
    public int f10101d;

    /* renamed from: e  reason: collision with root package name */
    public int f10102e;

    /* renamed from: f  reason: collision with root package name */
    public int f10103f;

    /* renamed from: g  reason: collision with root package name */
    public int f10104g;

    /* renamed from: h  reason: collision with root package name */
    public int f10105h;

    /* renamed from: i  reason: collision with root package name */
    public int f10106i;

    /* renamed from: j  reason: collision with root package name */
    public int f10107j;

    /* renamed from: k  reason: collision with root package name */
    public long f10108k;

    /* renamed from: l  reason: collision with root package name */
    public int f10109l;

    private void b(long j2, int i2) {
        this.f10108k += j2;
        this.f10109l += i2;
    }

    public void a(long j2) {
        b(j2, 1);
    }

    public synchronized void c() {
    }

    public void d(DecoderCounters decoderCounters) {
        this.f10098a += decoderCounters.f10098a;
        this.f10099b += decoderCounters.f10099b;
        this.f10100c += decoderCounters.f10100c;
        this.f10101d += decoderCounters.f10101d;
        this.f10102e += decoderCounters.f10102e;
        this.f10103f += decoderCounters.f10103f;
        this.f10104g += decoderCounters.f10104g;
        this.f10105h += decoderCounters.f10105h;
        this.f10106i = Math.max(this.f10106i, decoderCounters.f10106i);
        this.f10107j += decoderCounters.f10107j;
        b(decoderCounters.f10108k, decoderCounters.f10109l);
    }

    public String toString() {
        return Util.S("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f10098a), Integer.valueOf(this.f10099b), Integer.valueOf(this.f10100c), Integer.valueOf(this.f10101d), Integer.valueOf(this.f10102e), Integer.valueOf(this.f10103f), Integer.valueOf(this.f10104g), Integer.valueOf(this.f10105h), Integer.valueOf(this.f10106i), Integer.valueOf(this.f10107j), Long.valueOf(this.f10108k), Integer.valueOf(this.f10109l));
    }
}
