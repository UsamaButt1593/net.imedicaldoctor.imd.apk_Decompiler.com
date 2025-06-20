package com.dd.plist;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

public class BinaryPropertyListParser {

    /* renamed from: a  reason: collision with root package name */
    private int f18673a;

    /* renamed from: b  reason: collision with root package name */
    private int f18674b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f18675c;

    /* renamed from: d  reason: collision with root package name */
    private int f18676d;

    /* renamed from: e  reason: collision with root package name */
    private int f18677e;

    /* renamed from: f  reason: collision with root package name */
    private int f18678f;

    /* renamed from: g  reason: collision with root package name */
    private int f18679g;

    /* renamed from: h  reason: collision with root package name */
    private int f18680h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f18681i;

    protected BinaryPropertyListParser() {
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        if (i4 >= 0) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i2, bArr2, 0, i4);
            return bArr2;
        }
        throw new IllegalArgumentException("startIndex (" + i2 + ")" + " > endIndex (" + i3 + ")");
    }

    private NSObject b(byte[] bArr) throws Exception {
        this.f18675c = bArr;
        int i2 = 0;
        String str = new String(a(bArr, 0, 8));
        if (str.startsWith("bplist")) {
            this.f18673a = str.charAt(6) - '0';
            this.f18674b = str.charAt(7) - '0';
            if (this.f18673a <= 0) {
                byte[] bArr2 = this.f18675c;
                byte[] a2 = a(bArr2, bArr2.length - 32, bArr2.length);
                this.f18676d = (int) i(a(a2, 6, 7));
                this.f18677e = (int) i(a(a2, 7, 8));
                this.f18678f = (int) i(a(a2, 8, 16));
                this.f18679g = (int) i(a(a2, 16, 24));
                this.f18680h = (int) i(a(a2, 24, 32));
                this.f18681i = new int[this.f18678f];
                while (i2 < this.f18678f) {
                    byte[] bArr3 = this.f18675c;
                    int i3 = this.f18680h;
                    int i4 = this.f18676d;
                    int i5 = i2 + 1;
                    this.f18681i[i2] = (int) i(a(bArr3, (i2 * i4) + i3, i3 + (i4 * i5)));
                    i2 = i5;
                }
                return h(this.f18679g);
            }
            throw new Exception("Unsupported binary property list format: v" + this.f18673a + "." + this.f18674b + ". " + "Version 1.0 and later are not yet supported.");
        }
        throw new Exception("The given data is no binary property list. Wrong magic bytes: " + str);
    }

    public static NSObject c(File file) throws Exception {
        if (file.length() <= Runtime.getRuntime().freeMemory()) {
            return d(new FileInputStream(file));
        }
        throw new Exception("To little heap space available! Wanted to read " + file.length() + " bytes, but only " + Runtime.getRuntime().freeMemory() + " are available.");
    }

    public static NSObject d(InputStream inputStream) throws Exception {
        byte[] i2 = PropertyListParser.i(inputStream, Integer.MAX_VALUE);
        inputStream.close();
        return e(i2);
    }

    public static NSObject e(byte[] bArr) throws Exception {
        return new BinaryPropertyListParser().b(bArr);
    }

    public static final double f(byte[] bArr) {
        if (bArr.length == 8) {
            return Double.longBitsToDouble(g(bArr));
        }
        if (bArr.length == 4) {
            return (double) Float.intBitsToFloat((int) g(bArr));
        }
        throw new IllegalArgumentException("bad byte array length " + bArr.length);
    }

    public static final long g(byte[] bArr) {
        long j2 = 0;
        for (byte b2 : bArr) {
            j2 = (j2 << 8) | ((long) (b2 & 255));
        }
        return j2;
    }

    private NSObject h(int i2) throws Exception {
        int i3 = this.f18681i[i2];
        byte b2 = this.f18675c[i3];
        int i4 = (b2 & 240) >> 4;
        byte b3 = b2 & 15;
        int i5 = 0;
        switch (i4) {
            case 0:
                if (b3 == 8) {
                    return new NSNumber(false);
                }
                if (b3 != 9) {
                    return null;
                }
                return new NSNumber(true);
            case 1:
                int pow = (int) Math.pow(2.0d, (double) b3);
                if (((long) pow) < Runtime.getRuntime().freeMemory()) {
                    int i6 = i3 + 1;
                    return new NSNumber(a(this.f18675c, i6, pow + i6), 0);
                }
                throw new Exception("To little heap space available! Wanted to read " + pow + " bytes, but only " + Runtime.getRuntime().freeMemory() + " are available.");
            case 2:
                int pow2 = (int) Math.pow(2.0d, (double) b3);
                if (((long) pow2) < Runtime.getRuntime().freeMemory()) {
                    int i7 = i3 + 1;
                    return new NSNumber(a(this.f18675c, i7, pow2 + i7), 1);
                }
                throw new Exception("To little heap space available! Wanted to read " + pow2 + " bytes, but only " + Runtime.getRuntime().freeMemory() + " are available.");
            case 3:
                if (b3 != 3) {
                    PrintStream printStream = System.err;
                    printStream.println("BinaryPropertyListParser: Unknown date type :" + b3 + ". Attempting to parse anyway...");
                }
                return new NSDate(a(this.f18675c, i3 + 1, i3 + 9));
            case 4:
                int[] j2 = j(b3, i3);
                int i8 = j2[0];
                int i9 = j2[1];
                if (((long) i8) < Runtime.getRuntime().freeMemory()) {
                    int i10 = i3 + i9;
                    return new NSData(a(this.f18675c, i10, i8 + i10));
                }
                throw new Exception("To little heap space available! Wanted to read " + i8 + " bytes, but only " + Runtime.getRuntime().freeMemory() + " are available.");
            case 5:
                int[] j3 = j(b3, i3);
                int i11 = j3[0];
                int i12 = j3[1];
                if (((long) i11) < Runtime.getRuntime().freeMemory()) {
                    int i13 = i3 + i12;
                    return new NSString(a(this.f18675c, i13, i11 + i13), NTLM.DEFAULT_CHARSET);
                }
                throw new Exception("To little heap space available! Wanted to read " + i11 + " bytes, but only " + Runtime.getRuntime().freeMemory() + " are available.");
            case 6:
                int[] j4 = j(b3, i3);
                int i14 = j4[0];
                int i15 = j4[1];
                int i16 = i14 * 2;
                if (((long) i16) < Runtime.getRuntime().freeMemory()) {
                    int i17 = i3 + i15;
                    return new NSString(a(this.f18675c, i17, i16 + i17), "UTF-16BE");
                }
                throw new Exception("To little heap space available! Wanted to read " + i16 + " bytes, but only " + Runtime.getRuntime().freeMemory() + " are available.");
            case 8:
                int i18 = b3 + 1;
                if (((long) i18) < Runtime.getRuntime().freeMemory()) {
                    int i19 = i3 + 1;
                    return new UID(String.valueOf(i2), a(this.f18675c, i19, i18 + i19));
                }
                throw new Exception("To little heap space available! Wanted to read " + i18 + " bytes, but only " + Runtime.getRuntime().freeMemory() + " are available.");
            case 10:
                int[] j5 = j(b3, i3);
                int i20 = j5[0];
                int i21 = j5[1];
                if (((long) (this.f18677e * i20)) <= Runtime.getRuntime().freeMemory()) {
                    NSArray nSArray = new NSArray(i20);
                    while (i5 < i20) {
                        byte[] bArr = this.f18675c;
                        int i22 = i3 + i21;
                        int i23 = this.f18677e;
                        int i24 = i5 + 1;
                        nSArray.I(i5, h((int) i(a(bArr, (i5 * i23) + i22, i22 + (i23 * i24)))));
                        i5 = i24;
                    }
                    return nSArray;
                }
                throw new Exception("To little heap space available!");
            case 11:
                int[] j6 = j(b3, i3);
                int i25 = j6[0];
                int i26 = j6[1];
                if (((long) (this.f18677e * i25)) <= Runtime.getRuntime().freeMemory()) {
                    NSSet nSSet = new NSSet(true);
                    while (i5 < i25) {
                        byte[] bArr2 = this.f18675c;
                        int i27 = i3 + i26;
                        int i28 = this.f18677e;
                        i5++;
                        nSSet.y(h((int) i(a(bArr2, (i5 * i28) + i27, i27 + (i28 * i5)))));
                    }
                    return nSSet;
                }
                throw new Exception("To little heap space available!");
            case 12:
                int[] j7 = j(b3, i3);
                int i29 = j7[0];
                int i30 = j7[1];
                if (((long) (this.f18677e * i29)) <= Runtime.getRuntime().freeMemory()) {
                    NSSet nSSet2 = new NSSet();
                    while (i5 < i29) {
                        byte[] bArr3 = this.f18675c;
                        int i31 = i3 + i30;
                        int i32 = this.f18677e;
                        i5++;
                        nSSet2.y(h((int) i(a(bArr3, (i5 * i32) + i31, i31 + (i32 * i5)))));
                    }
                    return nSSet2;
                }
                throw new Exception("To little heap space available!");
            case 13:
                int[] j8 = j(b3, i3);
                int i33 = j8[0];
                int i34 = j8[1];
                if (((long) (i33 * 2 * this.f18677e)) <= Runtime.getRuntime().freeMemory()) {
                    NSDictionary nSDictionary = new NSDictionary();
                    while (i5 < i33) {
                        byte[] bArr4 = this.f18675c;
                        int i35 = i3 + i34;
                        int i36 = this.f18677e;
                        int i37 = i5 + 1;
                        int i38 = (int) i(a(bArr4, (i5 * i36) + i35, (i36 * i37) + i35));
                        byte[] bArr5 = this.f18675c;
                        int i39 = this.f18677e;
                        NSObject h2 = h(i38);
                        nSDictionary.put(h2.toString(), h((int) i(a(bArr5, (i33 * i39) + i35 + (i5 * i39), i35 + (i33 * i39) + (i39 * i37)))));
                        i5 = i37;
                    }
                    return nSDictionary;
                }
                throw new Exception("To little heap space available!");
            default:
                PrintStream printStream2 = System.err;
                printStream2.println("Unknown object type: " + i4);
                return null;
        }
    }

    public static final long i(byte[] bArr) {
        long j2 = 0;
        for (byte b2 : bArr) {
            j2 = (j2 << 8) | ((long) (b2 & 255));
        }
        return j2 & InternalZipConstants.f30717k;
    }

    private int[] j(int i2, int i3) {
        int i4 = 1;
        if (i2 == 15) {
            byte b2 = this.f18675c[i3 + 1];
            int i5 = (b2 & 240) >> 4;
            if (i5 != 1) {
                PrintStream printStream = System.err;
                printStream.println("BinaryPropertyListParser: Length integer has an unexpected type" + i5 + ". Attempting to parse anyway...");
            }
            int pow = (int) Math.pow(2.0d, (double) (b2 & 15));
            i4 = pow + 2;
            if (pow < 3) {
                int i6 = i3 + 2;
                i2 = (int) i(a(this.f18675c, i6, pow + i6));
            } else {
                int i7 = i3 + 2;
                i2 = new BigInteger(a(this.f18675c, i7, pow + i7)).intValue();
            }
        }
        return new int[]{i2, i4};
    }
}
