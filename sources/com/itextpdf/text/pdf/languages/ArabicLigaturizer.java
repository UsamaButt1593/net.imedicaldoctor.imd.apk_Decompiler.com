package com.itextpdf.text.pdf.languages;

import com.itextpdf.text.pdf.BidiLine;
import com.itextpdf.text.pdf.BidiOrder;
import java.util.HashMap;

public class ArabicLigaturizer implements LanguageProcessor {
    private static final char A = 'ﻷ';
    private static final char B = 'ﻹ';
    private static final char C = 'ﻵ';
    private static final char[][] D;
    public static final int E = 0;
    public static final int F = 1;
    public static final int G = 4;
    public static final int H = 8;
    public static final int I = 32;
    public static final int J = 64;
    public static final int K = 96;
    public static final int L = 128;
    private static final int M = 160;
    public static final int N = 224;
    public static final int O = 0;
    public static final int P = 256;
    public static final int Q = 256;

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<Character, char[]> f26879c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<Character, Character> f26880d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static final char f26881e = 'ا';

    /* renamed from: f  reason: collision with root package name */
    private static final char f26882f = 'أ';

    /* renamed from: g  reason: collision with root package name */
    private static final char f26883g = 'إ';

    /* renamed from: h  reason: collision with root package name */
    private static final char f26884h = 'آ';

    /* renamed from: i  reason: collision with root package name */
    private static final char f26885i = 'ل';

    /* renamed from: j  reason: collision with root package name */
    private static final char f26886j = 'ء';

    /* renamed from: k  reason: collision with root package name */
    private static final char f26887k = 'ـ';

    /* renamed from: l  reason: collision with root package name */
    private static final char f26888l = '‍';

    /* renamed from: m  reason: collision with root package name */
    private static final char f26889m = 'ٔ';

    /* renamed from: n  reason: collision with root package name */
    private static final char f26890n = 'ٕ';
    private static final char o = 'ؤ';
    private static final char p = 'ئ';
    private static final char q = 'و';
    private static final char r = 'ى';
    private static final char s = 'ي';
    private static final char t = 'ی';
    private static final char u = 'ّ';
    private static final char v = 'ِ';
    private static final char w = 'َ';
    private static final char x = 'ُ';
    private static final char y = 'ٓ';
    private static final char z = 'ﻻ';

    /* renamed from: a  reason: collision with root package name */
    protected int f26891a;

    /* renamed from: b  reason: collision with root package name */
    protected int f26892b;

    static class charstruct {

        /* renamed from: a  reason: collision with root package name */
        char f26893a;

        /* renamed from: b  reason: collision with root package name */
        char f26894b;

        /* renamed from: c  reason: collision with root package name */
        char f26895c;

        /* renamed from: d  reason: collision with root package name */
        int f26896d;

        /* renamed from: e  reason: collision with root package name */
        int f26897e = 1;

        charstruct() {
        }
    }

