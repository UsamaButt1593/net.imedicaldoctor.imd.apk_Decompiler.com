package androidx.media3.extractor;

import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
public final class CeaUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12966a = "CeaUtil";

    /* renamed from: b  reason: collision with root package name */
    public static final int f12967b = 1195456820;

    /* renamed from: c  reason: collision with root package name */
    public static final int f12968c = 3;

    /* renamed from: d  reason: collision with root package name */
    private static final int f12969d = 4;

    /* renamed from: e  reason: collision with root package name */
    private static final int f12970e = 181;

    /* renamed from: f  reason: collision with root package name */
    private static final int f12971f = 49;

    /* renamed from: g  reason: collision with root package name */
    private static final int f12972g = 47;

    private CeaUtil() {
    }

    public static void a(long j2, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        while (true) {
            boolean z = true;
            if (parsableByteArray.a() > 1) {
                int c2 = c(parsableByteArray);
                int c3 = c(parsableByteArray);
                int f2 = parsableByteArray.f() + c3;
                if (c3 == -1 || c3 > parsableByteArray.a()) {
                    Log.n(f12966a, "Skipping remainder of malformed SEI NAL unit.");
                    f2 = parsableByteArray.g();
                } else if (c2 == 4 && c3 >= 8) {
                    int L = parsableByteArray.L();
                    int R = parsableByteArray.R();
                    int s = R == 49 ? parsableByteArray.s() : 0;
                    int L2 = parsableByteArray.L();
                    if (R == 47) {
                        parsableByteArray.Z(1);
                    }
                    boolean z2 = L == f12970e && (R == 49 || R == 47) && L2 == 3;
                    if (R == 49) {
                        if (s != 1195456820) {
                            z = false;
                        }
                        z2 &= z;
                    }
                    if (z2) {
                        b(j2, parsableByteArray, trackOutputArr);
                    }
                }
                parsableByteArray.Y(f2);
            } else {
                return;
            }
        }
    }

    public static void b(long j2, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        TrackOutput[] trackOutputArr2 = trackOutputArr;
        int L = parsableByteArray.L();
        if ((L & 64) != 0) {
            parsableByteArray2.Z(1);
            int i2 = (L & 31) * 3;
            int f2 = parsableByteArray.f();
            for (TrackOutput trackOutput : trackOutputArr2) {
                parsableByteArray2.Y(f2);
                trackOutput.d(parsableByteArray2, i2);
                Assertions.i(j2 != C.f9084b);
                trackOutput.f(j2, 1, i2, 0, (TrackOutput.CryptoData) null);
            }
        }
    }

    private static int c(ParsableByteArray parsableByteArray) {
        int i2 = 0;
        while (parsableByteArray.a() != 0) {
            int L = parsableByteArray.L();
            i2 += L;
            if (L != 255) {
                return i2;
            }
        }
        return -1;
    }
}
