package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.g;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.decoder.c;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi(23)
class AsynchronousMediaCodecBufferEnqueuer implements MediaCodecBufferEnqueuer {

    /* renamed from: g  reason: collision with root package name */
    private static final int f11642g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static final int f11643h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final int f11644i = 2;

    /* renamed from: j  reason: collision with root package name */
    private static final int f11645j = 3;
    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")

    /* renamed from: k  reason: collision with root package name */
    private static final ArrayDeque<MessageParams> f11646k = new ArrayDeque<>();

    /* renamed from: l  reason: collision with root package name */
    private static final Object f11647l = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f11648a;

    /* renamed from: b  reason: collision with root package name */
    private final HandlerThread f11649b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f11650c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<RuntimeException> f11651d;

    /* renamed from: e  reason: collision with root package name */
    private final ConditionVariable f11652e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11653f;

    private static class MessageParams {

        /* renamed from: a  reason: collision with root package name */
        public int f11655a;

        /* renamed from: b  reason: collision with root package name */
        public int f11656b;

        /* renamed from: c  reason: collision with root package name */
        public int f11657c;

        /* renamed from: d  reason: collision with root package name */
        public final MediaCodec.CryptoInfo f11658d = new MediaCodec.CryptoInfo();

        /* renamed from: e  reason: collision with root package name */
        public long f11659e;

        /* renamed from: f  reason: collision with root package name */
        public int f11660f;

        MessageParams() {
        }

