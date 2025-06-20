package com.itextpdf.text.html;

import com.itextpdf.text.BaseColor;
import com.itextpdf.tool.xml.css.CSS;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

@Deprecated
public class HtmlUtilities {

    /* renamed from: a  reason: collision with root package name */
    public static final float f25760a = 12.0f;

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, Float> f25761b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f25762c = {8, 10, 12, 14, 18, 24, 36};

    static {
        HashMap<String, Float> hashMap = new HashMap<>();
        f25761b = hashMap;
        hashMap.put(CSS.Value.Z, new Float(4.0f));
        f25761b.put(CSS.Value.a0, new Float(6.0f));
        f25761b.put("small", new Float(8.0f));
        f25761b.put("medium", new Float(10.0f));
        f25761b.put(CSS.Value.c0, new Float(13.0f));
        f25761b.put(CSS.Value.d0, new Float(18.0f));
        f25761b.put(CSS.Value.e0, new Float(26.0f));
    }

    public static int a(String str) {
        if (str == null) {
            return -1;
        }
        if ("center".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("left".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("right".equalsIgnoreCase(str)) {
            return 2;
        }
        if ("justify".equalsIgnoreCase(str)) {
            return 3;
        }
        if (HtmlTags.e0.equalsIgnoreCase(str)) {
            return 8;
        }
        if ("top".equalsIgnoreCase(str)) {
            return 4;
        }
        if (HtmlTags.g0.equalsIgnoreCase(str)) {
            return 5;
        }
        if ("bottom".equalsIgnoreCase(str)) {
            return 6;
        }
        return HtmlTags.i0.equalsIgnoreCase(str) ? 7 : -1;
    }

    public static BaseColor b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return WebColors.b(str.toLowerCase().trim());
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String c(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt != 9) {
                if (charAt != 10) {
                    if (charAt != 13) {
                        if (charAt != ' ') {
                            stringBuffer.append(charAt);
                            z = false;
                        } else if (!z) {
                            stringBuffer.append(charAt);
                        }
                    }
                } else if (i2 > 0) {
                    stringBuffer.append(' ');
                    z = true;
                }
            }
        }
        return stringBuffer.toString();
    }

    public static int d(String str, String str2) {
        int i2;
        int i3 = 0;
        if (str.startsWith("+") || str.startsWith("-")) {
            if (str2 == null) {
                str2 = "12";
            }
            int parseFloat = (int) Float.parseFloat(str2);
            int length = f25762c.length - 1;
            while (true) {
                if (length < 0) {
                    length = 0;
                    break;
                } else if (parseFloat >= f25762c[length]) {
                    break;
                } else {
                    length--;
                }
            }
            if (str.startsWith("+")) {
                str = str.substring(1);
            }
            i2 = Integer.parseInt(str) + length;
        } else {
            try {
                i2 = Integer.parseInt(str) - 1;
            } catch (NumberFormatException unused) {
                i2 = 0;
            }
        }
        if (i2 >= 0) {
            int[] iArr = f25762c;
            i3 = i2 >= iArr.length ? iArr.length - 1 : i2;
        }
        return f25762c[i3];
    }

    public static Properties e(String str) {
        Properties properties = new Properties();
        if (str == null) {
            return properties;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), ":");
            if (stringTokenizer2.hasMoreTokens()) {
                String trim = stringTokenizer2.nextToken().trim();
                if (stringTokenizer2.hasMoreTokens()) {
                    String trim2 = stringTokenizer2.nextToken().trim();
                    if (trim2.startsWith("\"")) {
                        trim2 = trim2.substring(1);
                    }
                    if (trim2.endsWith("\"")) {
                        trim2 = trim2.substring(0, trim2.length() - 1);
                    }
                    properties.setProperty(trim.toLowerCase(), trim2);
                }
            }
        }
        return properties;
    }

    public static float f(String str) {
        return g(str, 12.0f);
    }

    public static float g(String str, float f2) {
        if (str == null) {
            return 0.0f;
        }
        Float f3 = f25761b.get(str.toLowerCase());
        if (f3 != null) {
            return f3.floatValue();
        }
        int length = str.length();
        boolean z = true;
        int i2 = 0;
        while (z && i2 < length) {
            switch (str.charAt(i2)) {
                case '+':
                case '-':
                case '.':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i2++;
                    break;
                default:
                    z = false;
                    break;
            }
        }
        if (i2 == 0) {
            return 0.0f;
        }
        if (i2 == length) {
            return Float.parseFloat(str + "f");
        }
        float parseFloat = Float.parseFloat(str.substring(0, i2) + "f");
        String substring = str.substring(i2);
        if (substring.startsWith(CSS.Value.i0)) {
            return parseFloat * 72.0f;
        }
        if (substring.startsWith(CSS.Value.j0)) {
            return (parseFloat / 2.54f) * 72.0f;
        }
        if (substring.startsWith(CSS.Value.k0)) {
            return (parseFloat / 25.4f) * 72.0f;
        }
        if (substring.startsWith(CSS.Value.m0)) {
            return parseFloat * 12.0f;
        }
        if (substring.startsWith("em")) {
            return parseFloat * f2;
        }
        return substring.startsWith(CSS.Value.p0) ? (parseFloat * f2) / 2.0f : parseFloat;
    }

    public static String h(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str3.length();
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i2);
            if (indexOf > -1) {
                stringBuffer.append(str.substring(i2, indexOf));
                i2 = str.indexOf(str3, indexOf) + length;
            } else {
                stringBuffer.append(str.substring(i2));
                return stringBuffer.toString();
            }
        }
    }
}
