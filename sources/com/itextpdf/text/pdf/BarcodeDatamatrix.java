package com.itextpdf.text.pdf;

import androidx.core.view.InputDeviceCompat;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.primitives.SignedBytes;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.codec.CCITTG4Encoder;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Hashtable;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import net.imedicaldoctor.imd.BuildConfig;
import okio.Utf8;
import org.apache.commons.httpclient.HttpStatus;

public class BarcodeDatamatrix {

    /* renamed from: h  reason: collision with root package name */
    public static final int f25866h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f25867i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f25868j = 3;

    /* renamed from: k  reason: collision with root package name */
    public static final int f25869k = 5;

    /* renamed from: l  reason: collision with root package name */
    public static final int f25870l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static final int f25871m = 1;

    /* renamed from: n  reason: collision with root package name */
    public static final int f25872n = 2;
    public static final int o = 3;
    public static final int p = 4;
    public static final int q = 5;
    public static final int r = 6;
    public static final int s = 7;
    public static final int t = 32;
    public static final int u = 64;
    private static final DmParams[] v = {new DmParams(10, 10, 10, 10, 3, 3, 5), new DmParams(12, 12, 12, 12, 5, 5, 7), new DmParams(8, 18, 8, 18, 5, 5, 7), new DmParams(14, 14, 14, 14, 8, 8, 10), new DmParams(8, 32, 8, 16, 10, 10, 11), new DmParams(16, 16, 16, 16, 12, 12, 12), new DmParams(12, 26, 12, 26, 16, 16, 14), new DmParams(18, 18, 18, 18, 18, 18, 14), new DmParams(20, 20, 20, 20, 22, 22, 18), new DmParams(12, 36, 12, 18, 22, 22, 18), new DmParams(22, 22, 22, 22, 30, 30, 20), new DmParams(16, 36, 16, 18, 32, 32, 24), new DmParams(24, 24, 24, 24, 36, 36, 24), new DmParams(26, 26, 26, 26, 44, 44, 28), new DmParams(16, 48, 16, 24, 49, 49, 28), new DmParams(32, 32, 16, 16, 62, 62, 36), new DmParams(36, 36, 18, 18, 86, 86, 42), new DmParams(40, 40, 20, 20, 114, 114, 48), new DmParams(44, 44, 22, 22, 144, 144, 56), new DmParams(48, 48, 24, 24, 174, 174, 68), new DmParams(52, 52, 26, 26, 204, 102, 42), new DmParams(64, 64, 16, 16, TIFFConstants.u0, 140, 56), new DmParams(72, 72, 18, 18, 368, 92, 36), new DmParams(80, 80, 20, 20, 456, 114, 48), new DmParams(88, 88, 22, 22, 576, 144, 56), new DmParams(96, 96, 24, 24, 696, 174, 68), new DmParams(104, 104, 26, 26, 816, TsExtractor.V, 56), new DmParams(120, 120, 20, 20, 1050, 175, 68), new DmParams(132, 132, 22, 22, 1304, 163, 62), new DmParams(144, 144, 24, 24, 1558, 156, 62)};
    private static final String w = "\r*> 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /* renamed from: a  reason: collision with root package name */
    private int f25873a;

    /* renamed from: b  reason: collision with root package name */
    private short[] f25874b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f25875c;

    /* renamed from: d  reason: collision with root package name */
    private int f25876d;

    /* renamed from: e  reason: collision with root package name */
    private int f25877e;

    /* renamed from: f  reason: collision with root package name */
    private int f25878f;

    /* renamed from: g  reason: collision with root package name */
    private int f25879g;

    private static class DmParams {

        /* renamed from: a  reason: collision with root package name */
        int f25880a;

        /* renamed from: b  reason: collision with root package name */
        int f25881b;

        /* renamed from: c  reason: collision with root package name */
        int f25882c;

        /* renamed from: d  reason: collision with root package name */
        int f25883d;

        /* renamed from: e  reason: collision with root package name */
        int f25884e;

        /* renamed from: f  reason: collision with root package name */
        int f25885f;

        /* renamed from: g  reason: collision with root package name */
        int f25886g;

        DmParams(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f25880a = i2;
            this.f25881b = i3;
            this.f25882c = i4;
            this.f25883d = i5;
            this.f25884e = i6;
            this.f25885f = i7;
            this.f25886g = i8;
        }
    }

    static class Placement {

        /* renamed from: d  reason: collision with root package name */
        private static final Hashtable<Integer, short[]> f25887d = new Hashtable<>();

        /* renamed from: a  reason: collision with root package name */
        private int f25888a;

        /* renamed from: b  reason: collision with root package name */
        private int f25889b;

        /* renamed from: c  reason: collision with root package name */
        private short[] f25890c;

        private Placement() {
        }

        private void a(int i2) {
            g(this.f25888a - 1, 0, i2, 0);
            g(this.f25888a - 1, 1, i2, 1);
            g(this.f25888a - 1, 2, i2, 2);
            g(0, this.f25889b - 2, i2, 3);
            g(0, this.f25889b - 1, i2, 4);
            g(1, this.f25889b - 1, i2, 5);
            g(2, this.f25889b - 1, i2, 6);
            g(3, this.f25889b - 1, i2, 7);
        }

        private void b(int i2) {
            g(this.f25888a - 3, 0, i2, 0);
            g(this.f25888a - 2, 0, i2, 1);
            g(this.f25888a - 1, 0, i2, 2);
            g(0, this.f25889b - 4, i2, 3);
            g(0, this.f25889b - 3, i2, 4);
            g(0, this.f25889b - 2, i2, 5);
            g(0, this.f25889b - 1, i2, 6);
            g(1, this.f25889b - 1, i2, 7);
        }

        private void c(int i2) {
            g(this.f25888a - 3, 0, i2, 0);
            g(this.f25888a - 2, 0, i2, 1);
            g(this.f25888a - 1, 0, i2, 2);
            g(0, this.f25889b - 2, i2, 3);
            g(0, this.f25889b - 1, i2, 4);
            g(1, this.f25889b - 1, i2, 5);
            g(2, this.f25889b - 1, i2, 6);
            g(3, this.f25889b - 1, i2, 7);
        }

