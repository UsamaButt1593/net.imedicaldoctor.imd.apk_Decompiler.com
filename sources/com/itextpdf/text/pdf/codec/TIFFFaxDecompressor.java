package com.itextpdf.text.pdf.codec;

import androidx.media3.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import okio.Utf8;

public class TIFFFaxDecompressor {
    static short[] A = {292, 260, 226, 226};
    static short[] B = {62, 62, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 588, 588, 588, 588, 588, 588, 588, 588, 1680, 1680, 20499, 22547, 24595, 26643, 1776, 1776, 1808, 1808, -24557, -22509, -20461, -18413, 1904, 1904, 1936, 1936, -16365, -14317, 782, 782, 782, 782, 814, 814, 814, 814, -12269, -10221, 10257, 10257, 12305, 12305, 14353, 14353, 16403, 18451, 1712, 1712, 1744, 1744, 28691, 30739, -32749, -30701, -28653, -26605, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 750, 750, 750, 750, 1616, 1616, 1648, 1648, 1424, 1424, 1456, 1456, 1488, 1488, 1520, 1520, 1840, 1840, 1872, 1872, 1968, 1968, 8209, 8209, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 1552, 1552, 1584, 1584, 2000, 2000, 2032, 2032, 976, 976, 1008, 1008, 1040, 1040, 1072, 1072, 1296, 1296, 1328, 1328, 718, 718, 718, 718, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 4113, 4113, 6161, 6161, 848, 848, 880, 880, 912, 912, 944, 944, 622, 622, 622, 622, 654, 654, 654, 654, 1104, 1104, 1136, 1136, 1168, 1168, 1200, 1200, 1232, 1232, 1264, 1264, 686, 686, 686, 686, 1360, 1360, 1392, 1392, 12, 12, 12, 12, 12, 12, 12, 12, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390};
    static byte[] C = {80, 88, Ascii.A, 71, Ascii.H, Ascii.H, DocWriter.f3, DocWriter.f3, 4, 4, 4, 4, 4, 4, 4, 4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41};
    static int[] u = {0, 1, 3, 7, 15, 31, 63, WorkQueueKt.f29430c, 255};
    static int[] v = {0, 128, PsExtractor.x, 224, PsExtractor.A, 248, 252, TIFFConstants.f26648a, 255};
    static byte[] w = {0, Byte.MIN_VALUE, SignedBytes.f22967a, -64, 32, -96, 96, -32, 16, -112, 80, -48, ByteBuffer.X2, -80, 112, -16, 8, -120, 72, -56, 40, -88, 104, -24, Ascii.B, -104, 88, -40, 56, -72, 120, -8, 4, -124, 68, -60, 36, -92, 100, -28, Ascii.x, -108, 84, -44, 52, -76, 116, -12, 12, -116, 76, -52, 44, -84, 108, -20, Ascii.F, -100, 92, -36, DocWriter.b3, -68, 124, -4, 2, -126, 66, -62, DocWriter.e3, -94, 98, -30, 18, -110, 82, -46, 50, -78, 114, -14, 10, -118, 74, -54, 42, -86, 106, -22, Ascii.D, -102, 90, -38, 58, -70, 122, -6, 6, -122, 70, -58, 38, -90, 102, -26, Ascii.z, -106, 86, -42, 54, -74, 118, -10, 14, -114, 78, -50, 46, -82, 110, -18, Ascii.H, -98, 94, -34, DocWriter.f3, -66, 126, -2, 1, -127, 65, -63, 33, -95, 97, -31, 17, -111, 81, -47, 49, -79, 113, -15, 9, -119, 73, -55, 41, -87, 105, -23, Ascii.C, -103, 89, -39, 57, -71, 121, -7, 5, -123, 69, -59, 37, -91, 101, -27, Ascii.y, -107, 85, -43, 53, -75, 117, -11, 13, -115, 77, -51, 45, -83, 109, -19, Ascii.G, -99, 93, -35, 61, -67, 125, -3, 3, -125, 67, -61, 35, -93, 99, -29, 19, -109, 83, -45, 51, -77, 115, -13, 11, -117, 75, -53, 43, -85, 107, -21, Ascii.E, -101, 91, -37, 59, -69, 123, -5, 7, -121, 71, -57, 39, -89, 103, -25, Ascii.A, -105, 87, -41, 55, -73, 119, -9, 15, -113, 79, -49, DocWriter.g3, -81, 111, -17, Ascii.I, -97, 95, -33, Utf8.f31404a, -65, Byte.MAX_VALUE, -1};
    static short[] x = {6430, 6400, 6400, 6400, 3225, 3225, 3225, 3225, 944, 944, 944, 944, 976, 976, 976, 976, 1456, 1456, 1456, 1456, 1488, 1488, 1488, 1488, 718, 718, 718, 718, 718, 718, 718, 718, 750, 750, 750, 750, 750, 750, 750, 750, 1520, 1520, 1520, 1520, 1552, 1552, 1552, 1552, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 654, 654, 654, 654, 654, 654, 654, 654, 1072, 1072, 1072, 1072, 1104, 1104, 1104, 1104, 1136, 1136, 1136, 1136, 1168, 1168, 1168, 1168, 1200, 1200, 1200, 1200, 1232, 1232, 1232, 1232, 622, 622, 622, 622, 622, 622, 622, 622, 1008, 1008, 1008, 1008, 1040, 1040, 1040, 1040, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 1712, 1712, 1712, 1712, 1744, 1744, 1744, 1744, 846, 846, 846, 846, 846, 846, 846, 846, 1264, 1264, 1264, 1264, 1296, 1296, 1296, 1296, 1328, 1328, 1328, 1328, 1360, 1360, 1360, 1360, 1392, 1392, 1392, 1392, 1424, 1424, 1424, 1424, 686, 686, 686, 686, 686, 686, 686, 686, 910, 910, 910, 910, 910, 910, 910, 910, 1968, 1968, 1968, 1968, 2000, 2000, 2000, 2000, 2032, 2032, 2032, 2032, 16, 16, 16, 16, 10257, 10257, 10257, 10257, 12305, 12305, 12305, 12305, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 878, 878, 878, 878, 878, 878, 878, 878, 1904, 1904, 1904, 1904, 1936, 1936, 1936, 1936, -18413, -18413, -16365, -16365, -14317, -14317, -10221, -10221, 590, 590, 590, 590, 590, 590, 590, 590, 782, 782, 782, 782, 782, 782, 782, 782, 1584, 1584, 1584, 1584, 1616, 1616, 1616, 1616, 1648, 1648, 1648, 1648, 1680, 1680, 1680, 1680, 814, 814, 814, 814, 814, 814, 814, 814, 1776, 1776, 1776, 1776, 1808, 1808, 1808, 1808, 1840, 1840, 1840, 1840, 1872, 1872, 1872, 1872, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, 14353, 14353, 14353, 14353, 16401, 16401, 16401, 16401, 22547, 22547, 24595, 24595, 20497, 20497, 20497, 20497, 18449, 18449, 18449, 18449, 26643, 26643, 28691, 28691, 30739, 30739, -32749, -32749, -30701, -30701, -28653, -28653, -26605, -26605, -24557, -24557, -22509, -22509, -20461, -20461, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232};
    static short[] y = {28679, 28679, 31752, -32759, -31735, -30711, -29687, -28663, 29703, 29703, 30727, 30727, -27639, -26615, -25591, -24567};
    static short[] z = {3226, 6412, 200, 168, 38, 38, 134, 134, 100, 100, 100, 100, 68, 68, 68, 68};

