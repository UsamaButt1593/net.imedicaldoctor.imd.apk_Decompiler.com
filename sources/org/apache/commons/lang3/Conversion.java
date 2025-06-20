package org.apache.commons.lang3;

import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.UUID;
import kotlin.UShort;
import net.lingala.zip4j.util.InternalZipConstants;

public class Conversion {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr) {
        return binaryBeMsb0ToHexDigit(zArr, 0);
    }

    public static byte binaryToByte(boolean[] zArr, int i2, byte b2, int i3, int i4) {
        if ((zArr.length == 0 && i2 == 0) || i4 == 0) {
            return b2;
        }
        if ((i4 - 1) + i3 < 8) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 + i3;
                b2 = (byte) ((b2 & (~(1 << i6))) | ((zArr[i5 + i2] ? 1 : 0) << i6));
            }
            return b2;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 8");
    }

    public static char binaryToHexDigit(boolean[] zArr) {
        return binaryToHexDigit(zArr, 0);
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr) {
        return binaryToHexDigitMsb0_4bits(zArr, 0);
    }

    public static int binaryToInt(boolean[] zArr, int i2, int i3, int i4, int i5) {
        if ((zArr.length == 0 && i2 == 0) || i5 == 0) {
            return i3;
        }
        if ((i5 - 1) + i4 < 32) {
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 + i4;
                i3 = (i3 & (~(1 << i7))) | ((zArr[i6 + i2] ? 1 : 0) << i7);
            }
            return i3;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 32");
    }

    public static long binaryToLong(boolean[] zArr, int i2, long j2, int i3, int i4) {
        if ((zArr.length == 0 && i2 == 0) || i4 == 0) {
            return j2;
        }
        if ((i4 - 1) + i3 < 64) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 + i3;
                j2 = (j2 & (~(1 << i6))) | ((zArr[i5 + i2] ? 1 : 0) << i6);
            }
            return j2;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 64");
    }

    public static short binaryToShort(boolean[] zArr, int i2, short s, int i3, int i4) {
        if ((zArr.length == 0 && i2 == 0) || i4 == 0) {
            return s;
        }
        if ((i4 - 1) + i3 < 16) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 + i3;
                s = (short) ((s & (~(1 << i6))) | ((zArr[i5 + i2] ? 1 : 0) << i6));
            }
            return s;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 16");
    }

    public static int byteArrayToInt(byte[] bArr, int i2, int i3, int i4, int i5) {
        if ((bArr.length == 0 && i2 == 0) || i5 == 0) {
            return i3;
        }
        if (((i5 - 1) * 8) + i4 < 32) {
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = (i6 * 8) + i4;
                i3 = (i3 & (~(255 << i7))) | ((bArr[i6 + i2] & 255) << i7);
            }
            return i3;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 32");
    }

    public static long byteArrayToLong(byte[] bArr, int i2, long j2, int i3, int i4) {
        if ((bArr.length == 0 && i2 == 0) || i4 == 0) {
            return j2;
        }
        if (((i4 - 1) * 8) + i3 < 64) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i5 * 8) + i3;
                j2 = (j2 & (~(255 << i6))) | ((((long) bArr[i5 + i2]) & 255) << i6);
            }
            return j2;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 64");
    }

    public static short byteArrayToShort(byte[] bArr, int i2, short s, int i3, int i4) {
        if ((bArr.length == 0 && i2 == 0) || i4 == 0) {
            return s;
        }
        if (((i4 - 1) * 8) + i3 < 16) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i5 * 8) + i3;
                s = (short) ((s & (~(255 << i6))) | ((bArr[i5 + i2] & 255) << i6));
            }
            return s;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 16");
    }

    public static UUID byteArrayToUuid(byte[] bArr, int i2) {
        if (bArr.length - i2 >= 16) {
            return new UUID(byteArrayToLong(bArr, i2, 0, 0, 8), byteArrayToLong(bArr, i2 + 8, 0, 0, 8));
        }
        throw new IllegalArgumentException("Need at least 16 bytes for UUID");
    }

    public static boolean[] byteToBinary(byte b2, int i2, boolean[] zArr, int i3, int i4) {
        if (i4 == 0) {
            return zArr;
        }
        if ((i4 - 1) + i2 < 8) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i3 + i5;
                boolean z = true;
                if (((b2 >> (i5 + i2)) & 1) == 0) {
                    z = false;
                }
                zArr[i6] = z;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 8");
    }

    public static String byteToHex(byte b2, int i2, String str, int i3, int i4) {
        if (i4 == 0) {
            return str;
        }
        if (((i4 - 1) * 4) + i2 < 8) {
            StringBuilder sb = new StringBuilder(str);
            int length = sb.length();
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (b2 >> ((i5 * 4) + i2)) & 15;
                int i7 = i3 + i5;
                if (i7 == length) {
                    length++;
                    sb.append(intToHexDigit(i6));
                } else {
                    sb.setCharAt(i7, intToHexDigit(i6));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 8");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        return new boolean[]{true, true, false, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        return new boolean[]{true, true, false, false};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        return new boolean[]{true, false, true, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        return new boolean[]{true, false, true, false};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        return new boolean[]{true, true, true, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        return new boolean[]{true, true, true, false};
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean[] hexDigitMsb0ToBinary(char r3) {
        /*
            r0 = 4
            switch(r3) {
                case 48: goto L_0x0080;
                case 49: goto L_0x007a;
                case 50: goto L_0x0074;
                case 51: goto L_0x006e;
                case 52: goto L_0x0068;
                case 53: goto L_0x0062;
                case 54: goto L_0x005c;
                case 55: goto L_0x0056;
                case 56: goto L_0x0050;
                case 57: goto L_0x004a;
                default: goto L_0x0004;
            }
        L_0x0004:
            switch(r3) {
                case 65: goto L_0x0044;
                case 66: goto L_0x003e;
                case 67: goto L_0x0038;
                case 68: goto L_0x0032;
                case 69: goto L_0x002c;
                case 70: goto L_0x0026;
                default: goto L_0x0007;
            }
        L_0x0007:
            switch(r3) {
                case 97: goto L_0x0044;
                case 98: goto L_0x003e;
                case 99: goto L_0x0038;
                case 100: goto L_0x0032;
                case 101: goto L_0x002c;
                case 102: goto L_0x0026;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret '"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = "' as a hexadecimal digit"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x0026:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 1, 1} // fill-array
            return r3
        L_0x002c:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 1, 0} // fill-array
            return r3
        L_0x0032:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 0, 1} // fill-array
            return r3
        L_0x0038:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 0, 0} // fill-array
            return r3
        L_0x003e:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 1, 1} // fill-array
            return r3
        L_0x0044:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 1, 0} // fill-array
            return r3
        L_0x004a:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 0, 1} // fill-array
            return r3
        L_0x0050:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 0, 0} // fill-array
            return r3
        L_0x0056:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 1, 1} // fill-array
            return r3
        L_0x005c:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 1, 0} // fill-array
            return r3
        L_0x0062:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 0, 1} // fill-array
            return r3
        L_0x0068:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 0, 0} // fill-array
            return r3
        L_0x006e:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 1, 1} // fill-array
            return r3
        L_0x0074:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 1, 0} // fill-array
            return r3
        L_0x007a:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 0, 1} // fill-array
            return r3
        L_0x0080:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 0, 0} // fill-array
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.Conversion.hexDigitMsb0ToBinary(char):boolean[]");
    }

    public static int hexDigitMsb0ToInt(char c2) {
        switch (c2) {
            case '0':
                return 0;
            case '1':
                return 8;
            case '2':
                return 4;
            case '3':
                return 12;
            case '4':
                return 2;
            case '5':
                return 10;
            case '6':
                return 6;
            case '7':
                return 14;
            case '8':
                return 1;
            case '9':
                return 9;
            default:
                switch (c2) {
                    case 'A':
                        return 5;
                    case 'B':
                        return 13;
                    case 'C':
                        return 3;
                    case 'D':
                        return 11;
                    case 'E':
                        return 7;
                    case 'F':
                        return 15;
                    default:
                        switch (c2) {
                            case 'a':
                                return 5;
                            case 'b':
                                return 13;
                            case 'c':
                                return 3;
                            case 'd':
                                return 11;
                            case 'e':
                                return 7;
                            case 'f':
                                return 15;
                            default:
                                throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
                        }
                }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        return new boolean[]{true, false, true, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        return new boolean[]{false, false, true, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        return new boolean[]{true, true, false, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        return new boolean[]{false, true, false, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        return new boolean[]{true, true, true, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        return new boolean[]{false, true, true, true};
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean[] hexDigitToBinary(char r3) {
        /*
            r0 = 4
            switch(r3) {
                case 48: goto L_0x0080;
                case 49: goto L_0x007a;
                case 50: goto L_0x0074;
                case 51: goto L_0x006e;
                case 52: goto L_0x0068;
                case 53: goto L_0x0062;
                case 54: goto L_0x005c;
                case 55: goto L_0x0056;
                case 56: goto L_0x0050;
                case 57: goto L_0x004a;
                default: goto L_0x0004;
            }
        L_0x0004:
            switch(r3) {
                case 65: goto L_0x0044;
                case 66: goto L_0x003e;
                case 67: goto L_0x0038;
                case 68: goto L_0x0032;
                case 69: goto L_0x002c;
                case 70: goto L_0x0026;
                default: goto L_0x0007;
            }
        L_0x0007:
            switch(r3) {
                case 97: goto L_0x0044;
                case 98: goto L_0x003e;
                case 99: goto L_0x0038;
                case 100: goto L_0x0032;
                case 101: goto L_0x002c;
                case 102: goto L_0x0026;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret '"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = "' as a hexadecimal digit"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x0026:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 1, 1} // fill-array
            return r3
        L_0x002c:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 1, 1} // fill-array
            return r3
        L_0x0032:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 1, 1} // fill-array
            return r3
        L_0x0038:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 1, 1} // fill-array
            return r3
        L_0x003e:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 0, 1} // fill-array
            return r3
        L_0x0044:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 0, 1} // fill-array
            return r3
        L_0x004a:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 0, 1} // fill-array
            return r3
        L_0x0050:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 0, 1} // fill-array
            return r3
        L_0x0056:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 1, 0} // fill-array
            return r3
        L_0x005c:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 1, 0} // fill-array
            return r3
        L_0x0062:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 1, 0} // fill-array
            return r3
        L_0x0068:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 1, 0} // fill-array
            return r3
        L_0x006e:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 0, 0} // fill-array
            return r3
        L_0x0074:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 0, 0} // fill-array
            return r3
        L_0x007a:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 0, 0} // fill-array
            return r3
        L_0x0080:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 0, 0} // fill-array
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.Conversion.hexDigitToBinary(char):boolean[]");
    }

    public static int hexDigitToInt(char c2) {
        int digit = Character.digit(c2, 16);
        if (digit >= 0) {
            return digit;
        }
        throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
    }

    public static byte hexToByte(String str, int i2, byte b2, int i3, int i4) {
        if (i4 == 0) {
            return b2;
        }
        if (((i4 - 1) * 4) + i3 < 8) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i5 * 4) + i3;
                b2 = (byte) ((b2 & (~(15 << i6))) | ((hexDigitToInt(str.charAt(i5 + i2)) & 15) << i6));
            }
            return b2;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 8");
    }

    public static int hexToInt(String str, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return i3;
        }
        if (((i5 - 1) * 4) + i4 < 32) {
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = (i6 * 4) + i4;
                i3 = (i3 & (~(15 << i7))) | ((hexDigitToInt(str.charAt(i6 + i2)) & 15) << i7);
            }
            return i3;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 32");
    }

    public static long hexToLong(String str, int i2, long j2, int i3, int i4) {
        if (i4 == 0) {
            return j2;
        }
        if (((i4 - 1) * 4) + i3 < 64) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i5 * 4) + i3;
                j2 = (j2 & (~(15 << i6))) | ((((long) hexDigitToInt(str.charAt(i5 + i2))) & 15) << i6);
            }
            return j2;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 64");
    }

    public static short hexToShort(String str, int i2, short s, int i3, int i4) {
        if (i4 == 0) {
            return s;
        }
        if (((i4 - 1) * 4) + i3 < 16) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i5 * 4) + i3;
                s = (short) ((s & (~(15 << i6))) | ((hexDigitToInt(str.charAt(i5 + i2)) & 15) << i6));
            }
            return s;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 16");
    }

    public static long intArrayToLong(int[] iArr, int i2, long j2, int i3, int i4) {
        if ((iArr.length == 0 && i2 == 0) || i4 == 0) {
            return j2;
        }
        if (((i4 - 1) * 32) + i3 < 64) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i5 * 32) + i3;
                j2 = (j2 & (~(InternalZipConstants.f30717k << i6))) | ((((long) iArr[i5 + i2]) & InternalZipConstants.f30717k) << i6);
            }
            return j2;
        }
        throw new IllegalArgumentException("(nInts-1)*32+dstPos is greather or equal to than 64");
    }

    public static boolean[] intToBinary(int i2, int i3, boolean[] zArr, int i4, int i5) {
        if (i5 == 0) {
            return zArr;
        }
        if ((i5 - 1) + i3 < 32) {
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i4 + i6;
                boolean z = true;
                if (((i2 >> (i6 + i3)) & 1) == 0) {
                    z = false;
                }
                zArr[i7] = z;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 32");
    }

    public static byte[] intToByteArray(int i2, int i3, byte[] bArr, int i4, int i5) {
        if (i5 == 0) {
            return bArr;
        }
        if (((i5 - 1) * 8) + i3 < 32) {
            for (int i6 = 0; i6 < i5; i6++) {
                bArr[i4 + i6] = (byte) ((i2 >> ((i6 * 8) + i3)) & 255);
            }
            return bArr;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 32");
    }

    public static String intToHex(int i2, int i3, String str, int i4, int i5) {
        if (i5 == 0) {
            return str;
        }
        if (((i5 - 1) * 4) + i3 < 32) {
            StringBuilder sb = new StringBuilder(str);
            int length = sb.length();
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = (i2 >> ((i6 * 4) + i3)) & 15;
                int i8 = i4 + i6;
                if (i8 == length) {
                    length++;
                    sb.append(intToHexDigit(i7));
                } else {
                    sb.setCharAt(i8, intToHexDigit(i7));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 32");
    }

    public static char intToHexDigit(int i2) {
        char forDigit = Character.forDigit(i2, 16);
        if (forDigit != 0) {
            return forDigit;
        }
        throw new IllegalArgumentException("nibble value not between 0 and 15: " + i2);
    }

    public static char intToHexDigitMsb0(int i2) {
        switch (i2) {
            case 0:
                return '0';
            case 1:
                return '8';
            case 2:
                return PdfWriter.r4;
            case 3:
                return Barcode128.F;
            case 4:
                return PdfWriter.p4;
            case 5:
                return 'a';
            case 6:
                return PdfWriter.t4;
            case 7:
                return Barcode128.H;
            case 8:
                return '1';
            case 9:
                return '9';
            case 10:
                return PdfWriter.s4;
            case 11:
                return Barcode128.G;
            case 12:
                return PdfWriter.q4;
            case 13:
                return 'b';
            case 14:
                return PdfWriter.u4;
            case 15:
                return Barcode128.I;
            default:
                throw new IllegalArgumentException("nibble value not between 0 and 15: " + i2);
        }
    }

    public static short[] intToShortArray(int i2, int i3, short[] sArr, int i4, int i5) {
        if (i5 == 0) {
            return sArr;
        }
        if (((i5 - 1) * 16) + i3 < 32) {
            for (int i6 = 0; i6 < i5; i6++) {
                sArr[i4 + i6] = (short) ((i2 >> ((i6 * 16) + i3)) & 65535);
            }
            return sArr;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 32");
    }

    public static boolean[] longToBinary(long j2, int i2, boolean[] zArr, int i3, int i4) {
        if (i4 == 0) {
            return zArr;
        }
        if ((i4 - 1) + i2 < 64) {
            for (int i5 = 0; i5 < i4; i5++) {
                zArr[i3 + i5] = (1 & (j2 >> (i5 + i2))) != 0;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 64");
    }

    public static byte[] longToByteArray(long j2, int i2, byte[] bArr, int i3, int i4) {
        if (i4 == 0) {
            return bArr;
        }
        if (((i4 - 1) * 8) + i2 < 64) {
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i3 + i5] = (byte) ((int) (255 & (j2 >> ((i5 * 8) + i2))));
            }
            return bArr;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 64");
    }

    public static String longToHex(long j2, int i2, String str, int i3, int i4) {
        if (i4 == 0) {
            return str;
        }
        if (((i4 - 1) * 4) + i2 < 64) {
            StringBuilder sb = new StringBuilder(str);
            int length = sb.length();
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (int) ((j2 >> ((i5 * 4) + i2)) & 15);
                int i7 = i3 + i5;
                if (i7 == length) {
                    length++;
                    sb.append(intToHexDigit(i6));
                } else {
                    sb.setCharAt(i7, intToHexDigit(i6));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 64");
    }

    public static int[] longToIntArray(long j2, int i2, int[] iArr, int i3, int i4) {
        if (i4 == 0) {
            return iArr;
        }
        if (((i4 - 1) * 32) + i2 < 64) {
            for (int i5 = 0; i5 < i4; i5++) {
                iArr[i3 + i5] = (int) (j2 >> ((i5 * 32) + i2));
            }
            return iArr;
        }
        throw new IllegalArgumentException("(nInts-1)*32+srcPos is greather or equal to than 64");
    }

    public static short[] longToShortArray(long j2, int i2, short[] sArr, int i3, int i4) {
        if (i4 == 0) {
            return sArr;
        }
        if (((i4 - 1) * 16) + i2 < 64) {
            for (int i5 = 0; i5 < i4; i5++) {
                sArr[i3 + i5] = (short) ((int) (65535 & (j2 >> ((i5 * 16) + i2))));
            }
            return sArr;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 64");
    }

    public static int shortArrayToInt(short[] sArr, int i2, int i3, int i4, int i5) {
        if ((sArr.length == 0 && i2 == 0) || i5 == 0) {
            return i3;
        }
        if (((i5 - 1) * 16) + i4 < 32) {
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = (i6 * 16) + i4;
                i3 = (i3 & (~(65535 << i7))) | ((sArr[i6 + i2] & UShort.Z) << i7);
            }
            return i3;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 32");
    }

    public static long shortArrayToLong(short[] sArr, int i2, long j2, int i3, int i4) {
        if ((sArr.length == 0 && i2 == 0) || i4 == 0) {
            return j2;
        }
        if (((i4 - 1) * 16) + i3 < 64) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (i5 * 16) + i3;
                j2 = (j2 & (~(65535 << i6))) | ((((long) sArr[i5 + i2]) & 65535) << i6);
            }
            return j2;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 64");
    }

    public static boolean[] shortToBinary(short s, int i2, boolean[] zArr, int i3, int i4) {
        if (i4 == 0) {
            return zArr;
        }
        if ((i4 - 1) + i2 < 16) {
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i3 + i5;
                boolean z = true;
                if (((s >> (i5 + i2)) & 1) == 0) {
                    z = false;
                }
                zArr[i6] = z;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 16");
    }

    public static byte[] shortToByteArray(short s, int i2, byte[] bArr, int i3, int i4) {
        if (i4 == 0) {
            return bArr;
        }
        if (((i4 - 1) * 8) + i2 < 16) {
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i3 + i5] = (byte) ((s >> ((i5 * 8) + i2)) & 255);
            }
            return bArr;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 16");
    }

    public static String shortToHex(short s, int i2, String str, int i3, int i4) {
        if (i4 == 0) {
            return str;
        }
        if (((i4 - 1) * 4) + i2 < 16) {
            StringBuilder sb = new StringBuilder(str);
            int length = sb.length();
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = (s >> ((i5 * 4) + i2)) & 15;
                int i7 = i3 + i5;
                if (i7 == length) {
                    length++;
                    sb.append(intToHexDigit(i6));
                } else {
                    sb.setCharAt(i7, intToHexDigit(i6));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 16");
    }

    public static byte[] uuidToByteArray(UUID uuid, byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return bArr;
        }
        if (i3 <= 16) {
            longToByteArray(uuid.getMostSignificantBits(), 0, bArr, i2, i3 > 8 ? 8 : i3);
            if (i3 >= 8) {
                longToByteArray(uuid.getLeastSignificantBits(), 0, bArr, i2 + 8, i3 - 8);
            }
            return bArr;
        }
        throw new IllegalArgumentException("nBytes is greather than 16");
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr, int i2) {
        if (zArr.length != 0) {
            int length = ((zArr.length - 1) - i2) + 1;
            int min = Math.min(4, length);
            boolean[] zArr2 = new boolean[4];
            System.arraycopy(zArr, length - min, zArr2, 4 - min, min);
            return zArr2[0] ? zArr2[1] ? zArr2[2] ? zArr2[3] ? Barcode128.I : Barcode128.H : zArr2[3] ? Barcode128.G : Barcode128.F : zArr2[2] ? zArr2[3] ? 'b' : 'a' : zArr2[3] ? '9' : '8' : zArr2[1] ? zArr2[2] ? zArr2[3] ? PdfWriter.u4 : PdfWriter.t4 : zArr2[3] ? PdfWriter.s4 : PdfWriter.r4 : zArr2[2] ? zArr2[3] ? PdfWriter.q4 : PdfWriter.p4 : zArr2[3] ? '1' : '0';
        }
        throw new IllegalArgumentException("Cannot convert an empty array.");
    }

    public static char binaryToHexDigit(boolean[] zArr, int i2) {
        if (zArr.length != 0) {
            int i3 = i2 + 3;
            if (zArr.length <= i3 || !zArr[i3]) {
                int i4 = i2 + 2;
                if (zArr.length <= i4 || !zArr[i4]) {
                    int i5 = i2 + 1;
                    return (zArr.length <= i5 || !zArr[i5]) ? zArr[i2] ? '1' : '0' : zArr[i2] ? PdfWriter.q4 : PdfWriter.p4;
                }
                int i6 = i2 + 1;
                return (zArr.length <= i6 || !zArr[i6]) ? zArr[i2] ? PdfWriter.s4 : PdfWriter.r4 : zArr[i2] ? PdfWriter.u4 : PdfWriter.t4;
            }
            int i7 = i2 + 2;
            if (zArr.length <= i7 || !zArr[i7]) {
                int i8 = i2 + 1;
                return (zArr.length <= i8 || !zArr[i8]) ? zArr[i2] ? '9' : '8' : zArr[i2] ? 'b' : 'a';
            }
            int i9 = i2 + 1;
            return (zArr.length <= i9 || !zArr[i9]) ? zArr[i2] ? Barcode128.G : Barcode128.F : zArr[i2] ? Barcode128.I : Barcode128.H;
        }
        throw new IllegalArgumentException("Cannot convert an empty array.");
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr, int i2) {
        if (zArr.length > 8) {
            throw new IllegalArgumentException("src.length>8: src.length=" + zArr.length);
        } else if (zArr.length - i2 < 4) {
            throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + zArr.length + ", srcPos=" + i2);
        } else if (zArr[i2 + 3]) {
            if (!zArr[i2 + 2]) {
                return zArr[i2 + 1] ? zArr[i2] ? Barcode128.G : PdfWriter.s4 : zArr[i2] ? '9' : '1';
            }
            if (zArr[i2 + 1]) {
                return zArr[i2] ? Barcode128.I : PdfWriter.u4;
            }
            if (zArr[i2]) {
                return 'b';
            }
            return PdfWriter.q4;
        } else if (!zArr[i2 + 2]) {
            return zArr[i2 + 1] ? zArr[i2] ? Barcode128.F : PdfWriter.r4 : zArr[i2] ? '8' : '0';
        } else {
            if (zArr[i2 + 1]) {
                return zArr[i2] ? Barcode128.H : PdfWriter.t4;
            }
            if (zArr[i2]) {
                return 'a';
            }
            return PdfWriter.p4;
        }
    }
}
