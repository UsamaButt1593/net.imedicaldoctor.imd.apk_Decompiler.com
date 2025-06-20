package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;

@UnstableApi
public final class TrueHdSampleRechunker {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f13139a = new byte[10];

    /* renamed from: b  reason: collision with root package name */
    private boolean f13140b;

    /* renamed from: c  reason: collision with root package name */
    private int f13141c;

    /* renamed from: d  reason: collision with root package name */
    private long f13142d;

    /* renamed from: e  reason: collision with root package name */
    private int f13143e;

    /* renamed from: f  reason: collision with root package name */
    private int f13144f;

    /* renamed from: g  reason: collision with root package name */
    private int f13145g;

    public void a(TrackOutput trackOutput, @Nullable TrackOutput.CryptoData cryptoData) {
        if (this.f13141c > 0) {
            trackOutput.f(this.f13142d, this.f13143e, this.f13144f, this.f13145g, cryptoData);
            this.f13141c = 0;
        }
    }

    public void b() {
        this.f13140b = false;
        this.f13141c = 0;
    }

    public void c(TrackOutput trackOutput, long j2, int i2, int i3, int i4, @Nullable TrackOutput.CryptoData cryptoData) {
        Assertions.j(this.f13145g <= i3 + i4, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f13140b) {
            int i5 = this.f13141c;
            int i6 = i5 + 1;
            this.f13141c = i6;
            if (i5 == 0) {
                this.f13142d = j2;
                this.f13143e = i2;
                this.f13144f = 0;
            }
            this.f13144f += i3;
            this.f13145g = i4;
            if (i6 >= 16) {
                a(trackOutput, cryptoData);
            }
        }
    }

    public void d(ExtractorInput extractorInput) throws IOException {
        if (!this.f13140b) {
            extractorInput.s(this.f13139a, 0, 10);
            extractorInput.n();
            if (Ac3Util.j(this.f13139a) != 0) {
                this.f13140b = true;
            }
        }
    }
}
