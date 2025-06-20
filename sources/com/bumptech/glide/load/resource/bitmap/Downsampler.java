package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {

    /* renamed from: f  reason: collision with root package name */
    static final String f18275f = "Downsampler";

    /* renamed from: g  reason: collision with root package name */
    public static final Option<DecodeFormat> f18276g = Option.g("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.Y);

    /* renamed from: h  reason: collision with root package name */
    public static final Option<PreferredColorSpace> f18277h = Option.g("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    @Deprecated

    /* renamed from: i  reason: collision with root package name */
    public static final Option<DownsampleStrategy> f18278i = DownsampleStrategy.f18273h;

    /* renamed from: j  reason: collision with root package name */
    public static final Option<Boolean> f18279j;

    /* renamed from: k  reason: collision with root package name */
    public static final Option<Boolean> f18280k;

    /* renamed from: l  reason: collision with root package name */
    private static final String f18281l = "image/vnd.wap.wbmp";

    /* renamed from: m  reason: collision with root package name */
    private static final String f18282m = "image/x-ico";

    /* renamed from: n  reason: collision with root package name */
    private static final Set<String> f18283n = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{f18281l, f18282m})));
    private static final DecodeCallbacks o = new DecodeCallbacks() {
        public void a(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        public void b() {
        }
    };
    private static final Set<ImageHeaderParser.ImageType> p = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> q = Util.f(0);

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f18284a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayMetrics f18285b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f18286c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageHeaderParser> f18287d;

    /* renamed from: e  reason: collision with root package name */
    private final HardwareConfigState f18288e = HardwareConfigState.a();

    public interface DecodeCallbacks {
        void a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f18279j = Option.g("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f18280k = Option.g("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f18287d = list;
        this.f18285b = (DisplayMetrics) Preconditions.d(displayMetrics);
        this.f18284a = (BitmapPool) Preconditions.d(bitmapPool);
        this.f18286c = (ArrayPool) Preconditions.d(arrayPool);
    }

    private static int a(double d2) {
        int l2 = l(d2);
        int x = x(((double) l2) * d2);
        return x((d2 / ((double) (((float) x) / ((float) l2)))) * ((double) x));
    }

    private void b(ImageReader imageReader, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        boolean z3;
        if (!this.f18288e.e(i2, i3, options, z, z2)) {
            if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
                try {
                    z3 = imageReader.d().hasAlpha();
                } catch (IOException e2) {
                    if (Log.isLoggable(f18275f, 3)) {
                        Log.d(f18275f, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
                    }
                    z3 = false;
                }
                Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                options.inPreferredConfig = config;
                if (config == Bitmap.Config.RGB_565) {
                    options.inDither = true;
                    return;
                }
                return;
            }
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        BitmapFactory.Options options2 = options;
        if (i12 <= 0 || i13 <= 0) {
            String str = f18275f;
            String str2 = "x";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to determine dimensions for: " + imageType2 + " with target [" + i14 + str2 + i15 + "]");
                return;
            }
            return;
        }
        if (r(i2)) {
            i7 = i12;
            i8 = i13;
        } else {
            i8 = i12;
            i7 = i13;
        }
        float b2 = downsampleStrategy2.b(i8, i7, i14, i15);
        if (b2 > 0.0f) {
            DownsampleStrategy.SampleSizeRounding a2 = downsampleStrategy2.a(i8, i7, i14, i15);
            if (a2 != null) {
                float f2 = (float) i8;
                float f3 = (float) i7;
                int x = i8 / x((double) (b2 * f2));
                int x2 = i7 / x((double) (b2 * f3));
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                int max = a2 == sampleSizeRounding ? Math.max(x, x2) : Math.min(x, x2);
                int i16 = Build.VERSION.SDK_INT;
                String str3 = "x";
                String str4 = f18275f;
                if (i16 > 23 || !f18283n.contains(options2.outMimeType)) {
                    int max2 = Math.max(1, Integer.highestOneBit(max));
                    if (a2 == sampleSizeRounding && ((float) max2) < 1.0f / b2) {
                        max2 <<= 1;
                    }
                    i9 = max2;
                } else {
                    i9 = 1;
                }
                options2.inSampleSize = i9;
                if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                    float min = (float) Math.min(i9, 8);
                    i10 = (int) Math.ceil((double) (f2 / min));
                    i11 = (int) Math.ceil((double) (f3 / min));
                    int i17 = i9 / 8;
                    if (i17 > 0) {
                        i10 /= i17;
                        i11 /= i17;
                    }
                } else {
                    if (!(imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A)) {
                        if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                            if (i16 >= 24) {
                                float f4 = (float) i9;
                                i10 = Math.round(f2 / f4);
                                i11 = Math.round(f3 / f4);
                            }
                        } else if (i8 % i9 == 0 && i7 % i9 == 0) {
                            i10 = i8 / i9;
                            i11 = i7 / i9;
                        } else {
                            int[] m2 = m(imageReader, options2, decodeCallbacks, bitmapPool);
                            i10 = m2[0];
                            i11 = m2[1];
                        }
                    }
                    float f5 = (float) i9;
                    i10 = (int) Math.floor((double) (f2 / f5));
                    i11 = (int) Math.floor((double) (f3 / f5));
                }
                double b3 = (double) downsampleStrategy2.b(i10, i11, i14, i15);
                options2.inTargetDensity = a(b3);
                options2.inDensity = l(b3);
                if (s(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                String str5 = str4;
                if (Log.isLoggable(str5, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculate scaling, source: [");
                    sb.append(i3);
                    String str6 = str3;
                    sb.append(str6);
                    sb.append(i4);
                    sb.append("], degreesToRotate: ");
                    sb.append(i2);
                    sb.append(", target: [");
                    sb.append(i14);
                    sb.append(str6);
                    sb.append(i15);
                    sb.append("], power of two scaled: [");
                    sb.append(i10);
                    sb.append(str6);
                    sb.append(i11);
                    sb.append("], exact scale factor: ");
                    sb.append(b2);
                    sb.append(", power of 2 sample size: ");
                    sb.append(i9);
                    sb.append(", adjusted scale factor: ");
                    sb.append(b3);
                    sb.append(", target density: ");
                    sb.append(options2.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options2.inDensity);
                    Log.v(str5, sb.toString());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        int i18 = i12;
        String str7 = "x";
        throw new IllegalArgumentException("Cannot scale with factor: " + b2 + " from: " + downsampleStrategy2 + ", source: [" + i18 + str7 + i13 + "], target: [" + i14 + str7 + i15 + "]");
    }

    private Resource<Bitmap> e(ImageReader imageReader, int i2, int i3, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Options options2 = options;
        byte[] bArr = (byte[]) this.f18286c.f(65536, byte[].class);
        BitmapFactory.Options k2 = k();
        k2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options2.c(f18276g);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options2.c(f18277h);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options2.c(DownsampleStrategy.f18273h);
        boolean booleanValue = ((Boolean) options2.c(f18279j)).booleanValue();
        Option option = f18280k;
        try {
            return BitmapResource.e(h(imageReader, k2, downsampleStrategy, decodeFormat, preferredColorSpace, options2.c(option) != null && ((Boolean) options2.c(option)).booleanValue(), i2, i3, booleanValue, decodeCallbacks), this.f18284a);
        } finally {
            v(k2);
            this.f18286c.put(bArr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0162, code lost:
        if (r0 >= 26) goto L_0x0164;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap h(com.bumptech.glide.load.resource.bitmap.ImageReader r27, android.graphics.BitmapFactory.Options r28, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r29, com.bumptech.glide.load.DecodeFormat r30, com.bumptech.glide.load.PreferredColorSpace r31, boolean r32, int r33, int r34, boolean r35, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r36) throws java.io.IOException {
        /*
            r26 = this;
            r8 = r26
            r7 = r27
            r6 = r28
            r5 = r36
            long r20 = com.bumptech.glide.util.LogTime.b()
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r0 = r8.f18284a
            int[] r0 = m(r7, r6, r5, r0)
            r1 = 0
            r4 = r0[r1]
            r2 = 1
            r3 = r0[r2]
            java.lang.String r2 = r6.outMimeType
            r0 = -1
            if (r4 == r0) goto L_0x0023
            if (r3 != r0) goto L_0x0020
            goto L_0x0023
        L_0x0020:
            r22 = r32
            goto L_0x0025
        L_0x0023:
            r22 = 0
        L_0x0025:
            int r1 = r27.a()
            int r14 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.j(r1)
            boolean r23 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.m(r1)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r15 = r33
            if (r15 != r0) goto L_0x0045
            boolean r9 = r(r14)
            r13 = r34
            if (r9 == 0) goto L_0x0042
            r24 = r3
            goto L_0x0049
        L_0x0042:
            r24 = r4
            goto L_0x0049
        L_0x0045:
            r13 = r34
            r24 = r15
        L_0x0049:
            if (r13 != r0) goto L_0x0057
            boolean r0 = r(r14)
            if (r0 == 0) goto L_0x0054
            r25 = r4
            goto L_0x0059
        L_0x0054:
            r25 = r3
            goto L_0x0059
        L_0x0057:
            r25 = r13
        L_0x0059:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r0 = r27.d()
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r12 = r8.f18284a
            r9 = r0
            r10 = r27
            r11 = r36
            r13 = r29
            r15 = r4
            r16 = r3
            r17 = r24
            r18 = r25
            r19 = r28
            c(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r26
            r15 = r1
            r1 = r27
            r11 = r2
            r2 = r30
            r10 = r3
            r3 = r22
            r12 = r4
            r4 = r23
            r13 = r5
            r5 = r28
            r14 = r6
            r6 = r24
            r29 = r15
            r15 = r7
            r7 = r25
            r0.b(r1, r2, r3, r4, r5, r6, r7)
            int r0 = android.os.Build.VERSION.SDK_INT
            boolean r1 = r8.z(r9)
            java.lang.String r3 = "Downsampler"
            if (r1 == 0) goto L_0x0139
            if (r12 < 0) goto L_0x00a5
            if (r10 < 0) goto L_0x00a5
            if (r35 == 0) goto L_0x00a5
            r6 = r3
            r2 = r24
            r3 = r25
            goto L_0x012f
        L_0x00a5:
            boolean r1 = s(r28)
            if (r1 == 0) goto L_0x00b3
            int r1 = r14.inTargetDensity
            float r1 = (float) r1
            int r4 = r14.inDensity
            float r4 = (float) r4
            float r1 = r1 / r4
            goto L_0x00b5
        L_0x00b3:
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x00b5:
            int r4 = r14.inSampleSize
            float r5 = (float) r12
            float r6 = (float) r4
            float r5 = r5 / r6
            r32 = r3
            double r2 = (double) r5
            double r2 = java.lang.Math.ceil(r2)
            int r2 = (int) r2
            float r3 = (float) r10
            float r3 = r3 / r6
            double r5 = (double) r3
            double r5 = java.lang.Math.ceil(r5)
            int r3 = (int) r5
            float r2 = (float) r2
            float r2 = r2 * r1
            int r2 = java.lang.Math.round(r2)
            float r3 = (float) r3
            float r3 = r3 * r1
            int r3 = java.lang.Math.round(r3)
            r6 = r32
            r5 = 2
            boolean r7 = android.util.Log.isLoggable(r6, r5)
            if (r7 == 0) goto L_0x012f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Calculated target ["
            r5.append(r7)
            r5.append(r2)
            java.lang.String r7 = "x"
            r5.append(r7)
            r5.append(r3)
            java.lang.String r9 = "] for source ["
            r5.append(r9)
            r5.append(r12)
            r5.append(r7)
            r5.append(r10)
            java.lang.String r7 = "], sampleSize: "
            r5.append(r7)
            r5.append(r4)
            java.lang.String r4 = ", targetDensity: "
            r5.append(r4)
            int r4 = r14.inTargetDensity
            r5.append(r4)
            java.lang.String r4 = ", density: "
            r5.append(r4)
            int r4 = r14.inDensity
            r5.append(r4)
            java.lang.String r4 = ", density multiplier: "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            android.util.Log.v(r6, r1)
        L_0x012f:
            if (r2 <= 0) goto L_0x013a
            if (r3 <= 0) goto L_0x013a
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r1 = r8.f18284a
            y(r14, r1, r2, r3)
            goto L_0x013a
        L_0x0139:
            r6 = r3
        L_0x013a:
            r1 = 28
            if (r0 < r1) goto L_0x0160
            com.bumptech.glide.load.PreferredColorSpace r0 = com.bumptech.glide.load.PreferredColorSpace.DISPLAY_P3
            r1 = r31
            if (r1 != r0) goto L_0x0164
            android.graphics.ColorSpace r0 = r28.outColorSpace
            if (r0 == 0) goto L_0x0164
            android.graphics.ColorSpace r0 = r28.outColorSpace
            boolean r0 = r0.isWideGamut()
            if (r0 == 0) goto L_0x0164
            android.graphics.ColorSpace$Named r0 = android.graphics.ColorSpace.Named.DISPLAY_P3
        L_0x0158:
            android.graphics.ColorSpace r0 = android.graphics.ColorSpace.get(r0)
            r14.inPreferredColorSpace = r0
            goto L_0x0169
        L_0x0160:
            r1 = 26
            if (r0 < r1) goto L_0x0169
        L_0x0164:
            android.graphics.ColorSpace$Named r0 = android.graphics.ColorSpace.Named.SRGB
            goto L_0x0158
        L_0x0169:
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r0 = r8.f18284a
            android.graphics.Bitmap r0 = i(r15, r14, r13, r0)
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r1 = r8.f18284a
            r13.a(r1, r0)
            r1 = 2
            boolean r1 = android.util.Log.isLoggable(r6, r1)
            if (r1 == 0) goto L_0x018b
            r9 = r12
            r12 = r28
            r13 = r0
            r14 = r33
            r1 = r29
            r15 = r34
            r16 = r20
            t(r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x018d
        L_0x018b:
            r1 = r29
        L_0x018d:
            if (r0 == 0) goto L_0x01a8
            android.util.DisplayMetrics r2 = r8.f18285b
            int r2 = r2.densityDpi
            r0.setDensity(r2)
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r2 = r8.f18284a
            android.graphics.Bitmap r1 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.o(r2, r0, r1)
            boolean r2 = r0.equals(r1)
            if (r2 != 0) goto L_0x01a9
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r2 = r8.f18284a
            r2.e(r0)
            goto L_0x01a9
        L_0x01a8:
            r1 = 0
        L_0x01a9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.h(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.DecodeFormat, com.bumptech.glide.load.PreferredColorSpace, boolean, int, int, boolean, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks):android.graphics.Bitmap");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap i(com.bumptech.glide.load.resource.bitmap.ImageReader r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto L_0x000c
            r7.b()
            r5.c()
        L_0x000c:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.i()
            r4.lock()
            android.graphics.Bitmap r5 = r5.b(r6)     // Catch:{ IllegalArgumentException -> 0x0027 }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.i()
            r6.unlock()
            return r5
        L_0x0025:
            r5 = move-exception
            goto L_0x0050
        L_0x0027:
            r4 = move-exception
            java.io.IOException r1 = u(r4, r1, r2, r3, r6)     // Catch:{ all -> 0x0025 }
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch:{ all -> 0x0025 }
        L_0x0038:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x004f
            r8.e(r0)     // Catch:{ IOException -> 0x004e }
            r0 = 0
            r6.inBitmap = r0     // Catch:{ IOException -> 0x004e }
            android.graphics.Bitmap r5 = i(r5, r6, r7, r8)     // Catch:{ IOException -> 0x004e }
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.i()
            r6.unlock()
            return r5
        L_0x004e:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x004f:
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0050:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.i()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.i(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    @TargetApi(19)
    @Nullable
    private static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = q;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                w(poll);
            }
        }
        return poll;
    }

    private static int l(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int[] m(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        i(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i2) {
        return i2 == 90 || i2 == 270;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.inDensity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean s(android.graphics.BitmapFactory.Options r1) {
        /*
            int r0 = r1.inTargetDensity
            if (r0 <= 0) goto L_0x000c
            int r1 = r1.inDensity
            if (r1 <= 0) goto L_0x000c
            if (r0 == r1) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.s(android.graphics.BitmapFactory$Options):boolean");
    }

    private static void t(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v(f18275f, "Decoded " + j(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + n(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.a(j2));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = q;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d2) {
        return (int) (d2 + 0.5d);
    }

    @TargetApi(26)
    private static void y(BitmapFactory.Options options, BitmapPool bitmapPool, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.g(i2, i3, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    @RequiresApi(21)
    public Resource<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, Options options) throws IOException {
        return e(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.f18287d, this.f18286c), i2, i3, options, o);
    }

    public Resource<Bitmap> f(InputStream inputStream, int i2, int i3, Options options) throws IOException {
        return g(inputStream, i2, i3, options, o);
    }

    public Resource<Bitmap> g(InputStream inputStream, int i2, int i3, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        return e(new ImageReader.InputStreamImageReader(inputStream, this.f18287d, this.f18286c), i2, i3, options, decodeCallbacks);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}
