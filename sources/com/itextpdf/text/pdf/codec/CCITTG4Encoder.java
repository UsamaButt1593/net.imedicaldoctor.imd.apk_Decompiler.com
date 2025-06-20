package com.itextpdf.text.pdf.codec;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.android.material.internal.ViewUtils;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.apache.commons.httpclient.HttpStatus;

public class CCITTG4Encoder {
    private static byte[] p = {8, 7, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static byte[] q = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8};
    private static final int r = 0;
    private static final int s = 1;
    private static final int t = 2;
    private static final int u = 1;
    private static final int v = -1;
    private static final int w = -2;
    private static final int x = -3;
    private static final int y = -4;

    /* renamed from: a  reason: collision with root package name */
    private int f26555a;

    /* renamed from: b  reason: collision with root package name */
    private int f26556b;

    /* renamed from: c  reason: collision with root package name */
    private int f26557c = 8;

    /* renamed from: d  reason: collision with root package name */
    private int f26558d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f26559e;

    /* renamed from: f  reason: collision with root package name */
    private ByteBuffer f26560f = new ByteBuffer(1024);

    /* renamed from: g  reason: collision with root package name */
    private byte[] f26561g;

    /* renamed from: h  reason: collision with root package name */
    private int f26562h;

    /* renamed from: i  reason: collision with root package name */
    private int f26563i;

    /* renamed from: j  reason: collision with root package name */
    private int[][] f26564j = {new int[]{8, 53, 0}, new int[]{6, 7, 1}, new int[]{4, 7, 2}, new int[]{4, 8, 3}, new int[]{4, 11, 4}, new int[]{4, 12, 5}, new int[]{4, 14, 6}, new int[]{4, 15, 7}, new int[]{5, 19, 8}, new int[]{5, 20, 9}, new int[]{5, 7, 10}, new int[]{5, 8, 11}, new int[]{6, 8, 12}, new int[]{6, 3, 13}, new int[]{6, 52, 14}, new int[]{6, 53, 15}, new int[]{6, 42, 16}, new int[]{6, 43, 17}, new int[]{7, 39, 18}, new int[]{7, 12, 19}, new int[]{7, 8, 20}, new int[]{7, 23, 21}, new int[]{7, 3, 22}, new int[]{7, 4, 23}, new int[]{7, 40, 24}, new int[]{7, 43, 25}, new int[]{7, 19, 26}, new int[]{7, 36, 27}, new int[]{7, 24, 28}, new int[]{8, 2, 29}, new int[]{8, 3, 30}, new int[]{8, 26, 31}, new int[]{8, 27, 32}, new int[]{8, 18, 33}, new int[]{8, 19, 34}, new int[]{8, 20, 35}, new int[]{8, 21, 36}, new int[]{8, 22, 37}, new int[]{8, 23, 38}, new int[]{8, 40, 39}, new int[]{8, 41, 40}, new int[]{8, 42, 41}, new int[]{8, 43, 42}, new int[]{8, 44, 43}, new int[]{8, 45, 44}, new int[]{8, 4, 45}, new int[]{8, 5, 46}, new int[]{8, 10, 47}, new int[]{8, 11, 48}, new int[]{8, 82, 49}, new int[]{8, 83, 50}, new int[]{8, 84, 51}, new int[]{8, 85, 52}, new int[]{8, 36, 53}, new int[]{8, 37, 54}, new int[]{8, 88, 55}, new int[]{8, 89, 56}, new int[]{8, 90, 57}, new int[]{8, 91, 58}, new int[]{8, 74, 59}, new int[]{8, 75, 60}, new int[]{8, 50, 61}, new int[]{8, 51, 62}, new int[]{8, 52, 63}, new int[]{5, 27, 64}, new int[]{5, 18, 128}, new int[]{6, 23, PsExtractor.x}, new int[]{7, 55, 256}, new int[]{8, 54, TIFFConstants.o1}, new int[]{8, 55, RendererCapabilities.M}, new int[]{8, 100, 448}, new int[]{8, 101, 512}, new int[]{8, 104, 576}, new int[]{8, 103, 640}, new int[]{9, 204, TypedValues.TransitionType.f4037n}, new int[]{9, HttpStatus.SC_RESET_CONTENT, ViewUtils.f21582a}, new int[]{9, 210, 832}, new int[]{9, 211, 896}, new int[]{9, 212, 960}, new int[]{9, 213, 1024}, new int[]{9, 214, 1088}, new int[]{9, 215, 1152}, new int[]{9, 216, 1216}, new int[]{9, 217, 1280}, new int[]{9, 218, 1344}, new int[]{9, 219, 1408}, new int[]{9, 152, 1472}, new int[]{9, 153, 1536}, new int[]{9, 154, 1600}, new int[]{6, 24, 1664}, new int[]{9, 155, 1728}, new int[]{11, 8, 1792}, new int[]{11, 12, 1856}, new int[]{11, 13, 1920}, new int[]{12, 18, 1984}, new int[]{12, 19, 2048}, new int[]{12, 20, 2112}, new int[]{12, 21, 2176}, new int[]{12, 22, 2240}, new int[]{12, 23, 2304}, new int[]{12, 28, MetaDo.m0}, new int[]{12, 29, 2432}, new int[]{12, 30, 2496}, new int[]{12, 31, 2560}, new int[]{12, 1, -1}, new int[]{9, 1, -2}, new int[]{10, 1, -2}, new int[]{11, 1, -2}, new int[]{12, 0, -2}};

