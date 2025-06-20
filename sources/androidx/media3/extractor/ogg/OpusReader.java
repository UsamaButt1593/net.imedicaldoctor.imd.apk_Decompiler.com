package androidx.media3.extractor.ogg;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.ogg.StreamReader;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class OpusReader extends StreamReader {
    private static final byte[] s = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] t = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean r;

    OpusReader() {
    }

    private static boolean n(ParsableByteArray parsableByteArray, byte[] bArr) {
        if (parsableByteArray.a() < bArr.length) {
            return false;
        }
        int f2 = parsableByteArray.f();
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.n(bArr2, 0, bArr.length);
        parsableByteArray.Y(f2);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean o(ParsableByteArray parsableByteArray) {
        return n(parsableByteArray, s);
    }

    /* access modifiers changed from: protected */
    public long f(ParsableByteArray parsableByteArray) {
        return c(OpusUtil.e(parsableByteArray.e()));
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean h(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) throws ParserException {
        Format.Builder d0;
        if (n(parsableByteArray, s)) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.e(), parsableByteArray.g());
            int c2 = OpusUtil.c(copyOf);
            List<byte[]> a2 = OpusUtil.a(copyOf);
            if (setupData.f13756a != null) {
                return true;
            }
            d0 = new Format.Builder().k0(MimeTypes.a0).L(c2).l0(OpusUtil.f13107a).Y(a2);
        } else {
            byte[] bArr = t;
            if (n(parsableByteArray, bArr)) {
                Assertions.k(setupData.f13756a);
                if (this.r) {
                    return true;
                }
                this.r = true;
                parsableByteArray.Z(bArr.length);
                Metadata d2 = VorbisUtil.d(ImmutableList.D(VorbisUtil.k(parsableByteArray, false, false).f13152b));
                if (d2 == null) {
                    return true;
                }
                d0 = setupData.f13756a.c().d0(d2.b(setupData.f13756a.d3));
            } else {
                Assertions.k(setupData.f13756a);
                return false;
            }
        }
        setupData.f13756a = d0.I();
        return true;
    }

    /* access modifiers changed from: protected */
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.r = false;
        }
    }
}
