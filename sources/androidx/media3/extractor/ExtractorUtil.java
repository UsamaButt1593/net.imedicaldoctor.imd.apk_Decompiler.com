package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.UnstableApi;
import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

@UnstableApi
public final class ExtractorUtil {
    private ExtractorUtil() {
    }

    @Pure
    public static void a(boolean z, @Nullable String str) throws ParserException {
        if (!z) {
            throw ParserException.a(str, (Throwable) null);
        }
    }

    public static boolean b(ExtractorInput extractorInput, byte[] bArr, int i2, int i3, boolean z) throws IOException {
        try {
            return extractorInput.h(bArr, i2, i3, z);
        } catch (EOFException e2) {
            if (z) {
                return false;
            }
            throw e2;
        }
    }

    public static int c(ExtractorInput extractorInput, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        while (i4 < i3) {
            int m2 = extractorInput.m(bArr, i2 + i4, i3 - i4);
            if (m2 == -1) {
                break;
            }
            i4 += m2;
        }
        return i4;
    }

    public static boolean d(ExtractorInput extractorInput, byte[] bArr, int i2, int i3) throws IOException {
        try {
            extractorInput.readFully(bArr, i2, i3);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(ExtractorInput extractorInput, int i2) throws IOException {
        try {
            extractorInput.o(i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