    static {
        char c2;
        char[][] cArr = {new char[]{f26886j, 65152}, new char[]{f26884h, 65153, 65154}, new char[]{f26882f, 65155, 65156}, new char[]{o, 65157, 65158}, new char[]{f26883g, 65159, 65160}, new char[]{p, 65161, 65162, 65163, 65164}, new char[]{f26881e, 65165, 65166}, new char[]{1576, 65167, 65168, 65169, 65170}, new char[]{1577, 65171, 65172}, new char[]{1578, 65173, 65174, 65175, 65176}, new char[]{1579, 65177, 65178, 65179, 65180}, new char[]{1580, 65181, 65182, 65183, 65184}, new char[]{1581, 65185, 65186, 65187, 65188}, new char[]{1582, 65189, 65190, 65191, 65192}, new char[]{1583, 65193, 65194}, new char[]{1584, 65195, 65196}, new char[]{1585, 65197, 65198}, new char[]{1586, 65199, 65200}, new char[]{1587, 65201, 65202, 65203, 65204}, new char[]{1588, 65205, 65206, 65207, 65208}, new char[]{1589, 65209, 65210, 65211, 65212}, new char[]{1590, 65213, 65214, 65215, 65216}, new char[]{1591, 65217, 65218, 65219, 65220}, new char[]{1592, 65221, 65222, 65223, 65224}, new char[]{1593, 65225, 65226, 65227, 65228}, new char[]{1594, 65229, 65230, 65231, 65232}, new char[]{f26887k, f26887k, f26887k, f26887k, f26887k}, new char[]{1601, 65233, 65234, 65235, 65236}, new char[]{1602, 65237, 65238, 65239, 65240}, new char[]{1603, 65241, 65242, 65243, 65244}, new char[]{f26885i, 65245, 65246, 65247, 65248}, new char[]{1605, 65249, 65250, 65251, 65252}, new char[]{1606, 65253, 65254, 65255, 65256}, new char[]{1607, 65257, 65258, 65259, 65260}, new char[]{q, 65261, 65262}, new char[]{r, 65263, 65264, 64488, 64489}, new char[]{s, 65265, 65266, 65267, 65268}, new char[]{1649, 64336, 64337}, new char[]{1657, 64358, 64359, 64360, 64361}, new char[]{1658, 64350, 64351, 64352, 64353}, new char[]{1659, 64338, 64339, 64340, 64341}, new char[]{1662, 64342, 64343, 64344, 64345}, new char[]{1663, 64354, 64355, 64356, 64357}, new char[]{1664, 64346, 64347, 64348, 64349}, new char[]{1667, 64374, 64375, 64376, 64377}, new char[]{1668, 64370, 64371, 64372, 64373}, new char[]{1670, 64378, 64379, 64380, 64381}, new char[]{1671, 64382, 64383, 64384, 64385}, new char[]{1672, 64392, 64393}, new char[]{1676, 64388, 64389}, new char[]{1677, 64386, 64387}, new char[]{1678, 64390, 64391}, new char[]{1681, 64396, 64397}, new char[]{1688, 64394, 64395}, new char[]{1700, 64362, 64363, 64364, 64365}, new char[]{1702, 64366, 64367, 64368, 64369}, new char[]{1705, 64398, 64399, 64400, 64401}, new char[]{1709, 64467, 64468, 64469, 64470}, new char[]{1711, 64402, 64403, 64404, 64405}, new char[]{1713, 64410, 64411, 64412, 64413}, new char[]{1715, 64406, 64407, 64408, 64409}, new char[]{1722, 64414, 64415}, new char[]{1723, 64416, 64417, 64418, 64419}, new char[]{1726, 64426, 64427, 64428, 64429}, new char[]{1728, 64420, 64421}, new char[]{1729, 64422, 64423, 64424, 64425}, new char[]{1733, 64480, 64481}, new char[]{1734, 64473, 64474}, new char[]{1735, 64471, 64472}, new char[]{1736, 64475, 64476}, new char[]{1737, 64482, 64483}, new char[]{1739, 64478, 64479}, new char[]{t, 64508, 64509, 64510, 64511}, new char[]{1744, 64484, 64485, 64486, 64487}, new char[]{1746, 64430, 64431}, new char[]{1747, 64432, 64433}};
        D = cArr;
        for (char[] cArr2 : cArr) {
            f26879c.put(Character.valueOf(cArr2[0]), cArr2);
            int length = cArr2.length;
            if (length != 3) {
                if (length != 5) {
                    c2 = cArr2[0];
                    if (c2 != 1591 || c2 == 1592) {
                        HashMap<Character, Character> hashMap = f26880d;
                        hashMap.put(Character.valueOf(cArr2[4]), Character.valueOf(cArr2[1]));
                        hashMap.put(Character.valueOf(cArr2[3]), Character.valueOf(cArr2[1]));
                    }
                } else {
                    f26880d.put(Character.valueOf(cArr2[4]), Character.valueOf(cArr2[3]));
                }
            }
            f26880d.put(Character.valueOf(cArr2[2]), Character.valueOf(cArr2[1]));
            c2 = cArr2[0];
            if (c2 != 1591) {
            }
            HashMap<Character, Character> hashMap2 = f26880d;
            hashMap2.put(Character.valueOf(cArr2[4]), Character.valueOf(cArr2[1]));
            hashMap2.put(Character.valueOf(cArr2[3]), Character.valueOf(cArr2[1]));
        }
    }

    public ArabicLigaturizer() {
        this.f26891a = 0;
        this.f26892b = 3;
    }

    public static int c(char[] cArr, int i2, int i3, char[] cArr2, int i4, int i5, int i6) {
        char[] cArr3 = new char[i3];
        for (int i7 = (i3 + i2) - 1; i7 >= i2; i7--) {
            cArr3[i7 - i2] = cArr[i7];
        }
        StringBuffer stringBuffer = new StringBuffer(i3);
        l(cArr3, stringBuffer, i6);
        if ((i6 & 12) != 0) {
            g(stringBuffer, i6);
        }
        System.arraycopy(stringBuffer.toString().toCharArray(), 0, cArr2, i4, stringBuffer.length());
        return stringBuffer.length();
    }

