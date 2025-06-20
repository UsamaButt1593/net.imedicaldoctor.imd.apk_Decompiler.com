package com.itextpdf.text;

import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.pdf.PdfEncodings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import okio.Utf8;

public class Utilities {
    public static Object[][] a(Object[][] objArr, Object[] objArr2) {
        if (objArr == null) {
            return new Object[][]{objArr2};
        }
        Object[][] objArr3 = new Object[(objArr.length + 1)][];
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        objArr3[objArr.length] = objArr2;
        return objArr3;
    }

    public static boolean b(Properties properties, String str) {
        return PdfBoolean.l3.equalsIgnoreCase(properties.getProperty(str));
    }

    public static String c(int i2) {
        if (i2 < 65536) {
            return Character.toString((char) i2);
        }
        int i3 = i2 - 65536;
        return new String(new char[]{(char) ((i3 / 1024) + 55296), (char) ((i3 % 1024) + Utf8.f31408e)});
    }

    public static String d(byte[] bArr) {
        ByteBuffer byteBuffer = new ByteBuffer();
        for (byte q : bArr) {
            byteBuffer.q(q);
        }
        return PdfEncodings.d(byteBuffer.F(), (String) null).toUpperCase();
    }

    public static int e(char c2, char c3) {
        return ((c2 - 55296) * 1024) + c3 + 9216;
    }

    public static int f(String str, int i2) {
        return ((str.charAt(i2) - 55296) * 1024) + str.charAt(i2 + 1) + 9216;
    }

    public static int g(char[] cArr, int i2) {
        return ((cArr[i2] - 55296) * 1024) + cArr[i2 + 1] + 9216;
    }

    public static char[] h(char[] cArr, int i2, int i3) {
        int i4 = i3 - i2;
        if (i4 >= 0) {
            char[] cArr2 = new char[i4];
            System.arraycopy(cArr, i2, cArr2, 0, Math.min(cArr.length - i2, i4));
            return cArr2;
        }
        throw new IllegalArgumentException(i2 + " > " + i3);
    }

    @Deprecated
    public static <K, V> Set<K> i(Hashtable<K, V> hashtable) {
        return hashtable == null ? Collections.emptySet() : hashtable.keySet();
    }

    public static final float j(float f2) {
        return f2 * 25.4f;
    }

    public static final float k(float f2) {
        return f2 * 72.0f;
    }

    public static boolean l(char c2) {
        return c2 >= 55296 && c2 <= 56319;
    }

    public static boolean m(char c2) {
        return c2 >= 56320 && c2 <= 57343;
    }

    public static boolean n(String str, int i2) {
        return i2 >= 0 && i2 <= str.length() + -2 && l(str.charAt(i2)) && m(str.charAt(i2 + 1));
    }

    public static boolean o(char[] cArr, int i2) {
        return i2 >= 0 && i2 <= cArr.length + -2 && l(cArr[i2]) && m(cArr[i2 + 1]);
    }

    public static final float p(float f2) {
        return f2 / 25.4f;
    }

    public static final float q(float f2) {
        return k(p(f2));
    }

    public static final float r(float f2) {
        return f2 / 72.0f;
    }

    public static final float s(float f2) {
        return j(r(f2));
    }

    public static String t(File file) throws IOException {
        byte[] bArr = new byte[((int) file.length())];
        new FileInputStream(file).read(bArr);
        return new String(bArr);
    }

    public static String u(String str) throws IOException {
        return t(new File(str));
    }

    public static void v(InputStream inputStream, int i2) throws IOException {
        while (i2 > 0) {
            long j2 = (long) i2;
            long skip = inputStream.skip(j2);
            if (skip > 0) {
                i2 = (int) (j2 - skip);
            } else {
                return;
            }
        }
    }

    public static URL w(String str) throws MalformedURLException {
        try {
            return new URL(str);
        } catch (Exception unused) {
            return new File(str).toURI().toURL();
        }
    }

    public static String x(String str) {
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        int i3 = 0;
        while (i3 < charArray.length) {
            char c2 = charArray[i3];
            if (c2 == '%' && (i2 = i3 + 2) < charArray.length) {
                int j2 = PRTokeniser.j(charArray[i3 + 1]);
                int j3 = PRTokeniser.j(charArray[i2]);
                if (j2 >= 0 && j3 >= 0) {
                    stringBuffer.append((char) ((j2 * 16) + j3));
                    i3 = i2;
                    i3++;
                }
            }
            stringBuffer.append(c2);
            i3++;
        }
        return stringBuffer.toString();
    }
}
