package com.itextpdf.awt.geom.misc;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {

    /* renamed from: a  reason: collision with root package name */
    private static ResourceBundle f25631a;

    public static String a(String str, Object[] objArr) {
        int i2;
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 20));
        int length = objArr.length;
        String[] strArr = new String[length];
        int i3 = 0;
        for (int i4 = 0; i4 < objArr.length; i4++) {
            Object obj = objArr[i4];
            if (obj == null) {
                strArr[i4] = "<null>";
            } else {
                strArr[i4] = obj.toString();
            }
        }
        while (true) {
            int indexOf = str.indexOf(123, i3);
            if (indexOf < 0) {
                break;
            }
            if (indexOf != 0) {
                int i5 = indexOf - 1;
                if (str.charAt(i5) == '\\') {
                    if (indexOf != 1) {
                        sb.append(str.substring(i3, i5));
                    }
                    sb.append(ASCIIPropertyListParser.f18652j);
                    i2 = indexOf + 1;
                    i3 = i2;
                }
            }
            if (indexOf > str.length() - 3) {
                sb.append(str.substring(i3, str.length()));
                i3 = str.length();
            } else {
                int i6 = indexOf + 1;
                byte digit = (byte) Character.digit(str.charAt(i6), 10);
                if (digit < 0 || str.charAt(indexOf + 2) != '}') {
                    sb.append(str.substring(i3, i6));
                    i3 = i6;
                } else {
                    sb.append(str.substring(i3, indexOf));
                    sb.append(digit >= length ? "<missing argument>" : strArr[digit]);
                    i2 = indexOf + 3;
                    i3 = i2;
                }
            }
        }
        if (i3 < str.length()) {
            sb.append(str.substring(i3, str.length()));
        }
        return sb.toString();
    }

    public static String b(String str) {
        ResourceBundle resourceBundle = f25631a;
        if (resourceBundle == null) {
            return str;
        }
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return "Missing message: " + str;
        }
    }

    public static String c(String str, char c2) {
        return g(str, new Object[]{String.valueOf(c2)});
    }

    public static String d(String str, int i2) {
        return g(str, new Object[]{Integer.toString(i2)});
    }

    public static String e(String str, Object obj) {
        return g(str, new Object[]{obj});
    }

    public static String f(String str, Object obj, Object obj2) {
        return g(str, new Object[]{obj, obj2});
    }

    public static String g(String str, Object[] objArr) {
        ResourceBundle resourceBundle = f25631a;
        if (resourceBundle != null) {
            try {
                str = resourceBundle.getString(str);
            } catch (MissingResourceException unused) {
            }
        }
        return a(str, objArr);
    }
}
