package androidx.media3.extractor.mp4;

import androidx.annotation.Nullable;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;

final class TrackFragment {

    /* renamed from: a  reason: collision with root package name */
    public DefaultSampleValues f13675a;

    /* renamed from: b  reason: collision with root package name */
    public long f13676b;

    /* renamed from: c  reason: collision with root package name */
    public long f13677c;

    /* renamed from: d  reason: collision with root package name */
    public long f13678d;

    /* renamed from: e  reason: collision with root package name */
    public int f13679e;

    /* renamed from: f  reason: collision with root package name */
    public int f13680f;

    /* renamed from: g  reason: collision with root package name */
    public long[] f13681g = new long[0];

    /* renamed from: h  reason: collision with root package name */
    public int[] f13682h = new int[0];

    /* renamed from: i  reason: collision with root package name */
    public int[] f13683i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    public long[] f13684j = new long[0];

    /* renamed from: k  reason: collision with root package name */
    public boolean[] f13685k = new boolean[0];

    /* renamed from: l  reason: collision with root package name */
    public boolean f13686l;

    /* renamed from: m  reason: collision with root package name */
    public boolean[] f13687m = new boolean[0];
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public TrackEncryptionBox f13688n;
    public final ParsableByteArray o = new ParsableByteArray();
    public boolean p;
    public long q;
    public boolean r;

    public void a(ParsableByteArray parsableByteArray) {
        parsableByteArray.n(this.o.e(), 0, this.o.g());
        this.o.Y(0);
        this.p = false;
    }

    public void b(ExtractorInput extractorInput) throws IOException {
        extractorInput.readFully(this.o.e(), 0, this.o.g());
        this.o.Y(0);
        this.p = false;
    }

    public long c(int i2) {
        return this.f13684j[i2];
    }

    public void d(int i2) {
        this.o.U(i2);
        this.f13686l = true;
        this.p = true;
    }

    public void e(int i2, int i3) {
        this.f13679e = i2;
        this.f13680f = i3;
        if (this.f13682h.length < i2) {
            this.f13681g = new long[i2];
            this.f13682h = new int[i2];
        }
        if (this.f13683i.length < i3) {
            int i4 = (i3 * 125) / 100;
            this.f13683i = new int[i4];
            this.f13684j = new long[i4];
            this.f13685k = new boolean[i4];
            this.f13687m = new boolean[i4];
        }
    }

    public void f() {
        this.f13679e = 0;
        this.q = 0;
        this.r = false;
        this.f13686l = false;
        this.p = false;
        this.f13688n = null;
    }

    public boolean g(int i2) {
        return this.f13686l && this.f13687m[i2];
    }
}
