package com.itextpdf.text.pdf.codec;

import androidx.media3.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.InvalidImageException;
import com.itextpdf.text.pdf.ByteBuffer;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import okio.Utf8;

public class TIFFFaxDecoder {
    static int[] p = {0, 1, 3, 7, 15, 31, 63, WorkQueueKt.f29430c, 255};
    static int[] q = {0, 128, PsExtractor.x, 224, PsExtractor.A, 248, 252, TIFFConstants.f26648a, 255};
    static byte[] r = {0, Byte.MIN_VALUE, SignedBytes.f22967a, -64, 32, -96, 96, -32, 16, -112, 80, -48, ByteBuffer.X2, -80, 112, -16, 8, -120, 72, -56, 40, -88, 104, -24, Ascii.B, -104, 88, -40, 56, -72, 120, -8, 4, -124, 68, -60, 36, -92, 100, -28, Ascii.x, -108, 84, -44, 52, -76, 116, -12, 12, -116, 76, -52, 44, -84, 108, -20, Ascii.F, -100, 92, -36, DocWriter.b3, -68, 124, -4, 2, -126, 66, -62, DocWriter.e3, -94, 98, -30, 18, -110, 82, -46, 50, -78, 114, -14, 10, -118, 74, -54, 42, -86, 106, -22, Ascii.D, -102, 90, -38, 58, -70, 122, -6, 6, -122, 70, -58, 38, -90, 102, -26, Ascii.z, -106, 86, -42, 54, -74, 118, -10, 14, -114, 78, -50, 46, -82, 110, -18, Ascii.H, -98, 94, -34, DocWriter.f3, -66, 126, -2, 1, -127, 65, -63, 33, -95, 97, -31, 17, -111, 81, -47, 49, -79, 113, -15, 9, -119, 73, -55, 41, -87, 105, -23, Ascii.C, -103, 89, -39, 57, -71, 121, -7, 5, -123, 69, -59, 37, -91, 101, -27, Ascii.y, -107, 85, -43, 53, -75, 117, -11, 13, -115, 77, -51, 45, -83, 109, -19, Ascii.G, -99, 93, -35, 61, -67, 125, -3, 3, -125, 67, -61, 35, -93, 99, -29, 19, -109, 83, -45, 51, -77, 115, -13, 11, -117, 75, -53, 43, -85, 107, -21, Ascii.E, -101, 91, -37, 59, -69, 123, -5, 7, -121, 71, -57, 39, -89, 103, -25, Ascii.A, -105, 87, -41, 55, -73, 119, -9, 15, -113, 79, -49, DocWriter.g3, -81, 111, -17, Ascii.I, -97, 95, -33, Utf8.f31404a, -65, Byte.MAX_VALUE, -1};
    static short[] s = {6430, 6400, 6400, 6400, 3225, 3225, 3225, 3225, 944, 944, 944, 944, 976, 976, 976, 976, 1456, 1456, 1456, 1456, 1488, 1488, 1488, 1488, 718, 718, 718, 718, 718, 718, 718, 718, 750, 750, 750, 750, 750, 750, 750, 750, 1520, 1520, 1520, 1520, 1552, 1552, 1552, 1552, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 654, 654, 654, 654, 654, 654, 654, 654, 1072, 1072, 1072, 1072, 1104, 1104, 1104, 1104, 1136, 1136, 1136, 1136, 1168, 1168, 1168, 1168, 1200, 1200, 1200, 1200, 1232, 1232, 1232, 1232, 622, 622, 622, 622, 622, 622, 622, 622, 1008, 1008, 1008, 1008, 1040, 1040, 1040, 1040, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 1712, 1712, 1712, 1712, 1744, 1744, 1744, 1744, 846, 846, 846, 846, 846, 846, 846, 846, 1264, 1264, 1264, 1264, 1296, 1296, 1296, 1296, 1328, 1328, 1328, 1328, 1360, 1360, 1360, 1360, 1392, 1392, 1392, 1392, 1424, 1424, 1424, 1424, 686, 686, 686, 686, 686, 686, 686, 686, 910, 910, 910, 910, 910, 910, 910, 910, 1968, 1968, 1968, 1968, 2000, 2000, 2000, 2000, 2032, 2032, 2032, 2032, 16, 16, 16, 16, 10257, 10257, 10257, 10257, 12305, 12305, 12305, 12305, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 878, 878, 878, 878, 878, 878, 878, 878, 1904, 1904, 1904, 1904, 1936, 1936, 1936, 1936, -18413, -18413, -16365, -16365, -14317, -14317, -10221, -10221, 590, 590, 590, 590, 590, 590, 590, 590, 782, 782, 782, 782, 782, 782, 782, 782, 1584, 1584, 1584, 1584, 1616, 1616, 1616, 1616, 1648, 1648, 1648, 1648, 1680, 1680, 1680, 1680, 814, 814, 814, 814, 814, 814, 814, 814, 1776, 1776, 1776, 1776, 1808, 1808, 1808, 1808, 1840, 1840, 1840, 1840, 1872, 1872, 1872, 1872, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, 14353, 14353, 14353, 14353, 16401, 16401, 16401, 16401, 22547, 22547, 24595, 24595, 20497, 20497, 20497, 20497, 18449, 18449, 18449, 18449, 26643, 26643, 28691, 28691, 30739, 30739, -32749, -32749, -30701, -30701, -28653, -28653, -26605, -26605, -24557, -24557, -22509, -22509, -20461, -20461, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232};
    static short[] t = {28679, 28679, 31752, -32759, -31735, -30711, -29687, -28663, 29703, 29703, 30727, 30727, -27639, -26615, -25591, -24567};
    static short[] u = {3226, 6412, 200, 168, 38, 38, 134, 134, 100, 100, 100, 100, 68, 68, 68, 68};
    static short[] v = {292, 260, 226, 226};
    static short[] w = {62, 62, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 588, 588, 588, 588, 588, 588, 588, 588, 1680, 1680, 20499, 22547, 24595, 26643, 1776, 1776, 1808, 1808, -24557, -22509, -20461, -18413, 1904, 1904, 1936, 1936, -16365, -14317, 782, 782, 782, 782, 814, 814, 814, 814, -12269, -10221, 10257, 10257, 12305, 12305, 14353, 14353, 16403, 18451, 1712, 1712, 1744, 1744, 28691, 30739, -32749, -30701, -28653, -26605, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 750, 750, 750, 750, 1616, 1616, 1648, 1648, 1424, 1424, 1456, 1456, 1488, 1488, 1520, 1520, 1840, 1840, 1872, 1872, 1968, 1968, 8209, 8209, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 1552, 1552, 1584, 1584, 2000, 2000, 2032, 2032, 976, 976, 1008, 1008, 1040, 1040, 1072, 1072, 1296, 1296, 1328, 1328, 718, 718, 718, 718, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 4113, 4113, 6161, 6161, 848, 848, 880, 880, 912, 912, 944, 944, 622, 622, 622, 622, 654, 654, 654, 654, 1104, 1104, 1136, 1136, 1168, 1168, 1200, 1200, 1232, 1232, 1264, 1264, 686, 686, 686, 686, 1360, 1360, 1392, 1392, 12, 12, 12, 12, 12, 12, 12, 12, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390};
    static byte[] x = {80, 88, Ascii.A, 71, Ascii.H, Ascii.H, DocWriter.f3, DocWriter.f3, 4, 4, 4, 4, 4, 4, 4, 4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41};

