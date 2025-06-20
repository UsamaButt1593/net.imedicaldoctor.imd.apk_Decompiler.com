package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class DolbyVisionConfig {

    /* renamed from: a  reason: collision with root package name */
    public final int f13012a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13013b;

    /* renamed from: c  reason: collision with root package name */
    public final String f13014c;

    private DolbyVisionConfig(int i2, int i3, String str) {
        this.f13012a = i2;
        this.f13013b = i3;
        this.f13014c = str;
    }

    @Nullable
    public static DolbyVisionConfig a(ParsableByteArray parsableByteArray) {
        String str;
        parsableByteArray.Z(2);
        int L = parsableByteArray.L();
        int i2 = L >> 1;
        int L2 = ((parsableByteArray.L() >> 3) & 31) | ((L & 1) << 5);
        if (i2 == 4 || i2 == 5 || i2 == 7) {
            str = "dvhe";
        } else if (i2 == 8) {
            str = "hev1";
        } else if (i2 != 9) {
            return null;
        } else {
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = ".0";
        sb.append(str2);
        sb.append(i2);
        if (L2 >= 10) {
            str2 = ".";
        }
        sb.append(str2);
        sb.append(L2);
        return new DolbyVisionConfig(i2, L2, sb.toString());
    }
}