    static char d(char c2, int i2) {
        if (c2 < 1569 || c2 > 1747) {
            return (c2 < 65269 || c2 > 65275) ? c2 : (char) (c2 + i2);
        }
        char[] cArr = f26879c.get(Character.valueOf(c2));
        return cArr != null ? cArr[i2 + 1] : c2;
    }

    static boolean e(charstruct charstruct2) {
        return charstruct2.f26897e > 2;
    }

    static void f(StringBuffer stringBuffer, charstruct charstruct2, int i2) {
        int i3;
        char c2 = charstruct2.f26893a;
        if (c2 != 0) {
            stringBuffer.append(c2);
            int i4 = charstruct2.f26896d;
            charstruct2.f26896d = i4 - 1;
            char c3 = charstruct2.f26894b;
            if (c3 != 0) {
                if ((i2 & 1) == 0) {
                    stringBuffer.append(c3);
                    i3 = charstruct2.f26896d - 1;
                } else {
                    i3 = i4 - 2;
                }
                charstruct2.f26896d = i3;
            }
            char c4 = charstruct2.f26895c;
            if (c4 != 0) {
                if ((i2 & 1) == 0) {
                    stringBuffer.append(c4);
                }
                charstruct2.f26896d--;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r6 = 64610;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        r6 = 64609;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void g(java.lang.StringBuffer r10, int r11) {
        /*
            int r0 = r10.length()
            r1 = 0
            r2 = 1
            r3 = r0
            r4 = 0
        L_0x0008:
            if (r2 >= r0) goto L_0x012f
            r5 = r11 & 4
            if (r5 == 0) goto L_0x004c
            char r5 = r10.charAt(r4)
            r6 = 64608(0xfc60, float:9.0535E-41)
            r7 = 64609(0xfc61, float:9.0536E-41)
            r8 = 64610(0xfc62, float:9.0538E-41)
            r9 = 1617(0x651, float:2.266E-42)
            switch(r5) {
                case 1614: goto L_0x0045;
                case 1615: goto L_0x003b;
                case 1616: goto L_0x0031;
                case 1617: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x004c
        L_0x0021:
            char r5 = r10.charAt(r2)
            switch(r5) {
                case 1612: goto L_0x002d;
                case 1613: goto L_0x0029;
                case 1614: goto L_0x004d;
                case 1615: goto L_0x0041;
                case 1616: goto L_0x0037;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x004c
        L_0x0029:
            r6 = 64607(0xfc5f, float:9.0534E-41)
            goto L_0x004d
        L_0x002d:
            r6 = 64606(0xfc5e, float:9.0532E-41)
            goto L_0x004d
        L_0x0031:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x004c
        L_0x0037:
            r6 = 64610(0xfc62, float:9.0538E-41)
            goto L_0x004d
        L_0x003b:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x004c
        L_0x0041:
            r6 = 64609(0xfc61, float:9.0536E-41)
            goto L_0x004d
        L_0x0045:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r6 = 0
        L_0x004d:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x011a
            char r5 = r10.charAt(r4)
            r7 = 65192(0xfea8, float:9.1353E-41)
            r8 = 65188(0xfea4, float:9.1348E-41)
            r9 = 65184(0xfea0, float:9.1342E-41)
            switch(r5) {
                case 65169: goto L_0x0104;
                case 65175: goto L_0x00ed;
                case 65235: goto L_0x00df;
                case 65247: goto L_0x00b5;
                case 65251: goto L_0x0098;
                case 65255: goto L_0x007d;
                case 65256: goto L_0x0063;
                default: goto L_0x0061;
            }
        L_0x0061:
            goto L_0x011a
        L_0x0063:
            char r5 = r10.charAt(r2)
            r7 = 65198(0xfeae, float:9.1362E-41)
            if (r5 == r7) goto L_0x0078
            r7 = 65200(0xfeb0, float:9.1365E-41)
            if (r5 == r7) goto L_0x0073
            goto L_0x011a
        L_0x0073:
            r6 = 64651(0xfc8b, float:9.0595E-41)
            goto L_0x011a
        L_0x0078:
            r6 = 64650(0xfc8a, float:9.0594E-41)
            goto L_0x011a
        L_0x007d:
            char r5 = r10.charAt(r2)
            if (r5 == r9) goto L_0x0093
            if (r5 == r8) goto L_0x008e
            if (r5 == r7) goto L_0x0089
            goto L_0x011a
        L_0x0089:
            r6 = 64724(0xfcd4, float:9.0698E-41)
            goto L_0x011a
        L_0x008e:
            r6 = 64723(0xfcd3, float:9.0696E-41)
            goto L_0x011a
        L_0x0093:
            r6 = 64722(0xfcd2, float:9.0695E-41)
            goto L_0x011a
        L_0x0098:
            char r5 = r10.charAt(r2)
            switch(r5) {
                case 65184: goto L_0x00b0;
                case 65188: goto L_0x00ab;
                case 65192: goto L_0x00a6;
                case 65252: goto L_0x00a1;
                default: goto L_0x009f;
            }
        L_0x009f:
            goto L_0x011a
        L_0x00a1:
            r6 = 64721(0xfcd1, float:9.0693E-41)
            goto L_0x011a
        L_0x00a6:
            r6 = 64720(0xfcd0, float:9.0692E-41)
            goto L_0x011a
        L_0x00ab:
            r6 = 64719(0xfccf, float:9.069E-41)
            goto L_0x011a
        L_0x00b0:
            r6 = 64718(0xfcce, float:9.0689E-41)
            goto L_0x011a
        L_0x00b5:
            char r5 = r10.charAt(r2)
            switch(r5) {
                case 65182: goto L_0x00db;
                case 65184: goto L_0x00d7;
                case 65186: goto L_0x00d3;
                case 65188: goto L_0x00cf;
                case 65190: goto L_0x00cb;
                case 65192: goto L_0x00c7;
                case 65250: goto L_0x00c3;
                case 65252: goto L_0x00be;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            goto L_0x011a
        L_0x00be:
            r6 = 64716(0xfccc, float:9.0686E-41)
            goto L_0x011a
        L_0x00c3:
            r6 = 64578(0xfc42, float:9.0493E-41)
            goto L_0x011a
        L_0x00c7:
            r6 = 64715(0xfccb, float:9.0685E-41)
            goto L_0x011a
        L_0x00cb:
            r6 = 64577(0xfc41, float:9.0492E-41)
            goto L_0x011a
        L_0x00cf:
            r6 = 64714(0xfcca, float:9.0684E-41)
            goto L_0x011a
        L_0x00d3:
            r6 = 64576(0xfc40, float:9.049E-41)
            goto L_0x011a
        L_0x00d7:
            r6 = 64713(0xfcc9, float:9.0682E-41)
            goto L_0x011a
        L_0x00db:
            r6 = 64575(0xfc3f, float:9.0489E-41)
            goto L_0x011a
        L_0x00df:
            char r5 = r10.charAt(r2)
            r7 = 65266(0xfef2, float:9.1457E-41)
            if (r5 == r7) goto L_0x00e9
            goto L_0x011a
        L_0x00e9:
            r6 = 64562(0xfc32, float:9.047E-41)
            goto L_0x011a
        L_0x00ed:
            char r5 = r10.charAt(r2)
            if (r5 == r9) goto L_0x0100
            if (r5 == r8) goto L_0x00fc
            if (r5 == r7) goto L_0x00f8
            goto L_0x011a
        L_0x00f8:
            r6 = 64675(0xfca3, float:9.0629E-41)
            goto L_0x011a
        L_0x00fc:
            r6 = 64674(0xfca2, float:9.0628E-41)
            goto L_0x011a
        L_0x0100:
            r6 = 64673(0xfca1, float:9.0626E-41)
            goto L_0x011a
        L_0x0104:
            char r5 = r10.charAt(r2)
            if (r5 == r9) goto L_0x0117
            if (r5 == r8) goto L_0x0113
            if (r5 == r7) goto L_0x010f
            goto L_0x011a
        L_0x010f:
            r6 = 64670(0xfc9e, float:9.0622E-41)
            goto L_0x011a
        L_0x0113:
            r6 = 64669(0xfc9d, float:9.062E-41)
            goto L_0x011a
        L_0x0117:
            r6 = 64668(0xfc9c, float:9.0619E-41)
        L_0x011a:
            if (r6 == 0) goto L_0x0125
            r10.setCharAt(r4, r6)
            int r3 = r3 + -1
        L_0x0121:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x0125:
            int r4 = r4 + 1
            char r5 = r10.charAt(r2)
            r10.setCharAt(r4, r5)
            goto L_0x0121
        L_0x012f:
            r10.setLength(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.languages.ArabicLigaturizer.g(java.lang.StringBuffer, int):void");
    }

    public static Character h(char c2) {
        return f26880d.get(Character.valueOf(c2));
    }

    static boolean i(char c2) {
        return (c2 >= 1611 && c2 <= 1621) || c2 == 1648;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        r13.f26894b = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006d, code lost:
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006e, code lost:
        if (r10 != 1) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0070, code lost:
        r13.f26896d++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0075, code lost:
        return r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int j(char r12, com.itextpdf.text.pdf.languages.ArabicLigaturizer.charstruct r13) {
        /*
            char r0 = r13.f26893a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = i(r12)
            r2 = 1570(0x622, float:2.2E-42)
            r3 = 1571(0x623, float:2.201E-42)
            r4 = 65271(0xfef7, float:9.1464E-41)
            r5 = 1573(0x625, float:2.204E-42)
            r6 = 65273(0xfef9, float:9.1467E-41)
            r7 = 65275(0xfefb, float:9.147E-41)
            r8 = 1575(0x627, float:2.207E-42)
            r9 = 1
            r10 = 2
            if (r0 == 0) goto L_0x0077
            char r0 = r13.f26895c
            r11 = 1617(0x651, float:2.266E-42)
            if (r0 == 0) goto L_0x0029
            if (r12 == r11) goto L_0x0029
            r0 = 2
            goto L_0x002a
        L_0x0029:
            r0 = 1
        L_0x002a:
            switch(r12) {
                case 1617: goto L_0x0067;
                case 1618: goto L_0x002d;
                case 1619: goto L_0x005f;
                case 1620: goto L_0x0041;
                case 1621: goto L_0x0030;
                default: goto L_0x002d;
            }
        L_0x002d:
            r13.f26895c = r12
            goto L_0x006d
        L_0x0030:
            char r12 = r13.f26893a
            if (r12 == r8) goto L_0x003e
            if (r12 == r7) goto L_0x003b
            r12 = 1621(0x655, float:2.272E-42)
        L_0x0038:
            r13.f26894b = r12
            goto L_0x006d
        L_0x003b:
            r13.f26893a = r6
            goto L_0x006e
        L_0x003e:
            r13.f26893a = r5
            goto L_0x006e
        L_0x0041:
            char r12 = r13.f26893a
            if (r12 == r8) goto L_0x005c
            r1 = 1740(0x6cc, float:2.438E-42)
            if (r12 == r1) goto L_0x0059
            if (r12 == r7) goto L_0x0056
            switch(r12) {
                case 1608: goto L_0x0051;
                case 1609: goto L_0x0059;
                case 1610: goto L_0x0059;
                default: goto L_0x004e;
            }
        L_0x004e:
            r12 = 1620(0x654, float:2.27E-42)
            goto L_0x0038
        L_0x0051:
            r12 = 1572(0x624, float:2.203E-42)
        L_0x0053:
            r13.f26893a = r12
            goto L_0x006e
        L_0x0056:
            r13.f26893a = r4
            goto L_0x006e
        L_0x0059:
            r12 = 1574(0x626, float:2.206E-42)
            goto L_0x0053
        L_0x005c:
            r13.f26893a = r3
            goto L_0x006e
        L_0x005f:
            char r12 = r13.f26893a
            if (r12 == r8) goto L_0x0064
            goto L_0x006d
        L_0x0064:
            r13.f26893a = r2
            goto L_0x006e
        L_0x0067:
            char r12 = r13.f26894b
            if (r12 != 0) goto L_0x0076
            r13.f26894b = r11
        L_0x006d:
            r10 = r0
        L_0x006e:
            if (r10 != r9) goto L_0x0075
            int r12 = r13.f26896d
            int r12 = r12 + r9
            r13.f26896d = r12
        L_0x0075:
            return r10
        L_0x0076:
            return r1
        L_0x0077:
            char r0 = r13.f26895c
            if (r0 == 0) goto L_0x007c
            return r1
        L_0x007c:
            char r0 = r13.f26893a
            if (r0 == 0) goto L_0x00a1
            r9 = 1604(0x644, float:2.248E-42)
            if (r0 == r9) goto L_0x0085
            goto L_0x00aa
        L_0x0085:
            r0 = 3
            if (r12 == r2) goto L_0x009b
            if (r12 == r3) goto L_0x0098
            if (r12 == r5) goto L_0x0095
            if (r12 == r8) goto L_0x008f
            goto L_0x00aa
        L_0x008f:
            r13.f26893a = r7
        L_0x0091:
            r13.f26897e = r10
            r1 = 3
            goto L_0x00aa
        L_0x0095:
            r13.f26893a = r6
            goto L_0x0091
        L_0x0098:
            r13.f26893a = r4
            goto L_0x0091
        L_0x009b:
            r12 = 65269(0xfef5, float:9.1461E-41)
            r13.f26893a = r12
            goto L_0x0091
        L_0x00a1:
            r13.f26893a = r12
            int r12 = n(r12)
            r13.f26897e = r12
            r1 = 1
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.languages.ArabicLigaturizer.j(char, com.itextpdf.text.pdf.languages.ArabicLigaturizer$charstruct):int");
    }

    public static void k(char[] cArr, int i2, int i3, int i4) {
        int i5 = i2 + i3;
        int i6 = i4 & 224;
        if (i6 != 0) {
            int i7 = i4 & 256;
            char c2 = i7 != 0 ? i7 != 256 ? '0' : 1776 : 1632;
            if (i6 == 32) {
                int i8 = c2 - '0';
                while (i2 < i5) {
                    char c3 = cArr[i2];
                    if (c3 <= '9' && c3 >= '0') {
                        cArr[i2] = (char) (c3 + i8);
                    }
                    i2++;
                }
            } else if (i6 == 64) {
                char c4 = (char) (c2 + 9);
                int i9 = '0' - c2;
                while (i2 < i5) {
                    char c5 = cArr[i2];
                    if (c5 <= c4 && c5 >= c2) {
                        cArr[i2] = (char) (c5 + i9);
                    }
                    i2++;
                }
            } else if (i6 == 96) {
                m(cArr, 0, i3, c2, false);
            } else if (i6 == 128) {
                m(cArr, 0, i3, c2, true);
            }
        }
    }

    static void l(char[] cArr, StringBuffer stringBuffer, int i2) {
        charstruct charstruct2 = new charstruct();
        charstruct charstruct3 = new charstruct();
        int i3 = 0;
        while (i3 < cArr.length) {
            int i4 = i3 + 1;
            char c2 = cArr[i3];
            if (j(c2, charstruct3) == 0) {
                int n2 = n(c2);
                int i5 = n2 == 1 ? 0 : 2;
                if (e(charstruct2)) {
                    i5++;
                }
                charstruct3.f26893a = d(charstruct3.f26893a, i5 % charstruct3.f26897e);
                f(stringBuffer, charstruct2, i2);
                charstruct charstruct4 = new charstruct();
                charstruct4.f26893a = c2;
                charstruct4.f26897e = n2;
                charstruct4.f26896d++;
                i3 = i4;
                charstruct charstruct5 = charstruct3;
                charstruct3 = charstruct4;
                charstruct2 = charstruct5;
            } else {
                i3 = i4;
            }
        }
        charstruct3.f26893a = d(charstruct3.f26893a, (e(charstruct2) ? 1 : 0) % charstruct3.f26897e);
        f(stringBuffer, charstruct2, i2);
        f(stringBuffer, charstruct3, i2);
    }

    static void m(char[] cArr, int i2, int i3, char c2, boolean z2) {
        char c3 = (char) (c2 - '0');
        int i4 = i3 + i2;
        while (i2 < i4) {
            char c4 = cArr[i2];
            byte h2 = BidiOrder.h(c4);
            if (h2 != 0) {
                if (h2 != 8) {
                    if (h2 != 3) {
                        if (h2 == 4) {
                            z2 = true;
                        }
                    }
                } else if (z2 && c4 <= '9') {
                    cArr[i2] = (char) (c4 + c3);
                }
                i2++;
            }
            z2 = false;
            i2++;
        }
    }

    static int n(char c2) {
        if (c2 >= 1569 && c2 <= 1747 && !i(c2)) {
            char[] cArr = f26879c.get(Character.valueOf(c2));
            if (cArr != null) {
                return cArr.length - 1;
            }
        } else if (c2 == 8205) {
            return 4;
        }
        return 1;
    }

    public boolean a() {
        return true;
    }

    public String b(String str) {
        return BidiLine.q(str, this.f26892b, this.f26891a);
    }

    public ArabicLigaturizer(int i2, int i3) {
        this.f26892b = i2;
        this.f26891a = i3;
    }
}
