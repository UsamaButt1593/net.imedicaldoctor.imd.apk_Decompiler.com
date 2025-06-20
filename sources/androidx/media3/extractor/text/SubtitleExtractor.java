package androidx.media3.extractor.text;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@UnstableApi
public class SubtitleExtractor implements Extractor {
    private static final int o = 0;
    private static final int p = 1;
    private static final int q = 2;
    private static final int r = 3;
    private static final int s = 4;
    private static final int t = 5;
    private static final int u = 1024;

    /* renamed from: d  reason: collision with root package name */
    private final SubtitleParser f13772d;

    /* renamed from: e  reason: collision with root package name */
    private final CueEncoder f13773e = new CueEncoder();

    /* renamed from: f  reason: collision with root package name */
    private final Format f13774f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Sample> f13775g;

    /* renamed from: h  reason: collision with root package name */
    private final ParsableByteArray f13776h = new ParsableByteArray();

    /* renamed from: i  reason: collision with root package name */
    private byte[] f13777i = Util.f9651f;

    /* renamed from: j  reason: collision with root package name */
    private TrackOutput f13778j;

    /* renamed from: k  reason: collision with root package name */
    private int f13779k;

    /* renamed from: l  reason: collision with root package name */
    private int f13780l;

    /* renamed from: m  reason: collision with root package name */
    private long[] f13781m;

    /* renamed from: n  reason: collision with root package name */
    private long f13782n;

    private static class Sample implements Comparable<Sample> {
        /* access modifiers changed from: private */
        public final byte[] X;
        /* access modifiers changed from: private */
        public final long s;

        private Sample(long j2, byte[] bArr) {
            this.s = j2;
            this.X = bArr;
        }

        /* renamed from: c */
        public int compareTo(Sample sample) {
            return Long.compare(this.s, sample.s);
        }
    }

    public SubtitleExtractor(SubtitleParser subtitleParser, Format format) {
        this.f13772d = subtitleParser;
        this.f13774f = format.c().k0(MimeTypes.O0).M(format.f3).Q(subtitleParser.d()).I();
        this.f13775g = new ArrayList();
        this.f13780l = 0;
        this.f13781m = Util.f9652g;
        this.f13782n = C.f9084b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(CuesWithTiming cuesWithTiming) {
        Sample sample = new Sample(cuesWithTiming.f13769b, this.f13773e.a(cuesWithTiming.f13768a, cuesWithTiming.f13770c));
        this.f13775g.add(sample);
        long j2 = this.f13782n;
        if (j2 == C.f9084b || cuesWithTiming.f13769b >= j2) {
            m(sample);
        }
    }

    private void g() throws IOException {
        try {
            long j2 = this.f13782n;
            this.f13772d.c(this.f13777i, j2 != C.f9084b ? SubtitleParser.OutputOptions.c(j2) : SubtitleParser.OutputOptions.b(), new c(this));
            Collections.sort(this.f13775g);
            this.f13781m = new long[this.f13775g.size()];
            for (int i2 = 0; i2 < this.f13775g.size(); i2++) {
                this.f13781m[i2] = this.f13775g.get(i2).s;
            }
            this.f13777i = Util.f9651f;
        } catch (RuntimeException e2) {
            throw ParserException.a("SubtitleParser failed.", e2);
        }
    }

    private boolean j(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = this.f13777i;
        if (bArr.length == this.f13779k) {
            this.f13777i = Arrays.copyOf(bArr, bArr.length + 1024);
        }
        byte[] bArr2 = this.f13777i;
        int i2 = this.f13779k;
        int read = extractorInput.read(bArr2, i2, bArr2.length - i2);
        if (read != -1) {
            this.f13779k += read;
        }
        long length = extractorInput.getLength();
        return (length != -1 && ((long) this.f13779k) == length) || read == -1;
    }

    private boolean k(ExtractorInput extractorInput) throws IOException {
        return extractorInput.b((extractorInput.getLength() > -1 ? 1 : (extractorInput.getLength() == -1 ? 0 : -1)) != 0 ? Ints.d(extractorInput.getLength()) : 1024) == -1;
    }

    private void l() {
        long j2 = this.f13782n;
        for (int n2 = j2 == C.f9084b ? 0 : Util.n(this.f13781m, j2, true, true); n2 < this.f13775g.size(); n2++) {
            m(this.f13775g.get(n2));
        }
    }

    private void m(Sample sample) {
        Assertions.k(this.f13778j);
        int length = sample.X.length;
        this.f13776h.V(sample.X);
        this.f13778j.d(this.f13776h, length);
        this.f13778j.f(sample.s, 1, length, 0, (TrackOutput.CryptoData) null);
    }

    public void a() {
        if (this.f13780l != 5) {
            this.f13772d.reset();
            this.f13780l = 5;
        }
    }

    public void c(long j2, long j3) {
        int i2 = this.f13780l;
        Assertions.i((i2 == 0 || i2 == 5) ? false : true);
        this.f13782n = j3;
        if (this.f13780l == 2) {
            this.f13780l = 1;
        }
        if (this.f13780l == 4) {
            this.f13780l = 3;
        }
    }

    public void d(ExtractorOutput extractorOutput) {
        Assertions.i(this.f13780l == 0);
        TrackOutput d2 = extractorOutput.d(0, 3);
        this.f13778j = d2;
        d2.e(this.f13774f);
        extractorOutput.o();
        extractorOutput.j(new IndexSeekMap(new long[]{0}, new long[]{0}, C.f9084b));
        this.f13780l = 1;
    }

    public /* synthetic */ Extractor e() {
        return d.a(this);
    }

    public boolean h(ExtractorInput extractorInput) throws IOException {
        return true;
    }

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2 = this.f13780l;
        Assertions.i((i2 == 0 || i2 == 5) ? false : true);
        if (this.f13780l == 1) {
            int d2 = extractorInput.getLength() != -1 ? Ints.d(extractorInput.getLength()) : 1024;
            if (d2 > this.f13777i.length) {
                this.f13777i = new byte[d2];
            }
            this.f13779k = 0;
            this.f13780l = 2;
        }
        if (this.f13780l == 2 && j(extractorInput)) {
            g();
            this.f13780l = 4;
        }
        if (this.f13780l == 3 && k(extractorInput)) {
            l();
            this.f13780l = 4;
        }
        return this.f13780l == 4 ? -1 : 0;
    }
}
