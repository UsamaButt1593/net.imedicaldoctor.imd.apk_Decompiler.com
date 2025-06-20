package okio;

import com.itextpdf.tool.xml.html.HTML;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u000f\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u0000*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\" \u0010\f\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0002\u0010\u0007\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\" \u0010\u000f\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"", "", "a", "(Ljava/lang/String;)[B", "map", "b", "([B[B)Ljava/lang/String;", "[B", "d", "()[B", "e", "()V", "BASE64", "f", "g", "BASE64_URL_SAFE", "okio"}, k = 2, mv = {1, 5, 1})
public final class _Base64Kt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f31418a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f31419b;

    static {
        ByteString.Companion companion = ByteString.Z;
        f31418a = companion.l("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").r();
        f31419b = companion.l("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").r();
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a4 A[LOOP:1: B:13:0x003b->B:49:0x00a4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00a2 A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] a(@org.jetbrains.annotations.NotNull java.lang.String r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r15, r0)
            int r0 = r15.length()
        L_0x0009:
            r1 = 9
            r2 = 32
            r3 = 13
            r4 = 10
            if (r0 <= 0) goto L_0x0029
            int r5 = r0 + -1
            char r5 = r15.charAt(r5)
            r6 = 61
            if (r5 == r6) goto L_0x0026
            if (r5 == r4) goto L_0x0026
            if (r5 == r3) goto L_0x0026
            if (r5 == r2) goto L_0x0026
            if (r5 == r1) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            int r0 = r0 + -1
            goto L_0x0009
        L_0x0029:
            long r5 = (long) r0
            r7 = 6
            long r5 = r5 * r7
            r7 = 8
            long r5 = r5 / r7
            int r6 = (int) r5
            byte[] r5 = new byte[r6]
            r7 = 0
            r8 = 0
            r9 = 0
            if (r0 <= 0) goto L_0x00a6
            r10 = 0
            r11 = 0
        L_0x003b:
            int r12 = r8 + 1
            char r8 = r15.charAt(r8)
            r13 = 65
            if (r13 > r8) goto L_0x004c
            r13 = 90
            if (r8 > r13) goto L_0x004c
            int r8 = r8 + -65
            goto L_0x0083
        L_0x004c:
            r13 = 97
            if (r13 > r8) goto L_0x0057
            r13 = 122(0x7a, float:1.71E-43)
            if (r8 > r13) goto L_0x0057
            int r8 = r8 + -71
            goto L_0x0083
        L_0x0057:
            r13 = 48
            if (r13 > r8) goto L_0x0062
            r13 = 57
            if (r8 > r13) goto L_0x0062
            int r8 = r8 + 4
            goto L_0x0083
        L_0x0062:
            r13 = 43
            if (r8 == r13) goto L_0x0081
            r13 = 45
            if (r8 != r13) goto L_0x006b
            goto L_0x0081
        L_0x006b:
            r13 = 47
            if (r8 == r13) goto L_0x007e
            r13 = 95
            if (r8 != r13) goto L_0x0074
            goto L_0x007e
        L_0x0074:
            if (r8 == r4) goto L_0x00a0
            if (r8 == r3) goto L_0x00a0
            if (r8 == r2) goto L_0x00a0
            if (r8 != r1) goto L_0x007d
            goto L_0x00a0
        L_0x007d:
            return r7
        L_0x007e:
            r8 = 63
            goto L_0x0083
        L_0x0081:
            r8 = 62
        L_0x0083:
            int r11 = r11 << 6
            r8 = r8 | r11
            int r10 = r10 + 1
            int r11 = r10 % 4
            if (r11 != 0) goto L_0x009f
            int r11 = r9 + 1
            int r13 = r8 >> 16
            byte r13 = (byte) r13
            r5[r9] = r13
            int r13 = r9 + 2
            int r14 = r8 >> 8
            byte r14 = (byte) r14
            r5[r11] = r14
            int r9 = r9 + 3
            byte r11 = (byte) r8
            r5[r13] = r11
        L_0x009f:
            r11 = r8
        L_0x00a0:
            if (r12 < r0) goto L_0x00a4
            r8 = r10
            goto L_0x00a7
        L_0x00a4:
            r8 = r12
            goto L_0x003b
        L_0x00a6:
            r11 = 0
        L_0x00a7:
            int r8 = r8 % 4
            r15 = 1
            if (r8 == r15) goto L_0x00db
            r15 = 2
            if (r8 == r15) goto L_0x00c4
            r15 = 3
            if (r8 == r15) goto L_0x00b3
            goto L_0x00ce
        L_0x00b3:
            int r15 = r11 << 6
            int r0 = r9 + 1
            int r1 = r15 >> 16
            byte r1 = (byte) r1
            r5[r9] = r1
            int r9 = r9 + 2
            int r15 = r15 >> 8
            byte r15 = (byte) r15
            r5[r0] = r15
            goto L_0x00ce
        L_0x00c4:
            int r15 = r11 << 12
            int r0 = r9 + 1
            int r15 = r15 >> 16
            byte r15 = (byte) r15
            r5[r9] = r15
            r9 = r0
        L_0x00ce:
            if (r9 != r6) goto L_0x00d1
            return r5
        L_0x00d1:
            byte[] r15 = java.util.Arrays.copyOf(r5, r9)
            java.lang.String r0 = "java.util.Arrays.copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.o(r15, r0)
            return r15
        L_0x00db:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okio._Base64Kt.a(java.lang.String):byte[]");
    }

    @NotNull
    public static final String b(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.p(bArr, "<this>");
        Intrinsics.p(bArr2, HTML.Tag.t0);
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i2 + 2;
            byte b3 = bArr[i2 + 1];
            i2 += 3;
            byte b4 = bArr[i4];
            bArr3[i3] = bArr2[(b2 & 255) >> 2];
            bArr3[i3 + 1] = bArr2[((b2 & 3) << 4) | ((b3 & 255) >> 4)];
            int i5 = i3 + 3;
            bArr3[i3 + 2] = bArr2[((b3 & 15) << 2) | ((b4 & 255) >> 6)];
            i3 += 4;
            bArr3[i5] = bArr2[b4 & Utf8.f31404a];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i2];
            bArr3[i3] = bArr2[(b5 & 255) >> 2];
            bArr3[i3 + 1] = bArr2[(b5 & 3) << 4];
            byte b6 = (byte) 61;
            bArr3[i3 + 2] = b6;
            bArr3[i3 + 3] = b6;
        } else if (length2 == 2) {
            int i6 = i2 + 1;
            byte b7 = bArr[i2];
            byte b8 = bArr[i6];
            bArr3[i3] = bArr2[(b7 & 255) >> 2];
            bArr3[i3 + 1] = bArr2[((b7 & 3) << 4) | ((b8 & 255) >> 4)];
            bArr3[i3 + 2] = bArr2[(b8 & 15) << 2];
            bArr3[i3 + 3] = (byte) 61;
        }
        return _JvmPlatformKt.c(bArr3);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bArr2 = f31418a;
        }
        return b(bArr, bArr2);
    }

    @NotNull
    public static final byte[] d() {
        return f31418a;
    }

    public static /* synthetic */ void e() {
    }

    @NotNull
    public static final byte[] f() {
        return f31419b;
    }

    public static /* synthetic */ void g() {
    }
}