    /* renamed from: k  reason: collision with root package name */
    private int[][] f26565k = {new int[]{10, 55, 0}, new int[]{3, 2, 1}, new int[]{2, 3, 2}, new int[]{2, 2, 3}, new int[]{3, 3, 4}, new int[]{4, 3, 5}, new int[]{4, 2, 6}, new int[]{5, 3, 7}, new int[]{6, 5, 8}, new int[]{6, 4, 9}, new int[]{7, 4, 10}, new int[]{7, 5, 11}, new int[]{7, 7, 12}, new int[]{8, 4, 13}, new int[]{8, 7, 14}, new int[]{9, 24, 15}, new int[]{10, 23, 16}, new int[]{10, 24, 17}, new int[]{10, 8, 18}, new int[]{11, 103, 19}, new int[]{11, 104, 20}, new int[]{11, 108, 21}, new int[]{11, 55, 22}, new int[]{11, 40, 23}, new int[]{11, 23, 24}, new int[]{11, 24, 25}, new int[]{12, 202, 26}, new int[]{12, 203, 27}, new int[]{12, 204, 28}, new int[]{12, HttpStatus.SC_RESET_CONTENT, 29}, new int[]{12, 104, 30}, new int[]{12, 105, 31}, new int[]{12, 106, 32}, new int[]{12, 107, 33}, new int[]{12, 210, 34}, new int[]{12, 211, 35}, new int[]{12, 212, 36}, new int[]{12, 213, 37}, new int[]{12, 214, 38}, new int[]{12, 215, 39}, new int[]{12, 108, 40}, new int[]{12, 109, 41}, new int[]{12, 218, 42}, new int[]{12, 219, 43}, new int[]{12, 84, 44}, new int[]{12, 85, 45}, new int[]{12, 86, 46}, new int[]{12, 87, 47}, new int[]{12, 100, 48}, new int[]{12, 101, 49}, new int[]{12, 82, 50}, new int[]{12, 83, 51}, new int[]{12, 36, 52}, new int[]{12, 55, 53}, new int[]{12, 56, 54}, new int[]{12, 39, 55}, new int[]{12, 40, 56}, new int[]{12, 88, 57}, new int[]{12, 89, 58}, new int[]{12, 43, 59}, new int[]{12, 44, 60}, new int[]{12, 90, 61}, new int[]{12, 102, 62}, new int[]{12, 103, 63}, new int[]{10, 15, 64}, new int[]{12, 200, 128}, new int[]{12, 201, PsExtractor.x}, new int[]{12, 91, 256}, new int[]{12, 51, TIFFConstants.o1}, new int[]{12, 52, RendererCapabilities.M}, new int[]{12, 53, 448}, new int[]{13, 108, 512}, new int[]{13, 109, 576}, new int[]{13, 74, 640}, new int[]{13, 75, TypedValues.TransitionType.f4037n}, new int[]{13, 76, ViewUtils.f21582a}, new int[]{13, 77, 832}, new int[]{13, 114, 896}, new int[]{13, 115, 960}, new int[]{13, 116, 1024}, new int[]{13, 117, 1088}, new int[]{13, 118, 1152}, new int[]{13, 119, 1216}, new int[]{13, 82, 1280}, new int[]{13, 83, 1344}, new int[]{13, 84, 1408}, new int[]{13, 85, 1472}, new int[]{13, 90, 1536}, new int[]{13, 91, 1600}, new int[]{13, 100, 1664}, new int[]{13, 101, 1728}, new int[]{11, 8, 1792}, new int[]{11, 12, 1856}, new int[]{11, 13, 1920}, new int[]{12, 18, 1984}, new int[]{12, 19, 2048}, new int[]{12, 20, 2112}, new int[]{12, 21, 2176}, new int[]{12, 22, 2240}, new int[]{12, 23, 2304}, new int[]{12, 28, MetaDo.m0}, new int[]{12, 29, 2432}, new int[]{12, 30, 2496}, new int[]{12, 31, 2560}, new int[]{12, 1, -1}, new int[]{9, 1, -2}, new int[]{10, 1, -2}, new int[]{11, 1, -2}, new int[]{12, 0, -2}};

