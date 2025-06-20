package androidx.media3.extractor.ogg;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.FlacFrameReader;
import androidx.media3.extractor.FlacMetadataReader;
import androidx.media3.extractor.FlacSeekTableSeekMap;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ogg.StreamReader;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class FlacReader extends StreamReader {
    private static final byte t = -1;
    private static final int u = 4;
    @Nullable
    private FlacStreamMetadata r;
    @Nullable
    private FlacOggSeeker s;

    private static final class FlacOggSeeker implements OggSeeker {

        /* renamed from: a  reason: collision with root package name */
        private FlacStreamMetadata f13714a;

        /* renamed from: b  reason: collision with root package name */
        private FlacStreamMetadata.SeekTable f13715b;

        /* renamed from: c  reason: collision with root package name */
        private long f13716c = -1;

        /* renamed from: d  reason: collision with root package name */
        private long f13717d = -1;

        public FlacOggSeeker(FlacStreamMetadata flacStreamMetadata, FlacStreamMetadata.SeekTable seekTable) {
            this.f13714a = flacStreamMetadata;
            this.f13715b = seekTable;
        }

        public SeekMap a() {
            Assertions.i(this.f13716c != -1);
            return new FlacSeekTableSeekMap(this.f13714a, this.f13716c);
        }

        public long b(ExtractorInput extractorInput) {
            long j2 = this.f13717d;
            if (j2 < 0) {
                return -1;
            }
            long j3 = -(j2 + 2);
            this.f13717d = -1;
            return j3;
        }

        public void c(long j2) {
            long[] jArr = this.f13715b.f13061a;
            this.f13717d = jArr[Util.n(jArr, j2, true, true)];
        }

        public void d(long j2) {
            this.f13716c = j2;
        }
    }

    FlacReader() {
    }

    private int n(ParsableByteArray parsableByteArray) {
        int i2 = (parsableByteArray.e()[2] & 255) >> 4;
        if (i2 == 6 || i2 == 7) {
            parsableByteArray.Z(4);
            parsableByteArray.S();
        }
        int j2 = FlacFrameReader.j(parsableByteArray, i2);
        parsableByteArray.Y(0);
        return j2;
    }

    private static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(ParsableByteArray parsableByteArray) {
        return parsableByteArray.a() >= 5 && parsableByteArray.L() == 127 && parsableByteArray.N() == 1179402563;
    }

    /* access modifiers changed from: protected */
    public long f(ParsableByteArray parsableByteArray) {
        if (!o(parsableByteArray.e())) {
            return -1;
        }
        return (long) n(parsableByteArray);
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean h(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) {
        byte[] e2 = parsableByteArray.e();
        FlacStreamMetadata flacStreamMetadata = this.r;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(e2, 17);
            this.r = flacStreamMetadata2;
            setupData.f13756a = flacStreamMetadata2.i(Arrays.copyOfRange(e2, 9, parsableByteArray.g()), (Metadata) null);
            return true;
        } else if ((e2[0] & Byte.MAX_VALUE) == 3) {
            FlacStreamMetadata.SeekTable f2 = FlacMetadataReader.f(parsableByteArray);
            FlacStreamMetadata c2 = flacStreamMetadata.c(f2);
            this.r = c2;
            this.s = new FlacOggSeeker(c2, f2);
            return true;
        } else if (!o(e2)) {
            return true;
        } else {
            FlacOggSeeker flacOggSeeker = this.s;
            if (flacOggSeeker != null) {
                flacOggSeeker.d(j2);
                setupData.f13757b = this.s;
            }
            Assertions.g(setupData.f13756a);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.r = null;
            this.s = null;
        }
    }
}
