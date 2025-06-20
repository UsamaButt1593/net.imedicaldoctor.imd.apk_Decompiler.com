package com.itextpdf.text.pdf;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.base.Ascii;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.ExceptionConverter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import kotlin.text.Typography;
import net.lingala.zip4j.util.InternalZipConstants;
import okio.Utf8;
import org.apache.commons.lang3.ClassUtils;

public class PdfEncodings {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f26196a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, ' ', '!', '\"', '#', '$', '%', Typography.f29117d, '\'', ASCIIPropertyListParser.f18649g, ASCIIPropertyListParser.f18650h, '*', '+', ASCIIPropertyListParser.f18651i, '-', ClassUtils.PACKAGE_SEPARATOR_CHAR, '/', '0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', ASCIIPropertyListParser.A, ASCIIPropertyListParser.f18655m, '<', ASCIIPropertyListParser.f18654l, '>', '?', '@', 'A', ASCIIPropertyListParser.u, 'C', ASCIIPropertyListParser.t, 'E', 'F', 'G', 'H', ASCIIPropertyListParser.x, 'J', 'K', 'L', 'M', ASCIIPropertyListParser.w, 'O', 'P', 'Q', ASCIIPropertyListParser.y, 'S', ASCIIPropertyListParser.C, 'U', 'V', 'W', 'X', ASCIIPropertyListParser.v, ASCIIPropertyListParser.D, '[', ASCIIPropertyListParser.p, ']', '^', '_', '`', 'a', 'b', Barcode128.F, Barcode128.G, Barcode128.H, Barcode128.I, Barcode128.J, Barcode128.K, Barcode128.L, 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ASCIIPropertyListParser.f18652j, '|', ASCIIPropertyListParser.f18653k, '~', Ascii.N, Typography.I, 65533, Typography.y, 402, Typography.B, Typography.F, Typography.C, Typography.D, 710, 8240, 352, 8249, 338, 65533, 381, 65533, 65533, Typography.w, Typography.x, Typography.z, Typography.A, Typography.E, Typography.u, Typography.v, 732, Typography.J, 353, 8250, 339, 65533, 382, 376, Typography.f29120g, 161, Typography.f29122i, Typography.f29123j, 164, 165, 166, Typography.f29124k, 168, Typography.f29125l, 170, 171, 172, 173, Typography.o, 175, Typography.p, Typography.q, 178, 179, 180, 181, Typography.r, Typography.s, 184, 185, 186, 187, 188, Typography.t, 190, 191, 192, 193, 194, Barcode128.N, Barcode128.O, Barcode128.P, Barcode128.Q, Barcode128.R, 200, 201, Barcode128.M, Barcode128.U, Barcode128.V, Barcode128.W, 206, 207, 208, 209, 210, 211, 212, 213, 214, Typography.f29121h, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};

    /* renamed from: b  reason: collision with root package name */
    static final char[] f26197b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, ' ', '!', '\"', '#', '$', '%', Typography.f29117d, '\'', ASCIIPropertyListParser.f18649g, ASCIIPropertyListParser.f18650h, '*', '+', ASCIIPropertyListParser.f18651i, '-', ClassUtils.PACKAGE_SEPARATOR_CHAR, '/', '0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', ASCIIPropertyListParser.A, ASCIIPropertyListParser.f18655m, '<', ASCIIPropertyListParser.f18654l, '>', '?', '@', 'A', ASCIIPropertyListParser.u, 'C', ASCIIPropertyListParser.t, 'E', 'F', 'G', 'H', ASCIIPropertyListParser.x, 'J', 'K', 'L', 'M', ASCIIPropertyListParser.w, 'O', 'P', 'Q', ASCIIPropertyListParser.y, 'S', ASCIIPropertyListParser.C, 'U', 'V', 'W', 'X', ASCIIPropertyListParser.v, ASCIIPropertyListParser.D, '[', ASCIIPropertyListParser.p, ']', '^', '_', '`', 'a', 'b', Barcode128.F, Barcode128.G, Barcode128.H, Barcode128.I, Barcode128.J, Barcode128.K, Barcode128.L, 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ASCIIPropertyListParser.f18652j, '|', ASCIIPropertyListParser.f18653k, '~', Ascii.N, Typography.E, Typography.C, Typography.D, Typography.F, Typography.v, Typography.u, 402, 8260, 8249, 8250, 8722, 8240, Typography.B, Typography.z, Typography.A, Typography.w, Typography.x, Typography.y, Typography.J, 64257, 64258, 321, 338, 352, 376, 381, 305, 322, 339, 353, 382, 65533, Typography.I, 161, Typography.f29122i, Typography.f29123j, 164, 165, 166, Typography.f29124k, 168, Typography.f29125l, 170, 171, 172, 173, Typography.o, 175, Typography.p, Typography.q, 178, 179, 180, 181, Typography.r, Typography.s, 184, 185, 186, 187, 188, Typography.t, 190, 191, 192, 193, 194, Barcode128.N, Barcode128.O, Barcode128.P, Barcode128.Q, Barcode128.R, 200, 201, Barcode128.M, Barcode128.U, Barcode128.V, Barcode128.W, 206, 207, 208, 209, 210, 211, 212, 213, 214, Typography.f29121h, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};

    /* renamed from: c  reason: collision with root package name */
    static final IntHashtable f26198c = new IntHashtable();

    /* renamed from: d  reason: collision with root package name */
    static final IntHashtable f26199d = new IntHashtable();

    /* renamed from: e  reason: collision with root package name */
    static HashMap<String, ExtraEncoding> f26200e = new HashMap<>();

    private static class Cp437Conversion implements ExtraEncoding {

        /* renamed from: a  reason: collision with root package name */
        private static IntHashtable f26201a = new IntHashtable();

        /* renamed from: b  reason: collision with root package name */
        private static final char[] f26202b = {Barcode128.R, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, Barcode128.O, Barcode128.P, 201, 230, Barcode128.Q, 244, 246, 242, 251, 249, 255, 214, 220, Typography.f29122i, Typography.f29123j, 165, 8359, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 8976, 172, Typography.t, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, Typography.q, Typography.N, Typography.M, 8992, 8993, 247, Typography.K, Typography.p, 8729, Typography.s, 8730, 8319, 178, 9632, Typography.f29120g};

        static {
            int i2 = 0;
            while (true) {
                char[] cArr = f26202b;
                if (i2 < cArr.length) {
                    f26201a.l(cArr[i2], i2 + 128);
                    i2++;
                } else {
                    return;
                }
            }
        }

        private Cp437Conversion() {
        }

        public byte[] a(String str, String str2) {
            int i2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i3 = 0;
            for (char c2 : charArray) {
                if (c2 < 128) {
                    i2 = i3 + 1;
                    bArr[i3] = (byte) c2;
                } else {
                    byte e2 = (byte) f26201a.e(c2);
                    if (e2 != 0) {
                        i2 = i3 + 1;
                        bArr[i3] = e2;
                    }
                }
                i3 = i2;
            }
            if (i3 == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            return bArr2;
        }

        public byte[] b(char c2, String str) {
            if (c2 < 128) {
                return new byte[]{(byte) c2};
            }
            byte e2 = (byte) f26201a.e(c2);
            if (e2 == 0) {
                return new byte[0];
            }
            return new byte[]{e2};
        }

        public String c(byte[] bArr, String str) {
            int i2;
            char[] cArr = new char[r8];
            int i3 = 0;
            for (byte b2 : bArr) {
                byte b3 = b2 & 255;
                if (b3 >= 32) {
                    if (b3 < 128) {
                        i2 = i3 + 1;
                        cArr[i3] = (char) b3;
                    } else {
                        i2 = i3 + 1;
                        cArr[i3] = f26202b[b3 - 128];
                    }
                    i3 = i2;
                }
            }
            return new String(cArr, 0, i3);
        }
    }

    private static class SymbolConversion implements ExtraEncoding {

        /* renamed from: c  reason: collision with root package name */
        private static final IntHashtable f26203c = new IntHashtable();

        /* renamed from: d  reason: collision with root package name */
        private static final IntHashtable f26204d = new IntHashtable();

        /* renamed from: e  reason: collision with root package name */
        private static final char[] f26205e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' ', '!', 8704, '#', 8707, '%', Typography.f29117d, 8715, ASCIIPropertyListParser.f18649g, ASCIIPropertyListParser.f18650h, '*', '+', ASCIIPropertyListParser.f18651i, '-', ClassUtils.PACKAGE_SEPARATOR_CHAR, '/', '0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', ASCIIPropertyListParser.A, ASCIIPropertyListParser.f18655m, '<', ASCIIPropertyListParser.f18654l, '>', '?', 8773, 913, 914, 935, 916, 917, 934, 915, 919, 921, 977, 922, 923, 924, 925, 927, 928, 920, 929, 931, 932, 933, 962, 937, 926, 936, 918, '[', 8756, ']', 8869, '_', 773, 945, 946, 967, 948, 949, 981, 947, 951, 953, 966, 954, 955, 956, 957, 959, 960, 952, 961, 963, 964, 965, 982, 969, 958, 968, 950, ASCIIPropertyListParser.f18652j, '|', ASCIIPropertyListParser.f18653k, '~', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Typography.I, 978, Typography.G, Typography.M, 8260, 8734, 402, 9827, 9830, 9829, 9824, 8596, 8592, 8593, 8594, 8595, Typography.p, Typography.q, Typography.H, Typography.N, Typography.f29121h, 8733, 8706, Typography.E, 247, Typography.L, 8801, Typography.K, Typography.F, 9474, 9472, 8629, 8501, 8465, 8476, 8472, 8855, 8853, 8709, 8745, 8746, 8835, 8839, 8836, 8834, 8838, 8712, 8713, 8736, 8711, Typography.o, Typography.f29125l, Typography.J, 8719, 8730, 8901, 172, 8743, 8744, 8660, 8656, 8657, 8658, 8659, 9674, 9001, 0, 0, 0, 8721, 9115, 9116, 9117, 9121, 9122, 9123, 9127, 9128, 9129, 9130, 0, 9002, 8747, 8992, 9134, 8993, 9118, 9119, 9120, 9124, 9125, 9126, 9131, 9132, 9133, 0};

        /* renamed from: f  reason: collision with root package name */
        private static final char[] f26206f = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' ', 9985, 9986, 9987, 9988, 9742, 9990, 9991, 9992, 9993, 9755, 9758, 9996, 9997, 9998, 9999, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 10021, 10022, 10023, 9733, 10025, 10026, 10027, 10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036, 10037, 10038, 10039, 10040, 10041, 10042, 10043, 10044, 10045, 10046, 10047, 10048, 10049, 10050, 10051, 10052, 10053, 10054, 10055, 10056, 10057, 10058, 10059, 9679, 10061, 9632, 10063, 10064, 10065, 10066, 9650, 9660, 9670, 10070, 9687, 10072, 10073, 10074, 10075, 10076, 10077, 10078, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10081, 10082, 10083, 10084, 10085, 10086, 10087, 9827, 9830, 9829, 9824, 9312, 9313, 9314, 9315, 9316, 9317, 9318, 9319, 9320, 9321, 10102, 10103, 10104, 10105, 10106, 10107, 10108, 10109, 10110, 10111, 10112, 10113, 10114, 10115, 10116, 10117, 10118, 10119, 10120, 10121, 10122, 10123, 10124, 10125, 10126, 10127, 10128, 10129, 10130, 10131, 10132, 8594, 8596, 8597, 10136, 10137, 10138, 10139, 10140, 10141, 10142, 10143, 10144, 10145, 10146, 10147, 10148, 10149, 10150, 10151, 10152, 10153, 10154, 10155, 10156, 10157, 10158, 10159, 0, 10161, 10162, 10163, 10164, 10165, 10166, 10167, 10168, 10169, 10170, 10171, 10172, 10173, 10174, 0};

        /* renamed from: a  reason: collision with root package name */
        private IntHashtable f26207a;

        /* renamed from: b  reason: collision with root package name */
        private final char[] f26208b;

        static {
            for (int i2 = 0; i2 < 256; i2++) {
                char c2 = f26205e[i2];
                if (c2 != 0) {
                    f26203c.l(c2, i2);
                }
            }
            for (int i3 = 0; i3 < 256; i3++) {
                char c3 = f26206f[i3];
                if (c3 != 0) {
                    f26204d.l(c3, i3);
                }
            }
        }

        SymbolConversion(boolean z) {
            if (z) {
                this.f26207a = f26203c;
                this.f26208b = f26205e;
                return;
            }
            this.f26207a = f26204d;
            this.f26208b = f26206f;
        }

        public byte[] a(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i2 = 0;
            for (char e2 : charArray) {
                byte e3 = (byte) this.f26207a.e(e2);
                if (e3 != 0) {
                    bArr[i2] = e3;
                    i2++;
                }
            }
            if (i2 == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        }

        public byte[] b(char c2, String str) {
            byte e2 = (byte) this.f26207a.e(c2);
            if (e2 == 0) {
                return new byte[0];
            }
            return new byte[]{e2};
        }

        public String c(byte[] bArr, String str) {
            int length = bArr.length;
            char[] cArr = new char[length];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                cArr[i3] = this.f26208b[bArr[i2] & 255];
                i2++;
                i3++;
            }
            return new String(cArr, 0, i3);
        }
    }

    private static class SymbolTTConversion implements ExtraEncoding {
        private SymbolTTConversion() {
        }

        public byte[] a(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i2 = 0;
            for (char c2 : charArray) {
                char c3 = 65280 & c2;
                if (c3 == 0 || c3 == 61440) {
                    bArr[i2] = (byte) c2;
                    i2++;
                }
            }
            if (i2 == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        }

        public byte[] b(char c2, String str) {
            char c3 = 65280 & c2;
            if (c3 != 0 && c3 != 61440) {
                return new byte[0];
            }
            return new byte[]{(byte) c2};
        }

        public String c(byte[] bArr, String str) {
            return null;
        }
    }

    private static class WingdingsConversion implements ExtraEncoding {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f26209a = {0, 35, DocWriter.e3, 0, 0, 0, 41, DocWriter.f3, 81, 42, 0, 0, 65, Utf8.f31404a, 0, 0, 0, 0, 0, -4, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 86, 0, 88, 89, 0, 0, 0, 0, 0, 0, 0, 0, -75, 0, 0, 0, 0, 0, -74, 0, 0, 0, -83, -81, -84, 0, 0, 0, 0, 0, 0, 0, 0, 124, 123, 0, 0, 0, 84, 0, 0, 0, 0, 0, 0, 0, 0, -90, 0, 0, 0, 113, 114, 0, 0, 0, 117, 0, 0, 0, 0, 0, 0, 125, 126, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -24, -40, 0, 0, -60, -58, 0, 0, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, -36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        private WingdingsConversion() {
        }

        public byte[] a(String str, String str2) {
            byte b2;
            int i2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i3 = 0;
            for (char c2 : charArray) {
                if (c2 == ' ') {
                    i2 = i3 + 1;
                    bArr[i3] = (byte) c2;
                } else {
                    if (c2 >= 9985 && c2 <= 10174 && (b2 = f26209a[c2 - 9984]) != 0) {
                        i2 = i3 + 1;
                        bArr[i3] = b2;
                    }
                }
                i3 = i2;
            }
            if (i3 == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            return bArr2;
        }

        public byte[] b(char c2, String str) {
            byte b2;
            if (c2 == ' ') {
                return new byte[]{(byte) c2};
            } else if (c2 < 9985 || c2 > 10174 || (b2 = f26209a[c2 - 9984]) == 0) {
                return new byte[0];
            } else {
                return new byte[]{b2};
            }
        }

        public String c(byte[] bArr, String str) {
            return null;
        }
    }

    static {
        for (int i2 = 128; i2 < 161; i2++) {
            char c2 = f26196a[i2];
            if (c2 != 65533) {
                f26198c.l(c2, i2);
            }
        }
        for (int i3 = 128; i3 < 161; i3++) {
            char c3 = f26197b[i3];
            if (c3 != 65533) {
                f26199d.l(c3, i3);
            }
        }
        a("Wingdings", new WingdingsConversion());
        a("Symbol", new SymbolConversion(true));
        a("ZapfDingbats", new SymbolConversion(false));
        a("SymbolTT", new SymbolTTConversion());
        a(InternalZipConstants.q, new Cp437Conversion());
    }

    public static void a(String str, ExtraEncoding extraEncoding) {
        synchronized (f26200e) {
            HashMap<String, ExtraEncoding> hashMap = (HashMap) f26200e.clone();
            hashMap.put(str.toLowerCase(), extraEncoding);
            f26200e = hashMap;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: char} */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (r4 <= 255) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        r4 = r2.e(r4);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] b(char r4, java.lang.String r5) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x00a0
            int r2 = r5.length()
            if (r2 != 0) goto L_0x000c
            goto L_0x00a0
        L_0x000c:
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.ExtraEncoding> r2 = f26200e
            java.lang.String r3 = r5.toLowerCase()
            java.lang.Object r2 = r2.get(r3)
            com.itextpdf.text.pdf.ExtraEncoding r2 = (com.itextpdf.text.pdf.ExtraEncoding) r2
            if (r2 == 0) goto L_0x0021
            byte[] r2 = r2.b(r4, r5)
            if (r2 == 0) goto L_0x0021
            return r2
        L_0x0021:
            java.lang.String r2 = "Cp1252"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x002c
            com.itextpdf.text.pdf.IntHashtable r2 = f26198c
            goto L_0x0038
        L_0x002c:
            java.lang.String r2 = "PDF"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0037
            com.itextpdf.text.pdf.IntHashtable r2 = f26199d
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            r3 = 255(0xff, float:3.57E-43)
            if (r2 == 0) goto L_0x0056
            r5 = 128(0x80, float:1.794E-43)
            if (r4 < r5) goto L_0x004b
            r5 = 160(0xa0, float:2.24E-43)
            if (r4 <= r5) goto L_0x0047
            if (r4 > r3) goto L_0x0047
            goto L_0x004b
        L_0x0047:
            int r4 = r2.e(r4)
        L_0x004b:
            if (r4 == 0) goto L_0x0053
            byte r4 = (byte) r4
            byte[] r5 = new byte[r0]
            r5[r1] = r4
            return r5
        L_0x0053:
            byte[] r4 = new byte[r1]
            return r4
        L_0x0056:
            java.lang.String r2 = "UnicodeBig"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0073
            int r5 = r4 >> 8
            byte r5 = (byte) r5
            r4 = r4 & r3
            byte r4 = (byte) r4
            r2 = 4
            byte[] r2 = new byte[r2]
            r3 = -2
            r2[r1] = r3
            r1 = -1
            r2[r0] = r1
            r0 = 2
            r2[r0] = r5
            r5 = 3
            r2[r5] = r4
            return r2
        L_0x0073:
            java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch:{ IOException -> 0x0099 }
            java.nio.charset.CharsetEncoder r5 = r5.newEncoder()     // Catch:{ IOException -> 0x0099 }
            java.nio.charset.CodingErrorAction r2 = java.nio.charset.CodingErrorAction.IGNORE     // Catch:{ IOException -> 0x0099 }
            r5.onUnmappableCharacter(r2)     // Catch:{ IOException -> 0x0099 }
            char[] r0 = new char[r0]     // Catch:{ IOException -> 0x0099 }
            r0[r1] = r4     // Catch:{ IOException -> 0x0099 }
            java.nio.CharBuffer r4 = java.nio.CharBuffer.wrap(r0)     // Catch:{ IOException -> 0x0099 }
            java.nio.ByteBuffer r4 = r5.encode(r4)     // Catch:{ IOException -> 0x0099 }
            r4.rewind()     // Catch:{ IOException -> 0x0099 }
            int r5 = r4.limit()     // Catch:{ IOException -> 0x0099 }
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0099 }
            r4.get(r5)     // Catch:{ IOException -> 0x0099 }
            return r5
        L_0x0099:
            r4 = move-exception
            com.itextpdf.text.ExceptionConverter r5 = new com.itextpdf.text.ExceptionConverter
            r5.<init>(r4)
            throw r5
        L_0x00a0:
            byte r4 = (byte) r4
            byte[] r5 = new byte[r0]
            r5[r1] = r4
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfEncodings.b(char, java.lang.String):byte[]");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: char} */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
        if (r6 <= 255) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        r6 = r1.e(r6);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] c(java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0006
            byte[] r8 = new byte[r0]
            return r8
        L_0x0006:
            if (r9 == 0) goto L_0x00cd
            int r1 = r9.length()
            if (r1 != 0) goto L_0x0010
            goto L_0x00cd
        L_0x0010:
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.ExtraEncoding> r1 = f26200e
            java.lang.String r2 = r9.toLowerCase()
            java.lang.Object r1 = r1.get(r2)
            com.itextpdf.text.pdf.ExtraEncoding r1 = (com.itextpdf.text.pdf.ExtraEncoding) r1
            if (r1 == 0) goto L_0x0025
            byte[] r1 = r1.a(r8, r9)
            if (r1 == 0) goto L_0x0025
            return r1
        L_0x0025:
            java.lang.String r1 = "Cp1252"
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L_0x0030
            com.itextpdf.text.pdf.IntHashtable r1 = f26198c
            goto L_0x003c
        L_0x0030:
            java.lang.String r1 = "PDF"
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L_0x003b
            com.itextpdf.text.pdf.IntHashtable r1 = f26199d
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            r2 = 255(0xff, float:3.57E-43)
            if (r1 == 0) goto L_0x0070
            char[] r8 = r8.toCharArray()
            int r9 = r8.length
            byte[] r3 = new byte[r9]
            r4 = 0
            r5 = 0
        L_0x0049:
            if (r4 >= r9) goto L_0x0067
            char r6 = r8[r4]
            r7 = 128(0x80, float:1.794E-43)
            if (r6 < r7) goto L_0x005c
            r7 = 160(0xa0, float:2.24E-43)
            if (r6 <= r7) goto L_0x0058
            if (r6 > r2) goto L_0x0058
            goto L_0x005c
        L_0x0058:
            int r6 = r1.e(r6)
        L_0x005c:
            if (r6 == 0) goto L_0x0064
            int r7 = r5 + 1
            byte r6 = (byte) r6
            r3[r5] = r6
            r5 = r7
        L_0x0064:
            int r4 = r4 + 1
            goto L_0x0049
        L_0x0067:
            if (r5 != r9) goto L_0x006a
            return r3
        L_0x006a:
            byte[] r8 = new byte[r5]
            java.lang.System.arraycopy(r3, r0, r8, r0, r5)
            return r8
        L_0x0070:
            java.lang.String r1 = "UnicodeBig"
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L_0x00a0
            char[] r8 = r8.toCharArray()
            int r9 = r8.length
            int r1 = r8.length
            r3 = 2
            int r1 = r1 * 2
            int r1 = r1 + r3
            byte[] r1 = new byte[r1]
            r4 = -2
            r1[r0] = r4
            r4 = -1
            r5 = 1
            r1[r5] = r4
            r4 = 2
        L_0x008c:
            if (r0 >= r9) goto L_0x009f
            char r5 = r8[r0]
            int r6 = r4 + 1
            int r7 = r5 >> 8
            byte r7 = (byte) r7
            r1[r4] = r7
            int r4 = r4 + r3
            r5 = r5 & r2
            byte r5 = (byte) r5
            r1[r6] = r5
            int r0 = r0 + 1
            goto L_0x008c
        L_0x009f:
            return r1
        L_0x00a0:
            java.nio.charset.Charset r9 = java.nio.charset.Charset.forName(r9)     // Catch:{ IOException -> 0x00c6 }
            java.nio.charset.CharsetEncoder r9 = r9.newEncoder()     // Catch:{ IOException -> 0x00c6 }
            java.nio.charset.CodingErrorAction r0 = java.nio.charset.CodingErrorAction.IGNORE     // Catch:{ IOException -> 0x00c6 }
            r9.onUnmappableCharacter(r0)     // Catch:{ IOException -> 0x00c6 }
            char[] r8 = r8.toCharArray()     // Catch:{ IOException -> 0x00c6 }
            java.nio.CharBuffer r8 = java.nio.CharBuffer.wrap(r8)     // Catch:{ IOException -> 0x00c6 }
            java.nio.ByteBuffer r8 = r9.encode(r8)     // Catch:{ IOException -> 0x00c6 }
            r8.rewind()     // Catch:{ IOException -> 0x00c6 }
            int r9 = r8.limit()     // Catch:{ IOException -> 0x00c6 }
            byte[] r9 = new byte[r9]     // Catch:{ IOException -> 0x00c6 }
            r8.get(r9)     // Catch:{ IOException -> 0x00c6 }
            return r9
        L_0x00c6:
            r8 = move-exception
            com.itextpdf.text.ExceptionConverter r9 = new com.itextpdf.text.ExceptionConverter
            r9.<init>(r8)
            throw r9
        L_0x00cd:
            int r9 = r8.length()
            byte[] r1 = new byte[r9]
        L_0x00d3:
            if (r0 >= r9) goto L_0x00df
            char r2 = r8.charAt(r0)
            byte r2 = (byte) r2
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x00d3
        L_0x00df:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfEncodings.c(java.lang.String, java.lang.String):byte[]");
    }

    public static final String d(byte[] bArr, String str) {
        String c2;
        if (bArr == null) {
            return "";
        }
        int i2 = 0;
        if (str == null || str.length() == 0) {
            char[] cArr = new char[bArr.length];
            while (i2 < bArr.length) {
                cArr[i2] = (char) (bArr[i2] & 255);
                i2++;
            }
            return new String(cArr);
        }
        ExtraEncoding extraEncoding = f26200e.get(str.toLowerCase());
        if (extraEncoding != null && (c2 = extraEncoding.c(bArr, str)) != null) {
            return c2;
        }
        char[] cArr2 = str.equals("Cp1252") ? f26196a : str.equals(PdfObject.g3) ? f26197b : null;
        if (cArr2 != null) {
            int length = bArr.length;
            char[] cArr3 = new char[length];
            while (i2 < length) {
                cArr3[i2] = cArr2[bArr[i2] & 255];
                i2++;
            }
            return new String(cArr3);
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static boolean e(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= 128 && ((charAt <= 160 || charAt > 255) && !f26199d.c(charAt))) {
                return false;
            }
        }
        return true;
    }
}
