package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import okio.Utf8;
import org.apache.commons.httpclient.HttpStatus;

@UnstableApi
public final class Ac3Util {

    /* renamed from: a  reason: collision with root package name */
    public static final int f12888a = 80000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f12889b = 768000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f12890c = 3062500;

    /* renamed from: d  reason: collision with root package name */
    public static final int f12891d = 16;

    /* renamed from: e  reason: collision with root package name */
    public static final int f12892e = 10;

    /* renamed from: f  reason: collision with root package name */
    private static final int f12893f = 256;

    /* renamed from: g  reason: collision with root package name */
    private static final int f12894g = 1536;

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f12895h = {1, 2, 3, 6};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f12896i = {OpusUtil.f13107a, 44100, 32000};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f12897j = {24000, 22050, AacUtil.f12877g};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f12898k = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f12899l = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, PsExtractor.x, 224, 256, TIFFConstants.o1, RendererCapabilities.M, 448, 512, 576, 640};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f12900m = {69, 87, 104, 121, TsExtractor.W, 174, 208, 243, TIFFConstants.s0, 348, HttpStatus.SC_EXPECTATION_FAILED, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static final class SyncFrameInfo {

        /* renamed from: h  reason: collision with root package name */
        public static final int f12901h = -1;

        /* renamed from: i  reason: collision with root package name */
        public static final int f12902i = 0;

        /* renamed from: j  reason: collision with root package name */
        public static final int f12903j = 1;

        /* renamed from: k  reason: collision with root package name */
        public static final int f12904k = 2;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final String f12905a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12906b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12907c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12908d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12909e;

        /* renamed from: f  reason: collision with root package name */
        public final int f12910f;

        /* renamed from: g  reason: collision with root package name */
        public final int f12911g;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface StreamType {
        }

        private SyncFrameInfo(@Nullable String str, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f12905a = str;
            this.f12906b = i2;
            this.f12908d = i3;
            this.f12907c = i4;
            this.f12909e = i5;
            this.f12910f = i6;
            this.f12911g = i7;
        }
    }

    private Ac3Util() {
    }

    private static int a(int i2, int i3, int i4) {
        return (i2 * i3) / (i4 * 32);
    }

    public static int b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i2 = position; i2 <= limit; i2++) {
            if ((Util.d0(byteBuffer, i2 + 4) & -2) == -126718022) {
                return i2 - position;
            }
        }
        return -1;
    }

    private static int c(int i2, int i3) {
        int i4 = i3 / 2;
        if (i2 < 0) {
            return -1;
        }
        int[] iArr = f12896i;
        if (i2 >= iArr.length || i3 < 0) {
            return -1;
        }
        int[] iArr2 = f12900m;
        if (i4 >= iArr2.length) {
            return -1;
        }
        int i5 = iArr[i2];
        if (i5 == 44100) {
            return (iArr2[i4] + (i3 % 2)) * 2;
        }
        int i6 = f12899l[i4];
        return i5 == 32000 ? i6 * 6 : i6 * 4;
    }

    public static Format d(ParsableByteArray parsableByteArray, String str, String str2, @Nullable DrmInitData drmInitData) {
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.n(parsableByteArray);
        int i2 = f12896i[parsableBitArray.h(2)];
        parsableBitArray.s(8);
        int i3 = f12898k[parsableBitArray.h(3)];
        if (parsableBitArray.h(1) != 0) {
            i3++;
        }
        int i4 = f12899l[parsableBitArray.h(5)] * 1000;
        parsableBitArray.c();
        parsableByteArray.Y(parsableBitArray.d());
        return new Format.Builder().X(str).k0(MimeTypes.Q).L(i3).l0(i2).R(drmInitData).b0(str2).K(i4).f0(i4).I();
    }

    public static int e(ByteBuffer byteBuffer) {
        int i2 = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) <= 10) {
            return f12894g;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i2 = (byteBuffer.get(byteBuffer.position() + 4) & com.itextpdf.text.pdf.ByteBuffer.X2) >> 4;
        }
        return f12895h[i2] * 256;
    }

    public static SyncFrameInfo f(ParsableBitArray parsableBitArray) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int e2 = parsableBitArray.e();
        parsableBitArray2.s(40);
        boolean z = parsableBitArray2.h(5) > 10;
        parsableBitArray2.q(e2);
        int i14 = -1;
        if (z) {
            parsableBitArray2.s(16);
            int h2 = parsableBitArray2.h(2);
            if (h2 == 0) {
                i14 = 0;
            } else if (h2 == 1) {
                i14 = 1;
            } else if (h2 == 2) {
                i14 = 2;
            }
            parsableBitArray2.s(3);
            int h3 = (parsableBitArray2.h(11) + 1) * 2;
            int h4 = parsableBitArray2.h(2);
            if (h4 == 3) {
                i10 = f12897j[parsableBitArray2.h(2)];
                i9 = 3;
                i8 = 6;
            } else {
                int h5 = parsableBitArray2.h(2);
                int i15 = f12895h[h5];
                i9 = h5;
                i10 = f12896i[h4];
                i8 = i15;
            }
            int i16 = i8 * 256;
            int a2 = a(h3, i10, i8);
            int h6 = parsableBitArray2.h(3);
            boolean g2 = parsableBitArray.g();
            int i17 = f12898k[h6] + (g2 ? 1 : 0);
            parsableBitArray2.s(10);
            if (parsableBitArray.g()) {
                parsableBitArray2.s(8);
            }
            if (h6 == 0) {
                parsableBitArray2.s(5);
                if (parsableBitArray.g()) {
                    parsableBitArray2.s(8);
                }
            }
            if (i14 == 1 && parsableBitArray.g()) {
                parsableBitArray2.s(16);
            }
            if (parsableBitArray.g()) {
                if (h6 > 2) {
                    parsableBitArray2.s(2);
                }
                if ((h6 & 1) == 0 || h6 <= 2) {
                    i12 = 6;
                } else {
                    i12 = 6;
                    parsableBitArray2.s(6);
                }
                if ((h6 & 4) != 0) {
                    parsableBitArray2.s(i12);
                }
                if (g2 && parsableBitArray.g()) {
                    parsableBitArray2.s(5);
                }
                if (i14 == 0) {
                    if (parsableBitArray.g()) {
                        i13 = 6;
                        parsableBitArray2.s(6);
                    } else {
                        i13 = 6;
                    }
                    if (h6 == 0 && parsableBitArray.g()) {
                        parsableBitArray2.s(i13);
                    }
                    if (parsableBitArray.g()) {
                        parsableBitArray2.s(i13);
                    }
                    int h7 = parsableBitArray2.h(2);
                    if (h7 == 1) {
                        parsableBitArray2.s(5);
                    } else if (h7 == 2) {
                        parsableBitArray2.s(12);
                    } else if (h7 == 3) {
                        int h8 = parsableBitArray2.h(5);
                        if (parsableBitArray.g()) {
                            parsableBitArray2.s(5);
                            if (parsableBitArray.g()) {
                                parsableBitArray2.s(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.s(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.s(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.s(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.s(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.s(4);
                            }
                            if (parsableBitArray.g()) {
                                parsableBitArray2.s(4);
                            }
                            if (parsableBitArray.g()) {
                                if (parsableBitArray.g()) {
                                    parsableBitArray2.s(4);
                                }
                                if (parsableBitArray.g()) {
                                    parsableBitArray2.s(4);
                                }
                            }
                        }
                        if (parsableBitArray.g()) {
                            parsableBitArray2.s(5);
                            if (parsableBitArray.g()) {
                                parsableBitArray2.s(7);
                                if (parsableBitArray.g()) {
                                    parsableBitArray2.s(8);
                                }
                            }
                        }
                        parsableBitArray2.s((h8 + 2) * 8);
                        parsableBitArray.c();
                    }
                    if (h6 < 2) {
                        if (parsableBitArray.g()) {
                            parsableBitArray2.s(14);
                        }
                        if (h6 == 0 && parsableBitArray.g()) {
                            parsableBitArray2.s(14);
                        }
                    }
                    if (parsableBitArray.g()) {
                        if (i9 == 0) {
                            parsableBitArray2.s(5);
                        } else {
                            for (int i18 = 0; i18 < i8; i18++) {
                                if (parsableBitArray.g()) {
                                    parsableBitArray2.s(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.g()) {
                parsableBitArray2.s(5);
                if (h6 == 2) {
                    parsableBitArray2.s(4);
                }
                if (h6 >= 6) {
                    parsableBitArray2.s(2);
                }
                if (parsableBitArray.g()) {
                    parsableBitArray2.s(8);
                }
                if (h6 == 0 && parsableBitArray.g()) {
                    parsableBitArray2.s(8);
                }
                if (h4 < 3) {
                    parsableBitArray.r();
                }
            }
            if (i14 == 0 && i9 != 3) {
                parsableBitArray.r();
            }
            if (i14 != 2 || (i9 != 3 && !parsableBitArray.g())) {
                i11 = 6;
            } else {
                i11 = 6;
                parsableBitArray2.s(6);
            }
            str = (parsableBitArray.g() && parsableBitArray2.h(i11) == 1 && parsableBitArray2.h(8) == 1) ? MimeTypes.S : MimeTypes.R;
            i7 = i14;
            i3 = i16;
            i4 = h3;
            i5 = i10;
            i2 = a2;
            i6 = i17;
        } else {
            parsableBitArray2.s(32);
            int h9 = parsableBitArray2.h(2);
            String str2 = h9 == 3 ? null : MimeTypes.Q;
            int h10 = parsableBitArray2.h(6);
            int i19 = f12899l[h10 / 2] * 1000;
            int c2 = c(h9, h10);
            parsableBitArray2.s(8);
            int h11 = parsableBitArray2.h(3);
            if (!((h11 & 1) == 0 || h11 == 1)) {
                parsableBitArray2.s(2);
            }
            if ((h11 & 4) != 0) {
                parsableBitArray2.s(2);
            }
            if (h11 == 2) {
                parsableBitArray2.s(2);
            }
            int[] iArr = f12896i;
            str = str2;
            i2 = i19;
            i4 = c2;
            i5 = h9 < iArr.length ? iArr[h9] : -1;
            i6 = f12898k[h11] + (parsableBitArray.g() ? 1 : 0);
            i7 = -1;
            i3 = f12894g;
        }
        return new SyncFrameInfo(str, i7, i6, i5, i4, i3, i2);
    }

    public static int g(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b2 = bArr[4];
        return c((b2 & 192) >> 6, b2 & Utf8.f31404a);
    }

    public static Format h(ParsableByteArray parsableByteArray, String str, String str2, @Nullable DrmInitData drmInitData) {
        String str3;
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.n(parsableByteArray);
        int h2 = parsableBitArray.h(13) * 1000;
        parsableBitArray.s(3);
        int i2 = f12896i[parsableBitArray.h(2)];
        parsableBitArray.s(10);
        int i3 = f12898k[parsableBitArray.h(3)];
        if (parsableBitArray.h(1) != 0) {
            i3++;
        }
        parsableBitArray.s(3);
        int h3 = parsableBitArray.h(4);
        parsableBitArray.s(1);
        if (h3 > 0) {
            parsableBitArray.s(6);
            if (parsableBitArray.h(1) != 0) {
                i3 += 2;
            }
            parsableBitArray.s(1);
        }
        if (parsableBitArray.b() > 7) {
            parsableBitArray.s(7);
            if (parsableBitArray.h(1) != 0) {
                str3 = MimeTypes.S;
                parsableBitArray.c();
                parsableByteArray.Y(parsableBitArray.d());
                return new Format.Builder().X(str).k0(str3).L(i3).l0(i2).R(drmInitData).b0(str2).f0(h2).I();
            }
        }
        str3 = MimeTypes.R;
        parsableBitArray.c();
        parsableByteArray.Y(parsableBitArray.d());
        return new Format.Builder().X(str).k0(str3).L(i3).l0(i2).R(drmInitData).b0(str2).f0(h2).I();
    }

    public static int i(ByteBuffer byteBuffer, int i2) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i2) + ((byteBuffer.get((byteBuffer.position() + i2) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int j(byte[] bArr) {
        boolean z = false;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b2 = bArr[7];
            if ((b2 & 254) == 186) {
                if ((b2 & 255) == 187) {
                    z = true;
                }
                return 40 << ((bArr[z ? (char) 9 : 8] >> 4) & 7);
            }
        }
        return 0;
    }
}