        private void d(int i2) {
            g(this.f25888a - 1, 0, i2, 0);
            g(this.f25888a - 1, this.f25889b - 1, i2, 1);
            g(0, this.f25889b - 3, i2, 2);
            g(0, this.f25889b - 2, i2, 3);
            g(0, this.f25889b - 1, i2, 4);
            g(1, this.f25889b - 3, i2, 5);
            g(1, this.f25889b - 2, i2, 6);
            g(1, this.f25889b - 1, i2, 7);
        }

        static short[] e(int i2, int i3) {
            Integer valueOf = Integer.valueOf((i2 * 1000) + i3);
            Hashtable<Integer, short[]> hashtable = f25887d;
            short[] sArr = hashtable.get(valueOf);
            if (sArr != null) {
                return sArr;
            }
            Placement placement = new Placement();
            placement.f25888a = i2;
            placement.f25889b = i3;
            placement.f25890c = new short[(i2 * i3)];
            placement.f();
            hashtable.put(valueOf, placement.f25890c);
            return placement.f25890c;
        }

        private void f() {
            int i2;
            int i3;
            int i4 = 0;
            Arrays.fill(this.f25890c, 0);
            int i5 = 4;
            int i6 = 1;
            while (true) {
                if (i5 == this.f25888a && i4 == 0) {
                    a(i6);
                    i6++;
                }
                if (i5 == this.f25888a - 2 && i4 == 0 && this.f25889b % 4 != 0) {
                    b(i6);
                    i6++;
                }
                if (i5 == this.f25888a - 2 && i4 == 0 && this.f25889b % 8 == 4) {
                    c(i6);
                    i6++;
                }
                if (i5 == this.f25888a + 4 && i4 == 2 && this.f25889b % 8 == 0) {
                    d(i6);
                    i6++;
                }
                while (true) {
                    if (i5 < this.f25888a && i4 >= 0 && this.f25890c[(this.f25889b * i5) + i4] == 0) {
                        h(i5, i4, i6);
                        i6++;
                    }
                    int i7 = i5 - 2;
                    int i8 = i4 + 2;
                    if (i7 < 0 || i8 >= this.f25889b) {
                        int i9 = i5 - 1;
                        int i10 = i4 + 5;
                    } else {
                        i5 = i7;
                        i4 = i8;
                    }
                }
                int i92 = i5 - 1;
                int i102 = i4 + 5;
                while (true) {
                    if (i92 >= 0) {
                        int i11 = this.f25889b;
                        if (i102 < i11 && this.f25890c[(i11 * i92) + i102] == 0) {
                            h(i92, i102, i6);
                            i6++;
                        }
                    }
                    int i12 = i92 + 2;
                    int i13 = i102 - 2;
                    i2 = this.f25888a;
                    if (i12 >= i2 || i13 < 0) {
                        i5 = i92 + 5;
                        i4 = i102 - 1;
                    } else {
                        i92 = i12;
                        i102 = i13;
                    }
                }
                i5 = i92 + 5;
                i4 = i102 - 1;
                if (i5 >= i2 && i4 >= (i3 = this.f25889b)) {
                    break;
                }
            }
            short[] sArr = this.f25890c;
            if (sArr[(i2 * i3) - 1] == 0) {
                sArr[((i2 * i3) - i3) - 2] = 1;
                sArr[(i2 * i3) - 1] = 1;
            }
        }

        private void g(int i2, int i3, int i4, int i5) {
            if (i2 < 0) {
                int i6 = this.f25888a;
                i2 += i6;
                i3 += 4 - ((i6 + 4) % 8);
            }
            if (i3 < 0) {
                int i7 = this.f25889b;
                i3 += i7;
                i2 += 4 - ((i7 + 4) % 8);
            }
            this.f25890c[(i2 * this.f25889b) + i3] = (short) ((i4 * 8) + i5);
        }

        private void h(int i2, int i3, int i4) {
            int i5 = i2 - 2;
            int i6 = i3 - 2;
            g(i5, i6, i4, 0);
            int i7 = i3 - 1;
            g(i5, i7, i4, 1);
            int i8 = i2 - 1;
            g(i8, i6, i4, 2);
            g(i8, i7, i4, 3);
            g(i8, i3, i4, 4);
            g(i2, i6, i4, 5);
            g(i2, i7, i4, 6);
            g(i2, i3, i4, 7);
        }
    }

    static class ReedSolomon {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f25891a = {0, 255, 1, PsExtractor.A, 2, 225, 241, 53, 3, 38, Jpeg.V4, 133, 242, 43, 54, 210, 4, 195, 39, 114, 227, 106, TsExtractor.T, 28, 243, 140, 44, 23, 55, 118, 211, 234, 5, 219, 196, 96, 40, 222, 115, 103, 228, 78, 107, 125, TsExtractor.M, 8, 29, 162, 244, 186, 141, BuildConfig.f29478d, 45, 99, 24, 49, 56, 13, 119, 153, 212, 199, 235, 91, 6, 76, 220, 217, 197, 11, 97, 184, 41, 36, 223, 253, 116, TsExtractor.K, 104, 193, 229, 86, 79, 171, 108, 165, 126, 145, TsExtractor.V, 34, 9, 74, 30, 32, 163, 84, 245, 173, 187, 204, 142, 81, 181, 190, 46, 88, 100, 159, 25, 231, 50, HttpStatus.SC_MULTI_STATUS, 57, 147, 14, 67, 120, 128, 154, 248, 213, 167, 200, 63, 236, 110, 92, 176, 7, 161, 77, 124, 221, 102, 218, 95, 198, 90, 12, 152, 98, 48, 185, 179, 42, 209, 37, 132, 224, 52, TIFFConstants.f26648a, 239, 117, 233, TsExtractor.W, 22, 105, 27, 194, 113, 230, HttpStatus.SC_PARTIAL_CONTENT, 87, 158, 80, PsExtractor.w, TsExtractor.N, 203, 109, 175, 166, 62, WorkQueueKt.f29430c, MetaDo.s0, 146, 66, 137, PsExtractor.x, 35, 252, 10, 183, 75, 216, 31, 83, 33, 73, 164, 144, 85, 170, 246, 65, 174, 61, TsExtractor.D, 202, HttpStatus.SC_RESET_CONTENT, 157, 143, 169, 82, 72, 182, 215, 191, 251, 47, 178, 89, 151, 101, 94, 160, 123, 26, 112, 232, 21, 51, Jpeg.W4, 208, 131, 58, 69, 148, 18, 15, 16, 68, 17, 121, 149, TsExtractor.J, 19, 155, 59, 249, 70, 214, ItemTouchHelper.Callback.f15380c, 168, 71, 201, 156, 64, 60, Jpeg.X4, TsExtractor.L, 111, 20, 93, 122, 177, 150};

