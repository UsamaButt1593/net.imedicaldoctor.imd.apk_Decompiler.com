package org.apache.commons.lang3.math;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;

public class NumberUtils {
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_ZERO = 0;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_ZERO = 0L;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_ZERO = 0;

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        } else if (!str.trim().startsWith("--")) {
            return new BigDecimal(str);
        } else {
            throw new NumberFormatException(str + " is not a valid number.");
        }
    }

    public static BigInteger createBigInteger(String str) {
        int i2;
        int i3;
        if (str == null) {
            return null;
        }
        boolean startsWith = str.startsWith("-");
        int i4 = 16;
        if (str.startsWith("0x", startsWith ? 1 : 0) || str.startsWith("0x", startsWith)) {
            i2 = startsWith + true;
        } else if (str.startsWith("#", startsWith)) {
            i2 = startsWith + true;
        } else if (!str.startsWith("0", startsWith) || str.length() <= (i3 = startsWith + true)) {
            i4 = 10;
            i2 = startsWith;
        } else {
            i4 = 8;
            i2 = i3;
        }
        BigInteger bigInteger = new BigInteger(str.substring(i2), i4);
        return startsWith ? bigInteger.negate() : bigInteger;
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:(1:61)|62|(1:67)(1:66)|68|(5:70|(3:72|(2:74|(2:76|(1:78)))|(2:94|95)(3:88|89|90))|96|97|(1:103))|104|105|(1:111)|112|113|114) */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01bd, code lost:
        throw new java.lang.NumberFormatException(r0 + " is not a valid number.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01de, code lost:
        return createLong(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01e3, code lost:
        return createBigInteger(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013c, code lost:
        if (r2 == 'l') goto L_0x013e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:104:0x018e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:112:0x01a4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:127:0x01da */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Number createNumber(java.lang.String r18) throws java.lang.NumberFormatException {
        /*
            r0 = r18
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r2 = org.apache.commons.lang3.StringUtils.isBlank(r18)
            if (r2 != 0) goto L_0x0226
            java.lang.String r7 = "#"
            java.lang.String r8 = "-#"
            java.lang.String r3 = "0x"
            java.lang.String r4 = "0X"
            java.lang.String r5 = "-0x"
            java.lang.String r6 = "-0X"
            java.lang.String[] r2 = new java.lang.String[]{r3, r4, r5, r6, r7, r8}
            r3 = 0
            r4 = 0
        L_0x001e:
            r5 = 6
            if (r4 >= r5) goto L_0x0031
            r5 = r2[r4]
            boolean r6 = r0.startsWith(r5)
            if (r6 == 0) goto L_0x002e
            int r2 = r5.length()
            goto L_0x0032
        L_0x002e:
            int r4 = r4 + 1
            goto L_0x001e
        L_0x0031:
            r2 = 0
        L_0x0032:
            r4 = 16
            if (r2 <= 0) goto L_0x0070
            r1 = r2
        L_0x0037:
            int r5 = r18.length()
            if (r2 >= r5) goto L_0x004a
            char r3 = r0.charAt(r2)
            r5 = 48
            if (r3 != r5) goto L_0x004a
            int r1 = r1 + 1
            int r2 = r2 + 1
            goto L_0x0037
        L_0x004a:
            int r2 = r18.length()
            int r2 = r2 - r1
            if (r2 > r4) goto L_0x006b
            r1 = 55
            if (r2 != r4) goto L_0x0058
            if (r3 <= r1) goto L_0x0058
            goto L_0x006b
        L_0x0058:
            r4 = 8
            if (r2 > r4) goto L_0x0066
            if (r2 != r4) goto L_0x0061
            if (r3 <= r1) goto L_0x0061
            goto L_0x0066
        L_0x0061:
            java.lang.Integer r0 = createInteger(r18)
            return r0
        L_0x0066:
            java.lang.Long r0 = createLong(r18)
            return r0
        L_0x006b:
            java.math.BigInteger r0 = createBigInteger(r18)
            return r0
        L_0x0070:
            int r2 = r18.length()
            r5 = 1
            int r2 = r2 - r5
            char r2 = r0.charAt(r2)
            r6 = 46
            int r7 = r0.indexOf(r6)
            r8 = 101(0x65, float:1.42E-43)
            int r8 = r0.indexOf(r8)
            r9 = 69
            int r9 = r0.indexOf(r9)
            int r8 = r8 + r9
            int r9 = r8 + 1
            java.lang.String r10 = " is not a valid number."
            r11 = -1
            if (r7 <= r11) goto L_0x00c9
            if (r9 <= r11) goto L_0x00ba
            if (r9 < r7) goto L_0x00a5
            int r12 = r18.length()
            if (r9 > r12) goto L_0x00a5
            int r12 = r7 + 1
            java.lang.String r12 = r0.substring(r12, r9)
            goto L_0x00c0
        L_0x00a5:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00ba:
            int r12 = r7 + 1
            java.lang.String r12 = r0.substring(r12)
        L_0x00c0:
            java.lang.String r7 = r0.substring(r3, r7)
            int r13 = r12.length()
            goto L_0x00ee
        L_0x00c9:
            if (r9 <= r11) goto L_0x00eb
            int r7 = r18.length()
            if (r9 > r7) goto L_0x00d6
            java.lang.String r7 = r0.substring(r3, r9)
            goto L_0x00ec
        L_0x00d6:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00eb:
            r7 = r0
        L_0x00ec:
            r12 = r1
            r13 = 0
        L_0x00ee:
            boolean r14 = java.lang.Character.isDigit(r2)
            r15 = 0
            r17 = 0
            if (r14 != 0) goto L_0x01be
            if (r2 == r6) goto L_0x01be
            if (r9 <= r11) goto L_0x010e
            int r4 = r18.length()
            int r4 = r4 - r5
            if (r9 >= r4) goto L_0x010e
            int r8 = r8 + 2
            int r1 = r18.length()
            int r1 = r1 - r5
            java.lang.String r1 = r0.substring(r8, r1)
        L_0x010e:
            int r4 = r18.length()
            int r4 = r4 - r5
            java.lang.String r4 = r0.substring(r3, r4)
            boolean r6 = isAllZeros(r7)
            if (r6 == 0) goto L_0x0125
            boolean r6 = isAllZeros(r1)
            if (r6 == 0) goto L_0x0125
            r6 = 1
            goto L_0x0126
        L_0x0125:
            r6 = 0
        L_0x0126:
            r7 = 68
            if (r2 == r7) goto L_0x018e
            r7 = 70
            if (r2 == r7) goto L_0x0179
            r7 = 76
            if (r2 == r7) goto L_0x013e
            r7 = 100
            if (r2 == r7) goto L_0x018e
            r7 = 102(0x66, float:1.43E-43)
            if (r2 == r7) goto L_0x0179
            r6 = 108(0x6c, float:1.51E-43)
            if (r2 != r6) goto L_0x01a9
        L_0x013e:
            if (r12 != 0) goto L_0x0164
            if (r1 != 0) goto L_0x0164
            char r1 = r4.charAt(r3)
            r2 = 45
            if (r1 != r2) goto L_0x0154
            java.lang.String r1 = r4.substring(r5)
            boolean r1 = isDigits(r1)
            if (r1 != 0) goto L_0x015a
        L_0x0154:
            boolean r1 = isDigits(r4)
            if (r1 == 0) goto L_0x0164
        L_0x015a:
            java.lang.Long r0 = createLong(r4)     // Catch:{ NumberFormatException -> 0x015f }
            return r0
        L_0x015f:
            java.math.BigInteger r0 = createBigInteger(r4)
            return r0
        L_0x0164:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0179:
            java.lang.Float r1 = createFloat(r4)     // Catch:{ NumberFormatException -> 0x018e }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x018e }
            if (r2 != 0) goto L_0x018e
            float r2 = r1.floatValue()     // Catch:{ NumberFormatException -> 0x018e }
            int r2 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r2 != 0) goto L_0x018d
            if (r6 == 0) goto L_0x018e
        L_0x018d:
            return r1
        L_0x018e:
            java.lang.Double r1 = createDouble(r4)     // Catch:{ NumberFormatException -> 0x01a4 }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x01a4 }
            if (r2 != 0) goto L_0x01a4
            float r2 = r1.floatValue()     // Catch:{ NumberFormatException -> 0x01a4 }
            double r2 = (double) r2
            int r5 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r5 != 0) goto L_0x01a3
            if (r6 == 0) goto L_0x01a4
        L_0x01a3:
            return r1
        L_0x01a4:
            java.math.BigDecimal r0 = createBigDecimal(r4)     // Catch:{ NumberFormatException -> 0x01a9 }
            return r0
        L_0x01a9:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01be:
            if (r9 <= r11) goto L_0x01d1
            int r2 = r18.length()
            int r2 = r2 - r5
            if (r9 >= r2) goto L_0x01d1
            int r8 = r8 + 2
            int r1 = r18.length()
            java.lang.String r1 = r0.substring(r8, r1)
        L_0x01d1:
            if (r12 != 0) goto L_0x01e4
            if (r1 != 0) goto L_0x01e4
            java.lang.Integer r0 = createInteger(r18)     // Catch:{ NumberFormatException -> 0x01da }
            return r0
        L_0x01da:
            java.lang.Long r0 = createLong(r18)     // Catch:{ NumberFormatException -> 0x01df }
            return r0
        L_0x01df:
            java.math.BigInteger r0 = createBigInteger(r18)
            return r0
        L_0x01e4:
            boolean r2 = isAllZeros(r7)
            if (r2 == 0) goto L_0x01f1
            boolean r1 = isAllZeros(r1)
            if (r1 == 0) goto L_0x01f1
            r3 = 1
        L_0x01f1:
            r1 = 7
            if (r13 > r1) goto L_0x020a
            java.lang.Float r1 = createFloat(r18)     // Catch:{ NumberFormatException -> 0x0209 }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x0209 }
            if (r2 != 0) goto L_0x020a
            float r2 = r1.floatValue()     // Catch:{ NumberFormatException -> 0x0209 }
            int r2 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r2 != 0) goto L_0x0208
            if (r3 == 0) goto L_0x020a
        L_0x0208:
            return r1
        L_0x0209:
        L_0x020a:
            if (r13 > r4) goto L_0x0221
            java.lang.Double r1 = createDouble(r18)     // Catch:{ NumberFormatException -> 0x0221 }
            boolean r2 = r1.isInfinite()     // Catch:{ NumberFormatException -> 0x0221 }
            if (r2 != 0) goto L_0x0221
            double r4 = r1.doubleValue()     // Catch:{ NumberFormatException -> 0x0221 }
            int r2 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x0220
            if (r3 == 0) goto L_0x0221
        L_0x0220:
            return r1
        L_0x0221:
            java.math.BigDecimal r0 = createBigDecimal(r18)
            return r0
        L_0x0226:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "A blank string is not a valid number"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createNumber(java.lang.String):java.lang.Number");
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return str.length() > 0;
    }

    public static boolean isDigits(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z = true;
        int i2 = charArray[0] == '-' ? 1 : 0;
        int i3 = i2 + 1;
        if (length > i3 && charArray[i2] == '0') {
            char c2 = charArray[i3];
            if (c2 == 'x' || c2 == 'X') {
                int i4 = i2 + 2;
                if (i4 == length) {
                    return false;
                }
                while (i4 < charArray.length) {
                    char c3 = charArray[i4];
                    if ((c3 < '0' || c3 > '9') && ((c3 < 'a' || c3 > 'f') && (c3 < 'A' || c3 > 'F'))) {
                        return false;
                    }
                    i4++;
                }
                return true;
            } else if (Character.isDigit(c2)) {
                while (i3 < charArray.length) {
                    char c4 = charArray[i3];
                    if (c4 < '0' || c4 > '7') {
                        return false;
                    }
                    i3++;
                }
                return true;
            }
        }
        int i5 = length - 1;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            if (i2 < i5 || (i2 < length && z2 && !z3)) {
                char c5 = charArray[i2];
                if (c5 >= '0' && c5 <= '9') {
                    z2 = false;
                    z3 = true;
                } else if (c5 == '.') {
                    if (z5 || z4) {
                        return false;
                    }
                    z5 = true;
                } else if (c5 != 'e' && c5 != 'E') {
                    if (c5 != '+') {
                        if (c5 != '-') {
                            return false;
                        }
                    }
                    if (!z2) {
                        return false;
                    }
                    z2 = false;
                    z3 = false;
                } else if (z4 || !z3) {
                    return false;
                } else {
                    z2 = true;
                    z4 = true;
                }
                i2++;
                z = true;
            }
        }
        if (i2 >= charArray.length) {
            return !z2 && z3;
        }
        char c6 = charArray[i2];
        if (c6 >= '0' && c6 <= '9') {
            return z;
        }
        if (c6 == 'e' || c6 == 'E') {
            return false;
        }
        if (c6 != '.') {
            return (z2 || !(c6 == 'd' || c6 == 'D' || c6 == 'f' || c6 == 'F')) ? (c6 == 'l' || c6 == 'L') && z3 && !z4 && !z5 : z3;
        }
        if (z5 || z4) {
            return false;
        }
        return z3;
    }

    public static byte max(byte b2, byte b3, byte b4) {
        if (b3 > b2) {
            b2 = b3;
        }
        return b4 > b2 ? b4 : b2;
    }

    public static byte min(byte b2, byte b3, byte b4) {
        if (b3 < b2) {
            b2 = b3;
        }
        return b4 < b2 ? b4 : b2;
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static long toLong(String str) {
        return toLong(str, 0);
    }

    public static short toShort(String str) {
        return toShort(str, 0);
    }

    private static void validateArray(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (Array.getLength(obj) == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static byte max(byte[] bArr) {
        validateArray(bArr);
        byte b2 = bArr[0];
        for (int i2 = 1; i2 < bArr.length; i2++) {
            byte b3 = bArr[i2];
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    public static byte min(byte[] bArr) {
        validateArray(bArr);
        byte b2 = bArr[0];
        for (int i2 = 1; i2 < bArr.length; i2++) {
            byte b3 = bArr[i2];
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    public static byte toByte(String str, byte b2) {
        if (str == null) {
            return b2;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b2;
        }
    }

    public static double toDouble(String str, double d2) {
        if (str == null) {
            return d2;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d2;
        }
    }

    public static float toFloat(String str, float f2) {
        if (str == null) {
            return f2;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f2;
        }
    }

    public static int toInt(String str, int i2) {
        if (str == null) {
            return i2;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static long toLong(String str, long j2) {
        if (str == null) {
            return j2;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j2;
        }
    }

    public static short toShort(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    public static double max(double d2, double d3, double d4) {
        return Math.max(Math.max(d2, d3), d4);
    }

    public static double min(double d2, double d3, double d4) {
        return Math.min(Math.min(d2, d3), d4);
    }

    public static double max(double[] dArr) {
        validateArray(dArr);
        double d2 = dArr[0];
        for (int i2 = 1; i2 < dArr.length; i2++) {
            if (Double.isNaN(dArr[i2])) {
                return Double.NaN;
            }
            double d3 = dArr[i2];
            if (d3 > d2) {
                d2 = d3;
            }
        }
        return d2;
    }

    public static double min(double[] dArr) {
        validateArray(dArr);
        double d2 = dArr[0];
        for (int i2 = 1; i2 < dArr.length; i2++) {
            if (Double.isNaN(dArr[i2])) {
                return Double.NaN;
            }
            double d3 = dArr[i2];
            if (d3 < d2) {
                d2 = d3;
            }
        }
        return d2;
    }

    public static float max(float f2, float f3, float f4) {
        return Math.max(Math.max(f2, f3), f4);
    }

    public static float min(float f2, float f3, float f4) {
        return Math.min(Math.min(f2, f3), f4);
    }

    public static float max(float[] fArr) {
        validateArray(fArr);
        float f2 = fArr[0];
        for (int i2 = 1; i2 < fArr.length; i2++) {
            if (Float.isNaN(fArr[i2])) {
                return Float.NaN;
            }
            float f3 = fArr[i2];
            if (f3 > f2) {
                f2 = f3;
            }
        }
        return f2;
    }

    public static float min(float[] fArr) {
        validateArray(fArr);
        float f2 = fArr[0];
        for (int i2 = 1; i2 < fArr.length; i2++) {
            if (Float.isNaN(fArr[i2])) {
                return Float.NaN;
            }
            float f3 = fArr[i2];
            if (f3 < f2) {
                f2 = f3;
            }
        }
        return f2;
    }

    public static int max(int i2, int i3, int i4) {
        if (i3 > i2) {
            i2 = i3;
        }
        return i4 > i2 ? i4 : i2;
    }

    public static int min(int i2, int i3, int i4) {
        if (i3 < i2) {
            i2 = i3;
        }
        return i4 < i2 ? i4 : i2;
    }

    public static int max(int[] iArr) {
        validateArray(iArr);
        int i2 = iArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i4 > i2) {
                i2 = i4;
            }
        }
        return i2;
    }

    public static int min(int[] iArr) {
        validateArray(iArr);
        int i2 = iArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i4 < i2) {
                i2 = i4;
            }
        }
        return i2;
    }

    public static long max(long j2, long j3, long j4) {
        if (j3 > j2) {
            j2 = j3;
        }
        return j4 > j2 ? j4 : j2;
    }

    public static long min(long j2, long j3, long j4) {
        if (j3 < j2) {
            j2 = j3;
        }
        return j4 < j2 ? j4 : j2;
    }

    public static long max(long[] jArr) {
        validateArray(jArr);
        long j2 = jArr[0];
        for (int i2 = 1; i2 < jArr.length; i2++) {
            long j3 = jArr[i2];
            if (j3 > j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    public static long min(long[] jArr) {
        validateArray(jArr);
        long j2 = jArr[0];
        for (int i2 = 1; i2 < jArr.length; i2++) {
            long j3 = jArr[i2];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    public static short max(short[] sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i2 = 1; i2 < sArr.length; i2++) {
            short s2 = sArr[i2];
            if (s2 > s) {
                s = s2;
            }
        }
        return s;
    }

    public static short min(short[] sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i2 = 1; i2 < sArr.length; i2++) {
            short s2 = sArr[i2];
            if (s2 < s) {
                s = s2;
            }
        }
        return s;
    }
}
