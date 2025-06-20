package androidx.media3.extractor.ts;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class MpegAudioReader implements ElementaryStreamReader {

    /* renamed from: n  reason: collision with root package name */
    private static final int f14408n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 4;

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f14409a;

    /* renamed from: b  reason: collision with root package name */
    private final MpegAudioUtil.Header f14410b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f14411c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14412d;

    /* renamed from: e  reason: collision with root package name */
    private TrackOutput f14413e;

    /* renamed from: f  reason: collision with root package name */
    private String f14414f;

    /* renamed from: g  reason: collision with root package name */
    private int f14415g;

    /* renamed from: h  reason: collision with root package name */
    private int f14416h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14417i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14418j;

    /* renamed from: k  reason: collision with root package name */
    private long f14419k;

    /* renamed from: l  reason: collision with root package name */
    private int f14420l;

    /* renamed from: m  reason: collision with root package name */
    private long f14421m;

    public MpegAudioReader() {
        this((String) null, 0);
    }

    private void f(ParsableByteArray parsableByteArray) {
        byte[] e2 = parsableByteArray.e();
        int g2 = parsableByteArray.g();
        for (int f2 = parsableByteArray.f(); f2 < g2; f2++) {
            byte b2 = e2[f2];
            boolean z = (b2 & 255) == 255;
            boolean z2 = this.f14418j && (b2 & 224) == 224;
            this.f14418j = z;
            if (z2) {
                parsableByteArray.Y(f2 + 1);
                this.f14418j = false;
                this.f14409a.e()[1] = e2[f2];
                this.f14416h = 2;
                this.f14415g = 1;
                return;
            }
        }
        parsableByteArray.Y(g2);
    }

    @RequiresNonNull({"output"})
    private void g(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.a(), this.f14420l - this.f14416h);
        this.f14413e.d(parsableByteArray, min);
        int i2 = this.f14416h + min;
        this.f14416h = i2;
        if (i2 >= this.f14420l) {
            Assertions.i(this.f14421m != C.f9084b);
            this.f14413e.f(this.f14421m, 1, this.f14420l, 0, (TrackOutput.CryptoData) null);
            this.f14421m += this.f14419k;
            this.f14416h = 0;
            this.f14415g = 0;
        }
    }

    @RequiresNonNull({"output"})
    private void h(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.a(), 4 - this.f14416h);
        parsableByteArray.n(this.f14409a.e(), this.f14416h, min);
        int i2 = this.f14416h + min;
        this.f14416h = i2;
        if (i2 >= 4) {
            this.f14409a.Y(0);
            if (!this.f14410b.a(this.f14409a.s())) {
                this.f14416h = 0;
                this.f14415g = 1;
                return;
            }
            MpegAudioUtil.Header header = this.f14410b;
            this.f14420l = header.f13102c;
            if (!this.f14417i) {
                this.f14419k = (((long) header.f13106g) * 1000000) / ((long) header.f13103d);
                this.f14413e.e(new Format.Builder().X(this.f14414f).k0(this.f14410b.f13101b).c0(4096).L(this.f14410b.f13104e).l0(this.f14410b.f13103d).b0(this.f14411c).i0(this.f14412d).I());
                this.f14417i = true;
            }
            this.f14409a.Y(0);
            this.f14413e.d(this.f14409a, 4);
            this.f14415g = 2;
        }
    }

    public void a() {
        this.f14415g = 0;
        this.f14416h = 0;
        this.f14418j = false;
        this.f14421m = C.f9084b;
    }

    public void b(ParsableByteArray parsableByteArray) {
        Assertions.k(this.f14413e);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f14415g;
            if (i2 == 0) {
                f(parsableByteArray);
            } else if (i2 == 1) {
                h(parsableByteArray);
            } else if (i2 == 2) {
                g(parsableByteArray);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public void c() {
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f14414f = trackIdGenerator.b();
        this.f14413e = extractorOutput.d(trackIdGenerator.c(), 1);
    }

    public void e(long j2, int i2) {
        this.f14421m = j2;
    }

    public MpegAudioReader(@Nullable String str, int i2) {
        this.f14415g = 0;
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        this.f14409a = parsableByteArray;
        parsableByteArray.e()[0] = -1;
        this.f14410b = new MpegAudioUtil.Header();
        this.f14421m = C.f9084b;
        this.f14411c = str;
        this.f14412d = i2;
    }
}
