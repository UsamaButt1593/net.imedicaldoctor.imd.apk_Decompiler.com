package androidx.media3.extractor.flv;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.flv.TagPayloadReader;
import java.util.Collections;

final class AudioTagPayloadReader extends TagPayloadReader {

    /* renamed from: e  reason: collision with root package name */
    private static final int f13265e = 2;

    /* renamed from: f  reason: collision with root package name */
    private static final int f13266f = 7;

    /* renamed from: g  reason: collision with root package name */
    private static final int f13267g = 8;

    /* renamed from: h  reason: collision with root package name */
    private static final int f13268h = 10;

    /* renamed from: i  reason: collision with root package name */
    private static final int f13269i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static final int f13270j = 1;

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f13271k = {5512, 11025, 22050, 44100};

    /* renamed from: b  reason: collision with root package name */
    private boolean f13272b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13273c;

    /* renamed from: d  reason: collision with root package name */
    private int f13274d;

    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    /* access modifiers changed from: protected */
    public boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        Format.Builder l0;
        if (!this.f13272b) {
            int L = parsableByteArray.L();
            int i2 = (L >> 4) & 15;
            this.f13274d = i2;
            if (i2 == 2) {
                l0 = new Format.Builder().k0(MimeTypes.I).L(1).l0(f13271k[(L >> 2) & 3]);
            } else if (i2 == 7 || i2 == 8) {
                l0 = new Format.Builder().k0(i2 == 7 ? MimeTypes.O : MimeTypes.P).L(1).l0(8000);
            } else {
                if (i2 != 10) {
                    throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f13274d);
                }
                this.f13272b = true;
            }
            this.f13299a.e(l0.I());
            this.f13273c = true;
            this.f13272b = true;
        } else {
            parsableByteArray.Z(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean c(ParsableByteArray parsableByteArray, long j2) throws ParserException {
        if (this.f13274d == 2) {
            int a2 = parsableByteArray.a();
            this.f13299a.d(parsableByteArray, a2);
            this.f13299a.f(j2, 1, a2, 0, (TrackOutput.CryptoData) null);
            return true;
        }
        int L = parsableByteArray.L();
        if (L == 0 && !this.f13273c) {
            int a3 = parsableByteArray.a();
            byte[] bArr = new byte[a3];
            parsableByteArray.n(bArr, 0, a3);
            AacUtil.Config f2 = AacUtil.f(bArr);
            this.f13299a.e(new Format.Builder().k0(MimeTypes.F).M(f2.f12887c).L(f2.f12886b).l0(f2.f12885a).Y(Collections.singletonList(bArr)).I());
            this.f13273c = true;
            return false;
        } else if (this.f13274d == 10 && L != 1) {
            return false;
        } else {
            int a4 = parsableByteArray.a();
            this.f13299a.d(parsableByteArray, a4);
            this.f13299a.f(j2, 1, a4, 0, (TrackOutput.CryptoData) null);
            return true;
        }
    }

    public void d() {
    }
}
