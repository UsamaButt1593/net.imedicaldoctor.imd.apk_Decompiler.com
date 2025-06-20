package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.container.NalUnitUtil;
import java.util.ArrayList;
import java.util.List;

@UnstableApi
public final class AvcConfig {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f12924a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12925b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12926c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12927d;

    /* renamed from: e  reason: collision with root package name */
    public final int f12928e;

    /* renamed from: f  reason: collision with root package name */
    public final int f12929f;

    /* renamed from: g  reason: collision with root package name */
    public final int f12930g;

    /* renamed from: h  reason: collision with root package name */
    public final int f12931h;

    /* renamed from: i  reason: collision with root package name */
    public final int f12932i;

    /* renamed from: j  reason: collision with root package name */
    public final float f12933j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final String f12934k;

    private AvcConfig(List<byte[]> list, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f2, @Nullable String str) {
        this.f12924a = list;
        this.f12925b = i2;
        this.f12926c = i3;
        this.f12927d = i4;
        this.f12928e = i5;
        this.f12929f = i6;
        this.f12930g = i7;
        this.f12931h = i8;
        this.f12932i = i9;
        this.f12933j = f2;
        this.f12934k = str;
    }

    private static byte[] a(ParsableByteArray parsableByteArray) {
        int R = parsableByteArray.R();
        int f2 = parsableByteArray.f();
        parsableByteArray.Z(R);
        return CodecSpecificDataUtil.d(parsableByteArray.e(), f2, R);
    }

    public static AvcConfig b(ParsableByteArray parsableByteArray) throws ParserException {
        String str;
        float f2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        try {
            parsableByteArray.Z(4);
            int L = (parsableByteArray.L() & 3) + 1;
            if (L != 3) {
                ArrayList arrayList = new ArrayList();
                int L2 = parsableByteArray.L() & 31;
                for (int i9 = 0; i9 < L2; i9++) {
                    arrayList.add(a(parsableByteArray));
                }
                int L3 = parsableByteArray.L();
                for (int i10 = 0; i10 < L3; i10++) {
                    arrayList.add(a(parsableByteArray));
                }
                if (L2 > 0) {
                    NalUnitUtil.SpsData l2 = NalUnitUtil.l((byte[]) arrayList.get(0), L, ((byte[]) arrayList.get(0)).length);
                    int i11 = l2.f9702f;
                    int i12 = l2.f9703g;
                    int i13 = l2.q;
                    int i14 = l2.r;
                    int i15 = l2.s;
                    float f3 = l2.f9704h;
                    str = CodecSpecificDataUtil.a(l2.f9697a, l2.f9698b, l2.f9699c);
                    i3 = i14;
                    i2 = i15;
                    f2 = f3;
                    i6 = l2.f9705i + 8;
                    i5 = l2.f9706j + 8;
                    i4 = i13;
                    i8 = i11;
                    i7 = i12;
                } else {
                    str = null;
                    i8 = -1;
                    i7 = -1;
                    i6 = -1;
                    i5 = -1;
                    i4 = -1;
                    i3 = -1;
                    i2 = -1;
                    f2 = 1.0f;
                }
                return new AvcConfig(arrayList, L, i8, i7, i6, i5, i4, i3, i2, f2, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ParserException.a("Error parsing AVC config", e2);
        }
    }
}
