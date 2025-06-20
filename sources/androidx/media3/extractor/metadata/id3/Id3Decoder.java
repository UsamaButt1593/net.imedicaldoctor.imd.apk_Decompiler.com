package androidx.media3.extractor.metadata.id3;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import net.lingala.zip4j.util.InternalZipConstants;

@UnstableApi
public final class Id3Decoder extends SimpleMetadataDecoder {

    /* renamed from: b  reason: collision with root package name */
    public static final FramePredicate f13355b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final String f13356c = "Id3Decoder";

    /* renamed from: d  reason: collision with root package name */
    public static final int f13357d = 4801587;

    /* renamed from: e  reason: collision with root package name */
    public static final int f13358e = 10;

    /* renamed from: f  reason: collision with root package name */
    private static final int f13359f = 128;

    /* renamed from: g  reason: collision with root package name */
    private static final int f13360g = 64;

    /* renamed from: h  reason: collision with root package name */
    private static final int f13361h = 32;

    /* renamed from: i  reason: collision with root package name */
    private static final int f13362i = 8;

    /* renamed from: j  reason: collision with root package name */
    private static final int f13363j = 4;

    /* renamed from: k  reason: collision with root package name */
    private static final int f13364k = 64;

    /* renamed from: l  reason: collision with root package name */
    private static final int f13365l = 2;

    /* renamed from: m  reason: collision with root package name */
    private static final int f13366m = 1;

    /* renamed from: n  reason: collision with root package name */
    private static final int f13367n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 3;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final FramePredicate f13368a;

    public interface FramePredicate {
        boolean a(int i2, int i3, int i4, int i5, int i6);
    }

    private static final class Id3Header {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f13369a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f13370b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f13371c;

        public Id3Header(int i2, boolean z, int i3) {
            this.f13369a = i2;
            this.f13370b = z;
            this.f13371c = i3;
        }
    }

