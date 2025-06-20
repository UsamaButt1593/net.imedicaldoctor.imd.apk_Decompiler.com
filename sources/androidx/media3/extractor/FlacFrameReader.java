package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ts.PsExtractor;
import java.io.IOException;

@UnstableApi
public final class FlacFrameReader {

    public static final class SampleNumberHolder {

        /* renamed from: a  reason: collision with root package name */
        public long f13040a;
    }

    private FlacFrameReader() {
    }

    private static boolean a(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i2) {
        int j2 = j(parsableByteArray, i2);
        return j2 != -1 && j2 <= flacStreamMetadata.f13050b;
    }

    private static boolean b(ParsableByteArray parsableByteArray, int i2) {
        return parsableByteArray.L() == Util.F(parsableByteArray.e(), i2, parsableByteArray.f() - 1, 0);
    }

    private static boolean c(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, boolean z, SampleNumberHolder sampleNumberHolder) {
        try {
            long S = parsableByteArray.S();
            if (!z) {
                S *= (long) flacStreamMetadata.f13050b;
            }
            sampleNumberHolder.f13040a = S;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i2, SampleNumberHolder sampleNumberHolder) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        FlacStreamMetadata flacStreamMetadata2 = flacStreamMetadata;
        int f2 = parsableByteArray.f();
        long N = parsableByteArray.N();
        long j2 = N >>> 16;
        if (j2 != ((long) i2)) {
            return false;
        }
        return g((int) (15 & (N >> 4)), flacStreamMetadata2) && f((int) ((N >> 1) & 7), flacStreamMetadata2) && !(((N & 1) > 1 ? 1 : ((N & 1) == 1 ? 0 : -1)) == 0) && c(parsableByteArray2, flacStreamMetadata2, ((j2 & 1) > 1 ? 1 : ((j2 & 1) == 1 ? 0 : -1)) == 0, sampleNumberHolder) && a(parsableByteArray2, flacStreamMetadata2, (int) ((N >> 12) & 15)) && e(parsableByteArray2, flacStreamMetadata2, (int) ((N >> 8) & 15)) && b(parsableByteArray2, f2);
    }

    private static boolean e(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i2) {
        int i3 = flacStreamMetadata.f13053e;
        if (i2 == 0) {
            return true;
        }
        if (i2 <= 11) {
            return i2 == flacStreamMetadata.f13054f;
        }
        if (i2 == 12) {
            return parsableByteArray.L() * 1000 == i3;
        }
        if (i2 > 14) {
            return false;
        }
        int R = parsableByteArray.R();
        if (i2 == 14) {
            R *= 10;
        }
        return R == i3;
    }

    private static boolean f(int i2, FlacStreamMetadata flacStreamMetadata) {
        return i2 == 0 || i2 == flacStreamMetadata.f13057i;
    }

    private static boolean g(int i2, FlacStreamMetadata flacStreamMetadata) {
        return i2 <= 7 ? i2 == flacStreamMetadata.f13055g - 1 : i2 <= 10 && flacStreamMetadata.f13055g == 2;
    }

    public static boolean h(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata, int i2, SampleNumberHolder sampleNumberHolder) throws IOException {
        long i3 = extractorInput.i();
        byte[] bArr = new byte[2];
        extractorInput.s(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i2) {
            extractorInput.n();
            extractorInput.j((int) (i3 - extractorInput.getPosition()));
            return false;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        System.arraycopy(bArr, 0, parsableByteArray.e(), 0, 2);
        parsableByteArray.X(ExtractorUtil.c(extractorInput, parsableByteArray.e(), 2, 14));
        extractorInput.n();
        extractorInput.j((int) (i3 - extractorInput.getPosition()));
        return d(parsableByteArray, flacStreamMetadata, i2, sampleNumberHolder);
    }

    public static long i(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata) throws IOException {
        extractorInput.n();
        boolean z = true;
        extractorInput.j(1);
        byte[] bArr = new byte[1];
        extractorInput.s(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z = false;
        }
        extractorInput.j(2);
        int i2 = z ? 7 : 6;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
        parsableByteArray.X(ExtractorUtil.c(extractorInput, parsableByteArray.e(), 0, i2));
        extractorInput.n();
        SampleNumberHolder sampleNumberHolder = new SampleNumberHolder();
        if (c(parsableByteArray, flacStreamMetadata, z, sampleNumberHolder)) {
            return sampleNumberHolder.f13040a;
        }
        throw ParserException.a((String) null, (Throwable) null);
    }

    public static int j(ParsableByteArray parsableByteArray, int i2) {
        switch (i2) {
            case 1:
                return PsExtractor.x;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i2 - 2);
            case 6:
                return parsableByteArray.L() + 1;
            case 7:
                return parsableByteArray.R() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i2 - 8);
            default:
                return -1;
        }
    }
}
