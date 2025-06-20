package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.CeaUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.List;

@UnstableApi
public final class SeiReader {

    /* renamed from: a  reason: collision with root package name */
    private final List<Format> f14485a;

    /* renamed from: b  reason: collision with root package name */
    private final TrackOutput[] f14486b;

    public SeiReader(List<Format> list) {
        this.f14485a = list;
        this.f14486b = new TrackOutput[list.size()];
    }

    public void a(long j2, ParsableByteArray parsableByteArray) {
        CeaUtil.a(j2, parsableByteArray, this.f14486b);
    }

    public void b(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i2 = 0; i2 < this.f14486b.length; i2++) {
            trackIdGenerator.a();
            TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 3);
            Format format = this.f14485a.get(i2);
            String str = format.f3;
            boolean z = MimeTypes.w0.equals(str) || MimeTypes.x0.equals(str);
            Assertions.b(z, "Invalid closed caption MIME type provided: " + str);
            String str2 = format.s;
            if (str2 == null) {
                str2 = trackIdGenerator.b();
            }
            d2.e(new Format.Builder().X(str2).k0(str).m0(format.X2).b0(format.Z).J(format.x3).Y(format.h3).I());
            this.f14486b[i2] = d2;
        }
    }
}