    /* renamed from: a  reason: collision with root package name */
    private int f26662a;

    /* renamed from: b  reason: collision with root package name */
    private int f26663b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f26664c;

    /* renamed from: d  reason: collision with root package name */
    private int f26665d;

    /* renamed from: e  reason: collision with root package name */
    private int f26666e;

    /* renamed from: f  reason: collision with root package name */
    private long f26667f;

    /* renamed from: g  reason: collision with root package name */
    private int f26668g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int[] f26669h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f26670i;

    /* renamed from: j  reason: collision with root package name */
    private int f26671j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f26672k = 2;

    /* renamed from: l  reason: collision with root package name */
    private int f26673l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f26674m = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f26675n;
    private boolean o;

    public TIFFFaxDecoder(long j2, int i2, int i3) {
        this.f26667f = j2;
        this.f26665d = i2;
        this.f26666e = i3;
        this.f26662a = 0;
        this.f26663b = 0;
        int i4 = i2 * 2;
        this.f26669h = new int[i4];
        this.f26670i = new int[i4];
    }

    private boolean a() {
        if (this.f26662a != 0) {
            this.f26663b++;
            this.f26662a = 0;
        }
        return true;
    }

    private int d() {
        boolean z = false;
        int i2 = 0;
        while (!z) {
            short s2 = u[i(4)];
            int i3 = (s2 >>> 1) & 15;
            int i4 = (s2 >>> 5) & 2047;
            if (i4 == 100) {
                short s3 = w[j(9)];
                short s4 = s3 & 1;
                int i5 = (s3 >>> 1) & 15;
                int i6 = (s3 >>> 5) & 2047;
                if (i5 == 12) {
                    o(5);
                    short s5 = t[i(4)];
                    i2 += (s5 >>> 4) & 4095;
                    o(4 - ((s5 >>> 1) & 7));
                } else if (i5 != 15) {
                    i2 += i6;
                    o(9 - i5);
                    if (s4 != 0) {
                    }
                } else {
                    throw new RuntimeException(MessageLocalization.b("eol.code.word.encountered.in.black.run", new Object[0]));
                }
            } else if (i4 == 200) {
                short s6 = v[i(2)];
                i2 += (s6 >>> 5) & 2047;
                o(2 - ((s6 >>> 1) & 15));
            } else {
                i2 += i4;
                o(4 - i3);
            }
            z = true;
        }
        return i2;
    }

