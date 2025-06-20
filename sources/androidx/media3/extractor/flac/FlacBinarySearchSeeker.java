package androidx.media3.extractor.flac;

import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.FlacFrameReader;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.a;
import java.io.IOException;

final class FlacBinarySearchSeeker extends BinarySearchSeeker {

    private static final class FlacTimestampSeeker implements BinarySearchSeeker.TimestampSeeker {

        /* renamed from: a  reason: collision with root package name */
        private final FlacStreamMetadata f13241a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13242b;

        /* renamed from: c  reason: collision with root package name */
        private final FlacFrameReader.SampleNumberHolder f13243c;

        private FlacTimestampSeeker(FlacStreamMetadata flacStreamMetadata, int i2) {
            this.f13241a = flacStreamMetadata;
            this.f13242b = i2;
            this.f13243c = new FlacFrameReader.SampleNumberHolder();
        }

        private long c(ExtractorInput extractorInput) throws IOException {
            while (extractorInput.i() < extractorInput.getLength() - 6 && !FlacFrameReader.h(extractorInput, this.f13241a, this.f13242b, this.f13243c)) {
                extractorInput.j(1);
            }
            if (extractorInput.i() < extractorInput.getLength() - 6) {
                return this.f13243c.f13040a;
            }
            extractorInput.j((int) (extractorInput.getLength() - extractorInput.i()));
            return this.f13241a.f13058j;
        }

        public BinarySearchSeeker.TimestampSearchResult a(ExtractorInput extractorInput, long j2) throws IOException {
            long position = extractorInput.getPosition();
            long c2 = c(extractorInput);
            long i2 = extractorInput.i();
            extractorInput.j(Math.max(6, this.f13241a.f13051c));
            long c3 = c(extractorInput);
            long i3 = extractorInput.i();
            if (c2 > j2 || c3 <= j2) {
                return c3 <= j2 ? BinarySearchSeeker.TimestampSearchResult.f(c3, i3) : BinarySearchSeeker.TimestampSearchResult.d(c2, position);
            }
            return BinarySearchSeeker.TimestampSearchResult.e(i2);
        }

        public /* synthetic */ void b() {
            a.a(this);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlacBinarySearchSeeker(androidx.media3.extractor.FlacStreamMetadata r17, int r18, long r19, long r21) {
        /*
            r16 = this;
            r0 = r17
            java.util.Objects.requireNonNull(r17)
            androidx.media3.extractor.flac.a r1 = new androidx.media3.extractor.flac.a
            r1.<init>(r0)
            androidx.media3.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker r2 = new androidx.media3.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker
            r3 = 0
            r4 = r18
            r2.<init>(r0, r4)
            long r3 = r17.h()
            long r7 = r0.f13058j
            long r13 = r17.e()
            r5 = 6
            int r0 = r0.f13051c
            int r15 = java.lang.Math.max(r5, r0)
            r5 = 0
            r0 = r16
            r9 = r19
            r11 = r21
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.flac.FlacBinarySearchSeeker.<init>(androidx.media3.extractor.FlacStreamMetadata, int, long, long):void");
    }
}
