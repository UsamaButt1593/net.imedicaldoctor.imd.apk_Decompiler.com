package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class StandardGifDecoder implements GifDecoder {
    private static final String A = "StandardGifDecoder";
    private static final int B = 4096;
    private static final int C = -1;
    private static final int D = -1;
    private static final int E = 4;
    private static final int F = 255;
    @ColorInt
    private static final int G = 0;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    private int[] f17810f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    private final int[] f17811g;

    /* renamed from: h  reason: collision with root package name */
    private final GifDecoder.BitmapProvider f17812h;

    /* renamed from: i  reason: collision with root package name */
    private ByteBuffer f17813i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f17814j;

    /* renamed from: k  reason: collision with root package name */
    private GifHeaderParser f17815k;

    /* renamed from: l  reason: collision with root package name */
    private short[] f17816l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f17817m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f17818n;
    private byte[] o;
    @ColorInt
    private int[] p;
    private int q;
    private GifHeader r;
    private Bitmap s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private int x;
    @Nullable
    private Boolean y;
    @NonNull
    private Bitmap.Config z;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.f17811g = new int[256];
        this.z = Bitmap.Config.ARGB_8888;
        this.f17812h = bitmapProvider;
        this.r = new GifHeader();
    }

    @ColorInt
    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.v + i2; i10++) {
            byte[] bArr = this.o;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f17810f[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.v + i12; i13++) {
            byte[] bArr2 = this.o;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f17810f[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    private void b(GifFrame gifFrame) {
        Boolean bool;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.p;
        int i7 = gifFrame2.f17774d;
        int i8 = this.v;
        int i9 = i7 / i8;
        int i10 = gifFrame2.f17772b / i8;
        int i11 = gifFrame2.f17773c / i8;
        int i12 = gifFrame2.f17771a / i8;
        boolean z2 = this.q == 0;
        int i13 = this.x;
        int i14 = this.w;
        byte[] bArr = this.o;
        int[] iArr2 = this.f17810f;
        Boolean bool2 = this.y;
        int i15 = 8;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        while (true) {
            bool = bool2;
            if (i17 >= i9) {
                break;
            }
            if (gifFrame2.f17775e) {
                if (i16 >= i9) {
                    int i19 = i18 + 1;
                    i2 = i9;
                    if (i19 == 2) {
                        i18 = i19;
                        i16 = 4;
                    } else if (i19 != 3) {
                        i18 = i19;
                        if (i19 == 4) {
                            i16 = 1;
                            i15 = 2;
                        }
                    } else {
                        i18 = i19;
                        i16 = 2;
                        i15 = 4;
                    }
                } else {
                    i2 = i9;
                }
                i3 = i16 + i15;
            } else {
                i2 = i9;
                i3 = i16;
                i16 = i17;
            }
            int i20 = i16 + i10;
            boolean z3 = i8 == 1;
            if (i20 < i14) {
                int i21 = i20 * i13;
                int i22 = i21 + i12;
                int i23 = i22 + i11;
                int i24 = i21 + i13;
                if (i24 < i23) {
                    i23 = i24;
                }
                i4 = i3;
                int i25 = i17 * i8 * gifFrame2.f17773c;
                if (z3) {
                    int i26 = i22;
                    while (true) {
                        i5 = i10;
                        if (i26 >= i23) {
                            break;
                        }
                        int i27 = iArr2[bArr[i25] & 255];
                        if (i27 != 0) {
                            iArr[i26] = i27;
                        } else if (z2 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i25 += i8;
                        i26++;
                        i10 = i5;
                    }
                } else {
                    i5 = i10;
                    int i28 = ((i23 - i22) * i8) + i25;
                    int i29 = i22;
                    while (true) {
                        i6 = i11;
                        if (i29 >= i23) {
                            break;
                        }
                        int a2 = a(i25, i28, gifFrame2.f17773c);
                        if (a2 != 0) {
                            iArr[i29] = a2;
                        } else if (z2 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i25 += i8;
                        i29++;
                        i11 = i6;
                    }
                    bool2 = bool;
                    i17++;
                    i10 = i5;
                    i9 = i2;
                    i11 = i6;
                    i16 = i4;
                }
            } else {
                i4 = i3;
                i5 = i10;
            }
            i6 = i11;
            bool2 = bool;
            i17++;
            i10 = i5;
            i9 = i2;
            i11 = i6;
            i16 = i4;
        }
        if (this.y == null) {
            this.y = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    private void c(GifFrame gifFrame) {
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.p;
        int i2 = gifFrame2.f17774d;
        int i3 = gifFrame2.f17772b;
        int i4 = gifFrame2.f17773c;
        int i5 = gifFrame2.f17771a;
        boolean z2 = this.q == 0;
        int i6 = this.x;
        byte[] bArr = this.o;
        int[] iArr2 = this.f17810f;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = gifFrame2.f17773c * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b3 = bArr[i12];
                int i14 = i2;
                byte b4 = b3 & 255;
                if (b4 != b2) {
                    int i15 = iArr2[b4];
                    if (i15 != 0) {
                        iArr[i13] = i15;
                    } else {
                        b2 = b3;
                    }
                }
                i12++;
                i13++;
                GifFrame gifFrame3 = gifFrame;
                i2 = i14;
            }
            int i16 = i2;
            i7++;
            gifFrame2 = gifFrame;
        }
        Boolean bool = this.y;
        this.y = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.y == null && z2 && b2 != -1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void u(com.bumptech.glide.gifdecoder.GifFrame r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.f17813i
            int r3 = r1.f17780j
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0018
            com.bumptech.glide.gifdecoder.GifHeader r1 = r0.r
            int r2 = r1.f17788f
            int r1 = r1.f17789g
        L_0x0015:
            int r2 = r2 * r1
            goto L_0x001d
        L_0x0018:
            int r2 = r1.f17773c
            int r1 = r1.f17774d
            goto L_0x0015
        L_0x001d:
            byte[] r1 = r0.o
            if (r1 == 0) goto L_0x0024
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002c
        L_0x0024:
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r1 = r0.f17812h
            byte[] r1 = r1.e(r2)
            r0.o = r1
        L_0x002c:
            byte[] r1 = r0.o
            short[] r3 = r0.f17816l
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0038
            short[] r3 = new short[r4]
            r0.f17816l = r3
        L_0x0038:
            short[] r3 = r0.f17816l
            byte[] r5 = r0.f17817m
            if (r5 != 0) goto L_0x0042
            byte[] r5 = new byte[r4]
            r0.f17817m = r5
        L_0x0042:
            byte[] r5 = r0.f17817m
            byte[] r6 = r0.f17818n
            if (r6 != 0) goto L_0x004e
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.f17818n = r6
        L_0x004e:
            byte[] r6 = r0.f17818n
            int r7 = r28.y()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = 0
        L_0x0061:
            if (r14 >= r9) goto L_0x006b
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x0061
        L_0x006b:
            byte[] r14 = r0.f17814j
            r15 = -1
            r23 = r7
            r21 = r11
            r22 = r12
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r24 = -1
            r25 = 0
            r26 = 0
        L_0x0084:
            if (r13 >= r2) goto L_0x0091
            if (r16 != 0) goto L_0x0098
            int r16 = r28.x()
            if (r16 > 0) goto L_0x0096
            r3 = 3
            r0.u = r3
        L_0x0091:
            r13 = r20
            r0 = 0
            goto L_0x0150
        L_0x0096:
            r17 = 0
        L_0x0098:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r8 = r21
            r15 = r23
            r0 = r24
            r23 = r7
            r7 = r25
        L_0x00b2:
            if (r4 < r15) goto L_0x013a
            r24 = r11
            r11 = r19 & r22
            int r19 = r19 >> r15
            int r4 = r4 - r15
            if (r11 != r9) goto L_0x00c6
            r22 = r12
            r15 = r23
            r8 = r24
            r11 = r8
            r0 = -1
            goto L_0x00b2
        L_0x00c6:
            if (r11 != r10) goto L_0x00dd
            r18 = r4
            r25 = r7
            r21 = r8
            r7 = r23
            r11 = r24
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r24 = r0
            r23 = r15
            r15 = -1
            r0 = r28
            goto L_0x0084
        L_0x00dd:
            r25 = r4
            r4 = -1
            if (r0 != r4) goto L_0x00f1
            byte r0 = r5[r11]
            r1[r20] = r0
            int r20 = r20 + 1
            int r13 = r13 + 1
            r0 = r11
            r7 = r0
            r11 = r24
            r4 = r25
            goto L_0x00b2
        L_0x00f1:
            if (r11 < r8) goto L_0x00fa
            byte r7 = (byte) r7
            r6[r26] = r7
            int r26 = r26 + 1
            r7 = r0
            goto L_0x00fb
        L_0x00fa:
            r7 = r11
        L_0x00fb:
            if (r7 < r9) goto L_0x0106
            byte r21 = r5[r7]
            r6[r26] = r21
            int r26 = r26 + 1
            short r7 = r3[r7]
            goto L_0x00fb
        L_0x0106:
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r7
            r1[r20] = r4
        L_0x010d:
            int r20 = r20 + 1
            int r13 = r13 + 1
            if (r26 <= 0) goto L_0x011a
            int r26 = r26 + -1
            byte r27 = r6[r26]
            r1[r20] = r27
            goto L_0x010d
        L_0x011a:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x0131
            short r0 = (short) r0
            r3[r8] = r0
            r5[r8] = r4
            int r8 = r8 + 1
            r0 = r8 & r22
            if (r0 != 0) goto L_0x0131
            if (r8 >= r6) goto L_0x0131
            int r15 = r15 + 1
            int r22 = r22 + r8
        L_0x0131:
            r0 = r11
            r11 = r24
            r4 = r25
            r6 = r27
            goto L_0x00b2
        L_0x013a:
            r25 = r4
            r24 = r0
            r21 = r8
            r18 = r25
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r0 = r28
            r25 = r7
            r7 = r23
            r23 = r15
            r15 = -1
            goto L_0x0084
        L_0x0150:
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.u(com.bumptech.glide.gifdecoder.GifFrame):void");
    }

    @NonNull
    private GifHeaderParser v() {
        if (this.f17815k == null) {
            this.f17815k = new GifHeaderParser();
        }
        return this.f17815k;
    }

    private Bitmap w() {
        Boolean bool = this.y;
        Bitmap a2 = this.f17812h.a(this.x, this.w, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.z);
        a2.setHasAlpha(true);
        return a2;
    }

    private int x() {
        int y2 = y();
        if (y2 <= 0) {
            return y2;
        }
        ByteBuffer byteBuffer = this.f17813i;
        byteBuffer.get(this.f17814j, 0, Math.min(y2, byteBuffer.remaining()));
        return y2;
    }

    private int y() {
        return this.f17813i.get() & 255;
    }

    private Bitmap z(GifFrame gifFrame, GifFrame gifFrame2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.p;
        int i4 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.s;
            if (bitmap2 != null) {
                this.f17812h.c(bitmap2);
            }
            this.s = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.f17777g == 3 && this.s == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i3 = gifFrame2.f17777g) > 0) {
            if (i3 == 2) {
                if (!gifFrame.f17776f) {
                    GifHeader gifHeader = this.r;
                    int i5 = gifHeader.f17794l;
                    if (gifFrame.f17781k == null || gifHeader.f17792j != gifFrame.f17778h) {
                        i4 = i5;
                    }
                }
                int i6 = gifFrame2.f17774d;
                int i7 = this.v;
                int i8 = i6 / i7;
                int i9 = gifFrame2.f17772b / i7;
                int i10 = gifFrame2.f17773c / i7;
                int i11 = gifFrame2.f17771a / i7;
                int i12 = this.x;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.x;
                }
            } else if (i3 == 3 && (bitmap = this.s) != null) {
                int i17 = this.x;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.w);
            }
        }
        u(gifFrame);
        if (gifFrame.f17775e || this.v != 1) {
            b(gifFrame);
        } else {
            c(gifFrame);
        }
        if (this.t && ((i2 = gifFrame.f17777g) == 0 || i2 == 1)) {
            if (this.s == null) {
                this.s = w();
            }
            Bitmap bitmap3 = this.s;
            int i18 = this.x;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.w);
        }
        Bitmap w2 = w();
        int i19 = this.x;
        w2.setPixels(iArr, 0, i19, 0, 0, i19, this.w);
        return w2;
    }

    public void clear() {
        this.r = null;
        byte[] bArr = this.o;
        if (bArr != null) {
            this.f17812h.d(bArr);
        }
        int[] iArr = this.p;
        if (iArr != null) {
            this.f17812h.f(iArr);
        }
        Bitmap bitmap = this.s;
        if (bitmap != null) {
            this.f17812h.c(bitmap);
        }
        this.s = null;
        this.f17813i = null;
        this.y = null;
        byte[] bArr2 = this.f17814j;
        if (bArr2 != null) {
            this.f17812h.d(bArr2);
        }
    }

    public int d() {
        return this.u;
    }

    public int e(@Nullable InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e2) {
                Log.w(A, "Error reading data from stream", e2);
            }
        } else {
            this.u = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                Log.w(A, "Error closing stream", e3);
            }
        }
        return this.u;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e7, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A[Catch:{ all -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d0 A[Catch:{ all -> 0x000e }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap f() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.bumptech.glide.gifdecoder.GifHeader r0 = r8.r     // Catch:{ all -> 0x000e }
            int r0 = r0.f17785c     // Catch:{ all -> 0x000e }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x0011
            int r0 = r8.q     // Catch:{ all -> 0x000e }
            if (r0 >= 0) goto L_0x003d
            goto L_0x0011
        L_0x000e:
            r0 = move-exception
            goto L_0x00e8
        L_0x0011:
            java.lang.String r0 = A     // Catch:{ all -> 0x000e }
            boolean r3 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x000e }
            if (r3 == 0) goto L_0x003b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r3.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x000e }
            com.bumptech.glide.gifdecoder.GifHeader r4 = r8.r     // Catch:{ all -> 0x000e }
            int r4 = r4.f17785c     // Catch:{ all -> 0x000e }
            r3.append(r4)     // Catch:{ all -> 0x000e }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x000e }
            int r4 = r8.q     // Catch:{ all -> 0x000e }
            r3.append(r4)     // Catch:{ all -> 0x000e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x000e }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x000e }
        L_0x003b:
            r8.u = r2     // Catch:{ all -> 0x000e }
        L_0x003d:
            int r0 = r8.u     // Catch:{ all -> 0x000e }
            r3 = 0
            if (r0 == r2) goto L_0x00c8
            r4 = 2
            if (r0 != r4) goto L_0x0047
            goto L_0x00c8
        L_0x0047:
            r0 = 0
            r8.u = r0     // Catch:{ all -> 0x000e }
            byte[] r5 = r8.f17814j     // Catch:{ all -> 0x000e }
            if (r5 != 0) goto L_0x0058
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r5 = r8.f17812h     // Catch:{ all -> 0x000e }
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.e(r6)     // Catch:{ all -> 0x000e }
            r8.f17814j = r5     // Catch:{ all -> 0x000e }
        L_0x0058:
            com.bumptech.glide.gifdecoder.GifHeader r5 = r8.r     // Catch:{ all -> 0x000e }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r5 = r5.f17787e     // Catch:{ all -> 0x000e }
            int r6 = r8.q     // Catch:{ all -> 0x000e }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x000e }
            com.bumptech.glide.gifdecoder.GifFrame r5 = (com.bumptech.glide.gifdecoder.GifFrame) r5     // Catch:{ all -> 0x000e }
            int r6 = r8.q     // Catch:{ all -> 0x000e }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0074
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.r     // Catch:{ all -> 0x000e }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r7 = r7.f17787e     // Catch:{ all -> 0x000e }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x000e }
            com.bumptech.glide.gifdecoder.GifFrame r6 = (com.bumptech.glide.gifdecoder.GifFrame) r6     // Catch:{ all -> 0x000e }
            goto L_0x0075
        L_0x0074:
            r6 = r3
        L_0x0075:
            int[] r7 = r5.f17781k     // Catch:{ all -> 0x000e }
            if (r7 == 0) goto L_0x007a
            goto L_0x007e
        L_0x007a:
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.r     // Catch:{ all -> 0x000e }
            int[] r7 = r7.f17783a     // Catch:{ all -> 0x000e }
        L_0x007e:
            r8.f17810f = r7     // Catch:{ all -> 0x000e }
            if (r7 != 0) goto L_0x00a4
            java.lang.String r0 = A     // Catch:{ all -> 0x000e }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x00a0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r1.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.append(r4)     // Catch:{ all -> 0x000e }
            int r4 = r8.q     // Catch:{ all -> 0x000e }
            r1.append(r4)     // Catch:{ all -> 0x000e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x000e }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x000e }
        L_0x00a0:
            r8.u = r2     // Catch:{ all -> 0x000e }
            monitor-exit(r8)
            return r3
        L_0x00a4:
            boolean r1 = r5.f17776f     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x00c2
            int[] r1 = r8.f17811g     // Catch:{ all -> 0x000e }
            int r2 = r7.length     // Catch:{ all -> 0x000e }
            java.lang.System.arraycopy(r7, r0, r1, r0, r2)     // Catch:{ all -> 0x000e }
            int[] r1 = r8.f17811g     // Catch:{ all -> 0x000e }
            r8.f17810f = r1     // Catch:{ all -> 0x000e }
            int r2 = r5.f17778h     // Catch:{ all -> 0x000e }
            r1[r2] = r0     // Catch:{ all -> 0x000e }
            int r0 = r5.f17777g     // Catch:{ all -> 0x000e }
            if (r0 != r4) goto L_0x00c2
            int r0 = r8.q     // Catch:{ all -> 0x000e }
            if (r0 != 0) goto L_0x00c2
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x000e }
            r8.y = r0     // Catch:{ all -> 0x000e }
        L_0x00c2:
            android.graphics.Bitmap r0 = r8.z(r5, r6)     // Catch:{ all -> 0x000e }
            monitor-exit(r8)
            return r0
        L_0x00c8:
            java.lang.String r0 = A     // Catch:{ all -> 0x000e }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x00e6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r1.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x000e }
            int r2 = r8.u     // Catch:{ all -> 0x000e }
            r1.append(r2)     // Catch:{ all -> 0x000e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x000e }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x000e }
        L_0x00e6:
            monitor-exit(r8)
            return r3
        L_0x00e8:
            monitor-exit(r8)     // Catch:{ all -> 0x000e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.f():android.graphics.Bitmap");
    }

    public void g() {
        this.q = (this.q + 1) % this.r.f17785c;
    }

    @NonNull
    public ByteBuffer getData() {
        return this.f17813i;
    }

    public int getHeight() {
        return this.r.f17789g;
    }

    public int getWidth() {
        return this.r.f17788f;
    }

    public synchronized void h(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        n(gifHeader, ByteBuffer.wrap(bArr));
    }

    public int i() {
        return this.r.f17785c;
    }

    public int j() {
        int i2;
        if (this.r.f17785c <= 0 || (i2 = this.q) < 0) {
            return 0;
        }
        return l(i2);
    }

    public void k(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.z = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    public int l(int i2) {
        if (i2 >= 0) {
            GifHeader gifHeader = this.r;
            if (i2 < gifHeader.f17785c) {
                return gifHeader.f17787e.get(i2).f17779i;
            }
        }
        return -1;
    }

    public void m() {
        this.q = -1;
    }

    public synchronized void n(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        p(gifHeader, byteBuffer, 1);
    }

    public int o() {
        return this.q;
    }

    public synchronized void p(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            try {
                int highestOneBit = Integer.highestOneBit(i2);
                this.u = 0;
                this.r = gifHeader;
                this.q = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f17813i = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f17813i.order(ByteOrder.LITTLE_ENDIAN);
                this.t = false;
                Iterator<GifFrame> it2 = gifHeader.f17787e.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().f17777g == 3) {
                            this.t = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.v = highestOneBit;
                int i3 = gifHeader.f17788f;
                this.x = i3 / highestOneBit;
                int i4 = gifHeader.f17789g;
                this.w = i4 / highestOneBit;
                this.o = this.f17812h.e(i3 * i4);
                this.p = this.f17812h.b(this.x * this.w);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    public int q() {
        return this.r.f17795m;
    }

    public int r() {
        return this.f17813i.limit() + this.o.length + (this.p.length * 4);
    }

    public synchronized int read(@Nullable byte[] bArr) {
        try {
            GifHeader d2 = v().r(bArr).d();
            this.r = d2;
            if (bArr != null) {
                h(d2, bArr);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.u;
    }

    public int s() {
        int i2 = this.r.f17795m;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 + 1;
    }

    @Deprecated
    public int t() {
        int i2 = this.r.f17795m;
        if (i2 == -1) {
            return 1;
        }
        return i2;
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i2) {
        this(bitmapProvider);
        p(gifHeader, byteBuffer, i2);
    }
}