    private int g() {
        boolean z = true;
        int i2 = 0;
        while (z) {
            int j2 = j(10);
            short s2 = s[j2];
            short s3 = s2 & 1;
            int i3 = (s2 >>> 1) & 15;
            if (i3 == 12) {
                short s4 = t[((j2 << 2) & 12) | i(2)];
                i2 += (s4 >>> 4) & 4095;
                o(4 - ((s4 >>> 1) & 7));
            } else if (i3 != 0) {
                if (i3 != 15) {
                    i2 += (s2 >>> 5) & 2047;
                    o(10 - i3);
                    if (s3 != 0) {
                    }
                } else if (i2 != 0) {
                    throw new RuntimeException(MessageLocalization.b("eol.code.word.encountered.in.white.run", new Object[0]));
                }
                z = false;
            } else {
                throw new InvalidImageException(MessageLocalization.b("invalid.code.encountered", new Object[0]));
            }
        }
        return i2;
    }

    private void h(int i2, boolean z, int[] iArr) {
        int[] iArr2 = this.f26669h;
        int i3 = this.f26668g;
        int i4 = this.f26671j;
        int i5 = i4 > 0 ? i4 - 1 : 0;
        int i6 = z ? i5 & -2 : i5 | 1;
        while (true) {
            if (i6 >= i3) {
                break;
            }
            int i7 = iArr2[i6];
            if (i7 > i2) {
                this.f26671j = i6;
                iArr[0] = i7;
                break;
            }
            i6 += 2;
        }
        int i8 = i6 + 1;
        if (i8 < i3) {
            iArr[1] = iArr2[i8];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int i(int r10) {
        /*
            r9 = this;
            byte[] r0 = r9.f26664c
            int r1 = r0.length
            int r1 = r1 + -1
            int r2 = r9.f26663b
            long r3 = r9.f26667f
            r5 = 1
            r7 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x001b
            byte r3 = r0[r2]
            if (r2 != r1) goto L_0x0016
        L_0x0014:
            r0 = 0
            goto L_0x0040
        L_0x0016:
            int r1 = r2 + 1
            byte r0 = r0[r1]
            goto L_0x0040
        L_0x001b:
            r5 = 2
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x0075
            boolean r3 = r9.o
            if (r3 == 0) goto L_0x002b
            int r3 = r0.length
            if (r2 < r3) goto L_0x002b
            r0 = 0
            r3 = 0
            goto L_0x0040
        L_0x002b:
            byte[] r3 = r
            byte r4 = r0[r2]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = r3[r4]
            if (r2 != r1) goto L_0x0037
            r3 = r4
            goto L_0x0014
        L_0x0037:
            int r1 = r2 + 1
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r3[r0]
            r3 = r4
        L_0x0040:
            int r1 = r9.f26662a
            int r4 = 8 - r1
            int r5 = r10 - r4
            int r6 = r4 - r10
            if (r6 < 0) goto L_0x005e
            int[] r0 = p
            r0 = r0[r4]
            r0 = r0 & r3
            int r0 = r0 >>> r6
            int r1 = r1 + r10
            r9.f26662a = r1
            r10 = 8
            if (r1 != r10) goto L_0x0074
            r9.f26662a = r7
            int r2 = r2 + 1
            r9.f26663b = r2
            goto L_0x0074
        L_0x005e:
            int[] r10 = p
            r10 = r10[r4]
            r10 = r10 & r3
            int r1 = -r6
            int r10 = r10 << r1
            int[] r1 = q
            r1 = r1[r5]
            r0 = r0 & r1
            int r1 = 8 - r5
            int r0 = r0 >>> r1
            r0 = r0 | r10
            int r2 = r2 + 1
            r9.f26663b = r2
            r9.f26662a = r5
        L_0x0074:
            return r0
        L_0x0075:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r0 = "tiff.fill.order.tag.must.be.either.1.or.2"
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r0, r1)
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFFaxDecoder.i(int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int j(int r12) {
        /*
            r11 = this;
            byte[] r0 = r11.f26664c
            int r1 = r0.length
            int r1 = r1 + -1
            int r2 = r11.f26663b
            long r3 = r11.f26667f
            r5 = 1
            r7 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x0028
            byte r3 = r0[r2]
            if (r2 != r1) goto L_0x0017
        L_0x0014:
            r0 = 0
        L_0x0015:
            r1 = 0
            goto L_0x0056
        L_0x0017:
            int r4 = r2 + 1
            if (r4 != r1) goto L_0x001e
            byte r0 = r0[r4]
            goto L_0x0015
        L_0x001e:
            byte r1 = r0[r4]
            int r4 = r2 + 2
            byte r0 = r0[r4]
        L_0x0024:
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x0056
        L_0x0028:
            r5 = 2
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x0097
            byte[] r3 = r
            byte r4 = r0[r2]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = r3[r4]
            if (r2 != r1) goto L_0x003a
            r3 = r4
            goto L_0x0014
        L_0x003a:
            int r5 = r2 + 1
            if (r5 != r1) goto L_0x0046
            byte r0 = r0[r5]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r3[r0]
            r3 = r4
            goto L_0x0015
        L_0x0046:
            byte r1 = r0[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = r3[r1]
            int r5 = r2 + 2
            byte r0 = r0[r5]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r3[r0]
            r3 = r4
            goto L_0x0024
        L_0x0056:
            int r4 = r11.f26662a
            r5 = 8
            int r4 = 8 - r4
            int r12 = r12 - r4
            if (r12 <= r5) goto L_0x0064
            int r6 = r12 + -8
            r8 = 8
            goto L_0x0066
        L_0x0064:
            r8 = r12
            r6 = 0
        L_0x0066:
            int r9 = r2 + 1
            r11.f26663b = r9
            int[] r9 = p
            r4 = r9[r4]
            r3 = r3 & r4
            int r12 = r3 << r12
            int[] r3 = q
            r4 = r3[r8]
            r0 = r0 & r4
            int r4 = 8 - r8
            int r0 = r0 >>> r4
            if (r6 == 0) goto L_0x008a
            int r0 = r0 << r6
            r3 = r3[r6]
            r1 = r1 & r3
            int r3 = 8 - r6
            int r1 = r1 >>> r3
            r0 = r0 | r1
            int r2 = r2 + 2
            r11.f26663b = r2
            r11.f26662a = r6
            goto L_0x0095
        L_0x008a:
            if (r8 != r5) goto L_0x0093
            r11.f26662a = r7
            int r2 = r2 + 2
            r11.f26663b = r2
            goto L_0x0095
        L_0x0093:
            r11.f26662a = r8
        L_0x0095:
            r12 = r12 | r0
            return r12
        L_0x0097:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.String r0 = "tiff.fill.order.tag.must.be.either.1.or.2"
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r0, r1)
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFFaxDecoder.j(int):int");
    }

    private int k(boolean z) {
        int j2;
        int i2 = this.f26674m;
        if (i2 == 0) {
            int j3 = j(12);
            if (z && j3 == 0 && j(4) == 1) {
                this.f26674m = 1;
                return 1;
            } else if (j3 != 1) {
                throw new RuntimeException(MessageLocalization.b("scanline.must.begin.with.eol.code.word", new Object[0]));
            }
        } else if (i2 == 1) {
            int i3 = 8 - this.f26662a;
            if (j(i3) != 0) {
                throw new RuntimeException(MessageLocalization.b("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            } else if (i3 >= 4 || j(8) == 0) {
                do {
                    j2 = j(8);
                    if (j2 != 1) {
                    }
                } while (j2 == 0);
                throw new RuntimeException(MessageLocalization.b("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            } else {
                throw new RuntimeException(MessageLocalization.b("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            }
        }
        if (this.f26675n == 0) {
            return 1;
        }
        return i(1);
    }

    public static void l(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = r[bArr[i2] & 255];
        }
    }

    private void n(byte[] bArr, int i2, int i3, int i4) {
        int i5 = (i2 * 8) + i3;
        int i6 = i4 + i5;
        int i7 = i5 >> 3;
        int i8 = i5 & 7;
        if (i8 > 0) {
            int i9 = 1 << (7 - i8);
            byte b2 = bArr[i7];
            while (i9 > 0 && i5 < i6) {
                b2 = (byte) (b2 | i9);
                i9 >>= 1;
                i5++;
            }
            bArr[i7] = b2;
        }
        int i10 = i5 >> 3;
        while (i5 < i6 - 7) {
            bArr[i10] = -1;
            i5 += 8;
            i10++;
        }
        while (i5 < i6) {
            int i11 = i5 >> 3;
            if (!this.o || i11 < bArr.length) {
                bArr[i11] = (byte) (bArr[i11] | (1 << (7 - (i5 & 7))));
            }
            i5++;
        }
    }

    private void o(int i2) {
        int i3 = this.f26662a - i2;
        if (i3 < 0) {
            this.f26663b--;
            i3 += 8;
        }
        this.f26662a = i3;
    }

    public void b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        this.f26664c = bArr2;
        int i4 = (this.f26665d + 7) / 8;
        this.f26662a = 0;
        this.f26663b = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            e(bArr, i5, i2);
            i5 += i4;
        }
    }

    public void c(byte[] bArr, byte[] bArr2, int i2, int i3, long j2) {
        byte[] bArr3 = bArr;
        int i4 = i2;
        this.f26664c = bArr2;
        this.f26672k = 3;
        boolean z = false;
        this.f26662a = 0;
        this.f26663b = 0;
        int i5 = (this.f26665d + 7) / 8;
        int[] iArr = new int[2];
        this.f26675n = (int) (j2 & 1);
        this.f26673l = (int) ((j2 & 2) >> 1);
        this.f26674m = (int) ((j2 & 4) >> 2);
        if (k(true) == 1) {
            e(bArr3, 0, i4);
            int i6 = i3;
            int i7 = i5;
            int i8 = 1;
            while (i8 < i6) {
                if (k(z) == 0) {
                    int[] iArr2 = this.f26669h;
                    this.f26669h = this.f26670i;
                    this.f26670i = iArr2;
                    this.f26671j = z ? 1 : 0;
                    int i9 = -1;
                    int i10 = i4;
                    boolean z2 = true;
                    int i11 = 0;
                    char c2 = z;
                    while (i10 < this.f26665d) {
                        h(i9, z2, iArr);
                        int i12 = iArr[c2];
                        i9 = iArr[1];
                        byte b2 = x[i(7)];
                        int i13 = (b2 & 120) >>> 3;
                        byte b3 = b2 & 7;
                        if (i13 == 0) {
                            if (!z2) {
                                n(bArr3, i7, i10, i9 - i10);
                            }
                            o(7 - b3);
                            i10 = i9;
                        } else if (i13 == 1) {
                            o(7 - b3);
                            if (z2) {
                                int g2 = i10 + g();
                                int i14 = i11 + 1;
                                this.f26670i[i11] = g2;
                                int d2 = d();
                                n(bArr3, i7, g2, d2);
                                i10 = g2 + d2;
                                i11 += 2;
                                this.f26670i[i14] = i10;
                            } else {
                                int d3 = d();
                                n(bArr3, i7, i10, d3);
                                int i15 = i10 + d3;
                                int i16 = i11 + 1;
                                this.f26670i[i11] = i15;
                                i10 = i15 + g();
                                i11 += 2;
                                this.f26670i[i16] = i10;
                            }
                            i9 = i10;
                        } else if (i13 <= 8) {
                            int i17 = i12 + (i13 - 5);
                            int i18 = i11 + 1;
                            this.f26670i[i11] = i17;
                            if (!z2) {
                                n(bArr3, i7, i10, i17 - i10);
                            }
                            z2 = !z2;
                            o(7 - b3);
                            i9 = i17;
                            i10 = i9;
                            i11 = i18;
                        } else {
                            throw new RuntimeException(MessageLocalization.b("invalid.code.encountered.while.decoding.2d.group.3.compressed.data", new Object[0]));
                        }
                        c2 = 0;
                    }
                    this.f26670i[i11] = i10;
                    this.f26668g = i11 + 1;
                } else {
                    e(bArr3, i7, i4);
                }
                i7 += i5;
                i8++;
                z = false;
            }
            return;
        }
        throw new RuntimeException(MessageLocalization.b("first.scanline.must.be.1d.encoded", new Object[0]));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (r11.f26672k == 2) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x012c, code lost:
        if (r11.f26672k == 2) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(byte[] r12, int r13, int r14) {
        /*
            r11 = this;
            r0 = 0
            r11.f26668g = r0
            r1 = 1
            r2 = 1
        L_0x0005:
            int r3 = r11.f26665d
            if (r14 >= r3) goto L_0x0130
        L_0x0009:
            r3 = 12
            r4 = 2
            r5 = 15
            r6 = 4
            if (r2 == 0) goto L_0x0073
            r7 = 10
            int r7 = r11.j(r7)
            short[] r8 = s
            short r8 = r8[r7]
            r9 = r8 & 1
            int r10 = r8 >>> 1
            r10 = r10 & r5
            if (r10 != r3) goto L_0x003b
            int r4 = r11.i(r4)
            int r5 = r7 << 2
            r3 = r3 & r5
            r3 = r3 | r4
            short[] r4 = t
            short r3 = r4[r3]
            int r4 = r3 >>> 1
            r4 = r4 & 7
            int r3 = r3 >>> r6
            r3 = r3 & 4095(0xfff, float:5.738E-42)
            int r14 = r14 + r3
            int r6 = r6 - r4
            r11.o(r6)
            goto L_0x0009
        L_0x003b:
            if (r10 == 0) goto L_0x0065
            if (r10 == r5) goto L_0x0057
            int r3 = r8 >>> 5
            r3 = r3 & 2047(0x7ff, float:2.868E-42)
            int r14 = r14 + r3
            int r3 = 10 - r10
            r11.o(r3)
            if (r9 != 0) goto L_0x0009
            int[] r2 = r11.f26670i
            int r3 = r11.f26668g
            int r4 = r3 + 1
            r11.f26668g = r4
            r2[r3] = r14
            r2 = 0
            goto L_0x0009
        L_0x0057:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.String r13 = "eol.code.word.encountered.in.white.run"
            java.lang.Object[] r14 = new java.lang.Object[r0]
            java.lang.String r13 = com.itextpdf.text.error_messages.MessageLocalization.b(r13, r14)
            r12.<init>(r13)
            throw r12
        L_0x0065:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.String r13 = "invalid.code.encountered"
            java.lang.Object[] r14 = new java.lang.Object[r0]
            java.lang.String r13 = com.itextpdf.text.error_messages.MessageLocalization.b(r13, r14)
            r12.<init>(r13)
            throw r12
        L_0x0073:
            int r7 = r11.f26665d
            if (r14 != r7) goto L_0x0080
            int r12 = r11.f26672k
            if (r12 != r4) goto L_0x0130
        L_0x007b:
            r11.a()
            goto L_0x0130
        L_0x0080:
            if (r2 != 0) goto L_0x0126
            int r7 = r11.i(r6)
            short[] r8 = u
            short r7 = r8[r7]
            int r8 = r7 >>> 1
            r8 = r8 & r5
            r9 = 5
            int r7 = r7 >>> r9
            r7 = r7 & 2047(0x7ff, float:2.868E-42)
            r10 = 100
            if (r7 != r10) goto L_0x00ec
            r7 = 9
            int r7 = r11.j(r7)
            short[] r8 = w
            short r7 = r8[r7]
            r8 = r7 & 1
            int r10 = r7 >>> 1
            r10 = r10 & r5
            int r7 = r7 >>> r9
            r7 = r7 & 2047(0x7ff, float:2.868E-42)
            if (r10 != r3) goto L_0x00c5
            r11.o(r9)
            int r7 = r11.i(r6)
            short[] r8 = t
            short r7 = r8[r7]
            int r8 = r7 >>> 1
            r8 = r8 & 7
            int r7 = r7 >>> r6
            r7 = r7 & 4095(0xfff, float:5.738E-42)
            r11.n(r12, r13, r14, r7)
            int r14 = r14 + r7
            int r7 = 4 - r8
            r11.o(r7)
            goto L_0x0080
        L_0x00c5:
            if (r10 == r5) goto L_0x00de
            r11.n(r12, r13, r14, r7)
            int r14 = r14 + r7
            int r7 = 9 - r10
            r11.o(r7)
            if (r8 != 0) goto L_0x0080
            int[] r2 = r11.f26670i
            int r7 = r11.f26668g
            int r8 = r7 + 1
            r11.f26668g = r8
            r2[r7] = r14
        L_0x00dc:
            r2 = 1
            goto L_0x0080
        L_0x00de:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.String r13 = "eol.code.word.encountered.in.black.run"
            java.lang.Object[] r14 = new java.lang.Object[r0]
            java.lang.String r13 = com.itextpdf.text.error_messages.MessageLocalization.b(r13, r14)
            r12.<init>(r13)
            throw r12
        L_0x00ec:
            r2 = 200(0xc8, float:2.8E-43)
            if (r7 != r2) goto L_0x0112
            int r2 = r11.i(r4)
            short[] r7 = v
            short r2 = r7[r2]
            int r7 = r2 >>> 5
            r7 = r7 & 2047(0x7ff, float:2.868E-42)
            int r2 = r2 >>> r1
            r2 = r2 & r5
            r11.n(r12, r13, r14, r7)
            int r14 = r14 + r7
            int r2 = 2 - r2
            r11.o(r2)
            int[] r2 = r11.f26670i
            int r7 = r11.f26668g
            int r8 = r7 + 1
            r11.f26668g = r8
            r2[r7] = r14
            goto L_0x00dc
        L_0x0112:
            r11.n(r12, r13, r14, r7)
            int r14 = r14 + r7
            int r2 = 4 - r8
            r11.o(r2)
            int[] r2 = r11.f26670i
            int r7 = r11.f26668g
            int r8 = r7 + 1
            r11.f26668g = r8
            r2[r7] = r14
            goto L_0x00dc
        L_0x0126:
            int r3 = r11.f26665d
            if (r14 != r3) goto L_0x0005
            int r12 = r11.f26672k
            if (r12 != r4) goto L_0x0130
            goto L_0x007b
        L_0x0130:
            int[] r12 = r11.f26670i
            int r13 = r11.f26668g
            int r0 = r13 + 1
            r11.f26668g = r0
            r12[r13] = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFFaxDecoder.e(byte[], int, int):void");
    }

    public void f(byte[] bArr, byte[] bArr2, int i2, int i3, long j2) {
        int i4;
        int i5;
        boolean z;
        byte[] bArr3 = bArr;
        this.f26664c = bArr2;
        this.f26672k = 4;
        int i6 = 0;
        this.f26662a = 0;
        this.f26663b = 0;
        int i7 = this.f26665d;
        int i8 = (i7 + 7) / 8;
        int[] iArr = new int[2];
        char c2 = 1;
        this.f26673l = (int) ((j2 & 2) >> 1);
        int[] iArr2 = this.f26670i;
        this.f26668g = 1;
        iArr2[0] = i7;
        this.f26668g = 1 + 1;
        iArr2[1] = i7;
        int i9 = i3;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int[] iArr3 = this.f26669h;
            this.f26669h = this.f26670i;
            this.f26670i = iArr3;
            this.f26671j = i4;
            int i12 = -1;
            int i13 = i2;
            int i14 = 0;
            boolean z2 = true;
            while (i13 < this.f26665d && this.f26663b < this.f26664c.length) {
                h(i12, z2, iArr);
                int i15 = iArr[i4];
                int i16 = iArr[c2];
                byte b2 = x[i(7)];
                int i17 = (b2 & 120) >>> 3;
                byte b3 = b2 & 7;
                if (i17 == 0) {
                    if (!z2) {
                        n(bArr3, i11, i13, i16 - i13);
                    }
                    o(7 - b3);
                    int i18 = i3;
                    i12 = i16;
                } else {
                    if (i17 == 1) {
                        o(7 - b3);
                        if (z2) {
                            int g2 = i13 + g();
                            int i19 = i14 + 1;
                            iArr3[i14] = g2;
                            int d2 = d();
                            n(bArr3, i11, g2, d2);
                            i13 = g2 + d2;
                            i14 += 2;
                            iArr3[i19] = i13;
                        } else {
                            int d3 = d();
                            n(bArr3, i11, i13, d3);
                            int i20 = i13 + d3;
                            int i21 = i14 + 1;
                            iArr3[i14] = i20;
                            i13 = i20 + g();
                            i14 += 2;
                            iArr3[i21] = i13;
                        }
                        int i22 = i3;
                        i12 = i13;
                    } else if (i17 <= 8) {
                        i12 = i15 + (i17 - 5);
                        int i23 = i14 + 1;
                        iArr3[i14] = i12;
                        if (!z2) {
                            n(bArr3, i11, i13, i12 - i13);
                        }
                        z2 = !z2;
                        o(7 - b3);
                        int i24 = i3;
                        i14 = i23;
                    } else if (i17 != 11) {
                        c2 = 1;
                        i13 = this.f26665d;
                        o(7 - b3);
                        int i25 = i3;
                        i4 = 0;
                    } else if (i(3) == 7) {
                        boolean z3 = false;
                        int i26 = 0;
                        while (!z3) {
                            while (i(1) != 1) {
                                i26++;
                            }
                            if (i26 > 5) {
                                i26 -= 6;
                                if (!z2 && i26 > 0) {
                                    iArr3[i14] = i13;
                                    i14++;
                                }
                                i13 += i26;
                                if (i26 > 0) {
                                    z2 = true;
                                }
                                if (i(1) == 0) {
                                    if (!z2) {
                                        iArr3[i14] = i13;
                                        i14++;
                                    }
                                    z = true;
                                } else {
                                    if (z2) {
                                        iArr3[i14] = i13;
                                        i14++;
                                    }
                                    z = false;
                                }
                                z2 = z;
                                z3 = true;
                            }
                            if (i26 == 5) {
                                if (!z2) {
                                    iArr3[i14] = i13;
                                    i14++;
                                }
                                i5 = i13 + i26;
                                z2 = true;
                            } else {
                                int i27 = i13 + i26;
                                iArr3[i14] = i27;
                                n(bArr3, i11, i27, 1);
                                i5 = i27 + 1;
                                i14++;
                                z2 = false;
                            }
                        }
                        int i28 = i3;
                    } else {
                        throw new InvalidImageException(MessageLocalization.b("invalid.code.encountered.while.decoding.2d.group.4.compressed.data", new Object[0]));
                    }
                    i4 = 0;
                    c2 = 1;
                }
                i13 = i12;
                i4 = 0;
                c2 = 1;
            }
            if (i14 < iArr3.length) {
                iArr3[i14] = i13;
                i14++;
            }
            this.f26668g = i14;
            i11 += i8;
            i10++;
            i9 = i3;
            i6 = 0;
        }
    }

    public void m(boolean z) {
        this.o = z;
    }
}