        public void a(int i2, int i3, int i4, long j2, int i5) {
            this.f11655a = i2;
            this.f11656b = i3;
            this.f11657c = i4;
            this.f11659e = j2;
            this.f11660f = i5;
        }
    }

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new ConditionVariable());
    }

    private void g() throws InterruptedException {
        this.f11652e.d();
        ((Handler) Assertions.g(this.f11650c)).obtainMessage(2).sendToTarget();
        this.f11652e.a();
    }

    private static void h(CryptoInfo cryptoInfo, MediaCodec.CryptoInfo cryptoInfo2) {
        cryptoInfo2.numSubSamples = cryptoInfo.f10056f;
        cryptoInfo2.numBytesOfClearData = j(cryptoInfo.f10054d, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = j(cryptoInfo.f10055e, cryptoInfo2.numBytesOfEncryptedData);
        cryptoInfo2.key = (byte[]) Assertions.g(i(cryptoInfo.f10052b, cryptoInfo2.key));
        cryptoInfo2.iv = (byte[]) Assertions.g(i(cryptoInfo.f10051a, cryptoInfo2.iv));
        cryptoInfo2.mode = cryptoInfo.f10053c;
        if (Util.f9646a >= 24) {
            g.a();
            cryptoInfo2.setPattern(c.a(cryptoInfo.f10057g, cryptoInfo.f10058h));
        }
    }

    @Nullable
    private static byte[] i(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Nullable
    private static int[] j(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(android.os.Message r11) {
        /*
            r10 = this;
            int r0 = r11.what
            if (r0 == 0) goto L_0x0041
            r1 = 1
            if (r0 == r1) goto L_0x002d
            r1 = 2
            r2 = 0
            if (r0 == r1) goto L_0x0027
            r1 = 3
            if (r0 == r1) goto L_0x001f
            java.util.concurrent.atomic.AtomicReference<java.lang.RuntimeException> r0 = r10.f11651d
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            int r11 = r11.what
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r1.<init>(r11)
            androidx.lifecycle.g.a(r0, r2, r1)
            goto L_0x0054
        L_0x001f:
            java.lang.Object r11 = r11.obj
            android.os.Bundle r11 = (android.os.Bundle) r11
            r10.n(r11)
            goto L_0x0054
        L_0x0027:
            androidx.media3.common.util.ConditionVariable r11 = r10.f11652e
            r11.f()
            goto L_0x0054
        L_0x002d:
            java.lang.Object r11 = r11.obj
            r2 = r11
            androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r2 = (androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r2
            int r4 = r2.f11655a
            int r5 = r2.f11656b
            android.media.MediaCodec$CryptoInfo r6 = r2.f11658d
            long r7 = r2.f11659e
            int r9 = r2.f11660f
            r3 = r10
            r3.m(r4, r5, r6, r7, r9)
            goto L_0x0054
        L_0x0041:
            java.lang.Object r11 = r11.obj
            r2 = r11
            androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r2 = (androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r2
            int r4 = r2.f11655a
            int r5 = r2.f11656b
            int r6 = r2.f11657c
            long r7 = r2.f11659e
            int r9 = r2.f11660f
            r3 = r10
            r3.l(r4, r5, r6, r7, r9)
        L_0x0054:
            if (r2 == 0) goto L_0x0059
            q(r2)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer.k(android.os.Message):void");
    }

    private void l(int i2, int i3, int i4, long j2, int i5) {
        try {
            this.f11648a.queueInputBuffer(i2, i3, i4, j2, i5);
        } catch (RuntimeException e2) {
            g.a(this.f11651d, (Object) null, e2);
        }
    }

    private void m(int i2, int i3, MediaCodec.CryptoInfo cryptoInfo, long j2, int i4) {
        try {
            synchronized (f11647l) {
                this.f11648a.queueSecureInputBuffer(i2, i3, cryptoInfo, j2, i4);
            }
        } catch (RuntimeException e2) {
            g.a(this.f11651d, (Object) null, e2);
        }
    }

    private void n(Bundle bundle) {
        try {
            this.f11648a.setParameters(bundle);
        } catch (RuntimeException e2) {
            g.a(this.f11651d, (Object) null, e2);
        }
    }

    private void o() throws InterruptedException {
        ((Handler) Assertions.g(this.f11650c)).removeCallbacksAndMessages((Object) null);
        g();
    }

    private static MessageParams p() {
        ArrayDeque<MessageParams> arrayDeque = f11646k;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    MessageParams messageParams = new MessageParams();
                    return messageParams;
                }
                MessageParams removeFirst = arrayDeque.removeFirst();
                return removeFirst;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void q(MessageParams messageParams) {
        ArrayDeque<MessageParams> arrayDeque = f11646k;
        synchronized (arrayDeque) {
            arrayDeque.add(messageParams);
        }
    }

    public void a() {
        RuntimeException andSet = this.f11651d.getAndSet((Object) null);
        if (andSet != null) {
            throw andSet;
        }
    }

    public void b(Bundle bundle) {
        a();
        ((Handler) Util.o(this.f11650c)).obtainMessage(3, bundle).sendToTarget();
    }

    public void c() throws InterruptedException {
        g();
    }

    public void d(int i2, int i3, int i4, long j2, int i5) {
        a();
        MessageParams p = p();
        p.a(i2, i3, i4, j2, i5);
        ((Handler) Util.o(this.f11650c)).obtainMessage(0, p).sendToTarget();
    }

    public void e(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4) {
        a();
        MessageParams p = p();
        p.a(i2, i3, 0, j2, i4);
        h(cryptoInfo, p.f11658d);
        ((Handler) Util.o(this.f11650c)).obtainMessage(1, p).sendToTarget();
    }

    public void flush() {
        if (this.f11653f) {
            try {
                o();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting(otherwise = 5)
    public void r(RuntimeException runtimeException) {
        this.f11651d.set(runtimeException);
    }

    public void shutdown() {
        if (this.f11653f) {
            flush();
            this.f11649b.quit();
        }
        this.f11653f = false;
    }

    public void start() {
        if (!this.f11653f) {
            this.f11649b.start();
            this.f11650c = new Handler(this.f11649b.getLooper()) {
                public void handleMessage(Message message) {
                    AsynchronousMediaCodecBufferEnqueuer.this.k(message);
                }
            };
            this.f11653f = true;
        }
    }

    @VisibleForTesting
    AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread, ConditionVariable conditionVariable) {
        this.f11648a = mediaCodec;
        this.f11649b = handlerThread;
        this.f11652e = conditionVariable;
        this.f11651d = new AtomicReference<>();
    }
}
