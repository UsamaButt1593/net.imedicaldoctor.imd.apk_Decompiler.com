package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@UnstableApi
public final class FlacMetadataReader {

    /* renamed from: a  reason: collision with root package name */
    private static final int f13041a = 1716281667;

    /* renamed from: b  reason: collision with root package name */
    private static final int f13042b = 16382;

    /* renamed from: c  reason: collision with root package name */
    private static final int f13043c = 18;

    public static final class FlacStreamMetadataHolder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public FlacStreamMetadata f13044a;

        public FlacStreamMetadataHolder(@Nullable FlacStreamMetadata flacStreamMetadata) {
            this.f13044a = flacStreamMetadata;
        }
    }

    private FlacMetadataReader() {
    }

    public static boolean a(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        extractorInput.s(parsableByteArray.e(), 0, 4);
        return parsableByteArray.N() == 1716281667;
    }

    public static int b(ExtractorInput extractorInput) throws IOException {
        extractorInput.n();
        ParsableByteArray parsableByteArray = new ParsableByteArray(2);
        extractorInput.s(parsableByteArray.e(), 0, 2);
        int R = parsableByteArray.R();
        int i2 = R >> 2;
        extractorInput.n();
        if (i2 == f13042b) {
            return R;
        }
        throw ParserException.a("First frame does not start with sync code.", (Throwable) null);
    }

    @Nullable
    public static Metadata c(ExtractorInput extractorInput, boolean z) throws IOException {
        Metadata a2 = new Id3Peeker().a(extractorInput, z ? null : Id3Decoder.f13355b);
        if (a2 == null || a2.g() == 0) {
            return null;
        }
        return a2;
    }

    @Nullable
    public static Metadata d(ExtractorInput extractorInput, boolean z) throws IOException {
        extractorInput.n();
        long i2 = extractorInput.i();
        Metadata c2 = c(extractorInput, z);
        extractorInput.o((int) (extractorInput.i() - i2));
        return c2;
    }

    public static boolean e(ExtractorInput extractorInput, FlacStreamMetadataHolder flacStreamMetadataHolder) throws IOException {
        FlacStreamMetadata b2;
        extractorInput.n();
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[4]);
        extractorInput.s(parsableBitArray.f9607a, 0, 4);
        boolean g2 = parsableBitArray.g();
        int h2 = parsableBitArray.h(7);
        int h3 = parsableBitArray.h(24) + 4;
        if (h2 == 0) {
            b2 = h(extractorInput);
        } else {
            FlacStreamMetadata flacStreamMetadata = flacStreamMetadataHolder.f13044a;
            if (flacStreamMetadata == null) {
                throw new IllegalArgumentException();
            } else if (h2 == 3) {
                b2 = flacStreamMetadata.c(g(extractorInput, h3));
            } else if (h2 == 4) {
                b2 = flacStreamMetadata.d(j(extractorInput, h3));
            } else if (h2 == 6) {
                ParsableByteArray parsableByteArray = new ParsableByteArray(h3);
                extractorInput.readFully(parsableByteArray.e(), 0, h3);
                parsableByteArray.Z(4);
                b2 = flacStreamMetadata.b(ImmutableList.K(PictureFrame.a(parsableByteArray)));
            } else {
                extractorInput.o(h3);
                return g2;
            }
        }
        flacStreamMetadataHolder.f13044a = b2;
        return g2;
    }

    public static FlacStreamMetadata.SeekTable f(ParsableByteArray parsableByteArray) {
        parsableByteArray.Z(1);
        int O = parsableByteArray.O();
        long f2 = ((long) parsableByteArray.f()) + ((long) O);
        int i2 = O / 18;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            long E = parsableByteArray.E();
            if (E == -1) {
                jArr = Arrays.copyOf(jArr, i3);
                jArr2 = Arrays.copyOf(jArr2, i3);
                break;
            }
            jArr[i3] = E;
            jArr2[i3] = parsableByteArray.E();
            parsableByteArray.Z(2);
            i3++;
        }
        parsableByteArray.Z((int) (f2 - ((long) parsableByteArray.f())));
        return new FlacStreamMetadata.SeekTable(jArr, jArr2);
    }

    private static FlacStreamMetadata.SeekTable g(ExtractorInput extractorInput, int i2) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
        extractorInput.readFully(parsableByteArray.e(), 0, i2);
        return f(parsableByteArray);
    }

    private static FlacStreamMetadata h(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = new byte[38];
        extractorInput.readFully(bArr, 0, 38);
        return new FlacStreamMetadata(bArr, 4);
    }

    public static void i(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        extractorInput.readFully(parsableByteArray.e(), 0, 4);
        if (parsableByteArray.N() != 1716281667) {
            throw ParserException.a("Failed to read FLAC stream marker.", (Throwable) null);
        }
    }

    private static List<String> j(ExtractorInput extractorInput, int i2) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
        extractorInput.readFully(parsableByteArray.e(), 0, i2);
        parsableByteArray.Z(4);
        return Arrays.asList(VorbisUtil.k(parsableByteArray, false, false).f13152b);
    }
}
