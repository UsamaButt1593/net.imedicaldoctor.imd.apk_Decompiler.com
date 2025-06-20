package kotlin.text;

import androidx.media3.common.C;
import com.itextpdf.tool.xml.html.HTML;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u0000H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u00020\u0000H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"", "", "V0", "(Ljava/lang/String;)Ljava/lang/Byte;", "", "radix", "W0", "(Ljava/lang/String;I)Ljava/lang/Byte;", "", "b1", "(Ljava/lang/String;)Ljava/lang/Short;", "c1", "(Ljava/lang/String;I)Ljava/lang/Short;", "X0", "(Ljava/lang/String;)Ljava/lang/Integer;", "Y0", "(Ljava/lang/String;I)Ljava/lang/Integer;", "", "Z0", "(Ljava/lang/String;)Ljava/lang/Long;", "a1", "(Ljava/lang/String;I)Ljava/lang/Long;", "input", "", "U0", "(Ljava/lang/String;)Ljava/lang/Void;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    @NotNull
    public static final Void U0(@NotNull String str) {
        Intrinsics.p(str, HTML.Tag.q0);
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte V0(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        return W0(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte W0(@NotNull String str, int i2) {
        int intValue;
        Intrinsics.p(str, "<this>");
        Integer Y0 = Y0(str, i2);
        if (Y0 == null || (intValue = Y0.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Integer X0(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        return Y0(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Integer Y0(@NotNull String str, int i2) {
        int i3;
        boolean z;
        int i4;
        Intrinsics.p(str, "<this>");
        CharsKt.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i5 = 0;
        char charAt = str.charAt(0);
        int t = Intrinsics.t(charAt, 48);
        int i6 = C.f9088f;
        if (t < 0) {
            i3 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i6 = Integer.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
            }
        } else {
            z = false;
            i3 = 0;
        }
        int i7 = -59652323;
        while (i3 < length) {
            int b2 = CharsKt__CharJVMKt.b(str.charAt(i3), i2);
            if (b2 < 0) {
                return null;
            }
            if ((i5 < i7 && (i7 != -59652323 || i5 < (i7 = i6 / i2))) || (i4 = i5 * i2) < i6 + b2) {
                return null;
            }
            i5 = i4 - b2;
            i3++;
        }
        return z ? Integer.valueOf(i5) : Integer.valueOf(-i5);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Long Z0(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        return a1(str, 10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007a  */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Long a1(@org.jetbrains.annotations.NotNull java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r0, r2)
            kotlin.text.CharsKt.a(r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            return r3
        L_0x0014:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.Intrinsics.t(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 >= 0) goto L_0x0037
            r6 = 1
            if (r2 != r6) goto L_0x002a
            return r3
        L_0x002a:
            r9 = 45
            if (r5 != r9) goto L_0x0032
            r7 = -9223372036854775808
            r4 = 1
            goto L_0x003a
        L_0x0032:
            r9 = 43
            if (r5 != r9) goto L_0x0039
            r4 = 1
        L_0x0037:
            r6 = 0
            goto L_0x003a
        L_0x0039:
            return r3
        L_0x003a:
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r11 = 0
            r13 = r9
        L_0x0042:
            if (r4 >= r2) goto L_0x0073
            char r5 = r0.charAt(r4)
            int r5 = kotlin.text.CharsKt__CharJVMKt.b(r5, r1)
            if (r5 >= 0) goto L_0x004f
            return r3
        L_0x004f:
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x005f
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 != 0) goto L_0x005e
            long r13 = (long) r1
            long r13 = r7 / r13
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x005f
        L_0x005e:
            return r3
        L_0x005f:
            long r9 = (long) r1
            long r11 = r11 * r9
            long r9 = (long) r5
            long r16 = r7 + r9
            int r5 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r5 >= 0) goto L_0x006a
            return r3
        L_0x006a:
            long r11 = r11 - r9
            int r4 = r4 + 1
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L_0x0042
        L_0x0073:
            if (r6 == 0) goto L_0x007a
            java.lang.Long r0 = java.lang.Long.valueOf(r11)
            goto L_0x007f
        L_0x007a:
            long r0 = -r11
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.a1(java.lang.String, int):java.lang.Long");
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short b1(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        return c1(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short c1(@NotNull String str, int i2) {
        int intValue;
        Intrinsics.p(str, "<this>");
        Integer Y0 = Y0(str, i2);
        if (Y0 == null || (intValue = Y0.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
