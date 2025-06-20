package com.itextpdf.text.pdf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.PlaybackException;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import org.apache.commons.httpclient.HttpStatus;

public class Barcode128 extends Barcode {
    private static final byte[][] D = {new byte[]{2, 1, 2, 2, 2, 2}, new byte[]{2, 2, 2, 1, 2, 2}, new byte[]{2, 2, 2, 2, 2, 1}, new byte[]{1, 2, 1, 2, 2, 3}, new byte[]{1, 2, 1, 3, 2, 2}, new byte[]{1, 3, 1, 2, 2, 2}, new byte[]{1, 2, 2, 2, 1, 3}, new byte[]{1, 2, 2, 3, 1, 2}, new byte[]{1, 3, 2, 2, 1, 2}, new byte[]{2, 2, 1, 2, 1, 3}, new byte[]{2, 2, 1, 3, 1, 2}, new byte[]{2, 3, 1, 2, 1, 2}, new byte[]{1, 1, 2, 2, 3, 2}, new byte[]{1, 2, 2, 1, 3, 2}, new byte[]{1, 2, 2, 2, 3, 1}, new byte[]{1, 1, 3, 2, 2, 2}, new byte[]{1, 2, 3, 1, 2, 2}, new byte[]{1, 2, 3, 2, 2, 1}, new byte[]{2, 2, 3, 2, 1, 1}, new byte[]{2, 2, 1, 1, 3, 2}, new byte[]{2, 2, 1, 2, 3, 1}, new byte[]{2, 1, 3, 2, 1, 2}, new byte[]{2, 2, 3, 1, 1, 2}, new byte[]{3, 1, 2, 1, 3, 1}, new byte[]{3, 1, 1, 2, 2, 2}, new byte[]{3, 2, 1, 1, 2, 2}, new byte[]{3, 2, 1, 2, 2, 1}, new byte[]{3, 1, 2, 2, 1, 2}, new byte[]{3, 2, 2, 1, 1, 2}, new byte[]{3, 2, 2, 2, 1, 1}, new byte[]{2, 1, 2, 1, 2, 3}, new byte[]{2, 1, 2, 3, 2, 1}, new byte[]{2, 3, 2, 1, 2, 1}, new byte[]{1, 1, 1, 3, 2, 3}, new byte[]{1, 3, 1, 1, 2, 3}, new byte[]{1, 3, 1, 3, 2, 1}, new byte[]{1, 1, 2, 3, 1, 3}, new byte[]{1, 3, 2, 1, 1, 3}, new byte[]{1, 3, 2, 3, 1, 1}, new byte[]{2, 1, 1, 3, 1, 3}, new byte[]{2, 3, 1, 1, 1, 3}, new byte[]{2, 3, 1, 3, 1, 1}, new byte[]{1, 1, 2, 1, 3, 3}, new byte[]{1, 1, 2, 3, 3, 1}, new byte[]{1, 3, 2, 1, 3, 1}, new byte[]{1, 1, 3, 1, 2, 3}, new byte[]{1, 1, 3, 3, 2, 1}, new byte[]{1, 3, 3, 1, 2, 1}, new byte[]{3, 1, 3, 1, 2, 1}, new byte[]{2, 1, 1, 3, 3, 1}, new byte[]{2, 3, 1, 1, 3, 1}, new byte[]{2, 1, 3, 1, 1, 3}, new byte[]{2, 1, 3, 3, 1, 1}, new byte[]{2, 1, 3, 1, 3, 1}, new byte[]{3, 1, 1, 1, 2, 3}, new byte[]{3, 1, 1, 3, 2, 1}, new byte[]{3, 3, 1, 1, 2, 1}, new byte[]{3, 1, 2, 1, 1, 3}, new byte[]{3, 1, 2, 3, 1, 1}, new byte[]{3, 3, 2, 1, 1, 1}, new byte[]{3, 1, 4, 1, 1, 1}, new byte[]{2, 2, 1, 4, 1, 1}, new byte[]{4, 3, 1, 1, 1, 1}, new byte[]{1, 1, 1, 2, 2, 4}, new byte[]{1, 1, 1, 4, 2, 2}, new byte[]{1, 2, 1, 1, 2, 4}, new byte[]{1, 2, 1, 4, 2, 1}, new byte[]{1, 4, 1, 1, 2, 2}, new byte[]{1, 4, 1, 2, 2, 1}, new byte[]{1, 1, 2, 2, 1, 4}, new byte[]{1, 1, 2, 4, 1, 2}, new byte[]{1, 2, 2, 1, 1, 4}, new byte[]{1, 2, 2, 4, 1, 1}, new byte[]{1, 4, 2, 1, 1, 2}, new byte[]{1, 4, 2, 2, 1, 1}, new byte[]{2, 4, 1, 2, 1, 1}, new byte[]{2, 2, 1, 1, 1, 4}, new byte[]{4, 1, 3, 1, 1, 1}, new byte[]{2, 4, 1, 1, 1, 2}, new byte[]{1, 3, 4, 1, 1, 1}, new byte[]{1, 1, 1, 2, 4, 2}, new byte[]{1, 2, 1, 1, 4, 2}, new byte[]{1, 2, 1, 2, 4, 1}, new byte[]{1, 1, 4, 2, 1, 2}, new byte[]{1, 2, 4, 1, 1, 2}, new byte[]{1, 2, 4, 2, 1, 1}, new byte[]{4, 1, 1, 2, 1, 2}, new byte[]{4, 2, 1, 1, 1, 2}, new byte[]{4, 2, 1, 2, 1, 1}, new byte[]{2, 1, 2, 1, 4, 1}, new byte[]{2, 1, 4, 1, 2, 1}, new byte[]{4, 1, 2, 1, 2, 1}, new byte[]{1, 1, 1, 1, 4, 3}, new byte[]{1, 1, 1, 3, 4, 1}, new byte[]{1, 3, 1, 1, 4, 1}, new byte[]{1, 1, 4, 1, 1, 3}, new byte[]{1, 1, 4, 3, 1, 1}, new byte[]{4, 1, 1, 1, 1, 3}, new byte[]{4, 1, 1, 3, 1, 1}, new byte[]{1, 1, 3, 1, 4, 1}, new byte[]{1, 1, 4, 1, 3, 1}, new byte[]{3, 1, 1, 1, 4, 1}, new byte[]{4, 1, 1, 1, 3, 1}, new byte[]{2, 1, 1, 4, 1, 2}, new byte[]{2, 1, 1, 2, 1, 4}, new byte[]{2, 1, 1, 2, 3, 2}};
    private static final byte[] E = {2, 3, 3, 1, 1, 1, 2};
    public static final char F = 'c';
    public static final char G = 'd';
    public static final char H = 'e';
    public static final char I = 'f';
    public static final char J = 'g';
    public static final char K = 'h';
    public static final char L = 'i';
    public static final char M = 'Ê';
    public static final char N = 'Ã';
    public static final char O = 'Ä';
    public static final char P = 'Å';
    public static final char Q = 'Æ';
    public static final char R = 'Ç';
    public static final char S = 'È';
    public static final char T = 'È';
    public static final char U = 'Ë';
    public static final char V = 'Ì';
    public static final char W = 'Í';
    private static final IntHashtable X;
    private Barcode128CodeSet C = Barcode128CodeSet.AUTO;

