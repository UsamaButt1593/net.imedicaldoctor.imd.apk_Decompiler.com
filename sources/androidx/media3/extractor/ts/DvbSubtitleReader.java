package androidx.media3.extractor.ts;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class DvbSubtitleReader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final List<TsPayloadReader.DvbSubtitleInfo> f14257a;

    /* renamed from: b  reason: collision with root package name */
    private final TrackOutput[] f14258b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14259c;

    /* renamed from: d  reason: collision with root package name */
    private int f14260d;

    /* renamed from: e  reason: collision with root package name */
    private int f14261e;

    /* renamed from: f  reason: collision with root package name */
    private long f14262f = C.f9084b;

    public DvbSubtitleReader(List<TsPayloadReader.DvbSubtitleInfo> list) {
        this.f14257a = list;
        this.f14258b = new TrackOutput[list.size()];
    }

    private boolean f(ParsableByteArray parsableByteArray, int i2) {
        if (parsableByteArray.a() == 0) {
            return false;
        }
        if (parsableByteArray.L() != i2) {
            this.f14259c = false;
        }
        this.f14260d--;
        return this.f14259c;
    }

    public void a() {
        this.f14259c = false;
        this.f14262f = C.f9084b;
    }

    public void b(ParsableByteArray parsableByteArray) {
        if (!this.f14259c) {
            return;
        }
        if (this.f14260d != 2 || f(parsableByteArray, 32)) {
            if (this.f14260d != 1 || f(parsableByteArray, 0)) {
                int f2 = parsableByteArray.f();
                int a2 = parsableByteArray.a();
                for (TrackOutput d2 : this.f14258b) {
                    parsableByteArray.Y(f2);
                    d2.d(parsableByteArray, a2);
                }
                this.f14261e += a2;
            }
        }
    }

    public void c() {
        if (this.f14259c) {
            Assertions.i(this.f14262f != C.f9084b);
            for (TrackOutput f2 : this.f14258b) {
                f2.f(this.f14262f, 1, this.f14261e, 0, (TrackOutput.CryptoData) null);
            }
            this.f14259c = false;
        }
    }

    public void d(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i2 = 0; i2 < this.f14258b.length; i2++) {
            TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = this.f14257a.get(i2);
            trackIdGenerator.a();
            TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 3);
            d2.e(new Format.Builder().X(trackIdGenerator.b()).k0(MimeTypes.J0).Y(Collections.singletonList(dvbSubtitleInfo.f14535c)).b0(dvbSubtitleInfo.f14533a).I());
            this.f14258b[i2] = d2;
        }
    }

    public void e(long j2, int i2) {
        if ((i2 & 4) != 0) {
            this.f14259c = true;
            this.f14262f = j2;
            this.f14261e = 0;
            this.f14260d = 2;
        }
    }
}
