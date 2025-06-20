package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.container.NalUnitUtil;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class HevcConfig {

    /* renamed from: l  reason: collision with root package name */
    private static final int f13070l = 33;

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f13071a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13072b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13073c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13074d;

    /* renamed from: e  reason: collision with root package name */
    public final int f13075e;

    /* renamed from: f  reason: collision with root package name */
    public final int f13076f;

    /* renamed from: g  reason: collision with root package name */
    public final int f13077g;

    /* renamed from: h  reason: collision with root package name */
    public final int f13078h;

    /* renamed from: i  reason: collision with root package name */
    public final int f13079i;

    /* renamed from: j  reason: collision with root package name */
    public final float f13080j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final String f13081k;

    private HevcConfig(List<byte[]> list, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f2, @Nullable String str) {
        this.f13071a = list;
        this.f13072b = i2;
        this.f13073c = i3;
        this.f13074d = i4;
        this.f13075e = i5;
        this.f13076f = i6;
        this.f13077g = i7;
        this.f13078h = i8;
        this.f13079i = i9;
        this.f13080j = f2;
        this.f13081k = str;
    }

    public static HevcConfig a(ParsableByteArray parsableByteArray) throws ParserException {
        int i2;
        int i3;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        try {
            parsableByteArray2.Z(21);
            int L = parsableByteArray.L() & 3;
            int L2 = parsableByteArray.L();
            int f2 = parsableByteArray.f();
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < L2; i6++) {
                parsableByteArray2.Z(1);
                int R = parsableByteArray.R();
                for (int i7 = 0; i7 < R; i7++) {
                    int R2 = parsableByteArray.R();
                    i5 += R2 + 4;
                    parsableByteArray2.Z(R2);
                }
            }
            parsableByteArray2.Y(f2);
            byte[] bArr = new byte[i5];
            String str = null;
            int i8 = 0;
            int i9 = 0;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            float f3 = 1.0f;
            while (i8 < L2) {
                int L3 = parsableByteArray.L() & 63;
                int R3 = parsableByteArray.R();
                int i17 = 0;
                while (i17 < R3) {
                    int R4 = parsableByteArray.R();
                    byte[] bArr2 = NalUnitUtil.f9675j;
                    int i18 = L2;
                    System.arraycopy(bArr2, i4, bArr, i9, bArr2.length);
                    int length = i9 + bArr2.length;
                    System.arraycopy(parsableByteArray.e(), parsableByteArray.f(), bArr, length, R4);
                    if (L3 == 33 && i17 == 0) {
                        NalUnitUtil.H265SpsData h2 = NalUnitUtil.h(bArr, length, length + R4);
                        int i19 = h2.f9690k;
                        i11 = h2.f9691l;
                        i12 = h2.f9685f + 8;
                        i13 = h2.f9686g + 8;
                        int i20 = h2.f9693n;
                        int i21 = h2.o;
                        int i22 = h2.p;
                        float f4 = h2.f9692m;
                        i3 = L3;
                        i2 = R3;
                        i10 = i19;
                        str = CodecSpecificDataUtil.c(h2.f9680a, h2.f9681b, h2.f9682c, h2.f9683d, h2.f9687h, h2.f9688i);
                        int i23 = i22;
                        i15 = i21;
                        i14 = i20;
                        f3 = f4;
                        i16 = i23;
                    } else {
                        i3 = L3;
                        i2 = R3;
                    }
                    i9 = length + R4;
                    parsableByteArray2.Z(R4);
                    i17++;
                    L2 = i18;
                    L3 = i3;
                    R3 = i2;
                    i4 = 0;
                }
                int i24 = L2;
                i8++;
                i4 = 0;
            }
            return new HevcConfig(i5 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), L + 1, i10, i11, i12, i13, i14, i15, i16, f3, str);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ParserException.a("Error parsing HEVC config", e2);
        }
    }
}