    public Id3Decoder() {
        this((FramePredicate) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean A(int i2, int i3, int i4, int i5, int i6) {
        return false;
    }

    private static int B(ParsableByteArray parsableByteArray, int i2) {
        byte[] e2 = parsableByteArray.e();
        int f2 = parsableByteArray.f();
        int i3 = f2;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= f2 + i2) {
                return i2;
            }
            if ((e2[i3] & 255) == 255 && e2[i4] == 0) {
                System.arraycopy(e2, i3 + 2, e2, i4, (i2 - (i3 - f2)) - 2);
                i2--;
            }
            i3 = i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0079, code lost:
        if ((r10 & 1) != 0) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0087, code lost:
        if ((r10 & 128) != 0) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean C(androidx.media3.common.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.f()
        L_0x0008:
            int r3 = r18.a()     // Catch:{ all -> 0x0022 }
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00ac
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0025
            int r7 = r18.s()     // Catch:{ all -> 0x0022 }
            long r8 = r18.N()     // Catch:{ all -> 0x0022 }
            int r10 = r18.R()     // Catch:{ all -> 0x0022 }
            goto L_0x002f
        L_0x0022:
            r0 = move-exception
            goto L_0x00b0
        L_0x0025:
            int r7 = r18.O()     // Catch:{ all -> 0x0022 }
            int r8 = r18.O()     // Catch:{ all -> 0x0022 }
            long r8 = (long) r8
            r10 = 0
        L_0x002f:
            r11 = 0
            if (r7 != 0) goto L_0x003d
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003d
            if (r10 != 0) goto L_0x003d
            r1.Y(r2)
            return r4
        L_0x003d:
            r7 = 4
            if (r0 != r7) goto L_0x006e
            if (r21 != 0) goto L_0x006e
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x004e
            r1.Y(r2)
            return r6
        L_0x004e:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x006e:
            if (r0 != r7) goto L_0x007c
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0076
            r3 = 1
            goto L_0x0077
        L_0x0076:
            r3 = 0
        L_0x0077:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x008b
            goto L_0x008c
        L_0x007c:
            if (r0 != r3) goto L_0x008a
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0084
            r3 = 1
            goto L_0x0085
        L_0x0084:
            r3 = 0
        L_0x0085:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x008b
            goto L_0x008c
        L_0x008a:
            r3 = 0
        L_0x008b:
            r4 = 0
        L_0x008c:
            if (r4 == 0) goto L_0x0090
            int r3 = r3 + 4
        L_0x0090:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0099
            r1.Y(r2)
            return r6
        L_0x0099:
            int r3 = r18.a()     // Catch:{ all -> 0x0022 }
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a6
            r1.Y(r2)
            return r6
        L_0x00a6:
            int r3 = (int) r8
            r1.Z(r3)     // Catch:{ all -> 0x0022 }
            goto L_0x0008
        L_0x00ac:
            r1.Y(r2)
            return r4
        L_0x00b0:
            r1.Y(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.id3.Id3Decoder.C(androidx.media3.common.util.ParsableByteArray, int, int, boolean):boolean");
    }

    private static byte[] d(byte[] bArr, int i2, int i3) {
        return i3 <= i2 ? Util.f9651f : Arrays.copyOfRange(bArr, i2, i3);
    }

    private static ApicFrame f(ParsableByteArray parsableByteArray, int i2, int i3) {
        int i4;
        String str;
        int L = parsableByteArray.L();
        Charset w = w(L);
        int i5 = i2 - 1;
        byte[] bArr = new byte[i5];
        parsableByteArray.n(bArr, 0, i5);
        if (i3 == 2) {
            str = "image/" + Ascii.g(new String(bArr, 0, 3, Charsets.f22254b));
            if ("image/jpg".equals(str)) {
                str = MimeTypes.Q0;
            }
            i4 = 2;
        } else {
            i4 = z(bArr, 0);
            String g2 = Ascii.g(new String(bArr, 0, i4, Charsets.f22254b));
            if (g2.indexOf(47) == -1) {
                str = "image/" + g2;
            } else {
                str = g2;
            }
        }
        int i6 = i4 + 2;
        int y = y(bArr, i6, L);
        return new ApicFrame(str, new String(bArr, i6, y - i6, w), bArr[i4 + 1] & 255, d(bArr, y + v(L), i5));
    }

    private static BinaryFrame g(ParsableByteArray parsableByteArray, int i2, String str) {
        byte[] bArr = new byte[i2];
        parsableByteArray.n(bArr, 0, i2);
        return new BinaryFrame(str, bArr);
    }

    private static ChapterFrame h(ParsableByteArray parsableByteArray, int i2, int i3, boolean z, int i4, @Nullable FramePredicate framePredicate) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int f2 = parsableByteArray.f();
        int z2 = z(parsableByteArray.e(), f2);
        String str = new String(parsableByteArray.e(), f2, z2 - f2, Charsets.f22254b);
        parsableByteArray.Y(z2 + 1);
        int s = parsableByteArray.s();
        int s2 = parsableByteArray.s();
        long N = parsableByteArray.N();
        long j2 = N == InternalZipConstants.f30717k ? -1 : N;
        long N2 = parsableByteArray.N();
        long j3 = N2 == InternalZipConstants.f30717k ? -1 : N2;
        ArrayList arrayList = new ArrayList();
        int i5 = f2 + i2;
        while (parsableByteArray.f() < i5) {
            Id3Frame k2 = k(i3, parsableByteArray, z, i4, framePredicate);
            if (k2 != null) {
                arrayList.add(k2);
            }
        }
        return new ChapterFrame(str, s, s2, j2, j3, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static ChapterTocFrame i(ParsableByteArray parsableByteArray, int i2, int i3, boolean z, int i4, @Nullable FramePredicate framePredicate) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int f2 = parsableByteArray.f();
        int z2 = z(parsableByteArray.e(), f2);
        String str = new String(parsableByteArray.e(), f2, z2 - f2, Charsets.f22254b);
        parsableByteArray2.Y(z2 + 1);
        int L = parsableByteArray.L();
        boolean z3 = (L & 2) != 0;
        boolean z4 = (L & 1) != 0;
        int L2 = parsableByteArray.L();
        String[] strArr = new String[L2];
        for (int i5 = 0; i5 < L2; i5++) {
            int f3 = parsableByteArray.f();
            int z5 = z(parsableByteArray.e(), f3);
            strArr[i5] = new String(parsableByteArray.e(), f3, z5 - f3, Charsets.f22254b);
            parsableByteArray2.Y(z5 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i6 = f2 + i2;
        while (parsableByteArray.f() < i6) {
            Id3Frame k2 = k(i3, parsableByteArray2, z, i4, framePredicate);
            if (k2 != null) {
                arrayList.add(k2);
            }
        }
        return new ChapterTocFrame(str, z3, z4, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    private static CommentFrame j(ParsableByteArray parsableByteArray, int i2) {
        if (i2 < 4) {
            return null;
        }
        int L = parsableByteArray.L();
        Charset w = w(L);
        byte[] bArr = new byte[3];
        parsableByteArray.n(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        parsableByteArray.n(bArr2, 0, i3);
        int y = y(bArr2, 0, L);
        String str2 = new String(bArr2, 0, y, w);
        int v = y + v(L);
        return new CommentFrame(str, str2, p(bArr2, v, y(bArr2, v, L), w));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0193, code lost:
        if (r13 == 67) goto L_0x0195;
     */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0208  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.metadata.id3.Id3Frame k(int r20, androidx.media3.common.util.ParsableByteArray r21, boolean r22, int r23, @androidx.annotation.Nullable androidx.media3.extractor.metadata.id3.Id3Decoder.FramePredicate r24) {
        /*
            r7 = r20
            r8 = r21
            int r9 = r21.L()
            int r10 = r21.L()
            int r11 = r21.L()
            r12 = 3
            if (r7 < r12) goto L_0x0019
            int r1 = r21.L()
            r13 = r1
            goto L_0x001a
        L_0x0019:
            r13 = 0
        L_0x001a:
            r14 = 4
            if (r7 != r14) goto L_0x003c
            int r1 = r21.P()
            if (r22 != 0) goto L_0x003a
            r2 = r1 & 255(0xff, float:3.57E-43)
            int r3 = r1 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 7
            r2 = r2 | r3
            int r3 = r1 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 14
            r2 = r2 | r3
            int r1 = r1 >> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 21
            r1 = r1 | r2
        L_0x003a:
            r15 = r1
            goto L_0x0048
        L_0x003c:
            if (r7 != r12) goto L_0x0043
            int r1 = r21.P()
            goto L_0x003a
        L_0x0043:
            int r1 = r21.O()
            goto L_0x003a
        L_0x0048:
            if (r7 < r12) goto L_0x0050
            int r1 = r21.R()
            r6 = r1
            goto L_0x0051
        L_0x0050:
            r6 = 0
        L_0x0051:
            r16 = 0
            if (r9 != 0) goto L_0x0067
            if (r10 != 0) goto L_0x0067
            if (r11 != 0) goto L_0x0067
            if (r13 != 0) goto L_0x0067
            if (r15 != 0) goto L_0x0067
            if (r6 != 0) goto L_0x0067
            int r0 = r21.g()
            r8.Y(r0)
            return r16
        L_0x0067:
            int r1 = r21.f()
            int r5 = r1 + r15
            int r1 = r21.g()
            java.lang.String r4 = "Id3Decoder"
            if (r5 <= r1) goto L_0x0082
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            androidx.media3.common.util.Log.n(r4, r0)
            int r0 = r21.g()
            r8.Y(r0)
            return r16
        L_0x0082:
            if (r24 == 0) goto L_0x009a
            r1 = r24
            r2 = r20
            r3 = r9
            r17 = r4
            r4 = r10
            r14 = r5
            r5 = r11
            r0 = r6
            r6 = r13
            boolean r1 = r1.a(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x009e
            r8.Y(r14)
            return r16
        L_0x009a:
            r17 = r4
            r14 = r5
            r0 = r6
        L_0x009e:
            r1 = 1
            if (r7 != r12) goto L_0x00bd
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            r3 = r0 & 64
            if (r3 == 0) goto L_0x00ae
            r3 = 1
            goto L_0x00af
        L_0x00ae:
            r3 = 0
        L_0x00af:
            r0 = r0 & 32
            if (r0 == 0) goto L_0x00b5
            r0 = 1
            goto L_0x00b6
        L_0x00b5:
            r0 = 0
        L_0x00b6:
            r18 = r2
            r5 = 0
            r2 = r0
            r0 = r18
            goto L_0x00ed
        L_0x00bd:
            r2 = 4
            if (r7 != r2) goto L_0x00e7
            r2 = r0 & 64
            if (r2 == 0) goto L_0x00c6
            r2 = 1
            goto L_0x00c7
        L_0x00c6:
            r2 = 0
        L_0x00c7:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x00cd
            r3 = 1
            goto L_0x00ce
        L_0x00cd:
            r3 = 0
        L_0x00ce:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x00d4
            r4 = 1
            goto L_0x00d5
        L_0x00d4:
            r4 = 0
        L_0x00d5:
            r5 = r0 & 2
            if (r5 == 0) goto L_0x00db
            r5 = 1
            goto L_0x00dc
        L_0x00db:
            r5 = 0
        L_0x00dc:
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00e1
            r0 = 1
            goto L_0x00e2
        L_0x00e1:
            r0 = 0
        L_0x00e2:
            r18 = r0
            r0 = r3
            r3 = r4
            goto L_0x00ed
        L_0x00e7:
            r0 = 0
            r2 = 0
            r3 = 0
            r5 = 0
            r18 = 0
        L_0x00ed:
            if (r0 != 0) goto L_0x00f1
            if (r3 == 0) goto L_0x00f5
        L_0x00f1:
            r2 = r17
            goto L_0x022b
        L_0x00f5:
            if (r2 == 0) goto L_0x00fc
            int r15 = r15 + -1
            r8.Z(r1)
        L_0x00fc:
            if (r18 == 0) goto L_0x0104
            int r15 = r15 + -4
            r0 = 4
            r8.Z(r0)
        L_0x0104:
            if (r5 == 0) goto L_0x010a
            int r15 = B(r8, r15)
        L_0x010a:
            r0 = 84
            r1 = 88
            r2 = 2
            if (r9 != r0) goto L_0x0128
            if (r10 != r1) goto L_0x0128
            if (r11 != r1) goto L_0x0128
            if (r7 == r2) goto L_0x0119
            if (r13 != r1) goto L_0x0128
        L_0x0119:
            androidx.media3.extractor.metadata.id3.TextInformationFrame r0 = s(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            goto L_0x01f5
        L_0x011f:
            r0 = move-exception
            goto L_0x01ff
        L_0x0122:
            r0 = move-exception
            goto L_0x0203
        L_0x0125:
            r0 = move-exception
            goto L_0x0203
        L_0x0128:
            if (r9 != r0) goto L_0x0134
            java.lang.String r0 = x(r7, r9, r10, r11, r13)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            androidx.media3.extractor.metadata.id3.TextInformationFrame r0 = q(r8, r15, r0)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            goto L_0x01f5
        L_0x0134:
            r3 = 87
            if (r9 != r3) goto L_0x0146
            if (r10 != r1) goto L_0x0146
            if (r11 != r1) goto L_0x0146
            if (r7 == r2) goto L_0x0140
            if (r13 != r1) goto L_0x0146
        L_0x0140:
            androidx.media3.extractor.metadata.id3.UrlLinkFrame r0 = u(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            goto L_0x01f5
        L_0x0146:
            if (r9 != r3) goto L_0x0152
            java.lang.String r0 = x(r7, r9, r10, r11, r13)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            androidx.media3.extractor.metadata.id3.UrlLinkFrame r0 = t(r8, r15, r0)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            goto L_0x01f5
        L_0x0152:
            r1 = 73
            r3 = 80
            if (r9 != r3) goto L_0x0168
            r4 = 82
            if (r10 != r4) goto L_0x0168
            if (r11 != r1) goto L_0x0168
            r4 = 86
            if (r13 != r4) goto L_0x0168
            androidx.media3.extractor.metadata.id3.PrivFrame r0 = o(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            goto L_0x01f5
        L_0x0168:
            r4 = 71
            r5 = 79
            if (r9 != r4) goto L_0x0180
            r4 = 69
            if (r10 != r4) goto L_0x0180
            if (r11 != r5) goto L_0x0180
            r4 = 66
            if (r13 == r4) goto L_0x017a
            if (r7 != r2) goto L_0x0180
        L_0x017a:
            androidx.media3.extractor.metadata.id3.GeobFrame r0 = l(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            goto L_0x01f5
        L_0x0180:
            r4 = 65
            r6 = 67
            if (r7 != r2) goto L_0x018d
            if (r9 != r3) goto L_0x019b
            if (r10 != r1) goto L_0x019b
            if (r11 != r6) goto L_0x019b
            goto L_0x0195
        L_0x018d:
            if (r9 != r4) goto L_0x019b
            if (r10 != r3) goto L_0x019b
            if (r11 != r1) goto L_0x019b
            if (r13 != r6) goto L_0x019b
        L_0x0195:
            androidx.media3.extractor.metadata.id3.ApicFrame r0 = f(r8, r15, r7)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            goto L_0x01f5
        L_0x019b:
            r1 = 77
            if (r9 != r6) goto L_0x01ac
            if (r10 != r5) goto L_0x01ac
            if (r11 != r1) goto L_0x01ac
            if (r13 == r1) goto L_0x01a7
            if (r7 != r2) goto L_0x01ac
        L_0x01a7:
            androidx.media3.extractor.metadata.id3.CommentFrame r0 = j(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            goto L_0x01f5
        L_0x01ac:
            if (r9 != r6) goto L_0x01c6
            r2 = 72
            if (r10 != r2) goto L_0x01c6
            if (r11 != r4) goto L_0x01c6
            if (r13 != r3) goto L_0x01c6
            r1 = r21
            r2 = r15
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            androidx.media3.extractor.metadata.id3.ChapterFrame r0 = h(r1, r2, r3, r4, r5, r6)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            goto L_0x01f5
        L_0x01c6:
            if (r9 != r6) goto L_0x01de
            if (r10 != r0) goto L_0x01de
            if (r11 != r5) goto L_0x01de
            if (r13 != r6) goto L_0x01de
            r1 = r21
            r2 = r15
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            androidx.media3.extractor.metadata.id3.ChapterTocFrame r0 = i(r1, r2, r3, r4, r5, r6)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            goto L_0x01f5
        L_0x01de:
            if (r9 != r1) goto L_0x01ed
            r1 = 76
            if (r10 != r1) goto L_0x01ed
            if (r11 != r1) goto L_0x01ed
            if (r13 != r0) goto L_0x01ed
            androidx.media3.extractor.metadata.id3.MlltFrame r0 = n(r8, r15)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            goto L_0x01f5
        L_0x01ed:
            java.lang.String r0 = x(r7, r9, r10, r11, r13)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
            androidx.media3.extractor.metadata.id3.BinaryFrame r0 = g(r8, r15, r0)     // Catch:{ OutOfMemoryError -> 0x0125, Exception -> 0x0122, all -> 0x011f }
        L_0x01f5:
            r8.Y(r14)
            r19 = r16
            r16 = r0
            r0 = r19
            goto L_0x0206
        L_0x01ff:
            r8.Y(r14)
            throw r0
        L_0x0203:
            r8.Y(r14)
        L_0x0206:
            if (r16 != 0) goto L_0x022a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to decode frame: id="
            r1.append(r2)
            java.lang.String r2 = x(r7, r9, r10, r11, r13)
            r1.append(r2)
            java.lang.String r2 = ", frameSize="
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r2 = r17
            androidx.media3.common.util.Log.o(r2, r1, r0)
        L_0x022a:
            return r16
        L_0x022b:
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            androidx.media3.common.util.Log.n(r2, r0)
            r8.Y(r14)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.id3.Id3Decoder.k(int, androidx.media3.common.util.ParsableByteArray, boolean, int, androidx.media3.extractor.metadata.id3.Id3Decoder$FramePredicate):androidx.media3.extractor.metadata.id3.Id3Frame");
    }

    private static GeobFrame l(ParsableByteArray parsableByteArray, int i2) {
        int L = parsableByteArray.L();
        Charset w = w(L);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.n(bArr, 0, i3);
        int z = z(bArr, 0);
        String u = MimeTypes.u(new String(bArr, 0, z, Charsets.f22254b));
        int i4 = z + 1;
        int y = y(bArr, i4, L);
        String p2 = p(bArr, i4, y, w);
        int v = y + v(L);
        int y2 = y(bArr, v, L);
        return new GeobFrame(u, p2, p(bArr, v, y2, w), d(bArr, y2 + v(L), i3));
    }

    @Nullable
    private static Id3Header m(ParsableByteArray parsableByteArray) {
        StringBuilder sb;
        String str;
        boolean z = false;
        if (parsableByteArray.a() < 10) {
            str = "Data too short to be an ID3 tag";
        } else {
            int O = parsableByteArray.O();
            if (O != 4801587) {
                sb = new StringBuilder();
                sb.append("Unexpected first three bytes of ID3 tag header: 0x");
                sb.append(String.format("%06X", new Object[]{Integer.valueOf(O)}));
            } else {
                int L = parsableByteArray.L();
                parsableByteArray.Z(1);
                int L2 = parsableByteArray.L();
                int K = parsableByteArray.K();
                if (L == 2) {
                    if ((L2 & 64) != 0) {
                        str = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme";
                    }
                } else if (L == 3) {
                    if ((L2 & 64) != 0) {
                        int s = parsableByteArray.s();
                        parsableByteArray.Z(s);
                        K -= s + 4;
                    }
                } else if (L == 4) {
                    if ((L2 & 64) != 0) {
                        int K2 = parsableByteArray.K();
                        parsableByteArray.Z(K2 - 4);
                        K -= K2;
                    }
                    if ((L2 & 16) != 0) {
                        K -= 10;
                    }
                } else {
                    sb = new StringBuilder();
                    sb.append("Skipped ID3 tag with unsupported majorVersion=");
                    sb.append(L);
                }
                if (L < 4 && (L2 & 128) != 0) {
                    z = true;
                }
                return new Id3Header(L, z, K);
            }
            str = sb.toString();
        }
        Log.n(f13356c, str);
        return null;
    }

    private static MlltFrame n(ParsableByteArray parsableByteArray, int i2) {
        int R = parsableByteArray.R();
        int O = parsableByteArray.O();
        int O2 = parsableByteArray.O();
        int L = parsableByteArray.L();
        int L2 = parsableByteArray.L();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.n(parsableByteArray);
        int i3 = ((i2 - 10) * 8) / (L + L2);
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int h2 = parsableBitArray.h(L);
            int h3 = parsableBitArray.h(L2);
            iArr[i4] = h2;
            iArr2[i4] = h3;
        }
        return new MlltFrame(R, O, O2, iArr, iArr2);
    }

    private static PrivFrame o(ParsableByteArray parsableByteArray, int i2) {
        byte[] bArr = new byte[i2];
        parsableByteArray.n(bArr, 0, i2);
        int z = z(bArr, 0);
        return new PrivFrame(new String(bArr, 0, z, Charsets.f22254b), d(bArr, z + 1, i2));
    }

    private static String p(byte[] bArr, int i2, int i3, Charset charset) {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new String(bArr, i2, i3 - i2, charset);
    }

    @Nullable
    private static TextInformationFrame q(ParsableByteArray parsableByteArray, int i2, String str) {
        if (i2 < 1) {
            return null;
        }
        int L = parsableByteArray.L();
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.n(bArr, 0, i3);
        return new TextInformationFrame(str, (String) null, (List<String>) r(bArr, L, 0));
    }

    private static ImmutableList<String> r(byte[] bArr, int i2, int i3) {
        if (i3 >= bArr.length) {
            return ImmutableList.K("");
        }
        ImmutableList.Builder r = ImmutableList.r();
        while (true) {
            int y = y(bArr, i3, i2);
            if (i3 >= y) {
                break;
            }
            r.g(new String(bArr, i3, y - i3, w(i2)));
            i3 = v(i2) + y;
        }
        ImmutableList<String> n2 = r.e();
        return n2.isEmpty() ? ImmutableList.K("") : n2;
    }

    @Nullable
    private static TextInformationFrame s(ParsableByteArray parsableByteArray, int i2) {
        if (i2 < 1) {
            return null;
        }
        int L = parsableByteArray.L();
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.n(bArr, 0, i3);
        int y = y(bArr, 0, L);
        return new TextInformationFrame("TXXX", new String(bArr, 0, y, w(L)), (List<String>) r(bArr, L, y + v(L)));
    }

    private static UrlLinkFrame t(ParsableByteArray parsableByteArray, int i2, String str) {
        byte[] bArr = new byte[i2];
        parsableByteArray.n(bArr, 0, i2);
        return new UrlLinkFrame(str, (String) null, new String(bArr, 0, z(bArr, 0), Charsets.f22254b));
    }

    @Nullable
    private static UrlLinkFrame u(ParsableByteArray parsableByteArray, int i2) {
        if (i2 < 1) {
            return null;
        }
        int L = parsableByteArray.L();
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.n(bArr, 0, i3);
        int y = y(bArr, 0, L);
        String str = new String(bArr, 0, y, w(L));
        int v = y + v(L);
        return new UrlLinkFrame("WXXX", str, p(bArr, v, z(bArr, v), Charsets.f22254b));
    }

    private static int v(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    private static Charset w(int i2) {
        if (i2 == 1) {
            return Charsets.f22258f;
        }
        if (i2 != 2) {
            return i2 != 3 ? Charsets.f22254b : Charsets.f22255c;
        }
        return Charsets.f22256d;
    }

    private static String x(int i2, int i3, int i4, int i5, int i6) {
        if (i2 == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    private static int y(byte[] bArr, int i2, int i3) {
        int z = z(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            return z;
        }
        while (z < bArr.length - 1) {
            if ((z - i2) % 2 == 0 && bArr[z + 1] == 0) {
                return z;
            }
            z = z(bArr, z + 1);
        }
        return bArr.length;
    }

    private static int z(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    @Nullable
    public Metadata e(byte[] bArr, int i2) {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i2);
        Id3Header m2 = m(parsableByteArray);
        if (m2 == null) {
            return null;
        }
        int f2 = parsableByteArray.f();
        int i3 = m2.f13369a == 2 ? 6 : 10;
        int b2 = m2.f13371c;
        if (m2.f13370b) {
            b2 = B(parsableByteArray, m2.f13371c);
        }
        parsableByteArray.X(f2 + b2);
        boolean z = false;
        if (!C(parsableByteArray, m2.f13369a, i3, false)) {
            if (m2.f13369a != 4 || !C(parsableByteArray, 4, i3, true)) {
                Log.n(f13356c, "Failed to validate ID3 tag with majorVersion=" + m2.f13369a);
                return null;
            }
            z = true;
        }
        while (parsableByteArray.a() >= i3) {
            Id3Frame k2 = k(m2.f13369a, parsableByteArray, z, i3, this.f13368a);
            if (k2 != null) {
                arrayList.add(k2);
            }
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    public Id3Decoder(@Nullable FramePredicate framePredicate) {
        this.f13368a = framePredicate;
    }
}
