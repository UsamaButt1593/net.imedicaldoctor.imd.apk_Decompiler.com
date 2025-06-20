package androidx.media3.extractor;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import androidx.media3.extractor.metadata.vorbis.VorbisComment;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UnstableApi
public final class VorbisUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13150a = "VorbisUtil";

    public static final class CommentHeader {

        /* renamed from: a  reason: collision with root package name */
        public final String f13151a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f13152b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13153c;

        public CommentHeader(String str, String[] strArr, int i2) {
            this.f13151a = str;
            this.f13152b = strArr;
            this.f13153c = i2;
        }
    }

    public static final class Mode {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f13154a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13155b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13156c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13157d;

        public Mode(boolean z, int i2, int i3, int i4) {
            this.f13154a = z;
            this.f13155b = i2;
            this.f13156c = i3;
            this.f13157d = i4;
        }
    }

    public static final class VorbisIdHeader {

        /* renamed from: a  reason: collision with root package name */
        public final int f13158a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13159b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13160c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13161d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13162e;

        /* renamed from: f  reason: collision with root package name */
        public final int f13163f;

        /* renamed from: g  reason: collision with root package name */
        public final int f13164g;

        /* renamed from: h  reason: collision with root package name */
        public final int f13165h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f13166i;

        /* renamed from: j  reason: collision with root package name */
        public final byte[] f13167j;

        public VorbisIdHeader(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, byte[] bArr) {
            this.f13158a = i2;
            this.f13159b = i3;
            this.f13160c = i4;
            this.f13161d = i5;
            this.f13162e = i6;
            this.f13163f = i7;
            this.f13164g = i8;
            this.f13165h = i9;
            this.f13166i = z;
            this.f13167j = bArr;
        }
    }

    private VorbisUtil() {
    }

    @Nullable
    public static int[] a(int i2) {
        if (i2 == 3) {
            return new int[]{0, 2, 1};
        }
        if (i2 == 5) {
            return new int[]{0, 2, 1, 3, 4};
        }
        if (i2 == 6) {
            return new int[]{0, 2, 1, 5, 3, 4};
        }
        if (i2 == 7) {
            return new int[]{0, 2, 1, 6, 5, 3, 4};
        }
        if (i2 != 8) {
            return null;
        }
        return new int[]{0, 2, 1, 7, 5, 6, 3, 4};
    }

    public static int b(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    private static long c(long j2, long j3) {
        return (long) Math.floor(Math.pow((double) j2, 1.0d / ((double) j3)));
    }

    @Nullable
    public static Metadata d(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            String[] q2 = Util.q2(str, "=");
            if (q2.length != 2) {
                Log.n(f13150a, "Failed to parse Vorbis comment: " + str);
            } else if (q2[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.a(new ParsableByteArray(Base64.decode(q2[1], 0))));
                } catch (RuntimeException e2) {
                    Log.o(f13150a, "Failed to parse vorbis picture", e2);
                }
            } else {
                arrayList.add(new VorbisComment(q2[0], q2[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    public static ImmutableList<byte[]> e(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.Z(1);
        int i2 = 0;
        while (parsableByteArray.a() > 0 && parsableByteArray.k() == 255) {
            i2 += 255;
            parsableByteArray.Z(1);
        }
        int L = i2 + parsableByteArray.L();
        int i3 = 0;
        while (parsableByteArray.a() > 0 && parsableByteArray.k() == 255) {
            i3 += 255;
            parsableByteArray.Z(1);
        }
        int L2 = i3 + parsableByteArray.L();
        byte[] bArr2 = new byte[L];
        int f2 = parsableByteArray.f();
        System.arraycopy(bArr, f2, bArr2, 0, L);
        int i4 = f2 + L + L2;
        int length = bArr.length - i4;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, i4, bArr3, 0, length);
        return ImmutableList.L(bArr2, bArr3);
    }

    private static void f(VorbisBitArray vorbisBitArray) throws ParserException {
        int e2 = vorbisBitArray.e(6) + 1;
        for (int i2 = 0; i2 < e2; i2++) {
            int e3 = vorbisBitArray.e(16);
            if (e3 == 0) {
                vorbisBitArray.h(8);
                vorbisBitArray.h(16);
                vorbisBitArray.h(16);
                vorbisBitArray.h(6);
                vorbisBitArray.h(8);
                int e4 = vorbisBitArray.e(4) + 1;
                for (int i3 = 0; i3 < e4; i3++) {
                    vorbisBitArray.h(8);
                }
            } else if (e3 == 1) {
                int e5 = vorbisBitArray.e(5);
                int[] iArr = new int[e5];
                int i4 = -1;
                for (int i5 = 0; i5 < e5; i5++) {
                    int e6 = vorbisBitArray.e(4);
                    iArr[i5] = e6;
                    if (e6 > i4) {
                        i4 = e6;
                    }
                }
                int i6 = i4 + 1;
                int[] iArr2 = new int[i6];
                for (int i7 = 0; i7 < i6; i7++) {
                    iArr2[i7] = vorbisBitArray.e(3) + 1;
                    int e7 = vorbisBitArray.e(2);
                    if (e7 > 0) {
                        vorbisBitArray.h(8);
                    }
                    for (int i8 = 0; i8 < (1 << e7); i8++) {
                        vorbisBitArray.h(8);
                    }
                }
                vorbisBitArray.h(2);
                int e8 = vorbisBitArray.e(4);
                int i9 = 0;
                int i10 = 0;
                for (int i11 = 0; i11 < e5; i11++) {
                    i9 += iArr2[iArr[i11]];
                    while (i10 < i9) {
                        vorbisBitArray.h(e8);
                        i10++;
                    }
                }
            } else {
                throw ParserException.a("floor type greater than 1 not decodable: " + e3, (Throwable) null);
            }
        }
    }

    private static void g(int i2, VorbisBitArray vorbisBitArray) throws ParserException {
        int e2 = vorbisBitArray.e(6) + 1;
        for (int i3 = 0; i3 < e2; i3++) {
            int e3 = vorbisBitArray.e(16);
            if (e3 != 0) {
                Log.d(f13150a, "mapping type other than 0 not supported: " + e3);
            } else {
                int e4 = vorbisBitArray.d() ? vorbisBitArray.e(4) + 1 : 1;
                if (vorbisBitArray.d()) {
                    int e5 = vorbisBitArray.e(8) + 1;
                    for (int i4 = 0; i4 < e5; i4++) {
                        int i5 = i2 - 1;
                        vorbisBitArray.h(b(i5));
                        vorbisBitArray.h(b(i5));
                    }
                }
                if (vorbisBitArray.e(2) == 0) {
                    if (e4 > 1) {
                        for (int i6 = 0; i6 < i2; i6++) {
                            vorbisBitArray.h(4);
                        }
                    }
                    for (int i7 = 0; i7 < e4; i7++) {
                        vorbisBitArray.h(8);
                        vorbisBitArray.h(8);
                        vorbisBitArray.h(8);
                    }
                } else {
                    throw ParserException.a("to reserved bits must be zero after mapping coupling steps", (Throwable) null);
                }
            }
        }
    }

    private static Mode[] h(VorbisBitArray vorbisBitArray) {
        int e2 = vorbisBitArray.e(6) + 1;
        Mode[] modeArr = new Mode[e2];
        for (int i2 = 0; i2 < e2; i2++) {
            modeArr[i2] = new Mode(vorbisBitArray.d(), vorbisBitArray.e(16), vorbisBitArray.e(16), vorbisBitArray.e(8));
        }
        return modeArr;
    }

    private static void i(VorbisBitArray vorbisBitArray) throws ParserException {
        int e2 = vorbisBitArray.e(6) + 1;
        int i2 = 0;
        while (i2 < e2) {
            if (vorbisBitArray.e(16) <= 2) {
                vorbisBitArray.h(24);
                vorbisBitArray.h(24);
                vorbisBitArray.h(24);
                int e3 = vorbisBitArray.e(6) + 1;
                vorbisBitArray.h(8);
                int[] iArr = new int[e3];
                for (int i3 = 0; i3 < e3; i3++) {
                    iArr[i3] = ((vorbisBitArray.d() ? vorbisBitArray.e(5) : 0) * 8) + vorbisBitArray.e(3);
                }
                for (int i4 = 0; i4 < e3; i4++) {
                    for (int i5 = 0; i5 < 8; i5++) {
                        if ((iArr[i4] & (1 << i5)) != 0) {
                            vorbisBitArray.h(8);
                        }
                    }
                }
                i2++;
            } else {
                throw ParserException.a("residueType greater than 2 is not decodable", (Throwable) null);
            }
        }
    }

    public static CommentHeader j(ParsableByteArray parsableByteArray) throws ParserException {
        return k(parsableByteArray, true, true);
    }

    public static CommentHeader k(ParsableByteArray parsableByteArray, boolean z, boolean z2) throws ParserException {
        if (z) {
            o(3, parsableByteArray, false);
        }
        String I = parsableByteArray.I((int) parsableByteArray.A());
        int length = I.length();
        long A = parsableByteArray.A();
        String[] strArr = new String[((int) A)];
        int i2 = length + 15;
        for (int i3 = 0; ((long) i3) < A; i3++) {
            String I2 = parsableByteArray.I((int) parsableByteArray.A());
            strArr[i3] = I2;
            i2 = i2 + 4 + I2.length();
        }
        if (!z2 || (parsableByteArray.L() & 1) != 0) {
            return new CommentHeader(I, strArr, i2 + 1);
        }
        throw ParserException.a("framing bit expected to be set", (Throwable) null);
    }

    public static VorbisIdHeader l(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z = true;
        o(1, parsableByteArray, false);
        int C = parsableByteArray.C();
        int L = parsableByteArray.L();
        int C2 = parsableByteArray.C();
        int w = parsableByteArray.w();
        if (w <= 0) {
            w = -1;
        }
        int w2 = parsableByteArray.w();
        if (w2 <= 0) {
            w2 = -1;
        }
        int w3 = parsableByteArray.w();
        if (w3 <= 0) {
            w3 = -1;
        }
        int L2 = parsableByteArray.L();
        int pow = (int) Math.pow(2.0d, (double) (L2 & 15));
        int pow2 = (int) Math.pow(2.0d, (double) ((L2 & PsExtractor.A) >> 4));
        if ((parsableByteArray.L() & 1) <= 0) {
            z = false;
        }
        return new VorbisIdHeader(C, L, C2, w, w2, w3, pow, pow2, z, Arrays.copyOf(parsableByteArray.e(), parsableByteArray.g()));
    }

    public static Mode[] m(ParsableByteArray parsableByteArray, int i2) throws ParserException {
        int i3 = 0;
        o(5, parsableByteArray, false);
        int L = parsableByteArray.L() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.e());
        vorbisBitArray.h(parsableByteArray.f() * 8);
        for (int i4 = 0; i4 < L; i4++) {
            n(vorbisBitArray);
        }
        int e2 = vorbisBitArray.e(6) + 1;
        while (i3 < e2) {
            if (vorbisBitArray.e(16) == 0) {
                i3++;
            } else {
                throw ParserException.a("placeholder of time domain transforms not zeroed out", (Throwable) null);
            }
        }
        f(vorbisBitArray);
        i(vorbisBitArray);
        g(i2, vorbisBitArray);
        Mode[] h2 = h(vorbisBitArray);
        if (vorbisBitArray.d()) {
            return h2;
        }
        throw ParserException.a("framing bit after modes not set as expected", (Throwable) null);
    }

    private static void n(VorbisBitArray vorbisBitArray) throws ParserException {
        if (vorbisBitArray.e(24) == 5653314) {
            int e2 = vorbisBitArray.e(16);
            int e3 = vorbisBitArray.e(24);
            int i2 = 0;
            if (!vorbisBitArray.d()) {
                boolean d2 = vorbisBitArray.d();
                while (i2 < e3) {
                    if (!d2 || vorbisBitArray.d()) {
                        vorbisBitArray.h(5);
                    }
                    i2++;
                }
            } else {
                vorbisBitArray.h(5);
                while (i2 < e3) {
                    i2 += vorbisBitArray.e(b(e3 - i2));
                }
            }
            int e4 = vorbisBitArray.e(4);
            if (e4 > 2) {
                throw ParserException.a("lookup type greater than 2 not decodable: " + e4, (Throwable) null);
            } else if (e4 == 1 || e4 == 2) {
                vorbisBitArray.h(32);
                vorbisBitArray.h(32);
                int e5 = vorbisBitArray.e(4) + 1;
                vorbisBitArray.h(1);
                vorbisBitArray.h((int) ((e4 == 1 ? e2 != 0 ? c((long) e3, (long) e2) : 0 : ((long) e2) * ((long) e3)) * ((long) e5)));
            }
        } else {
            throw ParserException.a("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray.c(), (Throwable) null);
        }
    }

    public static boolean o(int i2, ParsableByteArray parsableByteArray, boolean z) throws ParserException {
        if (parsableByteArray.a() < 7) {
            if (z) {
                return false;
            }
            throw ParserException.a("too short header: " + parsableByteArray.a(), (Throwable) null);
        } else if (parsableByteArray.L() != i2) {
            if (z) {
                return false;
            }
            throw ParserException.a("expected header type " + Integer.toHexString(i2), (Throwable) null);
        } else if (parsableByteArray.L() == 118 && parsableByteArray.L() == 111 && parsableByteArray.L() == 114 && parsableByteArray.L() == 98 && parsableByteArray.L() == 105 && parsableByteArray.L() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw ParserException.a("expected characters 'vorbis'", (Throwable) null);
        }
    }
}
