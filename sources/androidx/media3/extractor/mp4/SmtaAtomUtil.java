package androidx.media3.extractor.mp4;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;
import androidx.media3.extractor.ts.PsExtractor;

@UnstableApi
public final class SmtaAtomUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final int f13643a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final int f13644b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f13645c = 7;

    /* renamed from: d  reason: collision with root package name */
    private static final int f13646d = 9;

    /* renamed from: e  reason: collision with root package name */
    private static final int f13647e = 12;

    /* renamed from: f  reason: collision with root package name */
    private static final int f13648f = 13;

    /* renamed from: g  reason: collision with root package name */
    private static final int f13649g = 21;

    /* renamed from: h  reason: collision with root package name */
    private static final int f13650h = 22;

    /* renamed from: i  reason: collision with root package name */
    private static final int f13651i = 23;

    private SmtaAtomUtil() {
    }

    private static int a(int i2, ParsableByteArray parsableByteArray, int i3) {
        if (i2 == 12) {
            return PsExtractor.A;
        }
        if (i2 == 13) {
            return 120;
        }
        if (i2 == 21 && parsableByteArray.a() >= 8 && parsableByteArray.f() + 8 <= i3) {
            int s = parsableByteArray.s();
            int s2 = parsableByteArray.s();
            if (s >= 12 && s2 == 1936877170) {
                return parsableByteArray.M();
            }
        }
        return C.f9088f;
    }

    @Nullable
    public static Metadata b(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.Z(12);
        while (parsableByteArray.f() < i2) {
            int f2 = parsableByteArray.f();
            int s = parsableByteArray.s();
            if (parsableByteArray.s() != 1935766900) {
                parsableByteArray.Y(f2 + s);
            } else if (s < 16) {
                return null;
            } else {
                parsableByteArray.Z(4);
                int i3 = -1;
                int i4 = 0;
                for (int i5 = 0; i5 < 2; i5++) {
                    int L = parsableByteArray.L();
                    int L2 = parsableByteArray.L();
                    if (L == 0) {
                        i3 = L2;
                    } else if (L == 1) {
                        i4 = L2;
                    }
                }
                int a2 = a(i3, parsableByteArray, i2);
                if (a2 == -2147483647) {
                    return null;
                }
                return new Metadata(new SmtaMetadataEntry((float) a2, i4));
            }
        }
        return null;
    }
}