    /* renamed from: a  reason: collision with root package name */
    protected int f26676a;

    /* renamed from: b  reason: collision with root package name */
    protected int f26677b;

    /* renamed from: c  reason: collision with root package name */
    private int f26678c;

    /* renamed from: d  reason: collision with root package name */
    private int f26679d;

    /* renamed from: e  reason: collision with root package name */
    public int f26680e;

    /* renamed from: f  reason: collision with root package name */
    protected int f26681f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected int f26682g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected int f26683h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f26684i;

    /* renamed from: j  reason: collision with root package name */
    private int f26685j;

    /* renamed from: k  reason: collision with root package name */
    private int f26686k;

    /* renamed from: l  reason: collision with root package name */
    private byte[] f26687l;

    /* renamed from: m  reason: collision with root package name */
    private int f26688m;

    /* renamed from: n  reason: collision with root package name */
    private int f26689n;
    private int o;
    private int p;
    private int q = 0;
    private int[] r;
    private int[] s;
    private int t = 0;

    private int b() {
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            short s2 = z[k(4)];
            int i3 = (s2 >>> 1) & 15;
            int i4 = (s2 >>> 5) & 2047;
            if (i4 == 100) {
                short s3 = B[l(9)];
                short s4 = s3 & 1;
                int i5 = (s3 >>> 1) & 15;
                int i6 = (s3 >>> 5) & 2047;
                if (i5 == 12) {
                    n(5);
                    short s5 = y[k(4)];
                    i2 += (s5 >>> 4) & 4095;
                    n(4 - ((s5 >>> 1) & 7));
                } else if (i5 != 15) {
                    i2 += i6;
                    n(9 - i5);
                    if (s4 != 0) {
                    }
                } else {
                    throw new RuntimeException("Error 2");
                }
            } else if (i4 == 200) {
                short s6 = A[k(2)];
                i2 += (s6 >>> 5) & 2047;
                n(2 - ((s6 >>> 1) & 15));
            } else {
                i2 += i4;
                n(4 - i3);
            }
            z2 = true;
        }
        return i2;
    }

    private int h() {
        boolean z2 = true;
        int i2 = 0;
        while (z2) {
            int l2 = l(10);
            short s2 = x[l2];
            short s3 = s2 & 1;
            int i3 = (s2 >>> 1) & 15;
            if (i3 == 12) {
                short s4 = y[((l2 << 2) & 12) | k(2)];
                i2 += (s4 >>> 4) & 4095;
                n(4 - ((s4 >>> 1) & 7));
            } else if (i3 == 0) {
                throw new RuntimeException("Error 0");
            } else if (i3 != 15) {
                i2 += (s2 >>> 5) & 2047;
                n(10 - i3);
                if (s3 == 0) {
                    z2 = false;
                }
            } else {
                throw new RuntimeException("Error 1");
            }
        }
        return i2;
    }

    private int i() {
        int length = this.f26684i.length * 8;
        int i2 = length - 1;
        int i3 = length - 13;
        int i4 = (this.f26686k * 8) + this.f26685j;
        while (i4 <= i3) {
            int l2 = l(12);
            i4 += 12;
            while (l2 != 1 && i4 < i2) {
                l2 = ((l2 & 2047) << 1) | (1 & k(1));
                i4++;
            }
            if (l2 == 1) {
                if (this.f26683h != 1) {
                    return 1;
                }
                if (i4 < i2) {
                    return k(1);
                }
            }
        }
        throw new RuntimeException();
    }

    private void j(int i2, boolean z2, int[] iArr) {
        int[] iArr2 = this.r;
        int i3 = this.q;
        int i4 = this.t;
        int i5 = i4 > 0 ? i4 - 1 : 0;
        int i6 = z2 ? i5 & -2 : i5 | 1;
        while (true) {
            if (i6 >= i3) {
                break;
            }
            int i7 = iArr2[i6];
            if (i7 > i2) {
                this.t = i6;
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

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int k(int r10) {
        /*
            r9 = this;
            byte[] r0 = r9.f26684i
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            int r3 = r9.f26686k
            int r4 = r9.f26676a
            r5 = 0
            if (r4 != r2) goto L_0x0017
            byte r4 = r0[r3]
            if (r3 != r1) goto L_0x0012
        L_0x0010:
            r0 = 0
            goto L_0x002f
        L_0x0012:
            int r1 = r3 + 1
            byte r0 = r0[r1]
            goto L_0x002f
        L_0x0017:
            r6 = 2
            if (r4 != r6) goto L_0x0062
            byte[] r4 = w
            byte r6 = r0[r3]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = r4[r6]
            if (r3 != r1) goto L_0x0026
            r4 = r6
            goto L_0x0010
        L_0x0026:
            int r1 = r3 + 1
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r4[r0]
            r4 = r6
        L_0x002f:
            int r1 = r9.f26685j
            int r6 = 8 - r1
            int r7 = r10 - r6
            int r8 = r6 - r10
            if (r8 < 0) goto L_0x004c
            int[] r0 = u
            r0 = r0[r6]
            r0 = r0 & r4
            int r0 = r0 >>> r8
            int r1 = r1 + r10
            r9.f26685j = r1
            r10 = 8
            if (r1 != r10) goto L_0x0061
            r9.f26685j = r5
            int r3 = r3 + r2
            r9.f26686k = r3
            goto L_0x0061
        L_0x004c:
            int[] r10 = u
            r10 = r10[r6]
            r10 = r10 & r4
            int r1 = -r8
            int r10 = r10 << r1
            int[] r1 = v
            r1 = r1[r7]
            r0 = r0 & r1
            int r1 = 8 - r7
            int r0 = r0 >>> r1
            r0 = r0 | r10
            int r3 = r3 + r2
            r9.f26686k = r3
            r9.f26685j = r7
        L_0x0061:
            return r0
        L_0x0062:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r0 = "Invalid FillOrder"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFFaxDecompressor.k(int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int l(int r13) {
        /*
            r12 = this;
            byte[] r0 = r12.f26684i
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            int r3 = r12.f26686k
            int r4 = r12.f26676a
            r5 = 2
            r6 = 0
            if (r4 != r2) goto L_0x0025
            byte r2 = r0[r3]
            if (r3 != r1) goto L_0x0014
        L_0x0011:
            r0 = 0
        L_0x0012:
            r1 = 0
            goto L_0x004f
        L_0x0014:
            int r4 = r3 + 1
            if (r4 != r1) goto L_0x001b
            byte r0 = r0[r4]
            goto L_0x0012
        L_0x001b:
            byte r1 = r0[r4]
            int r4 = r3 + 2
            byte r0 = r0[r4]
        L_0x0021:
            r11 = r1
            r1 = r0
            r0 = r11
            goto L_0x004f
        L_0x0025:
            if (r4 != r5) goto L_0x008e
            byte[] r2 = w
            byte r4 = r0[r3]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = r2[r4]
            if (r3 != r1) goto L_0x0033
            r2 = r4
            goto L_0x0011
        L_0x0033:
            int r7 = r3 + 1
            if (r7 != r1) goto L_0x003f
            byte r0 = r0[r7]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r2[r0]
            r2 = r4
            goto L_0x0012
        L_0x003f:
            byte r1 = r0[r7]
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = r2[r1]
            int r7 = r3 + 2
            byte r0 = r0[r7]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r2[r0]
            r2 = r4
            goto L_0x0021
        L_0x004f:
            int r4 = r12.f26685j
            r7 = 8
            int r4 = 8 - r4
            int r13 = r13 - r4
            if (r13 <= r7) goto L_0x005d
            int r8 = r13 + -8
            r9 = 8
            goto L_0x005f
        L_0x005d:
            r9 = r13
            r8 = 0
        L_0x005f:
            int r10 = r3 + 1
            r12.f26686k = r10
            int[] r10 = u
            r4 = r10[r4]
            r2 = r2 & r4
            int r13 = r2 << r13
            int[] r2 = v
            r4 = r2[r9]
            r0 = r0 & r4
            int r4 = 8 - r9
            int r0 = r0 >>> r4
            if (r8 == 0) goto L_0x0082
            int r0 = r0 << r8
            r2 = r2[r8]
            r1 = r1 & r2
            int r2 = 8 - r8
            int r1 = r1 >>> r2
            r0 = r0 | r1
            int r3 = r3 + r5
            r12.f26686k = r3
            r12.f26685j = r8
            goto L_0x008c
        L_0x0082:
            if (r9 != r7) goto L_0x008a
            r12.f26685j = r6
            int r3 = r3 + r5
            r12.f26686k = r3
            goto L_0x008c
        L_0x008a:
            r12.f26685j = r9
        L_0x008c:
            r13 = r13 | r0
            return r13
        L_0x008e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r0 = "Invalid FillOrder"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFFaxDecompressor.l(int):int");
    }

    private void m(int i2, int i3) {
        int i4 = i2 + this.p;
        int i5 = i3 + i4;
        int i6 = i4 >> 3;
        int i7 = i4 & 7;
        if (i7 > 0) {
            int i8 = 1 << (7 - i7);
            byte b2 = this.f26687l[i6];
            while (i8 > 0 && i4 < i5) {
                b2 = (byte) (b2 | i8);
                i8 >>= 1;
                i4++;
            }
            this.f26687l[i6] = b2;
        }
        int i9 = i4 >> 3;
        while (i4 < i5 - 7) {
            this.f26687l[i9] = -1;
            i4 += 8;
            i9++;
        }
        while (i4 < i5) {
            int i10 = i4 >> 3;
            byte[] bArr = this.f26687l;
            bArr[i10] = (byte) (bArr[i10] | (1 << (7 - (i4 & 7))));
            i4++;
        }
    }

    private void n(int i2) {
        if (i2 > 8) {
            this.f26686k -= i2 / 8;
            i2 %= 8;
        }
        int i3 = this.f26685j - i2;
        if (i3 < 0) {
            this.f26686k--;
            i3 += 8;
        }
        this.f26685j = i3;
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f26676a = i2;
        this.f26677b = i3;
        this.f26678c = i4;
        this.f26679d = i5;
        this.f26683h = i4 & 1;
        this.f26681f = (i4 & 2) >> 1;
        this.f26682g = (i4 & 4) >> 2;
    }

    public void c() {
        this.q = 0;
        int i2 = 0;
        boolean z2 = true;
        while (true) {
            if (i2 >= this.f26688m) {
                break;
            }
            int i3 = i2;
            while (z2 && i3 < this.f26688m) {
                int l2 = l(10);
                short s2 = x[l2];
                short s3 = s2 & 1;
                int i4 = (s2 >>> 1) & 15;
                if (i4 == 12) {
                    short s4 = y[(12 & (l2 << 2)) | k(2)];
                    i3 += (s4 >>> 4) & 4095;
                    n(4 - ((s4 >>> 1) & 7));
                } else if (i4 == 0) {
                    this.f26680e++;
                } else if (i4 == 15) {
                    this.f26680e++;
                    return;
                } else {
                    i3 += (s2 >>> 5) & 2047;
                    n(10 - i4);
                    if (s3 == 0) {
                        int[] iArr = this.s;
                        int i5 = this.q;
                        this.q = i5 + 1;
                        iArr[i5] = i3;
                        z2 = false;
                    }
                }
            }
            if (i3 == this.f26688m) {
                int i6 = i3 - i2;
                if (z2 && i6 != 0 && i6 % 64 == 0 && l(8) != 53) {
                    this.f26680e++;
                    n(8);
                }
                i2 = i3;
            } else {
                i2 = i3;
                while (!z2 && i2 < this.f26688m) {
                    short s5 = z[k(4)];
                    int i7 = (s5 >>> 1) & 15;
                    int i8 = (s5 >>> 5) & 2047;
                    if (i8 == 100) {
                        short s6 = B[l(9)];
                        short s7 = s6 & 1;
                        int i9 = (s6 >>> 1) & 15;
                        int i10 = (s6 >>> 5) & 2047;
                        if (i9 == 12) {
                            n(5);
                            short s8 = y[k(4)];
                            int i11 = (s8 >>> 4) & 4095;
                            m(i2, i11);
                            i2 += i11;
                            n(4 - ((s8 >>> 1) & 7));
                        } else if (i9 == 15) {
                            this.f26680e++;
                            return;
                        } else {
                            m(i2, i10);
                            i2 += i10;
                            n(9 - i9);
                            if (s7 == 0) {
                                int[] iArr2 = this.s;
                                int i12 = this.q;
                                this.q = i12 + 1;
                                iArr2[i12] = i2;
                            }
                        }
                    } else if (i8 == 200) {
                        short s9 = A[k(2)];
                        int i13 = (s9 >>> 5) & 2047;
                        m(i2, i13);
                        i2 += i13;
                        n(2 - ((s9 >>> 1) & 15));
                        int[] iArr3 = this.s;
                        int i14 = this.q;
                        this.q = i14 + 1;
                        iArr3[i14] = i2;
                    } else {
                        m(i2, i8);
                        i2 += i8;
                        n(4 - i7);
                        int[] iArr4 = this.s;
                        int i15 = this.q;
                        this.q = i15 + 1;
                        iArr4[i15] = i2;
                    }
                    z2 = true;
                }
                if (i2 == this.f26688m) {
                    int i16 = i2 - i3;
                    if (!z2 && i16 != 0 && i16 % 64 == 0 && l(10) != 55) {
                        this.f26680e++;
                        n(10);
                    }
                }
            }
        }
        int[] iArr5 = this.s;
        int i17 = this.q;
        this.q = i17 + 1;
        iArr5[i17] = i2;
    }

    public void d() {
        for (int i2 = 0; i2 < this.f26689n; i2++) {
            c();
            if (this.f26685j != 0) {
                this.f26686k++;
                this.f26685j = 0;
            }
            this.p += this.o;
        }
    }

    public void e(byte[] bArr, byte[] bArr2, int i2, int i3) {
        this.f26687l = bArr;
        this.f26684i = bArr2;
        this.f26688m = i2;
        this.f26689n = i3;
        this.o = i2;
        this.p = 0;
        this.f26685j = 0;
        this.f26686k = 0;
        int i4 = i2 + 1;
        this.r = new int[i4];
        this.s = new int[i4];
        this.f26680e = 0;
        try {
            int i5 = this.f26677b;
            if (i5 == 2) {
                d();
            } else if (i5 == 3) {
                f();
            } else if (i5 == 4) {
                this.f26681f = (this.f26679d & 2) >> 1;
                g();
            } else {
                throw new RuntimeException("Unknown compression type " + this.f26677b);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
    }

    public void f() {
        int h2;
        int i2 = this.f26689n;
        int[] iArr = new int[2];
        if (this.f26684i.length >= 2) {
            if (l(12) != 1) {
                this.f26680e++;
            }
            n(12);
            int i3 = 0;
            int i4 = -1;
            while (i3 != 1) {
                try {
                    i3 = i();
                    i4++;
                } catch (Exception unused) {
                    throw new RuntimeException("No reference line present.");
                }
            }
            c();
            int i5 = i4 + 1;
            this.p += this.o;
            while (i5 < i2) {
                try {
                    int i6 = i();
                    if (i6 == 0) {
                        int[] iArr2 = this.r;
                        this.r = this.s;
                        this.s = iArr2;
                        this.t = 0;
                        int i7 = 0;
                        int i8 = -1;
                        boolean z2 = true;
                        int i9 = 0;
                        while (true) {
                            if (i7 >= this.f26688m) {
                                break;
                            }
                            j(i8, z2, iArr);
                            int i10 = iArr[0];
                            int i11 = iArr[1];
                            byte b2 = C[k(7)];
                            int i12 = (b2 & 120) >>> 3;
                            byte b3 = 7 & b2;
                            if (i12 == 0) {
                                if (!z2) {
                                    m(i7, i11 - i7);
                                }
                                n(7 - b3);
                                i7 = i11;
                                i8 = i7;
                            } else if (i12 == 1) {
                                n(7 - b3);
                                if (z2) {
                                    int h3 = i7 + h();
                                    int i13 = i9 + 1;
                                    this.s[i9] = h3;
                                    int b4 = b();
                                    m(h3, b4);
                                    h2 = h3 + b4;
                                    i9 += 2;
                                    this.s[i13] = h2;
                                } else {
                                    int b5 = b();
                                    m(i7, b5);
                                    int i14 = i7 + b5;
                                    int i15 = i9 + 1;
                                    this.s[i9] = i14;
                                    h2 = i14 + h();
                                    i9 += 2;
                                    this.s[i15] = h2;
                                }
                                i8 = h2;
                                i7 = i8;
                            } else if (i12 <= 8) {
                                i8 = i10 + (i12 - 5);
                                int i16 = i9 + 1;
                                this.s[i9] = i8;
                                if (!z2) {
                                    m(i7, i8 - i7);
                                }
                                z2 = !z2;
                                n(7 - b3);
                                i7 = i8;
                                i9 = i16;
                            } else {
                                this.f26680e++;
                                int i17 = 0;
                                while (i6 != 1) {
                                    try {
                                        i6 = i();
                                        i17++;
                                    } catch (Exception unused2) {
                                        return;
                                    }
                                }
                                i5 += i17 - 1;
                                n(13);
                            }
                        }
                        this.s[i9] = i7;
                        this.q = i9 + 1;
                    } else {
                        c();
                    }
                    this.p += this.o;
                    i5++;
                } catch (Exception unused3) {
                    this.f26680e++;
                    return;
                }
            }
            return;
        }
        throw new RuntimeException("Insufficient data to read initial EOL.");
    }

    public synchronized void g() {
        int i2;
        int i3;
        boolean z2;
        synchronized (this) {
            try {
                int i4 = this.f26689n;
                int[] iArr = new int[2];
                int[] iArr2 = this.s;
                this.q = 1;
                int i5 = this.f26688m;
                int i6 = 0;
                iArr2[0] = i5;
                this.q = 1 + 1;
                iArr2[1] = i5;
                int i7 = 0;
                while (i7 < i4) {
                    int[] iArr3 = this.r;
                    this.r = this.s;
                    this.s = iArr3;
                    this.t = i6;
                    int i8 = -1;
                    int i9 = 0;
                    int i10 = 0;
                    boolean z3 = true;
                    while (true) {
                        i2 = this.f26688m;
                        if (i9 >= i2) {
                            break;
                        }
                        j(i8, z3, iArr);
                        int i11 = iArr[i6];
                        int i12 = iArr[1];
                        byte b2 = C[k(7)];
                        int i13 = (b2 & 120) >>> 3;
                        byte b3 = 7 & b2;
                        if (i13 == 0) {
                            if (!z3) {
                                int i14 = this.f26688m;
                                if (i12 > i14) {
                                    i12 = i14;
                                }
                                m(i9, i12 - i9);
                            }
                            i9 = i12;
                            n(7 - b3);
                        } else if (i13 == 1) {
                            n(7 - b3);
                            if (z3) {
                                int h2 = i9 + h();
                                int i15 = i10 + 1;
                                iArr3[i10] = h2;
                                int b4 = b();
                                int i16 = this.f26688m;
                                if (b4 > i16 - h2) {
                                    b4 = i16 - h2;
                                }
                                m(h2, b4);
                                i9 = h2 + b4;
                                i10 += 2;
                                iArr3[i15] = i9;
                            } else {
                                int b5 = b();
                                int i17 = this.f26688m;
                                if (b5 > i17 - i9) {
                                    b5 = i17 - i9;
                                }
                                m(i9, b5);
                                int i18 = i9 + b5;
                                int i19 = i10 + 1;
                                iArr3[i10] = i18;
                                i9 = i18 + h();
                                i10 += 2;
                                iArr3[i19] = i9;
                            }
                        } else if (i13 <= 8) {
                            int i20 = i11 + (i13 - 5);
                            int i21 = i10 + 1;
                            iArr3[i10] = i20;
                            if (!z3) {
                                int i22 = this.f26688m;
                                if (i20 > i22) {
                                    i20 = i22;
                                }
                                m(i9, i20 - i9);
                            }
                            i9 = i20;
                            z3 = !z3;
                            n(7 - b3);
                            i10 = i21;
                        } else {
                            if (i13 == 11) {
                                k(3);
                                boolean z4 = false;
                                int i23 = 0;
                                while (!z4) {
                                    while (k(1) != 1) {
                                        i23++;
                                    }
                                    if (i23 > 5) {
                                        i23 -= 6;
                                        if (!z3 && i23 > 0) {
                                            iArr3[i10] = i9;
                                            i10++;
                                        }
                                        i9 += i23;
                                        if (i23 > 0) {
                                            z3 = true;
                                        }
                                        if (k(1) == 0) {
                                            if (!z3) {
                                                iArr3[i10] = i9;
                                                i10++;
                                            }
                                            z3 = true;
                                        } else {
                                            if (z3) {
                                                iArr3[i10] = i9;
                                                i10++;
                                            }
                                            z3 = false;
                                        }
                                        z4 = true;
                                    }
                                    if (i23 == 5) {
                                        if (!z3) {
                                            iArr3[i10] = i9;
                                            i10++;
                                        }
                                        i3 = i9 + i23;
                                        z2 = true;
                                    } else {
                                        int i24 = i9 + i23;
                                        iArr3[i10] = i24;
                                        m(i24, 1);
                                        i3 = i24 + 1;
                                        i10++;
                                        z2 = false;
                                    }
                                }
                            }
                            i6 = 0;
                        }
                        i8 = i9;
                        i6 = 0;
                    }
                    if (i10 <= i2) {
                        iArr3[i10] = i9;
                        i10++;
                    }
                    this.q = i10;
                    this.p += this.o;
                    i7++;
                    i6 = 0;
                }
            } finally {
                while (true) {
                }
            }
        }
    }
}