    /* renamed from: l  reason: collision with root package name */
    private int[] f26566l = {3, 1, 0};

    /* renamed from: m  reason: collision with root package name */
    private int[] f26567m = {4, 1, 0};

    /* renamed from: n  reason: collision with root package name */
    private int[][] f26568n = {new int[]{7, 3, 0}, new int[]{6, 3, 0}, new int[]{3, 3, 0}, new int[]{1, 1, 0}, new int[]{3, 2, 0}, new int[]{6, 2, 0}, new int[]{7, 2, 0}};
    private int[] o = {0, 1, 3, 7, 15, 31, 63, WorkQueueKt.f29430c, 255};

    public CCITTG4Encoder(int i2) {
        int i3 = i2;
        this.f26556b = i3;
        int i4 = (i3 + 7) / 8;
        this.f26555a = i4;
        this.f26559e = new byte[i4];
    }

    private void a() {
        int i2 = k(this.f26561g, this.f26562h, 0) != 0 ? 0 : i(this.f26561g, this.f26562h, 0, this.f26556b, 0);
        int i3 = k(this.f26559e, 0, 0) != 0 ? 0 : i(this.f26559e, 0, 0, this.f26556b, 0);
        int i4 = 0;
        while (true) {
            byte[] bArr = this.f26559e;
            int j2 = j(bArr, 0, i3, this.f26556b, k(bArr, 0, i3));
            if (j2 >= i2) {
                int i5 = i3 - i2;
                if (-3 > i5 || i5 > 3) {
                    byte[] bArr2 = this.f26561g;
                    int i6 = this.f26562h;
                    int j3 = j(bArr2, i6, i2, this.f26556b, k(bArr2, i6, i2));
                    m(this.f26566l);
                    if (i4 + i2 == 0 || k(this.f26561g, this.f26562h, i4) == 0) {
                        n(i2 - i4, this.f26564j);
                        n(j3 - i2, this.f26565k);
                    } else {
                        n(i2 - i4, this.f26565k);
                        n(j3 - i2, this.f26564j);
                    }
                    i2 = j3;
                } else {
                    m(this.f26568n[i5 + 3]);
                }
                i4 = i2;
            } else {
                m(this.f26567m);
                i4 = j2;
            }
            int i7 = this.f26556b;
            if (i4 < i7) {
                byte[] bArr3 = this.f26561g;
                int i8 = this.f26562h;
                i2 = i(bArr3, i8, i4, i7, k(bArr3, i8, i4));
                i3 = i(this.f26559e, 0, i(this.f26559e, 0, i4, this.f26556b, k(this.f26561g, this.f26562h, i4) ^ 1), this.f26556b, k(this.f26561g, this.f26562h, i4));
            } else {
                return;
            }
        }
    }

    private void b() {
        l(1, 12);
        l(1, 12);
        if (this.f26557c != 8) {
            this.f26560f.b((byte) this.f26558d);
            this.f26558d = 0;
            this.f26557c = 8;
        }
    }