        /* renamed from: b  reason: collision with root package name */
        private static final int[] f25892b = {1, 2, 4, 8, 16, 32, 64, 128, 45, 90, BuildConfig.f29478d, 69, TsExtractor.K, 57, 114, 228, 229, 231, 227, 235, 251, 219, 155, 27, 54, 108, 216, 157, 23, 46, 92, 184, 93, 186, 89, 178, 73, 146, 9, 18, 36, 72, 144, 13, 26, 52, 104, 208, 141, 55, 110, 220, 149, 7, 14, 28, 56, 112, 224, Jpeg.X4, MetaDo.s0, 195, 171, 123, 246, 193, 175, 115, 230, 225, 239, 243, 203, 187, 91, 182, 65, TsExtractor.L, 41, 82, 164, 101, 202, 185, 95, 190, 81, 162, 105, 210, 137, 63, 126, 252, 213, TsExtractor.M, 35, 70, 140, 53, 106, 212, 133, 39, 78, 156, 21, 42, 84, 168, 125, ItemTouchHelper.Callback.f15380c, 217, 159, 19, 38, 76, 152, 29, 58, 116, 232, 253, 215, 131, 43, 86, TsExtractor.N, 117, 234, 249, 223, 147, 11, 22, 44, 88, 176, 77, 154, 25, 50, 100, 200, PsExtractor.w, 87, 174, 113, Jpeg.V4, 233, 255, 211, TsExtractor.W, 59, 118, 236, 245, 199, 163, 107, 214, TsExtractor.J, 47, 94, TsExtractor.D, 85, 170, 121, 242, 201, 191, 83, 166, 97, 194, 169, WorkQueueKt.f29430c, TIFFConstants.f26648a, 209, 143, 51, 102, 204, 181, 71, 142, 49, 98, 196, 165, 103, HttpStatus.SC_PARTIAL_CONTENT, 177, 79, 158, 17, 34, 68, TsExtractor.V, 61, 122, 244, 197, 167, 99, 198, 161, 111, 222, 145, 15, 30, 60, 120, PsExtractor.A, HttpStatus.SC_RESET_CONTENT, 183, 67, TsExtractor.T, 33, 66, 132, 37, 74, 148, 5, 10, 20, 40, 80, 160, 109, 218, 153, 31, 62, 124, 248, 221, 151, 3, 6, 12, 24, 48, 96, PsExtractor.x, 173, 119, Jpeg.W4, 241, HttpStatus.SC_MULTI_STATUS, 179, 75, 150, 1};

        /* renamed from: c  reason: collision with root package name */
        private static final int[] f25893c = {228, 48, 15, 111, 62};

        /* renamed from: d  reason: collision with root package name */
        private static final int[] f25894d = {23, 68, 144, TsExtractor.T, PsExtractor.A, 92, TIFFConstants.f26648a};

        /* renamed from: e  reason: collision with root package name */
        private static final int[] f25895e = {28, 24, 185, 166, 223, 248, 116, 255, 110, 61};

        /* renamed from: f  reason: collision with root package name */
        private static final int[] f25896f = {175, TsExtractor.K, HttpStatus.SC_RESET_CONTENT, 12, 194, 168, 39, 245, 60, 97, 120};

        /* renamed from: g  reason: collision with root package name */
        private static final int[] f25897g = {41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242};

        /* renamed from: h  reason: collision with root package name */
        private static final int[] f25898h = {156, 97, PsExtractor.x, 252, 95, 9, 157, 119, TsExtractor.K, 45, 18, 186, 83, 185};

        /* renamed from: i  reason: collision with root package name */
        private static final int[] f25899i = {83, 195, 100, 39, TsExtractor.D, 75, 66, 61, 241, 213, 109, TsExtractor.J, 94, TIFFConstants.f26648a, 225, 48, 90, TsExtractor.D};

        /* renamed from: j  reason: collision with root package name */
        private static final int[] f25900j = {15, 195, 244, 9, 233, 71, 168, 2, TsExtractor.D, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, TsExtractor.N};

        /* renamed from: k  reason: collision with root package name */
        private static final int[] f25901k = {52, 190, 88, HttpStatus.SC_RESET_CONTENT, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, TsExtractor.N, TIFFConstants.f26648a, 124, 12, 181, 184, 96, 50, 193};

        /* renamed from: l  reason: collision with root package name */
        private static final int[] f25902l = {211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, TsExtractor.K, 110, 213, 141, TsExtractor.V, 120, 151, 233, 168, 93, 255};

        /* renamed from: m  reason: collision with root package name */
        private static final int[] f25903m = {245, WorkQueueKt.f29430c, 242, 218, TsExtractor.L, ItemTouchHelper.Callback.f15380c, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112};

