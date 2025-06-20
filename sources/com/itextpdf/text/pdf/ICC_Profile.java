package com.itextpdf.text.pdf;

import com.google.common.base.Ascii;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class ICC_Profile {

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, Integer> f26071c;

    /* renamed from: a  reason: collision with root package name */
    protected byte[] f26072a;

    /* renamed from: b  reason: collision with root package name */
    protected int f26073b;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f26071c = hashMap;
        hashMap.put("XYZ ", 3);
        f26071c.put("Lab ", 3);
        f26071c.put("Luv ", 3);
        f26071c.put("YCbr", 3);
        f26071c.put("Yxy ", 3);
        f26071c.put("RGB ", 3);
        f26071c.put("GRAY", 1);
        f26071c.put("HSV ", 3);
        f26071c.put("HLS ", 3);
        f26071c.put("CMYK", 4);
        f26071c.put("CMY ", 3);
        f26071c.put("2CLR", 2);
        f26071c.put("3CLR", 3);
        f26071c.put("4CLR", 4);
        f26071c.put("5CLR", 5);
        f26071c.put("6CLR", 6);
        f26071c.put("7CLR", 7);
        f26071c.put("8CLR", 8);
        f26071c.put("9CLR", 9);
        f26071c.put("ACLR", 10);
        f26071c.put("BCLR", 11);
        f26071c.put("CCLR", 12);
        f26071c.put("DCLR", 13);
        f26071c.put("ECLR", 14);
        f26071c.put("FCLR", 15);
    }

    protected ICC_Profile() {
    }

    public static ICC_Profile a(String str) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                ICC_Profile c2 = c(fileInputStream2);
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
                return c2;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                try {
                    throw new ExceptionConverter(e);
                } catch (Throwable th) {
                    th = th;
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                fileInputStream.close();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            throw new ExceptionConverter(e);
        }
    }

    public static ICC_Profile c(InputStream inputStream) {
        int i2 = 128;
        try {
            byte[] bArr = new byte[128];
            int i3 = 128;
            int i4 = 0;
            while (i3 > 0) {
                int read = inputStream.read(bArr, i4, i3);
                if (read >= 0) {
                    i3 -= read;
                    i4 += read;
                } else {
                    throw new IllegalArgumentException(MessageLocalization.b("invalid.icc.profile", new Object[0]));
                }
            }
            if (bArr[36] == 97 && bArr[37] == 99 && bArr[38] == 115 && bArr[39] == 112) {
                int i5 = ((bArr[0] & 255) << Ascii.B) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                byte[] bArr2 = new byte[i5];
                System.arraycopy(bArr, 0, bArr2, 0, 128);
                int i6 = i5 - 128;
                while (i6 > 0) {
                    int read2 = inputStream.read(bArr2, i2, i6);
                    if (read2 >= 0) {
                        i6 -= read2;
                        i2 += read2;
                    } else {
                        throw new IllegalArgumentException(MessageLocalization.b("invalid.icc.profile", new Object[0]));
                    }
                }
                return d(bArr2);
            }
            throw new IllegalArgumentException(MessageLocalization.b("invalid.icc.profile", new Object[0]));
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static ICC_Profile d(byte[] bArr) {
        try {
            Integer num = f26071c.get(new String(bArr, 16, 4, "US-ASCII"));
            return e(bArr, num == null ? 0 : num.intValue());
        } catch (UnsupportedEncodingException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static ICC_Profile e(byte[] bArr, int i2) {
        int i3 = 0;
        if (bArr.length >= 128 && bArr[36] == 97 && bArr[37] == 99 && bArr[38] == 115 && bArr[39] == 112) {
            try {
                ICC_Profile iCC_Profile = new ICC_Profile();
                iCC_Profile.f26072a = bArr;
                Integer num = f26071c.get(new String(bArr, 16, 4, "US-ASCII"));
                if (num != null) {
                    i3 = num.intValue();
                }
                iCC_Profile.f26073b = i3;
                if (i3 == i2) {
                    return iCC_Profile;
                }
                throw new IllegalArgumentException("ICC profile contains " + i3 + " component(s), the image data contains " + i2 + " component(s)");
            } catch (UnsupportedEncodingException e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            throw new IllegalArgumentException(MessageLocalization.b("invalid.icc.profile", new Object[0]));
        }
    }

    public byte[] b() {
        return this.f26072a;
    }

    public int f() {
        return this.f26073b;
    }
}
