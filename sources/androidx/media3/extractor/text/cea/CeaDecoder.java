package androidx.media3.extractor.text.cea;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

abstract class CeaDecoder implements SubtitleDecoder {

    /* renamed from: g  reason: collision with root package name */
    private static final int f13846g = 10;

    /* renamed from: h  reason: collision with root package name */
    private static final int f13847h = 2;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<CeaInputBuffer> f13848a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<SubtitleOutputBuffer> f13849b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityQueue<CeaInputBuffer> f13850c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private CeaInputBuffer f13851d;

    /* renamed from: e  reason: collision with root package name */
    private long f13852e;

    /* renamed from: f  reason: collision with root package name */
    private long f13853f;

    private static final class CeaInputBuffer extends SubtitleInputBuffer implements Comparable<CeaInputBuffer> {
        /* access modifiers changed from: private */
        public long g3;

        private CeaInputBuffer() {
        }

        /* renamed from: y */
        public int compareTo(CeaInputBuffer ceaInputBuffer) {
            if (l() != ceaInputBuffer.l()) {
                return l() ? 1 : -1;
            }
            long j2 = this.Y2 - ceaInputBuffer.Y2;
            if (j2 == 0) {
                j2 = this.g3 - ceaInputBuffer.g3;
                if (j2 == 0) {
                    return 0;
                }
            }
            return j2 > 0 ? 1 : -1;
        }
    }

    private static final class CeaOutputBuffer extends SubtitleOutputBuffer {
        private DecoderOutputBuffer.Owner<CeaOutputBuffer> Z2;

        public CeaOutputBuffer(DecoderOutputBuffer.Owner<CeaOutputBuffer> owner) {
            this.Z2 = owner;
        }

        public final void q() {
            this.Z2.a(this);
        }
    }

    public CeaDecoder() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.f13848a.add(new CeaInputBuffer());
        }
        this.f13849b = new ArrayDeque<>();
        for (int i3 = 0; i3 < 2; i3++) {
            this.f13849b.add(new CeaOutputBuffer(new b(this)));
        }
        this.f13850c = new PriorityQueue<>();
    }

    private void p(CeaInputBuffer ceaInputBuffer) {
        ceaInputBuffer.g();
        this.f13848a.add(ceaInputBuffer);
    }

    public void a() {
    }

    public final void d(long j2) {
    }

    public void e(long j2) {
        this.f13852e = j2;
    }

    public void flush() {
        this.f13853f = 0;
        this.f13852e = 0;
        while (!this.f13850c.isEmpty()) {
            p((CeaInputBuffer) Util.o(this.f13850c.poll()));
        }
        CeaInputBuffer ceaInputBuffer = this.f13851d;
        if (ceaInputBuffer != null) {
            p(ceaInputBuffer);
            this.f13851d = null;
        }
    }

    public abstract String getName();

    /* access modifiers changed from: protected */
    public abstract Subtitle h();

    /* access modifiers changed from: protected */
    public abstract void i(SubtitleInputBuffer subtitleInputBuffer);

    @Nullable
    /* renamed from: j */
    public SubtitleInputBuffer f() throws SubtitleDecoderException {
        Assertions.i(this.f13851d == null);
        if (this.f13848a.isEmpty()) {
            return null;
        }
        CeaInputBuffer pollFirst = this.f13848a.pollFirst();
        this.f13851d = pollFirst;
        return pollFirst;
    }

    @Nullable
    /* renamed from: k */
    public SubtitleOutputBuffer b() throws SubtitleDecoderException {
        SubtitleOutputBuffer subtitleOutputBuffer;
        if (this.f13849b.isEmpty()) {
            return null;
        }
        while (!this.f13850c.isEmpty() && ((CeaInputBuffer) Util.o(this.f13850c.peek())).Y2 <= this.f13852e) {
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) Util.o(this.f13850c.poll());
            if (ceaInputBuffer.l()) {
                subtitleOutputBuffer = (SubtitleOutputBuffer) Util.o(this.f13849b.pollFirst());
                subtitleOutputBuffer.f(4);
            } else {
                i(ceaInputBuffer);
                if (n()) {
                    Subtitle h2 = h();
                    subtitleOutputBuffer = (SubtitleOutputBuffer) Util.o(this.f13849b.pollFirst());
                    subtitleOutputBuffer.r(ceaInputBuffer.Y2, h2, Long.MAX_VALUE);
                } else {
                    p(ceaInputBuffer);
                }
            }
            p(ceaInputBuffer);
            return subtitleOutputBuffer;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final SubtitleOutputBuffer l() {
        return this.f13849b.pollFirst();
    }

    /* access modifiers changed from: protected */
    public final long m() {
        return this.f13852e;
    }

    /* access modifiers changed from: protected */
    public abstract boolean n();

    /* renamed from: o */
    public void c(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        Assertions.a(subtitleInputBuffer == this.f13851d);
        CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) subtitleInputBuffer;
        if (ceaInputBuffer.k()) {
            p(ceaInputBuffer);
        } else {
            long j2 = this.f13853f;
            this.f13853f = 1 + j2;
            long unused = ceaInputBuffer.g3 = j2;
            this.f13850c.add(ceaInputBuffer);
        }
        this.f13851d = null;
    }

    /* access modifiers changed from: protected */
    public void q(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.g();
        this.f13849b.add(subtitleOutputBuffer);
    }
}
