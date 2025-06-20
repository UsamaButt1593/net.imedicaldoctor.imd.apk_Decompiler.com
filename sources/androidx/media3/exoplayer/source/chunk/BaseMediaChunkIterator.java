package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.UnstableApi;
import java.util.NoSuchElementException;

@UnstableApi
public abstract class BaseMediaChunkIterator implements MediaChunkIterator {

    /* renamed from: b  reason: collision with root package name */
    private final long f12263b;

    /* renamed from: c  reason: collision with root package name */
    private final long f12264c;

    /* renamed from: d  reason: collision with root package name */
    private long f12265d;

    public BaseMediaChunkIterator(long j2, long j3) {
        this.f12263b = j2;
        this.f12264c = j3;
        reset();
    }

    public boolean c() {
        return this.f12265d > this.f12264c;
    }

    /* access modifiers changed from: protected */
    public final void e() {
        long j2 = this.f12265d;
        if (j2 < this.f12263b || j2 > this.f12264c) {
            throw new NoSuchElementException();
        }
    }

    /* access modifiers changed from: protected */
    public final long f() {
        return this.f12265d;
    }

    public boolean next() {
        this.f12265d++;
        return !c();
    }

    public void reset() {
        this.f12265d = this.f12263b - 1;
    }
}
