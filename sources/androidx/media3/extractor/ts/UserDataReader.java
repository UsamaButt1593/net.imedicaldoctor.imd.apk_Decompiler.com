package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.CeaUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.List;

final class UserDataReader {

    /* renamed from: c  reason: collision with root package name */
    private static final int f14551c = 434;

    /* renamed from: a  reason: collision with root package name */
    private final List<Format> f14552a;

    /* renamed from: b  reason: collision with root package name */
    private final TrackOutput[] f14553b;

    public UserDataReader(List<Format> list) {
        this.f14552a = list;
        this.f14553b = new TrackOutput[list.size()];
    }

    public void a(long j2, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() >= 9) {
            int s = parsableByteArray.s();
            int s2 = parsableByteArray.s();
            int L = parsableByteArray.L();
            if (s == f14551c && s2 == 1195456820 && L == 3) {
                CeaUtil.b(j2, parsableByteArray, this.f14553b);
            }
        }
    }

    public void b(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i2 = 0; i2 < this.f14553b.length; i2++) {
            trackIdGenerator.a();
            TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 3);
            Format format = this.f14552a.get(i2);
            String str = format.f3;
            boolean z = MimeTypes.w0.equals(str) || MimeTypes.x0.equals(str);
            Assertions.b(z, "Invalid closed caption MIME type provided: " + str);
            d2.e(new Format.Builder().X(trackIdGenerator.b()).k0(str).m0(format.X2).b0(format.Z).J(format.x3).Y(format.h3).I());
            this.f14553b[i2] = d2;
        }
    }
}
