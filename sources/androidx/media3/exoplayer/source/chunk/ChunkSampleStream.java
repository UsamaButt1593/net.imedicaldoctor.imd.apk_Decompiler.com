package androidx.media3.exoplayer.source.chunk;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.chunk.ChunkSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    private static final String q3 = "ChunkSampleStream";
    /* access modifiers changed from: private */
    public final int[] X;
    private final T X2;
    /* access modifiers changed from: private */
    public final Format[] Y;
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> Y2;
    /* access modifiers changed from: private */
    public final boolean[] Z;
    /* access modifiers changed from: private */
    public final MediaSourceEventListener.EventDispatcher Z2;
    private final LoadErrorHandlingPolicy a3;
    private final Loader b3;
    private final ChunkHolder c3;
    private final ArrayList<BaseMediaChunk> d3;
    private final List<BaseMediaChunk> e3;
    private final SampleQueue f3;
    private final SampleQueue[] g3;
    private final BaseMediaChunkOutput h3;
    @Nullable
    private Chunk i3;
    private Format j3;
    @Nullable
    private ReleaseCallback<T> k3;
    private long l3;
    /* access modifiers changed from: private */
    public long m3;
    private int n3;
    /* access modifiers changed from: private */
    @Nullable
    public BaseMediaChunk o3;
    boolean p3;
    public final int s;

    public final class EmbeddedSampleStream implements SampleStream {
        private final SampleQueue X;
        private final int Y;
        private boolean Z;
        public final ChunkSampleStream<T> s;

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue, int i2) {
            this.s = chunkSampleStream;
            this.X = sampleQueue;
            this.Y = i2;
        }

        private void a() {
            if (!this.Z) {
                ChunkSampleStream.this.Z2.h(ChunkSampleStream.this.X[this.Y], ChunkSampleStream.this.Y[this.Y], 0, (Object) null, ChunkSampleStream.this.m3);
                this.Z = true;
            }
        }

        public void b() {
        }

        public void c() {
            Assertions.i(ChunkSampleStream.this.Z[this.Y]);
            ChunkSampleStream.this.Z[this.Y] = false;
        }

        public boolean d() {
            return !ChunkSampleStream.this.H() && this.X.N(ChunkSampleStream.this.p3);
        }

        public int j(long j2) {
            if (ChunkSampleStream.this.H()) {
                return 0;
            }
            int H = this.X.H(j2, ChunkSampleStream.this.p3);
            if (ChunkSampleStream.this.o3 != null) {
                H = Math.min(H, ChunkSampleStream.this.o3.i(this.Y + 1) - this.X.F());
            }
            this.X.h0(H);
            if (H > 0) {
                a();
            }
            return H;
        }

        public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            if (ChunkSampleStream.this.H()) {
                return -3;
            }
            if (ChunkSampleStream.this.o3 != null && ChunkSampleStream.this.o3.i(this.Y + 1) <= this.X.F()) {
                return -3;
            }
            a();
            return this.X.V(formatHolder, decoderInputBuffer, i2, ChunkSampleStream.this.p3);
        }
    }

    public interface ReleaseCallback<T extends ChunkSource> {
        void d(ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int i2, @Nullable int[] iArr, @Nullable Format[] formatArr, T t, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long j2, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2) {
        this.s = i2;
        int i4 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.X = iArr;
        this.Y = formatArr == null ? new Format[0] : formatArr;
        this.X2 = t;
        this.Y2 = callback;
        this.Z2 = eventDispatcher2;
        this.a3 = loadErrorHandlingPolicy;
        this.b3 = new Loader(q3);
        this.c3 = new ChunkHolder();
        ArrayList<BaseMediaChunk> arrayList = new ArrayList<>();
        this.d3 = arrayList;
        this.e3 = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.g3 = new SampleQueue[length];
        this.Z = new boolean[length];
        int i5 = length + 1;
        int[] iArr2 = new int[i5];
        SampleQueue[] sampleQueueArr = new SampleQueue[i5];
        SampleQueue l2 = SampleQueue.l(allocator, drmSessionManager, eventDispatcher);
        this.f3 = l2;
        iArr2[0] = i2;
        sampleQueueArr[0] = l2;
        while (i4 < length) {
            SampleQueue m2 = SampleQueue.m(allocator);
            this.g3[i4] = m2;
            int i6 = i4 + 1;
            sampleQueueArr[i6] = m2;
            iArr2[i6] = this.X[i4];
            i4 = i6;
        }
        this.h3 = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.l3 = j2;
        this.m3 = j2;
    }

    private void A(int i2) {
        int min = Math.min(O(i2, 0), this.n3);
        if (min > 0) {
            Util.Y1(this.d3, 0, min);
            this.n3 -= min;
        }
    }

    private void B(int i2) {
        Assertions.i(!this.b3.k());
        int size = this.d3.size();
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (!F(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            long j2 = E().f12285h;
            BaseMediaChunk C = C(i2);
            if (this.d3.isEmpty()) {
                this.l3 = this.m3;
            }
            this.p3 = false;
            this.Z2.C(this.s, C.f12284g, j2);
        }
    }

    private BaseMediaChunk C(int i2) {
        BaseMediaChunk baseMediaChunk = this.d3.get(i2);
        ArrayList<BaseMediaChunk> arrayList = this.d3;
        Util.Y1(arrayList, i2, arrayList.size());
        this.n3 = Math.max(this.n3, this.d3.size());
        SampleQueue sampleQueue = this.f3;
        int i4 = 0;
        while (true) {
            sampleQueue.w(baseMediaChunk.i(i4));
            SampleQueue[] sampleQueueArr = this.g3;
            if (i4 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            sampleQueue = sampleQueueArr[i4];
            i4++;
        }
    }

    private BaseMediaChunk E() {
        ArrayList<BaseMediaChunk> arrayList = this.d3;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean F(int i2) {
        int F;
        BaseMediaChunk baseMediaChunk = this.d3.get(i2);
        if (this.f3.F() > baseMediaChunk.i(0)) {
            return true;
        }
        int i4 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.g3;
            if (i4 >= sampleQueueArr.length) {
                return false;
            }
            F = sampleQueueArr[i4].F();
            i4++;
        } while (F <= baseMediaChunk.i(i4));
        return true;
    }

    private boolean G(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private void I() {
        int O = O(this.f3.F(), this.n3 - 1);
        while (true) {
            int i2 = this.n3;
            if (i2 <= O) {
                this.n3 = i2 + 1;
                J(i2);
            } else {
                return;
            }
        }
    }

    private void J(int i2) {
        BaseMediaChunk baseMediaChunk = this.d3.get(i2);
        Format format = baseMediaChunk.f12281d;
        if (!format.equals(this.j3)) {
            this.Z2.h(this.s, format, baseMediaChunk.f12282e, baseMediaChunk.f12283f, baseMediaChunk.f12284g);
        }
        this.j3 = format;
    }

    private int O(int i2, int i4) {
        do {
            i4++;
            if (i4 >= this.d3.size()) {
                return this.d3.size() - 1;
            }
        } while (this.d3.get(i4).i(0) <= i2);
        return i4 - 1;
    }

    private void R() {
        this.f3.Y();
        for (SampleQueue Y3 : this.g3) {
            Y3.Y();
        }
    }

    public T D() {
        return this.X2;
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        return this.l3 != C.f9084b;
    }

    /* renamed from: K */
    public void Z(Chunk chunk, long j2, long j4, boolean z) {
        Chunk chunk2 = chunk;
        this.i3 = null;
        this.o3 = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f12278a, chunk2.f12279b, chunk.f(), chunk.e(), j2, j4, chunk.b());
        this.a3.b(chunk2.f12278a);
        this.Z2.q(loadEventInfo, chunk2.f12280c, this.s, chunk2.f12281d, chunk2.f12282e, chunk2.f12283f, chunk2.f12284g, chunk2.f12285h);
        if (!z) {
            if (H()) {
                R();
            } else if (G(chunk)) {
                C(this.d3.size() - 1);
                if (this.d3.isEmpty()) {
                    this.l3 = this.m3;
                }
            }
            this.Y2.j(this);
        }
    }

    /* renamed from: L */
    public void N(Chunk chunk, long j2, long j4) {
        Chunk chunk2 = chunk;
        this.i3 = null;
        this.X2.d(chunk2);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f12278a, chunk2.f12279b, chunk.f(), chunk.e(), j2, j4, chunk.b());
        this.a3.b(chunk2.f12278a);
        this.Z2.t(loadEventInfo, chunk2.f12280c, this.s, chunk2.f12281d, chunk2.f12282e, chunk2.f12283f, chunk2.f12284g, chunk2.f12285h);
        this.Y2.j(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f1  */
    /* renamed from: M */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.upstream.Loader.LoadErrorAction p(androidx.media3.exoplayer.source.chunk.Chunk r31, long r32, long r34, java.io.IOException r36, int r37) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            long r12 = r31.b()
            boolean r14 = r30.G(r31)
            java.util.ArrayList<androidx.media3.exoplayer.source.chunk.BaseMediaChunk> r2 = r0.d3
            int r2 = r2.size()
            r15 = 1
            int r10 = r2 + -1
            r2 = 0
            r11 = 0
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0027
            if (r14 == 0) goto L_0x0027
            boolean r2 = r0.F(r10)
            if (r2 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r8 = 0
            goto L_0x0028
        L_0x0027:
            r8 = 1
        L_0x0028:
            androidx.media3.exoplayer.source.LoadEventInfo r9 = new androidx.media3.exoplayer.source.LoadEventInfo
            long r3 = r1.f12278a
            androidx.media3.datasource.DataSpec r5 = r1.f12279b
            android.net.Uri r6 = r31.f()
            java.util.Map r7 = r31.e()
            r2 = r9
            r15 = r8
            r17 = r14
            r14 = r9
            r8 = r32
            r29 = r10
            r10 = r34
            r2.<init>(r3, r5, r6, r7, r8, r10, r12)
            androidx.media3.exoplayer.source.MediaLoadData r2 = new androidx.media3.exoplayer.source.MediaLoadData
            int r3 = r1.f12280c
            int r4 = r0.s
            androidx.media3.common.Format r5 = r1.f12281d
            int r6 = r1.f12282e
            java.lang.Object r7 = r1.f12283f
            long r8 = r1.f12284g
            long r24 = androidx.media3.common.util.Util.H2(r8)
            long r8 = r1.f12285h
            long r26 = androidx.media3.common.util.Util.H2(r8)
            r18 = r2
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r18.<init>(r19, r20, r21, r22, r23, r24, r26)
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy$LoadErrorInfo r3 = new androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy$LoadErrorInfo
            r4 = r36
            r5 = r37
            r3.<init>(r14, r2, r4, r5)
            T r2 = r0.X2
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r5 = r0.a3
            boolean r2 = r2.g(r1, r15, r3, r5)
            if (r2 == 0) goto L_0x00a6
            if (r15 == 0) goto L_0x009f
            androidx.media3.exoplayer.upstream.Loader$LoadErrorAction r2 = androidx.media3.exoplayer.upstream.Loader.f12576k
            if (r17 == 0) goto L_0x00a7
            r6 = r29
            androidx.media3.exoplayer.source.chunk.BaseMediaChunk r6 = r0.C(r6)
            if (r6 != r1) goto L_0x008e
            r11 = 1
            goto L_0x008f
        L_0x008e:
            r11 = 0
        L_0x008f:
            androidx.media3.common.util.Assertions.i(r11)
            java.util.ArrayList<androidx.media3.exoplayer.source.chunk.BaseMediaChunk> r6 = r0.d3
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00a7
            long r6 = r0.m3
            r0.l3 = r6
            goto L_0x00a7
        L_0x009f:
            java.lang.String r2 = "ChunkSampleStream"
            java.lang.String r6 = "Ignoring attempt to cancel non-cancelable load."
            androidx.media3.common.util.Log.n(r2, r6)
        L_0x00a6:
            r2 = 0
        L_0x00a7:
            if (r2 != 0) goto L_0x00c0
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r2 = r0.a3
            long r2 = r2.a(r3)
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x00be
            r6 = 0
            androidx.media3.exoplayer.upstream.Loader$LoadErrorAction r2 = androidx.media3.exoplayer.upstream.Loader.i(r6, r2)
            goto L_0x00c0
        L_0x00be:
            androidx.media3.exoplayer.upstream.Loader$LoadErrorAction r2 = androidx.media3.exoplayer.upstream.Loader.f12577l
        L_0x00c0:
            boolean r3 = r2.c()
            r6 = 1
            r3 = r3 ^ r6
            androidx.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher r6 = r0.Z2
            int r7 = r1.f12280c
            int r8 = r0.s
            androidx.media3.common.Format r9 = r1.f12281d
            int r10 = r1.f12282e
            java.lang.Object r11 = r1.f12283f
            long r12 = r1.f12284g
            long r4 = r1.f12285h
            r16 = r6
            r17 = r14
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r11
            r23 = r12
            r25 = r4
            r27 = r36
            r28 = r3
            r16.v(r17, r18, r19, r20, r21, r22, r23, r25, r27, r28)
            if (r3 == 0) goto L_0x0100
            r3 = 0
            r0.i3 = r3
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r3 = r0.a3
            long r4 = r1.f12278a
            r3.b(r4)
            androidx.media3.exoplayer.source.SequenceableLoader$Callback<androidx.media3.exoplayer.source.chunk.ChunkSampleStream<T>> r1 = r0.Y2
            r1.j(r0)
        L_0x0100:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.chunk.ChunkSampleStream.p(androidx.media3.exoplayer.source.chunk.Chunk, long, long, java.io.IOException, int):androidx.media3.exoplayer.upstream.Loader$LoadErrorAction");
    }

    public void P() {
        Q((ReleaseCallback) null);
    }

    public void Q(@Nullable ReleaseCallback<T> releaseCallback) {
        this.k3 = releaseCallback;
        this.f3.U();
        for (SampleQueue U : this.g3) {
            U.U();
        }
        this.b3.m(this);
    }

    public void S(long j2) {
        BaseMediaChunk baseMediaChunk;
        boolean z;
        this.m3 = j2;
        if (H()) {
            this.l3 = j2;
            return;
        }
        int i2 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= this.d3.size()) {
                break;
            }
            baseMediaChunk = this.d3.get(i4);
            int i5 = (baseMediaChunk.f12284g > j2 ? 1 : (baseMediaChunk.f12284g == j2 ? 0 : -1));
            if (i5 == 0 && baseMediaChunk.f12259k == C.f9084b) {
                break;
            } else if (i5 > 0) {
                break;
            } else {
                i4++;
            }
        }
        baseMediaChunk = null;
        if (baseMediaChunk != null) {
            z = this.f3.b0(baseMediaChunk.i(0));
        } else {
            z = this.f3.c0(j2, j2 < e());
        }
        if (z) {
            this.n3 = O(this.f3.F(), 0);
            SampleQueue[] sampleQueueArr = this.g3;
            int length = sampleQueueArr.length;
            while (i2 < length) {
                sampleQueueArr[i2].c0(j2, true);
                i2++;
            }
            return;
        }
        this.l3 = j2;
        this.p3 = false;
        this.d3.clear();
        this.n3 = 0;
        if (this.b3.k()) {
            this.f3.s();
            SampleQueue[] sampleQueueArr2 = this.g3;
            int length2 = sampleQueueArr2.length;
            while (i2 < length2) {
                sampleQueueArr2[i2].s();
                i2++;
            }
            this.b3.g();
            return;
        }
        this.b3.h();
        R();
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream T(long j2, int i2) {
        for (int i4 = 0; i4 < this.g3.length; i4++) {
            if (this.X[i4] == i2) {
                Assertions.i(!this.Z[i4]);
                this.Z[i4] = true;
                this.g3[i4].c0(j2, true);
                return new EmbeddedSampleStream(this, this.g3[i4], i4);
            }
        }
        throw new IllegalStateException();
    }

    public boolean a(LoadingInfo loadingInfo) {
        List<BaseMediaChunk> list;
        long j2;
        if (this.p3 || this.b3.k() || this.b3.j()) {
            return false;
        }
        boolean H = H();
        if (H) {
            list = Collections.emptyList();
            j2 = this.l3;
        } else {
            list = this.e3;
            j2 = E().f12285h;
        }
        this.X2.e(loadingInfo, j2, list, this.c3);
        ChunkHolder chunkHolder = this.c3;
        boolean z = chunkHolder.f12288b;
        Chunk chunk = chunkHolder.f12287a;
        chunkHolder.a();
        if (z) {
            this.l3 = C.f9084b;
            this.p3 = true;
            return true;
        } else if (chunk == null) {
            return false;
        } else {
            this.i3 = chunk;
            if (G(chunk)) {
                BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                if (H) {
                    long j4 = baseMediaChunk.f12284g;
                    long j5 = this.l3;
                    if (j4 != j5) {
                        this.f3.e0(j5);
                        for (SampleQueue e0 : this.g3) {
                            e0.e0(this.l3);
                        }
                    }
                    this.l3 = C.f9084b;
                }
                baseMediaChunk.k(this.h3);
                this.d3.add(baseMediaChunk);
            } else if (chunk instanceof InitializationChunk) {
                ((InitializationChunk) chunk).g(this.h3);
            }
            this.Z2.z(new LoadEventInfo(chunk.f12278a, chunk.f12279b, this.b3.n(chunk, this, this.a3.c(chunk.f12280c))), chunk.f12280c, this.s, chunk.f12281d, chunk.f12282e, chunk.f12283f, chunk.f12284g, chunk.f12285h);
            return true;
        }
    }

    public void b() throws IOException {
        this.b3.b();
        this.f3.Q();
        if (!this.b3.k()) {
            this.X2.b();
        }
    }

    public boolean c() {
        return this.b3.k();
    }

    public boolean d() {
        return !H() && this.f3.N(this.p3);
    }

    public long e() {
        if (H()) {
            return this.l3;
        }
        if (this.p3) {
            return Long.MIN_VALUE;
        }
        return E().f12285h;
    }

    public long f(long j2, SeekParameters seekParameters) {
        return this.X2.f(j2, seekParameters);
    }

    public long g() {
        if (this.p3) {
            return Long.MIN_VALUE;
        }
        if (H()) {
            return this.l3;
        }
        long j2 = this.m3;
        BaseMediaChunk E = E();
        if (!E.h()) {
            if (this.d3.size() > 1) {
                ArrayList<BaseMediaChunk> arrayList = this.d3;
                E = arrayList.get(arrayList.size() - 2);
            } else {
                E = null;
            }
        }
        if (E != null) {
            j2 = Math.max(j2, E.f12285h);
        }
        return Math.max(j2, this.f3.C());
    }

    public void h(long j2) {
        if (!this.b3.j() && !H()) {
            if (this.b3.k()) {
                Chunk chunk = (Chunk) Assertions.g(this.i3);
                if ((!G(chunk) || !F(this.d3.size() - 1)) && this.X2.k(j2, chunk, this.e3)) {
                    this.b3.g();
                    if (G(chunk)) {
                        this.o3 = (BaseMediaChunk) chunk;
                        return;
                    }
                    return;
                }
                return;
            }
            int j4 = this.X2.j(j2, this.e3);
            if (j4 < this.d3.size()) {
                B(j4);
            }
        }
    }

    public void i() {
        this.f3.W();
        for (SampleQueue W : this.g3) {
            W.W();
        }
        this.X2.a();
        ReleaseCallback<T> releaseCallback = this.k3;
        if (releaseCallback != null) {
            releaseCallback.d(this);
        }
    }

    public int j(long j2) {
        if (H()) {
            return 0;
        }
        int H = this.f3.H(j2, this.p3);
        BaseMediaChunk baseMediaChunk = this.o3;
        if (baseMediaChunk != null) {
            H = Math.min(H, baseMediaChunk.i(0) - this.f3.F());
        }
        this.f3.h0(H);
        I();
        return H;
    }

    public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (H()) {
            return -3;
        }
        BaseMediaChunk baseMediaChunk = this.o3;
        if (baseMediaChunk != null && baseMediaChunk.i(0) <= this.f3.F()) {
            return -3;
        }
        I();
        return this.f3.V(formatHolder, decoderInputBuffer, i2, this.p3);
    }

    public void t(long j2, boolean z) {
        if (!H()) {
            int A = this.f3.A();
            this.f3.r(j2, z, true);
            int A2 = this.f3.A();
            if (A2 > A) {
                long B = this.f3.B();
                int i2 = 0;
                while (true) {
                    SampleQueue[] sampleQueueArr = this.g3;
                    if (i2 >= sampleQueueArr.length) {
                        break;
                    }
                    sampleQueueArr[i2].r(B, z, this.Z[i2]);
                    i2++;
                }
            }
            A(A2);
        }
    }
}
