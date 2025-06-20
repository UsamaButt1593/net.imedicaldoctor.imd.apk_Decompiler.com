package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.CircularIntArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.ArrayDeque;

@RequiresApi(23)
final class AsynchronousMediaCodecCallback extends MediaCodec.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final Object f11661a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final HandlerThread f11662b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f11663c;
    @GuardedBy("lock")

    /* renamed from: d  reason: collision with root package name */
    private final CircularIntArray f11664d;
    @GuardedBy("lock")

    /* renamed from: e  reason: collision with root package name */
    private final CircularIntArray f11665e;
    @GuardedBy("lock")

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<MediaCodec.BufferInfo> f11666f;
    @GuardedBy("lock")

    /* renamed from: g  reason: collision with root package name */
    private final ArrayDeque<MediaFormat> f11667g;
    @GuardedBy("lock")
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private MediaFormat f11668h;
    @GuardedBy("lock")
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private MediaFormat f11669i;
    @GuardedBy("lock")
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private MediaCodec.CodecException f11670j;
    @GuardedBy("lock")
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private MediaCodec.CryptoException f11671k;
    @GuardedBy("lock")

    /* renamed from: l  reason: collision with root package name */
    private long f11672l;
    @GuardedBy("lock")

    /* renamed from: m  reason: collision with root package name */
    private boolean f11673m;
    @GuardedBy("lock")
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private IllegalStateException f11674n;

    AsynchronousMediaCodecCallback(HandlerThread handlerThread) {
        this.f11662b = handlerThread;
        this.f11664d = new CircularIntArray();
        this.f11665e = new CircularIntArray();
        this.f11666f = new ArrayDeque<>();
        this.f11667g = new ArrayDeque<>();
    }

    @GuardedBy("lock")
    private void b(MediaFormat mediaFormat) {
        this.f11665e.b(-2);
        this.f11667g.add(mediaFormat);
    }

    @GuardedBy("lock")
    private void f() {
        if (!this.f11667g.isEmpty()) {
            this.f11669i = this.f11667g.getLast();
        }
        this.f11664d.c();
        this.f11665e.c();
        this.f11666f.clear();
        this.f11667g.clear();
    }

    @GuardedBy("lock")
    private boolean i() {
        return this.f11672l > 0 || this.f11673m;
    }

    @GuardedBy("lock")
    private void j() {
        k();
        m();
        l();
    }

    @GuardedBy("lock")
    private void k() {
        IllegalStateException illegalStateException = this.f11674n;
        if (illegalStateException != null) {
            this.f11674n = null;
            throw illegalStateException;
        }
    }

    @GuardedBy("lock")
    private void l() {
        MediaCodec.CryptoException cryptoException = this.f11671k;
        if (cryptoException != null) {
            this.f11671k = null;
            throw cryptoException;
        }
    }

    @GuardedBy("lock")
    private void m() {
        MediaCodec.CodecException codecException = this.f11670j;
        if (codecException != null) {
            this.f11670j = null;
            throw codecException;
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        synchronized (this.f11661a) {
            try {
                if (!this.f11673m) {
                    long j2 = this.f11672l - 1;
                    this.f11672l = j2;
                    if (j2 <= 0) {
                        if (j2 < 0) {
                            o(new IllegalStateException());
                        } else {
                            f();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void o(IllegalStateException illegalStateException) {
        synchronized (this.f11661a) {
            this.f11674n = illegalStateException;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int c() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f11661a
            monitor-enter(r0)
            r3.j()     // Catch:{ all -> 0x000f }
            boolean r1 = r3.i()     // Catch:{ all -> 0x000f }
            r2 = -1
            if (r1 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r2
        L_0x000f:
            r1 = move-exception
            goto L_0x0022
        L_0x0011:
            androidx.collection.CircularIntArray r1 = r3.f11664d     // Catch:{ all -> 0x000f }
            boolean r1 = r1.h()     // Catch:{ all -> 0x000f }
            if (r1 == 0) goto L_0x001a
            goto L_0x0020
        L_0x001a:
            androidx.collection.CircularIntArray r1 = r3.f11664d     // Catch:{ all -> 0x000f }
            int r2 = r1.i()     // Catch:{ all -> 0x000f }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r2
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecCallback.c():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int d(android.media.MediaCodec.BufferInfo r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f11661a
            monitor-enter(r0)
            r9.j()     // Catch:{ all -> 0x000f }
            boolean r1 = r9.i()     // Catch:{ all -> 0x000f }
            r2 = -1
            if (r1 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r2
        L_0x000f:
            r10 = move-exception
            goto L_0x004c
        L_0x0011:
            androidx.collection.CircularIntArray r1 = r9.f11665e     // Catch:{ all -> 0x000f }
            boolean r1 = r1.h()     // Catch:{ all -> 0x000f }
            if (r1 == 0) goto L_0x001b
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r2
        L_0x001b:
            androidx.collection.CircularIntArray r1 = r9.f11665e     // Catch:{ all -> 0x000f }
            int r1 = r1.i()     // Catch:{ all -> 0x000f }
            if (r1 < 0) goto L_0x003d
            android.media.MediaFormat r2 = r9.f11668h     // Catch:{ all -> 0x000f }
            androidx.media3.common.util.Assertions.k(r2)     // Catch:{ all -> 0x000f }
            java.util.ArrayDeque<android.media.MediaCodec$BufferInfo> r2 = r9.f11666f     // Catch:{ all -> 0x000f }
            java.lang.Object r2 = r2.remove()     // Catch:{ all -> 0x000f }
            android.media.MediaCodec$BufferInfo r2 = (android.media.MediaCodec.BufferInfo) r2     // Catch:{ all -> 0x000f }
            int r4 = r2.offset     // Catch:{ all -> 0x000f }
            int r5 = r2.size     // Catch:{ all -> 0x000f }
            long r6 = r2.presentationTimeUs     // Catch:{ all -> 0x000f }
            int r8 = r2.flags     // Catch:{ all -> 0x000f }
            r3 = r10
            r3.set(r4, r5, r6, r8)     // Catch:{ all -> 0x000f }
            goto L_0x004a
        L_0x003d:
            r10 = -2
            if (r1 != r10) goto L_0x004a
            java.util.ArrayDeque<android.media.MediaFormat> r10 = r9.f11667g     // Catch:{ all -> 0x000f }
            java.lang.Object r10 = r10.remove()     // Catch:{ all -> 0x000f }
            android.media.MediaFormat r10 = (android.media.MediaFormat) r10     // Catch:{ all -> 0x000f }
            r9.f11668h = r10     // Catch:{ all -> 0x000f }
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r1
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecCallback.d(android.media.MediaCodec$BufferInfo):int");
    }

    public void e() {
        synchronized (this.f11661a) {
            this.f11672l++;
            ((Handler) Util.o(this.f11663c)).post(new i(this));
        }
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f11661a) {
            try {
                mediaFormat = this.f11668h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        Assertions.i(this.f11663c == null);
        this.f11662b.start();
        Handler handler = new Handler(this.f11662b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f11663c = handler;
    }

    public void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f11661a) {
            this.f11671k = cryptoException;
        }
    }

    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f11661a) {
            this.f11670j = codecException;
        }
    }

    public void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
        synchronized (this.f11661a) {
            this.f11664d.b(i2);
        }
    }

    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f11661a) {
            try {
                MediaFormat mediaFormat = this.f11669i;
                if (mediaFormat != null) {
                    b(mediaFormat);
                    this.f11669i = null;
                }
                this.f11665e.b(i2);
                this.f11666f.add(bufferInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f11661a) {
            b(mediaFormat);
            this.f11669i = null;
        }
    }

    public void p() {
        synchronized (this.f11661a) {
            this.f11673m = true;
            this.f11662b.quit();
            f();
        }
    }
}
