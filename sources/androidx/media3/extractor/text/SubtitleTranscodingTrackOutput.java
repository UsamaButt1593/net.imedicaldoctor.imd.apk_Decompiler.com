package androidx.media3.extractor.text;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.g;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.EOFException;
import java.io.IOException;

final class SubtitleTranscodingTrackOutput implements TrackOutput {

    /* renamed from: d  reason: collision with root package name */
    private final TrackOutput f13790d;

    /* renamed from: e  reason: collision with root package name */
    private final SubtitleParser.Factory f13791e;

    /* renamed from: f  reason: collision with root package name */
    private final CueEncoder f13792f = new CueEncoder();

    /* renamed from: g  reason: collision with root package name */
    private final ParsableByteArray f13793g = new ParsableByteArray();

    /* renamed from: h  reason: collision with root package name */
    private int f13794h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f13795i = 0;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f13796j = Util.f9651f;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private SubtitleParser f13797k;

    /* renamed from: l  reason: collision with root package name */
    private Format f13798l;

    public SubtitleTranscodingTrackOutput(TrackOutput trackOutput, SubtitleParser.Factory factory) {
        this.f13790d = trackOutput;
        this.f13791e = factory;
    }

    private void h(int i2) {
        int length = this.f13796j.length;
        int i3 = this.f13795i;
        if (length - i3 < i2) {
            int i4 = i3 - this.f13794h;
            int max = Math.max(i4 * 2, i2 + i4);
            byte[] bArr = this.f13796j;
            byte[] bArr2 = max <= bArr.length ? bArr : new byte[max];
            System.arraycopy(bArr, this.f13794h, bArr2, 0, i4);
            this.f13794h = 0;
            this.f13795i = i4;
            this.f13796j = bArr2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void i(CuesWithTiming cuesWithTiming, long j2, int i2) {
        Assertions.k(this.f13798l);
        byte[] a2 = this.f13792f.a(cuesWithTiming.f13768a, cuesWithTiming.f13770c);
        this.f13793g.V(a2);
        this.f13790d.d(this.f13793g, a2.length);
        int i3 = i2 & Integer.MAX_VALUE;
        long j3 = cuesWithTiming.f13769b;
        if (j3 == C.f9084b) {
            Assertions.i(this.f13798l.j3 == Long.MAX_VALUE);
        } else {
            long j4 = this.f13798l.j3;
            j2 = j4 == Long.MAX_VALUE ? j2 + j3 : j3 + j4;
        }
        this.f13790d.f(j2, i3, a2.length, 0, (TrackOutput.CryptoData) null);
    }

    public void a(ParsableByteArray parsableByteArray, int i2, int i3) {
        if (this.f13797k == null) {
            this.f13790d.a(parsableByteArray, i2, i3);
            return;
        }
        h(i2);
        parsableByteArray.n(this.f13796j, this.f13795i, i2);
        this.f13795i += i2;
    }

    public /* synthetic */ int b(DataReader dataReader, int i2, boolean z) {
        return g.a(this, dataReader, i2, z);
    }

    public int c(DataReader dataReader, int i2, boolean z, int i3) throws IOException {
        if (this.f13797k == null) {
            return this.f13790d.c(dataReader, i2, z, i3);
        }
        h(i2);
        int read = dataReader.read(this.f13796j, this.f13795i, i2);
        if (read != -1) {
            this.f13795i += read;
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public /* synthetic */ void d(ParsableByteArray parsableByteArray, int i2) {
        g.b(this, parsableByteArray, i2);
    }

    public void e(Format format) {
        TrackOutput trackOutput;
        Assertions.g(format.f3);
        Assertions.a(MimeTypes.l(format.f3) == 3);
        if (!format.equals(this.f13798l)) {
            this.f13798l = format;
            this.f13797k = this.f13791e.b(format) ? this.f13791e.c(format) : null;
        }
        if (this.f13797k == null) {
            trackOutput = this.f13790d;
        } else {
            trackOutput = this.f13790d;
            format = format.c().k0(MimeTypes.O0).M(format.f3).o0(Long.MAX_VALUE).Q(this.f13791e.a(format)).I();
        }
        trackOutput.e(format);
    }

    public void f(long j2, int i2, int i3, int i4, @Nullable TrackOutput.CryptoData cryptoData) {
        if (this.f13797k == null) {
            this.f13790d.f(j2, i2, i3, i4, cryptoData);
            return;
        }
        Assertions.b(cryptoData == null, "DRM on subtitles is not supported");
        int i5 = (this.f13795i - i4) - i3;
        this.f13797k.a(this.f13796j, i5, i3, SubtitleParser.OutputOptions.b(), new f(this, j2, i2));
        int i6 = i5 + i3;
        this.f13794h = i6;
        if (i6 == this.f13795i) {
            this.f13794h = 0;
            this.f13795i = 0;
        }
    }

    public void k() {
        SubtitleParser subtitleParser = this.f13797k;
        if (subtitleParser != null) {
            subtitleParser.reset();
        }
    }
}