    /* renamed from: com.itextpdf.text.pdf.Barcode128$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25865a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet[] r0 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25865a = r0
                com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r1 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.A     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f25865a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r1 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.B     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f25865a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r1 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.C     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.Barcode128.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Barcode128CodeSet {
        A,
        B,
        C,
        AUTO;

        public char a() {
            int i2 = AnonymousClass1.f25865a[ordinal()];
            if (i2 != 1) {
                return i2 != 3 ? Barcode128.K : Barcode128.L;
            }
            return Barcode128.J;
        }
    }

    static {
        IntHashtable intHashtable = new IntHashtable();
        X = intHashtable;
        intHashtable.l(0, 20);
        intHashtable.l(1, 16);
        intHashtable.l(2, 16);
        intHashtable.l(10, -1);
        intHashtable.l(11, 9);
        intHashtable.l(12, 8);
        intHashtable.l(13, 8);
        intHashtable.l(15, 8);
        intHashtable.l(17, 8);
        intHashtable.l(20, 4);
        intHashtable.l(21, -1);
        intHashtable.l(22, -1);
        intHashtable.l(23, -1);
        intHashtable.l(PsExtractor.A, -1);
        intHashtable.l(241, -1);
        intHashtable.l(ItemTouchHelper.Callback.f15380c, -1);
        intHashtable.l(251, -1);
        intHashtable.l(252, -1);
        intHashtable.l(30, -1);
        for (int i2 = 3100; i2 < 3700; i2++) {
            X.l(i2, 10);
        }
        X.l(37, -1);
        for (int i3 = 3900; i3 < 3940; i3++) {
            X.l(i3, -1);
        }
        IntHashtable intHashtable2 = X;
        intHashtable2.l(400, -1);
        intHashtable2.l(401, -1);
        intHashtable2.l(402, 20);
        intHashtable2.l(403, -1);
        for (int i4 = HttpStatus.SC_GONE; i4 < 416; i4++) {
            X.l(i4, 16);
        }
        IntHashtable intHashtable3 = X;
        intHashtable3.l(420, -1);
        intHashtable3.l(TypedValues.CycleType.s, -1);
        intHashtable3.l(422, 6);
        intHashtable3.l(423, -1);
        intHashtable3.l(424, 6);
        intHashtable3.l(TypedValues.CycleType.w, 6);
        intHashtable3.l(426, 6);
        intHashtable3.l(PlaybackException.G3, 17);
        intHashtable3.l(7002, -1);
        for (int i5 = 7030; i5 < 7040; i5++) {
            X.l(i5, -1);
        }
        IntHashtable intHashtable4 = X;
        intHashtable4.l(8001, 18);
        intHashtable4.l(8002, -1);
        intHashtable4.l(8003, -1);
        intHashtable4.l(8004, -1);
        intHashtable4.l(8005, 10);
        intHashtable4.l(8006, 22);
        intHashtable4.l(8007, -1);
        intHashtable4.l(8008, -1);
        intHashtable4.l(8018, 22);
        intHashtable4.l(8020, -1);
        intHashtable4.l(8100, 10);
        intHashtable4.l(8101, 14);
        intHashtable4.l(8102, 6);
        for (int i6 = 90; i6 < 100; i6++) {
            X.l(i6, -1);
        }
    }

    public Barcode128() {
        try {
            this.f25851a = 0.8f;
            this.f25853c = BaseFont.j("Helvetica", "winansi", false);
            this.f25854d = 8.0f;
            this.f25855e = 8.0f;
            this.f25856f = 8.0f * 3.0f;
            this.f25857g = 1;
            this.f25864n = 9;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static byte[] K(String str) {
        int indexOf = str.indexOf(65535);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        int charAt = str.charAt(0);
        for (int i2 = 1; i2 < str.length(); i2++) {
            charAt += str.charAt(i2) * i2;
        }
        String str2 = str + ((char) (charAt % 103));
        byte[] bArr = new byte[(((str2.length() + 1) * 6) + 7)];
        int i3 = 0;
        while (i3 < str2.length()) {
            System.arraycopy(D[str2.charAt(i3)], 0, bArr, i3 * 6, 6);
            i3++;
        }
        System.arraycopy(E, 0, bArr, i3 * 6, 7);
        return bArr;
    }

    public static String M(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String valueOf = String.valueOf(M);
        while (true) {
            try {
                if (str.startsWith(valueOf)) {
                    str = str.substring(1);
                } else {
                    int i2 = 2;
                    int i3 = 0;
                    while (true) {
                        if (i2 >= 5) {
                            break;
                        } else if (str.length() < i2) {
                            break;
                        } else {
                            i3 = X.e(Integer.parseInt(str.substring(0, i2)));
                            if (i3 != 0) {
                                break;
                            }
                            i2++;
                        }
                    }
                    i2 = 0;
                    if (i2 == 0) {
                        break;
                    }
                    stringBuffer.append(ASCIIPropertyListParser.f18649g);
                    stringBuffer.append(str.substring(0, i2));
                    stringBuffer.append(ASCIIPropertyListParser.f18650h);
                    str = str.substring(i2);
                    if (i3 > 0) {
                        int i4 = i3 - i2;
                        if (str.length() <= i4) {
                            break;
                        }
                        stringBuffer.append(R(str.substring(0, i4)));
                        str = str.substring(i4);
                    } else {
                        int indexOf = str.indexOf(202);
                        if (indexOf < 0) {
                            break;
                        }
                        stringBuffer.append(str.substring(0, indexOf));
                        str = str.substring(indexOf + 1);
                    }
                }
            } catch (Exception unused) {
            }
        }
        stringBuffer.append(R(str));
        return stringBuffer.toString();
    }

    static String N(String str, int i2, int i3) {
        StringBuilder sb = new StringBuilder("");
        int i4 = i2;
        while (i3 > 0) {
            if (str.charAt(i4) == 202) {
                sb.append(I);
                i4++;
            } else {
                i3 -= 2;
                int i5 = i4 + 1;
                i4 += 2;
                sb.append((char) (((str.charAt(i4) - '0') * 10) + (str.charAt(i5) - '0')));
            }
        }
        return ((char) (i4 - i2)) + sb.toString();
    }

    public static String O(String str, boolean z) {
        return P(str, z, Barcode128CodeSet.AUTO);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0188, code lost:
        r10.append(r7);
        r10.append(I);
        r7 = r10.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0192, code lost:
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01aa, code lost:
        r8.append(r7);
        r8.append((char) (r10 + '@'));
        r7 = r8.toString();
        r10 = r11;
        r8 = J;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0205, code lost:
        r11.append(r7);
        r11.append(r8.substring(1));
        r7 = r11.toString();
        r8 = L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02dd, code lost:
        if (r1 == com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.Z) goto L_0x02f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02e3, code lost:
        if (r8 != r18.a()) goto L_0x02e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02f3, code lost:
        throw new java.lang.RuntimeException(com.itextpdf.text.error_messages.MessageLocalization.b("there.are.illegal.characters.for.barcode.128.in.1", r0));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String P(java.lang.String r16, boolean r17, com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet r18) {
        /*
            r0 = r16
            r1 = r18
            r2 = 0
            r3 = 32
            r4 = 1
            int r5 = r16.length()
            r6 = 102(0x66, float:1.43E-43)
            java.lang.String r7 = ""
            if (r5 != 0) goto L_0x0037
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            char r1 = r18.a()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            if (r17 == 0) goto L_0x0036
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x0036:
            return r0
        L_0x0037:
            r8 = 0
        L_0x0038:
            java.lang.String r9 = "there.are.illegal.characters.for.barcode.128.in.1"
            r10 = 202(0xca, float:2.83E-43)
            if (r8 >= r5) goto L_0x0059
            char r11 = r0.charAt(r8)
            r12 = 127(0x7f, float:1.78E-43)
            if (r11 <= r12) goto L_0x0057
            if (r11 != r10) goto L_0x0049
            goto L_0x0057
        L_0x0049:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.Object[] r3 = new java.lang.Object[r4]
            r3[r2] = r0
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r9, r3)
            r1.<init>(r0)
            throw r1
        L_0x0057:
            int r8 = r8 + r4
            goto L_0x0038
        L_0x0059:
            char r8 = r0.charAt(r2)
            com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r11 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.AUTO
            r12 = 103(0x67, float:1.44E-43)
            r13 = 105(0x69, float:1.47E-43)
            r14 = 104(0x68, float:1.46E-43)
            r15 = 2
            if (r1 == r11) goto L_0x006c
            com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r10 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.C
            if (r1 != r10) goto L_0x00b1
        L_0x006c:
            boolean r10 = Q(r0, r2, r15)
            if (r10 == 0) goto L_0x00b1
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r13)
            java.lang.String r7 = r8.toString()
            if (r17 == 0) goto L_0x0092
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r6)
            java.lang.String r7 = r8.toString()
        L_0x0092:
            java.lang.String r8 = N(r0, r2, r15)
            char r10 = r8.charAt(r2)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r7)
            java.lang.String r7 = r8.substring(r4)
            r13.append(r7)
            java.lang.String r7 = r13.toString()
            r8 = 105(0x69, float:1.47E-43)
            goto L_0x012f
        L_0x00b1:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            if (r8 >= r3) goto L_0x00e9
            r10.<init>()
            r10.append(r7)
            r10.append(r12)
            java.lang.String r7 = r10.toString()
            if (r17 == 0) goto L_0x00d3
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r6)
            java.lang.String r7 = r10.toString()
        L_0x00d3:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            int r8 = r8 + 64
            char r7 = (char) r8
            r10.append(r7)
            java.lang.String r7 = r10.toString()
            r8 = 103(0x67, float:1.44E-43)
        L_0x00e7:
            r10 = 1
            goto L_0x012f
        L_0x00e9:
            r10.<init>()
            r10.append(r7)
            r10.append(r14)
            java.lang.String r7 = r10.toString()
            if (r17 == 0) goto L_0x0107
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r6)
            java.lang.String r7 = r10.toString()
        L_0x0107:
            r10 = 202(0xca, float:2.83E-43)
            if (r8 != r10) goto L_0x011b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r6)
            java.lang.String r7 = r8.toString()
            goto L_0x012c
        L_0x011b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            int r8 = r8 - r3
            char r7 = (char) r8
            r10.append(r7)
            java.lang.String r7 = r10.toString()
        L_0x012c:
            r8 = 104(0x68, float:1.46E-43)
            goto L_0x00e7
        L_0x012f:
            if (r1 == r11) goto L_0x0146
            char r11 = r18.a()
            if (r8 != r11) goto L_0x0138
            goto L_0x0146
        L_0x0138:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.Object[] r3 = new java.lang.Object[r4]
            r3[r2] = r0
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r9, r3)
            r1.<init>(r0)
            throw r1
        L_0x0146:
            if (r10 >= r5) goto L_0x02fa
            r11 = 99
            r13 = 100
            r12 = 101(0x65, float:1.42E-43)
            r14 = 4
            switch(r8) {
                case 103: goto L_0x0253;
                case 104: goto L_0x01de;
                case 105: goto L_0x0156;
                default: goto L_0x0152;
            }
        L_0x0152:
            r12 = 202(0xca, float:2.83E-43)
            goto L_0x02db
        L_0x0156:
            boolean r11 = Q(r0, r10, r15)
            if (r11 == 0) goto L_0x0179
            java.lang.String r11 = N(r0, r10, r15)
            char r12 = r11.charAt(r2)
            int r10 = r10 + r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r7)
            java.lang.String r7 = r11.substring(r4)
            r12.append(r7)
            java.lang.String r7 = r12.toString()
            goto L_0x0152
        L_0x0179:
            int r11 = r10 + 1
            char r10 = r0.charAt(r10)
            r14 = 202(0xca, float:2.83E-43)
            if (r10 != r14) goto L_0x0194
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
        L_0x0188:
            r10.append(r7)
            r10.append(r6)
            java.lang.String r7 = r10.toString()
        L_0x0192:
            r10 = r11
            goto L_0x0152
        L_0x0194:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            if (r10 >= r3) goto L_0x01bb
            r8.<init>()
            r8.append(r7)
            r8.append(r12)
            java.lang.String r7 = r8.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
        L_0x01aa:
            r8.append(r7)
            int r10 = r10 + 64
            char r7 = (char) r10
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r10 = r11
            r8 = 103(0x67, float:1.44E-43)
            goto L_0x0152
        L_0x01bb:
            r8.<init>()
            r8.append(r7)
            r8.append(r13)
            java.lang.String r7 = r8.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            int r10 = r10 - r3
            char r7 = (char) r10
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r10 = r11
            r8 = 104(0x68, float:1.46E-43)
            goto L_0x0152
        L_0x01de:
            com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r13 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.AUTO
            if (r1 != r13) goto L_0x0217
            boolean r13 = Q(r0, r10, r14)
            if (r13 == 0) goto L_0x0217
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r11)
            java.lang.String r7 = r8.toString()
            java.lang.String r8 = N(r0, r10, r14)
            char r11 = r8.charAt(r2)
            int r10 = r10 + r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
        L_0x0205:
            r11.append(r7)
            java.lang.String r7 = r8.substring(r4)
            r11.append(r7)
            java.lang.String r7 = r11.toString()
            r8 = 105(0x69, float:1.47E-43)
            goto L_0x0152
        L_0x0217:
            int r11 = r10 + 1
            char r10 = r0.charAt(r10)
            r13 = 202(0xca, float:2.83E-43)
            if (r10 != r13) goto L_0x0228
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            goto L_0x0188
        L_0x0228:
            if (r10 >= r3) goto L_0x0240
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r12)
            java.lang.String r7 = r8.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            goto L_0x01aa
        L_0x0240:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r7)
            int r10 = r10 - r3
            char r7 = (char) r10
            r12.append(r7)
            java.lang.String r7 = r12.toString()
            goto L_0x0192
        L_0x0253:
            com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r12 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.AUTO
            if (r1 != r12) goto L_0x027b
            boolean r12 = Q(r0, r10, r14)
            if (r12 == 0) goto L_0x027b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r11)
            java.lang.String r7 = r8.toString()
            java.lang.String r8 = N(r0, r10, r14)
            char r11 = r8.charAt(r2)
            int r10 = r10 + r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            goto L_0x0205
        L_0x027b:
            int r11 = r10 + 1
            char r10 = r0.charAt(r10)
            r12 = 202(0xca, float:2.83E-43)
            if (r10 != r12) goto L_0x0296
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r6)
            java.lang.String r7 = r10.toString()
        L_0x0294:
            r10 = r11
            goto L_0x02db
        L_0x0296:
            r14 = 95
            if (r10 <= r14) goto L_0x02be
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r13)
            java.lang.String r7 = r8.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            int r10 = r10 - r3
            char r7 = (char) r10
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r10 = r11
            r8 = 104(0x68, float:1.46E-43)
            goto L_0x02db
        L_0x02be:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            if (r10 >= r3) goto L_0x02d3
            r13.<init>()
            r13.append(r7)
            int r10 = r10 + 64
        L_0x02ca:
            char r7 = (char) r10
            r13.append(r7)
            java.lang.String r7 = r13.toString()
            goto L_0x0294
        L_0x02d3:
            r13.<init>()
            r13.append(r7)
            int r10 = r10 - r3
            goto L_0x02ca
        L_0x02db:
            com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r11 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.AUTO
            if (r1 == r11) goto L_0x02f4
            char r11 = r18.a()
            if (r8 != r11) goto L_0x02e6
            goto L_0x02f4
        L_0x02e6:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.Object[] r3 = new java.lang.Object[r4]
            r3[r2] = r0
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r9, r3)
            r1.<init>(r0)
            throw r1
        L_0x02f4:
            r12 = 103(0x67, float:1.44E-43)
            r14 = 104(0x68, float:1.46E-43)
            goto L_0x0146
        L_0x02fa:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.Barcode128.P(java.lang.String, boolean, com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet):java.lang.String");
    }

    static boolean Q(String str, int i2, int i3) {
        int length = str.length();
        loop0:
        while (i2 < length && i3 > 0) {
            if (str.charAt(i2) == 202) {
                i2++;
            } else {
                int min = Math.min(2, i3);
                if (i2 + min > length) {
                    return false;
                }
                while (true) {
                    int i4 = min - 1;
                    if (min <= 0) {
                        continue;
                        break;
                    }
                    int i5 = i2 + 1;
                    char charAt = str.charAt(i2);
                    if (charAt < '0' || charAt > '9') {
                        return false;
                    }
                    i3--;
                    i2 = i5;
                    min = i4;
                }
                return false;
            }
        }
        return i3 == 0;
    }

    public static String R(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= ' ' && charAt <= '~') {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public Barcode128CodeSet L() {
        return this.C;
    }

    public void S(Barcode128CodeSet barcode128CodeSet) {
        this.C = barcode128CodeSet;
    }

    public Rectangle e() {
        float f2;
        String str;
        String str2;
        BaseFont baseFont = this.f25853c;
        boolean z = true;
        float f3 = 0.0f;
        if (baseFont != null) {
            float f4 = this.f25855e;
            float I2 = f4 > 0.0f ? f4 - baseFont.I(3, this.f25854d) : (-f4) + this.f25854d;
            int i2 = this.f25864n;
            if (i2 == 11) {
                int indexOf = this.f25862l.indexOf(65535);
                str2 = indexOf < 0 ? "" : this.f25862l.substring(indexOf + 1);
            } else {
                str2 = i2 == 10 ? M(this.f25862l) : R(this.f25862l);
            }
            BaseFont baseFont2 = this.f25853c;
            String str3 = this.p;
            if (str3 != null) {
                str2 = str3;
            }
            float f5 = I2;
            f3 = baseFont2.Z(str2, this.f25854d);
            f2 = f5;
        } else {
            f2 = 0.0f;
        }
        int i3 = this.f25864n;
        if (i3 == 11) {
            int indexOf2 = this.f25862l.indexOf(65535);
            str = indexOf2 >= 0 ? this.f25862l.substring(0, indexOf2) : this.f25862l;
        } else {
            String str4 = this.f25862l;
            if (i3 != 10) {
                z = false;
            }
            str = P(str4, z, this.C);
        }
        float f6 = this.f25851a;
        return new Rectangle(Math.max((((float) ((str.length() + 2) * 11)) * f6) + (f6 * 2.0f), f3), this.f25856f + f2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Rectangle t(com.itextpdf.text.pdf.PdfContentByte r12, com.itextpdf.text.BaseColor r13, com.itextpdf.text.BaseColor r14) {
        /*
            r11 = this;
            int r0 = r11.f25864n
            r1 = 10
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 1
            r4 = 11
            if (r0 != r4) goto L_0x001f
            java.lang.String r0 = r11.f25862l
            int r0 = r0.indexOf(r2)
            if (r0 >= 0) goto L_0x0017
            java.lang.String r0 = ""
            goto L_0x002e
        L_0x0017:
            java.lang.String r5 = r11.f25862l
            int r0 = r0 + r3
            java.lang.String r0 = r5.substring(r0)
            goto L_0x002e
        L_0x001f:
            if (r0 != r1) goto L_0x0028
            java.lang.String r0 = r11.f25862l
            java.lang.String r0 = M(r0)
            goto L_0x002e
        L_0x0028:
            java.lang.String r0 = r11.f25862l
            java.lang.String r0 = R(r0)
        L_0x002e:
            com.itextpdf.text.pdf.BaseFont r5 = r11.f25853c
            r6 = 0
            if (r5 == 0) goto L_0x003f
            java.lang.String r7 = r11.p
            if (r7 == 0) goto L_0x0038
            r0 = r7
        L_0x0038:
            float r7 = r11.f25854d
            float r5 = r5.Z(r0, r7)
            goto L_0x0040
        L_0x003f:
            r5 = 0
        L_0x0040:
            int r7 = r11.f25864n
            r8 = 0
            if (r7 != r4) goto L_0x0057
            java.lang.String r1 = r11.f25862l
            int r1 = r1.indexOf(r2)
            if (r1 < 0) goto L_0x0054
            java.lang.String r2 = r11.f25862l
            java.lang.String r1 = r2.substring(r8, r1)
            goto L_0x0064
        L_0x0054:
            java.lang.String r1 = r11.f25862l
            goto L_0x0064
        L_0x0057:
            java.lang.String r2 = r11.f25862l
            if (r7 != r1) goto L_0x005d
            r1 = 1
            goto L_0x005e
        L_0x005d:
            r1 = 0
        L_0x005e:
            com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r7 = r11.C
            java.lang.String r1 = P(r2, r1, r7)
        L_0x0064:
            int r2 = r1.length()
            r7 = 2
            int r2 = r2 + r7
            int r2 = r2 * 11
            float r2 = (float) r2
            float r4 = r11.f25851a
            float r2 = r2 * r4
            r9 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 * r9
            float r2 = r2 + r4
            int r4 = r11.f25857g
            if (r4 == 0) goto L_0x0090
            if (r4 == r7) goto L_0x0088
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0084
            float r5 = r5 - r2
            float r5 = r5 / r9
        L_0x0082:
            r2 = 0
            goto L_0x0092
        L_0x0084:
            float r2 = r2 - r5
            float r2 = r2 / r9
        L_0x0086:
            r5 = 0
            goto L_0x0092
        L_0x0088:
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x008e
            float r5 = r5 - r2
            goto L_0x0082
        L_0x008e:
            float r2 = r2 - r5
            goto L_0x0086
        L_0x0090:
            r2 = 0
            goto L_0x0086
        L_0x0092:
            com.itextpdf.text.pdf.BaseFont r4 = r11.f25853c
            if (r4 == 0) goto L_0x00af
            float r7 = r11.f25855e
            int r9 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r9 > 0) goto L_0x00a0
            float r4 = r11.f25856f
            float r4 = r4 - r7
            goto L_0x00b0
        L_0x00a0:
            r6 = 3
            float r7 = r11.f25854d
            float r4 = r4.I(r6, r7)
            float r6 = -r4
            float r4 = r11.f25855e
            float r4 = r4 + r6
            r10 = r6
            r6 = r4
            r4 = r10
            goto L_0x00b0
        L_0x00af:
            r4 = 0
        L_0x00b0:
            byte[] r1 = K(r1)
            if (r13 == 0) goto L_0x00b9
            r12.h2(r13)
        L_0x00b9:
            int r13 = r1.length
            if (r8 >= r13) goto L_0x00d4
            byte r13 = r1[r8]
            float r13 = (float) r13
            float r7 = r11.f25851a
            float r13 = r13 * r7
            if (r3 == 0) goto L_0x00ce
            float r7 = r11.o
            float r7 = r13 - r7
            float r9 = r11.f25856f
            r12.H1(r5, r6, r7, r9)
        L_0x00ce:
            r3 = r3 ^ 1
            float r5 = r5 + r13
            int r8 = r8 + 1
            goto L_0x00b9
        L_0x00d4:
            r12.Q0()
            com.itextpdf.text.pdf.BaseFont r13 = r11.f25853c
            if (r13 == 0) goto L_0x00f3
            if (r14 == 0) goto L_0x00e0
            r12.h2(r14)
        L_0x00e0:
            r12.R()
            com.itextpdf.text.pdf.BaseFont r13 = r11.f25853c
            float r14 = r11.f25854d
            r12.s2(r13, r14)
            r12.e3(r2, r4)
            r12.m3(r0)
            r12.L0()
        L_0x00f3:
            com.itextpdf.text.Rectangle r12 = r11.e()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.Barcode128.t(com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.BaseColor, com.itextpdf.text.BaseColor):com.itextpdf.text.Rectangle");
    }

    public void y(String str) {
        if (h() == 10 && str.startsWith("(")) {
            StringBuilder sb = new StringBuilder("");
            int i2 = 0;
            while (i2 >= 0) {
                int indexOf = str.indexOf(41, i2);
                if (indexOf >= 0) {
                    String substring = str.substring(i2 + 1, indexOf);
                    if (substring.length() >= 2) {
                        int parseInt = Integer.parseInt(substring);
                        int e2 = X.e(parseInt);
                        if (e2 != 0) {
                            String valueOf = String.valueOf(parseInt);
                            if (valueOf.length() == 1) {
                                valueOf = "0" + valueOf;
                            }
                            int indexOf2 = str.indexOf(40, indexOf);
                            int length = indexOf2 < 0 ? str.length() : indexOf2;
                            sb.append(valueOf);
                            sb.append(str.substring(indexOf + 1, length));
                            if (e2 < 0) {
                                if (indexOf2 >= 0) {
                                    sb.append(M);
                                }
                            } else if (((length - indexOf) - 1) + valueOf.length() != e2) {
                                throw new IllegalArgumentException(MessageLocalization.b("invalid.ai.length.1", valueOf));
                            }
                            i2 = indexOf2;
                        } else {
                            throw new IllegalArgumentException(MessageLocalization.b("ai.not.found.1", substring));
                        }
                    } else {
                        throw new IllegalArgumentException(MessageLocalization.b("ai.too.short.1", substring));
                    }
                } else {
                    throw new IllegalArgumentException(MessageLocalization.b("badly.formed.ucc.string.1", str));
                }
            }
            str = sb.toString();
        }
        super.y(str);
    }
}