    public static byte[] d(byte[] bArr, int i2, int i3) {
        CCITTG4Encoder cCITTG4Encoder = new CCITTG4Encoder(i2);
        cCITTG4Encoder.f(bArr, 0, cCITTG4Encoder.f26555a * i3);
        return cCITTG4Encoder.c();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int g(byte[] r3, int r4, int r5, int r6) {
        /*
            int r6 = r6 - r5
            int r0 = r5 >> 3
            int r4 = r4 + r0
            r0 = 8
            if (r6 <= 0) goto L_0x0025
            r5 = r5 & 7
            if (r5 == 0) goto L_0x0025
            byte[] r1 = p
            byte r2 = r3[r4]
            int r2 = r2 << r5
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r1 = r1[r2]
            int r2 = 8 - r5
            if (r1 <= r2) goto L_0x001a
            r1 = r2
        L_0x001a:
            if (r1 <= r6) goto L_0x001d
            r1 = r6
        L_0x001d:
            int r5 = r5 + r1
            if (r5 >= r0) goto L_0x0021
            return r1
        L_0x0021:
            int r6 = r6 - r1
        L_0x0022:
            int r4 = r4 + 1
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            if (r6 < r0) goto L_0x0039
            byte r5 = r3[r4]
            if (r5 == 0) goto L_0x0034
            byte[] r3 = p
            r4 = r5 & 255(0xff, float:3.57E-43)
            byte r3 = r3[r4]
            int r1 = r1 + r3
            return r1
        L_0x0034:
            int r1 = r1 + 8
            int r6 = r6 + -8
            goto L_0x0022
        L_0x0039:
            if (r6 <= 0) goto L_0x0048
            byte[] r5 = p
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            if (r3 <= r6) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r6 = r3
        L_0x0047:
            int r1 = r1 + r6
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.CCITTG4Encoder.g(byte[], int, int, int):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int h(byte[] r3, int r4, int r5, int r6) {
        /*
            int r6 = r6 - r5
            int r0 = r5 >> 3
            int r4 = r4 + r0
            r0 = 8
            if (r6 <= 0) goto L_0x0025
            r5 = r5 & 7
            if (r5 == 0) goto L_0x0025
            byte[] r1 = q
            byte r2 = r3[r4]
            int r2 = r2 << r5
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r1 = r1[r2]
            int r2 = 8 - r5
            if (r1 <= r2) goto L_0x001a
            r1 = r2
        L_0x001a:
            if (r1 <= r6) goto L_0x001d
            r1 = r6
        L_0x001d:
            int r5 = r5 + r1
            if (r5 >= r0) goto L_0x0021
            return r1
        L_0x0021:
            int r6 = r6 - r1
        L_0x0022:
            int r4 = r4 + 1
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            if (r6 < r0) goto L_0x003a
            byte r5 = r3[r4]
            r2 = -1
            if (r5 == r2) goto L_0x0035
            byte[] r3 = q
            r4 = r5 & 255(0xff, float:3.57E-43)
            byte r3 = r3[r4]
            int r1 = r1 + r3
            return r1
        L_0x0035:
            int r1 = r1 + 8
            int r6 = r6 + -8
            goto L_0x0022
        L_0x003a:
            if (r6 <= 0) goto L_0x0049
            byte[] r5 = q
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            if (r3 <= r6) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r6 = r3
        L_0x0048:
            int r1 = r1 + r6
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.CCITTG4Encoder.h(byte[], int, int, int):int");
    }

    private static int i(byte[] bArr, int i2, int i3, int i4, int i5) {
        return i3 + (i5 != 0 ? h(bArr, i2, i3, i4) : g(bArr, i2, i3, i4));
    }

    private static int j(byte[] bArr, int i2, int i3, int i4, int i5) {
        return i3 < i4 ? i(bArr, i2, i3, i4, i5) : i4;
    }

    private int k(byte[] bArr, int i2, int i3) {
        if (i3 >= this.f26556b) {
            return 0;
        }
        return ((bArr[i2 + (i3 >> 3)] & 255) >> (7 - (i3 & 7))) & 1;
    }

    private void l(int i2, int i3) {
        int i4;
        int i5;
        while (true) {
            i4 = this.f26557c;
            i5 = this.f26558d;
            if (i3 <= i4) {
                break;
            }
            int i6 = i5 | (i2 >> (i3 - i4));
            this.f26558d = i6;
            i3 -= i4;
            this.f26560f.b((byte) i6);
            this.f26558d = 0;
            this.f26557c = 8;
        }
        int i7 = ((i2 & this.o[i3]) << (i4 - i3)) | i5;
        this.f26558d = i7;
        int i8 = i4 - i3;
        this.f26557c = i8;
        if (i8 == 0) {
            this.f26560f.b((byte) i7);
            this.f26558d = 0;
            this.f26557c = 8;
        }
    }

    private void m(int[] iArr) {
        l(iArr[1], iArr[0]);
    }

    private void n(int i2, int[][] iArr) {
        while (i2 >= 2624) {
            int[] iArr2 = iArr[103];
            l(iArr2[1], iArr2[0]);
            i2 -= iArr2[2];
        }
        if (i2 >= 64) {
            int[] iArr3 = iArr[(i2 >> 6) + 63];
            l(iArr3[1], iArr3[0]);
            i2 -= iArr3[2];
        }
        int[] iArr4 = iArr[i2];
        l(iArr4[1], iArr4[0]);
    }

    public byte[] c() {
        b();
        return this.f26560f.F();
    }

    public void e(byte[] bArr, int i2) {
        f(bArr, 0, this.f26555a * i2);
    }

    public void f(byte[] bArr, int i2, int i3) {
        this.f26561g = bArr;
        this.f26562h = i2;
        this.f26563i = i3;
        while (this.f26563i > 0) {
            a();
            System.arraycopy(this.f26561g, this.f26562h, this.f26559e, 0, this.f26555a);
            int i4 = this.f26562h;
            int i5 = this.f26555a;
            this.f26562h = i4 + i5;
            this.f26563i -= i5;
        }
    }
}
