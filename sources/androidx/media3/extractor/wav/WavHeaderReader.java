package androidx.media3.extractor.wav;

import android.util.Pair;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.WavUtil;
import java.io.IOException;

final class WavHeaderReader {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14595a = "WavHeaderReader";

    private static final class ChunkHeader {

        /* renamed from: c  reason: collision with root package name */
        public static final int f14596c = 8;

        /* renamed from: a  reason: collision with root package name */
        public final int f14597a;

        /* renamed from: b  reason: collision with root package name */
        public final long f14598b;

        private ChunkHeader(int i2, long j2) {
            this.f14597a = i2;
            this.f14598b = j2;
        }

        public static ChunkHeader a(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException {
            extractorInput.s(parsableByteArray.e(), 0, 8);
            parsableByteArray.Y(0);
            return new ChunkHeader(parsableByteArray.s(), parsableByteArray.A());
        }
    }

    private WavHeaderReader() {
    }

    public static boolean a(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        int i2 = ChunkHeader.a(extractorInput, parsableByteArray).f14597a;
        if (i2 != 1380533830 && i2 != 1380333108) {
            return false;
        }
        extractorInput.s(parsableByteArray.e(), 0, 4);
        parsableByteArray.Y(0);
        int s = parsableByteArray.s();
        if (s == 1463899717) {
            return true;
        }
        Log.d(f14595a, "Unsupported form type: " + s);
        return false;
    }

    public static WavFormat b(ExtractorInput extractorInput) throws IOException {
        byte[] bArr;
        ExtractorInput extractorInput2 = extractorInput;
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        ChunkHeader d2 = d(WavUtil.f13170c, extractorInput2, parsableByteArray);
        Assertions.i(d2.f14598b >= 16);
        extractorInput2.s(parsableByteArray.e(), 0, 16);
        parsableByteArray.Y(0);
        int D = parsableByteArray.D();
        int D2 = parsableByteArray.D();
        int C = parsableByteArray.C();
        int C2 = parsableByteArray.C();
        int D3 = parsableByteArray.D();
        int D4 = parsableByteArray.D();
        int i2 = ((int) d2.f14598b) - 16;
        if (i2 > 0) {
            byte[] bArr2 = new byte[i2];
            extractorInput2.s(bArr2, 0, i2);
            bArr = bArr2;
        } else {
            bArr = Util.f9651f;
        }
        extractorInput2.o((int) (extractorInput.i() - extractorInput.getPosition()));
        return new WavFormat(D, D2, C, C2, D3, D4, bArr);
    }

    public static long c(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader a2 = ChunkHeader.a(extractorInput, parsableByteArray);
        if (a2.f14597a != 1685272116) {
            extractorInput.n();
            return -1;
        }
        extractorInput.j(8);
        parsableByteArray.Y(0);
        extractorInput.s(parsableByteArray.e(), 0, 8);
        long y = parsableByteArray.y();
        extractorInput.o(((int) a2.f14598b) + 8);
        return y;
    }

    private static ChunkHeader d(int i2, ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException {
        while (true) {
            ChunkHeader a2 = ChunkHeader.a(extractorInput, parsableByteArray);
            if (a2.f14597a == i2) {
                return a2;
            }
            Log.n(f14595a, "Ignoring unknown WAV chunk: " + a2.f14597a);
            long j2 = a2.f14598b;
            long j3 = 8 + j2;
            if (j2 % 2 != 0) {
                j3 = 9 + j2;
            }
            if (j3 <= 2147483647L) {
                extractorInput.o((int) j3);
            } else {
                throw ParserException.e("Chunk is too large (~2GB+) to skip; id: " + a2.f14597a);
            }
        }
    }

    public static Pair<Long, Long> e(ExtractorInput extractorInput) throws IOException {
        extractorInput.n();
        ChunkHeader d2 = d(1684108385, extractorInput, new ParsableByteArray(8));
        extractorInput.o(8);
        return Pair.create(Long.valueOf(extractorInput.getPosition()), Long.valueOf(d2.f14598b));
    }
}
