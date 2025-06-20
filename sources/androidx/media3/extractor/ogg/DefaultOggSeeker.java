package androidx.media3.extractor.ogg;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;

final class DefaultOggSeeker implements OggSeeker {

    /* renamed from: m  reason: collision with root package name */
    private static final int f13699m = 72000;

    /* renamed from: n  reason: collision with root package name */
    private static final int f13700n = 100000;
    private static final int o = 30000;
    private static final int p = 0;
    private static final int q = 1;
    private static final int r = 2;
    private static final int s = 3;
    private static final int t = 4;

    /* renamed from: a  reason: collision with root package name */
    private final OggPageHeader f13701a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f13702b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final long f13703c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final StreamReader f13704d;

    /* renamed from: e  reason: collision with root package name */
    private int f13705e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f13706f;

    /* renamed from: g  reason: collision with root package name */
    private long f13707g;

    /* renamed from: h  reason: collision with root package name */
    private long f13708h;

    /* renamed from: i  reason: collision with root package name */
    private long f13709i;

    /* renamed from: j  reason: collision with root package name */
    private long f13710j;

    /* renamed from: k  reason: collision with root package name */
    private long f13711k;

    /* renamed from: l  reason: collision with root package name */
    private long f13712l;

    private final class OggSeekMap implements SeekMap {
        private OggSeekMap() {
        }

        public boolean g() {
            return true;
        }

        public SeekMap.SeekPoints j(long j2) {
            return new SeekMap.SeekPoints(new SeekPoint(j2, Util.x((DefaultOggSeeker.this.f13702b + BigInteger.valueOf(DefaultOggSeeker.this.f13704d.c(j2)).multiply(BigInteger.valueOf(DefaultOggSeeker.this.f13703c - DefaultOggSeeker.this.f13702b)).divide(BigInteger.valueOf(DefaultOggSeeker.this.f13706f)).longValue()) - 30000, DefaultOggSeeker.this.f13702b, DefaultOggSeeker.this.f13703c - 1)));
        }

        public long l() {
            return DefaultOggSeeker.this.f13704d.b(DefaultOggSeeker.this.f13706f);
        }
    }

    public DefaultOggSeeker(StreamReader streamReader, long j2, long j3, long j4, long j5, boolean z) {
        Assertions.a(j2 >= 0 && j3 > j2);
        this.f13704d = streamReader;
        this.f13702b = j2;
        this.f13703c = j3;
        if (j4 == j3 - j2 || z) {
            this.f13706f = j5;
            this.f13705e = 4;
        } else {
            this.f13705e = 0;
        }
        this.f13701a = new OggPageHeader();
    }

    private long i(ExtractorInput extractorInput) throws IOException {
        ExtractorInput extractorInput2 = extractorInput;
        if (this.f13709i == this.f13710j) {
            return -1;
        }
        long position = extractorInput.getPosition();
        if (!this.f13701a.d(extractorInput2, this.f13710j)) {
            long j2 = this.f13709i;
            if (j2 != position) {
                return j2;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f13701a.a(extractorInput2, false);
        extractorInput.n();
        long j3 = this.f13708h;
        OggPageHeader oggPageHeader = this.f13701a;
        long j4 = oggPageHeader.f13733c;
        long j5 = j3 - j4;
        int i2 = oggPageHeader.f13738h + oggPageHeader.f13739i;
        if (0 <= j5 && j5 < 72000) {
            return -1;
        }
        int i3 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i3 < 0) {
            this.f13710j = position;
            this.f13712l = j4;
        } else {
            this.f13709i = extractorInput.getPosition() + ((long) i2);
            this.f13711k = this.f13701a.f13733c;
        }
        long j6 = this.f13710j;
        long j7 = this.f13709i;
        if (j6 - j7 < SilenceSkippingAudioProcessor.A) {
            this.f13710j = j7;
            return j7;
        }
        long j8 = ((long) i2) * (i3 <= 0 ? 2 : 1);
        long j9 = this.f13710j;
        long j10 = this.f13709i;
        return Util.x((extractorInput.getPosition() - j8) + ((j5 * (j9 - j10)) / (this.f13712l - this.f13711k)), j10, j9 - 1);
    }

    private void k(ExtractorInput extractorInput) throws IOException {
        while (true) {
            this.f13701a.c(extractorInput);
            this.f13701a.a(extractorInput, false);
            OggPageHeader oggPageHeader = this.f13701a;
            if (oggPageHeader.f13733c > this.f13708h) {
                extractorInput.n();
                return;
            }
            extractorInput.o(oggPageHeader.f13738h + oggPageHeader.f13739i);
            this.f13709i = extractorInput.getPosition();
            this.f13711k = this.f13701a.f13733c;
        }
    }

    public long b(ExtractorInput extractorInput) throws IOException {
        int i2 = this.f13705e;
        if (i2 == 0) {
            long position = extractorInput.getPosition();
            this.f13707g = position;
            this.f13705e = 1;
            long j2 = this.f13703c - 65307;
            if (j2 > position) {
                return j2;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                long i3 = i(extractorInput);
                if (i3 != -1) {
                    return i3;
                }
                this.f13705e = 3;
            } else if (i2 != 3) {
                if (i2 == 4) {
                    return -1;
                }
                throw new IllegalStateException();
            }
            k(extractorInput);
            this.f13705e = 4;
            return -(this.f13711k + 2);
        }
        this.f13706f = j(extractorInput);
        this.f13705e = 4;
        return this.f13707g;
    }

    public void c(long j2) {
        this.f13708h = Util.x(j2, 0, this.f13706f - 1);
        this.f13705e = 2;
        this.f13709i = this.f13702b;
        this.f13710j = this.f13703c;
        this.f13711k = 0;
        this.f13712l = this.f13706f;
    }

    @Nullable
    /* renamed from: h */
    public OggSeekMap a() {
        if (this.f13706f != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public long j(ExtractorInput extractorInput) throws IOException {
        long j2;
        OggPageHeader oggPageHeader;
        this.f13701a.b();
        if (this.f13701a.c(extractorInput)) {
            this.f13701a.a(extractorInput, false);
            OggPageHeader oggPageHeader2 = this.f13701a;
            extractorInput.o(oggPageHeader2.f13738h + oggPageHeader2.f13739i);
            do {
                j2 = this.f13701a.f13733c;
                OggPageHeader oggPageHeader3 = this.f13701a;
                if ((oggPageHeader3.f13732b & 4) == 4 || !oggPageHeader3.c(extractorInput) || extractorInput.getPosition() >= this.f13703c || !this.f13701a.a(extractorInput, true)) {
                    return j2;
                }
                oggPageHeader = this.f13701a;
            } while (ExtractorUtil.e(extractorInput, oggPageHeader.f13738h + oggPageHeader.f13739i));
            return j2;
        }
        throw new EOFException();
    }
}
