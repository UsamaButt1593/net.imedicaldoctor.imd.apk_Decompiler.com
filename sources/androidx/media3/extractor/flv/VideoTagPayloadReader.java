package androidx.media3.extractor.flv;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.flv.TagPayloadReader;

final class VideoTagPayloadReader extends TagPayloadReader {

    /* renamed from: h  reason: collision with root package name */
    private static final int f13300h = 7;

    /* renamed from: i  reason: collision with root package name */
    private static final int f13301i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final int f13302j = 5;

    /* renamed from: k  reason: collision with root package name */
    private static final int f13303k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final int f13304l = 1;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f13305b = new ParsableByteArray(NalUnitUtil.f9675j);

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f13306c = new ParsableByteArray(4);

    /* renamed from: d  reason: collision with root package name */
    private int f13307d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13308e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13309f;

    /* renamed from: g  reason: collision with root package name */
    private int f13310g;

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    /* access modifiers changed from: protected */
    public boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        int L = parsableByteArray.L();
        int i2 = (L >> 4) & 15;
        int i3 = L & 15;
        if (i3 == 7) {
            this.f13310g = i2;
            return i2 != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i3);
    }

    /* access modifiers changed from: protected */
    public boolean c(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        int L = parsableByteArray.L();
        long t = j2 + (((long) parsableByteArray.t()) * 1000);
        if (L == 0 && !this.f13308e) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.a()]);
            parsableByteArray.n(parsableByteArray2.e(), 0, parsableByteArray.a());
            AvcConfig b2 = AvcConfig.b(parsableByteArray2);
            this.f13307d = b2.f12925b;
            this.f13299a.e(new Format.Builder().k0(MimeTypes.f9235j).M(b2.f12934k).r0(b2.f12926c).V(b2.f12927d).g0(b2.f12933j).Y(b2.f12924a).I());
            this.f13308e = true;
            return false;
        } else if (L != 1 || !this.f13308e) {
            return false;
        } else {
            int i2 = this.f13310g == 1 ? 1 : 0;
            if (!this.f13309f && i2 == 0) {
                return false;
            }
            byte[] e2 = this.f13306c.e();
            e2[0] = 0;
            e2[1] = 0;
            e2[2] = 0;
            int i3 = 4 - this.f13307d;
            int i4 = 0;
            while (parsableByteArray.a() > 0) {
                parsableByteArray.n(this.f13306c.e(), i3, this.f13307d);
                this.f13306c.Y(0);
                int P = this.f13306c.P();
                this.f13305b.Y(0);
                this.f13299a.d(this.f13305b, 4);
                this.f13299a.d(parsableByteArray, P);
                i4 = i4 + 4 + P;
            }
            this.f13299a.f(t, i2, i4, 0, (TrackOutput.CryptoData) null);
            this.f13309f = true;
            return true;
        }
    }

    public void d() {
        this.f13309f = false;
    }
}