        /* renamed from: n  reason: collision with root package name */
        private static final int[] f25904n = {77, 193, 137, 31, 19, 38, 22, 153, MetaDo.s0, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, Jpeg.V4, 5, 9, 5};
        private static final int[] o = {245, 132, TsExtractor.N, 223, 96, 32, 117, 22, Jpeg.W4, 133, Jpeg.W4, 231, HttpStatus.SC_RESET_CONTENT, TsExtractor.D, Jpeg.X4, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, HttpStatus.SC_RESET_CONTENT, 131, 88, 120, 100, 66, TsExtractor.K, 186, PsExtractor.A, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19};
        private static final int[] p = {175, 9, 223, Jpeg.W4, 12, 17, 220, 208, 100, 29, 175, 170, 230, PsExtractor.x, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, Jpeg.W4, 22, 150, 201, 117, 62, HttpStatus.SC_MULTI_STATUS, 164, 13, 137, 245, WorkQueueKt.f29430c, 67, MetaDo.s0, 28, 155, 43, 203, 107, 233, 53, 143, 46};
        private static final int[] q = {242, 93, 169, 50, 144, 210, 39, 118, 202, TsExtractor.D, 201, PsExtractor.w, 143, 108, 196, 37, 185, 112, TsExtractor.T, 230, 245, 63, 197, 190, ItemTouchHelper.Callback.f15380c, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, TsExtractor.L, TsExtractor.D, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204};
        private static final int[] r = {220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, WorkQueueKt.f29430c, 213, TsExtractor.V, 248, BuildConfig.f29478d, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, TsExtractor.W, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, TsExtractor.V, 223, 239, 181, 241, 59, 52, TsExtractor.N, 25, 49, 232, 211, PsExtractor.w, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186};

        ReedSolomon() {
        }

        static void a(byte[] bArr, int i2, int i3, int i4) {
            int i5 = (i2 + 2) / i3;
            byte[] bArr2 = new byte[256];
            byte[] bArr3 = new byte[256];
            int[] b2 = b(i4);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6;
                int i8 = 0;
                while (i7 < i2) {
                    bArr2[i8] = bArr[i7];
                    i7 += i5;
                    i8++;
                }
                c(bArr2, i8, bArr3, i4, b2);
                int i9 = i6;
                int i10 = 0;
                while (i9 < i4 * i5) {
                    bArr[i2 + i9] = bArr3[i10];
                    i9 += i5;
                    i10++;
                }
            }
        }

        private static int[] b(int i2) {
            switch (i2) {
                case 5:
                    return f25893c;
                case 7:
                    return f25894d;
                case 10:
                    return f25895e;
                case 11:
                    return f25896f;
                case 12:
                    return f25897g;
                case 14:
                    return f25898h;
                case 18:
                    return f25899i;
                case 20:
                    return f25900j;
                case 24:
                    return f25901k;
                case 28:
                    return f25902l;
                case 36:
                    return f25903m;
                case 42:
                    return f25904n;
                case 48:
                    return o;
                case 56:
                    return p;
                case 62:
                    return q;
                case 68:
                    return r;
                default:
                    return null;
            }
        }

