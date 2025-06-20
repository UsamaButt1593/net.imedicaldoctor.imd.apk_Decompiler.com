package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class WavUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final int f13168a = 1380533830;

    /* renamed from: b  reason: collision with root package name */
    public static final int f13169b = 1463899717;

    /* renamed from: c  reason: collision with root package name */
    public static final int f13170c = 1718449184;

    /* renamed from: d  reason: collision with root package name */
    public static final int f13171d = 1684108385;

    /* renamed from: e  reason: collision with root package name */
    public static final int f13172e = 1380333108;

    /* renamed from: f  reason: collision with root package name */
    public static final int f13173f = 1685272116;

    /* renamed from: g  reason: collision with root package name */
    public static final int f13174g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f13175h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static final int f13176i = 6;

    /* renamed from: j  reason: collision with root package name */
    public static final int f13177j = 7;

    /* renamed from: k  reason: collision with root package name */
    public static final int f13178k = 17;

    /* renamed from: l  reason: collision with root package name */
    public static final int f13179l = 65534;

    private WavUtil() {
    }

    public static int a(int i2, int i3) {
        if (i2 != 1) {
            if (i2 == 3) {
                return i3 == 32 ? 4 : 0;
            }
            if (i2 != 65534) {
                return 0;
            }
        }
        return Util.C0(i3);
    }

    public static int b(int i2) {
        if (i2 == 2 || i2 == 3) {
            return 1;
        }
        if (i2 == 4) {
            return 3;
        }
        if (i2 == 21 || i2 == 22) {
            return 1;
        }
        throw new IllegalArgumentException();
    }
}
