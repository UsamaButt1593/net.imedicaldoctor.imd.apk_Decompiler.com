package net.lingala.zip4j.crypto.PBKDF2;

class BinTools {

    /* renamed from: a  reason: collision with root package name */
    public static final String f30545a = "0123456789ABCDEF";

    BinTools() {
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            int i2 = (b2 + 256) % 256;
            stringBuffer.append(f30545a.charAt((i2 / 16) & 15));
            stringBuffer.append(f30545a.charAt((i2 % 16) & 15));
        }
        return stringBuffer.toString();
    }

    public static int b(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'A' && c2 <= 'F') {
            return c2 - '7';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - 'W';
        }
        throw new IllegalArgumentException("Input string may only contain hex digits, but found '" + c2 + "'");
    }

    public static byte[] c(String str) {
        if (str == null) {
            str = "";
        } else if (str.length() % 2 != 0) {
            str = "0" + str;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int i4 = i2 + 1;
            char charAt = str.charAt(i2);
            i2 += 2;
            bArr[i3] = (byte) ((b(charAt) * 16) + b(str.charAt(i4)));
            i3++;
        }
        return bArr;
    }
}