        private static void c(byte[] bArr, int i2, byte[] bArr2, int i3, int[] iArr) {
            byte b2;
            for (int i4 = 0; i4 <= i3; i4++) {
                bArr2[i4] = 0;
            }
            for (int i5 = 0; i5 < i2; i5++) {
                byte b3 = (bArr2[0] ^ bArr[i5]) & 255;
                int i6 = 0;
                while (i6 < i3) {
                    int i7 = i6 + 1;
                    byte b4 = bArr2[i7];
                    if (b3 == 0) {
                        b2 = 0;
                    } else {
                        int[] iArr2 = f25892b;
                        int[] iArr3 = f25891a;
                        b2 = (byte) iArr2[(iArr3[b3] + iArr3[iArr[(i3 - i6) - 1]]) % 255];
                    }
                    bArr2[i6] = (byte) (b4 ^ b2);
                    i6 = i7;
                }
            }
        }
    }

    private static int a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5, boolean z) {
        String str;
        String str2;
        int i6 = i3;
        if (i6 == 0) {
            return 0;
        }
        if (z) {
            bArr2[i4] = -26;
        } else {
            bArr2[i4] = -17;
        }
        if (z) {
            str2 = " 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            str = "`abcdefghijklmnopqrstuvwxyz{|}~";
        } else {
            str2 = " 0123456789abcdefghijklmnopqrstuvwxyz";
            str = "`ABCDEFGHIJKLMNOPQRSTUVWXYZ{|}~";
        }
        int[] iArr = new int[((i6 * 4) + 10)];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i7 < i6) {
            if (i8 % 3 == 0) {
                i9 = i7;
                i10 = i8;
            }
            int i11 = i7 + 1;
            int i12 = bArr[i7 + i2] & 255;
            if (i12 > 127) {
                i12 -= 128;
                int i13 = i8 + 1;
                iArr[i8] = 1;
                i8 += 2;
                iArr[i13] = 30;
            }
            char c2 = (char) i12;
            int indexOf = str2.indexOf(c2);
            if (indexOf >= 0) {
                iArr[i8] = indexOf + 3;
                i8++;
            } else if (i12 < 32) {
                int i14 = i8 + 1;
                iArr[i8] = 0;
                i8 += 2;
                iArr[i14] = i12;
            } else {
                int indexOf2 = "!\"#$%&'()*+,-./:;<=>?@[\\]^_".indexOf(c2);
                if (indexOf2 >= 0) {
                    int i15 = i8 + 1;
                    iArr[i8] = 1;
                    i8 += 2;
                    iArr[i15] = indexOf2;
                } else {
                    int indexOf3 = str.indexOf(c2);
                    if (indexOf3 >= 0) {
                        int i16 = i8 + 1;
                        iArr[i8] = 2;
                        i8 += 2;
                        iArr[i16] = indexOf3;
                    }
                }
            }
            i7 = i11;
        }
        if (i8 % 3 != 0) {
            i7 = i9;
            i8 = i10;
        }
        if ((i8 / 3) * 2 > i5 - 2) {
            return -1;
        }
        int i17 = 1;
        for (int i18 = 0; i18 < i8; i18 += 3) {
            int i19 = (iArr[i18] * 1600) + (iArr[i18 + 1] * 40) + iArr[i18 + 2] + 1;
            int i20 = i17 + 1;
            bArr2[i4 + i17] = (byte) (i19 / 256);
            i17 += 2;
            bArr2[i4 + i20] = (byte) i19;
        }
        int i21 = i17 + 1;
        bArr2[i17] = -2;
        int d2 = d(bArr, i7, i6 - i7, bArr2, i21, i5 - i21);
        return d2 < 0 ? d2 : i21 + d2;
    }

    private static int b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9 = i3;
        int i10 = i5;
        if (i9 == 0) {
            return 0;
        }
        int i11 = 0;
        boolean z = true;
        int i12 = 0;
        int i13 = 18;
        int i14 = 0;
        while (i11 < i9) {
            byte b2 = bArr[i11 + i2];
            int i15 = b2 & 255;
            byte b3 = b2 & 224;
            if ((b3 == 64 || b3 == 32) && i15 != 95) {
                if (z) {
                    int i16 = i14 + 1;
                    if (i16 > i10) {
                        break;
                    }
                    bArr2[i4 + i14] = -16;
                    i14 = i16;
                    z = false;
                }
                i12 |= (b2 & Utf8.f31404a) << i13;
                if (i13 != 0) {
                    i13 -= 6;
                } else if (i14 + 3 > i10) {
                    break;
                } else {
                    bArr2[i4 + i14] = (byte) (i12 >> 16);
                    int i17 = i14 + 2;
                    bArr2[i4 + i14 + 1] = (byte) (i12 >> 8);
                    i14 += 3;
                    bArr2[i4 + i17] = (byte) i12;
                    i12 = 0;
                    i13 = 18;
                }
            } else {
                if (!z) {
                    i12 |= 31 << i13;
                    if ((i14 + 3) - (i13 / 8) > i10) {
                        break;
                    }
                    int i18 = i14 + 1;
                    bArr2[i4 + i14] = (byte) (i12 >> 16);
                    if (i13 <= 12) {
                        bArr2[i4 + i18] = (byte) (i12 >> 8);
                        i18 = i14 + 2;
                    }
                    if (i13 <= 6) {
                        bArr2[i4 + i18] = (byte) i12;
                        i14 = i18 + 1;
                    } else {
                        i14 = i18;
                    }
                    z = true;
                    i12 = 0;
                    i13 = 18;
                }
                if (i15 > 127) {
                    if (i14 >= i10) {
                        break;
                    }
                    bArr2[i4 + i14] = -21;
                    i15 -= 128;
                    i14++;
                }
                if (i14 >= i10) {
                    break;
                }
                bArr2[i4 + i14] = (byte) (i15 + 1);
                i14++;
            }
            i11++;
        }
        if (i11 != i9) {
            return -1;
        }
        int i19 = 0;
        while (true) {
            DmParams[] dmParamsArr = v;
            if (i19 >= dmParamsArr.length) {
                i6 = Integer.MAX_VALUE;
                break;
            }
            i6 = dmParamsArr[i19].f25884e;
            if (i6 >= i4 + i14 + (3 - (i13 / 6))) {
                break;
            }
            i19++;
        }
        if ((i6 - i4) - i14 <= 2 && i13 >= 6) {
            if (i13 <= 12) {
                byte b4 = (byte) ((i12 >> 18) & 63);
                if ((b4 & 32) == 0) {
                    b4 = (byte) (b4 | SignedBytes.f22967a);
                }
                bArr2[i4 + i14] = (byte) (b4 + 1);
                i14++;
            }
            if (i13 > 6) {
                return i14;
            }
            byte b5 = (byte) ((i12 >> 12) & 63);
            if ((b5 & 32) == 0) {
                b5 = (byte) (b5 | SignedBytes.f22967a);
            }
            i8 = i14 + 1;
            bArr2[i4 + i14] = (byte) (b5 + 1);
        } else if (z) {
            return i14;
        } else {
            int i20 = (31 << i13) | i12;
            if ((i14 + 3) - (i13 / 8) > i10) {
                return -1;
            }
            int i21 = i14 + 1;
            bArr2[i4 + i14] = (byte) (i20 >> 16);
            if (i13 <= 12) {
                i7 = i14 + 2;
                bArr2[i4 + i21] = (byte) (i20 >> 8);
            } else {
                i7 = i21;
            }
            if (i13 > 6) {
                return i7;
            }
            i8 = i7 + 1;
            bArr2[i4 + i7] = (byte) i20;
        }
        return i8;
    }

    private static int c(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte b2;
        int i6 = 0;
        if (i3 == 0) {
            return 0;
        }
        byte[] bArr3 = new byte[i3];
        int i7 = 0;
        int i8 = 0;
        while (true) {
            b2 = 100;
            if (i7 >= i3) {
                break;
            }
            int indexOf = w.indexOf((char) bArr[i7 + i2]);
            if (indexOf >= 0) {
                bArr3[i7] = (byte) indexOf;
                i8++;
            } else {
                bArr3[i7] = 100;
                if (i8 >= 6) {
                    i8 -= (i8 / 3) * 3;
                }
                for (int i9 = 0; i9 < i8; i9++) {
                    bArr3[(i7 - i9) - 1] = 100;
                }
                i8 = 0;
            }
            i7++;
        }
        if (i8 >= 6) {
            i8 -= (i8 / 3) * 3;
        }
        for (int i10 = 0; i10 < i8; i10++) {
            bArr3[(i7 - i10) - 1] = 100;
        }
        int i11 = 0;
        while (i6 < i3) {
            byte b3 = bArr3[i6];
            if (i11 >= i5) {
                break;
            }
            if (b3 < 40) {
                if (i6 == 0 || (i6 > 0 && bArr3[i6 - 1] > 40)) {
                    bArr2[i11 + i4] = -18;
                    i11++;
                }
                if (i11 + 2 > i5) {
                    break;
                }
                i6 += 2;
                int i12 = (bArr3[i6] * SignedBytes.f22967a) + (bArr3[i6 + 1] * 40) + bArr3[i6] + 1;
                int i13 = i11 + 1;
                bArr2[i4 + i11] = (byte) (i12 / 256);
                i11 += 2;
                bArr2[i13 + i4] = (byte) i12;
            } else {
                if (i6 > 0 && bArr3[i6 - 1] < 40) {
                    bArr2[i11 + i4] = -2;
                    i11++;
                }
                int i14 = bArr[i6 + i2] & 255;
                if (i14 > 127) {
                    bArr2[i11 + i4] = -21;
                    i14 -= 128;
                    i11++;
                }
                if (i11 >= i5) {
                    break;
                }
                bArr2[i11 + i4] = (byte) (i14 + 1);
                i11++;
            }
            i6++;
        }
        if (i3 > 0) {
            b2 = bArr3[i3 - 1];
        }
        if (i6 != i3) {
            return -1;
        }
        if (b2 < 40 && i11 >= i5) {
            return -1;
        }
        if (b2 >= 40) {
            return i11;
        }
        bArr2[i4 + i11] = -2;
        return i11 + 1;
    }

    private static int d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        int i6 = i3 + i2;
        int i7 = i5 + i4;
        int i8 = i4;
        while (i2 < i6) {
            if (i8 >= i7) {
                return -1;
            }
            int i9 = i2 + 1;
            byte b2 = bArr[i2] & 255;
            if (!q(b2) || i9 >= i6 || !q(bArr[i9] & 255)) {
                if (b2 > Byte.MAX_VALUE) {
                    int i10 = i8 + 1;
                    if (i10 >= i7) {
                        return -1;
                    }
                    bArr2[i8] = -21;
                    i8 += 2;
                    bArr2[i10] = (byte) (b2 - Byte.MAX_VALUE);
                } else {
                    bArr2[i8] = (byte) (b2 + 1);
                    i8++;
                }
                i2 = i9;
            } else {
                i2 += 2;
                bArr2[i8] = (byte) (((b2 - 48) * 10) + (bArr[i9] & 255) + 82);
                i8++;
            }
        }
        return i8 - i4;
    }

    private static int e(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        int i6;
        if (i3 == 0) {
            return 0;
        }
        if (i3 < 250 && i3 + 2 > i5) {
            return -1;
        }
        if (i3 >= 250 && i3 + 3 > i5) {
            return -1;
        }
        bArr2[i4] = -25;
        int i7 = i4 + 1;
        if (i3 < 250) {
            bArr2[i7] = (byte) i3;
            i6 = 2;
        } else {
            bArr2[i7] = (byte) ((i3 / ItemTouchHelper.Callback.f15380c) + 249);
            bArr2[i4 + 2] = (byte) (i3 % ItemTouchHelper.Callback.f15380c);
            i6 = 3;
        }
        System.arraycopy(bArr, i2, bArr2, i6 + i4, i3);
        int i8 = i6 + i3 + i4;
        int i9 = i4 + 1;
        while (i9 < i8) {
            int i10 = i9 + 1;
            int i11 = (bArr2[i9] & 255) + ((i10 * 149) % 255) + 1;
            if (i11 > 255) {
                i11 += InputDeviceCompat.u;
            }
            bArr2[i9] = (byte) i11;
            i9 = i10;
        }
        return i8 - i4;
    }

    private void g(byte[] bArr, int i2, DmParams dmParams) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = ((dmParams.f25881b + (this.f25878f * 2)) + 7) / 8;
        Arrays.fill(this.f25875c, (byte) 0);
        int i9 = this.f25878f;
        while (true) {
            int i10 = dmParams.f25880a;
            i3 = this.f25878f;
            if (i9 >= i10 + i3) {
                break;
            }
            while (i3 < dmParams.f25881b + this.f25878f) {
                u(i3, i9, i8);
                i3 += 2;
            }
            i9 += dmParams.f25882c;
        }
        int i11 = dmParams.f25882c - 1;
        while (true) {
            i11 += i3;
            int i12 = dmParams.f25880a;
            i4 = this.f25878f;
            if (i11 >= i12 + i4) {
                break;
            }
            while (i4 < dmParams.f25881b + this.f25878f) {
                u(i4, i11, i8);
                i4++;
            }
            i3 = dmParams.f25882c;
        }
        while (true) {
            int i13 = dmParams.f25881b;
            i5 = this.f25878f;
            if (i4 >= i13 + i5) {
                break;
            }
            while (i5 < dmParams.f25880a + this.f25878f) {
                u(i4, i5, i8);
                i5++;
            }
            i4 += dmParams.f25883d;
        }
        int i14 = dmParams.f25883d - 1;
        while (true) {
            i14 += i5;
            int i15 = dmParams.f25881b;
            int i16 = this.f25878f;
            if (i14 >= i15 + i16) {
                break;
            }
            for (int i17 = i16 + 1; i17 < dmParams.f25880a + this.f25878f; i17 += 2) {
                u(i14, i17, i8);
            }
            i5 = dmParams.f25883d;
        }
        int i18 = 0;
        int i19 = 0;
        while (i18 < dmParams.f25880a) {
            int i20 = 1;
            while (true) {
                i6 = dmParams.f25882c;
                if (i20 >= i6 - 1) {
                    break;
                }
                int i21 = 0;
                while (i21 < dmParams.f25881b) {
                    int i22 = 1;
                    while (true) {
                        i7 = dmParams.f25883d;
                        if (i22 >= i7 - 1) {
                            break;
                        }
                        int i23 = i19 + 1;
                        short s2 = this.f25874b[i19];
                        if (s2 != 1) {
                            if (s2 > 1) {
                                if (((128 >> (s2 % 8)) & bArr[(s2 / 8) - 1] & 255) == 0) {
                                }
                            }
                            i22++;
                            i19 = i23;
                        }
                        int i24 = this.f25878f;
                        u(i22 + i21 + i24, i20 + i18 + i24, i8);
                        i22++;
                        i19 = i23;
                    }
                    i21 += i7;
                }
                i20++;
            }
            i18 += i6;
        }
    }

    private static int j(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5, int i6, boolean z) {
        int i7 = i3;
        int i8 = i5;
        int[] iArr = new int[6];
        if (i8 < 0) {
            return -1;
        }
        int i9 = i6 & 7;
        if (i9 == 0) {
            int d2 = d(bArr, i2, i3, bArr2, i4, i5);
            iArr[0] = d2;
            if (z && d2 >= 0) {
                return d2;
            }
            int a2 = a(bArr, i2, i3, bArr2, i4, i5, false);
            iArr[1] = a2;
            if (z && a2 >= 0) {
                return a2;
            }
            int a3 = a(bArr, i2, i3, bArr2, i4, i5, true);
            iArr[2] = a3;
            if (z && a3 >= 0) {
                return a3;
            }
            int e2 = e(bArr, i2, i3, bArr2, i4, i5);
            iArr[3] = e2;
            if (z && e2 >= 0) {
                return e2;
            }
            int c2 = c(bArr, i2, i3, bArr2, i4, i5);
            iArr[4] = c2;
            if (z && c2 >= 0) {
                return c2;
            }
            int b2 = b(bArr, i2, i3, bArr2, i4, i5);
            iArr[5] = b2;
            if (z && b2 >= 0) {
                return b2;
            }
            if (iArr[0] < 0 && iArr[1] < 0 && iArr[2] < 0 && iArr[3] < 0 && iArr[4] < 0 && b2 < 0) {
                return -1;
            }
            int i10 = 99999;
            int i11 = 0;
            for (int i12 = 0; i12 < 6; i12++) {
                int i13 = iArr[i12];
                if (i13 >= 0 && i13 < i10) {
                    i10 = i13;
                    i11 = i12;
                }
            }
            if (i11 == 0) {
                return d(bArr, i2, i3, bArr2, i4, i5);
            }
            if (i11 == 1) {
                return a(bArr, i2, i3, bArr2, i4, i5, false);
            }
            if (i11 == 2) {
                return a(bArr, i2, i3, bArr2, i4, i5, true);
            }
            if (i11 == 3) {
                return e(bArr, i2, i3, bArr2, i4, i5);
            }
            return i11 == 4 ? c(bArr, i2, i3, bArr2, i4, i5) : i10;
        }
        switch (i9) {
            case 1:
                byte[] bArr3 = bArr;
                int i14 = i2;
                byte[] bArr4 = bArr2;
                int i15 = i4;
                return d(bArr, i2, i3, bArr2, i4, i5);
            case 2:
                return a(bArr, i2, i3, bArr2, i4, i5, true);
            case 3:
                return a(bArr, i2, i3, bArr2, i4, i5, false);
            case 4:
                byte[] bArr5 = bArr;
                int i16 = i2;
                byte[] bArr6 = bArr2;
                int i17 = i4;
                return e(bArr, i2, i3, bArr2, i4, i5);
            case 5:
                byte[] bArr7 = bArr;
                int i18 = i2;
                byte[] bArr8 = bArr2;
                int i19 = i4;
                return c(bArr, i2, i3, bArr2, i4, i5);
            case 6:
                byte[] bArr9 = bArr;
                int i20 = i2;
                byte[] bArr10 = bArr2;
                int i21 = i4;
                return b(bArr, i2, i3, bArr2, i4, i5);
            case 7:
                if (i7 > i8) {
                    return -1;
                }
                byte[] bArr11 = bArr;
                int i22 = i2;
                System.arraycopy(bArr, i2, bArr2, i4, i7);
                return i7;
            default:
                return -1;
        }
    }

    private static int m(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i2 + 1;
            byte b2 = bArr[i2] & 255;
            if (b2 < 48 || b2 > 57) {
                return -1;
            }
            i5 = ((i5 * 10) + b2) - 48;
            i4++;
            i2 = i6;
        }
        return i5;
    }

    private static boolean q(int i2) {
        return i2 >= 48 && i2 <= 57;
    }

    private static void r(byte[] bArr, int i2, int i3) {
        if (i3 > 0) {
            int i4 = i2 + 1;
            bArr[i2] = -127;
            while (true) {
                i3--;
                if (i3 > 0) {
                    int i5 = i4 + 1;
                    int i6 = (i5 * 149) % 253;
                    int i7 = i6 + TsExtractor.L;
                    if (i7 > 254) {
                        i7 = i6 - 124;
                    }
                    bArr[i4] = (byte) i7;
                    i4 = i5;
                } else {
                    return;
                }
            }
        }
    }

    private int t(byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4;
        int m2;
        int m3;
        int m4;
        int m5;
        byte b2;
        byte[] bArr3 = bArr;
        int i5 = i3;
        int i6 = 0;
        if ((this.f25879g & 32) == 0) {
            return 0;
        }
        int i7 = 0;
        int i8 = 0;
        while (i6 < i5 && i7 <= 20) {
            int i9 = i6 + 1;
            byte b3 = bArr3[i2 + i6] & 255;
            i7++;
            if (b3 == 46) {
                this.f25873a = i9;
                return i8;
            } else if (b3 != 109) {
                if (b3 != 112) {
                    if (b3 != 115) {
                        if (b3 == 101) {
                            i6 += 7;
                            if (i6 > i5 || (m5 = m(bArr3, i2 + i9, 6)) < 0) {
                                return -1;
                            }
                            int i10 = i8 + 1;
                            bArr2[i8] = -15;
                            if (m5 < 127) {
                                i8 += 2;
                                bArr2[i10] = (byte) (m5 + 1);
                            } else if (m5 < 16383) {
                                int i11 = i8 + 2;
                                int i12 = m5 - 127;
                                bArr2[i10] = (byte) ((i12 / TIFFConstants.f26648a) + 128);
                                i8 += 3;
                                bArr2[i11] = (byte) ((i12 % TIFFConstants.f26648a) + 1);
                            } else {
                                int i13 = m5 - 16383;
                                bArr2[i10] = (byte) ((i13 / 64516) + PsExtractor.x);
                                int i14 = i8 + 3;
                                bArr2[i8 + 2] = (byte) (((i13 / TIFFConstants.f26648a) % TIFFConstants.f26648a) + 1);
                                i8 += 4;
                                bArr2[i14] = (byte) ((i13 % TIFFConstants.f26648a) + 1);
                            }
                        } else if (b3 == 102) {
                            if (i7 != 1 && (i7 != 2 || ((b2 = bArr3[i2]) != 115 && b2 != 109))) {
                                return -1;
                            }
                            i4 = i8 + 1;
                            bArr2[i8] = -24;
                            i8 = i4;
                        }
                    } else if (i7 != 1 || i6 + 10 > i5 || (m2 = m(bArr3, i2 + i9, 2)) <= 0 || m2 > 16 || (m3 = m(bArr3, i2 + i6 + 3, 2)) <= 1 || m3 > 16 || (m4 = m(bArr3, i2 + i6 + 5, 5)) < 0 || m2 >= 64516) {
                        return -1;
                    } else {
                        i6 += 10;
                        bArr2[i8] = -23;
                        bArr2[i8 + 1] = (byte) (((m2 - 1) << 4) | (17 - m3));
                        int i15 = i8 + 3;
                        bArr2[i8 + 2] = (byte) ((m4 / TIFFConstants.f26648a) + 1);
                        i8 += 4;
                        bArr2[i15] = (byte) ((m4 % TIFFConstants.f26648a) + 1);
                    }
                } else if (i7 != 1) {
                    return -1;
                } else {
                    i4 = i8 + 1;
                    bArr2[i8] = -22;
                    i8 = i4;
                }
                i6 = i9;
            } else if (i7 != 1 || (i6 = i6 + 2) > i5) {
                return -1;
            } else {
                byte b4 = bArr3[i2 + i9] & 255;
                if (b4 != 53 && b4 != 53) {
                    return -1;
                }
                int i16 = i8 + 1;
                bArr2[i8] = -22;
                i8 += 2;
                bArr2[i16] = (byte) (b4 == 53 ? 236 : Jpeg.X4);
            }
        }
        return -1;
    }

    private void u(int i2, int i3, int i4) {
        byte[] bArr = this.f25875c;
        int i5 = (i3 * i4) + (i2 / 8);
        bArr[i5] = (byte) (((byte) (128 >> (i2 & 7))) | bArr[i5]);
    }

    public Image f() throws BadElementException {
        byte[] bArr = this.f25875c;
        if (bArr == null) {
            return null;
        }
        int i2 = this.f25877e;
        int i3 = this.f25878f;
        byte[] d2 = CCITTG4Encoder.d(bArr, i2 + (i3 * 2), this.f25876d + (i3 * 2));
        int i4 = this.f25877e;
        int i5 = this.f25878f;
        return Image.W0(i4 + (i5 * 2), this.f25876d + (i5 * 2), false, 256, 0, d2, (int[]) null);
    }

    public int h(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("iso-8859-1");
        return i(bytes, 0, bytes.length);
    }

    public int i(byte[] bArr, int i2, int i3) {
        DmParams dmParams;
        int i4;
        DmParams[] dmParamsArr;
        DmParams[] dmParamsArr2;
        int i5 = i2;
        int i6 = i3;
        byte[] bArr2 = new byte[DefaultLoadControl.o];
        this.f25873a = 0;
        int t2 = t(bArr, i5, i6, bArr2);
        if (t2 < 0) {
            return 5;
        }
        if (this.f25876d == 0 || this.f25877e == 0) {
            DmParams[] dmParamsArr3 = v;
            DmParams dmParams2 = dmParamsArr3[dmParamsArr3.length - 1];
            int i7 = this.f25873a;
            int j2 = j(bArr, i5 + i7, i6 - i7, bArr2, t2, dmParams2.f25884e - t2, this.f25879g, false);
            if (j2 < 0) {
                return 1;
            }
            i4 = j2 + t2;
            int i8 = 0;
            while (true) {
                dmParamsArr = v;
                if (i8 >= dmParamsArr.length || dmParamsArr[i8].f25884e >= i4) {
                    dmParams = dmParamsArr[i8];
                    this.f25876d = dmParams.f25880a;
                    this.f25877e = dmParams.f25881b;
                } else {
                    i8++;
                }
            }
            dmParams = dmParamsArr[i8];
            this.f25876d = dmParams.f25880a;
            this.f25877e = dmParams.f25881b;
        } else {
            int i9 = 0;
            while (true) {
                dmParamsArr2 = v;
                if (i9 >= dmParamsArr2.length) {
                    break;
                }
                int i10 = this.f25876d;
                DmParams dmParams3 = dmParamsArr2[i9];
                if (i10 == dmParams3.f25880a && this.f25877e == dmParams3.f25881b) {
                    break;
                }
                i9++;
            }
            if (i9 == dmParamsArr2.length) {
                return 3;
            }
            dmParams = dmParamsArr2[i9];
            int i11 = this.f25873a;
            int j3 = j(bArr, i5 + i11, i6 - i11, bArr2, t2, dmParams.f25884e - t2, this.f25879g, true);
            if (j3 < 0) {
                return 1;
            }
            i4 = j3 + t2;
        }
        if ((this.f25879g & 64) != 0) {
            return 0;
        }
        int i12 = dmParams.f25881b;
        int i13 = this.f25878f;
        this.f25875c = new byte[((((i12 + (i13 * 2)) + 7) / 8) * (dmParams.f25880a + (i13 * 2)))];
        r(bArr2, i4, dmParams.f25884e - i4);
        int i14 = dmParams.f25880a;
        int i15 = i14 - ((i14 / dmParams.f25882c) * 2);
        int i16 = dmParams.f25881b;
        this.f25874b = Placement.e(i15, i16 - ((i16 / dmParams.f25883d) * 2));
        int i17 = dmParams.f25884e;
        int i18 = dmParams.f25885f;
        int i19 = dmParams.f25886g;
        ReedSolomon.a(bArr2, i17, i18, i19);
        g(bArr2, (((i17 + 2) / i18) * i19) + i17, dmParams);
        return 0;
    }

    public int k() {
        return this.f25876d;
    }

    public byte[] l() {
        return this.f25875c;
    }

    public int n() {
        return this.f25879g;
    }

    public int o() {
        return this.f25877e;
    }

    public int p() {
        return this.f25878f;
    }

    public void s(PdfContentByte pdfContentByte, BaseColor baseColor, float f2, float f3) {
        int i2 = this.f25877e;
        int i3 = this.f25878f;
        int i4 = i2 + (i3 * 2);
        int i5 = this.f25876d + (i3 * 2);
        int i6 = (i4 + 7) / 8;
        pdfContentByte.h2(baseColor);
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i7 * i6;
            for (int i9 = 0; i9 < i4; i9++) {
                if ((((this.f25875c[(i9 / 8) + i8] & 255) << (i9 % 8)) & 128) != 0) {
                    pdfContentByte.H1(((float) i9) * f3, ((float) ((i5 - i7) - 1)) * f2, f3, f2);
                }
            }
        }
        pdfContentByte.Q0();
    }

    public void v(int i2) {
        this.f25876d = i2;
    }

    public void w(int i2) {
        this.f25879g = i2;
    }

    public void x(int i2) {
        this.f25877e = i2;
    }

    public void y(int i2) {
        this.f25878f = i2;
    }
}
